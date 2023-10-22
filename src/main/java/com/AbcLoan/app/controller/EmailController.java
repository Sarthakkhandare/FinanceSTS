package com.AbcLoan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AbcLoan.app.serviceI.EmailServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin("*")
@RestController
public class EmailController {
	@Autowired
	private EmailServiceI es;
	
	
	@PostMapping(value="sendSanction" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String sendSanction (@RequestPart ("toEmail")String toEmail,
					@RequestPart ("sanctionLetter") MultipartFile sanctionLetter) throws JsonMappingException, JsonProcessingException {
//		ObjectMapper om =new ObjectMapper();
		
		
		try {
			es.sendSanctionLetter(toEmail, sanctionLetter);
			return "mail send";
		}catch (Exception e1) {
		
			return "error";
		}
		
		
		
	}

}
