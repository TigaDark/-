package ssm.domain.Pojo;

public class CheckBuyorderInfo {
    private int id;
    private int goodsquantityid;
    private String goodsname;
    private int realquantity;

    public int getRealquantity() {
        return realquantity;
    }

    public int getGoodsquantityid() {
        return goodsquantityid;
    }

    public void setGoodsquantityid(int goodsquantityid) {
        this.goodsquantityid = goodsquantityid;
    }

    public void setRealquantity(int realquantity) {
        this.realquantity = realquantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Override
    public String toString() {
        return "CheckBuyorderInfo{" +
                "id=" + id +
                ", goodsquantityid=" + goodsquantityid +
                ", goodsname='" + goodsname + '\'' +
                ", realquantity=" + realquantity +
                '}';
    }
}
