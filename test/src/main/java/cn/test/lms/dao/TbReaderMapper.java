package cn.test.lms.dao;

import cn.test.lms.bean.TbReader;
import cn.test.lms.bean.TbReaderExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbReaderMapper {
    long countByExample(TbReaderExample example);

    int deleteByExample(TbReaderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbReader record);

    int insertSelective(TbReader record);

    List<TbReader> selectByExample(TbReaderExample example);

    TbReader selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbReader record, @Param("example") TbReaderExample example);

    int updateByExample(@Param("record") TbReader record, @Param("example") TbReaderExample example);

    int updateByPrimaryKeySelective(TbReader record);

    int updateByPrimaryKey(TbReader record);
}