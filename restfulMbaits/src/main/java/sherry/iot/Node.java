package sherry.iot;

/**
 * Created by Crossing on 2017-7-5.
 */
public class Node {
    private Long id;
    private int value;

    public Node(Long id, int value) {
        this.id = id;
        this.value = value;
    }

    public Node() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
