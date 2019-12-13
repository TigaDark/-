package ssm.dao;

import ssm.domain.Purchase;

import java.util.List;

public interface PurchaseDao {

    Purchase findPurchaseById(int id) throws Exception;

}
