package com.backend.configuracao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Component
public class Configuracao {
    
	@Bean(name = "getHeadersVtex")
	public HttpHeaders getHeadersVtex() throws IOException {
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(mtJson));
//		headers.setContentType(mtJson);
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

//		headers.add("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"));
//		headers.add("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"));
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
		
		return headers;
		
	}

	
	/**
	 * Usado para operacoes REST (POST, GET, PATCH e etc.)
	 */
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate =  new RestTemplate();
		
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
				protected boolean hasError(HttpStatus statusCode) {
				return false;
			}});
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		return restTemplate;
	}
	
	@Bean
    public Properties getProperties() throws IOException {

        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./config/dados.properties"
        );
        props.load(file);
        
        return props;
    }
	

}


