package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeRequest{

    @JsonProperty("gender_id")
    private Long genderId;
    @JsonProperty("job_id")
    private Long jobId;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;

}
