package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Contract;
import ssm.domain.Purchase;

import java.util.List;

public interface PurchaseDao {

    Purchase findPurchaseById(int id) throws Exception;

    void editgoodsQuantitystatus(@Param(value = "id")int id, @Param(value = "status") int status);

    int findPurchaseByGoodsQuantityId(int id);

    Contract checkPurchase(int purchaseid);

    int findPurchaseidBycontractid(int contractid);
}
