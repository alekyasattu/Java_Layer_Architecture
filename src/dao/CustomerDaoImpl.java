package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import entities.Customer;
import exceptions.CustomerNotFoundException;

public class CustomerDaoImpl implements ICustomerWalletDao {
	
	private Map<String,Customer> store = new HashMap<>();

	@Override
	public void addCustomer(Customer c) {
		store.put(c.getMobileNo(),c);

	}

	@Override
	public Customer findEmployeeByMobileNo(String mobileNo) {
		Customer c = store.get(mobileNo);
		if(c == null) {
			throw new CustomerNotFoundException("customer not found for mobile no"+mobileNo);
		}
		return c;
	}

	@Override
	public Set<Customer> allCustomers() {
		
		Collection<Customer> customers = store.values();
		Set<Customer> customerSet = new HashSet<Customer>(customers);
		return customerSet;
	}

}
