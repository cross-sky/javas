package sherry.happ.service;

import sherry.datapoint.pojo.DataPoint;
import sherry.entity.PageTb;

import java.util.List;

/**
 * Created by Crossing on 2017-7-19.
 */
public interface DatapointRepository {
    List<DataPoint> selectById(Long id, PageTb pageTb);

    int saveData(DataPoint dataPoint);

    int count(PageTb pageTb);
}
