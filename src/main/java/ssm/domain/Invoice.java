package ssm.domain;

public class Invoice {
    private int id;
    //0-未发货 1-已发货
    private int issent;
    private GoodsQuantity goodsQuantity;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice() {
    }

    public Invoice(int issent, GoodsQuantity goodsQuantity) {
        this.issent = issent;
        this.goodsQuantity = goodsQuantity;
    }

    public GoodsQuantity getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(GoodsQuantity goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssent() {
        return issent;
    }

    public void setIssent(int issent) {
        this.issent = issent;
    }

}
