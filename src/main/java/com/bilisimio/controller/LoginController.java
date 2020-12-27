package com.bilisimio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bilisimio.input.UserInput;

@Controller
public class LoginController {

	@GetMapping(value = { "/", "index", "home" })
	public String getLoginPage(Model model) {
		model.addAttribute("userInput", new UserInput());
		return "login";
	}

}
