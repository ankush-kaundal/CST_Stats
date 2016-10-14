package com.manh.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.manh.model.ResourceUtilization;
import com.manh.service.IResourceUtilizationService;

public class ResourceUtilizationServiceImpl implements IResourceUtilizationService {

	@Override
	public Map<String, ResourceUtilization> readExcelFile(Map<String, String> miscDataMap) {
		Map<String, ResourceUtilization> resourceDataMap = new LinkedHashMap<String, ResourceUtilization>();
		
		String yearFrom, yearTo, monthFrom, monthTo, dayFrom, dayTo, timeOff, billableHours, clientHours, headCount, hoursAvailable, clientUtilization, billability;
		yearFrom = yearTo = monthFrom = monthTo = dayFrom = dayTo = timeOff = billableHours = clientHours = headCount = hoursAvailable = clientUtilization = billability = "";
		
		try {
			Boolean firstIteration = Boolean.TRUE;
			Boolean ignoreRow = Boolean.FALSE;
			Integer currentRow = -1;
			FileInputStream file = new FileInputStream(new File(FILE_PATH_TEMP_FILE));
			Map<String, Integer> columnIndex = new LinkedHashMap<String, Integer>();
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				ignoreRow = Boolean.FALSE;
				ResourceUtilization resourceData = new ResourceUtilization();
				Row row = rowIterator.next();
				currentRow = row.getRowNum(); 
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(firstIteration){
						try{
							columnIndex.put(cell.getStringCellValue(), cell.getColumnIndex());
						}catch(Exception e){
							System.err.println("Exception occured:"+e);
						}					
					}
					
					if(!firstIteration){
						if(cell.getColumnIndex() == 0 && (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getStringCellValue().equals("Total"))){
							ignoreRow = Boolean.TRUE;
						}
						
						if(cell.getColumnIndex() == 0){
							resourceData.setName(cell.getStringCellValue());
						}else if(cell.getColumnIndex() == 1){
							resourceData.setTotalHours(String.valueOf(((Double)(cell.getNumericCellValue())).intValue()));
						}else if(cell.getColumnIndex() == 2){
							resourceData.setClientHours(String.valueOf(((Double)(cell.getNumericCellValue())).intValue()));
						}else if(cell.getColumnIndex() == 3){
							resourceData.setHolidayOff(String.valueOf(((Double)(cell.getNumericCellValue())).intValue()));
						}else if(cell.getColumnIndex() == 4){
							resourceData.setCdev(String.valueOf(((Double)(cell.getNumericCellValue())).intValue()));
						}else if(cell.getColumnIndex() == 5){
							resourceData.setResourceUtilization(String.valueOf(((Double)(cell.getNumericCellValue()*100)).intValue()));
						}else if(cell.getColumnIndex() == 6){
							resourceData.setBillability(String.valueOf(((Double)(cell.getNumericCellValue())).intValue()));
						}else if(cell.getColumnIndex() == 7){
							resourceData.setBillablePercent(String.valueOf(((Double)(cell.getNumericCellValue()*100)).intValue()));
						}						
					}
					
					
					switch(currentRow) {
					case 1:
						if(cell.getColumnIndex() == 10){
							yearFrom = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("yearFrom", yearFrom);
						}else if(cell.getColumnIndex() == 11){
							monthFrom = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("monthFrom", monthFrom);
						}else if(cell.getColumnIndex() == 12){
							dayFrom = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("dayFrom", dayFrom);
						}
						break;
					case 2:
						if(cell.getColumnIndex() == 10){
							yearTo = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("yearTo", yearTo);
						}else if(cell.getColumnIndex() == 11){
							monthTo = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("monthTo", monthTo);
						}else if(cell.getColumnIndex() == 12){
							dayTo = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("dayTo", dayTo);
						}
						break;
					case 8:
						if(cell.getColumnIndex() == 14){
							timeOff = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("timeOff", timeOff);
						}
						break;
					case 9:
						if(cell.getColumnIndex() == 14){
							billableHours = String.valueOf((Math.round((Double)(cell.getNumericCellValue())*100.0)/100.0));
							miscDataMap.put("billableHours", billableHours);
						}
						break;
					case 10:
						if(cell.getColumnIndex() == 14){
							clientHours = String.valueOf((Math.round((Double)(cell.getNumericCellValue())*100.0)/100.0));
							miscDataMap.put("clientHours", clientHours);
						}
						break;
					case 11:
						if(cell.getColumnIndex() == 14){
							headCount = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("headCount", headCount);
						}
						break;
					case 12:
						if(cell.getColumnIndex() == 14){
							hoursAvailable = String.valueOf(((Double)(cell.getNumericCellValue())).intValue());
							miscDataMap.put("hoursAvailable", hoursAvailable);
						}
						break;
					case 13:
						if(cell.getColumnIndex() == 14){
							clientUtilization = String.valueOf((Math.round((Double)(cell.getNumericCellValue())*100.0)/100.0));
							miscDataMap.put("clientUtilization", clientUtilization);
						}
						break;
					case 14:
						if(cell.getColumnIndex() == 14){
							billability = String.valueOf((Math.round((Double)(cell.getNumericCellValue())*100.0)/100.0));
							miscDataMap.put("billability", billability);
						}
						break;				
					}
					
				}
				if(!firstIteration && !ignoreRow){
					resourceDataMap.put(resourceData.getName(), resourceData);
				}
				firstIteration = Boolean.FALSE;
				
				if(currentRow == 1 || currentRow == 2 || currentRow == 8 || currentRow == 9 || currentRow == 10 || currentRow == 11 || 
						currentRow == 12 || currentRow == 13 || currentRow == 14){
					
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resourceDataMap;
	}
	
	@Override
	public void submitUtilizationRequest(String fromDate, String toDate) {
		String formParsedDate[] = fromDate.split("/");
		String toParsedDate[] = toDate.split("/");

		//From Date
		String fromYear = formParsedDate[2];
		String fromMonth = formParsedDate[0];
		String fromDay = formParsedDate[1];
        
        //To Date
		String toYear = toParsedDate[2];
		String toMonth = toParsedDate[0];
		String toDay = toParsedDate[1];
		
		try{
			FileInputStream file = new FileInputStream(FILE_PATH_TEMPLATE_FILE);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;
			
			//Update the value of Year
	         cell = sheet.getRow(1).getCell(10);
	         cell.setCellValue(Integer.parseInt(fromYear));
	         cell = sheet.getRow(2).getCell(10);
	         cell.setCellValue(Integer.parseInt(toYear));
	         
	         //Update the value of Month
	         cell = sheet.getRow(1).getCell(11);
	         cell.setCellValue(Integer.parseInt(fromMonth));
	         cell = sheet.getRow(2).getCell(11);
	         cell.setCellValue(Integer.parseInt(toMonth));
	         
	         //Update the value of Day
	         cell = sheet.getRow(1).getCell(12);
	         cell.setCellValue(Integer.parseInt(fromDay));
	         cell = sheet.getRow(2).getCell(12);
	         cell.setCellValue(Integer.parseInt(toDay));
	         
	         file.close();

	         FileOutputStream outFile = new FileOutputStream(new File(FILE_PATH_TEMPLATE_FILE));
	         workbook.write(outFile);
	         outFile.close();

	         Process p = Runtime.getRuntime().exec("cmd /c/Project_CD/SFExcels/GSA_Timecard_Monitor.vbs");
	         int i = p.waitFor();
	         /*Path tempFile1 = FileSystems.getDefault().getPath("C:/Project_CD/SFExcels", "GSA_Procsd_Timecard.xlsm");
	         Files.deleteIfExists(tempFile1);*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}