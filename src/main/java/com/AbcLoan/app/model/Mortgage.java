package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mortgage 
{
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long mortgageId;
		private	Double propertyValue;
		@Lob
		private	byte[] propertyProof;
		@Lob
		private	byte[] propertyInsurance;
		private	String propertyType;
		private	Double loanOnProperty;
		

		
	}


