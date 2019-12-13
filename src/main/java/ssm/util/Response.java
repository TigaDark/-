package ssm.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Response implements Serializable {
//
//    private  static Map<String,String> msgMap = new HashMap<>();
    private  Map<String, Object> data = new HashMap<>();
    private String msg;
    private int code;

    //用枚举变量
//    //初始化状态码与文字说明
//     static {
//        msgMap.put("0", "");
//        msgMap.put("400", "HTTP 错误 400.0 - 访问被拒绝：错误的请求");
//        msgMap.put("401", "HTTP 错误 401.1 - 未经授权：访问由于凭据无效被拒绝");
//        msgMap.put("405", "用来访问本页面的 HTTP 谓词不被允许（方法不被允许）");
//        msgMap.put("406", "客户端浏览器不接受所请求页面的 MIME 类型");
//        msgMap.put("500", "HTTP 错误 500.0 - 服务器出错：内部服务器出错");
//        msgMap.put("1005", "[服务器]运行时异常");
//        msgMap.put("1006", "[服务器]空值异常");
//        msgMap.put("1007", "[服务器]数据类型转换异常");
//        msgMap.put("1008", "[服务器]IO异常");
//        msgMap.put("1009", "[服务器]未知方法异常");
//        msgMap.put("1010", "[服务器]数组越界异常");
//        msgMap.put("1011", "[服务器]网络异常");
//    }

    public Response() {

    }

    public  void success() {


    }

    public  void success(String msg) {

        this.setmsg(msg);

    }

    public  void success(String msg,int code) {

        this.setCode(code);
        this.setmsg(msg);

    }

//    public  void error(int code) {
//
//        this.setCode(code);
//        this.setmsg(msgMap.get(String.valueOf(code)));
//
//    }

    public  void fail(String msg) {

        this.setCode(-1);
        this.setmsg(msg);

    }

    public  void fail(String msg, int code) {

        this.setCode(code);
        this.setmsg(msg);

    }

    public Response put(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Response putAll(Map<String, ?> map) {
        Iterator i$ = map.keySet().iterator();

        while(i$.hasNext()) {
            String key = (String)i$.next();
            Object value = map.get(key);
            if(value != null) {
                this.put(key, value);
            }
        }
        return this;
    }
    public boolean isEmpty() {
        return this.data == null || this.data.isEmpty();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
