/**
 * 
 */
package com.foondri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rahul
 *
 */
@Controller
@RequestMapping("/hello")
public class PrintHelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		System.out.println("Inside printHello...");
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
}
