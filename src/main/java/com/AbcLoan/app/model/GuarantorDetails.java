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
public class GuarantorDetails 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer guarantorId;
	private String guarantorName;
	private String guarantorDOB;
	private String guarantorRelationshipwithCustomer;
	private Long guarantorMobileNo;
	private Long guarantorAdharcardNo;
	private String guarantorJobDetails;
	private String guarantorCityName;
	private String guarantorAreaName;

}
