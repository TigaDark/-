package ssm.dao;

import ssm.domain.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findCustomerById(int id) throws Exception;

    int findCustomerByPurchaseId(int purchaseid);

    List<Customer> findCustomerByInfo();

    void editCustomer(Customer customer);

    void addCustomer(Customer customer);

    Customer findCustomerByName(String name);

    Customer findCustomerByinvoiceId(int invoiceid);
}
