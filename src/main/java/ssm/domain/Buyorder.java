package ssm.domain;

public class Buyorder {
    private int id;
    private int goodsquantityid;
    private String goodsname;
    private int minquantity;
    private int realquantity;
    private int isbuy;

    public Buyorder() {
    }

    public Buyorder(int goodsquantityid, String goodsname, int minquantity, int realquantity, int isbuy) {
        this.goodsquantityid = goodsquantityid;
        this.goodsname = goodsname;
        this.minquantity = minquantity;
        this.realquantity = realquantity;
        this.isbuy = isbuy;
    }

    public int getGoodsquantityid() {
        return goodsquantityid;
    }

    public void setGoodsquantityid(int goodsquantityid) {
        this.goodsquantityid = goodsquantityid;
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
