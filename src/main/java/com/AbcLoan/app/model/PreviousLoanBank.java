package com.AbcLoan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PreviousLoanBank
{
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long branchId;
	 private String branchName;
	 private String ifscCode;
	 private String micrCode;
	 private Long contactNo;
	 private String email;
	 private String status;
	 
	@OneToOne(cascade = CascadeType.ALL)
    private PreviousBankAddress bankAddress;
	


}
