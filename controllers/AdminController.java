package com.bank.controllers;
import javax.swing.JOptionPane;

public class AdminController {
	public static void main(String[] args) {
		while(true){
			switch(JOptionPane.showInputDialog("0.종료")) {
			case "0": 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1": break;
			case "2": break;
			case "3": break;
			case "4": break;
			
			}
		}
	}

}
