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
public class UpcomingEventsController {

	private static final String UPCOMING_EVENTS_PAGE = "UpcomingEvents";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UpcomingEventsController.class);

    @RequestMapping(value = "/upcomingEvents", method = RequestMethod.GET)
    public String navidateToUpcomingEventsPage(@Valid @ModelAttribute("upcomingEventsPage") User userForm,
            BindingResult result, Map<String, Object> model) { 
        return UPCOMING_EVENTS_PAGE;
    }
}
