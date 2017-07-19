package sherry.entity;

import sherry.happ.entity.DeviceHot;

import java.util.List;

/**
 * Created by Crossing on 2017-7-18.
 */
public class RspTb {
    private List<DeviceHot> rows;
    private int total;

    public List<DeviceHot> getRows() {
        return rows;
    }

    public void setRows(List<DeviceHot> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
