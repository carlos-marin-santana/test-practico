package com.carlos.examenpractico.service.impl;

import com.carlos.examenpractico.model.WorkedHoursPaymentRequest;
import com.carlos.examenpractico.dto.EmployeeWorkedHour;
import com.carlos.examenpractico.repositories.WorkedHoursRepository;
import com.carlos.examenpractico.service.WorkedHoursService;
import com.carlos.examenpractico.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkedHoursServiceImpl implements WorkedHoursService {

    @Autowired
    private WorkedHoursRepository repository;

    @Override
    public Integer getWorkedHoursByEmployeeId(WorkedHoursPaymentRequest request) {
        if(Utils.checkIfDateIsPrior(request.getStartDate(),request.getEndDate())) {
            List<EmployeeWorkedHour> hours = repository.findByEmployeeIdAndWorkedDateBetween(request.getEmployeeId(),
                    request.getStartDate(), request.getEndDate());
            return hours.stream().mapToInt(EmployeeWorkedHour::getWorkedHours).sum();
        }
    return null;
    }
}
