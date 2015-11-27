package com.test.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("message", "Home ," + " Username : " + getPrincipal());
		return "home";
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String aboutPage(ModelMap model) {
		model.addAttribute("message", "About ," + " Username : " + getPrincipal());
		return "about";
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String contactPage(ModelMap model) {
		model.addAttribute("message", "Contact ," + " Username : " + getPrincipal());
		return "contact";
	}

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("message", "Admin ," + " Username : " + getPrincipal());
		return "admin/admin";
	}

	@RequestMapping(value = { "/dba" }, method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("message", "DBA ," + " Username : " + getPrincipal());
		return "dba/dba";
	}

	/*
	 * @RequestMapping(value={"/AccessDenied"} , method= RequestMethod.GET)
	 * public String accessDeniedPage(ModelMap model){
	 * model.addAttribute("message",
	 * "AccessDenied *You are not authorized to access this page!*  ," +
	 * " Username : " + getPrincipal()); return "errors/accessDenied"; }
	 */

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model) {
		
		model.addAttribute("message", "You do not have permission to access this page!");
		
		return "403";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
