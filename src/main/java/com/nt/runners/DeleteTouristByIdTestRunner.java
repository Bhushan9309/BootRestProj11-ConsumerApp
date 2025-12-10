package com.nt.runners;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DeleteTouristByIdTestRunner implements CommandLineRunner {

	@Autowired
    private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//=============using exchange()==============//
				// endpoint url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/delete/{id}";
				//consume the endpoint
				ResponseEntity<String> resp=template.exchange(endpointurl, HttpMethod.DELETE,null,String.class,1010);
				//display the results
				System.out.println("Response Status Code ---> "+resp.getStatusCode());
				System.out.println("Response Body --> "+resp.getBody());
				System.out.println("Response Headers ==> "+resp.getHeaders());
				System.exit(0);


	}

}
