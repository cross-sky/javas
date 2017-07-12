package sherry.happ.service;

import sherry.happ.entity.DeviceHot;

import java.util.HashMap;
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

        Long id = counter.incrementAndGet();
        DeviceHot deviceHot = new DeviceHot();
        deviceHot.setId(id);
        deviceHot.setTemper(45);
        deviceHot.setText("first text");
        deviceHot.setMode(1);
        deviceHots.put(id, deviceHot);
    }


    @Override
    public Iterable<DeviceHot> findAll() {
        return this.deviceHots.values();
    }

    @Override
    public DeviceHot save(DeviceHot deviceHot) {
        Long id = deviceHot.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            deviceHot.setId(id);
        }
        this.deviceHots.put(id, deviceHot);
        return deviceHot;
    }

    @Override
    public DeviceHot findDevice(Long id) {
        return this.deviceHots.get(id);
    }

    @Override
    public void deleteDevice(Long id) {
        this.deviceHots.remove(id);
    }
}
