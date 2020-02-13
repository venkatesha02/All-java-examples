package com.tyss.employeemanagementsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.tyss.employeemanagementsystem.dto.UserInfoBean;
import com.tyss.employeemanagementsystem.service.UserService;
import com.tyss.employeemanagementsystem.service.UserServiceImpl;

class AddUserTest {

	@Test
	void addUserNullTest() {
		UserService service = new UserServiceImpl();
		UserInfoBean bean = null;
		boolean actual =service.addUser(bean);
		assertEquals(false, actual);
		
//		assertThrows(Exception.class, ()->{
//			service.addUser(bean);
//		});
		
	}

	@Test
	void addUserNotNullTest() {
		UserInfoBean bean = new UserInfoBean();
		UserService service = new UserServiceImpl();

		assertThrows(Exception.class, ()->{
			service.addUser(bean);
		});
	}

}
