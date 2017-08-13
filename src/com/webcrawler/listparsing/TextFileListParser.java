package com.webcrawler.listparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileListParser implements ListParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webcrawler.application.ListParser#getList(java.lang.String)
	 */
	@Override
	public List<String> getList(String listName) {
		List<String> wordList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(listName))) {

			String line;
			while ((line = reader.readLine()) != null) {
				wordList.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return wordList;
	}

}
