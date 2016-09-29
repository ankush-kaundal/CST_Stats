package com.manh.controller;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manh.dao.IUserDetailsDao;
import com.manh.model.User;

@Controller
public class CommonController {

	private static final String LOGIN_PAGE = "loginPage";
	private static final String CREATE_USER_PAGE = "createUserPage";
	private static final String HOME_PAGE = "homePage";
	
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static final IUserDetailsDao userDetailsDao = (IUserDetailsDao) context.getBean("userDetailsDao");

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CSTCheckListController.class);

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String loginPage(Model model) {
		return LOGIN_PAGE;
	}

	@RequestMapping(value = { "/default"}, method = RequestMethod.GET)
	public String defaultPage(Model model) {
		return HOME_PAGE;
	}
	
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logoutPage(Model model) {
		return LOGIN_PAGE;
	}
	
	@RequestMapping(value = { "/loginForm" }, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPageAuthentication(@ModelAttribute("SpringWeb") User user) {
		ModelAndView modelView = new ModelAndView();
		
		if(userDetailsDao.isValidUser(user)){
			modelView.setViewName(HOME_PAGE);
			modelView.addObject("welcomeUserName", userDetailsDao.getUserName(user));
		}else{
			modelView.setViewName(LOGIN_PAGE);
			modelView.addObject("response", "Invalid UserId or Password..");
		}
		
		return modelView;
	}
	
	@RequestMapping(value = "/createUserPage", method = { RequestMethod.POST, RequestMethod.GET })
	public String createUserPage(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		return CREATE_USER_PAGE;
	}

	@RequestMapping(value = "/validateAndCreateUserAccount", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView validateAndCreateUserAccount(@ModelAttribute("SpringWeb") User user) {
		ModelAndView modelView = new ModelAndView();
		
		if(!userDetailsDao.isUserAlreadyCreated(user)){
			userDetailsDao.createUserDetail(user);			
			modelView.setViewName(HOME_PAGE);
		}else{
			modelView.setViewName(CREATE_USER_PAGE);
			modelView.addObject("response", "Email is already register..");
		}		
		
		return modelView;
	}
}