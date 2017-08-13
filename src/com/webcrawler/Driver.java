package com.webcrawler;

import com.webcrawler.application.WebCrawler;
import com.webcrawler.listparsing.TextFileListParser;

public class Driver {
	
	public static void main(String[] args) {
		WebCrawler webCrawler = new WebCrawler(new TextFileListParser());
		webCrawler.run();
	}

}
