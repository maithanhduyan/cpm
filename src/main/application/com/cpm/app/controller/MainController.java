package com.cpm.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpm.app.core.account.entity.Account;
import com.cpm.app.core.account.model.AccountModel;
import com.cpm.app.core.account.repository.AccountRepository;
import com.cpm.app.core.crypto.entity.Asset;
import com.cpm.app.core.crypto.entity.AssetHolding;
import com.cpm.app.core.crypto.entity.AssetPriceHistory;
import com.cpm.app.core.crypto.entity.AssetTransaction;
import com.cpm.app.services.auth.AccountService;
import com.cpm.app.services.crypto.AssetCategoryService;
import com.cpm.app.services.crypto.AssetHoldingService;
import com.cpm.app.services.crypto.AssetPriceHistoryService;
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

	@Autowired
	AccountService accountService;

	@Autowired
	AssetPriceHistoryService assetPriceHistoryService;

	private AccountModel accountModel;
	Authentication auth;

	public MainController() {

	}

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String viewHome(Model model) {
		if (this.auth == null) {
			LOG.info("Set Account Model");
			this.accountModel = getCurentAccount();
		}
		// LOG.info("Size: " + cryptocurrencyService.findAll().size());
		List<Asset> assets = assetService.findAll();
		model.addAttribute("assets", assets);
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

	@RequestMapping(value = { "/coins", "/coins.html" }, method = RequestMethod.GET)
	public String viewcoinlist(Model model) {
		List<Asset> assets = assetService.findAll();
		model.addAttribute("assets", assets);
		model.addAttribute("coins", assets.size());

		long marketCap = 2036491712613L;
		model.addAttribute("marketCap", marketCap);

		long _24HVolume = 135003975852L;
		model.addAttribute("_24HVolume", _24HVolume);
		double bitcoinMarketCapDominace = 42.74;
		model.addAttribute("bitcoinMarketCapDominace", bitcoinMarketCapDominace);
		return "coins";
	}

	@RequestMapping(value = { "/portfolio", "/portfolio.html" }, method = RequestMethod.GET)
	public String viewMyPorfolio(Model model) {
		List<AssetTransaction> transactions = assetTransactionService.findAll();

		List<AssetHolding> assetHoldings = assetHoldingService.findAll();

		model.addAttribute("assetHoldings", assetHoldings);
		model.addAttribute("transactions", transactions);

		double totalBalance = 400000.02;
		model.addAttribute("totalBalance", totalBalance);
		double _24hPortfolioChange = 15000.02;
		model.addAttribute("_24hPortfolioChange", _24hPortfolioChange);
		double totalProfitLoss = 350000.00;
		model.addAttribute("totalProfitLoss", totalProfitLoss);
		model.addAttribute("assetsHoldingCount", assetHoldings.size());

		return "portfolio";
	}

	@RequestMapping(value = { "/nupl", "/nupl.html" }, method = RequestMethod.GET)
	public String viewNUPL() {
		return "nupl";
	}

	@RequestMapping(value = { "/stock-to-flow", "/stock-to-flow.html" }, method = RequestMethod.GET)
	public String viewStockToFlow() {
		return "stock-to-flow";
	}

	@RequestMapping(value = { "/asset-price-history.html" }, method = RequestMethod.GET)
	public String viewAssetPriceHistory(Model model) {
		List<Asset> assets = assetService.findAll();
		List<AssetPriceHistory> assetPriceHistories = assetPriceHistoryService.findAll();
		model.addAttribute("assets", assets);
		model.addAttribute("assetPriceHistories", assetPriceHistories);
		return "asset-price-history";
	}

	@RequestMapping(value = { "/auth/login", "/auth/login.html" })
	public String viewLogin() {
		return "login";
	}

	@RequestMapping(value = { "/transactions.html" }, method = RequestMethod.GET)
	public String viewTransactions(@RequestParam Map<String, String> allParams, Model model) {
		List<AssetTransaction> transactions = null;
		if (allParams.containsKey("assetName")) {
			transactions = assetTransactionService.findAllByAssetAndAccount(allParams.get("assetName"), "admin");
			model.addAttribute("assetName", allParams.get("assetName"));

		} else {
			model.addAttribute("assetName", "?");
		}

		model.addAttribute("transactions", transactions);
		return "transaction";
	}

	@RequestMapping(value = { "/add-asset-holding" }, method = RequestMethod.POST)
	public String doAddAssetHolding(@RequestParam Map<String, String> allParams) {
		// TODO: add param to add Asset Holding
		String assetName = allParams.get("asset_name");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String quantity = allParams.getOrDefault("quantity", "0.0");
		double hold = Double.parseDouble(quantity);
		LOG.info(assetName);
		LOG.info(allParams.get("_csrf"));
		// Save to database
		try {
			AssetHolding assetHolding = assetHoldingService.fetchByUserNameAndAssetName(username, assetName);
			if (assetHolding == null) {
				assetHolding = new AssetHolding();
				assetHolding.setId(UUID.randomUUID().toString());
				assetHolding.setAsset(assetService.findByName(assetName));
				assetHolding.setAccount(accountService.findByName(username));
				assetHolding.setCreatedDate(new Date());
				assetHolding.setHold(hold);
				assetHoldingService.save(assetHolding);
				LOG.info(assetHolding.getId());
			} else {
				LOG.info(assetHolding.getId());

			}
		} catch (Exception ex) {
			LOG.info(ex.getMessage());
		}
		// display on portfolio
		return "redirect:/portfolio.html";
	}

	@RequestMapping(value = { "/add-transaction.html" }, method = RequestMethod.GET)
	public String viewAddTransaction() {
		return "add-transaction";
	}

	@RequestMapping(value = { "/profile.html" }, method = RequestMethod.GET)
	public String viewProfile() {
		return "profile";
	}

	@RequestMapping(value = { "/settings.html" }, method = RequestMethod.GET)
	public String viewSettings() {
		return "settings";
	}

	@RequestMapping(value = { "/activity-log.html" }, method = RequestMethod.GET)
	public String viewActivityLog() {
		return "activity-log";
	}
	
	@RequestMapping(value = { "/samples/candlestick-chart.html" }, method = RequestMethod.GET)
	public String viewCandleStickChartSample() {
		return "samples/candlestick-chart";
	}

	@RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		LOG.info("LOGOUT");
		return "redirect:/login?logout"; // You can redirect wherever you want, but generally it's a good practice to
											// show login screen again.
	}

	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public String view403() {
		return "error/403";
	}

	@ModelAttribute("appName")
	public String getAppName() {
		return "Cryptocurrency Portfolio Management";
	}

	@ModelAttribute("assetList")
	public List<Asset> getAssetList() {
		List<Asset> assets = assetService.findAll();
		return assets;
	}

	private AccountModel getCurentAccount() {
		AccountModel accountModel = new AccountModel();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		LOG.info("currentPrincipalName:" + currentPrincipalName);
		Account account = accountService.findByName(currentPrincipalName);
		accountModel.setAccount(account);
		accountModel.setSessionId(authentication.getDetails().toString());
		return null;
	}
}
