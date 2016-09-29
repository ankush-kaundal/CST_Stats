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
import com.manh.helper.NextupNumber;
import com.manh.model.CSTCheckList;
import com.manh.model.LeavePlanner;

public class CSTCheckListDaoImpl implements ICSTCheckListDao {
 
	private DataSource dataSource;
	private final static Logger logger = LoggerFactory.getLogger(LeavePlannerDaoImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<CSTCheckList> getProjectList(){
		String sql = "select distinct project_name,project_code from cst_checklist order by project_name ";
		
		List<CSTCheckList> cstCheckListObj = new ArrayList<CSTCheckList>();
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CSTCheckList obj = new CSTCheckList();
				obj.setProjectName(rs.getString("project_name"));
				obj.setProjectCode(rs.getString("project_code"));
				cstCheckListObj.add(obj);
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
		
		return cstCheckListObj;
    }
	
	public void submitCheckList(CSTCheckList cstCheckList){
		boolean retValue = isRecordAlreadyPopulated(cstCheckList.getProjectCode());
		
		if(retValue){
			updateCheckList(cstCheckList); 
		}else{
			insertCheckList(cstCheckList);
		}
	}
	
	public void insertCheckList(CSTCheckList cstCheckList){
		String sql = "insert into cst_checklist ( cst_checklist_id,project_name,project_code,"
				+ "project_plan,billing_information,rmt,"
				+ "salesforce_usage,onsite_team_details,customer_team_details,"
				+ "environment_info, windows_vm_box,vm_image_path,"
				+ "is_wm_mda_repo_seperated,wm_repo,mda_repo,"
				+ "git_info,mod_specs,tech_doc,"
				+ "delivery_note,any_mods_in_progress,any_mods_in_progress_cmnt,"
				+ "is_the_project_status_red,is_the_project_status_red_cmnt,planned_group_of_mods,"
				+ "planned_group_of_mods_cmnt,go_live_date,go_live_date_cmnt,"
				+ "mod_tested_on_client,mod_tested_on_client_cmnt,number_of_open_issue,"
				+ "number_of_open_issue_cmnt,resource_handover_planned,resource_handover_planned_cmnt,"
				+ "logged_hours,logged_hours_cmnt,vpt_planned, "
				+ "vpt_planned_cmnt,warehouse_flow_document,warehouse_flow_document_cmnt,"
				+ "version_rollup_info,version_rollup_info_cmnt,mod_vs_env_mapping,"
				+ "mod_vs_env_mapping_cmnt, build_in_sync,build_in_sync_cmnt,"
				+ "list_of_sf_case,list_of_sf_case_cmnt,config_doc_for_mod,"
				+ "config_doc_for_mod_cmnt,build_box_in_sync,build_box_in_sync_cmnt, "
				+ "add_cst_manager_netsteps,sdn_process_documented,sdn_process_documented_cmnt,"
				+ "kt_for_mod,kt_for_mod_cmnt,fix_pack_creation_process,"
				+ "fix_pack_creation_process_cmnt, test_scripts_in_mamatters,test_scripts_in_mamatters_cmnt,"
				+ "resource_handover,resource_handover_cmnt,jira_mentioned_in_sf,"				
				+ "jira_mentioned_in_sf_cmnt,create_date_time,update_date_time) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		ResultSet rs = null ;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			int nextupValue = NextupNumber.getNextupValue(conn, "cst_checklist_id_seq");
			
			if(nextupValue != 0){
				preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setInt(1, nextupValue);
				preparedStmt.setString(2, cstCheckList.getProjectName());
				preparedStmt.setString(3, cstCheckList.getProjectCode());
				
				preparedStmt.setString(4, cstCheckList.getProjectPlan());
				preparedStmt.setString(5, cstCheckList.getBillingInformation());
				preparedStmt.setString(6, cstCheckList.getRmt());
				
				preparedStmt.setString(7, cstCheckList.getSalesforceUsage());
				preparedStmt.setString(8, cstCheckList.getOnsiteTeamDetails());
				preparedStmt.setString(9, cstCheckList.getCustomerTeamDetails());
				
				preparedStmt.setString(10, cstCheckList.getEnvironmentInfo());
				preparedStmt.setString(11, cstCheckList.getWindowsVmBox());
				preparedStmt.setString(12, cstCheckList.getVmImagePath());
				
				preparedStmt.setString(13, cstCheckList.getIsWmMdaRepoSeperated());
				preparedStmt.setString(14, cstCheckList.getWmRepo());
				preparedStmt.setString(15, cstCheckList.getMdaRepo());
				
				preparedStmt.setString(16, cstCheckList.getGitInfo());
				preparedStmt.setString(17, cstCheckList.getModSpecs());
				preparedStmt.setString(18, cstCheckList.getTechDoc());
				
				preparedStmt.setString(19, cstCheckList.getDeliveryNote());
				preparedStmt.setString(20, cstCheckList.getAnyModsInProgress());
				preparedStmt.setString(21, cstCheckList.getAnyModsInProgressCmnt());
				
				preparedStmt.setString(22, cstCheckList.getIsTheProjectStatusRed());
				preparedStmt.setString(23, cstCheckList.getIsTheProjectStatusRedCmnt());
				preparedStmt.setString(24, cstCheckList.getPlannedGroupOfMods());
				
				preparedStmt.setString(25, cstCheckList.getPlannedGroupOfModsCmnt());
				preparedStmt.setString(26, cstCheckList.getGoLiveDate());
				preparedStmt.setString(27, cstCheckList.getGoLiveDateCmnt());
				
				preparedStmt.setString(28, cstCheckList.getModTestedOnClient());
				preparedStmt.setString(29, cstCheckList.getModTestedOnClientCmnt());
				preparedStmt.setString(30, cstCheckList.getNumberOfOpenIssue());
				
				preparedStmt.setString(31, cstCheckList.getNumberOfOpenIssueCmnt());
				preparedStmt.setString(32, cstCheckList.getResourcHandoverPlanned());
				preparedStmt.setString(33, cstCheckList.getResourceHandoverPlannedCmnt());
				
				preparedStmt.setString(34, cstCheckList.getLoggedHours());
				preparedStmt.setString(35, cstCheckList.getLoggedHoursCmnt());
				preparedStmt.setString(36, cstCheckList.getVptPlanned());
				
				preparedStmt.setString(37, cstCheckList.getVptPlannedCmnt());
				preparedStmt.setString(38, cstCheckList.getWarehouseFlowDocument());
				preparedStmt.setString(39, cstCheckList.getWarehouseFlowDocumentCmnt());
				
				preparedStmt.setString(40, cstCheckList.getVersionRollupInfo());
				preparedStmt.setString(41, cstCheckList.getVersionRollupInfoCmnt());
				preparedStmt.setString(42, cstCheckList.getModVsEnvMapping());
				
				preparedStmt.setString(43, cstCheckList.getModVsEnvMappingCmnt());
				preparedStmt.setString(44, cstCheckList.getBuildInSync());
				preparedStmt.setString(45, cstCheckList.getBuildInSyncCmnt());
				
				preparedStmt.setString(46, cstCheckList.getListOfSfCase());
				preparedStmt.setString(47, cstCheckList.getListOfSfCaseCmnt());
				preparedStmt.setString(48, cstCheckList.getConfigDocForMod());
				
				preparedStmt.setString(49, cstCheckList.getConfigDocForModCmnt());
				preparedStmt.setString(50, cstCheckList.getBuildBoxInSync());
				preparedStmt.setString(51, cstCheckList.getBuildBoxInSyncCmnt());
				
				preparedStmt.setString(52, cstCheckList.getAddCstManagerNetsteps());
				preparedStmt.setString(53, cstCheckList.getSdnProcessDocumented());
				preparedStmt.setString(54, cstCheckList.getSdnProcessDocumentedCmnt());
				
				preparedStmt.setString(55, cstCheckList.getKtForMod());
				preparedStmt.setString(56, cstCheckList.getKtForModCmnt());
				preparedStmt.setString(57, cstCheckList.getFixPackCreationProcess());
				
				preparedStmt.setString(58, cstCheckList.getFixPackCreationProcessCmnt());
				preparedStmt.setString(59, cstCheckList.getTestScriptsInMamatters());
				preparedStmt.setString(60, cstCheckList.getTestScriptsInMamattersCmnt());
				
				preparedStmt.setString(61, cstCheckList.getResourceHandover());
				preparedStmt.setString(62, cstCheckList.getResourceHandoverCmnt());
				preparedStmt.setString(63, cstCheckList.getJiraMentionedInSf());
				
				preparedStmt.setString(64, cstCheckList.getJiraMentionedInSfCmnt());
				
				java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
				preparedStmt.setDate(65, sqlDate);
				preparedStmt.setDate(66, sqlDate);
				
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
	
	public void updateCheckList(CSTCheckList cstCheckList){
		String sql = "update cst_checklist set project_name = ?, project_code = ?, "
				+ "project_plan = ?, billing_information = ?, rmt = ?, "
				+ "salesforce_usage = ?, onsite_team_details = ?, customer_team_details = ?, "
				+ "environment_info = ?, windows_vm_box = ?, vm_image_path = ?, "
				+ "is_wm_mda_repo_seperated = ?, wm_repo = ?, mda_repo = ?, "
				+ "git_info = ?, mod_specs = ?, tech_doc = ?, "
				+ "delivery_note = ?, any_mods_in_progress = ?, any_mods_in_progress_cmnt = ?, "
				+ "is_the_project_status_red = ?, is_the_project_status_red_cmnt = ?, planned_group_of_mods = ?, "
				+ "planned_group_of_mods_cmnt = ?, go_live_date = ?, go_live_date_cmnt = ?, "
				+ "mod_tested_on_client = ?, mod_tested_on_client_cmnt = ?, number_of_open_issue = ?, "
				+ "number_of_open_issue_cmnt = ?, resource_handover_planned = ?, resource_handover_planned_cmnt = ?, "
				+ "logged_hours = ?, logged_hours_cmnt = ?, vpt_planned = ?, "
				+ "vpt_planned_cmnt = ?, warehouse_flow_document = ?, warehouse_flow_document_cmnt = ?, "
				+ "version_rollup_info = ?, version_rollup_info_cmnt = ?, mod_vs_env_mapping = ?, "
				+ "mod_vs_env_mapping_cmnt = ?, build_in_sync = ?, build_in_sync_cmnt = ?, "
				+ "list_of_sf_case = ?, list_of_sf_case_cmnt = ?, config_doc_for_mod = ?, "
				+ "config_doc_for_mod_cmnt = ?, build_box_in_sync = ?, build_box_in_sync_cmnt = ?, "
				+ "add_cst_manager_netsteps = ?, sdn_process_documented = ?, sdn_process_documented_cmnt = ?, "
				+ "kt_for_mod = ?, kt_for_mod_cmnt = ?, fix_pack_creation_process = ?, "
				+ "fix_pack_creation_process_cmnt = ?, test_scripts_in_mamatters = ?, test_scripts_in_mamatters_cmnt = ?, "
				+ "resource_handover = ?, resource_handover_cmnt = ?, jira_mentioned_in_sf = ?, "				
				+ "jira_mentioned_in_sf_cmnt = ?, create_date_time = ?, update_date_time  = ? where project_code = ?";
		
		Connection conn = null;
		ResultSet rs = null ;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, cstCheckList.getProjectName());
			preparedStmt.setString(2, cstCheckList.getProjectCode());
			preparedStmt.setString(3, cstCheckList.getProjectPlan());
			preparedStmt.setString(4, cstCheckList.getBillingInformation());
			preparedStmt.setString(5, cstCheckList.getRmt());
			preparedStmt.setString(6, cstCheckList.getSalesforceUsage());
			preparedStmt.setString(7, cstCheckList.getOnsiteTeamDetails());
			preparedStmt.setString(8, cstCheckList.getCustomerTeamDetails());
			preparedStmt.setString(9, cstCheckList.getEnvironmentInfo());
			preparedStmt.setString(10, cstCheckList.getWindowsVmBox());
			preparedStmt.setString(11, cstCheckList.getVmImagePath());
			preparedStmt.setString(12, cstCheckList.getIsWmMdaRepoSeperated());
			preparedStmt.setString(13, cstCheckList.getWmRepo());
			preparedStmt.setString(14, cstCheckList.getMdaRepo());
			preparedStmt.setString(15, cstCheckList.getGitInfo());
			preparedStmt.setString(16, cstCheckList.getModSpecs());
			preparedStmt.setString(17, cstCheckList.getTechDoc());
			preparedStmt.setString(18, cstCheckList.getDeliveryNote());
			preparedStmt.setString(19, cstCheckList.getAnyModsInProgress());
			preparedStmt.setString(20, cstCheckList.getAnyModsInProgressCmnt());
			preparedStmt.setString(21, cstCheckList.getIsTheProjectStatusRed());
			preparedStmt.setString(22, cstCheckList.getIsTheProjectStatusRedCmnt());
			preparedStmt.setString(23, cstCheckList.getPlannedGroupOfMods());
			preparedStmt.setString(24, cstCheckList.getPlannedGroupOfModsCmnt());
			preparedStmt.setString(25, cstCheckList.getGoLiveDate());
			preparedStmt.setString(26, cstCheckList.getGoLiveDateCmnt());
			preparedStmt.setString(27, cstCheckList.getModTestedOnClient());
			preparedStmt.setString(28, cstCheckList.getModTestedOnClientCmnt());
			preparedStmt.setString(29, cstCheckList.getNumberOfOpenIssue());
			preparedStmt.setString(30, cstCheckList.getNumberOfOpenIssueCmnt());
			preparedStmt.setString(31, cstCheckList.getResourcHandoverPlanned());
			preparedStmt.setString(32, cstCheckList.getResourceHandoverPlannedCmnt());
			preparedStmt.setString(33, cstCheckList.getLoggedHours());
			preparedStmt.setString(34, cstCheckList.getLoggedHoursCmnt());
			preparedStmt.setString(35, cstCheckList.getVptPlanned());
			preparedStmt.setString(36, cstCheckList.getVptPlannedCmnt());
			preparedStmt.setString(37, cstCheckList.getWarehouseFlowDocument());
			preparedStmt.setString(38, cstCheckList.getWarehouseFlowDocumentCmnt());
			preparedStmt.setString(39, cstCheckList.getVersionRollupInfo());
			preparedStmt.setString(40, cstCheckList.getVersionRollupInfoCmnt());
			preparedStmt.setString(41, cstCheckList.getModVsEnvMapping());
			preparedStmt.setString(42, cstCheckList.getModVsEnvMappingCmnt());
			preparedStmt.setString(43, cstCheckList.getBuildInSync());
			preparedStmt.setString(44, cstCheckList.getBuildInSyncCmnt());
			preparedStmt.setString(45, cstCheckList.getListOfSfCase());
			preparedStmt.setString(46, cstCheckList.getListOfSfCaseCmnt());
			preparedStmt.setString(47, cstCheckList.getConfigDocForMod());
			preparedStmt.setString(48, cstCheckList.getConfigDocForModCmnt());
			preparedStmt.setString(49, cstCheckList.getBuildBoxInSync());
			preparedStmt.setString(50, cstCheckList.getBuildBoxInSyncCmnt());
			preparedStmt.setString(51, cstCheckList.getAddCstManagerNetsteps());
			preparedStmt.setString(52, cstCheckList.getSdnProcessDocumented());
			preparedStmt.setString(53, cstCheckList.getSdnProcessDocumentedCmnt());
			preparedStmt.setString(54, cstCheckList.getKtForMod());
			preparedStmt.setString(55, cstCheckList.getKtForModCmnt());
			preparedStmt.setString(56, cstCheckList.getFixPackCreationProcess());
			preparedStmt.setString(57, cstCheckList.getFixPackCreationProcessCmnt());
			preparedStmt.setString(58, cstCheckList.getTestScriptsInMamatters());
			preparedStmt.setString(59, cstCheckList.getTestScriptsInMamattersCmnt());
			preparedStmt.setString(60, cstCheckList.getResourceHandover());
			preparedStmt.setString(61, cstCheckList.getResourceHandoverCmnt());
			preparedStmt.setString(62, cstCheckList.getJiraMentionedInSf());
			preparedStmt.setString(63, cstCheckList.getJiraMentionedInSfCmnt());
			
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			preparedStmt.setDate(64, sqlDate);
			preparedStmt.setDate(65, sqlDate);
			preparedStmt.setString(66, cstCheckList.getProjectCode());
			
			preparedStmt.executeUpdate();
					
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
	
	public boolean isRecordAlreadyPopulated(String projectCode){
		String sql = "select count(1) as count from cst_checklist where project_code = ? ";
		
		boolean retValue = false;
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, projectCode);
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
	
	public CSTCheckList getAllCSTListValueForAProject(String projectCode){
		String sql = "select project_name,project_code,"
				+ "project_plan,billing_information,rmt,"
				+ "salesforce_usage,onsite_team_details,customer_team_details,"
				+ "environment_info, windows_vm_box,vm_image_path,"
				+ "is_wm_mda_repo_seperated,wm_repo,mda_repo,"
				+ "git_info,mod_specs,tech_doc,"
				+ "delivery_note,any_mods_in_progress,any_mods_in_progress_cmnt,"
				+ "is_the_project_status_red,is_the_project_status_red_cmnt,planned_group_of_mods,"
				+ "planned_group_of_mods_cmnt,go_live_date,go_live_date_cmnt,"
				+ "mod_tested_on_client,mod_tested_on_client_cmnt,number_of_open_issue,"
				+ "number_of_open_issue_cmnt,resource_handover_planned,resource_handover_planned_cmnt,"
				+ "logged_hours,logged_hours_cmnt,vpt_planned, "
				+ "vpt_planned_cmnt,warehouse_flow_document,warehouse_flow_document_cmnt,"
				+ "version_rollup_info,version_rollup_info_cmnt,mod_vs_env_mapping,"
				+ "mod_vs_env_mapping_cmnt, build_in_sync,build_in_sync_cmnt,"
				+ "list_of_sf_case,list_of_sf_case_cmnt,config_doc_for_mod,"
				+ "config_doc_for_mod_cmnt,build_box_in_sync,build_box_in_sync_cmnt, "
				+ "add_cst_manager_netsteps,sdn_process_documented,sdn_process_documented_cmnt,"
				+ "kt_for_mod,kt_for_mod_cmnt,fix_pack_creation_process,"
				+ "fix_pack_creation_process_cmnt, test_scripts_in_mamatters,test_scripts_in_mamatters_cmnt,"
				+ "resource_handover,resource_handover_cmnt,jira_mentioned_in_sf,"				
				+ "jira_mentioned_in_sf_cmnt,create_date_time,update_date_time from cst_checklist where project_code = ?";
		
		List<CSTCheckList> cstCheckListObj = new ArrayList<CSTCheckList>();
		CSTCheckList obj = new CSTCheckList();
		Connection conn = null;
		
		try {			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, projectCode);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				obj.setProjectName(rs.getString("project_name"));
				obj.setProjectCode(rs.getString("project_code"));
				
				obj.setProjectPlan(rs.getString("project_plan"));
				obj.setBillingInformation(rs.getString("billing_information"));
				obj.setRmt(rs.getString("rmt"));
				obj.setSalesforceUsage(rs.getString("salesforce_usage"));
				obj.setOnsiteTeamDetails(rs.getString("onsite_team_details"));
				obj.setCustomerTeamDetails(rs.getString("customer_team_details"));
				obj.setEnvironmentInfo(rs.getString("environment_info"));
				obj.setWindowsVmBox(rs.getString("windows_vm_box"));
				obj.setVmImagePath(rs.getString("vm_image_path"));
				obj.setIsWmMdaRepoSeperated(rs.getString("is_wm_mda_repo_seperated"));
				obj.setWmRepo(rs.getString("wm_repo"));
				obj.setMdaRepo(rs.getString("mda_repo"));
				obj.setGitInfo(rs.getString("git_info"));
				obj.setModSpecs(rs.getString("mod_specs"));
				obj.setTechDoc(rs.getString("tech_doc"));
				obj.setDeliveryNote(rs.getString("delivery_note"));
				obj.setAnyModsInProgress(rs.getString("any_mods_in_progress"));
				obj.setAnyModsInProgressCmnt(rs.getString("any_mods_in_progress_cmnt"));
				obj.setIsTheProjectStatusRed(rs.getString("is_the_project_status_red"));
				obj.setIsTheProjectStatusRedCmnt(rs.getString("is_the_project_status_red_cmnt"));
				obj.setPlannedGroupOfMods(rs.getString("planned_group_of_mods"));
				obj.setPlannedGroupOfModsCmnt(rs.getString("planned_group_of_mods_cmnt"));
				obj.setGoLiveDate(rs.getString("go_live_date"));
				obj.setGoLiveDateCmnt(rs.getString("go_live_date_cmnt"));
				obj.setModTestedOnClient(rs.getString("mod_tested_on_client"));
				obj.setModTestedOnClientCmnt(rs.getString("mod_tested_on_client_cmnt"));
				
				obj.setNumberOfOpenIssue(rs.getString("number_of_open_issue"));
				obj.setNumberOfOpenIssueCmnt(rs.getString("number_of_open_issue_cmnt"));
				obj.setResourcHandoverPlanned(rs.getString("resource_handover_planned"));
				obj.setResourceHandoverPlannedCmnt(rs.getString("resource_handover_planned_cmnt"));
				obj.setLoggedHours(rs.getString("logged_hours"));
				obj.setLoggedHoursCmnt(rs.getString("logged_hours_cmnt"));
				obj.setVptPlanned(rs.getString("vpt_planned"));
				obj.setVptPlannedCmnt(rs.getString("vpt_planned_cmnt"));
				obj.setWarehouseFlowDocument(rs.getString("warehouse_flow_document"));
				obj.setWarehouseFlowDocumentCmnt(rs.getString("warehouse_flow_document_cmnt"));
				obj.setVersionRollupInfo(rs.getString("version_rollup_info"));
				obj.setVersionRollupInfoCmnt(rs.getString("version_rollup_info_cmnt"));
				obj.setModVsEnvMapping(rs.getString("mod_vs_env_mapping"));
				obj.setModVsEnvMappingCmnt(rs.getString("mod_vs_env_mapping_cmnt"));
				obj.setBuildInSync(rs.getString("build_in_sync"));
				obj.setBuildInSyncCmnt(rs.getString("build_in_sync_cmnt"));
				obj.setListOfSfCase(rs.getString("list_of_sf_case"));
				obj.setListOfSfCaseCmnt(rs.getString("list_of_sf_case_cmnt"));
				obj.setConfigDocForMod(rs.getString("config_doc_for_mod"));
				obj.setConfigDocForModCmnt(rs.getString("config_doc_for_mod_cmnt"));
				obj.setBuildBoxInSync(rs.getString("build_box_in_sync"));
				obj.setBuildBoxInSyncCmnt(rs.getString("build_box_in_sync_cmnt"));
				obj.setAddCstManagerNetsteps(rs.getString("add_cst_manager_netsteps"));
				obj.setSdnProcessDocumented(rs.getString("sdn_process_documented"));
				obj.setSdnProcessDocumentedCmnt(rs.getString("sdn_process_documented_cmnt"));
				obj.setKtForMod(rs.getString("kt_for_mod"));
				obj.setKtForModCmnt(rs.getString("kt_for_mod_cmnt"));
				obj.setFixPackCreationProcess(rs.getString("fix_pack_creation_process"));
				obj.setFixPackCreationProcessCmnt(rs.getString("fix_pack_creation_process_cmnt"));
				obj.setTestScriptsInMamatters(rs.getString("test_scripts_in_mamatters"));
				obj.setTestScriptsInMamattersCmnt(rs.getString("test_scripts_in_mamatters_cmnt"));
				obj.setResourceHandover(rs.getString("resource_handover"));
				obj.setResourceHandoverCmnt(rs.getString("resource_handover_cmnt"));
				obj.setJiraMentionedInSf(rs.getString("jira_mentioned_in_sf"));
				obj.setJiraMentionedInSfCmnt(rs.getString("jira_mentioned_in_sf_cmnt"));
								
				//cstCheckListObj.add(obj);
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
		
		return obj;
	}
}