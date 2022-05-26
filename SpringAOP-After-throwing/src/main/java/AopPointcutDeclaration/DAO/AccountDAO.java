package AopPointcutDeclaration.DAO;


import AopPointcutDeclaration.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {

		// for academic purpose ... simulate an exception
		if (tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}

		List<Account> myAccounts=new ArrayList<>();
		//create sample accounts
		Account t1=new Account("jhanu","silver");
		Account t2=new Account("arifa","platinum");
		Account t3=new Account("hello","orange");
		//add them to our list
		myAccounts.add(t1);
		myAccounts.add(t2);
		myAccounts.add(t3);

		return myAccounts;
	}
	
	public void addAccount(String b) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public String setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}




