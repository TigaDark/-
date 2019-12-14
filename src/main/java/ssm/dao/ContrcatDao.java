package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Contract;

import java.util.Date;
import java.util.List;

public interface ContrcatDao {

    List<Contract> findContractByInfo(String query) throws Exception;

    void editContractProcess(@Param(value = "id")int id, @Param(value = "progress")int progress, @Param(value = "times")Date times);
}
