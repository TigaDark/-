package ssm.dao;

import ssm.domain.Goods;

public interface GoodsDao {

    Goods findGoodsByQuantityId(int id);

}
