package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.*;
import ssm.domain.*;
import ssm.domain.Pojo.SelectInfo;
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
    private CustomerDao customerDao;
    @Autowired
    private LogisticsDao logisticsDao;
    @Autowired
    private OrdersGoodDao ordersGoodDao;
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Invoice> findInvoiceByInfo(SelectInfo selectInfo) {
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        List<Invoice> invoiceList= invoiceDao.findInvoiceByInfo(selectInfo.getQuery());
        return invoiceList;
    }

    @Override
    public void confirmSent(int invoiceid,Logistics alogistics) throws Exception {
        int ordersflag=1; //表示短期合同清单完成
        //将invoice issent 状态改为1 表示发货完成
        invoiceDao.editissentById(invoiceid,1);
        //通过invoice 找到 customer信息
        int customerid = invoiceDao.findCustomeridByid(invoiceid);
        Customer customer = customerDao.findCustomerById(customerid);
        //添加物流信息 也要在中间表关联 注意主键回填  //物流单号是strid
        Logistics logistics1= new Logistics(new Date(),"商品已交付:"+alogistics.getCompany());
        Logistics logistics2=new Logistics(new Date(),"商品正从: "+alogistics.getStart_place()+" 飞速发往："+ customer.getAddress());
        logisticsDao.addLogistics(logistics1);
        logisticsDao.addLogistics(logistics2);
        logisticsDao.addLogisticsByInvoiceId(logistics1.getId(),invoiceid);
        logisticsDao.addLogisticsByInvoiceId(logistics2.getId(),invoiceid);

        //通过invoice 的oredersgoodid 将其goodstatus改为发货完成2
        Invoice invoice=invoiceDao.findInvoiceByid(invoiceid);
        ordersGoodDao.editordersGoodstatus(invoice.getOrdersGood().getId(),2);

        //遍历orders_goods中所有ordersid的goodstatus 若完成则在orders表里面置progress为1 表示该合同清单完成
        int ordersid = ordersGoodDao.findOrdersIdByid(invoice.getOrdersGood().getId());
        List<OrdersGood> ordersGoods = ordersGoodDao.findOrdersGoodByordersId(ordersid);
        //  如果都发货完成(即都为2) 那么表示该清单已完成
        for (OrdersGood ordersGoodss:ordersGoods){
            if (ordersGoodss.getGoodstatus()!=2)
                ordersflag=0;
        }
        if(ordersflag==1){
            ordersDao.editProgressByid(ordersid,1);
        }

        //判断合同是否完成
        //找到contrcatid 然后找到所有 ordersid progress是否都为 1 如果是置contractflag1=1
        //通过contrcatid 找到purchase 查看是不是所有商品的剩余数量都是0 要是都是0 置 contractflag2=1
        //2个都是1 表示合同完成
        int contractflag1=1;
        int contractflag2=1;
        Contract contract = contrcatDao.findContractByOrdersId(ordersid);
        List<Orders> ordersList = ordersDao.findOrdersByContractId(contract.getId());
        for (Orders order:ordersList){
            if (order.getProgress()!=1)
                contractflag1=0;
        }

        for (GoodsQuantity goodsQuantity:contract.getPurchase().getGoodsQuantityList()){
            if (goodsQuantity.getSurplus()!=0)
                contractflag2=0;
        }
        if(contractflag1==1 && contractflag2==1){
            //合同完成
            contrcatDao.editContractProcessByContractid(contract.getId(),2,new Date());
        }
    }
}
