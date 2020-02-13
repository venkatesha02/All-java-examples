package com.tyss.employeemanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="other_info")
public class OtherInfoBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String deptName;
	
	@Column
	private String joiningDate;
	
	@Column
	private String dateOfBirth;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId")
//	private UserInfoBean bean;
		
}
