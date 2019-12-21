package ssm.domain;

public class Invoice {
    private int id;
    //0-未发货 1-已发货
    private int issent;
    private OrdersGood ordersGood;
    private Customer customer;
    private String logisticsid;

    public String getLogisticsid() {
        return "98961202459"+this.id;
    }

    public void setLogisticsid(String logisticsid) {
        this.logisticsid = logisticsid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice() {
    }

    public Invoice(int issent, OrdersGood ordersGood) {
        this.issent = issent;
        this.ordersGood = ordersGood;
    }

    public OrdersGood getOrdersGood() {
        return ordersGood;
    }

    public void setOrdersGood(OrdersGood ordersGood) {
        this.ordersGood = ordersGood;
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
