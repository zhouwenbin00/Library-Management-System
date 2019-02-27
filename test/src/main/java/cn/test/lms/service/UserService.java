package cn.test.lms.service;

import cn.test.lms.bean.EasyUIDataGridResult;
import cn.test.lms.bean.Result;
import cn.test.lms.bean.TbUser;

public interface UserService {
    EasyUIDataGridResult getUserList(Integer page, Integer rows);

    Result saveUser(TbUser user);

    TbUser login(String username, String password);
}
