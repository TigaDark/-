package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Contract;
import ssm.domain.Pojo.ContractForm;
import ssm.domain.Pojo.ContracteditForm;
import ssm.domain.Pojo.contracttime;

import java.util.Date;
import java.util.List;

public interface ContrcatDao {

    List<Contract> findContractByInfo(String query) throws Exception;

    void editContractProcess(@Param(value = "id")int id, @Param(value = "progress")int progress, @Param(value = "times")Date times);

    void editContractEndProgressByPurchaseId(@Param(value = "pruchaseid")int pruchaseid, @Param(value = "progress")int progress,@Param(value = "endtimes")Date endtimes);

    void addContract(ContractForm contractForm);

    void editContract(ContracteditForm contracteditForm);

    void findContractById(int id);

    Contract findContractByOrdersId(int ordersid);

    void editContractProcessByContractid(@Param(value = "id")int id, @Param(value = "progress")int progress, @Param(value = "endtimes")Date times);

    List<Contract> findContractByUserId(int userid);

    void editContractTotal(@Param(value = "id")int id, @Param(value = "totalmoney")double totalmoney);

    List<Contract> findContract();

    List<Contract> findCustomertics();

    List<Contract> getCustomerticsBytime(contracttime contracttime);

    List<Contract> findContracticByuserid(int id);

    List<Contract> findSaleticsByuserid(@Param(value = "id")int id,  @Param(value = "contracttime")contracttime contracttime);
}
