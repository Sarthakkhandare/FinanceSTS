package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanctionLetter {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long sanctionId;
	private String sanctionDate;
	private String applicantName;
	private String contactDetails;
	private Double loanAmountSanctioned;
	private String interestType;
	private Float rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String modeOfPayment;

}
