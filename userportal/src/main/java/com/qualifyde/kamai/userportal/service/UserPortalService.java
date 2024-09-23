package com.qualifyde.kamai.userportal.service;

import java.util.List;

import com.qualifyde.kamai.userportal.domain.UserPortalDomain;
import com.qualifyde.kamai.userportal.dto.UserPortalDTO;

public interface UserPortalService {
    UserPortalDomain addUserPortal(UserPortalDTO userPortalDTO);
    List<UserPortalDTO> getAllUsers();
    UserPortalDTO getUserPortalById(Long userId);
}
