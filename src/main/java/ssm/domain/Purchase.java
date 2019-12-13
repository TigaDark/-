package ssm.domain;

import java.util.List;

public class Purchase {
    private int id;
    //1-已付款 0-未付款
    private int ispay;
    //属于某个客户的采购订单
    private Customer customer;
    //这个采购订单有多个商品
    private List<GoodsQuantity> goodsQuantityList;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", ispay=" + ispay +
                ", customer=" + customer +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<GoodsQuantity> getGoodsQuantityList() {
        return goodsQuantityList;
    }

    public void setGoodsQuantityList(List<GoodsQuantity> goodsQuantityList) {
        this.goodsQuantityList = goodsQuantityList;
    }
}
