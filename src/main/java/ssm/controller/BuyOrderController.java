package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.domain.Buyorder;
import ssm.domain.Pojo.BuyorderForm;
import ssm.domain.Pojo.CheckBuyorderInfo;
import ssm.domain.Pojo.SelectInfo;
import ssm.service.BuyOrderService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/buyorder")
public class BuyOrderController {
    @Autowired
    private BuyOrderService buyOrderService;

    @RequestMapping("/addBuyOrder")
    public @ResponseBody Response Login(@RequestBody BuyorderForm buyorderForm) throws Exception {
        //获取进货单
        Buyorder buyorder = new Buyorder(buyorderForm.getOrdersgoodsid(),buyorderForm.getGoodsname(),buyorderForm.getMinbuygoods(),0,0);
        buyOrderService.addBuyOrder(buyorder);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("订货单生成成功",200);
        return response;
    }

    @RequestMapping("/getBuyOrderListList")
    public @ResponseBody Response getBuyOrderListList(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出合同信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Buyorder> buyorderList=buyOrderService.findBuyOrderByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(buyorderList);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("buyorderList",pageInfo);
        response.success("获取进货货单成功",200);
        return response;
    }

    @RequestMapping("/checkBuyOrder")
    private @ResponseBody Response checkBuyOrder(@RequestBody CheckBuyorderInfo checkBuyorderInfo)throws Exception{
        //确认进货
        buyOrderService.confirmBuyOrder(checkBuyorderInfo);

        Response response=new Response();
        Map<String,Object> data=new HashMap<>();
        response.success("进货成功!",200);
        return response;
    }

}
