package sherry.happ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sherry.datapoint.mapper.CmdQueueMapper;
import sherry.datapoint.pojo.CmdQueue;
import sherry.datapoint.pojo.CmdQueueExample;

import java.util.List;

/**
 * Created by Crossing on 2017-7-24.
 */
@Service
public class CmdQueueRepositoryImpl implements CmdQueueRepository {

    @Autowired
    private CmdQueueMapper mapper;
    @Override
    public List<CmdQueue> select(String key, Integer id) {
        CmdQueueExample example = new CmdQueueExample();
        CmdQueueExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceKeyEqualTo(key);
        criteria.andDeviceIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public int update(CmdQueue cmdQueue) {
        CmdQueueExample example = new CmdQueueExample();
        CmdQueueExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceKeyEqualTo(cmdQueue.getDeviceKey());
        criteria.andDeviceIdEqualTo(cmdQueue.getDeviceId());

        return mapper.updateByExampleSelective(cmdQueue,example);
    }
}
