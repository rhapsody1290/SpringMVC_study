package cn.apeius.springmvc.controller;

import org.apache.commons.logging.Log;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 2016/9/1.
 */
public class Hello implements Controller{

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        //设置试图名称
//        mv.setViewName("hello");
//        mv.addObject("msg","这是第一个springmvc程序");

        return new ModelAndView("hello","msg","这是第一个springmvc程序");
    }
}
