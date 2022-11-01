package com.carlos.examenpractico.model;

import com.carlos.examenpractico.dto.EmployeeDto;
import com.carlos.examenpractico.dto.GenderDto;
import com.carlos.examenpractico.dto.JobDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeesResponse extends BaseModel{

    private List<EmployeeResponse> employees;

    @Builder
    public EmployeesResponse(List<EmployeeDto> employees, Boolean success){
        super(success);
        if(employees!= null && employees.size() >0){
            List<EmployeeResponse> employeesList = new ArrayList<>();
            for(EmployeeDto employeeDto : employees){
                employeesList.add(new EmployeeResponse(employeeDto, employeeDto.getGender(), employeeDto.getJob(),
                        employeeDto.getJobId(), employeeDto.getGenderId()));
                this.employees = employeesList;
            }
        }
    }
}
