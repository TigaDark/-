package ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;
import ssm.util.DateUtil;

import java.util.Date;

//物流信息表
public class Logistics {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date times;
    private String timesStr;
    private String context;
    private String start_place;
    private String company;
    private String strid;

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", times=" + times +
                ", timesStr='" + timesStr + '\'' +
                ", context='" + context + '\'' +
                ", start_place='" + start_place + '\'' +
                ", compayny='" + company + '\'' +
                ", strid='" + strid + '\'' +
                '}';
    }

    public Logistics(Date times, String context) {
        this.times = times;
        this.context = context;
    }

    public String getStart_place() {
        return start_place;
    }

    public void setStart_place(String start_place) {
        this.start_place = start_place;
    }

    public String getCompany() {
        return company;
    }

    public void setCompayny(String company) {
        this.company = company;
    }

    public String getStrid() {
        return "98961202459"+this.id;
    }

    public void setStrid(String strid) {
        this.strid = strid;
    }

    public Logistics() {
    }



    public String getTimesStr() {
        if(times!=null)
            return DateUtil.dateTostring(times,"YYYY-MM-dd HH:mm:ss");
        else
            return null;
    }

    public void setTimesStr(String timesStr) {
        this.timesStr = timesStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
