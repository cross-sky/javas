package sherry.happ.controller; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sherry.Application;
import sherry.happ.service.CmdQueueRepository;
import sherry.happ.service.DeviceRepository;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.MockMvc.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HappControl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/20/2017</pre>
 */
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Application.class)

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@WebMvcTest
public class HappControlTest {

    //@Autowired
    private MockMvc mvc;

    @Autowired
    private CmdQueueRepository cmdQueueRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HappControl(deviceRepository, cmdQueueRepository)).build();
        //mvc = MockMvcBuilders.standaloneSetup(new  Application()).build();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    @Rollback(true)
    public void test_rec_device_data() throws Exception {
        //make sure that cmd_que has sets to 1
        RequestBuilder requestBuilder = null;

        requestBuilder = post("/happ/rec_device").contentType(MediaType.APPLICATION_JSON)
                .content("{\"dInfo\":{\"str\":\"cngdzhxz001\",\"id\":1},\"dMode\":{\"id\":1,\"status\":1,\"temper\":24," +
                        "\"mode\":1},\"data\":{\"deviceId\":1,\"waterInT\":33.3,\"waterOutT\":44.4}}");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertThat(result.getResponse().getContentAsString()).contains("set");

        //content().string(equalTo("success"))
        //.andExpect(content().string("success"))
    }

    @Test
    @Rollback(true)
    public void test_rec_device_data_ok() throws Exception {
        RequestBuilder requestBuilder = null;

        requestBuilder = post("/happ/rec_device").contentType(MediaType.APPLICATION_JSON)
                .content("{\"dInfo\":{\"str\":\"cngdzhxz001\",\"id\":1},\"dMode\":{\"id\":1,\"status\":1,\"temper\":24," +
                        "\"mode\":1},\"data\":{\"deviceId\":1,\"waterInT\":33.3,\"waterOutT\":44.4},\"ack\":\"suc\"}");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertThat(result.getResponse().getContentAsString()).contains("success");
    }


}
