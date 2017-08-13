package com.webcrawler.application;

public class KeywordMatch {
	
	private String keyword;
	private String blackword;
	private String matchedURL;
	
	public KeywordMatch(String keyword, String blackword, String matchedURL) {
		this.keyword = keyword;
		this.blackword = blackword;
		this.matchedURL = matchedURL;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public String getBlackword() {
		return this.blackword;
	}

	public String getMatchedURL() {
		return this.matchedURL;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setBlackword(String blackword) {
		this.blackword = blackword;
	}

	public void setMatchedURL(String matchedURL) {
		this.matchedURL = matchedURL;
	}

	@Override
	public String toString() {
		return "KeywordMatch - keyword=" + this.keyword + ", blackword=" + this.blackword + ", matchedURL="
				+ this.matchedURL;
	}
	
	
	
	

}
