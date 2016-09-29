package com.manh.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manh.dao.ICSTCheckListDao;
import com.manh.model.CSTCheckList;

@Controller
public class CSTCheckListController {

	private static final String CST_CHECK_LIST_PAGE = "CSTCheckList";
	private static final String VIEW_CST_CHECK_LIST_PAGE = "ViewCSTCheckList";

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private static final ICSTCheckListDao cstCheckListDao = (ICSTCheckListDao) context.getBean("cstCheckListDAO");
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CSTCheckListController.class);

	@RequestMapping(value = "/cstChecklist", method = {RequestMethod.GET})
    public ModelAndView cstChecklist(@ModelAttribute("SpringWeb")CSTCheckList inputParm) {
		ModelAndView modelView = new ModelAndView();	
		List<CSTCheckList> projectNameCodeList = cstCheckListDao.getProjectList();
		modelView.addObject("projectNameCodeList", projectNameCodeList);
		modelView.addObject("checkbox1Checked", "checked");
		modelView.setViewName(CST_CHECK_LIST_PAGE);
		return modelView;
    }
	
	@RequestMapping(value = "/submitCSTCheckList", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView submitCSTCheckList(@ModelAttribute("SpringWeb")CSTCheckList inputParm) {
		cstCheckListDao.submitCheckList(inputParm);
		
		ModelAndView modelView = new ModelAndView();
		List<CSTCheckList> projectNameCodeList = cstCheckListDao.getProjectList();
		modelView.addObject("projectNameCodeList", projectNameCodeList);
		modelView.addObject("checkbox1Checked", "checked");
		modelView.setViewName(CST_CHECK_LIST_PAGE);
		return modelView;
    } 
	
	@RequestMapping(value = "/viewCSTListByProject", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView viewCSTListByProject(@ModelAttribute("SpringWeb")CSTCheckList inputParm) {
		ModelAndView modelView = new ModelAndView();
		CSTCheckList cstListByProjectCode = cstCheckListDao.getAllCSTListValueForAProject(inputParm.getProjectCode());
		List<CSTCheckList> projectNameCodeList = cstCheckListDao.getProjectList();
		
		modelView.addObject("projectNameCodeList", projectNameCodeList);
		modelView.addObject("cstListByProjectCode", cstListByProjectCode);
		modelView.addObject("checkbox2Checked", "checked");
		modelView.setViewName(CST_CHECK_LIST_PAGE);
		return modelView;
    } 
	
}
