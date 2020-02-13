package com.tyss.employeemanagementsystem.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.employeemanagementsystem.dao.UserDao;
import com.tyss.employeemanagementsystem.dto.UserInfoBean;
import com.tyss.employeemanagementsystem.dto.OtherInfoBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao dao;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_NAME_REGEX =
			Pattern.compile("(?i)(^[A-Za-z])((?![ .,'-]$)[A-Za-z .,'-]){0,24}$",Pattern.CASE_INSENSITIVE); 

	@Override
	public boolean addUser(UserInfoBean bean) {
		
		if(bean == null) {
			return false;
		}
		Matcher matcher1 = VALID_EMAIL_ADDRESS_REGEX.matcher(bean.getEmail());
		Matcher matcher2 = VALID_NAME_REGEX.matcher(bean.getFirstName());
		Matcher matcher3 = VALID_NAME_REGEX.matcher(bean.getLastName());

		if(matcher1.find() && matcher2.find() && matcher3.find()) {
			return dao.addUser(bean);

		}else {
			return false;
		}

	}

	@Override
	public UserInfoBean auth(String email, String password) {

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (matcher.find()) {

			return dao.auth(email, password);

		} else {
			return null;
		}

	}

	@Override
	public List<UserInfoBean> getAllEmp() {

		return dao.getAllEmp();

	}

	@Override
	public boolean updateUser(UserInfoBean bean) {
		
		if(bean != null) {
			Matcher matcher1 = VALID_EMAIL_ADDRESS_REGEX.matcher(bean.getEmail());
			Matcher matcher2 = VALID_NAME_REGEX.matcher(bean.getFirstName());
			Matcher matcher3 = VALID_NAME_REGEX.matcher(bean.getLastName());
			//return false;
			if(matcher1.find() && matcher2.find() && matcher3.find()) {
				
				return dao.updateUser(bean);
				
			}else {
				return false;
			}
		}
		return false;


	}

	@Override
	public List<UserInfoBean> userSearch(String name) {

		return dao.userSearch(name);

	} 

	@Override
	public OtherInfoBean find(int id) {

		return dao.find(id);
	}





}// end of class
