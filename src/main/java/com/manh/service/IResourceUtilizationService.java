package com.manh.service;

import java.util.Map;

import com.manh.model.ResourceUtilization;

public interface IResourceUtilizationService {
	public String FILE_PATH_TEMP_FILE = "C:\\Project_CD\\SFExcels\\TempList.xlsm";
	public String FILE_PATH_TEMPLATE_FILE = "C:\\Project_CD\\SFExcels\\GSA_Timecard_Monitor.xlsm";
	public String VB_PATH = "C:\\Project_CD\\SFExcels\\GSA_Timecard_Monitor.vbs";
	
	public Map<String, ResourceUtilization> readExcelFile(Map<String, String> miscData);
	public void submitUtilizationRequest(String fromDate, String toDate);
}