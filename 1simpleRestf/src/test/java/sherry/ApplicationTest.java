package sherry; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sherry.web.UserController;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Application Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/07/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class ApplicationTest {

    private MockMvc mvc;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
        RequestBuilder requestBuilder = null;

        //1. get user
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //2. post a user
        requestBuilder = post("/users/").contentType(MediaType.APPLICATION_JSON).content("{\"id\":1, \"name\": \"alice\", \"age\":11}");
        mvc.perform(requestBuilder).andExpect(content().string(equalTo("success")));

        //3. get the post usr
        requestBuilder = get("/users/1");
        mvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"alice\",\"age\":11}")));

        //4. update the user
        requestBuilder = post("/users/1").contentType(MediaType.APPLICATION_JSON).content("{\"id\":1,\"name\":\"alice\",\"age\":12}");
        mvc.perform(requestBuilder).andExpect(content().string(equalTo("success")));

        //5. get the user
        requestBuilder = get("/users/1");
        mvc.perform(requestBuilder).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"alice\",\"age\":12}")));

        //6. delete the user
        requestBuilder = delete("/users/1");
        mvc.perform(requestBuilder).andExpect(content().string(equalTo("success")));

        //7. get the user
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder).andExpect(content().string(equalTo("[]")));
    }


} 
