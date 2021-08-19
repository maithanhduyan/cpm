package com.cpm.app.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpm.app.core.crypto.entity.Asset;
import com.cpm.app.services.crypto.AssetService;

@RestController
@RequestMapping(value = { "/api/v1" })
public class MainRestController {

	private static final Logger LOG = LoggerFactory.getLogger(MainRestController.class);

	@Autowired
	AssetService assetService;

	@RequestMapping(value = { "/" })
	public String healcheck() {
		return "OK";
	}

	@RequestMapping(value = { "/asset/findPage" },method = RequestMethod.POST)
	public @ResponseBody Map<String, Asset> findPage(@RequestParam Map<String, String> req) {
		Map<String, Asset> map = new HashMap<String, Asset>();
		return map;
	}
}
