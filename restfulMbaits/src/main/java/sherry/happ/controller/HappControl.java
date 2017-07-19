package sherry.happ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sherry.entity.PageTb;
import sherry.entity.RspDpTb;
import sherry.entity.RspTb;
import sherry.happ.entity.DeviceHot;
import sherry.happ.service.DatapointRepository;
import sherry.happ.service.DeviceRepository;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Crossing on 2017-7-11.
 */
@Controller
@RequestMapping(value = "/happ")
public class HappControl {

    private final DeviceRepository deviceRepository;

    @Autowired
    private DatapointRepository datapointRepository;

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

    @GetMapping("/list_device_data/{id}")
    public ModelAndView view_data(@PathVariable("id") Long id) {
        return new ModelAndView("/device/list_data", "device_id", id);
    }

    @ResponseBody
    @RequestMapping(value = "/list_device_data/list_b_js")
    public RspDpTb list_device_data(@RequestBody PageTb pageTb) {
        RspDpTb rspTb = new RspDpTb();
        //int id = pageTb.getDid();
        rspTb.setRows(this.datapointRepository.selectById(pageTb.getDid(), pageTb));
        rspTb.setTotal(this.datapointRepository.count(pageTb));
        return rspTb;
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

    @RequestMapping(value = "/list_b")
    public ModelAndView list_b() {
        return new ModelAndView("device/list_b");
    }


    @ResponseBody
    @RequestMapping(value = "/list_b_js")
    public RspTb list_b_js(PageTb pageTb) {
        RspTb rspTb = new RspTb();
        rspTb.setRows(this.deviceRepository.findAll());
        rspTb.setTotal(12);
        return rspTb;
    }


}
