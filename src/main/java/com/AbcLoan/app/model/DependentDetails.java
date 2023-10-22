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
public class DependentDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long dependantId;
	private	String fatherName;
	private	String motherName;
	private	Integer noOfFamilyMember;
	private	Integer noOfChild;
//	private	String maritalStatus;
	private	Integer dependentMember;
	private	Double familyIncome;
	private	String spouseName;

}
