package com.backend.mayday.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.core.ParameterizedTypeReference;

import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.SMSRequest;
import com.backend.mayday.model.SMSResponse;
//import com.backend.mayday.service.SMSService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SMSController {

//	SMSService smsService = new SMSService();

	@PostMapping("/enviarSMS")
	public List<SMSResponse> enviar(@RequestBody List<SMSRequest> smsRequest) throws Exception {
		try {
			Properties props = new Properties();
	        FileInputStream file = new FileInputStream(
	                "./config/dados.properties"
	        );
	        props.load(file);
	        
		    var key = props.getProperty("properties.sms.key");
			
			for(SMSRequest s: smsRequest) {
				s.setKey(key);
				s.setType(9);
			}

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders httpHeaders = null;
			restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
				protected boolean hasError(HttpStatus statusCode) {
					return false;
				}
			});
//			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

			HttpEntity<Object> request = new HttpEntity<>(smsRequest, httpHeaders);

//					ResponseEntity<?> res = restTemplate.postForEntity(url, request, ProdutosVtex.class);

			ResponseEntity<List<SMSResponse>> res = restTemplate.exchange("https://api.smsdev.com.br/v1/send",
					HttpMethod.POST, request, new ParameterizedTypeReference<List<SMSResponse>>() {
					});

			if (res.getStatusCodeValue() == 200) {
				return res.getBody();
			} else
				return null;

		} catch (Exception err) {
			throw err;
		}
	}

}
