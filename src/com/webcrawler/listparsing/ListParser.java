package com.webcrawler.listparsing;

import java.util.List;

public interface ListParser {

	/**
	 * Get a list of words from a file or database
	 * 
	 * @param listName
	 *            The name of the list
	 * @return A list of words
	 */
	List<String> getList(String listName);

}