package service;

import java.util.Set;

import entities.Customer;

public interface ICustomerService {
	 
void addCustomer(Customer c);
	
	Customer findEmployeeByMobileNo(String mobileNo);
	
	Set<Customer> allCustomers();

}
