package com.cpm.app.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	@RequestMapping(value = {"/api"})
	public String healcheck() {
		return "OK";
	}
}
