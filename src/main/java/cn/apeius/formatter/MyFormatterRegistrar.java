package cn.apeius.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by Asus on 2016/9/20.
 */
public class MyFormatterRegistrar implements FormatterRegistrar{

    private  String datePattern;

    public MyFormatterRegistrar(String datePattern){
        this.datePattern = datePattern;
    }
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter(datePattern));
        //注册更多的Formatter
    }
}
