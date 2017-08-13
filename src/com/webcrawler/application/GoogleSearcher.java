package com.webcrawler.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearcher {

	private static final String QUOTE = "\"";
	private static final String TYPE = "json";

	private final String API_KEY;
	private final String SEARCH_ENGINE_ID;

	private List<KeywordMatch> matches;

	public GoogleSearcher(String apiKey, String searchEngineId) {
		API_KEY = apiKey;
		SEARCH_ENGINE_ID = searchEngineId;

		matches = new ArrayList<>();
	}

	public List<KeywordMatch> performSearch(List<String> keywords, List<String> blacklist) throws IOException {

		for (String keyword : keywords)
			for (String blackword : blacklist)
				checkForMatch(keyword, blackword);

		return matches;
	}

	private void checkForMatch(String keyword, String blackword) throws IOException {
		String query = buildQuery(keyword, blackword);
		// String query = "android";

		URL searchURL = new URL("https://www.googleapis.com/customsearch/v1" + "?key=" + API_KEY + "&cx="
				+ SEARCH_ENGINE_ID + "&q=" + query + "&alt=" + TYPE);

		HttpURLConnection connection = (HttpURLConnection) searchURL.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("\"link\": \"")) {
				String resultURL = line.substring(line.indexOf("\"link\": \"") + ("\"link\": \"").length(),
						line.indexOf("\","));
				matches.add(new KeywordMatch(keyword, blackword, resultURL));
			}
		}

		connection.disconnect();
	}

	private String buildQuery(String keyword, String blackword) {
		StringBuilder sb = new StringBuilder();

		sb.append(QUOTE + keyword.replaceAll("\\s", "+") + QUOTE);
		sb.append("+");
		sb.append(QUOTE + blackword.replaceAll("\\s", "+") + QUOTE);

		return sb.toString();
	}

}
