package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ContrcatDao;
import ssm.domain.*;
import ssm.service.ContrcatService;

import java.util.Date;
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

    @Override
    public void editContractProcess(Contract contract) {
        //注意 时间也要修改！！！
        contrcatDao.editContractProcess(contract.getId(),contract.getProgress()+1,new Date());
    }

    @Override
    public void addContract(ContractForm contractForm) {
        //添加合同
        contrcatDao.addContract(contractForm);
    }

    @Override
    public void editContract(ContracteditForm contracteditForm) {
        contrcatDao.editContract(contracteditForm);
    }
}
