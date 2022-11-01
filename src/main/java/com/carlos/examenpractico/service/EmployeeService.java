package com.carlos.examenpractico.service;

import com.carlos.examenpractico.model.EmployeeRequest;
import com.carlos.examenpractico.model.WorkedHoursPaymentRequest;
import com.carlos.examenpractico.dto.EmployeeDto;
import com.carlos.examenpractico.model.WorkedHoursResponse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    EmployeeDto findEmployeeById(Long id);

    Long saveEmployee(EmployeeRequest employeeDto);

    Map<String, List<EmployeeDto>> findEmployeesByJobId(Long jobId);

    CompletableFuture<List<EmployeeDto>> getEmployeesById(List<Long> ids);
}
