package org.uplift.libraryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uplift.libraryproject.model.UserApiResponce;

import javax.sound.midi.Soundbank;

@Service
public class UserService {
    @Autowired
    private RestTemplateBuilder rtb;
    @Autowired
    @Value("${phoneNumber.url}")
    private String apiUrl;
    @Value("${phoneNumber.api.key}")
    private String apikey;


    public UserApiResponce getuserDetailApiService(String phoneNum){
        RestTemplate rt=rtb.build();
        String url=apiUrl+"?api_key="+apikey+"&phone="+phoneNum;
        System.out.println("created url"+url);
        ResponseEntity<UserApiResponce> responseEntity=rt.getForEntity(url,UserApiResponce.class);
        System.out.println(responseEntity);
        System.out.println("Checking phonenumber");
        return responseEntity.getBody();
    }
}
