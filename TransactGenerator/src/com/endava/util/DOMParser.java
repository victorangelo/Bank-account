package com.endava.util;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import com.endava.bank.Bank;
import com.endava.bank.BanksHandler;

/**
 * This class is mainly used for parsing an XML file using DOM approach.
 * 
 * @author Victor Angheluta
 * Endava (c).
 *
 */
public class DOMParser {

	
	/**
	 * Given an XML file path the function extracts in a Map all the nodes and their first degree sub-nodes.
	 * 
	 * @return Map<String, List<String>>
	 */
	public static List<Bank> loadDOMtoMap(String fileName){
		
		List<Bank> result = null;
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
        BanksHandler handler = new BanksHandler();
        
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse("properties\\" + fileName, handler);            
            System.out.println("Number of read Banks: " + handler.getBanks().size());
            
            if(handler != null && handler.getBanks().size() > 0){
            	return handler.getBanks(); 
            }
            	
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

		return result;
	}
}
