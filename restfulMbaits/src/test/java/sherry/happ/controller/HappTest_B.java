package sherry.happ.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.Application;
import sherry.datapoint.mapper.DataPointMapper;
import sherry.datapoint.pojo.DataPoint;
import sherry.datapoint.pojo.DataPointExample;
import sherry.entity.PageTb;

import java.util.List;

/**
 * DatapointRepositoryImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/19/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HappTest_B {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    public void test_recDeviceData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/mapper;q=0.9,application/json;q=0.8");
        HttpEntity<?> request = new HttpEntity<Object>(headers);

    }

} 
