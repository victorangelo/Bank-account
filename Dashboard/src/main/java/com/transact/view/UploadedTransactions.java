package com.transact.view;


/**
 *  This class designates a front end bean for transactions.
 * @author Victor Angheluta
 */
public class UploadedTransactions {

	private Integer totalTransactions;
	private String uploadedDate;
	
	public UploadedTransactions(){
		this.totalTransactions = 0;
		this.uploadedDate = "0:00";
	}
	
	public Integer getTotalTransactions() {
		return totalTransactions;
	}
	public void setTotalTransactions(Integer totalTransactions) {
		this.totalTransactions = totalTransactions;
	}
	public String getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
}
