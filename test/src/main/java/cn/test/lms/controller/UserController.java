package cn.test.lms.controller;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbUser;
import cn.test.lms.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "user/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getUserList(Integer page, Integer rows){
        return service.getUserList(page,rows);
    }

    //修改图书
    @RequestMapping(value = "user/save",method = RequestMethod.POST)
    @ResponseBody
    public Result saveUser(String json){
        //将字符串转为json对象
        JSONObject parse = (JSONObject) JSONObject.parse(json);
        //将json对象转javaBean对象
        TbUser user= JSONObject.toJavaObject(parse, TbUser.class);
        return service.saveUser(user);
    }
}
