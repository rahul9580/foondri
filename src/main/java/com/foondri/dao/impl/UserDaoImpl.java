package com.foondri.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foondri.dao.IUserDao;

/**
 * @author rahul
 *
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void createUser(String mobile, String email, String password, String address) {
		String query = "insert into foondri.user_detail(mobile, email, password, address) values(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, mobile);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.setString(4, address);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
