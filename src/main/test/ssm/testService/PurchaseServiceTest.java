package ssm.testService;

import org.junit.Test;
import ssm.service.PurchaseService;
import ssm.service.impl.PurchaseServiceImpl;

public class PurchaseServiceTest {
    @Test
    public void test() throws Exception {
        PurchaseService purchaseService=new PurchaseServiceImpl();
        System.out.println(purchaseService.findPurchaseById(2));

    }
}
