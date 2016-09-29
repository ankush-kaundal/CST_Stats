package com.manh.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manh.dao.ILeavePlannerDao;
import com.manh.helper.NextupNumber;
import com.manh.model.LeavePlanner;
import com.manh.model.ProjectDetails;

public class LeavePlannerDaoImpl implements ILeavePlannerDao {
 
	private DataSource dataSource;
	private final static Logger logger = LoggerFactory.getLogger(LeavePlannerDaoImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void submitLeaveDetails(LeavePlanner leavePlanner){
		String sql = "INSERT INTO leave_planner (leave_planner_id,user_id,user_name,from_date,to_date) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		ResultSet rs = null ;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			int nextupValue = NextupNumber.getNextupValue(conn, "leave_planner_id_seq");
			
			if(nextupValue != 0){
				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setInt(1, nextupValue);
				preparedStmt.setString(2, "sacgupta@manh.com");
				preparedStmt.setString(3, "sachin");
				preparedStmt.setString(4, leavePlanner.getFromDate());
				preparedStmt.setString(5, leavePlanner.getToDate());
				
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
	
	public int getNextupValue(String sequenceName){
		Connection conn = null;
		ResultSet rs = null ;
		Statement sqlStatement = null ;
		int nextvalue = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String nextupQuery = "select " + sequenceName + ".NEXTVAL FROM dual"; 
			sqlStatement = conn.createStatement() ;
			rs = sqlStatement.executeQuery(nextupQuery) ;
			rs.next() ;
			nextvalue = rs.getInt(1) ;
			
			rs.close();
		    sqlStatement.close();
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
		
		return nextvalue;
    }
	
	public List<LeavePlanner> getAllAppliedLeave(){
		String sql = "select user_name,from_date,to_date,user_id from leave_planner order by user_name, from_date";
		
		Connection conn = null;
		
		try {
			List<LeavePlanner> leavePlannerList = new ArrayList<LeavePlanner>();
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				LeavePlanner leavePlanner = new LeavePlanner();
				leavePlanner.setUserName(rs.getString("user_name"));
				leavePlanner.setFromDate(rs.getString("from_date"));
				leavePlanner.setToDate(rs.getString("to_date"));
				leavePlanner.setUserId(rs.getString("user_id"));
				leavePlannerList.add(leavePlanner);
			}
			
			rs.close();
			ps.close();
			return leavePlannerList;
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
	
	public List<LeavePlanner> getAppliedLeaveByUserId(String userId){
		String sql = "select user_name,from_date,to_date,user_id from leave_planner where user_id = ? order by from_date";
		
		Connection conn = null;
		
		try {
			List<LeavePlanner> leavePlannerList = new ArrayList<LeavePlanner>();
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				LeavePlanner leavePlanner = new LeavePlanner();
				leavePlanner.setUserName(rs.getString("user_name"));
				leavePlanner.setFromDate(rs.getString("from_date"));
				leavePlanner.setToDate(rs.getString("to_date"));
				leavePlanner.setUserId(rs.getString("user_id"));
				leavePlannerList.add(leavePlanner);
			}
			
			rs.close();
			ps.close();
			return leavePlannerList;
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
	
	public List<LeavePlanner> getAllUserInfo(){
		String sql = "select distinct user_name,user_id from leave_planner order by user_name ";
		
		Connection conn = null;
		
		try {
			List<LeavePlanner> leavePlannerList = new ArrayList<LeavePlanner>();
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				LeavePlanner leavePlanner = new LeavePlanner();
				leavePlanner.setUserName(rs.getString("user_name"));
				leavePlanner.setUserId(rs.getString("user_id"));
				leavePlannerList.add(leavePlanner);
			}
			
			rs.close();
			ps.close();
			return leavePlannerList;
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