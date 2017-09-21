package sherry.datapoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sherry.datapoint.pojo.CmdQueue;
import sherry.datapoint.pojo.CmdQueueExample;

@Mapper
public interface CmdQueueMapper {
    long countByExample(CmdQueueExample example);

    int deleteByExample(CmdQueueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmdQueue record);

    int insertSelective(CmdQueue record);

    List<CmdQueue> selectByExample(CmdQueueExample example);

    CmdQueue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmdQueue record, @Param("example") CmdQueueExample example);

    int updateByExample(@Param("record") CmdQueue record, @Param("example") CmdQueueExample example);

    int updateByPrimaryKeySelective(CmdQueue record);

    int updateByPrimaryKey(CmdQueue record);
}