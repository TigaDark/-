package ssm.service;

import ssm.domain.Customer;
import ssm.domain.SelectInfo;
import ssm.domain.Users;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerByInfo(SelectInfo selectInfo);

    void editCustomer(Customer customer);

    void addCustomer(Customer customer);

    Customer checkCustomer(String name);
}
