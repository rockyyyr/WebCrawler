package com.webcrawler.application;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.webcrawler.email.EmailAlert;
import com.webcrawler.listparsing.ListParser;

public class WebCrawler {
	
	private static final String KEYWORD_FILE = "keywords.txt";
	private static final String BLACKLIST_FILE = "blacklist.txt";
	private static final String RECIPIENTS_FILE = "recipients.txt";
	
	private static final String API_KEY = "AIzaSyC_5dvnVV0jC9PozO3lRmR7LUm_jf6_R3U";
	private static final String SEARCH_ENGINE_ID = "007676740702620226561:o6oxl8bznvm";
	
	
	private ListParser listParser;
	private GoogleSearcher googleSearch;
	
	public WebCrawler(ListParser listParser) {
		this.listParser = listParser;
		googleSearch = new GoogleSearcher(API_KEY, SEARCH_ENGINE_ID);
	}

	public void run() {
		List<String> keywords = listParser.getList(KEYWORD_FILE);
		List<String> blacklist = listParser.getList(BLACKLIST_FILE);
		List<String> recipients = listParser.getList(RECIPIENTS_FILE);
		
		List<KeywordMatch> matches = null;
		
		try {
			matches = googleSearch.performSearch(keywords, blacklist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(matches != null && !matches.isEmpty()) {
			
			matches.forEach(System.out::println);
			
//			EmailAlert alert = new EmailAlert(recipients, matches);
//			
//			boolean success = alert.sendAlert();
//			System.out.println(success);
		}
		
	}

}
