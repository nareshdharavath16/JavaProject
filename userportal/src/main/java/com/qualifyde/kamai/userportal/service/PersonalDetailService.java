package com.qualifyde.kamai.userportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualifyde.kamai.userportal.domain.PersonalDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonalDetailService {
	  @Autowired
	    private EntityManager entityManager;

	    public PersonalDetail saveUserRole(PersonalDetail personalDetail) {
	        if (personalDetail.getId() == null) {
	            entityManager.persist(personalDetail);
	            return personalDetail;
	        } else {
	            return entityManager.merge(personalDetail); 
	        }
	    }

}
