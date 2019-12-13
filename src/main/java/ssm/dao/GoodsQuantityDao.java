package ssm.dao;

import ssm.domain.GoodsQuantity;

public interface GoodsQuantityDao {

    GoodsQuantity findGoodsQuantityByPurchaseId(int id);
}
