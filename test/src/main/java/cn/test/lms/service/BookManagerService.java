package cn.test.lms.service;

import cn.test.lms.bean.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookManagerService {

    /*添加图书*/
    void addBook(Book book);
}
