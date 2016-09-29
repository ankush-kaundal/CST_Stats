package com.manh.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manh.model.ResourceUtilization;
import com.manh.service.IResourceUtilizationService;

@Controller
public class ResourceUtilizationController {

	private static final String RESOURCE_UTILIZATION_PAGE = "ResourceUtilization";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ResourceUtilizationController.class);

    @RequestMapping(value = "/resourceUtilization", method = {RequestMethod.GET})
    public ModelAndView getAllAppliedLeave() {
		ModelAndView model = new ModelAndView();		
		Map<String, String> miscDataMap = new HashMap<String, String>();
		Map<String, ResourceUtilization> resourceDataMap = getService().readExcelFile(miscDataMap);
		model.setViewName(RESOURCE_UTILIZATION_PAGE);
		model.addObject("resourceDataMap", resourceDataMap);
		model.addObject("miscDataMap", miscDataMap);
		model.addObject("fromDate", miscDataMap.get("monthFrom")+"/"+miscDataMap.get("dayFrom")+"/"+miscDataMap.get("yearFrom"));
		model.addObject("toDate", miscDataMap.get("monthTo")+"/"+miscDataMap.get("dayTo")+"/"+miscDataMap.get("yearTo"));
		return model;
    }
    
    @RequestMapping(value = "/submitUtilization", method = {RequestMethod.POST,RequestMethod.GET})
    public String submitUtilization(@ModelAttribute("resourceUtilization")ResourceUtilization resourceUtilization, 
    		   ModelMap model) {
		
		String toDate = resourceUtilization.getToDate();//09/21/2016
		String fromDate = resourceUtilization.getFromDate();
		
		getService().submitUtilizationRequest(fromDate, toDate);
		model.addAttribute("submitResponse", "Please wait...");
		return RESOURCE_UTILIZATION_PAGE;
    }
    
    
    private IResourceUtilizationService getService(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	IResourceUtilizationService resourceUtilizationService = (IResourceUtilizationService) context.getBean("resourceUtilization");
    	return resourceUtilizationService;
    }
}