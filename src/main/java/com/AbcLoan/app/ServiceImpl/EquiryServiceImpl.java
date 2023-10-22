package com.AbcLoan.app.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AbcLoan.app.Repository.EnquiryRepository;
import com.AbcLoan.app.model.CibilScore;
import com.AbcLoan.app.model.Enquiry;
import com.AbcLoan.app.serviceI.EnquiryServiceI;

@Service
public class EquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository repository;

	
	@Override
	public List<Enquiry> getAllEnquiry() 
	{
		List<Enquiry> listenquiry = repository.findAll();
		return listenquiry;
	}

	@Override
	public void saveEnquiry(Enquiry enquiry) 
	{
		CibilScore cb=new CibilScore();
		cb.setCibilScore(0);
		cb.setCibilScoreDate("");
		cb.setStatus("");
		enquiry.setCibilScore(cb);
		enquiry.setRemark("enquiry");
	   repository.save(enquiry);
		
	   
	}
	
	@Override
	public void UpdateStatus(Enquiry enquiry) {
		
		repository.save(enquiry);
	}

	
	@Override
	public Enquiry generateCibil(Enquiry oenquiry) {

		CibilScore cibil =new CibilScore();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
		cibil.setCibilScoreDate(formatter.format(date));
		
		int max =850;
		int min = 650;
		int score=(int)(Math.random()*(max-min))+min;
		cibil.setCibilScore(score);
		if ( score>750) {
			cibil.setStatus("good");
		}
		else {
			cibil.setStatus("poor");
		}

		oenquiry.setCibilScore(cibil);
		Enquiry oper=repository.save(oenquiry);
		return oper;

	}

	@Override
	public List<Enquiry> findByRemark(String forwardedRemark) {
		
		 List<Enquiry> oeList=repository.findAllByRemark(forwardedRemark);
		return oeList;
	}

	@Override
	public void rejectEnquiry(Enquiry rejectednquiry) {
	repository.save(rejectednquiry);
	}
	
	@Autowired 
	EmailService es;

	@Override
	public void approveEnquiry(Enquiry approvedEnquiry) {
		repository.save(approvedEnquiry);
		
		es.approvedEmailSend(approvedEnquiry.getEmail());
	}

	@Override
	public Enquiry getSingleEnquiry(Long enquiryId) {
		Optional<Enquiry> optional= repository.findById(enquiryId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	

	
}
