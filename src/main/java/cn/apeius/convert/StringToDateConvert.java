package cn.apeius.convert;


import org.springframework.core.convert.converter.Converter;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Asus on 2016/9/16.
 */
public class StringToDateConvert implements Converter<String,Date> {
    private String datePattern;

    public StringToDateConvert(String datePattern){
        this.datePattern = datePattern;
    }

    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("格式错误");
        }
    }
}
