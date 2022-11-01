package com.carlos.examenpractico.model;

import com.carlos.examenpractico.dto.EmployeeDto;
import com.carlos.examenpractico.dto.GenderDto;
import com.carlos.examenpractico.dto.JobDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse extends BaseModel{

    private Long id;
    @JsonProperty("gender_id")
    private Long genderId;
    @JsonProperty("job_id")
    private Long jobId;
    private GenderDto gender;
    private JobDto job;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;

    public EmployeeResponse(EmployeeDto employeeDto, GenderDto gender, JobDto job, Long jobId, Long genderId){
        this.id = employeeDto.getId();
        this.genderId = genderId;
        this.jobId = jobId;
        this.gender = gender;
        this.job = job;
        this.name = employeeDto.getName();
        this.lastName = employeeDto.getLastName();
        this.birthdate = employeeDto.getBirthDate();
    }

}
