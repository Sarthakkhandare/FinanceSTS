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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Enquiry 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enquiryId;
	private	String enquiryName;
	private	Integer age;
	private	String email;
	private	Long mobileNo;
	private String pancardNo;
	private String remark;
	
	@OneToOne(cascade=CascadeType.ALL)
	CibilScore cibilScore;


}
