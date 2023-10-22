package com.AbcLoan.app.serviceI;

import java.util.List;

import com.AbcLoan.app.model.CustomerApplicationForm;

public interface CustomerApplicationServiceI 
{

	void saveCustomerApplication(CustomerApplicationForm customerApplication);

	List<CustomerApplicationForm> getgetAllAppl();

	CustomerApplicationForm getSingleApple(Long applicationNo);

	CustomerApplicationForm updateAppln(CustomerApplicationForm customerApplicationForm);

	List<CustomerApplicationForm> getListByStatus(String statusCode);

	CustomerApplicationForm updateLedger(CustomerApplicationForm customerApplicationForm);
	CustomerApplicationForm payall(CustomerApplicationForm customerApplicationForm);
}
