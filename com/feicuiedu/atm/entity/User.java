package com.feicuiedu.atm.entity;

/**
 * �û��˻���Ϣ 
 * @author  ������
 */
public class User{
	
	private String accountNumber = "370120180104";
	private String password = "123456";
	private String userName = "wang";
	private Double balance = 10000.00; 

	public String getAccountNumber(){
		return accountNumber;
	}
	public String getPassword(){
		return password;
	}
	public String getUserName(){
		return userName;
	}
	public Double getBalance(){
		return balance;
	}

	public void setBalance(Double balance){
		this.balance=balance;
	}
}