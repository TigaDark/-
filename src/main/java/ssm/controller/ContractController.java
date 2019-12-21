package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.domain.Pojo.ContractForm;
import ssm.domain.Pojo.ContracteditForm;
import ssm.domain.Pojo.SelectInfo;
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

}
