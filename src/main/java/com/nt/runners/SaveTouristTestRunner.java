package com.nt.runners;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.TouristVO;

import tools.jackson.databind.ObjectMapper;
//@Component
public class SaveTouristTestRunner implements CommandLineRunner {
    @Autowired
    private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//=============using exchange()==============//
				// endpoint url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/save";
				/*String touristJson="""
					{
							  "tname": "Raj Thackeray",
							  "taddrs": "Mumbai",
							  "dob": "1995-08-15",
							  "startLocation": "Mumbai",
							  "endLocation": "Goa",
							  "expenditure": 15000.50
							}
				""";*/
				TouristVO vo= new TouristVO("Uddhav Thackeray", "Mumbai", LocalDate.of(1960,10,27), "Mumbai", "Nagpur", 4566123.0);
				ObjectMapper mapper=new ObjectMapper();
				String touristJson=mapper.writeValueAsString(vo);
				
				
				//request headers
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				//prepare HttpEntity Object having headers, body
				HttpEntity<String> entity=new HttpEntity<String>(touristJson,headers);
				//consume the endpoint
				ResponseEntity<String> resp=template.exchange(endpointurl, HttpMethod.POST,entity,String.class);
				//display the results
				System.out.println("Response Status Code ---> "+resp.getStatusCode());
				System.out.println("Response Body --> "+resp.getBody());
				System.out.println("Response Headers ==> "+resp.getHeaders());
				System.exit(0);
				
	}

}
