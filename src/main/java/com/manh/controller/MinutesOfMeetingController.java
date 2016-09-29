package com.manh.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.model.User;

@Controller
public class MinutesOfMeetingController {

	private static final String MINUTES_OF_MEETING_PAGE = "MinutesOfMeeting";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MinutesOfMeetingController.class);
	
	@RequestMapping(value = "/minutesOfMeeting", method = RequestMethod.GET)
	public String navidateToMinutesOfMeetingPage(@Valid @ModelAttribute("minutesOfMeetingPage") User userForm,
	    BindingResult result, Map<String, Object> model) { 
		return MINUTES_OF_MEETING_PAGE;
	}
	
	@RequestMapping(value = "/submitMoM", method = RequestMethod.POST)
	public String submitMoM(@Valid @ModelAttribute("minutesOfMeetingPage") User userForm,
	    BindingResult result, Map<String, Object> model) { 
		
		
		return MINUTES_OF_MEETING_PAGE;
	}
	
	
}
