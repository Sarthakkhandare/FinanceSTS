package com.AbcLoan.app.serviceI;

import java.util.List;

import com.AbcLoan.app.model.Enquiry;


public interface EnquiryServiceI
{

	public 	List<Enquiry> getAllEnquiry();

	 public void saveEnquiry(Enquiry enquiry);

//	 public void saveOperationEnquiry(Enquiry operEnquiry);
//
//	public List<OperationEnquiry> getAllOperationEnquiry();
//


	public void UpdateStatus(Enquiry enquiry);

	public Enquiry generateCibil(Enquiry oenquiry);

	public List<Enquiry> findByRemark(String forwardedRemark);

	public void rejectEnquiry(Enquiry rejectednquiry);

	public void approveEnquiry(Enquiry approvedEnquiry);

	public Enquiry getSingleEnquiry(Long enquiryId);

}
