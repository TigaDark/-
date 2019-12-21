package ssm.domain;

public class GoodsQuantity {
    int id;
    //这个商品的购买数量
    private int quantity;
    //发货状态
    //0-未发货 1-发货中 2-发货完成 3-正在进货中
    private int goodstatus;
    private Goods goods;
    //合同剩余数量
    private int surplus;

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public int getGoodstatus() {
        return goodstatus;
    }

    public void setGoodstatus(int goodstatus) {
        this.goodstatus = goodstatus;
    }

    @Override
    public String toString() {
        return "GoodsQuantity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", goodstatus=" + goodstatus +
                ", goods=" + goods +
                ", surplus=" + surplus +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
