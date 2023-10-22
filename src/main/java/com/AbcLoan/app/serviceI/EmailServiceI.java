package com.AbcLoan.app.serviceI;

import org.springframework.web.multipart.MultipartFile;


public interface EmailServiceI {

	void sendSanctionLetter(String toEmail, MultipartFile sanctionLetter);

}
