package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.CustomerDao;
import ssm.domain.Customer;
import ssm.domain.Pojo.SelectInfo;
import ssm.service.CustomerService;

import java.util.List;
@Service("customerServer")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<Customer> findCustomerByInfo(SelectInfo selectInfo) {
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        return customerDao.findCustomerByInfo();
    }

    @Override
    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {

        customerDao.addCustomer(customer);
    }

    @Override
    public Customer checkCustomer(String name) {
        return customerDao.findCustomerByName(name);
    }
}
