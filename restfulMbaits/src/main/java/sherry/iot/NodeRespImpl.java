package sherry.iot;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crossing on 2017-7-5.
 */
@Repository
public class NodeRespImpl implements NodeResp {
    private Map<Long, Node> nodeMaps = new HashMap<Long, Node>();

    public NodeRespImpl() {
        nodeMaps.put(1L, new Node(1L, 0));
        nodeMaps.put(2L, new Node(2L, 1));
    }

    @Override
    public Node findNode(Long id) {
        return nodeMaps.get(id);
    }

    @Override
    public Node updateNode(Long id, Node node) {
        if (nodeMaps.containsKey(id)) {
            nodeMaps.put(id, node);
        }
        return nodeMaps.get(id);
    }
}
