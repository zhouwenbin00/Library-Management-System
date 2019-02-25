package cn.test.lms.dao;

import cn.test.lms.bean.TbBook;
import cn.test.lms.bean.TbBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBookMapper {
    long countByExample(TbBookExample example);

    int deleteByExample(TbBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbBook record);

    int insertSelective(TbBook record);

    List<TbBook> selectByExample(TbBookExample example);

    TbBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbBook record, @Param("example") TbBookExample example);

    int updateByExample(@Param("record") TbBook record, @Param("example") TbBookExample example);

    int updateByPrimaryKeySelective(TbBook record);

    int updateByPrimaryKey(TbBook record);

    List<TbBook> selectByCondition(@Param("keyWord")String keyWord, @Param("book_category")String book_category, @Param("book_press")String book_press, @Param("book_position")String book_position);
}