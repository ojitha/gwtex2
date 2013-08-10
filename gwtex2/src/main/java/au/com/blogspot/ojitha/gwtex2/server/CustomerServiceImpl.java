package au.com.blogspot.ojitha.gwtex2.server;

import org.springframework.beans.factory.annotation.Autowired;

import au.com.blogspot.ojitha.gwtex2.client.CustomerService;
import au.com.blogspot.ojitha.gwtex2.shared.CustomerDto;
import au.com.blogspot.ojitha.server.service.CustomerBusinessService;
import au.com.blogspot.ojitha.server.spring.GWTSpringAwareContext;

public class CustomerServiceImpl extends GWTSpringAwareContext implements
		CustomerService {

	@Autowired
	CustomerBusinessService customerBusinessService;
	
	@Override
	public Boolean addCustomer(CustomerDto customer)
			throws IllegalArgumentException {
		this.customerBusinessService.save(customer);
		return null;
	}

}
