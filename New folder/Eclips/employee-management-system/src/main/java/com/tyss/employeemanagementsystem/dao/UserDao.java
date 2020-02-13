package com.tyss.employeemanagementsystem.dao;

import java.util.List;

import com.tyss.employeemanagementsystem.dto.UserInfoBean;
import com.tyss.employeemanagementsystem.dto.OtherInfoBean;

public interface UserDao {

	public boolean addUser(UserInfoBean bean);

	public UserInfoBean auth(String email, String password);
	
	public List<UserInfoBean> getAllEmp();
	
	public boolean updateUser(UserInfoBean bean);
	
	public List<UserInfoBean> userSearch(String name);
	 
	public OtherInfoBean find(int id);
	
}
