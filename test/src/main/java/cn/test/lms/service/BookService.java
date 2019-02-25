package cn.test.lms.service;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbBook;

public interface BookService {
    //添加图书
    Result addBook(TbBook book);

    //获取图书列表
    EasyUIDataGridResult getBookList(Integer page, Integer rows);

    Result delBook(Integer[] ids);

    Result savelBook(TbBook book);

    EasyUIDataGridResult searchlBook(String keyWord, String book_category, String book_press, String book_position);

    TbBook searchByBookCode(String book_code);

    EasyUIDataGridResult getBookRankingList(Integer page, Integer rows);
}
