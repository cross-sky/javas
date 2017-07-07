package sherry.web;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sherry.iot.Node;
import sherry.iot.NodeResp;

/**
 * Created by Crossing on 2017-7-5.
 */
@Controller
@RequestMapping("/iot")
@ExposesResourceFor(Node.class)
public class NodeController {
    private final NodeResp nodeResp;

    public NodeController(NodeResp nodeResp) {
        this.nodeResp = nodeResp;
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource<Node>> getNode(@PathVariable Long id) {
        Resource<Node> resource = new Resource<Node>(this.nodeResp.findNode(id));
        return new ResponseEntity<Resource<Node>>(resource, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    HttpEntity<Resource<Node>> updateNode(@PathVariable Long id, @RequestBody Node node) {
        Resource<Node> resource = new Resource<Node>(this.nodeResp.updateNode(id, node));
        return new ResponseEntity<Resource<Node>>(resource, HttpStatus.OK);
    }


}
