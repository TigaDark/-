package ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;
import ssm.util.DateUtil;

import java.util.Date;

public class Contract {
    private int id;
    private String strid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date start_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date end_time;
    private int fahuoid;
    private int jinhuoid;
    private double totalmoney;
    //0-未完成 1-正在进行 2-已完成
    private int progress;
    private Customer customer;
    private Purchase purchase;
    private Users user;
    private String end_timeStr;
    private String start_timeStr;

    public String getStrid() {
        return "CC-SJB-2019-000"+this.id;
    }

    public void setStrid(String strid) {
        this.strid = strid;
    }

    public void setEnd_timeStr(String end_timeStr) {
        this.end_timeStr = end_timeStr;
    }

    public String getStart_timeStr() {
        //如果不是默认值2000年 那么就是未开始合同
        if(start_time.getYear()!=100)
            return DateUtil.dateTostring(start_time,"YYYY-MM-dd HH:mm");
        else
            return "未执行";
    }

    public String getEnd_timeStr() {
        if(end_time.getYear()!=100)
            return DateUtil.dateTostring(end_time,"YYYY-MM-dd HH:mm");
        else
            return "未结束";
    }

    public void setStart_timeStr(String start_timeStr) {
        this.start_timeStr = start_timeStr;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", fahuoid=" + fahuoid +
                ", jinhuoid=" + jinhuoid +
                ", totalmoney=" + totalmoney +
                ", customer=" + customer +
                ", purchase=" + purchase +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }


    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getFahuoid() {
        return fahuoid;
    }

    public void setFahuoid(int fahuoid) {
        this.fahuoid = fahuoid;
    }

    public int getJinhuoid() {
        return jinhuoid;
    }

    public void setJinhuoid(int jinhuoid) {
        this.jinhuoid = jinhuoid;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

