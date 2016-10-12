package com.manh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manh.dao.IWeeklyDao;
import com.manh.helper.NextupNumber;
import com.manh.model.CSTCheckList;
import com.manh.model.Weekly;

public class WeeklyDaoImpl implements IWeeklyDao {
 
	private DataSource dataSource;
	private final static Logger logger = LoggerFactory.getLogger(LeavePlannerDaoImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void submitWeekly(Weekly weekly){
		insertWeekly(weekly);
	}	
	
	public void insertWeekly(Weekly weekly){
		String sql = "insert into weekly (weekly_id,project_name,project_code,base_open_issue,base_delivered_issue,base_inprogress_issue,"
				+ "custom_open_issue,custom_delivered_issue,custom_inprogress_issue,mod_open_issue,mod_delivered_issue,mod_inprogress_issue,"
				+ "comments,create_date_time,update_date_time) values (?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			int nextupValue = NextupNumber.getNextupValue(conn, "weekly_id_seq");
			
			if(nextupValue != 0){
				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setInt(1, nextupValue);
				preparedStmt.setString(2, weekly.getProjectName());
				preparedStmt.setString(3, weekly.getProjectCode());
				
				preparedStmt.setString(4, weekly.getBaseOpenIssue());
				preparedStmt.setString(5, weekly.getBaseDeliveredIssue());
				preparedStmt.setString(6, weekly.getBaseInprogressIssue());
				
				preparedStmt.setString(7, weekly.getCustomOpenIssue());
				preparedStmt.setString(8, weekly.getCustomDeliveredIssue());
				preparedStmt.setString(9, weekly.getCustomInprogressIssue());
				
				preparedStmt.setString(10, weekly.getModOpenIssue());
				preparedStmt.setString(11, weekly.getModDeliveredIssue());
				preparedStmt.setString(12, weekly.getModInprogressIssue());
				
				preparedStmt.setString(13, weekly.getComments());
				
				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				preparedStmt.setDate(14, sqlDate);
				preparedStmt.setDate(15, sqlDate);
				
				preparedStmt.execute();
			}			
			
		    conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
    }
}