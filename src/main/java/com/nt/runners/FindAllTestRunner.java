package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.TouristVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class FindAllTestRunner implements CommandLineRunner {

    
	@Autowired
    private RestTemplate template;


    
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//=============using exchange()==============//
		// endpoint url
		String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/all";
		//consume the endpoint
		ResponseEntity<String> resp=template.exchange(endpointurl,HttpMethod.GET, null,String.class);
		//gather results
		System.out.println("Response Status Code ---> "+resp.getStatusCode());
		System.out.println("Response Body --> "+resp.getBody());
		System.out.println("Response Headers ==> "+resp.getHeaders());
		
		/*// (Deserialization) (Json content to Object)
		ObjectMapper mapper= new ObjectMapper();
		List<TouristVO> list=mapper.readValue(resp.getBody(), new TypeReference<List<TouristVO>>() { });
		list.forEach(System.out::println);*/
		
				
		
		
		System.exit(0);

	}


}
