package com.bilisimio.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Configuration
public class TwilioConfiguration {

	@Value("${twilio.accountSid}")
	private String accountSid;
	@Value("${twilio.authToken}")
	private String authToken;
	@Value("${twilio.trialNumber}")
	private String trialNumber;

}