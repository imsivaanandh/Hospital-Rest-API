package com.jsp.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital.dto.Hospital;

public interface Hospitalrepo extends JpaRepository<Hospital, Integer> {

}
