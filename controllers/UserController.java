package com.bank.controllers;
import javax.swing.JOptionPane;

import com.bank.domains.MemberBean;
import com.bank.serviceimps.MemberServiceImpl;
import com.bank.services.MemberService;

public class UserController {
	public static void main(String[] args) {
		MemberBean member = null;
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료  1.가입")) {
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1" : 
				String spec = JOptionPane.showInputDialog("id, pass, name, ssn"); 
				String[] arr = spec.split(","); 
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPass(arr[2]);
				member.setSsn(arr[3]);
							
				
				break;
			case "2" : break;
			case "3" : break;
			case "4" : break;
			case "5" : break;
			
			}
		}
		
	}

}
