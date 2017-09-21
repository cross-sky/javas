package sherry.happ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sherry.datapoint.mapper.DataPointMapper;
import sherry.datapoint.pojo.DataPoint;
import sherry.datapoint.pojo.DataPointExample;
import sherry.entity.PageTb;

import java.util.List;

/**
 * Created by Crossing on 2017-7-19.
 */
@Service
public class DatapointRepositoryImpl implements DatapointRepository {

    @Autowired
    private DataPointMapper mapper;

    @Override
    public List<DataPoint> selectById(Long id, PageTb pageTb) {
        DataPointExample example = new DataPointExample();
        DataPointExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdEqualTo(Integer.parseInt(Long.toString(id)));
        //int offset = (pageTb.getOffset() + 1) * pageTb.getLimit();
        //int offset = pageTb.getOffset()  * pageTb.getLimit();
        example.setOffset(pageTb.getOffset());
        example.setLimit(pageTb.getLimit());
        //System.out.println("offset" + offset + "," + pageTb.getLimit());

        List<DataPoint> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public int saveData(DataPoint dataPoint) {
        return mapper.insert(dataPoint);
    }

    @Override
    public int count(PageTb pageTb) {
        DataPointExample example = new DataPointExample();
        DataPointExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdEqualTo(pageTb.getDid().intValue());
        return ((int) mapper.countByExample(example));
    }
}
