package sherry.happ.service;

import sherry.happ.entity.DeviceHot;

/**
 * Created by Crossing on 2017-7-12.
 */
public interface DeviceRepository {
    Iterable<DeviceHot> findAll();

    DeviceHot save(DeviceHot deviceHot);

    DeviceHot findDevice(Long id);

    void deleteDevice(Long id);
}
