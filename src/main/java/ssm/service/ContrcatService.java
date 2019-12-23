package ssm.service;

import ssm.domain.Contract;
import ssm.domain.Pojo.*;

import java.util.HashMap;
import java.util.List;

public interface ContrcatService {
    /**
     * 根据分页参数 和 查询参数 查询出合同信息
     * @param selectInfo
     * @return
     * @throws Exception
     */
    List<Contract> findContractByInfo(SelectInfo selectInfo) throws Exception;

    /**
     * 根据合同id 修改对应合同的进度
     * @param contract
     */
    void editContractProcess(Contract contract);

    void addContract(ContractForm contractForm);

    void editContract(ContracteditForm contracteditForm);

    List<Contract> findContractByUsername(SaleSelect selectInfo);

    List<Contract> findContract();

    List<Contract> findCustomertics();

    List<Contract> getCustomerticsBytime(contracttime contracttime);

    HashMap<String,Double> getgoodstics();

    HashMap<String, Double> getgoodsticsBytime(contracttime contracttime);

    List<Contract> getSaleticsBysalename(String username) throws Exception;

    List<Contract> getSaleticsBytime(String username, contracttime contracttime) throws Exception;
}
