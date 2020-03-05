package com.test.app;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@SpringBootTest
class DemoApplicationTests {

    protected RestTemplate restTemplate = (new TestRestTemplate()).getRestTemplate();
    String cityURL = "http://127.0.0.1:8088/api/cities";
    String cityWeather = "http://127.0.0.1:8088/api/city/{101010100}";
    @Before
    public void before() {

    }

    @After
    public void after() {

    }


    @Test
    public void testGetCities() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(cityURL)
                .build();
        URI uri = uriComponents.toUri();
        String  res = restTemplate.getForObject(uri, String.class);
        System.out.println(res);

    }

    @Test
    public void testGetWeather() throws Exception {

        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("http://127.0.0.1:8088/api/city/{id}")
                .build().expand("101010100");
        URI uri = uriComponents.toUri();
        String  res = restTemplate.getForObject(uri, String.class);
        System.out.println(res);
    }


}
