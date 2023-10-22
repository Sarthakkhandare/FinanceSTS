package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerPermanent 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permanentId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private Double pinCode;
	private String houseNo;
	private String streetName;
	
	

	

}
