package com.tyss.hibernateapp.many_to_many;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="project_info")
public class Project_info implements Serializable {

	@Id
	@Column
	private int project_id;
	
	@Column
	private String project_name;
	
	@Column
	private String technology;
	
	@Column
	private String location;
	
	@Column
	private String start_date;
	
	@Column
	private String end_date;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="emp_project_info",joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="emp_id"))
	private List<Emp_Primary_Info> primaryinfo;
	
	
	
}
