package com.manh.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NextupNumber {
 	public static int getNextupValue(Connection conn, String sequenceName){
		ResultSet rs = null ;
		Statement sqlStatement = null ;
		int nextvalue = 0;
		
		try {
			String nextupQuery = "select " + sequenceName + ".NEXTVAL FROM dual"; 
			sqlStatement = conn.createStatement() ;
			rs = sqlStatement.executeQuery(nextupQuery) ;
			rs.next() ;
			nextvalue = rs.getInt(1) ;
			
			rs.close();
		    sqlStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (sqlStatement != null) {
				try {
					sqlStatement.close();
				} catch (SQLException e) {}
			}
		}
		
		return nextvalue;
    }
}