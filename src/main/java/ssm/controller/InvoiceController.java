package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.domain.Pojo.SelectInfo;
import ssm.service.InvoiceService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping("/getInvoiceList")
    public @ResponseBody Response getInvoiceList(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出合同信息
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Invoice> invoices=invoiceService.findInvoiceByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(invoices);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("invoiceList",pageInfo);
        response.success("获取发货单成功",200);
        return response;
    }

    @RequestMapping("/confirmSent/{invoiceid}")
    private @ResponseBody Response confirmSent(@PathVariable(name = "invoiceid")int invoiceid,@RequestBody Logistics logistics)throws Exception{
        //确认发货
        invoiceService.confirmSent(invoiceid,logistics);
        Response response=new Response();
        Map<String,Object> data=new HashMap<>();
        response.success("确认发货成功!",200);
        return response;

    }

}
