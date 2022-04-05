package com.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.backend.mayday.model.SMSRequest;
import com.backend.mayday.model.SMSResponse;

public class SMSService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders httpHeaders;

	public Optional<SMSResponse> enviaPost(SMSRequest smsRequest){
		
		HttpEntity<Object> request = new HttpEntity<>(httpHeaders);
		
//		ResponseEntity<?> res = restTemplate.postForEntity(url, request, ProdutosVtex.class);
		
		ResponseEntity<Object> res = restTemplate.exchange("https://api.smsdev.com.br/v1/send",
				HttpMethod.POST, 
				request, 
				new ParameterizedTypeReference<Object>() {});
    	
//        response = Unirest.post(url)
//                .header("Content-Type", "application/json")
//                .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
//                .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
//                .asString();

        return null;
	}
	
}
