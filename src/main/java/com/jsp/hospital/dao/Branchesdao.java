package com.jsp.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital.dto.Branches;
import com.jsp.hospital.repo.BranchesRepo;

@Repository
public class Branchesdao {

	@Autowired
	private BranchesRepo repo;
	public Branches saveBranches(Branches branches) {
		return repo.save(branches);
	}
	
}
