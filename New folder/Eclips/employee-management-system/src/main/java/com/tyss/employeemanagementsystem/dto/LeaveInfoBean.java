package com.tyss.employeemanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "leave_info")
@Data
public class LeaveInfoBean  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String fromDate;

	@Column
	private String toDate;

	@Column
	private int leaveStatus;

//	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH })
//	private UserInfoBean infoBean;

}