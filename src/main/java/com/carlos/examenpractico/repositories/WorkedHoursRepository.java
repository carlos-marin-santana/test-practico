package com.carlos.examenpractico.repositories;

import com.carlos.examenpractico.dto.EmployeeWorkedHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkedHoursRepository extends JpaRepository<EmployeeWorkedHour, Long> {

    List<EmployeeWorkedHour> findByEmployeeIdAndWorkedDateBetween(Long id, Date startDate, Date endDate);
}
