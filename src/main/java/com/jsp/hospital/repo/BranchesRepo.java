package com.jsp.hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital.dto.Branches;

public interface BranchesRepo extends JpaRepository<Branches, Integer>{

}
