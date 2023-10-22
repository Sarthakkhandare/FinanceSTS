package com.AbcLoan.app.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AbcLoan.app.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long>
{

	public List<Enquiry> findAllByRemark(String forwardedRemark);
//
//	public Enquiry findByEnquiryId(Long enquiryId);
//	

}
