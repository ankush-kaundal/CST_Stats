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
public class WeeklyController {

	private static final String WEEKLY_PAGE = "Weekly";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WeeklyController.class);

    @RequestMapping(value = "/weekly", method = RequestMethod.POST)
    public String navidateToWeeklyPage(@Valid @ModelAttribute("weeklyPage") User userForm,
            BindingResult result, Map<String, Object> model) { 
        return WEEKLY_PAGE;
    }
}
