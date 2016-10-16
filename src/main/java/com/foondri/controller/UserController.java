/**
 * 
 */
package com.foondri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foondri.service.IUserService;

/**
 * @author rahul
 *
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		System.out.println("Inside signup...");
		model.addAttribute("message", "Hello user, Please signup here!");
		return "signup";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String createUser(@RequestParam("mobile") String mobile, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("address") String address) {
		System.out.println("Inside createUser Ctrl...");
		userService.createUser(mobile, email, password, address);
		ModelMap model = new ModelMap();
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
}
