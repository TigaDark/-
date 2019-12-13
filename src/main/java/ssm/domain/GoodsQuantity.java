package ssm.domain;

public class GoodsQuantity {
    int id;
    //这个商品的购买数量
    private int quantity;
    //发货状态
    private int goodstatus;
    private Goods goods;

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
                ", goods=" + goods +
                ", quantity=" + quantity +
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
