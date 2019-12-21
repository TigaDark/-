package ssm.domain.Pojo;

public class BuyorderForm {
    private int ordersgoodsid;
    private String goodsname;
    private int goodsnums;
    private int goodsmin;
    private int minbuygoods;
    private int surplusquantity;

    public int getOrdersgoodsid() {
        return ordersgoodsid;
    }

    public void setOrdersgoodsid(int ordersgoodsid) {
        this.ordersgoodsid = ordersgoodsid;
    }

    public int getSurplusquantity() {
        return surplusquantity;
    }

    public void setSurplusquantity(int surplusquantity) {
        this.surplusquantity = surplusquantity;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsnums() {
        return goodsnums;
    }

    public void setGoodsnums(int goodsnums) {
        this.goodsnums = goodsnums;
    }

    public int getGoodsmin() {
        return goodsmin;
    }

    public void setGoodsmin(int goodsmin) {
        this.goodsmin = goodsmin;
    }

    public int getMinbuygoods() {
        return minbuygoods;
    }

    public void setMinbuygoods(int minbuygoods) {
        this.minbuygoods = minbuygoods;
    }
}
