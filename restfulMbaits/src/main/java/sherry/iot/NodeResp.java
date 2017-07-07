package sherry.iot;

/**
 * Created by Crossing on 2017-7-5.
 */
public interface NodeResp {
    Node findNode(Long id);

    Node updateNode(Long id, Node node);
}
