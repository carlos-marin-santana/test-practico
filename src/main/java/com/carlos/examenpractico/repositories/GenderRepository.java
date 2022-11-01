package com.carlos.examenpractico.repositories;

import com.carlos.examenpractico.dto.GenderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderDto, Long> {
}
