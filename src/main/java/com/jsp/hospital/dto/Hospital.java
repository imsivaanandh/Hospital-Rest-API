package com.jsp.hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hospital {

	@Id
	private int id;
	private String  name;
	
	@OneToMany (cascade = CascadeType.REMOVE)
	private List<Branches> branches;
}
