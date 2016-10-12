CREATE TABLE leave_planner
( leave_planner_id number(10) NOT NULL,
  user_id       varchar2(100),
  user_name       varchar2(100),  
  from_date       varchar2(100),
  to_date         varchar2(100),
  CONSTRAINT leave_planner_pk PRIMARY KEY (leave_planner_id)
);

CREATE SEQUENCE leave_planner_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
MAXVALUE 10000000
CYCLE
CACHE 10;

CREATE TABLE cst_checklist
( cst_checklist_id number(10) NOT NULL,
  project_name    varchar2(500),
  project_code    varchar2(100),
  project_plan    varchar2(1000),
  billing_information varchar2(100),
  rmt varchar2(100),
  salesforce_usage varchar2(100),
  onsite_team_details varchar2(1000),
  customer_team_details varchar2(1000),  
  environment_info varchar2(1000),
  windows_vm_box varchar2(1000),
  vm_image_path varchar2(1000),
  is_wm_mda_repo_seperated varchar2(1000),
  wm_repo varchar2(1000),
  mda_repo varchar2(1000),  
  git_info varchar2(1000),
  mod_specs varchar2(1000),
  tech_doc varchar2(1000),
  delivery_note varchar2(1000),
  any_mods_in_progress varchar2(10),
  any_mods_in_progress_cmnt varchar2(1000),
  is_the_project_status_red varchar2(10),
  is_the_project_status_red_cmnt varchar2(1000),
  planned_group_of_mods varchar2(10),
  planned_group_of_mods_cmnt varchar2(1000),
  go_live_date varchar2(10),
  go_live_date_cmnt varchar2(1000),
  mod_tested_on_client varchar2(10),
  mod_tested_on_client_cmnt varchar2(1000),  
  number_of_open_issue varchar2(10),
  number_of_open_issue_cmnt varchar2(1000),
  resource_handover_planned varchar2(10),
  resource_handover_planned_cmnt varchar2(1000),
  logged_hours varchar2(10),
  logged_hours_cmnt varchar2(1000),
  vpt_planned varchar2(10),
  vpt_planned_cmnt varchar2(1000),
  warehouse_flow_document varchar2(10),
  warehouse_flow_document_cmnt varchar2(1000),
  version_rollup_info varchar2(10),
  version_rollup_info_cmnt varchar2(1000),
  mod_vs_env_mapping varchar2(10),
  mod_vs_env_mapping_cmnt varchar2(1000),
  build_in_sync varchar2(10),
  build_in_sync_cmnt varchar2(1000),
  list_of_sf_case varchar2(10),
  list_of_sf_case_cmnt varchar2(1000),
  config_doc_for_mod varchar2(10),
  config_doc_for_mod_cmnt varchar2(1000),
  build_box_in_sync varchar2(10),
  build_box_in_sync_cmnt varchar2(1000),
  add_cst_manager_netsteps varchar2(10),
  sdn_process_documented varchar2(10),
  sdn_process_documented_cmnt varchar2(1000),
  kt_for_mod varchar2(10),
  kt_for_mod_cmnt varchar2(1000),
  fix_pack_creation_process varchar2(10),
  fix_pack_creation_process_cmnt varchar2(1000),
  test_scripts_in_mamatters varchar2(10),
  test_scripts_in_mamatters_cmnt varchar2(1000),
  resource_handover varchar2(10),
  resource_handover_cmnt varchar2(1000),
  jira_mentioned_in_sf varchar2(10),
  jira_mentioned_in_sf_cmnt varchar2(1000),
  create_date_time date,
  update_date_time date,
  CONSTRAINT cst_checklist_pk PRIMARY KEY (cst_checklist_id)
);

CREATE SEQUENCE cst_checklist_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
MAXVALUE 10000000
CYCLE
CACHE 10;

CREATE TABLE user_details
( user_details_id number(10) NOT NULL,
  user_email_id       varchar2(100),
  user_name           varchar2(100),  
  password            varchar2(100),
  CONSTRAINT user_details_pk PRIMARY KEY (user_details_id)
);

CREATE SEQUENCE user_details_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
MAXVALUE 10000000
CYCLE
CACHE 10;

CREATE TABLE weekly
( weekly_id number(10) NOT NULL,
  project_name    varchar2(500),
  project_code    varchar2(100),
  base_open_issue    number,
  base_delivered_issue    number,
  base_inprogress_issue    number,
  custom_open_issue    number,
  custom_delivered_issue    number,
  custom_inprogress_issue    number,
  mod_open_issue    number,
  mod_delivered_issue    number,
  mod_inprogress_issue    number,
  comments	varchar2(32000),
  create_date_time date,
  update_date_time date,
  CONSTRAINT weekly_pk PRIMARY KEY (weekly_id)
);

CREATE SEQUENCE weekly_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
MAXVALUE 10000000
CYCLE
CACHE 10;
