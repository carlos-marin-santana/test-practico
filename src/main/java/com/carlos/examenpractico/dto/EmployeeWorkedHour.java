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
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "WORKED_HOURS")
    private Integer workedHours;
    @Column(name = "WORKED_DATE")
    //@Temporal(TemporalType.DATE)
    private Date workedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeDto employeeDto;
}
