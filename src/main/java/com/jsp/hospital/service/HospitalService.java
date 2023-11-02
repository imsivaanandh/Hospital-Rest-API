package com.jsp.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital.dao.HospitalDao;
import com.jsp.hospital.dto.Hospital;
import com.jsp.hospital.exception.IdNotFoundException;
import com.jsp.hospital.util.ResponseStructure;


@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao; 
	
	public ResponseEntity<ResponseStructure<Hospital>> savehospital(Hospital hospital) {
		Hospital dbhospital = hospitalDao.savehospital(hospital);
		
		ResponseStructure<Hospital> strecture = new ResponseStructure<Hospital>();
		strecture.setMessage("Hospital data saved successfully");
		strecture.setStatus(HttpStatus.CREATED.value());
		strecture.setData(dbhospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(strecture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id) {
		Hospital dbHospital = hospitalDao.findHospitalId(id);
		if (dbHospital != null) {
			ResponseStructure<Hospital> strecture = new ResponseStructure<Hospital>();
			strecture.setMessage("Hospital data fetched successfully");
			strecture.setStatus(HttpStatus.OK.value());
			strecture.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(strecture,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Sorry Id not Found");
	
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalByid(int id) {
		Hospital dbHospital = hospitalDao.deleteHospitalId(id);
		if (dbHospital != null) {
			ResponseStructure<Hospital> strecture = new ResponseStructure<Hospital>();
			strecture.setMessage("Hospital data deleted successfully");
			strecture.setStatus(HttpStatus.FOUND.value());
			strecture.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(strecture,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Sorry Id not Found");
		}
		
	}	
}
