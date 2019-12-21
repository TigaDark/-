package ssm.domain;

public class Buyorder {
    private int id;
    private int ordersgoodsid;
    private String goodsname;
    private int minquantity;
    private int realquantity;
    private int isbuy;
    private int surplusquantity;

    public Buyorder() {
    }

    public int getSurplusquantity() {
        return surplusquantity;
    }

    public void setSurplusquantity(int surplusquantity) {
        this.surplusquantity = surplusquantity;
    }

    public Buyorder(int ordersgoodsid, String goodsname, int minquantity, int realquantity, int isbuy) {
        this.ordersgoodsid = ordersgoodsid;
        this.goodsname = goodsname;
        this.minquantity = minquantity;
        this.realquantity = realquantity;
        this.isbuy = isbuy;
    }

    public int getOrdersgoodsid() {
        return ordersgoodsid;
    }

    public void setOrdersgoodsid(int ordersgoodsid) {
        this.ordersgoodsid = ordersgoodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinquantity() {
        return minquantity;
    }

    public void setMinquantity(int minquantity) {
        this.minquantity = minquantity;
    }

    public int getRealquantity() {
        return realquantity;
    }

    public void setRealquantity(int realquantity) {
        this.realquantity = realquantity;
    }

    public int getIsbuy() {
        return isbuy;
    }

    public void setIsbuy(int isbuy) {
        this.isbuy = isbuy;
    }

}
