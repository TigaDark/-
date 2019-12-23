package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Goods;

import java.util.List;

public interface GoodsDao {

    Goods findGoodsByQuantityId(int id) throws Exception;

    void editgoodsNums(@Param(value = "gid")int id, @Param(value = "nums") int nums) throws Exception;

    Goods findGoodsByName(String goodsname);

    List<Goods> findAllGoods();
}
