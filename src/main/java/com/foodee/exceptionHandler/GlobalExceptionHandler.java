package com.foodee.exceptionHandler;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalExceptionHandler implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String handleErrorRequest(Model model) {

		return "customError";
	}

	@Override
	public String getErrorPath() {

		return PATH;
	}

}
