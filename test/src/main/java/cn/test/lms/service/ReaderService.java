package cn.test.lms.service;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbReader;

import java.util.List;

public interface ReaderService {
    Result addReader(TbReader reader);

    EasyUIDataGridResult getReaderList(Integer page, Integer rows);

    Result delReader(Integer[] ids);

    Result savelReader(TbReader reader);

    EasyUIDataGridResult searchlReader(String reader_college, String reader_grade, String reader_status);

    TbReader searchByGrade(String grade);

    EasyUIDataGridResult getReaderRankingList(Integer page, Integer rows);
}
