package cn.test.lms.dao;

import cn.test.lms.bean.TbAuthority;
import cn.test.lms.bean.TbAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAuthorityMapper {
    long countByExample(TbAuthorityExample example);

    int deleteByExample(TbAuthorityExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TbAuthority record);

    int insertSelective(TbAuthority record);

    List<TbAuthority> selectByExample(TbAuthorityExample example);

    TbAuthority selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TbAuthority record, @Param("example") TbAuthorityExample example);

    int updateByExample(@Param("record") TbAuthority record, @Param("example") TbAuthorityExample example);

    int updateByPrimaryKeySelective(TbAuthority record);

    int updateByPrimaryKey(TbAuthority record);
}