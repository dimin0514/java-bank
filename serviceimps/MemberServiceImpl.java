package com.bank.serviceimps;
import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.services.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private CustomerBean[] customers;
	private EmployeeBean[] employees;
	private int custCount, empCount;
	
	public MemberServiceImpl() {
		
		customers = new CustomerBean[10];
		employees = new EmployeeBean[10];
		custCount=0;
		empCount=0;
	}
	
	@Override
	public void join(CustomerBean param) {
		customers[custCount] = param;
		custCount++;
	}
	
	@Override
	public void register(EmployeeBean param) {
		employees[empCount] = param;
		empCount++;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}

	@Override
	public EmployeeBean[] findAllEmployees() {
		return employees;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int count1 = 0, count2 = 0, count3 = 0;
		for(int i=0;i< custCount;i++) {
			if(name.equals(customers[i].getName())) {
				count1++;
				break;
			}
		}
		for(int i=0;i< empCount;i++) {
			if(name.equals(employees[i].getName())) {
				count2++;
				break;
			}
		}
		count3 = count1 + count2;
		MemberBean[] members = new MemberBean[count3];
		int j = 0;
		for(int i=0;i< custCount;i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(count1==j) {
					break;
				}
				
			}
		}
		int k = 0; 
		for(int i=0;i< empCount;i++) {
			if(name.equals(employees[i].getName())) {
				members[j] = employees[i];
				k++;
				j++;
				if(count2==k) {
					break;
				}
				break;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean c = new MemberBean();
		for(int i=0;i< custCount;i++) {
			if(id.equals(customers[i].getId())) {
				c = customers[i];
				break;
			}
		}
		for(int i=0;i< empCount;i++) {
			if(id.equals(employees[i].getId())) {
				c = employees[i];
				break;
			}
		}
		return c;
	}
	

	@Override
	public boolean login(MemberBean param) {
		
		return findById(param.getId())
				.getPass()
				.equals(param.getPass());
	}

	@Override
	public int countCustomers() {
		return custCount;
	}

	@Override
	public int countEmployees() {
		return empCount;
	}

	@Override
	public boolean existId(String id) {
		boolean flag = false;
		for(int i=0;i< custCount;i++) {
			if(id.equals(customers[i].getId())) {
				flag = true;
				break;
			}
		}
		for(int i=0;i< empCount;i++) {
			if(id.equals(employees[i].getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String[] passwords = param.getPass().split(",");
		String oldPass = passwords[0];
		String newPass = passwords[1];
		param.setPass(oldPass);
		if(login(param)) {
			for(int i=0;i< custCount;i++) {
				if(id.equals(customers[i].getId())) {
					customers[i].setPass(newPass);;
					break;
				}
			}
			for(int i=0;i< empCount;i++) {
				if(id.equals(employees[i].getId())) {
					employees[i].setPass(newPass);
					break;
				}
			}
		}
		
		
	}

	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			int i = 0;
			for(;i< custCount;i++) {
				if(customers[i].getId().equals(param.getId())) {
					customers[i] = customers[custCount-1];
					custCount--;
					break;
				}
			}
			i = 0;
			for(;i< empCount;i++) {
				if(employees[i].getId().equals(param.getId())) {
					employees[i] = employees[empCount-1];
					empCount--;
					break;
				}
			}
		}
	}
}