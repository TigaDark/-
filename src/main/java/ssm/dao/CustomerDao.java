package ssm.dao;

import ssm.domain.Customer;

public interface CustomerDao {

    Customer findCustomerById(int id) throws Exception;

    int findCustomerByPurchaseId(int purchaseid);
}
