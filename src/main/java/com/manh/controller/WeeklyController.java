package com.manh.controller;

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

import com.manh.dao.IProjectDetailsDao;
import com.manh.dao.IWeeklyDao;
import com.manh.model.ProjectDetails;
import com.manh.model.Weekly;

@Controller
public class WeeklyController {

	private static final String WEEKLY_PAGE = "Weekly";
	private static final String VIEW_WEEKLY_PAGE = "ViewWeekly";
	private final static Logger logger = LoggerFactory.getLogger(ProjectDetailsController.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static final IWeeklyDao weeklyDao = (IWeeklyDao) context.getBean("weeklyDAO");
	private static final IProjectDetailsDao projectDetailsDao = (IProjectDetailsDao) context.getBean("projectDetailsDAO");

    @RequestMapping(value = "/weekly", method = RequestMethod.GET)
    public ModelAndView navidateToWeeklyPage() {
		ModelAndView model = new ModelAndView();		
		List<ProjectDetails> projectNames = projectDetailsDao.getAllProjectDetails();
		model.setViewName(WEEKLY_PAGE);
		model.addObject("projectDetails", projectNames);
		return model;
    }
    @RequestMapping(value = "/viewAllWeekly", method = RequestMethod.GET)
    public ModelAndView navidateToViewWeeklyPage() {
		ModelAndView model = new ModelAndView();		
		List<ProjectDetails> projectNames = projectDetailsDao.getAllProjectDetails();
		model.setViewName(VIEW_WEEKLY_PAGE);
		model.addObject("projectDetails", projectNames);
		return model;
    }
    @RequestMapping(value = "/submitWeekly", method = {RequestMethod.POST,RequestMethod.GET})
    public String submitWeekly(@ModelAttribute("SpringWeb")Weekly weekly, 
    		   ModelMap model) {		
    	weeklyDao.submitWeekly(weekly);
    	List<ProjectDetails> projectNames = projectDetailsDao.getAllProjectDetails();
		model.addObject("projectDetails", projectNames);
		model.addAttribute("submitResponse", "Weekly has been submitted...");
        return WEEKLY_PAGE;
    }
}
