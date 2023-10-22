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
public class PropertyAddress 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyAdrId;
	private	String propertyAreaName;
	private	String propertyCityName;
	private	String propertyDistrict;
	private	String propertyState;
	private	Integer propertyPinCode;
	
}
