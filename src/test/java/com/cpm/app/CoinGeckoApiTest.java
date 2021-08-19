package com.cpm.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CoinGeckoApiTest {

	final String API_URL = "";

	public static void main(String[] args) throws IOException {
		// Change the URL with any other publicly accessible POST resource, which
		// accepts JSON request body
		URL url = new URL("https://api.coingecko.com/api/v3/");

		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		//con.setRequestProperty("Content-Type", "application/json; utf-8");
		//con.setRequestProperty("Accept", "application/json");

		con.setDoOutput(true);

		// JSON String need to be constructed for the specific resource.
		// We may construct complex JSON using any third-party JSON libraries such as
		// jackson or org.json
//		String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";
//
//		try (OutputStream os = con.getOutputStream()) {
//			byte[] input = jsonInputString.getBytes("utf-8");
//			os.write(input, 0, input.length);
//		}
//
//		int code = con.getResponseCode();
//		System.out.println(jsonInputString);
//		System.out.println(code);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}

	}

}
