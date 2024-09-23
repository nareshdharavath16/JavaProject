package com.qualifyde.kamai.userportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qualifyde.kamai.userportal.domain.UserPortalDomain;

public interface UserPortalRepository extends JpaRepository<UserPortalDomain, Long> {
}
