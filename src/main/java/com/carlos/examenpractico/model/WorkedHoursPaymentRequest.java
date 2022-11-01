package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkedHoursPaymentRequest {
    @JsonProperty("employee_id")
    private Long employeeId;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("end_date")
    private Date endDate;
}
