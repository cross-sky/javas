package sherry.web;

import org.springframework.web.bind.annotation.*;
import sherry.domain.User;

import java.util.*;

/**
 * Created by Crossing on 2017-7-7.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(userMap.values());
        return r;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userMap.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        userMap.put(id, user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userMap.remove(id);
        return "success";
    }
}
