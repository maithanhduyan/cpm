package com.cpm.app.datasample;

import java.time.Instant;
import java.util.Date;
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
import com.cpm.app.core.crypto.repository.AssetRepository;

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

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Creating Data Sample ...");
		if (env.getProperty("cpm.data.sample").equalsIgnoreCase("create")) {
			LOG.info(env.getProperty("cpm.data.sample"));
			createAccountSample();
			createAssetSample();
		}

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
		Asset crypto = new Asset();
		crypto.setId("aff9b7d5-0ba9-4126-b05f-34b87484f852");
		crypto.setName("CRYPTO");
		crypto.setCode("CRYPTO");
		assetRepository.save(crypto);

		return FAIL;
	}

}
