package ssm.service;

import ssm.domain.Logistics;

import java.util.List;

public interface LogisticsService {
    public List<Logistics> findLogisticsByInvoiceId(int id) throws Exception;
}
