package com.webcrawler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleSearcher {

	private String API_KEY;
	private String SEARCH_ENGINE_ID;

	public GoogleSearcher(String apiKey, String searchEngineId) {
		API_KEY = apiKey;
		SEARCH_ENGINE_ID = searchEngineId;
	}

	public Map<String, String> performSearch(List<String> keywords, List<String> blacklist) {
		return new HashMap<>();
	}

	private String buildQueryUrl(List<String> keywords, List<String> blacklist) {
		return "";
	}

}
