package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.Customer;
import ssm.domain.Pojo.SelectInfo;
import ssm.service.CustomerService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/getCustomerList")
    public @ResponseBody Response getCustomerList(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出客户信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Customer> customerList=customerService.findCustomerByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(customerList);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("customerList",pageInfo);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/checkCustomer")
    public @ResponseBody Response checkCustomer(@RequestParam(required = true,name = "name") String name) throws Exception {
        //根据用户姓名查询出是否存在该客户姓名
        Customer customer = customerService.checkCustomer(name);

        Response response=new Response();
        // null -不存在可用  否则有这个销售员账户则不可用
        if (customer!=null)
            response.success("该客户已存在",201);
        else
            response.success("客户可用",200);
        return response;
    }


    @RequestMapping("/addCustomer")
    public @ResponseBody Response addCustomer(@RequestBody Customer customer) throws Exception {
        //添加客户信息
        customerService.addCustomer(customer);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("添加成功",200);
        return response;
    }

    @RequestMapping("/editCustomer")
    public @ResponseBody Response editCustomer(@RequestBody Customer customer) throws Exception {
        customerService.editCustomer(customer);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("修改成功",200);
        return response;
    }
}
