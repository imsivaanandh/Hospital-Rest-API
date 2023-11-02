package com.jsp.hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.repo.Hospitalrepo;



@Repository
public class HospitalDao {

	@Autowired
	Hospitalrepo repo;
	
	public Hospital savehospital(Hospital hospital) {
		return repo.save(hospital);
	}

	public Hospital findHospitalId(int hospitalId) {
		Optional<Hospital> optional = repo.findById(hospitalId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital deleteHospitalId(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
//			im going to delete the data
			Hospital dbhospital = optional.get();
//			repo.delete(user);
			repo.deleteById(id);

			return dbhospital;
		}else {
			return null;
		}
	}
}
