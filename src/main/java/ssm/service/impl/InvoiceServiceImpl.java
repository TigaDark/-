package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.*;
import ssm.domain.*;
import ssm.service.InvoiceService;

import java.util.Date;
import java.util.List;
@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private GoodsQuantityDao goodsQuantityDao;
    @Autowired
    private ContrcatDao contrcatDao;
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private LogisticsDao logisticsDao;

    @Override
    public List<Invoice> findInvoiceByInfo(SelectInfo selectInfo) {
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        List<Invoice> invoiceList= invoiceDao.findInvoiceByInfo(selectInfo.getQuery());
        return invoiceList;
    }

    @Override
    public void confirmSent(Invoice invoice) throws Exception {
        int flag=1; //表示合同完成
        System.out.println(invoice);
        // 找到purchase_Goods 里面的采购订单id并把goodstatus设置为2 表示该商品发货完成
        goodsQuantityDao.editgoodsstatusByid(invoice.getGoodsQuantity().getId(),2);

        // 然后 在purchase_Goods 找到该purchaseid 在在purchase_Goods里面遍历 所有pruchaseid的  goodstatus
        int purchaseid = purchaseDao.findPurchaseByGoodsQuantityId(invoice.getGoodsQuantity().getId());
        List<GoodsQuantity> goodsQuantityList=goodsQuantityDao.findGoodsQuantityByPurchaseId(purchaseid);
        System.out.println(goodsQuantityList);
        //  如果都发货完成(即都为2) 那么表示该采购清单已完成 该合同完成
        for (GoodsQuantity goodsQuantity:goodsQuantityList){
            if (goodsQuantity.getGoodstatus()!=2)
                //表示该合同未完成
                flag=0;
        }
        //若合同完成   根据purchaseid 找到contract 设置合同为 已完成状态 同时设置完成时间
        if (flag==1){
            contrcatDao.editContractEndProgressByPurchaseId(purchaseid,2,new Date());
        }

        //Invoice 里的issent改为 1 表示已发货
        invoiceDao.editissentById(invoice.getId(),1);

        //添加物流信息 也要在中间表关联 注意主键回填
        Logistics logistics=new Logistics(new Date(),"商品正飞速发往："+invoice.getCustomer().getAddress());
        logisticsDao.addLogistics(logistics);
        logisticsDao.addLogisticsByInvoiceId(logistics.getId(),invoice.getId());
    }
}
