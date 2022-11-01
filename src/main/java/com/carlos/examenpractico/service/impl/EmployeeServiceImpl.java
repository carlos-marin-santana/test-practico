package com.carlos.examenpractico.service.impl;

import com.carlos.examenpractico.dto.EmployeeDto;
import com.carlos.examenpractico.model.EmployeeRequest;
import com.carlos.examenpractico.repositories.EmployeeRepository;
import com.carlos.examenpractico.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDto> getAllEmployees(){
        return repository.findAll();
    }

    @Override
    public EmployeeDto findEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Long saveEmployee(EmployeeRequest employeeDto){

        if(employeeDto.getGenderId() != null && employeeDto.getJobId() != null && employeeDto.getName() != null &&
                employeeDto.getLastName() != null && employeeDto.getBirthdate()!= null){
            return repository.insertEmployee(employeeDto.getGenderId(), employeeDto.getJobId(), employeeDto.getName(),
                    employeeDto.getLastName(), employeeDto.getBirthdate());
        }
        return null;
    }

    @Override
    public Map<String, List<EmployeeDto>> findEmployeesByJobId(Long jobId) {
        var list = repository.findAll();

        var filteredOrderedList = list.stream()
                .filter(employee -> employee.getJobId().equals(jobId))
                .sorted(Comparator.comparing(EmployeeDto::getLastName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        filteredOrderedList.forEach(e -> {
            e.setGenderId(null);
            e.setJobId(null);
        });

        var result = filteredOrderedList.stream()
                .collect(Collectors.groupingBy(EmployeeDto::getLastName));

        return result;
    }

    @Async
    public CompletableFuture<List<EmployeeDto>> getEmployeesById(List<Long> ids) {
        var list = repository.findAllById(ids);
        list.forEach(e -> {
            e.setId(null);
            e.setGender(null);
            e.setJob(null);
        });
        return CompletableFuture.completedFuture(list);
    }
}
