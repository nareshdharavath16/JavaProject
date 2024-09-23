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
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserPortalDomain userPortalDomain;

    @Column(name = "street")
    @NotBlank
    @Size(max = 255)
    private String street;

    @Column(name = "city")
    @NotBlank
    @Size(max = 100)
    private String city;

    @Column(name = "state")
    @NotBlank
    @Size(max = 100)
    private String state;

    @Column(name = "zip_code", nullable = false)
    @NotBlank
    @Size(max = 20)
    private String zipCode;

    @Column(name = "country")
    @NotBlank
    @Size(max = 100)
    private String country;
}