package ssm.service;

import ssm.domain.Orders;
import ssm.domain.OrdersGood;
import ssm.domain.Pojo.SelectInfo;
import ssm.domain.Pojo.orderForm;

import java.util.List;

public interface OrdersServer {
    void addOrders(orderForm orderForm) throws Exception;

    List<Orders> findOrdersByInfo(SelectInfo selectInfo);

    Orders getGoodsListByOrdersId(int id);

    void createSentGoodsOreder(OrdersGood ordersGood) throws Exception;
}
