package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Goods;

public interface GoodsDao {

    Goods findGoodsByQuantityId(int id) throws Exception;

    void editgoodsNums(@Param(value = "gid")int id, @Param(value = "nums") int nums) throws Exception;

}
