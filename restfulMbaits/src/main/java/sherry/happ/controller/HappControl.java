package sherry.happ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sherry.happ.entity.DeviceHot;
import sherry.happ.service.DeviceRepository;
import sherry.happ.service.DeviceRepositoryImpl;


/**
 * Created by Crossing on 2017-7-11.
 */
@Controller
@RequestMapping(value = "/happ")
public class HappControl {

    private final DeviceRepository deviceRepository;

    public HappControl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/iot")
    public ModelAndView nodeSet() {
        return new ModelAndView("/iiot");
    }

    @RequestMapping(value = "/blank")
    public ModelAndView nodeBland() {
        return new ModelAndView("/blank");
    }

    @RequestMapping("/disp1")
    public ModelAndView dispNode1() {
        return new ModelAndView("/disp1");
    }

    @GetMapping()
    public ModelAndView list() {
        Iterable<DeviceHot> deviceHots = this.deviceRepository.findAll();
        return new ModelAndView("device/list", "devices", deviceHots);
    }


}
