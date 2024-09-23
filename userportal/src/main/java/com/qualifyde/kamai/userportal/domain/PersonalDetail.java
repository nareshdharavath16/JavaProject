package com.qualifyde.kamai.userportal.domain;
import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "personal_details")
@Data
@NoArgsConstructor
public class PersonalDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPortalDomain userPortalDomain;
     
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "martial_status")
    private String martialStatus;
    
    @Column(name = "citizen")
    private String citizen;
    
    @Column(name = " physically_handicapped")
    private String physicallyHandicapped;
    
    
   
}
