package sherry.datapoint.pojo;

public class CmdQueue {
    private Integer id;

    private Integer deviceId;

    private String deviceKey;

    private Integer readCmd;

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

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }

    public Integer getReadCmd() {
        return readCmd;
    }

    public void setReadCmd(Integer readCmd) {
        this.readCmd = readCmd;
    }
}