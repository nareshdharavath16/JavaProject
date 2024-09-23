package com.qualifyde.kamai.userportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qualifyde.kamai.userportal.domain.EducationDetail;

@Repository
public interface EducationDetailRepository extends JpaRepository<EducationDetail, Long> {
}
