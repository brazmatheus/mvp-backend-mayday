package com.backend.mayday.model;
import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class SMSRequest {

	@Getter
	@Setter
	private String key;
	@Getter
	@Setter
	private Integer type;
	@Getter
	@Setter
	private String number;
	@Getter 
	@Setter
	private String msg;

}
		
