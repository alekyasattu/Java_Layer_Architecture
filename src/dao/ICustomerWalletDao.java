package dao;

import java.util.Set;

import entities.Customer;

public interface ICustomerWalletDao {

	void addCustomer(Customer c);
	
	Customer findEmployeeByMobileNo(String mobileNo);
	
	Set<Customer> allCustomers();
}
