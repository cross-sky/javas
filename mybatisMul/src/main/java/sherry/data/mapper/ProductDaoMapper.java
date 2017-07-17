package sherry.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sherry.data.pojo.ProductDao;
import sherry.data.pojo.ProductDaoExample;

@Mapper
public interface ProductDaoMapper {
    long countByExample(ProductDaoExample example);

    int deleteByExample(ProductDaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductDao record);

    int insertSelective(ProductDao record);

    List<ProductDao> selectByExample(ProductDaoExample example);

    ProductDao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDao record, @Param("example") ProductDaoExample example);

    int updateByExample(@Param("record") ProductDao record, @Param("example") ProductDaoExample example);

    int updateByPrimaryKeySelective(ProductDao record);

    int updateByPrimaryKey(ProductDao record);
}