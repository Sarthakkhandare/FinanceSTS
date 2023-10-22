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
public class PreviousLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long previousLoanId;
	private Double previousLoanAmount;
	private Double paidAmount;
	private Double remainingAmount;
	private Integer defaulterCount;
	private String loanStatus;
	private String remark;
	
	@OneToOne(cascade =CascadeType.ALL)
	private PreviousLoanBank previousBankDetails;
	


}
