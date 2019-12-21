package ssm.service;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Buyorder;
import ssm.domain.Pojo.CheckBuyorderInfo;
import ssm.domain.Pojo.SelectInfo;

import java.util.List;

public interface BuyOrderService {
    void addBuyOrder(Buyorder buyorder) throws Exception;

    List<Buyorder> findBuyOrderByInfo(SelectInfo selectInfo);

    void confirmBuyOrder(CheckBuyorderInfo checkBuyorderInfo) throws Exception;
}
