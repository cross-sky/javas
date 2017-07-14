package sherry.happ.service;

import sherry.happ.entity.DeviceHot;

import java.util.List;

/**
 * Created by Crossing on 2017-7-12.
 */
public interface DeviceRepository {
    List<DeviceHot> findAll();

    DeviceHot save(DeviceHot deviceHot);

    DeviceHot findDevice(Long id);

    Long deleteDevice(Long id);

    DeviceHot updateDevice(DeviceHot deviceHot);


}
