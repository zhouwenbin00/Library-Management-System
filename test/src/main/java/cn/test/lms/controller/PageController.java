package cn.test.lms.controller;

import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbUser;
import cn.test.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PageController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("toLogin")
    @ResponseBody
    public Result login(String username , String password, String remember,HttpServletRequest request,HttpServletResponse response) {
        TbUser user = service.login(username, password);
        if (user!=null){
            if (remember.equals("on")){
                String loginInfo = username + "," + password;
                Cookie userCookie = new Cookie("loginInfo",loginInfo);
                userCookie.setMaxAge(7 * 24 * 60 * 60); // 存活期为7天
                userCookie.setPath("/");
                response.addCookie(userCookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return Result.ok();
        }else {
            return new Result(100,"登陆失败");
        }
    }
    @RequestMapping("outLogin")
    @ResponseBody
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        response.sendRedirect("login");
    }

}
