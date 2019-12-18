package ssm.service;

import ssm.domain.Buyorder;
import ssm.domain.CheckBuyorderInfo;
import ssm.domain.SelectInfo;

import java.util.List;

public interface BuyOrderService {
    void addBuyOrder(Buyorder buyorder) throws Exception;

    List<Buyorder> findBuyOrderByInfo(SelectInfo selectInfo);

    void confirmBuyOrder(CheckBuyorderInfo checkBuyorderInfo) throws Exception;
}
