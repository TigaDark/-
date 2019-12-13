package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ContrcatDao;
import ssm.domain.Contract;
import ssm.domain.GoodsQuantity;
import ssm.domain.SelectInfo;
import ssm.service.ContrcatService;

import java.util.List;
@Service("contrcatService")
public class ContrcatServiceImpl implements ContrcatService {

    @Autowired
    private ContrcatDao contrcatDao;

    @Override
    public List<Contract> findContractByInfo(SelectInfo selectInfo) throws Exception {
        int total=0;
        //分页
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        List<Contract> contracts= contrcatDao.findContractByInfo(selectInfo.getQuery());
        //计算该合同总金额
        for(Contract contract:contracts){
            total=0;
            for(GoodsQuantity goodsQuantity:contract.getPurchase().getGoodsQuantityList()){
                //计算每一个商品的总价格
                total+=(goodsQuantity.getGoods().getPrice()*goodsQuantity.getQuantity());
            }
            contract.setTotalmoney(total);
        }
        return contracts;
    }
}
