package com.nono.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nono.Dao.GetPasswordByUserName;

@Repository
public class CompareUserService {
	@Autowired
	GetPasswordByUserName getPasswordByUserName;
	public boolean isRightPassword ( String username ,String password) {
		Boolean boolean1 = false;
		
		String passwordString = getPasswordByUserName.getPassword(username);
		
		//密码是正确的就返回正确;
		if( password!=null && password.equals( passwordString) ){
			
			boolean1 = true;
			
		};
		
		return boolean1;
	}
}
