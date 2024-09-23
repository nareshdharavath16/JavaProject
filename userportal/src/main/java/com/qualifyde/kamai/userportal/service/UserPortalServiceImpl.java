package com.qualifyde.kamai.userportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qualifyde.kamai.userportal.domain.Address;
import com.qualifyde.kamai.userportal.domain.EducationDetail;
import com.qualifyde.kamai.userportal.domain.PersonalDetail;
import com.qualifyde.kamai.userportal.domain.Role;
import com.qualifyde.kamai.userportal.domain.UserPortalDomain;
import com.qualifyde.kamai.userportal.dto.UserPortalDTO;
import com.qualifyde.kamai.userportal.repository.UserPortalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserPortalServiceImpl implements UserPortalService {

    private final UserPortalRepository userPortalRepository;
    private final ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserPortalServiceImpl(UserPortalRepository userPortalRepository, ModelMapper modelMapper) {
        this.userPortalRepository = userPortalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserPortalDomain addUserPortal(UserPortalDTO userPortalDTO) {
        UserPortalDomain userPortalDomain = modelMapper.map(userPortalDTO, UserPortalDomain.class);
        userPortalDomain.setCreatedOn(LocalDateTime.now());
        userPortalDomain.setUpdatedOn(LocalDateTime.now());
        
        userPortalDomain.setHtmlTemplate(userPortalDTO.getHtmlTemplate());

        List<Address> addresses = userPortalDTO.getAddresses().stream()
                .map(addressDTO -> modelMapper.map(addressDTO, Address.class))
                .collect(Collectors.toList());
        addresses.forEach(address -> address.setUserPortalDomain(userPortalDomain));
        userPortalDomain.setAddresses(addresses);

        List<EducationDetail> educationDetails = userPortalDTO.getEducationDetails().stream()
                .map(educationDetailDTO -> modelMapper.map(educationDetailDTO, EducationDetail.class))
                .collect(Collectors.toList());
        educationDetails.forEach(educationDetail -> educationDetail.setUserPortalDomain(userPortalDomain));
        userPortalDomain.setEducationDetails(educationDetails);

        List<Role> roles = userPortalDTO.getRoles().stream()
                .map(roleDTO -> modelMapper.map(roleDTO, Role.class))
                .collect(Collectors.toList());
        roles.forEach(role -> role.setUserPortalDomain(userPortalDomain));
        userPortalDomain.setRoles(roles);

        List<PersonalDetail> personalDetails = userPortalDTO.getPersonalDetails().stream()
                .map(personalDetailDTO -> modelMapper.map(personalDetailDTO, PersonalDetail.class))
                .collect(Collectors.toList());
        personalDetails.forEach(personalDetail -> personalDetail.setUserPortalDomain(userPortalDomain));
        userPortalDomain.setPersonalDetails(personalDetails);

        return userPortalRepository.save(userPortalDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPortalDTO> getAllUsers() {
        List<UserPortalDomain> userDomains = userPortalRepository.findAll();
        return userDomains.stream()
                .map(userDomain -> modelMapper.map(userDomain, UserPortalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UserPortalDTO getUserPortalById(Long userId) {
        Optional<UserPortalDomain> userPortalDomain = userPortalRepository.findById(userId);
        return userPortalDomain.map(domain -> modelMapper.map(domain, UserPortalDTO.class)).orElse(null);
    }
}
