package com.carlos.examenpractico.model;

import com.carlos.examenpractico.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeesMapResponse extends BaseModel{

    private Map<String, List<EmployeeResponse>> employees;

    @Builder
    public EmployeesMapResponse(Map<String, List<EmployeeDto>> employees, Boolean success){
        super(success);
        if(employees != null && employees.size() > 0){
            Map<String, List<EmployeeResponse>> employeesMap = new HashMap<>();
            for(var employeeKeySet : employees.entrySet()){
                List<EmployeeResponse> employeesList = new ArrayList<>();
                for(var employeeDto : employeeKeySet.getValue()){
                    employeesList.add(new EmployeeResponse(employeeDto, employeeDto.getGender(), employeeDto.getJob(),
                            employeeDto.getJobId(), employeeDto.getGenderId()));
                }
                employeesMap.put(employeeKeySet.getKey(), employeesList);

                this.employees = employeesMap;
            }
        }
    }
}
