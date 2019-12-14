package ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 字符串转日期类
     * @param date
     * @param pattern  日期格式 如"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String dateTostring(Date date,String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        String format = df.format(date);
        return format;
    }


    public static Date stringTodate(String str,String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date date2 = df.parse(str);
        return date2;
    }
}
