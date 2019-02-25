package cn.test.lms.controller;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbBook;
import cn.test.lms.service.BookService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;

@Controller
public class BookController {
    //注入service
    @Autowired
    private BookService service;

    //添加图书
    @RequestMapping(value = "book/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addBook(TbBook book){
        return service.addBook(book);

    }
    //获取图书列表
    @RequestMapping(value = "book/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getBookList(Integer page, Integer rows){
        return service.getBookList(page,rows);
    }

    //删除图书
    @RequestMapping(value = "book/del",method = RequestMethod.POST)
    @ResponseBody
    public Result delBook(Integer[] ids){
        return service.delBook(ids);
    }

    //删除图书
    @RequestMapping(value = "book/save",method = RequestMethod.POST)
    @ResponseBody
    public Result savelBook( String json){
        //将字符串转为json对象
        JSONObject parse = (JSONObject) JSONObject.parse(json);
        //将json对象转javaBean对象
        TbBook book= JSONObject.toJavaObject(parse,TbBook.class);
        return service.savelBook(book);
    }

    //条件查询列表数据
    @RequestMapping(value = "book/search",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult searchlBook( String keyWord,String book_category,String book_press ,String book_position){
        return service.searchlBook(keyWord,book_category,book_press,book_position);
    }
}
