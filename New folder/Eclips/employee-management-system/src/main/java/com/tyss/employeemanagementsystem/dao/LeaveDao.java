package com.tyss.employeemanagementsystem.dao;

import com.tyss.employeemanagementsystem.dto.LeaveInfoBean;

public interface LeaveDao {

	public boolean applyLeave(LeaveInfoBean bean);
	
}