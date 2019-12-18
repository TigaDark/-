package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Buyorder;

import java.util.List;

public interface BuyOrderDao {
    void addBuyOrder(Buyorder buyorder) throws Exception;

    List<Buyorder> findBuyOrderByInfo(String query);

    void editBuyOrder(@Param(value = "id")int id, @Param(value = "realquantity")int realquantity, @Param(value = "status")int status);
}
