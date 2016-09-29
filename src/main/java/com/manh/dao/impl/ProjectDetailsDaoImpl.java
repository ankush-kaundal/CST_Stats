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

import com.manh.dao.IProjectDetailsDao;
import com.manh.model.ProjectDetails;

public class ProjectDetailsDaoImpl implements IProjectDetailsDao {
 
	private DataSource dataSource;
	private final static Logger logger = LoggerFactory.getLogger(ProjectDetailsDaoImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<ProjectDetails> getAllProjectDetails(){
		String sql = "select project_name, project_code, mod_specs, tech_doc, delivery_Note, environment_info from cst_checklist";
		
		Connection conn = null;
		
		try {
			List<ProjectDetails> projectNameList = new ArrayList<ProjectDetails>();
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProjectDetails projectDetails = new ProjectDetails();
				projectDetails.setProjectName(rs.getString("project_name"));
				projectDetails.setProjectCode(rs.getString("project_code"));
				projectDetails.setModSpecsLink(rs.getString("mod_specs"));
				projectDetails.setTechDocLink(rs.getString("tech_doc"));
				projectDetails.setDeliverNoteLink(rs.getString("delivery_Note"));
				projectDetails.setMamattersLink(rs.getString("environment_info"));
				projectNameList.add(projectDetails);
			}
			
			rs.close();
			ps.close();
			return projectNameList;
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