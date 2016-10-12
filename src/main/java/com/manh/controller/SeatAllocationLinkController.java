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
public class SeatAllocationLinkController {

	private static final String SEAT_ALLOCATION_LINK_PAGE = "SeatAllocationLink";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SeatAllocationLinkController.class);

    @RequestMapping(value = "/seatAllocationLink", method = RequestMethod.GET)
    public String navidateToSeatAllocationLinkPage(@Valid @ModelAttribute("seatAllocationLinkPage") User userForm,
            BindingResult result, Map<String, Object> model) { 
        return SEAT_ALLOCATION_LINK_PAGE;
    }
}
