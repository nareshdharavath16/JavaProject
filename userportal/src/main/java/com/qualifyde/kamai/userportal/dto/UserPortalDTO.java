package com.qualifyde.kamai.userportal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserPortalDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
//    private String username;
    private String password;
    private String mobileNumber;
    private String email;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    
    private String htmlTemplate;

    private List<AddressDTO> addresses = new ArrayList<>();
    private List<EducationDetailDTO> educationDetails = new ArrayList<>();
    private List<RoleDTO> roles = new ArrayList<>();
    private List<PersonalDetailDTO> personalDetails = new ArrayList<>();
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
