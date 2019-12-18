package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.BuyOrderDao;
import ssm.dao.GoodsDao;
import ssm.dao.GoodsQuantityDao;
import ssm.domain.*;
import ssm.service.BuyOrderService;

import java.util.List;

@Service("buyOrder")
public class BuyOrderServiceImpl implements BuyOrderService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private BuyOrderDao buyOrderDao;
    @Autowired
    private GoodsQuantityDao goodsQuantityDao;
    @Override
    public void addBuyOrder(Buyorder buyorder) throws Exception {
        // 生成进货单
        buyOrderDao.addBuyOrder(buyorder);
        // 修改订单的货物goodsstate 为3 表示正在进货
        goodsQuantityDao.editgoodsstatusByid(buyorder.getGoodsquantityid(),3);
    }

    @Override
    public List<Buyorder> findBuyOrderByInfo(SelectInfo selectInfo) {
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        //查询参数传入
        List<Buyorder> buyorderList= buyOrderDao.findBuyOrderByInfo(selectInfo.getQuery());
        return buyorderList;
    }

    @Override
    public void confirmBuyOrder(CheckBuyorderInfo checkBuyorderInfo) throws Exception {
        System.out.println(checkBuyorderInfo);
        //将数量改为输入的数量 和 状态改为1
        buyOrderDao.editBuyOrder(checkBuyorderInfo.getId(),checkBuyorderInfo.getRealquantity(),1);

        //通过goodsname 查询到goodid 将goodid的库存+ 进货的数量
        Goods goods=goodsDao.findGoodsByName(checkBuyorderInfo.getGoodsname());
        goodsDao.editgoodsNums(goods.getId(),goods.getId()+checkBuyorderInfo.getRealquantity());
        //将goodquantity id 的进货单 status 改为0 显示未进货 因为这个订单已经进货了
        goodsQuantityDao.editgoodsstatusByid(checkBuyorderInfo.getGoodsquantityid(),0);
    }
}
