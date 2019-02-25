package cn.test.lms.service.impl;

import cn.test.lms.bean.*;
import cn.test.lms.dao.TbBookMapper;
import cn.test.lms.dao.TbReaderMapper;
import cn.test.lms.dao.TbRecordMapper;
import cn.test.lms.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private TbRecordMapper mapper;

    @Autowired
    private TbReaderMapper readerMapper;

    @Autowired
    private TbBookMapper bookMapper;

    @Transactional
    @Override
    public Result addRecord(String book_code, String grade, String bookName, String readerName) {
        TbReaderExample readerExample  = new  TbReaderExample();
        readerExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade));
        List<TbReader> readers = readerMapper.selectByExample(readerExample);
        TbReader reader = readers.get(0);
        reader.setBorrowTime(reader.getBorrowTime()+1);

        TbBookExample bookExample = new TbBookExample();
        bookExample.createCriteria().andBookCodeEqualTo(book_code);
        List<TbBook> list1 = bookMapper.selectByExample(bookExample);
        TbBook book = list1.get(0);
        book.setBorrowTime(book.getBorrowTime()+1);

        TbRecord tbRecord = new TbRecord();
        tbRecord.setBookName(bookName);
        tbRecord.setBookNum(book_code);
        tbRecord.setBorrowDate(new Date());
        tbRecord.setGrade(Integer.parseInt(grade));
        tbRecord.setBorrowsDays(30);
        tbRecord.setStatus("未还");
        tbRecord.setReaderName(readerName);
        tbRecord.setRent(1.0);
        int i = mapper.insertSelective(tbRecord);
        if (i>0){
            readerMapper.updateByPrimaryKeySelective(reader);
            bookMapper.updateByPrimaryKeySelective(book);
            TbRecord record = mapper.selectByPrimaryKey(tbRecord.getId());
             List<TbRecord> list=new ArrayList();
             list.add(record);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(list);
            result.setTotal(1);
            return Result.ok().addData("result",result);
        }
        return new Result(100,"添加失败");

    }

    @Override
    public EasyUIDataGridResult getRecordList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        TbRecordExample example = new TbRecordExample();
        // 设置pageHelper
        PageHelper.startPage(page,rows);
        //执行条件查询
        List<TbRecord> list = mapper.selectByExample(example);
        PageInfo<TbRecord> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }

    @Override
    public EasyUIDataGridResult getOverRecordList(Integer page, Integer rows) {
        //判断非空
        if (page ==null)page = 1;
        if (rows == null)rows  = 10;
        //获取今天
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        Date lastDate = now.getTime();
//        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
//        System.out.println(endDate);
        TbRecordExample example = new TbRecordExample();
        example.createCriteria().andBorrowDateLessThan(lastDate).andStatusNotLike("已还");
        List<TbRecord> list = mapper.selectByExample(example);
        PageInfo<TbRecord> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }

    @Override
    public EasyUIDataGridResult searchOverRecord(String bookName, String readerName) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        Date lastDate = now.getTime();
        TbRecordExample example = new TbRecordExample();
        if (bookName!=null&&bookName!=""){example.createCriteria().andBookNameLike("%"+bookName+"%");}
        if (readerName!=null&&readerName!=""){example.createCriteria().andReaderNameLike("%"+readerName+"%");}
        example.createCriteria().andBorrowDateLessThan(lastDate).andStatusNotLike("已还");
        List<TbRecord> list = mapper.selectByExample(example);
        PageInfo<TbRecord> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }

    @Override
    public EasyUIDataGridResult searchRecordByGrade(String grade) {
        TbRecordExample example = new TbRecordExample();
        if (grade!=null&&grade!=""){
            example.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andStatusEqualTo("未还");
        }
        List<TbRecord> list = mapper.selectByExample(example);
        PageInfo<TbRecord> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }

    @Transactional
    @Override
    public Result returnBook(Integer id) {
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        TbRecord record = mapper.selectByPrimaryKey(id);
        Date borrowDate = record.getBorrowDate();
        Date today = new Date();
        Integer days=Integer.parseInt(String.valueOf((today.getTime()-borrowDate.getTime())/(24*60*60*1000)));
        Integer overday = days-30;
        if (overday<0){
            overday=0;
        }
        record.setReturnDate(today);
        record.setStatus("已还");
        record.setOverDays(overday);
        record.setOverRent(overday*0.1);
        int i = mapper.updateByPrimaryKeySelective(record);
        if (i>0){
            TbReaderExample readerExample = new TbReaderExample();
            readerExample.createCriteria().andGradeEqualTo(record.getGrade());
            List<TbReader> list = readerMapper.selectByExample(readerExample);
            TbReader reader = list.get(0);
            reader.setBalance(reader.getBalance()-1-overday*0.1);
            int j = readerMapper.updateByPrimaryKeySelective(reader);
            if (j>0){
                return Result.ok();
            }
        }
        return null;
    }

    @Override
    public EasyUIDataGridResult searchRecord(String bookName,String readerName) {
        TbRecordExample example = new TbRecordExample();
        if (bookName!=null&&bookName!=""){example.createCriteria().andBookNameLike("%"+bookName+"%");}
        if (readerName!=null&&readerName!=""){example.createCriteria().andReaderNameLike("%"+readerName+"%");}
        List<TbRecord> list = mapper.selectByExample(example);
        PageInfo<TbRecord> info = new PageInfo<>(list);
        //封装数据
        EasyUIDataGridResult result = new EasyUIDataGridResult();
//        result.setRows(list);
        result.setRows(info.getList());
        result.setTotal((int)info.getTotal());
        // 返回*数据
        return result;
    }
}
