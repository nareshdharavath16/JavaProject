package com.qualifyde.kamai.userportal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RoleDTO {
    private Long id;
    private Long userId;
    private String roleName;
    private String skills;
    private String experience;
    private Boolean fresher;
    
    
}
