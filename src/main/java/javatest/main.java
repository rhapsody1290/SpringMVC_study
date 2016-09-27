package javatest;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Asus on 2016/9/22.
 */
public class main {
    public static void main(String[] args){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MyResources", Locale.SIMPLIFIED_CHINESE);
        System.out.println(resourceBundle.getString("greetings"));

        resourceBundle = ResourceBundle.getBundle("MyResources", Locale.US);
        System.out.println(resourceBundle.getString("greetings"));
    }
}
