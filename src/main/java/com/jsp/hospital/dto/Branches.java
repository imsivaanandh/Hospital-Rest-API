package com.jsp.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Branches {

	@Id
	private int id;
	private String name;
	private String address;
	
}
