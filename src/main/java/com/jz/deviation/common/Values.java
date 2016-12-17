package com.jz.deviation.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Values {
	@Value("${password.secret}")
	public String passwdSecret;
	
}
