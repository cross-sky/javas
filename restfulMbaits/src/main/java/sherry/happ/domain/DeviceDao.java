package sherry.happ.domain;

import org.apache.ibatis.annotations.Mapper;
import sherry.happ.entity.DeviceHot;

import java.util.List;

/**
 * Created by Crossing on 2017-7-14.
 */
@Mapper
public interface DeviceDao {
    List<DeviceHot> findAll();

    Long saveDevice(DeviceHot deviceHot);

    DeviceHot findDevice(Long id);

    Long deleteDevice(Long id);

    Long updateDevice(DeviceHot deviceHot);
}
