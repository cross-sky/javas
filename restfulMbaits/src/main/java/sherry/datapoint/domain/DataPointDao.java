package sherry.datapoint.domain;

public class DataPointDao {
    private Integer id;

    private Integer deviceId;

    private Float waterInT;

    private Float waterOutT;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Float getWaterInT() {
        return waterInT;
    }

    public void setWaterInT(Float waterInT) {
        this.waterInT = waterInT;
    }

    public Float getWaterOutT() {
        return waterOutT;
    }

    public void setWaterOutT(Float waterOutT) {
        this.waterOutT = waterOutT;
    }
}