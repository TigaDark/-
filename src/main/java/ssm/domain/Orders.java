package ssm.domain;

import java.util.List;

public class Orders {
    private int id;
    private String strid;
    // 0-正在进行 1-已完成
    private int progress;
    private Contract contract;
    private List<OrdersGood> ordersGoodList;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", strid='" + strid + '\'' +
                ", progress=" + progress +
                ", contract=" + contract +
                ", ordersGoodList=" + ordersGoodList +
                '}';
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<OrdersGood> getOrdersGoodList() {
        return ordersGoodList;
    }

    public void setOrdersGoodList(List<OrdersGood> ordersGoodList) {
        this.ordersGoodList = ordersGoodList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrid() {
        return strid;
    }

    public void setStrid(String strid) {
        this.strid = strid;
    }
}
