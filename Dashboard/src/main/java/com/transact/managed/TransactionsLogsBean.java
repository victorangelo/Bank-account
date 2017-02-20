package com.transact.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="history")
@RequestScoped
public class TransactionsLogsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{history_log}")
	private List<TransactionLogBean> history_log;
	
	public TransactionsLogsBean(){
		
		//temporary
		history_log = new ArrayList<TransactionLogBean>();
		TransactionLogBean transactionLogBean = new TransactionLogBean();
		transactionLogBean.setID(10L); transactionLogBean.setTransactedValue(100D); Calendar cal = Calendar.getInstance(); cal.set(2017, 02, 10); transactionLogBean.setDate(cal.getTime());
		history_log.add(transactionLogBean);
		
		transactionLogBean = new TransactionLogBean();
		transactionLogBean.setID(10L); transactionLogBean.setTransactedValue(200D); cal = Calendar.getInstance(); cal.set(2017, 02, 11); transactionLogBean.setDate(cal.getTime());
		history_log.add(transactionLogBean);
		//temporary
	}
	
	
	public List<TransactionLogBean> getHistory_log() {
		return history_log;
	}
	public void setHistory_log(List<TransactionLogBean> history_log) {
		this.history_log = history_log;
	}
}
