package com.qualifyde.kamai.userportal.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.qualifyde.kamai.userportal.domain.Address;
import com.qualifyde.kamai.userportal.domain.EducationDetail;
import com.qualifyde.kamai.userportal.domain.PersonalDetail;
import com.qualifyde.kamai.userportal.domain.Role;
import com.qualifyde.kamai.userportal.domain.UserPortalDomain;
import com.qualifyde.kamai.userportal.dto.UserPortalDTO;
import com.qualifyde.kamai.userportal.service.UserPortalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/userportal")
public class UserPortalController {
    
    private final UserPortalService userPortalService;
   
    private Address address;
   
    private EducationDetail educationDetail;
   
    private Role role;
    
    private PersonalDetail personalDetail;
    

    @Autowired
    private ModelMapper modelMapper;

    public UserPortalController(UserPortalService userPortalService) {
        this.userPortalService = userPortalService;
    }

    @PostMapping("userportal/create")
    public ResponseEntity<UserPortalDTO> addUserPortal(@Valid @RequestBody UserPortalDTO userPortalDTO) {
        UserPortalDomain savedUser = userPortalService.addUserPortal(userPortalDTO);
        return new ResponseEntity<>(modelMapper.map(savedUser, UserPortalDTO.class), HttpStatus.OK);
    }

    @GetMapping("userportal/all")
    public ResponseEntity<List<UserPortalDTO>> getAllUsers() {
        List<UserPortalDTO> users = userPortalService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("userportal/{id}")
    public ResponseEntity<UserPortalDTO> getUserPortalById(@PathVariable Long id) {
        UserPortalDTO user = userPortalService.getUserPortalById(id);
        Context context = new Context();
        context.setVariable("firstname", user.getFirstName());
        context.setVariable("lastname", " "+user.getLastName()); 
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
