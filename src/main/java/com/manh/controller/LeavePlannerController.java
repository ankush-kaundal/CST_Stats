package com.manh.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manh.dao.ILeavePlannerDao;
import com.manh.model.LeavePlanner;

@Controller
public class LeavePlannerController {

	private static final String LEAVE_PLANNER_PAGE = "LeavePlannerPage";
	private static final String VIEW_APPLIED_LEAVE_PAGE = "ViewAppliedLeavePage";
	private final static Logger logger = LoggerFactory.getLogger(LeavePlannerController.class);

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static final ILeavePlannerDao leavePlannerDao = (ILeavePlannerDao) context.getBean("leavePlannerDAO");
		
	@RequestMapping(value = "/leavePlanner", method = {RequestMethod.GET})
    public String navidateToProjectDetailsPage() {
		return LEAVE_PLANNER_PAGE;
    } 
	
	
	@RequestMapping(value = "/viewAllAppliedLeave", method = {RequestMethod.GET})
    public ModelAndView getAllAppliedLeave() {
		ModelAndView model = new ModelAndView();		
		
		List<LeavePlanner> appliedLeaveList = leavePlannerDao.getAllAppliedLeave();
		List<LeavePlanner> allUserList = leavePlannerDao.getAllUserInfo();
		model.setViewName(VIEW_APPLIED_LEAVE_PAGE);
		model.addObject("allUserList", allUserList);
		model.addObject("userAppliedLeaveList", appliedLeaveList);
		model.addObject("selectedUser", "All");
		return model;
    }
	
	@RequestMapping(value = "/viewAppliedLeaveByUser", method = {RequestMethod.GET})
    public ModelAndView getAppliedLeaveByUser(@ModelAttribute("SpringWeb")LeavePlanner leavePlanner) {
		ModelAndView modelView = new ModelAndView();	
		
		List<LeavePlanner> allUserList = leavePlannerDao.getAllUserInfo();
		List<LeavePlanner> allAppliedLeaveList = leavePlannerDao.getAllAppliedLeave();
		modelView.addObject("allUserList", allUserList);
		
		if("All".equals(leavePlanner.getUserId()) || "".equals(leavePlanner.getUserId())){			
			modelView.addObject("userAppliedLeaveList", allAppliedLeaveList);
			modelView.addObject("selectedUser", "All");
		}else{
			List<LeavePlanner> userAppliedLeaveList = leavePlannerDao.getAppliedLeaveByUserId(leavePlanner.getUserId());
			modelView.addObject("userAppliedLeaveList", userAppliedLeaveList);
			modelView.addObject("selectedUser", leavePlanner.getUserId());
		}
		
		modelView.setViewName(VIEW_APPLIED_LEAVE_PAGE);		
		
		return modelView;
    }
	
	@RequestMapping(value = "/submitLeave", method = {RequestMethod.POST,RequestMethod.GET})
    public String submitLeave(@ModelAttribute("SpringWeb")LeavePlanner leavePlanner, 
    		   ModelMap model) {
		
		leavePlannerDao.submitLeaveDetails(leavePlanner);
		List<LeavePlanner> leavePlannerList = new ArrayList<LeavePlanner>();
		leavePlannerList.add(leavePlanner);
		model.addAttribute("submitResponse", "Leave request has been submitted...");
		return LEAVE_PLANNER_PAGE;
    } 
}


