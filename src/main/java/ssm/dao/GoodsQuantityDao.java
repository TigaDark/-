package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.GoodsQuantity;

import java.util.List;

public interface GoodsQuantityDao {

    List<GoodsQuantity> findGoodsQuantityByPurchaseId(int id) throws Exception;

    GoodsQuantity findGoodsQuantityById(int id) throws Exception;

    void editgoodsstatusByid(@Param(value = "id")int id, @Param(value = "goodstatus")int goodstatus) throws Exception;

    int findPurchaseIdByid(int id);
}
