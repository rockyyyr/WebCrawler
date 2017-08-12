package com.webcrawler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeywordParser {
	
	private final String KEYWORDS;
	private final String BLACKLIST;
	
	public KeywordParser(String keywords, String blacklist) {
		this.KEYWORDS = keywords;
		this.BLACKLIST = blacklist;
	}
	
	public List<String> getKeywordList(){
		return getListFromFile(KEYWORDS);
	}
	
	public List<String> getBlacklist(){
		return getListFromFile(BLACKLIST);
	} 
	
	private List<String> getListFromFile(String filename){
		List<String> wordList = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
			
			String line;
			
			while((line = reader.readLine()) != null) {
				wordList.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}
	
	
	
	
	
	

}
