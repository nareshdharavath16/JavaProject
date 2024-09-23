package com.qualifyde.kamai.userportal.dto;

import java.time.LocalDate;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class EducationDetailDTO {
    private Long id;
//  private Long userId;
    private String institutionName;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
}
