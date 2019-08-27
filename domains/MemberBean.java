package com.bank.domains;

public class MemberBean {
	private String id, pass, name, ssn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", 비번="
					+ pass+ ", 이름=" + name + ", 주민번호=" + ssn + "]";
	}
	

}
