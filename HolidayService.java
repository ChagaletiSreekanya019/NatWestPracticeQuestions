package org.uplift.libraryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.uplift.libraryproject.model.HolidayApiResponse;

import java.time.LocalDate;
@Service
public class  HolidayService {
    @Autowired
    private RestTemplateBuilder rtb;
    @Value("${holiday.url}")
    private String apiUrl;
    @Value("${holiday.api.key}")
    private String apiKey;
//    @Value("${check.holidays}")
//    private check
    public HolidayApiResponse getHolidayApiServise(LocalDate date) {
//        System.out.println(rtb);
        RestTemplate rt=rtb.build();
        String url=apiUrl+"?key="+apiKey+"&year="+date.getYear()+"&month="+date.getMonthValue()+"&day="+date.getDayOfMonth()
                +"&country=IN";
        try{
            ResponseEntity<HolidayApiResponse> response=rt.getForEntity(url,HolidayApiResponse.class);
            return response.getBody();
//            System.out.println(response.getStatusCode());
//            System.out.println(response.getBody());
        }catch(HttpClientErrorException e){
            String errorMessage=e.getMessage();
            String[] tokens=errorMessage.split(";");
            String statuscode = tokens[0].substring(0,3);
            String error=tokens[tokens.length-1].split("For more information")[0];
            System.out.println("Error is "+ error);
            System.out.println("statuscode= "+statuscode);
            HolidayApiResponse hr=new HolidayApiResponse();
            hr.setStatus(Integer.parseInt(statuscode));
            hr.setError(error);
            System.err.println("Error response "+hr);
            return hr;
        }

    }
}
