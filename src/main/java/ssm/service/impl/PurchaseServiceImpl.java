package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.*;
import ssm.domain.*;
import ssm.service.PurchaseService;

import java.util.List;
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private GoodsQuantityDao goodsQuantityDao;

    @Override
    public Purchase findPurchaseById(int id) throws Exception {
        return purchaseDao.findPurchaseById(id);
    }

    @Override
    public void createSentGoodsOreder(GoodsQuantity goodsQuantity) throws Exception {
//        //获取该订单的顾客id 并查询客户信息id
//        int Purchaseid = goodsQuantityDao.findPurchaseIdByid(goodsQuantity.getId());
//        int customerid = customerDao.findCustomerByPurchaseId(Purchaseid);
//
//        //生成发货单
//        invoiceDao.createInvoice(new Invoice(0,goodsQuantity),customerid);
//
//        //修改对应物品状态 获取原来的状态+1即可
//        purchaseDao.editgoodsQuantitystatus(goodsQuantity.getId(),goodsQuantity.getGoodstatus()+1);
//
//        //根据商品id 对应商品库存要减 小于0时不给发货的不用考虑0的情况
//        goodsDao.editgoodsNums(goodsQuantity.getGoods().getId(),goodsQuantity.getGoods().getNums()-goodsQuantity.getQuantity());


    }

    @Override
    public Contract checkPurchase(int purchaseid) {
        return purchaseDao.checkPurchase(purchaseid);
    }
}
