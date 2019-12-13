package ssm.service;

import ssm.domain.Contract;
import ssm.domain.SelectInfo;

import java.util.List;

public interface ContrcatService {
    /**
     * 根据分页参数 和 查询参数 查询出合同信息
     * @param selectInfo
     * @return
     * @throws Exception
     */
    List<Contract> findContractByInfo(SelectInfo selectInfo) throws Exception;
}
