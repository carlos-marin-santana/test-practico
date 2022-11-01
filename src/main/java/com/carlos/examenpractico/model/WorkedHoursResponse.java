package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkedHoursResponse extends BaseModel {
    @JsonProperty("total_worked_hours")
    private Integer totalWorkedHours;

    @Builder
    public WorkedHoursResponse(Integer totalWorkedHours, Boolean success){
        super(success);
        this.totalWorkedHours = totalWorkedHours;
    }
}
