package cn.test.lms.controller;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbBook;
import cn.test.lms.bean.TbReader;
import cn.test.lms.service.ReaderService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReaderController {
    @Autowired
    private ReaderService service;

    //添加读者
    @RequestMapping(value = "reader/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addReader(TbReader reader){
        return service.addReader(reader);
    }

    //获取读者列表
    @RequestMapping(value = "reader/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getReaderList(Integer page, Integer rows){
        return service.getReaderList(page,rows);
    }

    //删除读者
    @RequestMapping(value = "reader/del",method = RequestMethod.POST)
    @ResponseBody
    public Result delReader(Integer[] ids){
        return service.delReader(ids);
    }

    //修改读者
    @RequestMapping(value = "reader/save",method = RequestMethod.POST)
    @ResponseBody
    public Result savelReader( String json){
        //将字符串转为json对象
        JSONObject parse = (JSONObject) JSONObject.parse(json);
        //将json对象转javaBean对象
        TbReader reader= JSONObject.toJavaObject(parse,TbReader.class);
        return service.savelReader(reader);
    }

    //条件查询列表数据
    @RequestMapping(value = "reader/search",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult searchlReader( String reader_college,String reader_grade ,String reader_status){
        return service.searchlReader(reader_college,reader_grade,reader_status);
    }

    //通过学号查询
    @RequestMapping(value = "reader/searchByGrade",method = RequestMethod.POST)
    @ResponseBody
    public TbReader searchByGrade(String grade){
        return service.searchByGrade(grade);
    }

 @RequestMapping(value = "reader/ranking",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getReaderRankingList(Integer page, Integer rows){
        return service.getReaderRankingList(page,rows);
    }

}
