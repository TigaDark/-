package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.LogisticsDao;
import ssm.domain.Logistics;
import ssm.service.LogisticsService;

import java.util.List;

@Service("logisticsService")
public class LogisticsServiceImpl implements LogisticsService{
    @Autowired
    private LogisticsDao logisticsDao;

    @Override
    public List<Logistics> findLogisticsByInvoiceId(int id) throws Exception {
        return logisticsDao.findLogisticsByInvoiceId(id);
    }
}
