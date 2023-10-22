package com.AbcLoan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AbcLoan.app.model.AllPersonalDocs;
import com.AbcLoan.app.model.CustomerApplicationForm;
import com.AbcLoan.app.serviceI.CustomerApplicationServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class CustomerApplicationController 
{
	@Autowired
	CustomerApplicationServiceI customerService;
	
	@PostMapping(value="customerApplicationForm" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveCustomerApplication(
			@RequestPart ("professionsalarySlips") MultipartFile professionsalarySlips,
			@RequestPart ("propertyProof") MultipartFile propertyProof,
			@RequestPart ("propertyInsurance") MultipartFile propertyInsurance,
			@RequestPart ("addressProof") MultipartFile addressProof,
			@RequestPart ("panCard") MultipartFile panCard,
			@RequestPart ("incomeTaxReturn") MultipartFile incomeTaxReturn,
			@RequestPart ("adharCard") MultipartFile adharCard,
			@RequestPart ("photo")MultipartFile photo,
			@RequestPart ("signature")MultipartFile signature, 
			@RequestPart ("thumb") MultipartFile thumb,
			@RequestPart ("bankCheque")MultipartFile bankCheque,
			@RequestPart ("bankStatement") MultipartFile bankStatement ,
            @RequestPart ("customerApplication") String customerApplication)
	{
		ObjectMapper om=new ObjectMapper();
		CustomerApplicationForm customerAppl;
		try {
			customerAppl = om.readValue(customerApplication,CustomerApplicationForm.class);
			customerAppl.getCustomerProfession().setProfessionsalarySlips(professionsalarySlips.getBytes());
			customerAppl.getMortgage().setPropertyInsurance(propertyInsurance.getBytes());
			customerAppl.getMortgage().setPropertyProof(propertyProof.getBytes());
			
				AllPersonalDocs allPersonalDocs=new AllPersonalDocs();
			
				allPersonalDocs.setAddressProof(addressProof.getBytes());
				allPersonalDocs.setPanCard(panCard.getBytes());
				allPersonalDocs.setIncomeTaxReturn(incomeTaxReturn.getBytes());
				allPersonalDocs.setAadhar(adharCard.getBytes());
				allPersonalDocs.setPhoto(photo.getBytes());
				allPersonalDocs.setSignature(signature.getBytes());
				allPersonalDocs.setThumb(thumb.getBytes());
				allPersonalDocs.setBankCheque(bankCheque.getBytes());
				allPersonalDocs.setBankStatement(bankStatement.getBytes());
				
				customerAppl.setAllPersonalDocs(allPersonalDocs);
			
			
			
			customerService.saveCustomerApplication(customerAppl);
			
			return "data save successfully";
			
		}catch (Exception e) {
			
		e.printStackTrace();
		}
		
		return "save customer form";
	}
	
	
	@GetMapping("/getApplication")
	public  List<CustomerApplicationForm> getAllAppl(){
		List <CustomerApplicationForm> applicationList= customerService.getgetAllAppl();
		
		return applicationList;
	}
	
	@GetMapping("/getApplication/{applicationNo}")
	public CustomerApplicationForm getSingleAppl(@PathVariable ("applicationNo") Long applicationNo ){
		CustomerApplicationForm customerApplicationForm= customerService.getSingleApple(applicationNo);
		return customerApplicationForm;
	}
	
	@PutMapping("/updateAppln/{applicationNo}")
	public CustomerApplicationForm updateAppln (@PathVariable ("applicationNo") Long applicationNo ,@RequestBody CustomerApplicationForm customerApplicationForm)
	{	
		customerApplicationForm.setApplicationNo(applicationNo);
		CustomerApplicationForm cust= customerService.updateAppln(customerApplicationForm);
		return cust;
	}
	
	@GetMapping ("/getCmList")
	public List<CustomerApplicationForm> getVerifiedList(){
		
		List<CustomerApplicationForm> verifiedList = customerService.getListByStatus("verified");
		return verifiedList;
	}
	
	@GetMapping ("/getSanctionedList")
	public List<CustomerApplicationForm> getSanctionedList(){
		
		List<CustomerApplicationForm> verifiedList = customerService.getListByStatus("sanctioned");
		return verifiedList;
	}
	
	@GetMapping ("/getforwardSanctionedList")
	public List<CustomerApplicationForm> getforwardSanctionedList(){
		
		List<CustomerApplicationForm> verifiedList = customerService.getListByStatus("forwardedtoAH");
		return verifiedList;
	}
	@GetMapping ("/getDisbursedList")
	public List<CustomerApplicationForm> getDisbursedList(){
		
		List<CustomerApplicationForm> verifiedList = customerService.getListByStatus("disbursed");
		return verifiedList;
	}
	@PutMapping("/updateLedger/{applicationNo}")
	public CustomerApplicationForm updateLedger (@PathVariable ("applicationNo") Long applicationNo ,@RequestBody CustomerApplicationForm customerApplicationForm)
	{	
		customerApplicationForm.setApplicationNo(applicationNo);
		CustomerApplicationForm cust= customerService.updateLedger(customerApplicationForm);
		return cust;
	}
	
	@GetMapping ("/getDefaulterList")
	public List<CustomerApplicationForm> getDefaulterList(){
		
		List<CustomerApplicationForm> verifiedList = customerService.getListByStatus("Defaulter");
		return verifiedList;
	}
	
	@PutMapping("/payall/{applicationNo}")
	public CustomerApplicationForm updateLedgerpay (@PathVariable ("applicationNo") Long applicationNo ,@RequestBody CustomerApplicationForm customerApplicationForm)
	{	
		customerApplicationForm.setApplicationNo(applicationNo);
		CustomerApplicationForm cust= customerService.payall(customerApplicationForm);
		return cust;
	}
	


	
	
}
