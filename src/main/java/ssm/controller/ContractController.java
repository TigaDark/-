package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.domain.Pojo.*;
import ssm.service.ContrcatService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContrcatService contrcatService;

    @RequestMapping("/getContractList")
    public @ResponseBody Response getContractList(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出合同信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Contract> contracts=contrcatService.findContractByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(contracts);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("contractList",pageInfo);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/editContractProcess")
    public @ResponseBody Response editContractProcess(@RequestBody Contract contract) throws Exception {
        //根据合同id 修改对应的合同进度
        contrcatService.editContractProcess(contract);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("执行合同成功",200);
        return response;
    }


    @RequestMapping("/addContract")
    public @ResponseBody Response addContract(@RequestBody ContractForm contractForm) throws Exception {
        //根据合同id 修改对应的合同进度
        contrcatService.addContract(contractForm);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("添加合同成功！",200);
        return response;
    }

    @RequestMapping("/editContract")
    public @ResponseBody Response addContract(@RequestBody ContracteditForm contracteditForm) throws Exception {
        //根据合同id 修改对应的合同进度
        contrcatService.editContract(contracteditForm);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("修改合同成功！",200);
        return response;
    }

    @RequestMapping("/getSaleContractList")
    public @ResponseBody Response getSaleContractList(@RequestBody SaleSelect selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出合同信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Contract> contracts=contrcatService.findContractByUsername(selectInfo);
        PageInfo pageInfo= new PageInfo(contracts);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("contractList",pageInfo);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getTotaltics")
    public @ResponseBody Response getTotaltics() throws Exception {
        List<Contract> contracts=contrcatService.findContract();
        double total=0;
        for (Contract contract:contracts)
            total+=contract.getTotalmoney();
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("total",total);
        response.success("获取成功",200);
        return response;
    }
    @RequestMapping("/getTotalticsBytime")
    public @ResponseBody Response getTotalticsBytime(@RequestBody contracttime contracttime) throws Exception {
        List<Contract> contracts=contrcatService.findContract();
        double total=0;
        for (Contract contract:contracts){
            if ((contracttime.getStarttime().compareTo(contract.getStart_timeStr())<=0) &&  (contracttime.getEndtime().compareTo(contract.getEnd_timeStr())>=0))
                total+=contract.getTotalmoney();
        }
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("total",total);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getCustomertics")
    public @ResponseBody Response getCustomertics() throws Exception {
        List<Contract> contracttics=contrcatService.findCustomertics();
        Response response=new Response();
        response.put("contracttics",contracttics);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getCustomerticsBytime")
    public @ResponseBody Response getCustomerticsBytime(@RequestBody contracttime contracttime) throws Exception {
        List<Contract> contracts=contrcatService.getCustomerticsBytime(contracttime);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("contracttics",contracts);
        response.success("获取成功",200);
        return response;
    }
    @RequestMapping("/getgoodstics")
    public @ResponseBody Response getgoodstics() throws Exception {
        HashMap<String,Double> goodsMap=contrcatService.getgoodstics();
        HashMap<Double,String> nameMap=new HashMap<>();
        for(String key:goodsMap.keySet()){
            nameMap.put(goodsMap.get(key),key);
        }
        Response response=new Response();
        response.put("goodstics",goodsMap);
        response.put("nametics",nameMap);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getgoodsticsBytime")
    public @ResponseBody Response getgoodsticsBytime(@RequestBody contracttime contracttime) throws Exception {
        HashMap<String,Double> goodsMap=contrcatService.getgoodsticsBytime(contracttime);
        HashMap<Double,String> nameMap=new HashMap<>();
        for(String key:goodsMap.keySet()){
            nameMap.put(goodsMap.get(key),key);
        }
        Response response=new Response();
        response.put("goodstics",goodsMap);
        response.put("nametics",nameMap);
        response.success("获取成功",200);
        return response;
    }
    @RequestMapping("/getSaletics/{username}")
    public @ResponseBody Response getSaletics(@PathVariable("username") String username) throws Exception {
        List<Contract> contracttics=contrcatService.getSaleticsBysalename(username);
        Response response=new Response();
        response.put("saletics",contracttics);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/getSaleticsBytime/{username}")
    public @ResponseBody Response getSaleticsBytime(@PathVariable("username") String username,@RequestBody contracttime contracttime) throws Exception {
        List<Contract> contracts=contrcatService.getSaleticsBytime(username,contracttime);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("saletics",contracts);
        response.success("获取成功",200);
        return response;
    }

}

