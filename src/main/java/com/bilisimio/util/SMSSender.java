package com.bilisimio.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilisimio.configuration.TwilioConfiguration;
import com.bilisimio.output.OTPOutput;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.java.Log;

@Log
@Service
public class SMSSender {

	private static SMSSender instance = null;

	@Autowired
	private TwilioConfiguration configuration;

	private SMSSender() {

	}

	public static SMSSender getInstance() {
		if (instance == null)
			instance = new SMSSender();

		return instance;
	}

	public String sendOTP(OTPOutput otpOutput) {
		Twilio.init(configuration.getAccountSid(), configuration.getAuthToken());

		Message message = Message.creator(new PhoneNumber("+905394176264"), // to
				new PhoneNumber(configuration.getTrialNumber()), // from
				prepareOTPMessage(otpOutput.getCode())).create();

		log.info(message.getSid());
		return message.getSid();
	}
	
	private String prepareOTPMessage(String code) {
		return "Your verification code is: ".concat(code);
	}

}
