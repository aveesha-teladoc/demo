package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value="/getContent")
    private String getI18nValue(){
        String url = "http://localhost:3000/pages/fetch";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject params = new JSONObject().put("key","call_details.call_history");
        HttpEntity<String> request =
                new HttpEntity<String>(params.toString(), headers);
        return new RestTemplate().postForObject(url,request, String.class);
    }
}
