package ssm.testService;

import org.junit.Test;
import ssm.domain.Contract;
import ssm.domain.SelectInfo;
import ssm.service.ContrcatService;
import ssm.service.PurchaseService;
import ssm.service.impl.ContrcatServiceImpl;
import ssm.service.impl.PurchaseServiceImpl;

import java.util.List;

public class PurchaseServiceTest {
    @Test
    public void test() throws Exception {
        PurchaseService purchaseService=new PurchaseServiceImpl();
        System.out.println(purchaseService.findPurchaseById(2));

    }
}
