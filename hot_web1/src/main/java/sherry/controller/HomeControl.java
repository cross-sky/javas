package sherry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Crossing on 2017-9-20.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeControl {

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping(value = "/run_water")
    public ModelAndView run_water() {
        return new ModelAndView("/run-water");
    }

    @RequestMapping(value = "/run_hot")
    public ModelAndView run_hot() {
        return new ModelAndView("/run-hot");
    }

    @RequestMapping(value = "/run_sun")
    public ModelAndView run_sun() {
        return new ModelAndView("/run-sun");
    }

    @RequestMapping(value = "/run_room")
    public ModelAndView run_room() {
        return new ModelAndView("/run-room");
    }

    @RequestMapping(value = "/run_machine")
    public ModelAndView run_machine() {
        return new ModelAndView("/run-machine");
    }

    @RequestMapping(value = "/setting")
    public ModelAndView setting() {
        return new ModelAndView("/setting");
    }

    @RequestMapping(value = "/chart")
    public ModelAndView chart() {
        return new ModelAndView("/chart");
    }
}
