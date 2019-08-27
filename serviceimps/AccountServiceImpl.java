package com.bank.serviceimps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bank.domains.AccountBean;
import com.bank.services.AdminService;

public class AccountServiceImpl implements AdminService {
	private AccountBean[] accounts;
	private int count;
	
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
		
	}
	
	@Override
	public void createAccount(int money) {
		//accountNum, today, money
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money+"");
		acc.setToday(findDate());
		
		accounts[count] = acc; 
		count++; 
		
	}
	@Override
	public String createAccountNum() {
		String accountNum="";
		Random ran = new Random();
		
		for(int i=0;i<9;i++){
			accountNum +=(i==4)?"-":ran.nextInt(10);
		}
		return accountNum;
	}
	@Override
	public AccountBean[] findAll() {
		return accounts;
	}
	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean ac = new AccountBean();
		for(int i=0;i<count;i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				ac= accounts[i];
				break;
			}
		}
		return ac;
	}
	@Override
	public int countAccounts() {
		return count;
	}
	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i=0;i<count;i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM=dd hh:mm").format(new Date());
	
	}
	@Override
	public void depositMoney(AccountBean param) {
		String accountNum = param.getAccountNum();
		String oldMoney = param.getMoney();
		int temp = 0;
		int newMoney = Integer.parseInt(oldMoney)+temp;
	
		
		
		
	}
	@Override
	public void withdrawMoney(AccountBean param) {
		
	}
	@Override
	public void deleteAccountNum(String accountNum) {
		
	}
	
	
}
