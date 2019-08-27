package com.bank.domains;

public class AccountBean {
	
	private String accountNum, today, money;

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getToday() {
		return today;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoney() {
		return money;
	}
	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNum + ", 거래일자=" + today + ", 금액=" + money + "]";
	}

}
