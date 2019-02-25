package cn.test.lms.service;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;

public interface RecordService {
    public Result addRecord(String book_code, String grade, String bookName, String readerName);

    EasyUIDataGridResult getRecordList(Integer page, Integer rows);

    EasyUIDataGridResult getOverRecordList(Integer page, Integer rows);

    EasyUIDataGridResult searchRecord(String bookName,String readerName);

    EasyUIDataGridResult searchOverRecord(String bookName, String readerName);

    EasyUIDataGridResult searchRecordByGrade(String grade);

    Result returnBook(Integer id);
}
