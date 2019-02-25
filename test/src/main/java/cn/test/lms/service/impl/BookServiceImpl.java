package cn.test.lms.service.impl;

import cn.test.lms.bean.*;
import cn.test.lms.dao.TbBookMapper;
import cn.test.lms.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    //注入mapper
    @Autowired
    private TbBookMapper mapper;

    //添加图书
    @Override
    public Result addBook(TbBook book) {
        //补充数据
        book.setBorrowTime(book.getTotalNum());
        book.setRegisterDate(new Date());
        //选择性插入
        int rows = mapper.insertSelective(book);
        if(rows>0){
            //有行改变则成功
            return Result.ok();
        }
        return new Result(100,"添加图书失败！");

    }

    //获取图书列表
    @Override
    public EasyUIDataGridResult getBookList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        TbBookExample example = new TbBookExample();
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        //执行条件查询
        List<TbBook> list = mapper.selectByExample(example);
        PageInfo<TbBook> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回数据
        return result;
    }

    //批量删除图书
    @Override
    public Result delBook(Integer[] ids) {
        for (Integer id:ids) {
            int i = mapper.deleteByPrimaryKey(id);
            if (i<=0){
                return new Result(100,"删除失败");
            }
        }
        return Result.ok();

    }

    @Override
    public Result savelBook(TbBook book) {
        int rows = mapper.updateByPrimaryKeySelective(book);
        if (rows>0)return Result.ok();
        return new Result(100,"修改失败");
    }

    @Override
    public EasyUIDataGridResult searchlBook(String keyWord, String book_category, String book_press, String book_position) {
        if (keyWord=="")keyWord=null;
        if (book_category=="")book_category=null;
        if (book_press=="")book_press=null;
        if (book_position=="")book_position=null;
//        System.out.println(keyWord+"-"+book_category+"-"+book_press+"-"+book_position);
        List<TbBook> list = mapper.selectByCondition(keyWord,book_category,book_press,book_position);
        PageInfo<TbBook> info = new PageInfo(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        return result;
    }

    @Override
    public TbBook searchByBookCode(String book_code) {
        if (book_code!=null&&book_code!=""){
            TbBookExample example = new TbBookExample();
            TbBookExample.Criteria criteria = example.createCriteria();
            criteria.andBookCodeEqualTo(book_code);
            List<TbBook> list = mapper.selectByExample(example);
            for (TbBook book:list
            ) {
                return book;
            }
        }
        return null;
    }

    @Override
    public EasyUIDataGridResult getBookRankingList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        TbBookExample example = new TbBookExample();
        example.setOrderByClause("borrow_time DESC ,id DESC");
        List<TbBook> list = mapper.selectByExample(example);
        PageInfo<TbBook> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }
}
