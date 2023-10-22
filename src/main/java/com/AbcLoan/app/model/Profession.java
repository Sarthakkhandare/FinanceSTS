package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profession 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professionId;
	private String professionType;
	private Double professionSalary;
	private String professionSalaryType;
	private String professionWorkingPeriod;
	private String professionDesignation;
	@Lob
	private byte[] professionsalarySlips;

}
