package com.qualifyde.kamai.userportal.service;

import com.qualifyde.kamai.userportal.domain.Address;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class AddressService {

    @Autowired
    private EntityManager entityManager;

    public Address saveAddress(Address address) {
        if (address.getId() == null) {
            entityManager.persist(address);
            return address;
        } else {
            return entityManager.merge(address);
        }
    }
}
