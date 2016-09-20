package cn.apeius.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Asus on 2016/9/19.
 */
public class DateFormatter implements Formatter<Date>{
    private String datePattern;
    private SimpleDateFormat simpleDateFormat;

    public DateFormatter(String datePattern){
        this.datePattern = datePattern;
        simpleDateFormat = new SimpleDateFormat(datePattern);
        simpleDateFormat.setLenient(false);
    }

    public Date parse(String text, Locale locale) throws ParseException {
        return simpleDateFormat.parse(text);
    }

    public String print(Date date, Locale locale) {
        return simpleDateFormat.format(date);
    }
    public static void main(String[] args){
        String a = "abc ".trim();
        System.out.println(a.length());
    }

}
