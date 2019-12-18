package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.domain.Logistics;
import ssm.service.LogisticsService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/logistics")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @RequestMapping("/showLogistics")
    public @ResponseBody Response showLogistics(@RequestParam(required = true,name = "id") int id) throws Exception {
        List<Logistics> logisticsList=logisticsService.findLogisticsByInvoiceId(id);

        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("logisticsList",logisticsList);
        response.success("获取成功",200);
        return response;
    }
}
