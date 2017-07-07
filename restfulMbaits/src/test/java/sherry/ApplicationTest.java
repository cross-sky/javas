package sherry; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Application Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/04/2017</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void hasHalLinks() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/customers/1", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).startsWith(
                "{\"id\":1,\"firstName\":\"Oliver\"" + ",\"lastName\":\"Gierke\"");
        assertThat(entity.getBody()).contains("_links\":{\"self\":{\"href\"");
    }

    @Test
    public void producesJsonWhenXmlIsPreferred()throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/mapper;q=0.9,application/json;q=0.8");
        HttpEntity<?> request = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = this.restTemplate.exchange("/customers/1",
                HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType())
                .isEqualTo(MediaType.parseMediaType("application/json;charset=UTF-8"));
    }


} 
