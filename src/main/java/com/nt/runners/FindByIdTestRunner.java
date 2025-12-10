package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.TouristVO;


//@Component
public class FindByIdTestRunner implements CommandLineRunner {
    @Autowired
    private RestTemplate template;
	
	
	@Override
	public void run(String... args) throws Exception {
		/*//=============using getForEntity()==============//
		// endpoint url
		String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/find/{id}";
		//consume the endpoint
		ResponseEntity<String> resp=template.getForEntity(endpointurl, String.class,1004);
		//gather results
		System.out.println("Response Status Code ---> "+resp.getStatusCode());
		System.out.println("Response Body --> "+resp.getBody());
		System.out.println("Response Headers ==> "+resp.getHeaders());*/
		
		/*//=============using getForObject==============//
				// endpoint url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/find/{id}";
				//consume the endpoint
				String output=template.getForObject(endpointurl, String.class,1004);
				//gather results
				System.out.println("Response Body --> "+output);*/
		
		/*//=============using exchange()==============//
				// endpoint url
				String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/find/{id}";
				//consume the endpoint
				ResponseEntity<String> resp=template.exchange(endpointurl,HttpMethod.GET, null,String.class,1004);
				//gather results
				System.out.println("Response Status Code ---> "+resp.getStatusCode());
				System.out.println("Response Body --> "+resp.getBody());
				System.out.println("Response Headers ==> "+resp.getHeaders());
				//convert String json content to VO class object (Deserialization)
				ObjectMapper mapper= new ObjectMapper();
				TouristVO vo=mapper.readValue(resp.getBody(), TouristVO.class);
				System.out.println("VO Class Object data ==> "+vo);*/
		
		//=============using exchange()==============//
		// endpoint url
		String endpointurl="http://localhost:8080/BootRestProj10-MiniProject-SwaggerAPI/tourist-api/find/{id}";
		//consume the endpoint
		ResponseEntity<TouristVO> resp=template.exchange(endpointurl,HttpMethod.GET, null,TouristVO.class,1004);
		//gather results
		System.out.println("Response Status Code ---> "+resp.getStatusCode());
		System.out.println("Response Body --> "+resp.getBody());
		System.out.println("Response Headers ==> "+resp.getHeaders());
		
				
		
		
		System.exit(0);

	}

}
