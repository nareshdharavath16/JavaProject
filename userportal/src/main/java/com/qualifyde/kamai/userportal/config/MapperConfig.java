package com.qualifyde.kamai.userportal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qualifyde.kamai.userportal.domain.Address;
import com.qualifyde.kamai.userportal.domain.EducationDetail;
import com.qualifyde.kamai.userportal.domain.Role;
import com.qualifyde.kamai.userportal.domain.UserPortalDomain;
import com.qualifyde.kamai.userportal.domain.PersonalDetail;
import com.qualifyde.kamai.userportal.dto.AddressDTO;
import com.qualifyde.kamai.userportal.dto.EducationDetailDTO;
import com.qualifyde.kamai.userportal.dto.RoleDTO;
import com.qualifyde.kamai.userportal.dto.UserPortalDTO;
import com.qualifyde.kamai.userportal.dto.PersonalDetailDTO;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(UserPortalDTO.class, UserPortalDomain.class)
        .addMapping(UserPortalDTO::getHtmlTemplate, UserPortalDomain::setHtmlTemplate);

modelMapper.createTypeMap(UserPortalDomain.class, UserPortalDTO.class)
        .addMapping(UserPortalDomain::getHtmlTemplate, UserPortalDTO::setHtmlTemplate);

        
        
       modelMapper.createTypeMap(AddressDTO.class, Address.class);
       modelMapper.createTypeMap(Address.class, AddressDTO.class);
       
       modelMapper.createTypeMap(EducationDetailDTO.class, EducationDetail.class);
       modelMapper.createTypeMap(EducationDetail.class, EducationDetailDTO.class);
       
        modelMapper.createTypeMap(RoleDTO.class, Role.class);
        modelMapper.createTypeMap(Role.class, RoleDTO.class);
        
        modelMapper.createTypeMap(PersonalDetailDTO.class,PersonalDetail.class);
        modelMapper.createTypeMap(PersonalDetail.class, PersonalDetailDTO.class);


        return modelMapper;
    }
}
