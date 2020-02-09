package com.tyss.hibernateapp.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Emp_Address_Pk implements Serializable {

	private int emp_id;
	private String addrs_type;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp_Address_Pk other = (Emp_Address_Pk) obj;
		if (addrs_type == null) {
			if (other.addrs_type != null)
				return false;
		} else if (!addrs_type.equals(other.addrs_type))
			return false;
		if (emp_id != other.emp_id)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrs_type == null) ? 0 : addrs_type.hashCode());
		result = prime * result + emp_id;
		return result;
	}
	
	
}
