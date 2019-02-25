package cn.test.lms.service.impl;

import cn.test.lms.bean.*;
import cn.test.lms.dao.TbReaderMapper;
import cn.test.lms.service.ReaderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private TbReaderMapper mapper;

    @Override
    public Result addReader(TbReader reader) {
        //补全数据
        reader.setRegisterDate(new Date());
        reader.setBorrowTime(0);
        reader.setStatus("激活");
        int i = mapper.insert(reader);
        if (i>0)return Result.ok();
        return new Result(100,"添加失败");
    }

    @Override
    public EasyUIDataGridResult getReaderList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        TbReaderExample example = new TbReaderExample();
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        //执行条件查询
        List<TbReader> list = mapper.selectByExample(example);
        PageInfo<TbReader> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回数据
        return result;
    }

    @Override
    public Result delReader(Integer[] ids) {
        for (Integer id:ids) {
            int i = mapper.deleteByPrimaryKey(id);
            if (i<=0){
                return new Result(100,"删除失败");
            }
        }
        return Result.ok();

    }

    @Override
    public Result savelReader(TbReader reader) {
        int rows = mapper.updateByPrimaryKeySelective(reader);
        if (rows>0)return Result.ok();
        return new Result(100,"修改失败");
    }

    @Override
    public EasyUIDataGridResult searchlReader(String reader_college, String reader_grade, String reader_status) {
        TbReaderExample example = new TbReaderExample();
        TbReaderExample.Criteria criteria = example.createCriteria();
        if (reader_college!=""&&reader_college!=null){
            criteria.andCollegeEqualTo(reader_college);
        }
        if (reader_grade!=""&&reader_grade!=null){
            criteria.andGradeEqualTo(Integer.parseInt(reader_grade));
        }
        if (reader_status!=""&&reader_status!=null){
            criteria.andStatusEqualTo(reader_status);
        }
        List<TbReader> list = mapper.selectByExample(example);
        PageInfo<TbReader> info =new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        return result;
    }

    @Override
    public TbReader searchByGrade(String grade) {
        if (grade!=null&&grade!=""){
            TbReaderExample example = new TbReaderExample();
            TbReaderExample.Criteria criteria = example.createCriteria();
            criteria.andGradeEqualTo(Integer.parseInt(grade));
            List<TbReader> list = mapper.selectByExample(example);
            for (TbReader reader:list
                 ) {
                return reader;
            }

        }
        return null;

    }

    @Override
    public EasyUIDataGridResult getReaderRankingList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        TbReaderExample example = new TbReaderExample();
        example.setOrderByClause("borrow_time DESC ,id DESC");
        List<TbReader> list = mapper.selectByExample(example);
        PageInfo<TbReader> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }
}
