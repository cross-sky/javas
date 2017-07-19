package sherry.entity;

/**
 * Created by Crossing on 2017-7-18.
 */
public class PageTb {
    private int limit;
    private int offset;
   // private int did;

    private Long did;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }
}
