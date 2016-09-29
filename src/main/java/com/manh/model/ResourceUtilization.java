package com.manh.model;

public class ResourceUtilization {
	private String name;
	private String totalHours;
	private String clientHours;
	private String holidayOff;
	private String cdev;
	private String resourceUtilization;
	private String billability;
	private String billablePercent;
	private String year;
	private String month;
	private String day;
	private String workingHours;
	private String userName;
	private String fromDate;
	private String toDate;
	private String userId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public String getClientHours() {
		return clientHours;
	}
	public void setClientHours(String clientHours) {
		this.clientHours = clientHours;
	}
	public String getHolidayOff() {
		return holidayOff;
	}
	public void setHolidayOff(String holidayOff) {
		this.holidayOff = holidayOff;
	}
	public String getCdev() {
		return cdev;
	}
	public void setCdev(String cdev) {
		this.cdev = cdev;
	}
	public String getResourceUtilization() {
		return resourceUtilization;
	}
	public void setResourceUtilization(String resourceUtilization) {
		this.resourceUtilization = resourceUtilization;
	}
	public String getBillability() {
		return billability;
	}
	public void setBillability(String billability) {
		this.billability = billability;
	}
	public String getBillablePercent() {
		return billablePercent;
	}
	public void setBillablePercent(String billablePercent) {
		this.billablePercent = billablePercent;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}