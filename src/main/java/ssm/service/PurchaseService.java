package ssm.service;

import ssm.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase findPurchaseById(int id) throws Exception;
}
