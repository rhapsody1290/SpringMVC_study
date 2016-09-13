package cn.apeius.springmvc.controller;

import cn.apeius.springmvc.pojo.User;
import cn.apeius.springmvc.pojo.UserForm;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/test6",params = "userId")
    public ModelAndView test6(@RequestParam(value="userId") String userId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","限定请求参数，必须要有Userid这个信息；userid：" + userId);
        return mv;
    }

    @RequestMapping(value = "/test7")
    public ModelAndView test7(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","Servlet中的对象");
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return mv;
    }

    /**
     * required：必须要有这个参数
     * defautlValue：默认值，如果defaultValue设置了值，那么required失效
     * @param userId
     * @return
     */
    @RequestMapping(value = "/test8")
    public ModelAndView test8(@RequestParam(value = "userId",required = true,defaultValue = "10") String userId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","userId：" + userId);
        return mv;
    }

    @RequestMapping(value = "/test9")
    public ModelAndView test9(@CookieValue("JSESSIONID") String JSESSIONID){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","JESSIONID：" + JSESSIONID);
        return mv;
    }

    @RequestMapping(value = "/test10")
    public ModelAndView test10(User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg",user);
        return mv;
    }

    @RequestMapping(value = "/test11")
    public ModelAndView test11(UserForm userForm){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","List集合");

        for(User user : userForm.getUsers()){
            System.out.println(user);
        }

        return mv;
    }

    @RequestMapping(value="/test12")
    public ModelAndView test12(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userList");
        List<User> userList = new ArrayList<User>();
        for(int i = 0 ; i < 3 ; i ++){
            User user = new User();
            user.setUserName("user_name"+i);
            user.setPassword("123456");
            userList.add(user);
        }
        mv.addObject("userList", userList);
        return mv;
    }

    @RequestMapping(value="/test13")
    @ResponseBody
    public List<User> test13(){
        List<User> userList = new ArrayList<User>();

        for(int i = 0 ; i < 3 ; i ++){
            User user = new User();
            user.setUserName("user_name"+i);
            user.setPassword("123456");
            userList.add(user);
        }

        return userList;
    }

    @RequestMapping(value="/test14")
    @ResponseBody
    public User test14(){
        User user = new User();
        user.setUserName("user_name");
        user.setPassword("123456");
        return user;
    }

    @RequestMapping(value="/test15")
    @ResponseStatus(value= HttpStatus.OK)
    public void test15(@RequestBody User user){
        System.out.println(user);
    }

    @RequestMapping(value="/test16")
    @ResponseStatus(value= HttpStatus.OK)
    public void test16(@RequestBody List<User> users){
        for(User user : users){
            System.out.println(user);
        }
    }

    @RequestMapping(value="/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile)
            throws Exception {
        if (multipartFile != null) {
            // multipartFile.getOriginalFilename() 获取文件的原始名称
            multipartFile.transferTo(new File("d:\\tmp\\" + multipartFile.getOriginalFilename()));
        }
        return "redirect:/success.html";

    }

    @RequestMapping(value="/uploadMultipartFile")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] multipartFiles)
            throws Exception {
        for(MultipartFile multipartFile : multipartFiles){
            if (multipartFile != null) {
                // multipartFile.getOriginalFilename() 获取文件的原始名称
                multipartFile.transferTo(new File("d:\\tmp\\" + multipartFile.getOriginalFilename()));
            }
        }

        return "redirect:/success.html";

    }

    @RequestMapping(value = "/test17")
    public String test17(){
        System.out.println("17");
        return "forward:/test18.do";
    }

    @RequestMapping(value = "/test18")
    public ModelAndView test18(){
        System.out.println("18");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "测试转发");
        return mv;
    }

    @RequestMapping(value = "test19")
    public String test19(){
        System.out.println("19");
        return "redirect:/success.html";
    }

    @RequestMapping(value="/test20")
    public ModelAndView test20(Model model){
        model.addAttribute("msg","test20");
        return new ModelAndView("hello","msg","sfddf");
    }
}
