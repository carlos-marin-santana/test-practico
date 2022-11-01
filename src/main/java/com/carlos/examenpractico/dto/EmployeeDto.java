package com.carlos.examenpractico.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gender_id")
    private Long genderId;
    @Column(name = "job_id")
    private Long jobId;
    @ManyToOne
    @JoinColumn(name = "gender_id", insertable = false, updatable = false)
    private GenderDto gender;
    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private JobDto job;
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTHDATE")
    private Date birthDate;
}
