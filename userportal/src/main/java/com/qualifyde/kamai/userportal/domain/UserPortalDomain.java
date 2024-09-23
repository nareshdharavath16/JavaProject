package com.qualifyde.kamai.userportal.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "user_portal")
@Data
@NoArgsConstructor
public class UserPortalDomain implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
   
    @Column(name="date_birth",nullable=false)
    private LocalDate dateBirth;

//    @Column(name = "username", nullable = false, unique = true)
//    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    
    
    @Column(name = "html_template")
    private String htmlTemplate;

    @OneToMany(mappedBy = "userPortalDomain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @OneToMany(mappedBy = "userPortalDomain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationDetail> educationDetails;

    @OneToMany(mappedBy = "userPortalDomain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Role> roles;

    @OneToMany(mappedBy = "userPortalDomain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonalDetail> personalDetails;

}
