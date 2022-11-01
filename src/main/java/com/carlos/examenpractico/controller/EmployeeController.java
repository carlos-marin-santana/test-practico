package com.carlos.examenpractico.controller;

import com.carlos.examenpractico.model.*;
import com.carlos.examenpractico.dto.EmployeeDto;
import com.carlos.examenpractico.service.EmployeeService;
import com.carlos.examenpractico.service.WorkedHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @Autowired
    private WorkedHoursService workedHoursService;

    @PostMapping("/saveEmployee")
    public EmployeeIdResponse saveEmployee(@RequestBody EmployeeRequest employeeDto){
        var id = service.saveEmployee(employeeDto);
        if(id != null){
            return EmployeeIdResponse.builder().id(id).success(true).build();
        }
        return EmployeeIdResponse.builder().success(false).build();
    }

    @PostMapping("/findByJobId")
    public EmployeesMapResponse findEmployeesByJobId(@RequestBody JobIdRequest jobIdRequest){
        var map = service.findEmployeesByJobId(jobIdRequest.getJobId());

        if(map.size() > 0){
            return EmployeesMapResponse.builder().employees(map).success(true).build();
        }
        return EmployeesMapResponse.builder().success(false).build();
    }

    @PostMapping("/getEmployeesById")
    public CompletableFuture<EmployeesResponse> getEmployeesById(@RequestBody EmployeeIdsRequest ids) throws ExecutionException, InterruptedException {
        var employess =  service.getEmployeesById(ids.getEmployeeIds());

        return CompletableFuture.completedFuture(EmployeesResponse.builder().employees(employess.get()).success(true).build())
                .exceptionally(handleGetEmployeesByIdFailure);
    }

        private static Function<Throwable, EmployeesResponse> handleGetEmployeesByIdFailure = throwable ->
                EmployeesResponse.builder().success(false).build();


    @PostMapping("/getWorkedHoursByEmployeeId")
    public WorkedHoursResponse getWorkedHoursByEmployeeId(@RequestBody WorkedHoursPaymentRequest workedHoursPaymentRequest){
        var hours = workedHoursService.getWorkedHoursByEmployeeId(workedHoursPaymentRequest);
        EmployeeDto employee = service.findEmployeeById(workedHoursPaymentRequest.getEmployeeId());
        if(employee != null && hours != null){
            return WorkedHoursResponse.builder().totalWorkedHours(hours).success(true).build();
        }
        return WorkedHoursResponse.builder().success(false).build();
    }

    @PostMapping("/getPaymentByEmployeeIdAndWorkedHours")
    public PaymentResponse getPaymentByEmployeeIdAndWorkedHours(@RequestBody WorkedHoursPaymentRequest workedHoursPaymentRequest){
        var workedHours = workedHoursService.getWorkedHoursByEmployeeId(workedHoursPaymentRequest);
        if(workedHours == null){
            return PaymentResponse.builder().success(false).build();
        }
        EmployeeDto employee = service.findEmployeeById(workedHoursPaymentRequest.getEmployeeId());
        Double payment = employee!= null? workedHours * employee.getJob().getSalary(): null;
        if(payment != null){
            return PaymentResponse.builder().payment(payment).success(true).build();
        }
        return PaymentResponse.builder().success(false).build();
    }
}
