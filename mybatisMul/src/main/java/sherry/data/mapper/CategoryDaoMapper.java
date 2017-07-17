package sherry.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sherry.data.dto.CategoryDto;
import sherry.data.pojo.CategoryDao;
import sherry.data.pojo.CategoryDaoExample;

@Mapper
public interface CategoryDaoMapper {
    long countByExample(CategoryDaoExample example);

    int deleteByExample(CategoryDaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryDao record);

    int insertSelective(CategoryDao record);

    List<CategoryDao> selectByExample(CategoryDaoExample example);

    CategoryDao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryDao record, @Param("example") CategoryDaoExample example);

    int updateByExample(@Param("record") CategoryDao record, @Param("example") CategoryDaoExample example);

    int updateByPrimaryKeySelective(CategoryDao record);

    int updateByPrimaryKey(CategoryDao record);

    CategoryDto getById(int id);
}