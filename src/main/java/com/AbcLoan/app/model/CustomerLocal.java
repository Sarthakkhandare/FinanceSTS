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
public class CustomerLocal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private Integer pinCode;
	private String houseNo;
	private String streetName;
	
	
	

}
