package com.carlos.examenpractico.repositories;

import com.carlos.examenpractico.dto.JobDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobDto, Long> {
}
