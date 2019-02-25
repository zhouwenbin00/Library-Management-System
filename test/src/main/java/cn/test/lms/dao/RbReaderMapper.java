package cn.test.lms.dao;

import cn.test.lms.bean.RbReader;
import cn.test.lms.bean.RbReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbReaderMapper {
    long countByExample(RbReaderExample example);

    int deleteByExample(RbReaderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RbReader record);

    int insertSelective(RbReader record);

    List<RbReader> selectByExample(RbReaderExample example);

    RbReader selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RbReader record, @Param("example") RbReaderExample example);

    int updateByExample(@Param("record") RbReader record, @Param("example") RbReaderExample example);

    int updateByPrimaryKeySelective(RbReader record);

    int updateByPrimaryKey(RbReader record);
}