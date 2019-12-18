package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Logistics;

import java.util.Date;
import java.util.List;

public interface LogisticsDao {
    List<Logistics> findLogisticsByInvoiceId(int id) throws Exception;

    int addLogistics(Logistics logistics) throws Exception;

    void addLogisticsByInvoiceId(@Param(value = "lid")int lid, @Param(value = "iid")int iid);
}
