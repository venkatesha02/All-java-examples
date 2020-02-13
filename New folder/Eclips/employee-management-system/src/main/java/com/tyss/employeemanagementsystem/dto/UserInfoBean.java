package com.tyss.employeemanagementsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_info")
public class UserInfoBean{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String userType;

	@OneToOne(cascade = CascadeType.ALL)
	private OtherInfoBean otherInfo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<LeaveInfoBean> leaveInfo;

}
