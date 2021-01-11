package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bilisimio.input.OTPInput;
import com.bilisimio.input.UserInput;
import com.bilisimio.model.User;
import com.bilisimio.output.UserOutput;
import com.bilisimio.service.OTPService;
import com.bilisimio.service.UserService;

import lombok.extern.java.Log;

@Controller
@Log
public class LoginController {

	@Autowired
	private OTPService otpService;

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "index" })
	public String getLoginPage(Model model) {
		model.addAttribute("userInput", new UserInput());
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(UserInput userInput, BindingResult result, Model model) {
		User user = userService.getUserByEmailAndPassword(userInput);
		if (user == null) {
			model.addAttribute("userInput", new UserInput());
			return "login";
		}
		OTPInput otpInput = otpService.sendOtp(userInput);
		model.addAttribute("otpInput", otpInput);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("loged:" + auth.getName());
		return "otp_validation";
	}

	@PostMapping(value = "/otpValidation")
	public String otpValidation(OTPInput otpInput, BindingResult result, Model model) {
		log.info(otpInput.getOtpCode().concat("-" ));
		
		boolean isValid = otpService.validateOTP(otpInput);
		if (isValid) {
			// userService.getUserById(id)
			model.addAttribute("userOutput", new UserOutput());
			return "home";
		}
		model.addAttribute("otpInput", new OTPInput());
		return "otp_validation";
	}

}
