package ssm.domain;

public class BuyorderForm {
    private int goodsquantityid;
    private String goodsname;
    private int goodsnums;
    private int goodsmin;
    private int minbuygoods;

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
