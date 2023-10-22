package com.AbcLoan.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AbcLoan.app.model.CustomerApplicationForm;


@Repository
public interface CustomerApplicationRepository extends JpaRepository<CustomerApplicationForm, Long>
{

	List<CustomerApplicationForm> findAllByStatusCode(String statusCode);
	

}
