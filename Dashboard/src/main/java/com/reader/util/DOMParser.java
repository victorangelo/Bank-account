package com.reader.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import com.reader.bank.TransactionsHandler;
import com.reader.transaction.Transaction;

/**
 * This class is mainly used for parsing an XML file using DOM approach.
 * 
 * @author Victor Angheluta
 *
 */
public class DOMParser {

	/**
	 * Given an XML file path the function extracts in a Map all the nodes and
	 * their first degree sub-nodes.
	 * 
	 * @return Map<String, List<String>>
	 */
	public static List<Transaction> loadDOMtoMap(InputStream inputStream) {
		try {
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			TransactionsHandler handler = new TransactionsHandler();
			parser.parse(inputStream, handler);
			//parser.parse("C:\\Users\\vangheluta\\workspace\\TransactGenerator\\transactions.xml", handler);
			if(handler != null && handler.getTransactions().size() > 0){
				return handler.getTransactions();
			}
			
		} catch (ParserConfigurationException | SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}