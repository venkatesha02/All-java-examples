package com.tyss.hibernateapp.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.ToString.Exclude;

@SuppressWarnings("serial")
@Entity
@Table(name="emp_secondary_info")
public class Emp_Secondary_info implements Serializable {

	@Id
	@Column
	private	int emp_id;
	
	@Column
	private String gender;
	
	@Column
	private String personal_email;
	
	@Column
	private String job_location;
	
	@Column
	private boolean is_married;
	
	@Column
	private String nationality;
	
	@Column
	private long guardian_number;
	
	@Column
	private String guardian_name;
	
	@Column
	private String govt_id;
	
	@Column
	private String blood_group;
	
	@Column
	private long emargancy_no;
	
	@Column
	private boolean is_phycally_challenged;
	
	@Exclude
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id")
	
	private Emp_Primary_Info primary;
	
	public Emp_Primary_Info getPrimary() {
		return primary;
	}

	public void setPrimary(Emp_Primary_Info primary) {
		this.primary = primary;
	}

	public int getId() {
		return emp_id;
	}
	
	public void setId(int id) {
		this.emp_id = id;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPersonal_email() {
		return personal_email;
	}
	
	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}
	
	public String getJob_location() {
		return job_location;
	}
	
	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}
	
	public boolean isIs_married() {
		return is_married;
	}
	
	public void setIs_married(boolean is_married) {
		this.is_married = is_married;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public long getGuardian_number() {
		return guardian_number;
	}
	
	public void setGuardian_number(long guardian_number) {
		this.guardian_number = guardian_number;
	}
	
	public String getGuardian_name() {
		return guardian_name;
	}
	
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	
	public String getGovt_id() {
		return govt_id;
	}
	
	public void setGovt_id(String govt_id) {
		this.govt_id = govt_id;
	}
	
	public String getBlood_group() {
		return blood_group;
	}
	
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	
	public long getEmargancy_no() {
		return emargancy_no;
	}
	
	public void setEmargancy_no(long emargancy_no) {
		this.emargancy_no = emargancy_no;
	}
	
	public boolean isIs_phycally_challenged() {
		return is_phycally_challenged;
	}
	
	public void setIs_phycally_challenged(boolean is_phycally_challenged) {
		this.is_phycally_challenged = is_phycally_challenged;
	}
	
}
