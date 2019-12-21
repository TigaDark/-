package ssm.domain.Pojo;

import java.util.List;

public class orderForm {
    private int contractid;
    private List<OrdersGoods> ordergoodsList;

    public int getContractid() {
        return contractid;
    }

    @Override
    public String toString() {
        return "orderForm{" +
                "contractid=" + contractid +
                ", ordergoodsList=" + ordergoodsList +
                '}';
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    public List<OrdersGoods> getOrdergoodsList() {
        return ordergoodsList;
    }

    public void setOrdergoodsList(List<OrdersGoods> ordergoodsList) {
        this.ordergoodsList = ordergoodsList;
    }
}
