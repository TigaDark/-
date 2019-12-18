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

    public Logistics() {
    }

    public Logistics(Date times, String context) {
        this.times = times;
        this.context = context;
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
