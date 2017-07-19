package sherry.entity;

import sherry.datapoint.pojo.DataPoint;

import java.util.List;

/**
 * Created by Crossing on 2017-7-19.
 */
public class RspDpTb {
    private List<DataPoint> rows;
    private int total;

    public List<DataPoint> getRows() {
        return rows;
    }

    public void setRows(List<DataPoint> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
