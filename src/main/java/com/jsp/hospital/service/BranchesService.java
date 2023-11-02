package com.jsp.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital.dao.Branchesdao;
import com.jsp.hospital.dao.HospitalDao;
import com.jsp.hospital.dto.Branches;
import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.util.ResponseStructure;


@Service
public class BranchesService {

	@Autowired
	private Branchesdao branchesDao;
	@Autowired
	private HospitalDao hospitalDao;
	
	public ResponseEntity<ResponseStructure<Branches>> saveBranches(int hospitalId, Branches branches){
		Hospital dbHospital = hospitalDao.findHospitalId(hospitalId);
		if (dbHospital != null) {
			
			List<Branches> listOfBranches = dbHospital.getBranches();
			listOfBranches.add(branches);
			
			dbHospital.setBranches(listOfBranches);
			
			Branches dbBranches =  branchesDao.saveBranches(branches);
			ResponseStructure<Branches> structure = new ResponseStructure<Branches>();
			structure.setMessage("Branches saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbBranches);
			return new ResponseEntity<ResponseStructure<Branches>>(structure,HttpStatus.CREATED);
		}else {
		
		return null;
		}
	}
}
