package com.cpm.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpm.app.services.crypto.CryptocurrencyService;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@Autowired
	CryptocurrencyService cryptocurrencyService;

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String viewHome() {
		LOG.info("Size: " + cryptocurrencyService.findAll().size());
		LOG.info("index");
		return "index";
	}

	@RequestMapping(value = { "/dashboard.html" }, method = RequestMethod.GET)
	public String viewDashboard() {
		LOG.info("index");
		return "dashboard";
	}

	@RequestMapping(value = { "/dashboard2.html" }, method = RequestMethod.GET)
	public String viewDashboard2() {
		LOG.info("index");
		return "dashboard2";
	}

	@RequestMapping("/coinlist")
	public String viewcoinlist() {
		return "coinlist";
	}
}
