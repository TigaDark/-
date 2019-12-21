package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.domain.Pojo.BuyorderForm;
import ssm.domain.Pojo.SelectInfo;
import ssm.domain.Pojo.orderForm;
import ssm.service.OrdersServer;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersServer ordersServer;

    @RequestMapping("/addOrders")
    public @ResponseBody Response addOrders(@RequestBody orderForm orderForm) throws Exception {
        //添加合同清单
        ordersServer.addOrders(orderForm);
        Response response=new Response();
        response.success("合同订单生成成功",200);
        return response;
    }

    @RequestMapping("/getordersList")
    public @ResponseBody Response getordersList(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出合同订单信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Orders> ordersList=ordersServer.findOrdersByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(ordersList);
        Response response=new Response();
        response.put("ordersList",pageInfo);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getGoodsListByOrdersId")
    public @ResponseBody Response getGoodsListByOrdersId(@RequestParam(required = true,name = "ordersid") int id) throws Exception {
        //根据合同内容id 查询出采购内容
        Orders orders=ordersServer.getGoodsListByOrdersId(id);

        Response response=new Response();
        response.put("orders",orders);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/createSentGoodsOreder")
    public @ResponseBody Response createSentGoodsOreder(@RequestBody OrdersGood ordersGood) throws Exception {
        //获取发货单内容 OrdersGood并生成发货单同时修改当前订单物品的发货状态
        ordersServer.createSentGoodsOreder(ordersGood);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("生成发货单成功",200);
        return response;
    }
}
