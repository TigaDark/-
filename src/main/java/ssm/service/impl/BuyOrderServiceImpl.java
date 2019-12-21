package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.BuyOrderDao;
import ssm.dao.GoodsDao;
import ssm.dao.GoodsQuantityDao;
import ssm.dao.OrdersGoodDao;
import ssm.domain.*;
import ssm.domain.Pojo.CheckBuyorderInfo;
import ssm.domain.Pojo.SelectInfo;
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
    @Autowired
    private OrdersGoodDao ordersGoodDao;
    @Override
    public void addBuyOrder(Buyorder buyorder) throws Exception {
        // 生成进货单
        // 设置剩余数量初始值
        buyorder.setSurplusquantity(buyorder.getMinquantity());
        buyOrderDao.addBuyOrder(buyorder);
        // 修改订单的货物goodsstate 为3 表示正在进货
        ordersGoodDao.editordersGoodstatus(buyorder.getOrdersgoodsid(),3);

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
        // 查询原来的buyorder
        Buyorder buyorder=buyOrderDao.findBuyOrderById(checkBuyorderInfo.getId());
        //将数量加上输入的数量
        buyOrderDao.editBuyOrder(checkBuyorderInfo.getId(),checkBuyorderInfo.getRealquantity()+buyorder.getRealquantity());

        //通过goodsname 查询到goodid 将goodid的库存+ 进货的数量
        Goods goods=goodsDao.findGoodsByName(checkBuyorderInfo.getGoodsname());
        goodsDao.editgoodsNums(goods.getId(),goods.getNums()+checkBuyorderInfo.getRealquantity());

        //实际进货量》最小进货了 进货完成
        if (checkBuyorderInfo.getRealquantity()+buyorder.getRealquantity()>=buyorder.getMinquantity()){
            //将goodquantity id 的进货单 status 改为0 显示未进货 因为这个订单已经进货了
            ordersGoodDao.editordersGoodstatus(checkBuyorderInfo.getGoodsquantityid(),0);
            buyOrderDao.editBuyOrderStatus(checkBuyorderInfo.getId(),2,0);
            // buyorders状态改为1 剩余数量改为0
        }else{
            //表示进货中
            buyOrderDao.editBuyOrderStatus(checkBuyorderInfo.getId(),1,buyorder.getMinquantity()-checkBuyorderInfo.getRealquantity()-buyorder.getRealquantity());
        }

    }
}
