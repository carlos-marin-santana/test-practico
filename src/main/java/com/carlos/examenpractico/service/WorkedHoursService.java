package com.carlos.examenpractico.service;

import com.carlos.examenpractico.model.WorkedHoursPaymentRequest;

public interface WorkedHoursService {

    Integer getWorkedHoursByEmployeeId(WorkedHoursPaymentRequest request);

}
