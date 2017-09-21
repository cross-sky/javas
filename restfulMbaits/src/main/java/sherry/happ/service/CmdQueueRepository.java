package sherry.happ.service;

import sherry.datapoint.pojo.CmdQueue;

import java.util.List;

/**
 * Created by Crossing on 2017-7-24.
 */
public interface CmdQueueRepository {
    List<CmdQueue> select(String key, Integer id);

    int update(CmdQueue cmdQueue);
}
