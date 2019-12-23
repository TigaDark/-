package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ContrcatDao;
import ssm.dao.GoodsDao;
import ssm.dao.UsersDao;
import ssm.domain.*;
import ssm.domain.Pojo.*;
import ssm.service.ContrcatService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Service("contrcatService")
public class ContrcatServiceImpl implements ContrcatService {

    @Autowired
    private ContrcatDao contrcatDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Contract> findContractByInfo(SelectInfo selectInfo) throws Exception {
        double total=0;
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
            contrcatDao.editContractTotal(contract.getId(),contract.getTotalmoney());
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

    @Override
    public List<Contract> findContractByUsername(SaleSelect selectInfo) {
        double total=0;
        //通过名字查询userid
        int userid = usersDao.findByRealName(selectInfo.getUsername());
        //分页
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        List<Contract> contracts= contrcatDao.findContractByUserId(userid);
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
    public List<Contract> findContract() {
        return contrcatDao.findContract();
    }

    @Override
    public List<Contract> findCustomertics() {
        return contrcatDao.findCustomertics();
    }

    @Override
    public List<Contract> getCustomerticsBytime(contracttime contracttime) {
        return contrcatDao.getCustomerticsBytime(contracttime);
    }

    @Override
    public  HashMap<String,Double>getgoodstics() {
        //找到所有商品
        List<Goods> goodsList=goodsDao.findAllGoods();
        HashMap<String,Double> goodMap = new HashMap<String, Double>();
        for (Goods goods:goodsList){
            goodMap.put(goods.getName(),0.0);
        }
        List<Contract> contractList=contrcatDao.findContract();
        for (Contract contract:contractList){
            //找到对应合同的商品 通过key加起来
            for (GoodsQuantity goodsQuantity:contract.getPurchase().getGoodsQuantityList()){
                double sum =goodMap.get(goodsQuantity.getGoods().getName())+goodsQuantity.getQuantity()*goodsQuantity.getGoods().getPrice();
                goodMap.put(goodsQuantity.getGoods().getName(),sum);
            }
        }
        return goodMap;
    }

    @Override
    public HashMap<String, Double> getgoodsticsBytime(contracttime contracttime) {
        //找到所有商品
        List<Goods> goodsList=goodsDao.findAllGoods();
        HashMap<String,Double> goodMap = new HashMap<String, Double>();
        for (Goods goods:goodsList){
            goodMap.put(goods.getName(),0.0);
        }
        List<Contract> contractList=contrcatDao.findContract();
        for (Contract contract:contractList){
            //找到对应合同的商品 通过key加起来
            if ((contracttime.getStarttime().compareTo(contract.getStart_timeStr())<=0) &&  (contracttime.getEndtime().compareTo(contract.getEnd_timeStr())>=0)){
                for (GoodsQuantity goodsQuantity:contract.getPurchase().getGoodsQuantityList()){
                    double sum =goodMap.get(goodsQuantity.getGoods().getName())+goodsQuantity.getQuantity()*goodsQuantity.getGoods().getPrice();
                    goodMap.put(goodsQuantity.getGoods().getName(),sum);
                }
            }
        }
        return goodMap;
    }

    @Override
    public List<Contract> getSaleticsBysalename(String username) throws Exception {
        int id = Integer.parseInt(username);
        return contrcatDao.findContracticByuserid(id);
    }

    @Override
    public List<Contract> getSaleticsBytime(String username, contracttime contracttime) throws Exception {
        int id = Integer.parseInt(username);
        return contrcatDao.findSaleticsByuserid(id,contracttime);
    }
}
