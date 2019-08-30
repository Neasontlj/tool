package wxTools.tools;

import java.math.BigDecimal;
import java.text.*;
import java.util.Calendar;
import java.util.Date;


public class FormatUtil {
    public static String getDateTime(String format) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(cal.getTime());
    }

    public static String format(Date date,String type) {
        DateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }

    public static String format(Date date) {
        return format(date,"yyyy-MM-dd");
    }

    public static String formatDataTime(Date date) {
        return format(date,"yyyy-MM-dd HH:mm:ss");
    }

    public static String format(double value,String type) {
        NumberFormat format = new DecimalFormat(type);
        return format.format(value);
    }

    public static String format(BigDecimal value,String type) {
        DecimalFormat format = new DecimalFormat(type);
        return format.format(value);
    }

    public static String format(BigDecimal value) {
        return format(value,"#,##0.00");
    }

    public static String format(double value) {
        return format(value,"#,##0.00");
    }

    public static String format(long value,String type) {
        NumberFormat format = new DecimalFormat(type);
        return format.format(value);
    }

    public static String format(long value) {
        return format(value,"#,###");
    }

    public static String formatCash(String src,int letterNum) {
        src = src.trim();
        String result = "";
        if (src.length() > letterNum) {
            return src.substring((src.length() - letterNum));
        } else {
            while (result.length() < (letterNum - src.length())) {
                result += "0";
            }
            result += src;
            return result;
        }
    }


    public static Date parse(String str) {
        return parse(str,"yyyy-MM-dd HH:mm:ss");
    }

    public static Date parse(String str,String dateType) {
        DateFormat format = new SimpleDateFormat(dateType);
        try {
            return format.parse(str);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String formatDateTime(String str) {
        return formatDataTime(parse(str));
    }
    
    //对日期增加天数
    public static String addDate(String payTime,int day)throws ParseException{
    	DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = fmt.parse(payTime);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE, day);
    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
    }
}
