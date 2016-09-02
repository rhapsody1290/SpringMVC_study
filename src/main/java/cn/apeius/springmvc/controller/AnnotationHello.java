package cn.apeius.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Asus on 2016/9/2.
 */
@Controller
public class AnnotationHello {

    @RequestMapping(value = "/show1")//可以省略后缀
    public ModelAndView test1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","这是第一个注解程序");
        return mv;
    }

    @RequestMapping("/test/*/show2")
    public ModelAndView test2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","/test/*/show2");
        return mv;
    }

    @RequestMapping("/test/**/show3")
    public ModelAndView test3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","/test/**/show3");
        return mv;
    }

    @RequestMapping("/test/{itemId}/{itemName}")
    public ModelAndView test4(@PathVariable("itemId") String itemId, @PathVariable("itemName") String itemName){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","itemId:" + itemId + " " + "itemName:" + itemName);
        return mv;
    }

    @RequestMapping(value = "test5", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView test5(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","限制只有get请求才能进入");
        return mv;
    }
}
