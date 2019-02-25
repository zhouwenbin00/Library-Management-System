package cn.test.lms.controller;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbCategory;
import cn.test.lms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //添加分类
    @RequestMapping(value = "category/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addCategory(String category){
        return categoryService.addCategory(category);
    }

    //分类列表
    @RequestMapping(value = "category/list",method = RequestMethod.POST)
    @ResponseBody
    public EasyUIDataGridResult getCategoryList(Integer page, Integer rows){
        return categoryService.getCategoryList(page,rows);
    }
    //下拉框的分页数据
    @RequestMapping(value = "category/combobox",method = RequestMethod.POST)
    @ResponseBody
    public List<TbCategory> getCategoryList(){
        return categoryService.getCategoryList();
    }
    //删除分类
    @RequestMapping(value = "category/del",method = RequestMethod.POST)
    @ResponseBody
    public Result delCategory(Integer[] ids){
        System.out.println(ids);

        return categoryService.delCategory(ids);
    }
}
