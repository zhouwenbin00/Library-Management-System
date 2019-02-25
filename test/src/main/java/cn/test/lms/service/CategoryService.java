package cn.test.lms.service;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbCategory;

import java.util.List;

public interface CategoryService {
    //新增分类
    Result addCategory(String category);

    //分类列表
    EasyUIDataGridResult getCategoryList(Integer page, Integer rows);

    //不分页的分类列表
    List<TbCategory> getCategoryList();

    //删除分类
    Result delCategory(Integer[] ids);
}
