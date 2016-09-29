package com.manh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.model.LeavePlanner;
import com.manh.model.User;
 
@Controller
public class MyController {
 
   @RequestMapping(value = { "/", "/loginForm" }, method = RequestMethod.POST)
   public String homePage(Model model) {
       return "homePage";
   }
   
   
   @RequestMapping(value = { "/overView" }, method = RequestMethod.GET)
   public String overviewPage(Model model) {
       return "OverviewPage";
   }
 
    
   @RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
   public String contactusPage(Model model) {
       model.addAttribute("address", "Vietnam");
       model.addAttribute("phone", "...");
       model.addAttribute("email", "...");
       return "contactusPage";
   }
      
   @RequestMapping(value = { "loginForm" }, method = RequestMethod.GET)
   public String createAccount(Model model) {
       return "index";
   }
   
   @RequestMapping(value = "/createAccount", method = {RequestMethod.POST,RequestMethod.GET})
   public String createAccount(@ModelAttribute("SpringWeb")User user, 
   		   ModelMap model) {
		return "CreateAccount";
   }
   
}