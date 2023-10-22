package com.AbcLoan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PropertyDetails 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long propertyId;
	private	String propertyType;
	private	String propertyArea;
	private	String constructionArea;
	private	Double propertyPrice;
	private	Double constructionPrice;
	
	@OneToOne(cascade =CascadeType.PERSIST)
	private PropertyAddress propertyAddress;

}
