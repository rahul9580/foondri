/**
 * 
 */
package com.foondri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foondri.dao.IUserDao;
import com.foondri.service.IUserService;

/**
 * @author rahul
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public void createUser(String mobile, String email, String password, String address) {
		userDao.createUser(mobile, email, password, address);
	}
	
}
