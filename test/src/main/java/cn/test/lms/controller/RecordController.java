package cn.test.lms.controller;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecordController {
    @Autowired
    private RecordService service;

    @RequestMapping(value = "record/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addRecord(String book_code,String grade,String bookName,String readerName){
        return service.addRecord(book_code,grade,bookName,readerName);
    }

    @RequestMapping(value = "record/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getRecordList(Integer page, Integer rows){
        return service.getRecordList(page,rows);
    }

    @RequestMapping(value = "over_record/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getOverRecordList(Integer page, Integer rows){
        return service.getOverRecordList(page,rows);
    }

    @RequestMapping(value = "record/search",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult searchRecord(String bookName,String readerName){
        return service.searchRecord(bookName,readerName);
    }

    @RequestMapping(value = "over_record/search",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult searchOverRecord(String bookName,String readerName){
        return service.searchOverRecord(bookName,readerName);
    }
    @RequestMapping(value = "record/searchByGrade",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult searchRecordByGrade(String grade){
        return service.searchRecordByGrade(grade);
    }
  @RequestMapping(value = "record/return_book",method = RequestMethod.POST)
    @ResponseBody
    public Result returnBook(Integer id){
        return service.returnBook(id);
    }


}
