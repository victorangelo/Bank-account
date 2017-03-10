package com.transact.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reader.transaction.Transaction;
import com.reader.util.DOMParser;
import com.transact.model.bank.AccountEntity;
import com.transact.model.bank.BankEntity;
import com.transact.model.transaction.TransactionEntity;
import com.transact.service.AccountManager;
import com.transact.service.BankManager;
import com.transact.service.TransactionManager;
import com.transact.view.UploadedTransactions;

/**
 * This is the controller class for the spring application.
 * 
 * @author Victor Angheluta
 */
@Controller
@SessionAttributes("transactions")
public class TransactController {

	@Autowired
	TransactionManager tManager;

	@Autowired
	AccountManager aManager;

	@Autowired
	BankManager bManager;

	/**
	 * Bind all transactionslogs list
	 */
	@ModelAttribute("allTransactions")
	public List<TransactionEntity> populateTransactions() {
		List<TransactionEntity> transactions = tManager.getAllTransactions();
		return transactions;
	}

	/**
	 * Method will be called in initial page load at GET /transacts
	 */
	@RequestMapping(value = "/transacts", method = RequestMethod.GET)
	public String setupForm(Model model) {
		return "listTransactionsView";
	}

	/**
	 * file uploader action method. Saves the entries if they're not contained
	 * into the DB. Returns as response the uploaded list of entries.
	 * 
	 * @param fName
	 * @param mType
	 * @return String
	 */
	@RequestMapping(value = ("/transacts"), headers = "content-type=multipart/*", method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("file[]") List<MultipartFile> fileList) {

		UploadedTransactions uploadedTransactions = new UploadedTransactions();
		
		for (MultipartFile file : fileList){
			if (!file.isEmpty() && file.getOriginalFilename().equals("transactions.xml")) {
				
		        List<Transaction> listTransactions = null;
		        try {
		            listTransactions = DOMParser.loadDOMtoMap(file.getInputStream());
		            uploadedTransactions.setTotalTransactions(listTransactions.size());
		            uploadedTransactions.setUploadedDate(Calendar.getInstance().getTime().toString());
		            file.getInputStream().close();
		            System.out.println("File reading multipart is ok.");
		        } catch (FileNotFoundException e) {
		            System.out.println("File not found" + e);
		        } catch (IOException ioe) {
		                System.out.println("Error while closing stream: " + ioe);
		        }
	
				for (Transaction trans : listTransactions) {
					TransactionEntity te = new TransactionEntity();
					te.setValue(trans.getTransactionValue());
	
					BankEntity sourceBank = bManager.getBankByName(trans.getSourceAccount().getBankID());
					if (sourceBank == null) {
						sourceBank = new BankEntity();
						sourceBank.setName(trans.getSourceAccount().getBankID());
						sourceBank.setId(bManager.saveBank(sourceBank));
					}
					AccountEntity sourceAccount = aManager
							.getAccountByNumberAndBankId(trans.getSourceAccount().getAccountID(), sourceBank);
					if (sourceAccount == null) {
						sourceAccount = new AccountEntity();
						sourceAccount.setNumber(trans.getSourceAccount().getAccountID());
						sourceAccount.setBalance(0D);
						sourceAccount.setBankID(sourceBank);
						aManager.saveAccount(sourceAccount);
					}
					sourceAccount.setBalance(sourceAccount.getBalance() - trans.getTransactionValue());
					aManager.update(sourceAccount);
					te.setSourceAccountID(sourceAccount);
	
					BankEntity destinationBank = bManager.getBankByName(trans.getDestinationAccount().getBankID());
					if (destinationBank == null) {
						destinationBank = new BankEntity();
						destinationBank.setName(trans.getDestinationAccount().getBankID());
						destinationBank.setId(bManager.saveBank(destinationBank));
					}
					AccountEntity destinationAccount = aManager
							.getAccountByNumberAndBankId(trans.getDestinationAccount().getAccountID(), destinationBank);
					if (destinationAccount == null) {
						destinationAccount = new AccountEntity();
						destinationAccount.setNumber(trans.getDestinationAccount().getAccountID());
						destinationAccount.setBalance(0D);
						destinationAccount.setBankID(destinationBank);
						aManager.saveAccount(destinationAccount);
					}
					destinationAccount.setBalance(destinationAccount.getBalance() + trans.getTransactionValue());
					aManager.update(destinationAccount);
					te.setDestinationAccountID(destinationAccount);
					te.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
	
					tManager.saveTransaction(te);
	
				}
				break;
			}
		}

		return new ModelAndView("listTransactionsView", "uploadedTransactions", uploadedTransactions);
	}
	
}
