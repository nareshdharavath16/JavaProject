package com.qualifyde.kamai.userportal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 

public class PersonalDetailDTO {
	
    private Long id;
    private Long userId;
    private String gender;
    private String martialStatus;
    private String citizen;
    private String physicallyHandicapped;
    
}
