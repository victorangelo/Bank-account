package com.endava.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.endava.bank.Account;
import com.endava.bank.Bank;
import com.endava.transaction.Transaction;

/**
 * This class is used for randomly generated values.
 * 
 * @author Victor Angheluta.
 *
 */
public class RandGenerator {

	/**
	 * The demanded value can range between min value and the max value and is
	 * of long type.
	 * 
	 * @param min
	 * @param max
	 * @return Long
	 */
	public static long randNumber(long min, long max) {

		return ThreadLocalRandom.current().nextLong(min, max + 1);
	}

	/**
	 * This method generates a valid transaction. It presumes a maximum
	 * transaction value of 10 000 000 000. A negative transaction has a credit
	 * meaning while a positive one is meant for debt.
	 * 
	 * @param banks
	 * @return Transaction
	 */
	public static Transaction randTransaction(List<Bank> banks) {

		Transaction transaction = null;
		if (banks != null && !banks.isEmpty()) {

			int sourceBankID = ThreadLocalRandom.current().nextInt(0, banks.size());
			int destinationBankID = ThreadLocalRandom.current().nextInt(0, banks.size());
			Bank sourceBank = banks.get(sourceBankID);
			Bank destinationBank = banks.get(destinationBankID);
			if (sourceBank.getAccounts() != null && !sourceBank.getAccounts().isEmpty()
					&& destinationBank.getAccounts() != null && !destinationBank.getAccounts().isEmpty()) {
				int sourceAccountID = ThreadLocalRandom.current().nextInt(0, sourceBank.getAccounts().size());
				int destinationAccountID = ThreadLocalRandom.current().nextInt(0, destinationBank.getAccounts().size());
				transaction = new Transaction();
				transaction.setSourceAccount(
						new Account(sourceBank.getAccounts().get(sourceAccountID), sourceBank.getName()));
				transaction.setSourceAccount(new Account(destinationBank.getAccounts().get(destinationAccountID),
						destinationBank.getName()));
				if (transaction.validateTransaction()) {
					transaction.setTransactionValue(
							ThreadLocalRandom.current().nextDouble(-10000000000.0d, 10000000000.0d));
					return transaction;
				}
			}
		}
		return null;
	}

	/**
	 * This method generates transactions.xml file containing a wide range of
	 * transactions. It is synchronized.
	 * 
	 * @param transactionsNumber
	 * @param banks
	 */
	public synchronized static void randTransactions(long transactionsNumber, List<Bank> banks) {

		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File("transactions.xml"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		XMLStreamWriter out = null;
		try {
			out = XMLOutputFactory.newInstance().createXMLStreamWriter(new OutputStreamWriter(outputStream, "utf-8"));
		} catch (UnsupportedEncodingException | XMLStreamException | FactoryConfigurationError e) {
			e.printStackTrace();
		}

		try {
			out.writeStartDocument();
			for (long l = 0; l < transactionsNumber; l++) {
				Transaction transaction = null;
				do {
					transaction = randTransaction(banks);
					}while (transaction == null);
				streamWriter(out, transaction);
			}

			out.writeEndDocument();
			out.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void streamWriter(XMLStreamWriter out, Transaction transaction) throws XMLStreamException{
		out.writeStartElement("transactions");
		out.writeStartElement("transaction");

		out.writeStartElement("value");
		out.writeCharacters(String.valueOf(transaction.getTransactionValue()));
		out.writeEndElement();

		out.writeStartElement("sourceAccount");
		out.writeStartElement("id");
		out.writeCharacters(transaction.getSourceAccount().getAccountID());
		out.writeEndElement();
		out.writeStartElement("bankId");
		out.writeCharacters(transaction.getSourceAccount().getAccountID());
		out.writeEndElement();
		out.writeEndElement();
		out.writeStartElement("destinationAccount");
		out.writeStartElement("id");
		out.writeCharacters(transaction.getSourceAccount().getAccountID());
		out.writeEndElement();
		out.writeStartElement("bankId");
		out.writeCharacters(transaction.getSourceAccount().getAccountID());
		out.writeEndElement();
		out.writeEndElement();

		out.writeEndElement();
		out.writeEndElement();
	}
}
