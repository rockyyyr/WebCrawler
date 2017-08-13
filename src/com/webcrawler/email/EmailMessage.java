package com.webcrawler.email;

import java.util.List;

import com.webcrawler.application.KeywordMatch;

public class EmailMessage {

	public static String buildMessage(List<KeywordMatch> matches) {
		StringBuilder sb = new StringBuilder();
		sb.append("<div>Keyword Alert List</div>");
		
		for(KeywordMatch match : matches) {
			sb.append(buildMatchRow(match.getKeyword(), match.getBlackword()));
		}
		
		return null;
	}
	
	private static String buildMatchRow(String keyword, String blackWord) {
		return String.format("<div>%s - %s</div>", keyword, blackWord);
	}
}
