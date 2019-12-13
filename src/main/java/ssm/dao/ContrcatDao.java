package ssm.dao;

import ssm.domain.Contract;

import java.util.List;

public interface ContrcatDao {

    List<Contract> findContractByInfo(String query) throws Exception;
}
