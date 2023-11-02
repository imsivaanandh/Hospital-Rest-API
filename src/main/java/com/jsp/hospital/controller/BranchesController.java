package com.jsp.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital.dto.Branches;
import com.jsp.hospital.service.BranchesService;
import com.jsp.hospital.util.ResponseStructure;

@RestController
@RequestMapping("/branches")
public class BranchesController {

	@Autowired
	private BranchesService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Branches>> saveBranches(@RequestParam int hospitalId, @RequestBody Branches branches){
		return service.saveBranches(hospitalId, branches);
	}
}
