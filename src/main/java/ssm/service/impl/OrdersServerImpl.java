package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import ssm.dao.*;
import ssm.domain.*;
import ssm.domain.Pojo.OrdersGoods;
import ssm.domain.Pojo.SelectInfo;
import ssm.domain.Pojo.orderForm;
import ssm.service.OrdersServer;

import java.util.List;

@Service("ordersServer")
public class OrdersServerImpl implements OrdersServer {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private OrdersGoodDao ordersGoodDao;
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private GoodsQuantityDao goodsQuantityDao;
    @Override
    public void addOrders(orderForm orderForm) throws Exception {
        // 生成订单号"CC-SJO-2019-000" 插入订单表 并返回插入id
        Orders orders = new Orders();
        orders.setStrid("CC-SJO-2019-000");
         ordersDao.addOrders(orders);

        // 根据订单good 插入中间表 orders_good 默认状态 0 未发货 未支付
        for (OrdersGoods ordersGoods:orderForm.getOrdergoodsList()){
            //根据名字找到goods id
            Goods goods=goodsDao.findGoodsByName(ordersGoods.getName());
            //插入中间表
            ordersDao.addOrdersGoods(orders.getId(),goods.getId(),ordersGoods.getNums(),0,0);
        }

        //绑定合同和 orders
        ordersDao.addContractOrders(orderForm.getContractid(),orders.getId());

        //通过contractid 找到purchaseid 然后再找到对应purchaseid的goodquantityid 把数量减去清单数量
        int purchaseid=purchaseDao.findPurchaseidBycontractid(orderForm.getContractid());
        List<GoodsQuantity> goodsQuantityList= goodsQuantityDao.findGoodsQuantityByPurchaseId(purchaseid);
        System.out.println(goodsQuantityList.size());
        for (GoodsQuantity goodsQuantity:goodsQuantityList){
            for (OrdersGoods ordersGoods:orderForm.getOrdergoodsList()){
                Goods goods=goodsDao.findGoodsByName(ordersGoods.getName());
                //找到对应商品 减去数量
                System.out.println(goods.getId()+"--"+goodsQuantity.getGoods().getId());
                if (goods.getId()==goodsQuantity.getGoods().getId()){
                    goodsQuantityDao.editsurplusByid(goodsQuantity.getId(),goodsQuantity.getSurplus()-ordersGoods.getNums());
                    break;
                }
            }
        }
    }

    @Override
    public List<Orders> findOrdersByInfo(SelectInfo selectInfo) {
        //分页
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        return ordersDao.findOrdersByInfo(selectInfo.getQuery());
    }

    @Override
    public Orders getGoodsListByOrdersId(int id) {

        return ordersDao.getGoodsListByOrdersId(id);
    }

    @Override
    public void createSentGoodsOreder(OrdersGood ordersGood) throws Exception {
        //获取该订单的顾客id 并查询客户信息id
        int ordersid = ordersGoodDao.findOrdersIdByid(ordersGood.getId());
        int customerid = ordersDao.findCustomerByordersid(ordersid);

        //生成发货单
        invoiceDao.createInvoice(new Invoice(0,ordersGood),customerid);

        //修改对应物品状态 获取原来的状态+1即可
        ordersGoodDao.editordersGoodstatus(ordersGood.getId(),ordersGood.getGoodstatus()+1);

        //根据商品id 对应商品库存要减 小于0时不给发货的不用考虑0的情况
        goodsDao.editgoodsNums(ordersGood.getGoods().getId(),ordersGood.getGoods().getNums()-ordersGood.getQuantity());
    }
}
