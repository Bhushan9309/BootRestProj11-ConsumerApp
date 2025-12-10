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
public class UpdateTouristTestRunner  implements CommandLineRunner{
	@Autowired
    private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//=============using exchange()==============//
				// endpoint url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/update";
				//convert VO Class object to json content (Serialization)
				TouristVO vo= new TouristVO(1010,"Ashish Shelar", "Mumbai", LocalDate.of(1960,10,27), "Mumbai", "London", 9966123.0);
				ObjectMapper mapper=new ObjectMapper();
				String touristJson=mapper.writeValueAsString(vo);
				
				
				//request headers
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				//prepare HttpEntity Object having headers, body
				HttpEntity<String> entity=new HttpEntity<String>(touristJson,headers);
				//consume the endpoint
				ResponseEntity<String> resp=template.exchange(endpointurl, HttpMethod.PUT,entity,String.class);
				//display the results
				System.out.println("Response Status Code ---> "+resp.getStatusCode());
				System.out.println("Response Body --> "+resp.getBody());
				System.out.println("Response Headers ==> "+resp.getHeaders());
				System.exit(0);

 }
}
