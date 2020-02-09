package com.tyss.hibernateapp.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emp_addess_info")
public class Emp_Address_Info implements Serializable {
	
	@EmbeddedId
	private Emp_Address_Pk composite;
	
	@Column
	private int house_no;
	
	@Column
	private String addrs1;
	
	@Column 
	private String addrs2;
	
	@Column
	private String landmark; 
	
	@Column
	private String city;
	
	@Column
	private int pincode;
	
	@MapsId("emp_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Emp_Primary_Info primary;
	
	
}