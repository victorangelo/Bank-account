package com.transact.model.transaction;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactionslogs")
public class TransactionsLogs {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long ID;
	
	@Column(name = "value")
	Double transactedValue;
	
	@Column(name = "date")
	Date date;

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
