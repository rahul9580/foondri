/**
 * 
 */
package com.foondri.dao;

/**
 * @author rahul
 *
 */
public interface IUserDao {

	void createUser(String mobile, String email, String password, String address);

}
