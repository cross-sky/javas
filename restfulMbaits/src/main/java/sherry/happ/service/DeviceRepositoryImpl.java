package sherry.happ.service;

import sherry.happ.entity.DeviceHot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Crossing on 2017-7-12.
 */
public class DeviceRepositoryImpl implements DeviceRepository {

    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, DeviceHot> deviceHots = new ConcurrentHashMap<Long, DeviceHot>();
    private final Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(1, "HotMode");
        map.put(2, "ColdMode");
        map.put(3, "WaterMode");
    }

    {
        Long id = counter.incrementAndGet();
        DeviceHot deviceHot = new DeviceHot();
        deviceHot.setId(id);
        deviceHot.setTemper(45);
        deviceHot.setText("first text");
        deviceHot.setMode(2);
        deviceHot.setStatus(0);
        deviceHot.setModeStr(map.get(deviceHot.getMode()));
        deviceHots.put(id, deviceHot);
    }


    @Override
    public List<DeviceHot> findAll() {
        return null;
        //return this.deviceHots.values();
    }

    @Override
    public DeviceHot save(DeviceHot deviceHot) {
        Long id = deviceHot.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            deviceHot.setId(id);
        }
        this.deviceHots.put(id, deviceHot);
        deviceHot.setModeStr(map.get(deviceHot.getMode()));
        return deviceHot;
    }

    @Override
    public DeviceHot findDevice(Long id) {
        return this.deviceHots.get(id);
    }

    @Override
    public Long deleteDevice(Long id) {
        this.deviceHots.remove(id);
        return id;
    }

    @Override
    public DeviceHot updateDevice(DeviceHot deviceHot) {
        this.deviceHots.put(deviceHot.getId(), deviceHot);
        deviceHot.setModeStr(map.get(deviceHot.getMode()));
        return deviceHot;
    }


}
