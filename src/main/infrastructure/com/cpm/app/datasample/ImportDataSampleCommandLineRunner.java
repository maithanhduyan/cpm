package com.cpm.app.datasample;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cpm.app.core.account.entity.Account;
import com.cpm.app.core.account.repository.AccountRepository;
import com.cpm.app.core.crypto.entity.Asset;
import com.cpm.app.core.crypto.entity.AssetCategory;
import com.cpm.app.core.crypto.entity.AssetHolding;
import com.cpm.app.core.crypto.entity.AssetTransaction;
import com.cpm.app.core.crypto.repository.AssetCategoryRepository;
import com.cpm.app.core.crypto.repository.AssetHoldingRepository;
import com.cpm.app.core.crypto.repository.AssetRepository;
import com.cpm.app.core.crypto.repository.AssetTransactionRepository;

@Component
public class ImportDataSampleCommandLineRunner implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ImportDataSampleCommandLineRunner.class);

	private static final int SUCESS = 1;
	private static final int FAIL = 0;

	@Autowired
	private Environment env;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	AssetCategoryRepository assetCategoryRepository;

	@Autowired
	AssetHoldingRepository assetHoldingRepository;

	@Autowired
	AssetTransactionRepository assetTransactionRepository;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Creating Data Sample ...");
		if (env.getProperty("cpm.data.sample").equalsIgnoreCase("create")) {
			LOG.info(env.getProperty("cpm.data.sample"));
			createAccountSample();
			createAssetCategoriesSample();
			createAssetSample();
			createAssetHodingSample();
			createAssetHoldingTransactionSample();
		}

	}

	private void createAssetHoldingTransactionSample() {
		Account account = accountRepository.findByUsername("admin");
		Asset btc = assetRepository.findByCode("BTC");
		AssetHolding holdBTC = assetHoldingRepository.findByAsset(btc.getId());
		AssetTransaction holdBTCTransaction1 = new AssetTransaction();
		holdBTCTransaction1.setId("bb73fdac-506e-4f7f-806c-5c8bcb24780b");
		holdBTCTransaction1.setAssetHolding(holdBTC);
		holdBTCTransaction1.setAccount(account);
		holdBTCTransaction1.setPrice(48567.23);
		holdBTCTransaction1.setAmount(1.5);
		holdBTCTransaction1.setCreatedDate(new Date());
		assetTransactionRepository.save(holdBTCTransaction1);

	}

	private void createAssetHodingSample() {
		Account account = accountRepository.findByUsername("admin");
		Asset btc = assetRepository.findByName("Bitcoin");
		AssetHolding holdBTC = new AssetHolding("6b196cac-44fb-4570-aeff-391edaf57d86", btc, 0.25, new Date(), null,
				account);
		assetHoldingRepository.save(holdBTC);

		Asset doge = assetRepository.findByCode("DOGE");
		AssetHolding holdDoge = new AssetHolding("0066d9ea-34f8-4195-abf5-6629e8f2c13e", doge, 100000.25, new Date(),
				null, account);
		assetHoldingRepository.save(holdDoge);

		Asset bnb = assetRepository.findByCode("BNB");
		AssetHolding holdBNB = new AssetHolding("601a25a7-c593-447d-9b1e-f0c48d31f0a6", bnb, 2.2, new Date(), null,
				account);
		assetHoldingRepository.save(holdBNB);
	}

	private void createAssetCategoriesSample() {
		List<AssetCategory> listAssets = new ArrayList<AssetCategory>();
		AssetCategory crypto = new AssetCategory("c2595d8b-5e8b-4aff-a2a3-eabb51f162bb", "Crypto", "Crypto");
		listAssets.add(crypto);
		AssetCategory stock = new AssetCategory("e51a94f8-6a27-427b-87d4-50e7f0b0355d", "Stock", "Stock");
		listAssets.add(stock);
		AssetCategory bond = new AssetCategory("2d99914c-29a3-4de8-a5bd-f8243165dfc4", "Bond", "Bond");
		listAssets.add(bond);
		assetCategoryRepository.saveAll(listAssets);
	}

	int createAccountSample() {
		LOG.info("Creating Account ...");
		Account account = new Account();
		// account.setId(UUID.randomUUID().toString());
		account.setId("d28b3d67-ff4d-4acf-8fda-eea8a7f6568f");
		account.setUserName(env.getProperty("spring.security.user.name", "admin"));
		account.setEncrytedPassword(
				new BCryptPasswordEncoder().encode(env.getProperty("spring.security.user.password", "admin")));
		account.setUserRole("ROLE_" + env.getProperty("spring.security.user.roles", "ADMIN"));
		account.setCreatedDate(new Date());
		account.setActive(true);

		if (accountRepository.save(account) != null) {
			return SUCESS;
		}

		return FAIL;
	}

	int createAssetSample() {
		LOG.info("Create Asset.");
		AssetCategory crypto = assetCategoryRepository.getById("c2595d8b-5e8b-4aff-a2a3-eabb51f162bb");
		Asset bitcoin = new Asset("aff9b7d5-0ba9-4126-b05f-34b87484f852", "Bitcoin", "BTC", crypto, null, null);
		assetRepository.save(bitcoin);
		Asset doge = new Asset("5274e915-69b7-4050-abc9-608c054eaaf2", "Dogecoin", "DOGE", crypto, null, null);
		assetRepository.save(doge);
		Asset eth = new Asset("fcad3991-719c-4db6-aaf7-9b4a4bc09cee", "Ethereum", "ETH", crypto, null, null);
		assetRepository.save(eth);
		Asset ada = new Asset("afac7a40-d779-4947-a02c-3329d2448667", "Cardano", "ADA", crypto, null, null);
		assetRepository.save(ada);
		Asset dot = new Asset("3b1f10c7-66c8-4d35-88ac-b18c022fccac", "Polkadot", "DOT", crypto, null, null);
		assetRepository.save(dot);
		Asset bnb = new Asset("31febbd2-0357-414d-aae1-bf85440903e0", "Binance Coin", "BNB", crypto, null, null);
		assetRepository.save(bnb);
		Asset sol = new Asset("9a22d87f-6fed-4a9d-be4d-a685dcb867f8", "Solana", "SOL", crypto, null, null);
		assetRepository.save(sol);

		return FAIL;
	}

}
