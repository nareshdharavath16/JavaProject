package com.qualifyde.kamai.userportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualifyde.kamai.userportal.domain.EducationDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class EducationDetailService {
	
	@Autowired
    private EntityManager entityManager;
	
	
	public EducationDetail saveEducationDetail(EducationDetail educationdetail) {
        if (educationdetail.getId() == null) {
            entityManager.persist(educationdetail);
            return educationdetail;
        } else {
            return entityManager.merge(educationdetail); 
        }
    }

}
