package sherry.datapoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sherry.datapoint.pojo.DataPoint;
import sherry.datapoint.pojo.DataPointExample;

@Mapper
public interface DataPointMapper {
    long countByExample(DataPointExample example);

    int deleteByExample(DataPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataPoint record);

    int insertSelective(DataPoint record);

    List<DataPoint> selectByExample(DataPointExample example);

    DataPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataPoint record, @Param("example") DataPointExample example);

    int updateByExample(@Param("record") DataPoint record, @Param("example") DataPointExample example);

    int updateByPrimaryKeySelective(DataPoint record);

    int updateByPrimaryKey(DataPoint record);
}