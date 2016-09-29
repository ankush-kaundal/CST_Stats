package com.manh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manh.dao.ICSTCheckListDao;
import com.manh.dao.IUserDetailsDao;
import com.manh.helper.NextupNumber;
import com.manh.model.CSTCheckList;
import com.manh.model.LeavePlanner;
import com.manh.model.User;

public class UserDetailsDaoImpl implements IUserDetailsDao {
 
	private DataSource dataSource;
	private final static Logger logger = LoggerFactory.getLogger(LeavePlannerDaoImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public boolean createUserDetail(User user){
		String sql = "insert into user_details (user_details_id,user_email_id,user_name,password) values (?,?,?,?)";
		
		Connection conn = null;
		ResultSet rs = null ;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			int nextupValue = NextupNumber.getNextupValue(conn, "user_details_id_seq");
			
			if(nextupValue != 0){
				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setInt(1, nextupValue);
				preparedStmt.setString(2, user.getUserEmailId().toLowerCase());
				preparedStmt.setString(3, user.getUserName());
				preparedStmt.setString(4, user.getPassword());
				
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
		
		return true;
	}
	
	public boolean isUserAlreadyCreated(User user){
		String sql = "select count(1) as count from user_details where user_email_id = ? ";
		
		boolean retValue = false;
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserEmailId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt("count") > 0)
					retValue = true;					
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return retValue;
	}
	
	public boolean isValidUser(User user){
		String sql = "select count(1) as count from user_details where user_email_id = ? and password = ?";
		
		boolean retValue = false;
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserEmailId().toLowerCase());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getInt("count") > 0)
					retValue = true;					
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return retValue;
	}
	
	public String getUserName(User user){
		String sql = "select user_name from user_details where user_email_id = ? and password = ?";
		
		String userName = "";
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserEmailId().toLowerCase());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				userName = rs.getString("user_name");	
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return userName;
	}
}