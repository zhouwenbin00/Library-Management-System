package cn.test.lms.service.impl;

import cn.test.lms.bean.*;
import cn.test.lms.dao.TbUserMapper;
import cn.test.lms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper mapper;
    @Override
    public EasyUIDataGridResult getUserList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        //执行条件查询
        TbUserExample example = new TbUserExample();
        List<TbUser> list = mapper.selectByExample(example);
        PageInfo<TbUser> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }

    @Override
    public Result saveUser(TbUser user) {
        if (user.getId()==null){
            int i = mapper.insertSelective(user);
            if (i>0)return Result.ok();
        }else {
            int rows = mapper.updateByPrimaryKeySelective(user);
            if (rows>0)return Result.ok();
        }

        return new Result(100,"修改失败");
    }

    @Override
    public TbUser login(String username, String password) {
//        System.out.println(username+password);
        TbUserExample example = new TbUserExample();
        if (username!=null&&password!=null){
            example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
            List<TbUser> list = mapper.selectByExample(example);
            System.out.println();
            if (list!=null&&!list.isEmpty()){
                TbUser user = list.get(0);
                return user;
            }
        }
        return null;
    }
}
