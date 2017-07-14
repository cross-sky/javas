package sherry.datapoint.mapper;

import sherry.datapoint.domain.DataPointDao;

public interface DataPointDaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataPointDao record);

    int insertSelective(DataPointDao record);

    DataPointDao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataPointDao record);

    int updateByPrimaryKey(DataPointDao record);
}