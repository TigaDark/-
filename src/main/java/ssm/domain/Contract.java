package ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Contract {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date start_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date end_time;
    private int fahuoid;
    private int jinhuoid;
    private int totalmoney;
    //0-未完成 1-正在进行 3-已完成  注意没有2
    private int progress;
    private Customer customer;
    private Purchase purchase;
    private Users user;


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

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
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

