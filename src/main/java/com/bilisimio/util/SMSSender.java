package com.bilisimio.util;

import org.springframework.stereotype.Service;

import com.bilisimio.output.OTPOutput;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.java.Log;

@Log
@Service
public class SMSSender {

	private static SMSSender instance = null;

	private String accountSid = "AC377e68f4e5565436217b27584331b79f";

	private String authToken = "3bface45de08108d646009ccabafdbdb";

	private String trialNumber = "+18702592950";

	private SMSSender() {

	}

	public static SMSSender getInstance() {
		if (instance == null)
			instance = new SMSSender();

		return instance;
	}

	public String sendOTP(OTPOutput otpOutput) {
		Twilio.init(accountSid, authToken);

		Message message = Message.creator(new PhoneNumber("+905394176264"), // to
				new PhoneNumber(trialNumber), // from
				prepareOTPMessage(otpOutput.getCode())).create();

		log.info(message.getSid());
		return message.getSid();
	}

	private String prepareOTPMessage(String code) {
		return "Your verification code is: ".concat(code);
	}

}
