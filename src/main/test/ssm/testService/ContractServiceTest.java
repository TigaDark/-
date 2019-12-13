package ssm.testService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.dao.ContrcatDao;
import ssm.domain.Contract;
import ssm.domain.SelectInfo;
import ssm.service.ContrcatService;
import ssm.service.impl.ContrcatServiceImpl;

import java.util.List;

public class ContractServiceTest {

    @Test
    public void test() throws Exception {
        ContrcatService contrcatService =new ContrcatServiceImpl();
        SelectInfo selectInfo = new SelectInfo();
        selectInfo.setPagenum(1);
        selectInfo.setPagesize(2);
        selectInfo.setQuery("123");
        List<Contract> contracts=contrcatService.findContractByInfo(selectInfo);
        for (Contract contract:contracts)
            System.out.println(contract);

    }
}
