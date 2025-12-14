package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class PatchUpdateTestRunner2 implements CommandLineRunner {

	@Autowired
    private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		//=============using exchange()==============//
				// end point url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/update/{loc1}/{loc2}/{loc3}/{hikePercent}";
				//register factory
				template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
				//consume the end point
				ResponseEntity<String> resp=template.exchange(endpointurl, HttpMethod.PATCH,null,String.class,"Goa","Varanasi","Nagpur",7.0);
				//display the results
				System.out.println("Response Status Code ---> "+resp.getStatusCode());
				System.out.println("Response Body --> "+resp.getBody());
				System.out.println("Response Headers ==> "+resp.getHeaders());
				System.exit(0);

	}
}
