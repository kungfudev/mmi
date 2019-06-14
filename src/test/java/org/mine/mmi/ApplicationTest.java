package org.mine.mmi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    Logger log = LoggerFactory.getLogger(ApplicationTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getPing() throws MalformedURLException {
        URL url = new URL("http://localhost:" + port + "/convert?from=Kilometers&to=Miles&value=40");
        ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody(), equalTo("24.854840"));
    }

//    @Test
//    public void getStatic() throws MalformedURLException {
//        URL url = new URL("http://localhost:" + port + "/");
//        ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//        log.debug(response.getBody());
//    }
}
