package com.qualifyde.kamai.userportal.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles1")
@Data
@NoArgsConstructor
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserPortalDomain userPortalDomain;
    
//    @Column(name = "user_id", nullable = false)
//    private String userId;

    @Column(name = "role_name", unique = true)
    private String roleName;
    
    
    @Column(name = "skills", nullable = false)
    private String skills;
    
    @Column(name = "experience", nullable = false)
    private String experience;
    
    @Column(name = "fresher", nullable = false)
    private Boolean fresher;
    
    
}
