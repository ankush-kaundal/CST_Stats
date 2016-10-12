package com.manh.model;

import java.sql.Date;

public class Weekly {
	private String projectName;
	private String projectCode;
	private String baseOpenIssue;
	private String baseDeliveredIssue;
	private String baseInprogressIssue;
	private String customOpenIssue;
	private String customDeliveredIssue;
	private String customInprogressIssue;
	private String modOpenIssue;
	private String modDeliveredIssue;
	private String modInprogressIssue;
	private String comments;
	private Date createDateTime;
	private Date updateDateTime;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getBaseOpenIssue() {
		return baseOpenIssue;
	}
	public void setBaseOpenIssue(String baseOpenIssue) {
		this.baseOpenIssue = baseOpenIssue;
	}
	public String getBaseDeliveredIssue() {
		return baseDeliveredIssue;
	}
	public void setBaseDeliveredIssue(String baseDeliveredIssue) {
		this.baseDeliveredIssue = baseDeliveredIssue;
	}
	public String getBaseInprogressIssue() {
		return baseInprogressIssue;
	}
	public void setBaseInprogressIssue(String baseInprogressIssue) {
		this.baseInprogressIssue = baseInprogressIssue;
	}
	public String getCustomOpenIssue() {
		return customOpenIssue;
	}
	public void setCustomOpenIssue(String customOpenIssue) {
		this.customOpenIssue = customOpenIssue;
	}
	public String getCustomDeliveredIssue() {
		return customDeliveredIssue;
	}
	public void setCustomDeliveredIssue(String customDeliveredIssue) {
		this.customDeliveredIssue = customDeliveredIssue;
	}
	public String getCustomInprogressIssue() {
		return customInprogressIssue;
	}
	public void setCustomInprogressIssue(String customInprogressIssue) {
		this.customInprogressIssue = customInprogressIssue;
	}
	public String getModOpenIssue() {
		return modOpenIssue;
	}
	public void setModOpenIssue(String modOpenIssue) {
		this.modOpenIssue = modOpenIssue;
	}
	public String getModDeliveredIssue() {
		return modDeliveredIssue;
	}
	public void setModDeliveredIssue(String modDeliveredIssue) {
		this.modDeliveredIssue = modDeliveredIssue;
	}
	public String getModInprogressIssue() {
		return modInprogressIssue;
	}
	public void setModInprogressIssue(String modInprogressIssue) {
		this.modInprogressIssue = modInprogressIssue;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}