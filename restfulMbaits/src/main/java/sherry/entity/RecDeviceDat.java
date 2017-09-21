package sherry.entity;

import sherry.datapoint.pojo.DataPoint;
import sherry.happ.entity.DeviceHot;

/**
 * Created by Crossing on 2017-7-20.
 */
public class RecDeviceDat {
    private DeviceInfo dInfo;
    private DeviceHot dMode;
    private DataPoint data;
    private String ack;

    public DeviceInfo getdInfo() {
        return dInfo;
    }

    public void setdInfo(DeviceInfo dInfo) {
        this.dInfo = dInfo;
    }

    public DeviceHot getdMode() {
        return dMode;
    }

    public void setdMode(DeviceHot dMode) {
        this.dMode = dMode;
    }

    public DataPoint getData() {
        return data;
    }

    public void setData(DataPoint data) {
        this.data = data;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    @Override
    public String toString() {
        return "RecDeviceDat{" +
                "dInfo=" + dInfo +
                ", dMode=" + dMode +
                ", data=" + data +
                ", ack='" + ack + '\'' +
                '}';
    }
}
