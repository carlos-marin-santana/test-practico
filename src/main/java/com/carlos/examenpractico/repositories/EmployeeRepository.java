package com.carlos.examenpractico.repositories;

import com.carlos.examenpractico.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.sql.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {

    @Procedure(procedureName="CHECK_EXISTING_EMPLOYEES", outputParameterName = "v_id")
    //@Procedure(procedureName="CARLOS.CHECK_EXISTING_EMPLOYEES")
    Long insertEmployee(Long V_GENDER_ID, Long V_JOB_ID, String V_NAME, String V_LAST_NAME, Date V_BIRTHDATE);

    //List<EmployeeDto> findAll
}
