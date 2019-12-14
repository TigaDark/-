package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.service.ContrcatService;
import ssm.service.PurchaseService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/getGoodsListByPurchaseId")
    public @ResponseBody Response getGoodsListByPurchaseId(@RequestParam(required = true,name = "id") int id) throws Exception {
        //根据采购清单id 查询出采购内容
        System.out.println(id);
        Purchase purchases=purchaseService.findPurchaseById(id);
        System.out.println(purchases);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("purchases",purchases);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/createSentGoodsOreder")
    public @ResponseBody Response createSentGoodsOreder(@RequestBody GoodsQuantity goodsQuantity) throws Exception {
        //获取发货单内容 goodsQuantity并生成发货单同时修改当前订单物品的发货状态
        purchaseService.createSentGoodsOreder(goodsQuantity);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("生成发货单成功",200);
        return response;
    }



}
