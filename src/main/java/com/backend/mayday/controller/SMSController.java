package com.backend.mayday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.SMSRequest;
//import com.backend.mayday.service.SMSService;

@RestController
public class SMSController {

//	SMSService smsService = new SMSService();

	@GetMapping("/")
	public String enviar() {
		try {
			SMSRequest smsRequest = new SMSRequest();
			smsRequest.setMsg("Teste143");
//			smsService.enviaPost(smsRequest);
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	@GetMapping("/teste")
	public String testa() {
		try {
			PlanoAtivacao planoAtivacao = new PlanoAtivacao();
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
