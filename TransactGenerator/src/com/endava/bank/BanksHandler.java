package com.endava.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The class that implements the ContentHandler Interface
 * 
 * @author Victor Angheluta.
 */
public class BanksHandler extends DefaultHandler {
    private static final String TAG_BANKS = "banks";
    private static final String TAG_BANK = "bank";
    private static final String TAG_NAME = "Name";
    private static final String TAG_ACCOUNTS = "accounts";
    private static final String TAG_ACCOUNT = "account";
    
    private final Stack<String> tagsStack = new Stack<String>();
    private final StringBuilder tempVal = new StringBuilder();
    
    private List<Bank> banks;
    private Bank bank;
    
    

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        pushTag(qName);
        
        tempVal.setLength(0);
        
        if (TAG_BANKS.equalsIgnoreCase(qName)) {
            banks = new ArrayList<Bank>();
        } else if (TAG_BANK.equalsIgnoreCase(qName)) {
            bank = new Bank();
        } else if (TAG_BANK.equalsIgnoreCase(qName)) {
            bank = new Bank();
        }
    }

    public void characters(char ch[], int start, int length) {
        tempVal.append(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) {
        String tag = peekTag();
        if (!qName.equals(tag)) {
            throw new InternalError();
        }

        popTag();
        String parentTag = peekTag();

        if (TAG_ACCOUNT.equalsIgnoreCase(tag)) {
        	String account = tempVal.toString().trim();        	
        	if (TAG_ACCOUNTS.equalsIgnoreCase(parentTag)) {
        		bank.getAccounts().add(account);
            } 
        } else {
	        		if (TAG_ACCOUNTS.equalsIgnoreCase(tag)) {
	        			banks.add(bank);
	        		}
	        		if (TAG_BANK.equalsIgnoreCase(parentTag)) {
	        			bank = null; // debug
	        		}
	        		if (TAG_NAME.equalsIgnoreCase(tag)) {
	        			String name = tempVal.toString().trim();
			            if (TAG_BANK.equalsIgnoreCase(parentTag)) {
			        		bank = new Bank();
			            	bank.setName(name);
			            } else if (TAG_BANKS.equalsIgnoreCase(parentTag)) {
			            	banks.add(bank);
			            }
	        		} 
        		}
    }

    public void startDocument() {
        pushTag("");
    }

    public List<Bank> getBanks() {
        return banks;
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
