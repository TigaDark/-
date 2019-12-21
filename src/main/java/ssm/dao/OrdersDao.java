package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Orders;
import ssm.domain.OrdersGood;

import java.util.List;

public interface OrdersDao {
    int addOrders(Orders orders);

    void addOrdersGoods(@Param(value = "ordersid")int ordersid, @Param(value = "goodsid")int goodsid, @Param(value = "nums")int nums, @Param(value = "goodstatus")int goodstatus, @Param(value = "ispay")int ispay);

    void addContractOrders(@Param(value = "contractid")int contractid, @Param(value = "ordersid")int ordersid);

    List<Orders> findOrdersByInfo(String query);

    Orders getGoodsListByOrdersId(int id);

    int findCustomerByordersid(int ordersid);

    OrdersGood findOrdersGoodById(int id);

    void editProgressByid(@Param(value = "ordersid")int ordersid,@Param(value = "progress")int progress);

    List<Orders> findOrdersByContractId(int id);
}
