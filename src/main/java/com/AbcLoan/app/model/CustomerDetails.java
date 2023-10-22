package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private Long customerMobileno;
    private String customerEmailId;
    private Long adharNo;
    private String pancardNo;
    private String  gender;
    private String customerDOB;
    private Integer customerAge;
    private String loanType;
    private String maritalStatus;
    private Integer cibilScore;
    
    private Double totalLoanRequired;
}
