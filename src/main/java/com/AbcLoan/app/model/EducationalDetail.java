package com.AbcLoan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationalDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long educationalId;
	private String educationalSpecialization;
	private Integer passingYear;
	private String qualification;

}
