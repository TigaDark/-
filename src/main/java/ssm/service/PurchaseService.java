package ssm.service;

import ssm.domain.Contract;
import ssm.domain.GoodsQuantity;
import ssm.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    /**
     * 根据id 查询采购清单
     * @param id
     * @return
     * @throws Exception
     */
    Purchase findPurchaseById(int id) throws Exception;


    /**
     * 生成发货单
     * @param id
     * @throws Exception
     */
    void createSentGoodsOreder(GoodsQuantity id) throws Exception;

    Contract checkPurchase(int purchaseid);
}
