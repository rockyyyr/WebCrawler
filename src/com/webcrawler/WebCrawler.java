package com.webcrawler;

import java.util.List;
import java.util.Map;

public class WebCrawler {
	
	private static final String KEYWORD_FILE = "keywords.txt";
	private static final String BLACKLIST_FILE = "blacklist.txt";
	
	private KeywordParser keywordParser;
	private GoogleSearcher googleSearch;
	
	public WebCrawler() {
		keywordParser = new KeywordParser(KEYWORD_FILE, BLACKLIST_FILE);
		googleSearch = new GoogleSearcher("api key", "search engine id");
	}

	public void run() {
		List<String> keywords = keywordParser.getKeywordList();
		List<String> blacklist = keywordParser.getBlacklist();
		
		Map<String, String> matches = googleSearch.performSearch(keywords, blacklist);
		
		if(!matches.isEmpty()) {
			EmailAlert alert = new EmailAlert();
			
			alert.sendAlert(matches);
		}
		
	}

}
