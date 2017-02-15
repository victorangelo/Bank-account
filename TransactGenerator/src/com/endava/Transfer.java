package com.endava;

import com.endava.util.DOMParser;
import com.endava.util.RandGenerator;

/**
 * The Main Class
 * 
 * @author Victor Angheluta.
 */
public class Transfer {

	public static void main(String[] args) {
		
		long numberOfTransactions = 0;
		
		if (args.length > 0) {
		    try {
		    	numberOfTransactions = Long.parseLong(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument " + args[0] + " must be a long.");
		        System.exit(1);
		    }
		}else {
			numberOfTransactions = RandGenerator.randNumber(10L, 1000000L);
		}
		
		System.out.println("The total number of transactions is " + numberOfTransactions);
		RandGenerator.randTransactions(numberOfTransactions, DOMParser.loadDOMtoMap("ListOfBanksAndAccounts.xml"));
		System.out.println("The process is completed.");
	}

}
