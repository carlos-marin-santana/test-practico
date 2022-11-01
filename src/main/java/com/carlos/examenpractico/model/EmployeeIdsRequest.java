package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeIdsRequest {
    @JsonProperty("employee_id")
    private List<Long> employeeIds;
}
