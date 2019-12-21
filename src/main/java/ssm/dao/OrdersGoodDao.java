package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.OrdersGood;

import java.util.List;

public interface OrdersGoodDao {
    void findOrdersGoodBOrdersyId(int id);

    int findOrdersIdByid(int id);

    void editordersGoodstatus(@Param(value = "id")int id, @Param(value = "status") int status);

    List<OrdersGood> findOrdersGoodByordersId(int ordersid);
}
