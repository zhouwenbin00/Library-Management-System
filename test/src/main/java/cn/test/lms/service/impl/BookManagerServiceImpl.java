package cn.test.lms.service.impl;

import cn.test.lms.bean.TbBook;
import cn.test.lms.dao.TbBookMapper;
import cn.test.lms.service.BookManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookManagerServiceImpl implements BookManagerService {
    @Autowired
    private TbBookMapper mapper;

    @Override
    public void addBook(TbBook book) {
        mapper.insertSelective(book);
    }
}
