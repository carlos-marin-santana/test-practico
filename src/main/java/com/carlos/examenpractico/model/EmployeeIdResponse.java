package com.carlos.examenpractico.model;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeIdResponse extends BaseModel{
    private Long id;

    @Builder
    public EmployeeIdResponse(Long id, Boolean success){
        super(success);
        this.id = id;
    }
}
