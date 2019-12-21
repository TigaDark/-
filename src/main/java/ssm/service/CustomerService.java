package ssm.service;

import ssm.domain.Customer;
import ssm.domain.Pojo.SelectInfo;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerByInfo(SelectInfo selectInfo);

    void editCustomer(Customer customer);

    void addCustomer(Customer customer);

    Customer checkCustomer(String name);
}
