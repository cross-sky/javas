package sherry.happ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sherry.happ.domain.DeviceDao;
import sherry.happ.entity.DeviceHot;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Crossing on 2017-7-14.
 */
@Service
public class DeviceRepositoryImplMybatis implements DeviceRepository {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public List<DeviceHot> findAll() {
        //List<DeviceHot> list= deviceDao.findAll();
        return deviceDao.findAll();
        //return (Iterable<DeviceHot>) list.iterator();
    }

    @Override
    public DeviceHot save(DeviceHot deviceHot) {
        Long id =  deviceDao.saveDevice(deviceHot);
        return deviceDao.findDevice(id);
    }

    @Override
    public DeviceHot findDevice(Long id) {
        return deviceDao.findDevice(id);
    }

    @Override
    public Long deleteDevice(Long id) {
        return deviceDao.deleteDevice(id);
    }

    @Override
    public DeviceHot updateDevice(DeviceHot deviceHot) {
        deviceDao.updateDevice(deviceHot);
        return deviceHot;
    }

}
