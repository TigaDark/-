package ssm.domain;

import org.springframework.format.annotation.DateTimeFormat;
import ssm.util.DateUtil;

import java.text.ParseException;
import java.util.Date;

public class Users {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String phone;
    private String email;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date entrytime;
    private Role role;
    private String entrytimeStr;

    public String getEntrytimeStr() {
        if(entrytime!=null)
            return DateUtil.dateTostring(entrytime,"YYYY-MM-dd");
        else
            return null;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", entrytime=" + entrytime +
                ", role=" + role +
                ", entrytimeStr='" + entrytimeStr + '\'' +
                '}';
    }

    public void setEntrytimeStr(String entrytimeStr) {
        this.entrytimeStr = entrytimeStr;
    }

    public Date getEntrytime() throws ParseException {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
