package cn.test.lms.service.impl;

import cn.test.lms.bean.Book;
import cn.test.lms.dao.BookMapper;
import cn.test.lms.service.BookManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookManagerServiceImpl implements BookManagerService {
    @Autowired
    private BookMapper mapper;

    @Override
    public void addBook(Book book) {
        mapper.insertSelective(book)
    }
}
