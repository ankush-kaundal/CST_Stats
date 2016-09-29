package com.manh.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manh.dao.IProjectDetailsDao;
import com.manh.model.ProjectDetails;

@Controller
public class ProjectDetailsController {

	private static final String PROJECT_DETAILS_PAGE = "projectDetailsPage";
	private final static Logger logger = LoggerFactory.getLogger(ProjectDetailsController.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static final IProjectDetailsDao projectDetailsDao = (IProjectDetailsDao) context.getBean("projectDetailsDAO");
	
	@RequestMapping(value = "/projectDetails", method = {RequestMethod.GET})
    public ModelAndView navidateToProjectDetailsPage() {
		ModelAndView model = new ModelAndView();		
		
		List<ProjectDetails> projectNames = projectDetailsDao.getAllProjectDetails();
		model.setViewName(PROJECT_DETAILS_PAGE);
		model.addObject("projectDetails", projectNames);
		return model;
    }
}
