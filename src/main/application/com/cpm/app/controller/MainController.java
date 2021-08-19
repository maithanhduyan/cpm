package com.cpm.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpm.app.core.crypto.entity.AssetHolding;
import com.cpm.app.core.crypto.entity.AssetTransaction;
import com.cpm.app.services.crypto.AssetCategoryService;
import com.cpm.app.services.crypto.AssetHoldingService;
import com.cpm.app.services.crypto.AssetService;
import com.cpm.app.services.crypto.AssetTransactionService;
import com.cpm.app.services.crypto.CryptocurrencyService;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@Autowired
	CryptocurrencyService cryptocurrencyService;

	@Autowired
	AssetTransactionService assetTransactionService;

	@Autowired
	AssetService assetService;

	@Autowired
	AssetHoldingService assetHoldingService;

	@Autowired
	AssetCategoryService assetCategoryService;

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String viewHome() {
		LOG.info("Size: " + cryptocurrencyService.findAll().size());
		return "coins";
	}

	@RequestMapping(value = { "/dashboard.html" }, method = RequestMethod.GET)
	public String viewDashboard() {
		return "samples/dashboard";
	}

	@RequestMapping(value = { "/dashboard2.html" }, method = RequestMethod.GET)
	public String viewDashboard2() {
		LOG.info("index");
		return "samples/dashboard2";
	}

	@RequestMapping(value = { "/coins", "/coins.html" })
	public String viewcoinlist() {
		return "coins";
	}

	@RequestMapping(value = { "/portfolio", "/portfolio.html" })
	public String viewMyPorfolio(Model model) {
		List<AssetTransaction> transactions = assetTransactionService.findAll();

		List<AssetHolding> assetHoldings = assetHoldingService.findAll();

		model.addAttribute("assetHoldings", assetHoldings);
		model.addAttribute("transactions", transactions);
		LOG.info("Size: " + transactions.size());
		return "portfolio";
	}

	@RequestMapping(value = { "/nupl", "/nupl.html" })
	public String viewNUPL() {
		return "nupl";
	}

	@RequestMapping(value = { "/stock-to-flow", "/stock-to-flow.html" })
	public String viewStockToFlow() {
		return "stock-to-flow";
	}

	@ModelAttribute("appName")
	public String getAppName() {
		return "Cryptocurrency Portfolio Management";
	}
}
