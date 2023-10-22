package com.AbcLoan.app.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbcLoan.app.Repository.CustomerApplicationRepository;
import com.AbcLoan.app.model.CustomerApplicationForm;
import com.AbcLoan.app.model.Ledger;
import com.AbcLoan.app.model.LoanDisbursement;
import com.AbcLoan.app.model.SanctionLetter;
import com.AbcLoan.app.serviceI.CustomerApplicationServiceI;


@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationServiceI
{
	@Autowired
	CustomerApplicationRepository customerRepository;

	@Override
	public void saveCustomerApplication(CustomerApplicationForm customerApplication) 
	{
		LoanDisbursement ld =new  LoanDisbursement();
		ld.setLoanNumber(0l);
		ld.setAggrementDate("");
		ld.setAccountType("");
		ld.setAmountPaidDate("");
		ld.setAmountPayType("");
		ld.setTotalAmount(0.0);
		ld.setBankName("");
		ld.setAccountNumber(0l);
		ld.setIfscCode("");
		ld.setTransferAmount(0.0);
		ld.setPaymentStatus("");
		
		 Ledger ledger =new Ledger();
		 ledger.setLedgerCreatedDate("");
		 ledger.setTotalLoanAmount(0.0);
		 ledger.setPayableAmountWithInterest(0.0);
		 ledger.setNextEmiDateEnd("");
		 ledger.setNextEmiDateStart("");
		 ledger.setRemainingAmount(0.0);
		 ledger.setDefaulterCount(0);
		 ledger.setTenure(0);
		 ledger.setMonthlyEmi(0.0);
		 ledger.setAmountPaidTillDate(0.0);
		 ledger.setPreviousEmiStatus("");
		 ledger.setCurrentMonthEmiStatus("");
		 ledger.setLoanEndDate("");
		 ledger.setLoanStatus("");
		 
	 SanctionLetter sl =new SanctionLetter();
		sl.setSanctionDate("");
		sl.setLoanAmountSanctioned(0.0);
		sl.setLoanTenure(0);
		sl.setInterestType("");
		sl.setRateOfInterest(0.0F);
		sl.setMonthlyEmiAmount(0.0);
		sl.setModeOfPayment("");
		sl.setApplicantName("");
		sl.setContactDetails("");
		
		customerApplication.setLedger(ledger);
		customerApplication.setLoanDisbursement(ld);
		customerApplication.setSanctionLetter(sl);
		
		customerRepository.save(customerApplication);
		
	}

	@Override
	public List<CustomerApplicationForm> getgetAllAppl() {
		
		return customerRepository.findAll();
	}

	@Override
	public CustomerApplicationForm getSingleApple(Long applicationNo) {
		Optional<CustomerApplicationForm> op = customerRepository.findById(applicationNo);
		
		if(op.isPresent())
		{
			CustomerApplicationForm cust=op.get();
		return cust;
		}
		else {
			return null;
		}
	}

	@Autowired 
	EmailService es;
	
	@Override
	public CustomerApplicationForm updateAppln(CustomerApplicationForm customerApplicationForm) {
		if(customerApplicationForm.getStatusCode().equals("disbursed")) {
			
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String ledgerDate =formatter.format(date);
			customerApplicationForm.getLedger().setLedgerCreatedDate(ledgerDate);
			customerApplicationForm.getLoanDisbursement().setAmountPaidDate(ledgerDate);
			customerApplicationForm.getLoanDisbursement().setAggrementDate(ledgerDate);
			
			
//			Date startDate= new Date(customerApplicationForm.getLedger().getLedgerCreatedDate());
//			System.out.println(""+startDate);
//			
			Calendar today =new GregorianCalendar();
			today.setTime(new Date());
			int loanTenure=customerApplicationForm.getSanctionLetter().getLoanTenure();
			Calendar cal = Calendar.getInstance(); 
//			cal.setTime(startDate);
			cal.add(Calendar.MONTH, loanTenure);
			customerApplicationForm.getLedger().setLoanEndDate(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE));
//	
		}
		CustomerApplicationForm cust= customerRepository.save(customerApplicationForm);
		
		if(cust.getStatusCode().equals("disbursed")) {
			es.disburseEmailSend(customerApplicationForm);
		}
		return cust;
		
	}

	@Override
	public List<CustomerApplicationForm> getListByStatus(String statusCode) {
		List<CustomerApplicationForm> verifiedList = customerRepository.findAllByStatusCode(statusCode);
		return verifiedList;
	}

	@Override
	public CustomerApplicationForm updateLedger(CustomerApplicationForm customerApplicationForm) {
		if ( customerApplicationForm.getLedger().getDefaulterCount()>=3) {
			customerApplicationForm.setStatusCode("Defaulter");
			es.Defoulter(customerApplicationForm);
		}
		CustomerApplicationForm cust= customerRepository.save(customerApplicationForm);
		
		return cust;
	}
	
	@Override
	public CustomerApplicationForm payall(CustomerApplicationForm customerApplicationForm) {
		if ( customerApplicationForm.getLedger().getDefaulterCount()>=customerApplicationForm.getSanctionLetter().getLoanTenure()) {
			customerApplicationForm.setStatusCode("Nill Full Loan");
			
		}
		CustomerApplicationForm cust= customerRepository.save(customerApplicationForm);
		
		return cust;
	}

	
}
