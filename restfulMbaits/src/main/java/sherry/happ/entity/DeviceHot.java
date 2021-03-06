package sherry.happ.entity;

/**
 * Created by Crossing on 2017-7-12.
 */
public class DeviceHot {
    private Long id;
    private int status;
    private int temper;
    private String text;
    private int mode;
    private String modeStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTemper() {
        return temper;
    }

    public void setTemper(int temper) {
        this.temper = temper;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getModeStr() {
        return modeStr;
    }

    public void setModeStr(String modeStr) {
        this.modeStr = modeStr;
    }

    @Override
    public String toString() {
        return "DeviceHot{" +
                "id=" + id +
                ", status=" + status +
                ", temper=" + temper +
                ", text='" + text + '\'' +
                ", mode=" + mode +
                ", modeStr='" + modeStr + '\'' +
                '}';
    }
}
