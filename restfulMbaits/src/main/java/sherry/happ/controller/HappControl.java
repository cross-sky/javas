package sherry.happ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sherry.happ.entity.DeviceHot;
import sherry.happ.service.DeviceRepository;
import sherry.happ.service.DeviceRepositoryImpl;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


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

    private final Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(1, "HotMode");
        map.put(2, "ColdMode");
        map.put(3, "WaterMode");
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

    @GetMapping(params = "form")
    public ModelAndView createForm() {
        DeviceHot deviceHot = new DeviceHot();
        deviceHot.setTemper(45);
        deviceHot.setText("first text");
        deviceHot.setMode(1);
        deviceHot.setStatus(0);
        return new ModelAndView("/device/form", "device", deviceHot);
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id")Long id) {
        return new ModelAndView("/device/form", "device", this.deviceRepository.findDevice(id));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modify(DeviceHot deviceHot, RedirectAttributes redirect) {
        if (deviceHot.getStatus() != 1) {
            deviceHot.setStatus(0);
        }
        deviceHot.setModeStr(map.get(deviceHot.getMode()));

        redirect.addFlashAttribute("message", "success saveDevice");

        if (deviceHot.getId() == null) {
            deviceHot = this.deviceRepository.save(deviceHot);
        }else {
            deviceHot = this.deviceRepository.updateDevice(deviceHot);
        }
        ModelAndView mode = new ModelAndView("redirect:/happ/view/{id}");
        mode.addObject("id", deviceHot.getId());
        //mode.addObject("message", "success saveDevice");
        return mode;
    }


}
