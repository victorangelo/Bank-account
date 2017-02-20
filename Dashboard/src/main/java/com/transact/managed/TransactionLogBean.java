package com.transact.managed;
import java.io.Serializable;
import java.util.Date;
 
public class TransactionLogBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private Long ID;
    private Double transactedValue;
    private Date date;
    
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Double getTransactedValue() {
		return transactedValue;
	}
	public void setTransactedValue(Double transactedValue) {
		this.transactedValue = transactedValue;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}