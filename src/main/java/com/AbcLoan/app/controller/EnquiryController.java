package com.AbcLoan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AbcLoan.app.model.Enquiry;
import com.AbcLoan.app.serviceI.EnquiryServiceI;

@CrossOrigin("*")
@RestController
public class EnquiryController 
{
	@Autowired
	EnquiryServiceI enquiryService;
	
	//http://localhost:8888/enquiry
	@PostMapping(value="/enquiry")
	public String saveEnquiry(@RequestBody Enquiry enquiry)
	{
		
		enquiryService.saveEnquiry(enquiry);
		return "Data Save Succefully";
	}  
	
	
	//http://localhost:8888/enquiry
	@GetMapping(value="/enquiry")
	public List<Enquiry> getAllEnquiry()
	{
		List<Enquiry> listenquiry = enquiryService.getAllEnquiry();
		return listenquiry;
	}
	
	@PutMapping("/enquiry/{id}")
	public String updateEnquiry(@RequestBody Enquiry enquiry, @PathVariable Long id) {
		enquiry.setEnquiryId(id);
		enquiryService.UpdateStatus(enquiry);
		
		return "data added successfully";
	}
	

	@PutMapping("/generate/{id}")
	public Enquiry generateCibil(@PathVariable ("id") Long id, @RequestBody Enquiry oenquiry) {
		oenquiry.setEnquiryId(id);
		Enquiry oer=enquiryService.generateCibil(oenquiry);
		return oer;
	}
	
	@GetMapping("/oeEnquiry")
	public List<Enquiry> getOperationEnquiry(){
		List<Enquiry> elist= enquiryService.findByRemark("forwarded");
		return elist;
	}
	
	@PutMapping("/rejected/{id}")
	public String rejectEnquiry( @PathVariable ("id") Long id, @RequestBody Enquiry rejectedEnquiry) {
			
		rejectedEnquiry.setEnquiryId(id);
		enquiryService.rejectEnquiry(rejectedEnquiry);
		
		return"Enquiry rejected successfully";
	}
	@PutMapping("/approved/{id}")
	public String  approvedEnquiry (@PathVariable ("id") Long id, @RequestBody Enquiry approvedEnquiry)
	{
		approvedEnquiry.setEnquiryId(id);
		enquiryService.approveEnquiry(approvedEnquiry);
		
		return "enquiry approved !";
	}
	
	@GetMapping("/enquiry/{enquiryId}")
	public Enquiry getSingleEnquiry (@PathVariable ("enquiryId") Long enquiryId)
	{
		
		Enquiry e=this.enquiryService.getSingleEnquiry(enquiryId);
		return e;
	}
	
	

}
