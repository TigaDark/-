package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.PurchaseDao;
import ssm.domain.Purchase;
import ssm.service.PurchaseService;

import java.util.List;
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;
    @Override
    public Purchase findPurchaseById(int id) throws Exception {
        return purchaseDao.findPurchaseById(id);
    }
}
