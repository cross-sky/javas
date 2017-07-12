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
}
