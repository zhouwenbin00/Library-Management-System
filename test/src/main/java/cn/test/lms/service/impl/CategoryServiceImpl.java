package cn.test.lms.service.impl;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbCategory;
import cn.test.lms.bean.TbCategoryExample;
import cn.test.lms.dao.TbCategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements cn.test.lms.service.CategoryService {
    @Autowired
    private TbCategoryMapper mapper;

    //添加分类
    @Override
    public Result addCategory(String category) {
        TbCategory tbCategory=new TbCategory();
        tbCategory.setCategory(category);
        int rows = mapper.insertSelective(tbCategory);
        if (rows>0){
            return Result.ok();
        }else {
            return new Result(100,"添加失败");
        }
    }

    //内容列表
    @Override
    public EasyUIDataGridResult getCategoryList(Integer page, Integer rows) {
         //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        TbCategoryExample example = new TbCategoryExample();
       // 设置pageHelper
        PageHelper.startPage(page,rows);
        //执行条件查询
        List<TbCategory> list = mapper.selectByExample(example);
        PageInfo<TbCategory> info = new PageInfo<>(list);
         //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
       // 返回*数据
        return result;
    }

    @Override
    @Transactional
    public Result delCategory(Integer[] ids) {
        for (Integer id:ids) {
            int i = mapper.deleteByPrimaryKey(id);
            if (i<=0){
                return new Result(100,"删除失败");
            }
        }
//        int i = mapper.deleteByPrimaryKey(id);
//        if (i<=0)return new Result(100,"删除失败");
        return Result.ok();
    }
}
