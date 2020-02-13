package com.tyss.employeemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.employeemanagementsystem.dao.LeaveDao;
import com.tyss.employeemanagementsystem.dto.LeaveInfoBean;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao dao;
	
	@Override
	public boolean applyLeave(LeaveInfoBean bean) {
		
		return dao.applyLeave(bean);
	}

}
