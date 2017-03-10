package com.reader.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.reader.transaction.Transaction;

/**
 * The class that extends DefaultHandler class
 * 
 * @author Victor Angheluta.
 */
public class TransactionsHandler extends DefaultHandler {

	private List<Transaction> transactions;
	private Transaction transaction;

	private final Stack<String> tagsStack = new Stack<String>();
	private final StringBuilder tempVal = new StringBuilder();

	/**
	 * Parses the starting elements in a XML DOM
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		pushTag(qName);
		tempVal.setLength(0);

		if ("transactions".equalsIgnoreCase(qName)) {
			transactions = new ArrayList<Transaction>();
		} else if ("transaction".equalsIgnoreCase(qName)) {
			transaction = new Transaction();
		}
	}

	/**
	 * Parses the end tag elements of a XML DOM
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String tag = peekTag();
		if (!qName.equals(tag)) {
			throw new InternalError();
		}

		popTag();
		String parentTag = peekTag();

		
		if ("transactions".equalsIgnoreCase(tag) && transaction != null) {
			transactions.add(transaction);
		}
		if ("transaction".equalsIgnoreCase(tag) && "transactions".equalsIgnoreCase(parentTag)) {
			if(transaction!= null ) { 
				transactions.add(transaction);
				transaction = null;
			}
		}
		if ("value".equalsIgnoreCase(tag)) {
			Double value = Double.parseDouble(tempVal.toString().trim());
			if ("transaction".equalsIgnoreCase(parentTag)) {
				if (transaction == null) {
					transaction = new Transaction();
				}
				transaction.setTransactionValue(value);
			}
		}
		if ("id".equalsIgnoreCase(tag)) {
			String id = tempVal.toString().trim();
			if ("sourceAccount".equalsIgnoreCase(parentTag)) {
				if (transaction.getSourceAccount() == null) {
					transaction.setSourceAccount(new Account());
				}
				transaction.getSourceAccount().setAccountID(id);
			} else {
				if ("destinationAccount".equalsIgnoreCase(parentTag)) {
					if (transaction.getDestinationAccount() == null) {
						transaction.setDestinationAccount(new Account());
					}
					transaction.getDestinationAccount().setAccountID(id);
				}
			}
		} else if ("bankId".equalsIgnoreCase(tag)) {
			String bankId = tempVal.toString().trim();
			if ("sourceAccount".equalsIgnoreCase(parentTag)) {
				if (transaction.getSourceAccount() == null) {
					transaction.setSourceAccount(new Account());
				}
				transaction.getSourceAccount().setBankID(bankId);
			} else {
				if ("destinationAccount".equalsIgnoreCase(parentTag)) {
					if (transaction.getDestinationAccount() == null) {
						transaction.setDestinationAccount(new Account());
					}
					transaction.getDestinationAccount().setBankID(bankId);
				}
			}
		}
	}

	public void characters(char ch[], int start, int length) {
		tempVal.append(ch, start, length);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void startDocument() {
		pushTag("");
	}

	private void pushTag(String tag) {
		tagsStack.push(tag);
	}

	private String popTag() {
		return tagsStack.pop();
	}

	private String peekTag() {
		return tagsStack.peek();
	}
}
