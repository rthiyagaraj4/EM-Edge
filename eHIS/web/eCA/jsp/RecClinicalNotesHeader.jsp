<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
25/07/2012		IN034224			Dinesh T	Recording and signing the addendum is not functioning properly
19/09/2012		IN033677			Dinesh T	CRF-Recording and signing the addendum with new free text editor
04/03/2013	IN038176		Dinesh T		Forwarding the notes to other practitioner for signing
08/10/2013	    IN041881		NijithaS		MO-GN-5428
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .
02/06/2014	  IN037701		Nijitha											SKR-CRF-0036
24/09/2014	  IN050839		NijithaS										ML-BRU-SCF-1422	
28/11/2014    IN052757		Chowminya										Clinical default from quicklink select - page not loaded
06/05/2015	IN053733		Ramesh G										When a notifiable recorded against a notifiable diagnosis is marked in error, 
																			the notification to be de-linked from the parent diagnosis
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
01/11/2016		IN061988	Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
27/06/2017	 IN064566		Raja S		27/06/2017		Ramesh G			PMG2017-GHL-CRF-0005
15/02/2018	 IN063799		Prakash C	15/02/2018		Ramesh		ML-MMOH-CRF-0808
22/05/2018	 IN067607		Raja S		22/05/2018		Ramesh G			ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
18/03/2020	IN071264		Nijitha S	18/03/2020		Ramesh G			GHL-CRF-0604
27/07/2022	26826			Ramesh G									MMS-DM-CRF-0197
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="eOR.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%><!--Added common bean IN064566-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<title>RecClinicalNotesHeader</title>
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String practitioner_id		=	(String)session.getValue("ca_practitioner_id");
	String practitioner_name		=	checkForNull((String)		session.getValue("practitioner_name"));
	practitioner_name		=	practitioner_name.replace('\'',' ');
	
	String action_comment = request.getParameter("action_comment") == null ? "" : request.getParameter("action_comment");
	String dispResLinkHYMLYN = request.getParameter("dispResLinkHYMLYN") == null ? "" : request.getParameter("dispResLinkHYMLYN"); //IN041284
	String noteSplCharValidate = request.getParameter("noteSplCharValidate") == null ? "" : request.getParameter("noteSplCharValidate"); //IN059571
	//IN037701 Starts
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	String l_notes_view = request.getParameter("p_notes_view") == null ? "" : request.getParameter("p_notes_view");
	//IN037701 Ends
	String display   =request.getParameter("display")==null?"Y":request.getParameter("display"); //IN063799
	String p_called_from_widget   =request.getParameter("p_called_from_widget")==null?"Y":request.getParameter("p_called_from_widget"); //IN071264
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="javascript" src="../../eCA/js/RecClinicalNotesPart1.js"></script>
<script language="javascript" src="../../eCA/js/RecClinicalNotesPart2.js"></script>
<script language="javascript" src="../../eCA/js/RecClinicalNotesPart4.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- IN071264 Starts-->
<script>
function autoSave(auto_save_time){
	if('N'==document.getElementById("autoSaveCheck").value){
		document.getElementById("autoSaveCheck").value='Y';
		document.getElementById("autoSaveImg").src='../../eCA/images/ToggleSwitchOn.png';
		document.getElementById("timer").style.display='inline-block';
		document.getElementById("timerlable").style.display='inline-block';		
		countdown(auto_save_time);
	}else if('Y'==document.getElementById("autoSaveCheck").value){
		document.getElementById("autoSaveCheck").value='N';
		document.getElementById("autoSaveImg").src='../../eCA/images/ToggleSwitchOff.png';
		document.getElementById("timer").style.display="none";
		document.getElementById("timerlable").style.display="none";
	}
}
</script>
<!-- IN071264 Starts-->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="callMeOnLoad()" class='CONTENT'>
<%
	
	Connection				con					= null;
	
	PreparedStatement		pstmt				= null;
	PreparedStatement		ptPatLine			= null;

	ResultSet				rs					= null;
	ResultSet				stPatLine			= null;

	String	note_type						=	"",		note_type_desc			=	"";
	String	service_code					=	"",		service_desc			=	"";
	String	performed_by_id					=	"",		performed_by_name		=	"";
	String	episode_type					=	"",		resp_id					=	"";
	String	patient_id						=	"",		categoryId				=	"";
	String	encounter_id					=	"",		visit_adm_date			=	"";
	String	sys_date_time					=	"",		appl_task_id			=	"";
	String	operation_mode					=	"",		facility_id				=	"";
	String auto_save_yn="";//IN071264
	String auto_save_time="";//IN071264
	String	patient_class					=	"",		function_id				=	"";
	String	accession_num					=	"",		privilege_type			=	"";
	String	event_type_caption				=	"",		event_class				=	"";
	String	security_level					=	"",		event_date_caption		=	"";
	String	event_date_time					=	"",		event_perf_by_caption	=	"";
	String	event_title_caption				=	"",		event_title_desc		=	"";
	String	event_auth_by_caption			=	"",		amendment_type			=	"";
	String	event_status_caption			=	"",		event_status			=	"";
	String	serv_facl_spec_yn				=	"",		figer_print_auth_yn		=   "";
	String	p_note_type						=	"",		p_date_time				=	"";
	String	autho_doct_name					=	"",		strModifiedBy			=	"";
	String	speciality_code					=	"",		qry_params				=	"";
	String  strDetailsQry					=	"",		facility_name			=	"";
	String  attending_practitioner			=	"",		disflag					=	"disabled";
	String	days_backdate					=	"",		speciality_name			=	"";
	String	event_status_code				=	""; 
	String  attending_practitioner_temp			= "";//IN041881
	String	Sex				=	"",quicklinkDate="",parameterDate="";
	String notifiable_code		=""; //IN053733
	int temp=0; 
	String	Dob				=	""; 
	String	module_id				=	""; 
	String	discharge_date_time				=	""; 
	String	location_code				=	""; 
	String	service_name				=	""; 
	String	speciality_code1				=	""; 
	String splty_code = "";
	String p_splty_code = "";
	String splty_code_desc = "";
	String splQuery = "";
	String disableFilterBy = "";
	String note_group_id = "";
	String note_group_disable = "";
	String note_status = "";
	String sec_count = "";
	String doc_linked_note_yn = "";
	String no_of_rec_per_enc			=	"";
	String countQuerySec			=	"";
	String query_section_details			=	"";
	String query_section_details_serv			=	"";
	String msgfrom			=	"";
	String called_from			=	"";
	String contr_mod_accession_num			=	"";
	String contr_oth_accession_num  = ""; //IN053733
	String performedId						=	"";
	boolean NoteTypeflag			=	false;
	String srl_no	= "";  //[IN033677]
	int record_cnt_for_enc = 0;
	
	String		role_based_access_yn	=	"",	pre_cond_for_rec 			=	"";
	boolean error_flag = false;
	boolean search_screen_activated = false;
	int cntNote = 0;
	int count=1;
	int count1=1;
	int count2=1;
	StringBuffer sqlQuery = new StringBuffer();

	String sec_count_upd ="";
	String doc_linked_note_yn_upd ="";

	// 0064 

		PreparedStatement stmtsql = null;
		
		String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
		String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");

		String sqlFilter = "";
		String column_id = "",	column_desc = "",	value_type = "",	actual_value = "";
		String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
		String final_value = "";
		String field_desc = "";
		//String sel = "";
		//String iSel = "", dSel = "", oSel = "", Esel = "", Xsel = "";
		HashMap map = new HashMap();		
		String default_sql = "";
		StringBuffer default_query = new StringBuffer();
		int Existance_Count = 0;

		String filter_by_ql="",speciality_ql="",note_type_ql="",medanc_serv_ql="",performed_by_ql="";

		String date_ind = "", date_val = "", date_unit = "", date_ref = "";
		StringTokenizer strToken = null;

		String  filter_by_sel="";
		String  speciality_disp="";
		StringBuffer spl_ql_qry =new StringBuffer();

		String filter_by_ql_tmp="P";
		String ql_flag="N";
		String serv_name_ql="",perf_pract_name_ql="";

		// 0064 ends
	
		String dflt_transcription_yn ="N";
		String transcription_yn ="N";
		String sel_filterBy ="";
		String note_group_req ="";
		boolean custSpecificFlg =false;//IN064566
		String siteSpecFlag="N"; //IN064566
		boolean myHIXSiteFlag =false;//IN067607
		String myHIXSiteFlg="N";//IN067607
		String myHIXNoteType = "";//IN067607
		boolean copiedFlag = false;//IN068105
		String copiedFlagYN = "N";//IN068105

		StringBuffer	query_header_details	=	new StringBuffer();	
		String loggedUser	= (String) session.getValue("login_user");

		try
		{
			facility_id				=	(String)session.getValue("facility_id");
			resp_id					=	(String)session.getValue("responsibility_id");
			
			operation_mode			=	checkForNull(request.getParameter("operation_mode"));
			function_id				=	checkForNull(request.getParameter("function_id"));
			amendment_type			=	checkForNull(request.getParameter("amendment_type"));
			episode_type			=	checkForNull(request.getParameter("episode_type"));
			patient_id				=	checkForNull(request.getParameter("patient_id"));
			encounter_id			=	checkForNull(request.getParameter("encounter_id"),"0");
			visit_adm_date			=	checkForNull(request.getParameter("visit_adm_date"));
			patient_class			=	checkForNull(request.getParameter("patient_class"),"XT");
			event_class				=	checkForNull(request.getParameter("event_class"));
			categoryId				=   checkForNull(request.getParameter("categ_id"));
			note_type				=	checkForNull(request.getParameter("note_type")); 
			appl_task_id			=	checkForNull(request.getParameter("appl_task_id"));
			called_from			=	checkForNull(request.getParameter("called_from"));
			note_group_req			=	checkForNull(request.getParameter("note_group"));
			srl_no					=	checkForNull(request.getParameter("srl_no"));
			contr_mod_accession_num	=	checkForNull(request.getParameter("contr_mod_accession_num"));
			contr_oth_accession_num	=	checkForNull(request.getParameter("contr_oth_accession_num"));
			notifiable_code  =	request.getParameter("notifiable_code")==null?"":(String)request.getParameter("notifiable_code"); //IN044085
			String notifiable_emailYN  =	request.getParameter("notifiable_emailYN")==null?"N":(String)request.getParameter("notifiable_emailYN"); //IN044085
			
			
			performedId				=	request.getParameter("performedId")==null?"":(String)request.getParameter("performedId");
			performed_by_ql	=	request.getParameter("performed_by_ql")==null?"":(String)request.getParameter("performed_by_ql");
			
			
			con				=	ConnectionManager.getConnection(request);
		
			//26826 Start.			
			String or_bean_id 						= "@orderentrybean"+patient_id+encounter_id;
			String or_bean_name 					= "eOR.OrderEntryBean";
			OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			bean.setLanguageId(locale);			
			String  dxChkBfrPlaceOrderYN=bean.allowedNewOrders(con,patient_id,encounter_id,patient_class,facility_id);
			if("Y".equals(dxChkBfrPlaceOrderYN)){
			//26826 End.
			
				//IN064566 starts
				try
				{
					custSpecificFlg = CommonBean.isSiteSpecific(con, "CA","MANDATORY_CHECK_ALERT");
					if(custSpecificFlg)
						siteSpecFlag ="Y";
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				//IN064566 Ends
				//IN041284 Start.
				//IN059571 Star.
				//String sql = "select DISP_RES_LINK_HTML_YN from CA_NOTE_PARAM";
				//String sql = "select DISP_RES_LINK_HTML_YN,NOTE_SPL_CHAR_VALD from CA_NOTE_PARAM";//IN071264
				
				String sql = "select DISP_RES_LINK_HTML_YN,NOTE_SPL_CHAR_VALD, AUTO_SAVE_YN,AUTO_SAVE_TIME from CA_NOTE_PARAM";//IN071264
				//IN059571 End.
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()){
					dispResLinkHYMLYN = rs.getString(1) == null ? "N" : (String) rs.getString(1);
					noteSplCharValidate = rs.getString(2) == null ? "N" : (String) rs.getString(2); //IN059571
					auto_save_yn = rs.getString(3) == null ? "N" : (String) rs.getString(3); //IN071264 

					auto_save_time = rs.getString(4) == null ? "N" : (String) rs.getString(4); //IN071264
					
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				//IN041284 End.
				qry_params		= "select nvl(FIGER_PRINT_AUTH_YN, 'N') FIGER_PRINT_AUTH_YN,days_backdate from ca_note_param";
				pstmt = con.prepareStatement(qry_params);
				
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					figer_print_auth_yn			=   rs.getString("figer_print_auth_yn");
					days_backdate				=	rs.getString("days_backdate");
				}
				sys_date_time	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
				
				if(rs!=null) rs.close();					   
				if(pstmt!=null) pstmt.close();
			
				
				
				//IN068105 start
				copiedFlag = CommonBean.isSiteSpecific(con, "CA","COPIED_NOTE_INFO");
				if(copiedFlag)
					copiedFlagYN="Y";
				//IN068105 ends		
			//IN067607 starts
				try
				{
					if(function_id.equals("DISCHARGE_SUMMARY")){
						myHIXSiteFlag = CommonBean.isSiteSpecific(con, "CA","SENT_MYHIX");
						if(myHIXSiteFlag){
							myHIXSiteFlg ="Y";

							String myHIXSql="Select DEFAULT_VALUE MYHIX_NOTE_CODE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = 'XMLSTD' and SEGMENT_ID in ('DISREGC','ENCREGC') and ELEMENT_ID = 'NOTE_TYPE'";
							pstmt	=	con.prepareStatement(myHIXSql);
							rs		=	pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									myHIXNoteType = myHIXNoteType+'|'+rs.getString(1)+'|';
								}
							}	
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally{
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
			//IN067607 Ends
			
			if (appl_task_id.equals("PAT_MEDICAL_REPORT")||function_id.equals("TASK_LIST"))
			{
				disableFilterBy = "disabled";
			}else{
				disableFilterBy="";
			}
			if(function_id.equals("TASK_LIST"))
			{
				sel_filterBy = "selected";
			}
			else
			{
				sel_filterBy = "";	
			}
			
			//appl_task_id="PAT_MEDICAL_REPORT";
			autho_doct_name			=	checkForNull(request.getParameter("authority"));
			strModifiedBy			=	checkForNull(request.getParameter("modified_by"));
			Sex			=	checkForNull(request.getParameter("Sex"));
			Dob			=	checkForNull(request.getParameter("Dob"));
			module_id			=	checkForNull(request.getParameter("module_id"));
			location_code			=	checkForNull(request.getParameter("location_code"));
			speciality_name			=	checkForNull(request.getParameter("speciality_name"));
			speciality_code1			=	checkForNull(request.getParameter("speciality_code"));


			if(encounter_id == null || encounter_id.equals("") )
			{
				encounter_id = "0";
				patient_class = "XT";
			}
			
			if( !operation_mode.equals("Update") && !operation_mode.equals("ModifySection") && !operation_mode.equals("ModifyAddendum"))
			{
					if(function_id.equals("SPCL_NOTE")){
						p_note_type		=	request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
						//accession_num	=	checkForNull(request.getParameter("accession_num"));
					}else{
						p_note_type		=	request.getParameter("p_note_type") == null ? "" : request.getParameter("p_note_type");	
					}
			}
			
			//crf 0064 starts here
			
			if(!function_id.equals("SPCL_NOTE") && !function_id.equals("TASK_LIST")){
				if(ql_ref.equals("") && !default_yn.equals("N"))
				{
					//default_sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and DEFAULT_YN = 'Y' and OPTION_ID=? and rownum=1";
					//default_sql = "SELECT 1 existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.default_yn = 'Y' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y' AND ROWNUM = 1";
					default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";//changed for regression issue DineshT 2009-12-29


					stmtsql = con.prepareStatement(default_sql);
				
					stmtsql.setString(1,loggedUser);
					stmtsql.setString(2,resp_id);
					stmtsql.setString(3,appl_task_id);
					stmtsql.setString(4,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					default_query.append("select A.QUICK_LINK_REF from ");
					if(Existance_Count>0)//changed for regression issue DineshT 2009-12-29
						default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
					else
						default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
					default_query.append(" and LINK_TYPE = 'F' and DEFAULT_YN = 'Y' and OPTION_ID=? ");
					
					stmtsql = con.prepareStatement(default_query.toString());
					if(Existance_Count >0)//changed for regression issue DineshT 2009-12-29
						stmtsql.setString(1,loggedUser);
					else
						stmtsql.setString(1,resp_id);

						stmtsql.setString(2,appl_task_id);

					rs = stmtsql.executeQuery();

					if(rs.next())
					{
						ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
					}

					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();
				}
			}
			
			
			if(!ql_ref.equals(""))
			{
				sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID AND OPTION_ID=?) COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,appl_task_id);
				stmtsql.setString(2,ql_ref);
				rs = stmtsql.executeQuery();

				while(rs.next())
				{
					column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
					column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
					value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
					actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
					date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
					date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
					date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
					relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");

					if(value_type.equals("A"))
						final_value = actual_value;
					else
					{
						if(column_id.equals("DATE_TIME"))
						{
							if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
							{
								final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
							}
							else
							{
								final_value = "";
							}
						}
						else
							final_value = relative_value;
					}

					map.put(column_id,final_value);

				}
				if(stmtsql != null) stmtsql.close();
				if(rs != null) rs.close();
	/*		}

			if(!ql_ref.equals(""))
			{*/

				field_desc = (String) map.get("FILTER_BY") == null ? "" : (String) map.get("FILTER_BY");
				if(!field_desc.equals("")){
					filter_by_ql = field_desc;
					filter_by_ql_tmp=filter_by_ql;
				}

				field_desc = (String) map.get("SPECIALITY") == null ? "" : (String) map.get("SPECIALITY");
				if(!field_desc.equals(""))
					speciality_ql = field_desc;
				if(speciality_ql.equals("CURR_PAT_SPLTY_CODE"))
				{
					speciality_ql=speciality_code1;
				}

				field_desc = (String) map.get("NOTE_TYPE") == null ? "" : (String) map.get("NOTE_TYPE");
				if(!field_desc.equals(""))
					note_type_ql = field_desc;

				field_desc = (String) map.get("MEDANC_SERV") == null ? "" : (String) map.get("MEDANC_SERV");
				if(!field_desc.equals(""))
					medanc_serv_ql = field_desc;

				field_desc = (String) map.get("PERFORMED_BY") == null ? "" : (String) map.get("PERFORMED_BY");
				if(!field_desc.equals(""))
					performed_by_ql = field_desc;
				
				if(performed_by_ql.equals("LOGGED_IN_PRACT"))
				{
					performed_by_ql=practitioner_id;
				}

				field_desc = (String) map.get("DATE_TIME") == null ? "" : (String) map.get("DATE_TIME");

				
				

				String currDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
				int noOfdays = 0;
				if(!field_desc.equals(""))
				{
					strToken = new StringTokenizer(field_desc,"|");
					if(strToken.hasMoreTokens())
					{
						date_ind = strToken.nextToken();
						date_val = strToken.nextToken();
						date_unit = strToken.nextToken();
						date_ref = strToken.nextToken();
					}
					noOfdays = Integer.parseInt(date_val);
					/*if(noOfdays<=Integer.parseInt(days_backdate)){
					if(date_ind.equals("B"))
						sys_date_time = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					//else if(date_ind.equals("A"))
						//sys_date_time = //com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					}*/			
					temp=Integer.parseInt(days_backdate);
					parameterDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,temp,"d");
					quicklinkDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);					
					if(com.ehis.util.DateUtils.isAfter(quicklinkDate,parameterDate, "DMYHM", locale))
					{					
					if(date_ind.equals("B"))
						{
						sys_date_time =quicklinkDate ;
						}
					}			
				}			
				
				if(!filter_by_ql.equals(""))
				{
					
					if (filter_by_ql.equals("R")){		

							//IN061988 starts
							//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  
							if("PH_NOTES".equals(appl_task_id))
							{
								spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  	
							}
							else
							{
								spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  	
							}
							//IN061988 ends
					   
					   }else if (filter_by_ql.equals("P") ){			
						   
						   //IN061988 starts
						  //spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  else
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  //IN061988 ends
					   }
					   else if (filter_by_ql.equals("S")){	
						   
						   if(speciality_ql.equals("")){
						   
									String spltySql = "SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
									
									stmtsql = con.prepareStatement(spltySql.toString());	
									stmtsql.setString(1,practitioner_id);
									rs = stmtsql.executeQuery();
									if(rs.next()){
										speciality_ql = rs.getString("PRIMARY_SPECIALITY_CODE");
									
									}

									if(rs == null) rs.close();
									if(stmtsql == null) stmtsql.close();
						   
						   }
									
						  //IN061988 starts
						  //spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resource_type=? ");
						  }
						  else
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
						  }
						  //IN061988 ends
						  
						  if (!(speciality_ql.equals("")))
							  spl_ql_qry.append(" and a.RESOURCE_CODE = ? ");
						  //else
							  spl_ql_qry.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)  ");
						  //IN061988 starts
						  //spl_ql_qry.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append(" and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  else
						  {
							spl_ql_qry.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  //IN061988 ends
						 
					   }					 

					  
						 if(!note_type_ql.equals(""))
								spl_ql_qry.append(" 	and c.note_type = ? ");
						 //else //IN052757
								spl_ql_qry.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");						
					   
				
					
					   stmtsql = con.prepareStatement(spl_ql_qry.toString());				   

						if (filter_by_ql.equals("R")) 
						{
							stmtsql.setString(1,resp_id);
							stmtsql.setString(2,locale);
							stmtsql.setString(3,patient_class);//
							if(!note_type_ql.equals("")){
								stmtsql.setString(4,note_type_ql);
								stmtsql.setString(5,appl_task_id);
							}else{
								stmtsql.setString(4,appl_task_id);
							}

						}
						 else if (filter_by_ql.equals("P"))
						{
							stmtsql.setString(1,"P");
							stmtsql.setString(2,practitioner_id);
							stmtsql.setString(3,locale);
							stmtsql.setString(4,patient_class);
							stmtsql.setString(5,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(6,note_type_ql);
								stmtsql.setString(7,appl_task_id);
							}else{
								stmtsql.setString(6,appl_task_id);
							}
								

						}									
						 else if (filter_by_ql.equals("S"))
						 {
							stmtsql.setString(1,"S");
						   if (!speciality_ql.equals(""))
						   {
							stmtsql.setString(2,speciality_ql);
							stmtsql.setString(3,practitioner_id);
							stmtsql.setString(4,practitioner_id);
							stmtsql.setString(5,locale);
							stmtsql.setString(6,patient_class);
							stmtsql.setString(7,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(8,note_type_ql);
								stmtsql.setString(9,appl_task_id);
							}else{
								stmtsql.setString(8,appl_task_id);
							}
						   }
						   else
						   {
							stmtsql.setString(2,practitioner_id);
							stmtsql.setString(3,practitioner_id);
							stmtsql.setString(4,locale);
							stmtsql.setString(5,patient_class);
							stmtsql.setString(6,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(7,note_type_ql);
								stmtsql.setString(8,appl_task_id);
						   }else{
								stmtsql.setString(7,appl_task_id);							
						   }
						   }
						}

					
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");					
					}else{
						Existance_Count = 0;
					}
					
					if(Existance_Count==1 && !ql_ref.equals(""))
					{
						ql_flag="Y";
					}
					else
					{
						filter_by_ql="";
						speciality_ql="";
						note_type_ql="";
						medanc_serv_ql="";
						performed_by_ql="";
						filter_by_ql_tmp="P";
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					
				
				}
				else
				{				
					//IN061988 starts
					//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					if("PH_NOTES".equals(appl_task_id))
					{
						spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d  where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					}
					else
					{
						spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					}
					//IN061988 ends
					if(!note_type_ql.equals(""))
						spl_ql_qry.append(" and c.note_type = ? ");
					else
						spl_ql_qry.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

						 stmtsql = con.prepareStatement(spl_ql_qry.toString());
						 
						stmtsql.setString(1,practitioner_id);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,patient_class);
						stmtsql.setString(4,resp_id);
					if(!note_type_ql.equals(""))
						stmtsql.setString(5,note_type_ql);
					else
						stmtsql.setString(5,appl_task_id);

					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}

					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					if(Existance_Count !=1)
					{				
						spl_ql_qry.delete(0,spl_ql_qry.length());
						//IN061988 starts
						//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						if("PH_NOTES".equals(appl_task_id))
						{
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						}
						else
						{
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						}
						//IN061988 ends

						 if(!note_type_ql.equals(""))
								spl_ql_qry.append(" 	and c.note_type = ? ");
						 else
								spl_ql_qry.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

							stmtsql = con.prepareStatement(spl_ql_qry.toString());
							stmtsql.setString(1,resp_id);
							stmtsql.setString(2,locale);
							stmtsql.setString(3,patient_class);//
						if(!note_type_ql.equals(""))
							stmtsql.setString(4,note_type_ql);
						else
							stmtsql.setString(4,appl_task_id);//

						rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");				
					}
					


				}

				if(Existance_Count==1 && !ql_ref.equals(""))
					{
						ql_flag="Y";
					}
					else
					{
						filter_by_ql="";
						speciality_ql="";
						note_type_ql="";
						medanc_serv_ql="";
						performed_by_ql="";
						filter_by_ql_tmp="";
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
			}			
				
				if(ql_flag.equals("Y"))
					{
					
						
						String serv_ql_qry= "select AM_GET_DESC.AM_SERVICE(nvl(?,''),?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						stmtsql = con.prepareStatement(serv_ql_qry);
						stmtsql.setString(1,medanc_serv_ql);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,performed_by_ql);
						stmtsql.setString(4,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							serv_name_ql = rs.getString("service_name")==null?"":rs.getString("service_name");
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,note_type_ql);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{
							sec_count = rs.getString("count");
							
						}
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();


						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, note_type_ql);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
		
						
						if(!privilege_type.equals("1") && !note_type_ql.equals(""))
						{
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else{
								disflag  = "";
						}
						
						String note_group_query2 ="select note_group_id from ca_note_type where note_type = ?";
						pstmt		=	con.prepareStatement(note_group_query2);
						pstmt.setString(1,note_type_ql);
						ResultSet rs1			=	pstmt.executeQuery();
						if(rs1.next()){
							note_group_id = rs1.getString("note_group_id");						
						}
						if(rs1 != null)rs1.close();
						if(pstmt != null)pstmt.close();

						String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

					pstmt = con.prepareStatement(query_note_group_props);
					pstmt.setString(1, note_group_id);
					rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
						role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
						role_based_access_yn=role_based_access_yn;
						pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(pre_cond_for_rec.equals("D"))
					{
						if(patient_class.equals("IP") || patient_class.equals("DC"))
						{
							String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
							pstmt = con.prepareStatement(query_ip_dis_advice);
							pstmt.setString(1, facility_id);
							pstmt.setString(2, encounter_id);
							rs = pstmt.executeQuery();						
							if(!rs.next())
							{
								error_flag = true;
								msgfrom = "DIS_ADV_NOT_EXISTS";
								p_note_type = "";
								note_type_ql="";
								note_group_id="";
								performed_by_ql  =  "";
								perf_pract_name_ql = "";
								disflag  = "";
								filter_by_ql="P";
								speciality_ql="";							
								medanc_serv_ql="";								
								filter_by_ql_tmp="P";								
								serv_name_ql = "";		
							}
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}
					}
					else if(pre_cond_for_rec.equals("E"))
					{
						
						String install_yn = "";
						String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
						pstmt = con.prepareStatement(query_install_yn);
						rs = pstmt.executeQuery();
						if(rs.next())
							install_yn = checkForNull(rs.getString("INSTALL_YN"));						
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						String query_chk_deceased = "";
						if(install_yn.equals("Y"))
							query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
						else
							query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

						pstmt = con.prepareStatement(query_chk_deceased);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						
						if(!rs.next())
						{
							error_flag = true;
							msgfrom = "DECEASED_ONLY";
							p_note_type = "";
							note_type_ql="";
							note_group_id="";
							performed_by_ql  =  "";
							perf_pract_name_ql = "";
							disflag  = "";
							filter_by_ql="P";
							speciality_ql="";							
							medanc_serv_ql="";								
							filter_by_ql_tmp="P";								
							serv_name_ql = "";		
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}

					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					
					if(!error_flag)
					{
						if(!no_of_rec_per_enc.equals(""))
						{
							try
							{
								String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
								pstmt = con.prepareStatement(query);
								pstmt.setString(1, encounter_id);
								pstmt.setString(2, facility_id);
								pstmt.setString(3, note_type_ql);
								rs = pstmt.executeQuery();
								if(rs.next())
									record_cnt_for_enc =  rs.getInt(1);

								if(record_cnt_for_enc >=  Integer.parseInt(no_of_rec_per_enc))
								{
									msgfrom="MAX_NOTES_LIMIT";
									search_screen_activated = true;
									p_note_type = "";
									note_type_ql="";
									note_group_id="";
									performed_by_ql  =  "";
									perf_pract_name_ql = "";
									disflag  = "";
									filter_by_ql="P";
									speciality_ql="";							
									medanc_serv_ql="";								
									filter_by_ql_tmp="P";								
									serv_name_ql = "";		
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();							
							}
							catch(Exception e)
							{
								e.printStackTrace();							
							}
						}
					}


					}


			}else if(!p_note_type.equals("")&&!function_id.equals("TASK_LIST"))
			{
				
						
						String serv_ql_qry= "select AM_GET_DESC.AM_SERVICE(nvl(?,''),?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						
						stmtsql = con.prepareStatement(serv_ql_qry);
						stmtsql.setString(1,medanc_serv_ql);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,performed_by_ql);
						stmtsql.setString(4,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							serv_name_ql = rs.getString("service_name")==null?"":rs.getString("service_name");
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,p_note_type);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{
							sec_count = rs.getString("count");
							
						}
						
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();


						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, p_note_type);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							//event_class,serv_facl_spec_yn,privilege_type,note_type_desc
							//event_type_caption,security_level,event_date_caption,event_perf_by_caption,security_level,event_date_caption,event_perf_by_caption,event_title_caption,event_title_desc,event_auth_by_caption,event_status_caption,note_group_id,doc_linked_note_yn

							
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
		
						
						if(!privilege_type.equals("1") && !p_note_type.equals("") && performed_by_ql.equals(""))
						{
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else if(!performed_by_ql.equals("")){
							disflag  = "disabled";
						}else{
								disflag  = "";
						}					
						
						String note_group_query2 ="select note_group_id from ca_note_type where note_type = ?";
						pstmt		=	con.prepareStatement(note_group_query2);
							
						pstmt.setString(1,note_type_ql);
						ResultSet rs1			=	pstmt.executeQuery();
						if(rs1.next()){
							note_group_id = rs1.getString("note_group_id");						
						}
						if(rs1 != null)rs1.close();
						if(pstmt != null)pstmt.close();

						String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

					pstmt = con.prepareStatement(query_note_group_props);
					pstmt.setString(1, note_group_id);
					rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
						role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
						role_based_access_yn=role_based_access_yn;
						pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(pre_cond_for_rec.equals("D"))
					{
						if(patient_class.equals("IP") || patient_class.equals("DC"))
						{
							String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
							pstmt = con.prepareStatement(query_ip_dis_advice);
							pstmt.setString(1, facility_id);
							pstmt.setString(2, encounter_id);
							rs = pstmt.executeQuery();						
							if(!rs.next())
							{
								error_flag = true;
								msgfrom = "DIS_ADV_NOT_EXISTS";
								//p_note_type = "";
								note_type_ql="";
								note_group_id="";
								performed_by_ql  =  "";
								//perf_pract_name_ql = "";
								disflag  = "";
								filter_by_ql="P";
								speciality_ql="";							
								medanc_serv_ql="";								
								filter_by_ql_tmp="P";								
								serv_name_ql = "";		
								if(!appl_task_id.equals("PROGRESS_NOTES"))
								{
									p_note_type = "";
									perf_pract_name_ql = "";
								}


							}
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}
					}
					else if(pre_cond_for_rec.equals("E"))
					{
						
						String install_yn = "";
						String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
						pstmt = con.prepareStatement(query_install_yn);
						rs = pstmt.executeQuery();
						if(rs.next())
							install_yn = checkForNull(rs.getString("INSTALL_YN"));						
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						String query_chk_deceased = "";
						if(install_yn.equals("Y"))
							query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
						else
							query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

						pstmt = con.prepareStatement(query_chk_deceased);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						
						if(!rs.next())
						{
							error_flag = true;
							msgfrom = "DECEASED_ONLY";
							
							if(!appl_task_id.equals("PROGRESS_NOTES"))
							{
							p_note_type = "";
								perf_pract_name_ql = "";
							}
							
							note_type_ql="";
							note_group_id="";
							performed_by_ql  =  "";
							disflag  = "";
							filter_by_ql="P";
							speciality_ql="";							
							medanc_serv_ql="";								
							filter_by_ql_tmp="P";								
							serv_name_ql = "";		
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}

					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					
					if(!error_flag)
					{
						
						if(!no_of_rec_per_enc.equals(""))
						{
							try
							{
								String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
								pstmt = con.prepareStatement(query);
								pstmt.setString(1, encounter_id);
								pstmt.setString(2, facility_id);
								pstmt.setString(3, note_type_ql);
								rs = pstmt.executeQuery();
								if(rs.next())
									record_cnt_for_enc =  rs.getInt(1);
								if (!no_of_rec_per_enc.equals(""))
								{
									if(record_cnt_for_enc >=  Integer.parseInt(no_of_rec_per_enc))
									{
										msgfrom="MAX_NOTES_LIMIT";
										search_screen_activated = true;
										p_note_type = "";
										note_type_ql="";
										note_group_id="";
										performed_by_ql  =  "";
										perf_pract_name_ql = "";
										disflag  = "";
										filter_by_ql="P";
										speciality_ql="";							
										medanc_serv_ql="";								
										filter_by_ql_tmp="P";								
										serv_name_ql = "";		
									}
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();							
							}
							catch(Exception e)
							{
								e.printStackTrace();
								
							}
						}
					  }
					}
					else
					{	
						
						p_note_type = note_type;
						performed_by_ql=performedId;
						
						//new addition
						
						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, p_note_type);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							//event_class,serv_facl_spec_yn,privilege_type,note_type_desc
							//event_type_caption,security_level,event_date_caption,event_perf_by_caption,security_level,event_date_caption,event_perf_by_caption,event_title_caption,event_title_desc,event_auth_by_caption,event_status_caption,note_group_id,doc_linked_note_yn

							
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
						// ends here
						//49237 Start.
						if(!privilege_type.equals("1") && !p_note_type.equals("") && performed_by_ql.equals(""))
						{							
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else if(!performed_by_ql.equals("")){							
							disflag  = "disabled";
						}else{
								disflag  = "";
						}
						//49237 End.
						String query_tasklst = "select AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						
						stmtsql = con.prepareStatement(query_tasklst);
						stmtsql.setString(1,performedId);
						stmtsql.setString(2,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
						
						

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,p_note_type);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{						
							sec_count = rs.getString("count");
							
						}
						
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
					
						
					}


			//crf 0064 ends here
					if(appl_task_id.equals("RD_CLINICAL_NOTES")){						
						if(!privilege_type.equals("1")){
							disflag  = "disabled";
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
						}else{
							disflag  = "";	
							performed_by_ql  =  "";
							perf_pract_name_ql = "";
						}
					}
			if(!patient_class.equals("XT") )
			{
				//strDetailsQry	=	"select to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,(select facility_name from sm_facility_param where facility_id=a.facility_id) facility_name, (select short_desc from am_service where service_code=a. SERVICE_CODE )  specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ATTEND_PRACTITIONER_ID) attending_practitioner,service_code from pr_encounter a where facility_id = ? and encounter_id = ? ";
				  strDetailsQry	="select  to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,1)  attending_practitioner,service_code,AM_GET_DESC.AM_SPECIALITY(?,?,'2') speciality_name from    pr_encounter a where   facility_id = ? and     encounter_id = ?";
				try
				{
					ptPatLine	=	con.prepareStatement(strDetailsQry);

					ptPatLine.setString	(	1,	locale	);
					ptPatLine.setString	(	2,	locale	);
					ptPatLine.setString	(	3,	locale	);
					ptPatLine.setString	(	4,	speciality_code1 );
					ptPatLine.setString	(	5,	locale	);
					ptPatLine.setString	(	6,	facility_id	);
					ptPatLine.setString	(	7,	encounter_id);

					stPatLine		=	ptPatLine.executeQuery();

					if(stPatLine.next())
					{
						service_name				=	stPatLine.getString("service_name");
						speciality_code				=	stPatLine.getString("service_code");
						discharge_date_time				=	stPatLine.getString("DISCHARGE_DATE_TIME");
						attending_practitioner		=	stPatLine.getString("attending_practitioner");
						attending_practitioner_temp	= java.net.URLEncoder.encode(attending_practitioner,"UTF-8");//IN041881
						speciality_name		=	stPatLine.getString("speciality_name");
						visit_adm_date		=	stPatLine.getString("visit_adm_date");
					}
				

							// added for CRF 499 unlinked issue starts
			
		
				if(serv_facl_spec_yn.equals("Y") )
				{

					query_section_details_serv = " select ca_note_type_by_serv.service_code from ca_note_type_by_serv, AM_FACILITY_SERVICE_VW where ca_note_type_by_serv.facility_id=AM_FACILITY_SERVICE_VW.operating_facility_id and ca_note_type_by_serv.note_type = ?  and ca_note_type_by_serv.service_code=AM_FACILITY_SERVICE_VW.SERVICE_CODE AND ca_note_type_by_serv.SERVICE_CODE = ? ";

					pstmt		=	con.prepareStatement(query_section_details_serv);
					
					pstmt.setString(1, p_note_type);
					pstmt.setString(2, speciality_code);
					rs	=	pstmt.executeQuery();

				if(rs.next())
					 service_code = rs.getString(1);

				if(service_code == null) service_code ="";

				if(service_code.equals(""))
				{
					 speciality_code ="";
					 service_name = "" ;

				}



				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

						
				}

			

		// added for CRF 499 unlinked issue ends





					/*if(ql_flag.equals("Y"))
					{
						if(!service_name.equals(serv_name_ql))
						{
							service_name="";	
						}

					}*/

					if(medanc_serv_ql.equals("") && (!note_type_ql.equals("") || !p_note_type.equals("")))
					{
						medanc_serv_ql = speciality_code;
						serv_name_ql = service_name;				
					}
				
				}
				catch (Exception eeee)
				{
					eeee.printStackTrace() ;
				}
				finally
				{
					if ( stPatLine!= null) stPatLine.close();
					if ( ptPatLine!= null) ptPatLine.close();
				}
			}		
			boolean chk_flag = com.ehis.util.DateUtils.isBefore(sys_date_time, visit_adm_date, "DMYHM", locale);
			if(chk_flag)
			{
				sys_date_time = visit_adm_date;
			}else{
				sys_date_time = sys_date_time;
			}	
			%>
	<center>
	<form name="RecClinicalNotesHeaderForm" id="RecClinicalNotesHeaderForm" >
	<table border="0" cellpadding = 4 cellspacing="0" width="100%" name="detailTable" id="detailTable">
	<%
			
			if( operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum"))
			{
				String sel_note_group = "";
				accession_num	=	checkForNull(request.getParameter("accession_num"));
				note_type			=	checkForNull(request.getParameter("note_type"));

				//query_header_details.append("select event_type_caption, note_type, note_type_desc, service_code, short_desc service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, short_name performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, decode( event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified') event_status from ca_encntr_note_vw where facility_id = ? and accession_num = ? ");
				query_header_details.append("select event_type_caption, note_type, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, event_status, (select note_group_id from ca_note_type b where b.note_type = a.note_type ) note_group_id	from 	ca_encntr_note A where 	/*facility_id = ? and 	*/accession_num = ?");
				try
				{
					pstmt	=	con.prepareStatement(query_header_details.toString());
					pstmt.setString( 1,	locale	);
					pstmt.setString( 2,	locale	);
					pstmt.setString( 3,	locale	);
					//pstmt.setString( 4,	facility_id		);
					pstmt.setString( 4,	accession_num	);
					
					rs	=	pstmt.executeQuery();
					if(rs.next())
					{
						event_type_caption				=	rs.getString("event_type_caption");
						note_type						=	rs.getString("note_type");
						note_type_desc					=	rs.getString("note_type_desc");
						service_code					=	rs.getString("service_code");
						service_desc					=	rs.getString("service_desc");
						event_class						=	rs.getString("event_class");
						security_level					=	rs.getString("security_level");
						event_date_caption				=	rs.getString("event_date_caption");
						event_date_time					=	rs.getString("event_date_time");
						event_perf_by_caption			=	rs.getString("event_perf_by_caption");
						performed_by_id					=	rs.getString("performed_by_id");
						performed_by_name				=	rs.getString("performed_by_name");
						event_title_caption				=	rs.getString("event_title_caption");
						event_title_desc				=	rs.getString("event_title_desc");
						event_auth_by_caption			=	rs.getString("event_auth_by_caption");
						event_status_caption			=	rs.getString("event_status_caption");
						event_status_code				=	rs.getString("event_status");					
						sel_note_group				=	rs.getString("note_group_id");					
						//event_status					=	rs.getString("event_status");				
						
						event_date_time					=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);

						if(event_status_code.equals("1"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if (event_status_code.equals("2"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						else if (event_status_code.equals("3"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						else if (event_status_code.equals("4"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						else if (event_status_code.equals("5"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");


						if(event_title_desc==null)		
							event_title_desc		=	"";
						if(event_type_caption==null)	
							event_type_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteTypes.label","ca_labels");
						if(event_date_caption==null)	
							event_date_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
						if(event_perf_by_caption==null)	
							event_perf_by_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels") ;
						if(event_title_caption==null)	
							event_title_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteTitle.label","ca_labels");
						if(event_auth_by_caption==null)	
							event_auth_by_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.authorizedby.label","common_labels");	
						if(event_status_caption==null)	
							event_status_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");		 //"Note Status";
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					//IN034224,starts Addendum
					accession_num	=	checkForNull(request.getParameter("accession_num"));			
					
					if(!accession_num.equals(""))
					{
						//Connection			conAddendum			=	null;
						PreparedStatement	pstmtAddendum		=	null;
						ResultSet			rsAddendum			=	null;
						
						try
						{
							//conAddendum				=	ConnectionManager.getConnection(request);//IN033677
							//pstmtAddendum			=	conAddendum.prepareStatement("SELECT SRL_NO FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
							pstmtAddendum			=	con.prepareStatement("SELECT SRL_NO FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881//IN033677
							pstmtAddendum.setString(1, accession_num);
							
							rsAddendum				=	pstmtAddendum.executeQuery();
													
							if(rsAddendum.next())
							{
								srl_no	=rsAddendum.getString(1);
							}
						}
						catch(Exception e)
						{
							//out.println("Exception in RecClinicalNotesHeader.jsp,1400=>"+e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
						}
						finally
						{			
							if(rsAddendum!=null) rsAddendum.close();
							if(pstmtAddendum!=null)pstmtAddendum.close();
							//if(conAddendum!=null) ConnectionManager.returnConnection(conAddendum,request);//IN033677
						}
					}
					//IN034224,ends Addendum

					String query_privilege_type = "select privilege_type,SERV_FACL_SPEC_YN from ca_note_type_for_resp_view where resp_id = ? and note_type = ? ";

					pstmt		=	con.prepareStatement(query_privilege_type);

					pstmt.setString( 1,	resp_id.trim());
					pstmt.setString( 2,	note_type.trim());

					rs			=	pstmt.executeQuery();

					if(rs.next())
					{
						privilege_type	=	rs.getString("privilege_type");
						serv_facl_spec_yn = rs.getString("serv_facl_spec_yn");
						
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
		%>
			<tr>
				<td class="label"  width="20%"><%=event_type_caption%></td>
				<td class="DATA" width="30%"><%=note_type_desc%><input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
							<input type="hidden" name="note_group" id="note_group" value="<%=sel_note_group%>"></td>
				<td class="label" width="20%"><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
				<td class="DATA" width="30%" colspan='2'>
				
				<%if(operation_mode.equals("Update"))
				{
					%>
					
						<input type ="text" name ="serv_disp" readonly  value = "<%=service_desc%>">&nbsp;
						<input type="button" value="?" class="button" 		onClick="callConditionLookupServ('<%=serv_facl_spec_yn%>')" name='search_btn_serv' >
						<input type ="hidden" name ="service_code" value = '<%=service_code%>'>

				<%}else{%>
					<%=service_desc%>
					<input type ="hidden" name ="serv_disp" readonly  value = <%=service_desc%>>
					<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
				<%}%>
				</td>
			</tr>
			<tr>
				<td class="label"  width="25%"><%=event_date_caption%></td>
				<td class="DATA" width="25%"><%=event_date_time%><input type="hidden" name="event_date_time" id="event_date_time"  value="<%=event_date_time%>"></td>
				<td class="label"  width="25%"><%=event_perf_by_caption%></td>
				<td class="DATA" width="25%" colspan='2'><%=performed_by_name%><input type="hidden" name="performed_by_id" id="performed_by_id" value="<%=performed_by_id%>"></td>
			</tr>
			<tr>
				<td class="label" width="25%"><%=event_title_caption%></td>
				<%
				//Note Title Editable for Note Modification time. Start.
				if( operation_mode.equals("Update")){%>
					<td class="DATA" width="25%"><input type="text" name="event_title_desc" id="event_title_desc" value="<%=event_title_desc%>" size="60" maxlength="200" onBlur="return makeValidString(this);">
				<%}else{%>
					<td class="DATA" width="25%"><%=event_title_desc%>
					<input type="hidden" name="event_title_desc" id="event_title_desc" size="40" maxlength="200" value='<%=event_title_desc%>'>
				<%}
				//Note Title Editable for Note Modification time. End.
				%>
				</td>
				<td class="label"  width="25%"><%=event_status_caption%></td>
				<td class="DATA" width="25%"><%=event_status%>
					<input type='hidden' name='event_status' id='event_status' value="<%=event_status%>">
					<!--<input type="hidden" name="event_status" id="event_status" value="<%=event_status%>"> -->
				</td>			
			</tr>
			<tr>
			<!-- IN071264 Starts -->
			<%if("Y".equals(auto_save_yn)){ %>
				<td class="label" width='25%'  style="display:" id="autosaveontd" name="autosaveontd">Auto Save</td>
				<td class="LABEL" width='25%' valign="center"  style="display:" id="autosaveon" name="autosaveon">
					<table border="0" cellpadding = 0 cellspacing="0" width="100%">
						<tr>
							<td width="20%"><img id="autoSaveImg" src="../../eCA/images/ToggleSwitchOff.png" onClick='autoSave(<%=auto_save_time%>)'/></td>
							<td class="LABEL" width="80%"><font color="red"><div id="timerlable" style="display:none">Time Remaining</div>&nbsp;<div id="timer" style="display:none"> 2:00</div></font></td>
						</tr>
					</table>
						
					<input type="hidden" id="autoSaveCheck" name="autoSaveCheck" id="autoSaveCheck" value="N"/>
				</td>
				<td  colspan = 3 ></td>
				
			<%} %>
			<!-- IN071264 Ends -->
				<td  colspan = 4 width='50%' class ='button' align="right">
				<input type=button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HideHeader.label","ca_labels")%>" class=button onclick="compressHeaderFrames();" name="hideHeaderButton" id="hideHeaderButton"></td>
			</tr>
			
				<%
					String secQuery = " select (select count(*)  from ca_note_section B where B.note_type = A.NOTE_TYPE ) sec_count,DOC_LINKED_NOTE_YN from CA_NOTE_TYPE_LANG_VW A where NOTE_TYPE = ? and LANGUAGE_ID = ? ";

					pstmt		=	con.prepareStatement(secQuery);

					pstmt.setString( 1,	note_type.trim());
					pstmt.setString( 2,	locale );

					rs			=	pstmt.executeQuery();

					if(rs.next())
					{
						sec_count_upd	=	rs.getString("sec_count");
						doc_linked_note_yn_upd = rs.getString("DOC_LINKED_NOTE_YN");
						
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if (doc_linked_note_yn_upd.equals("Y")){
						if(Integer.parseInt(sec_count_upd) == 0){

					%>
						<script>
				
							console.log(parent.content.workAreaFrame);
							setTimeout("loadFileUpload();",50);	
							function loadFileUpload()
							{
								
								top.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols="100%,0%,0%";

							top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&accession_num=<%=accession_num%>&called_from=NOTES_HEADER';

							top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&called_from=NOTES_HEADER';
							
												
							}
								
						</script>

		<%
					}
					else 
					{
		%>
			<script>
			console.log(parent.content.workAreaFrame);
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href='../../eCA/jsp/RecClinicalNotesToolbar.jsp?operation_mode=<%=operation_mode%>&doc_linked_note_yn=<%=doc_linked_note_yn%>&function_id=<%=function_id%>&appl_task_id=<%=appl_task_id%>';
			</script>

		<%

					}
					}
			}
			else
			{					
				
		%>
			<tr>
				<td class="LABEL"  id="td_filter_by" width='25%'><fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
				<td class ='fields' width='25%'>
				<select name="filter_by" id="filter_by" onChange = "javascript:fnDisplaySplty(this);return populateNoteType(this);"  <%=disableFilterBy%>>
				<%if (p_note_type.trim().equals("") || appl_task_id.equals("NOTIFIABLEFORM") ) {//IN050839	%>
					<% if(filter_by_ql_tmp.equals("R")) filter_by_sel="selected"; 
					   else filter_by_sel=""; 
					 %>
				<option value="R" <%=filter_by_sel%>><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
					<!-- <option value="NT"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option> -->
					<% if(filter_by_ql_tmp.equals("P")) filter_by_sel="selected"; else filter_by_sel=""; %>
					<option value="P" <%=filter_by_sel%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}" /></option>
					<% if(filter_by_ql_tmp.equals("S")) filter_by_sel="selected"; else filter_by_sel=""; %>
					<option value="S" <%=filter_by_sel%> ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
					<%
					}
					else
					{%><option value="N" selected ><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option><%}%>
				</select></td><!-- <img src="../../eCommon/images/mandatory.gif"></img> -->
				
				<%
				if(filter_by_ql_tmp.equals("S") && ql_flag.equals("Y"))
				{
					speciality_disp="display:";
				}
				else
				{
					speciality_disp ="display:none";
				}
					
				%>


				<td class ='LABEL' width='25%' id="td_lbl_splty" style="<%=speciality_disp%>"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
				<td class="fields"  width='25%' id="td_splty" colspan="2">
				<select name="speciality_list" id="speciality_list" onChange = "javascript:return populateNoteType(document.RecClinicalNotesHeaderForm.filter_by);"  style="<%=speciality_disp%>"><option value="">&nbsp;&nbsp;--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- &nbsp;&nbsp;</option>
				<%
						try
						{					
							splQuery = "select SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,'2') short_desc from am_speciality_lang_vw where language_id=? and SPECIALITY_CODE IN (select A.PRIMARY_SPECIALITY_CODE from AM_PRACTITIONER A where A.PRACTITIONER_ID = ? UNION  select B.SPECIALITY_CODE from AM_PRACT_SPECIALITIES B where B.PRACTITIONER_ID = ? and B.FACILITY_ID = ?) and eff_status = 'E' order by 2";					
							
							pstmt		=	con.prepareStatement(splQuery);		
							
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);						
							pstmt.setString(3,practitioner_id);						
							pstmt.setString(4,practitioner_id);
							pstmt.setString(5,facility_id);
							
							rs			=	pstmt.executeQuery();

							while(rs.next())
							{
								splty_code		=	rs.getString("speciality_code");
								splty_code_desc	=	rs.getString("short_desc");					
					%>
					
							<option value="<%=splty_code%>" <%=(splty_code.trim().equals(p_splty_code.trim())||splty_code.trim().equals(speciality_ql.trim()))?"selected":""%>  ><%=splty_code_desc%></option>
					<%}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}			
				%>
				</select>			
				 </td>

			</tr>
			<tr>
				<td class="LABEL" name="td_note_type" id="td_note_type"  width='25%'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
				<td class ='fields' width='25%'><select name="note_type" id="note_type" onChange = "return callNoteSectionRoutine()" <%=((function_id.equals("SPCL_NOTE")&&(!p_note_type.equals("")))||(function_id.equals("TASK_LIST"))?"disabled":"")%>>
				<option value="">&nbsp;&nbsp;&nbsp;---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- &nbsp;&nbsp;&nbsp;</option>
				<%
				try
				{
					/*
					query_header_details.append("Select note_type, replace(note_type_desc,'''','') note_type_desc from ca_note_type_for_resp_view where resp_id = ? and privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y'  ");

					if(!p_note_type.equals(""))
						query_header_details.append(" and note_type = ? ");
					else
						query_header_details.append(" AND NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

					query_header_details.append(" order by  2 "); */

					//

			/*		query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");

					if(!p_note_type.equals(""))
						query_header_details.append(" 	and c.note_type = ? ");
					else
						query_header_details.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");  */

					if((appl_task_id.equals("RD_CLINICAL_NOTES")&&!p_note_type.equals(""))||(function_id.equals("SPCL_NOTE")&&(!p_note_type.equals("")))) {
							query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");								
					}else{
							
						if (!appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							if(!filter_by_ql.equals("R")&&!filter_by_ql.equals(""))
							{
							
							sqlQuery.append("Select count(*) total from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE =?");
							
							if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
							{
							sqlQuery.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
							}
							else
							{
							sqlQuery.append(" AND a.RESOURCE_CODE = ?");
							}
							 sqlQuery.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) AND EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5')");
							
							pstmt		=	con.prepareStatement(sqlQuery.toString());

							if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count1++,filter_by_ql);
							}
							else if(filter_by_ql.equals(""))
							{
								pstmt.setString(count1++,"P");
							}
							if(filter_by_ql.equals("S"))
							{
								if(speciality_ql.equals(""))
								{
									pstmt.setString(count1++,practitioner_id);
									pstmt.setString(count1++,practitioner_id);
								}
								else
								{
									pstmt.setString(count1++,speciality_ql);
								}
							}
							else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count1++,practitioner_id);	
							}
											
							pstmt.setString(count1++,locale);
							pstmt.setString(count1++,patient_class);
							pstmt.setString(count1++,appl_task_id);
							pstmt.setString(count1++,resp_id);	

							rs			=	pstmt.executeQuery();

							if (rs.next())
								cntNote = rs.getInt("total");
															
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							}
							else if(filter_by_ql.equals(""))
							{
								sqlQuery.delete(0,sqlQuery.length());
								sqlQuery.append("Select count(*) total from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE ='P'");
								sqlQuery.append(" AND a.RESOURCE_CODE = ?");
								sqlQuery.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) AND EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5')");
								
								if(!note_type_ql.equals(""))
								sqlQuery.append(" and c.note_type = ? ");
							
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									sqlQuery.append(" and c.NOTE_GROUP_ID = ? ");

								}
							
								pstmt		=	con.prepareStatement(sqlQuery.toString());
								pstmt.setString(count1++,practitioner_id);
								pstmt.setString(count1++,locale);
								pstmt.setString(count1++,patient_class);
								pstmt.setString(count1++,appl_task_id);
								pstmt.setString(count1++,resp_id);
								if(!note_type_ql.equals(""))
									pstmt.setString(count1++,note_type_ql);
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{	
									pstmt.setString(count1++,note_group_req);
								}

								rs			=	pstmt.executeQuery();

								if (rs.next())
									cntNote = rs.getInt("total");
								
															
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();


							}

						}
							if (cntNote > 0) {				
								
								query_header_details.append("Select distinct a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE =? ");
								
								if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
								{
									query_header_details.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
								}
								else
								{
									query_header_details.append(" AND a.RESOURCE_CODE = ?");
								}
								
								 query_header_details.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' ) ");
							}else {
								if(!function_id.equals("TASK_LIST")){	out.println("<SCRIPT>document.RecClinicalNotesHeaderForm.filter_by.value = 'R'</SCRIPT>");}
								//IN061988 starts
								//query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	
								if("PH_NOTES".equals(appl_task_id))
								{
									query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
								}
								else
								{
									query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");				
								}
								//IN061988 ends
							}
												
					}
						if(!p_note_type.equals(""))
							query_header_details.append(" 	and c.note_type = ? ");
						else
							query_header_details.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");
						//IN037701 Starts
						if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
						{
							query_header_details.append(" 	AND EVENT_CLASS= ? ");
						}
						//IN037701 Ends
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
								query_header_details.append(" AND  (EXISTS (SELECT 1 FROM CA_PMR_FOR_PRACTITIONER WHERE NOTE_TYPE_ID=A.NOTE_TYPE AND PRACTITIONER_ID=? AND FACILITY_ID=? ) OR (EXISTS (SELECT 1 FROM  CA_PMR_FOR_SPECIALITY WHERE NOTE_TYPE_ID=A.NOTE_TYPE  AND FACILITY_ID=? AND SPECIALITY_CODE IN  (SELECT  PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?))))");
						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT")&&p_note_type.equals(""))
						{	
							query_header_details.append(" and c.NOTE_GROUP_ID = ? ");
						}

						query_header_details.append(" 	order by  2 ");
						
					
					pstmt		=	con.prepareStatement(query_header_details.toString());
											
				//	pstmt.setString(1,resp_id);
				/*
				if((!p_note_type.equals(""))) {
					
					pstmt.setString(count2++,resp_id);	
					pstmt.setString(count2++,locale);
					pstmt.setString(count2++,patient_class);
					
					if(!p_note_type.equals(""))
						pstmt.setString(count2++,p_note_type);
					else
						pstmt.setString(count2++,appl_task_id);
				
				}else */{
					if (cntNote > 0)
					{
							
							if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count2++,filter_by_ql);
							}
							else if(filter_by_ql.equals(""))
							{
								pstmt.setString(count2++,"P");
							}
							if(filter_by_ql.equals("S"))
							{
								
								if(speciality_ql.equals(""))
								{
									pstmt.setString(count2++,practitioner_id);
									pstmt.setString(count2++,practitioner_id);
								}
								else
								{
									pstmt.setString(count2++,speciality_ql);
								}
								
								
							}
							else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count2++,practitioner_id);	
							}
						
						//pstmt.setString(1,practitioner_id);
						pstmt.setString(count2++,locale);
						pstmt.setString(count2++,patient_class);
						pstmt.setString(count2++,resp_id);
						if(!p_note_type.equals(""))
							pstmt.setString(count2++,p_note_type);
						else
							pstmt.setString(count2++,appl_task_id);
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,practitioner_id);
						}
					}
					else
					{	
						pstmt.setString(count2++,resp_id);	
						pstmt.setString(count2++,locale);
						pstmt.setString(count2++,patient_class);
						if(!p_note_type.equals(""))
							pstmt.setString(count2++,p_note_type);
						else
							pstmt.setString(count2++,appl_task_id);
						//IN037701 Starts
						if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
						{
							//p_event_class_widget
							 pstmt.setString(count2++,p_event_class_widget);
						}
						//IN037701 Ends
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,practitioner_id);
						}
					}
						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
						{	
							pstmt.setString(count2++,note_group_req);
						}
				}
						
					
					rs			=	pstmt.executeQuery();

					while(rs.next())
					{
						note_type		=	rs.getString("note_type");
						note_type_desc	=	rs.getString("note_type_desc");		
						dflt_transcription_yn	=	rs.getString("dflt_transcription_yn");	

						if (note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim()))
						{
							NoteTypeflag = true;						 
						}
			%>
						<option value="<%=note_type%>" <%=(note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim()))?"selected":""%>  ><%=note_type_desc%></option>
			<%
						if((note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim())))
						{
							transcription_yn = dflt_transcription_yn;
						}
			}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}	

				/*if(!ql_ref.equals("")&&!note_type_ql.equals(""))
				{
					p_note_type =note_type_ql;
				}*/

				if(p_note_type.equals("") && !note_type_ql.equals(""))
				{
					p_note_type =note_type_ql;
				}
				
				if((!p_note_type.equals("") || !note_type_ql.equals("")) ){
					String note_group_query1 ="select note_group_id from ca_note_type where note_type = ?";
					pstmt		=	con.prepareStatement(note_group_query1);
					pstmt.setString(1,p_note_type);
					ResultSet rs1			=	pstmt.executeQuery();
					if(rs1.next()){
						note_group_id = rs1.getString("note_group_id");
						note_group_disable = "disabled";
					}
					if(rs1 != null)rs1.close();
					if(pstmt != null)pstmt.close();
				}
				if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
				{
					note_group_id =note_group_req;
					note_group_disable = "disabled";
				}

				%>
				</select><img src="../../eCommon/images/mandatory.gif"></img>
				</td>
				
				<td class="label" width='25%' >	<fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/>
				</td>
				<td class="fields" width='25%'>
					<select name="note_group" id="note_group" onchange="populateNoteTypesForGroup(this,'<%=patient_class%>','Header');" <%=note_group_disable%>>
						<option value="">----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
						<%
						try
						{
							String note_group = "";
							String note_group_desc = "";
							/*
							StringBuffer note_group_query = new StringBuffer(" Select note_group, note_group_desc from ca_note_group  where eff_status='E'  ");
							if(!p_note_type.equals(""))
								note_group_query.append(" and note_group =(select note_group_id from ca_note_type where note_type = ? ) ");
							else if (!appl_task_id.equals(""))
								note_group_query.append(" and APPL_TASK_ID=?  ");
							note_group_query.append("  order by 2"); */

							//										

							StringBuffer note_group_query = new StringBuffer(" 	Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = ? ");
							
							if((!p_note_type.equals("") || !note_type_ql.equals("")) &&ql_flag.equals("N"))					
								note_group_query.append(" and a.note_group =( select note_group_id from ca_note_type where note_type = ? ) ");
							else if (!appl_task_id.equals(""))
							{
								note_group_query.append("  and a.APPL_TASK_ID=?  ");
							

								if (cntNote > 0) {	
									note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where IB.RESOURCE_TYPE=? ");
									if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
									{
										note_group_query.append(" and IB.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
									}
									else
									{
										note_group_query.append(" AND ib.RESOURCE_CODE = ?");
									}
					
									
										note_group_query.append(" and ib.note_type_id=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1" );
								}else {															
									note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resp ib where ib.resp_id=? and ib.note_type=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1");
								}
								if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
									note_group_query.append(" AND  (EXISTS (SELECT 1 FROM CA_PMR_FOR_PRACTITIONER WHERE NOTE_TYPE_ID=iA.NOTE_TYPE AND PRACTITIONER_ID=? AND FACILITY_ID=? ) OR  (EXISTS (SELECT 1 FROM  CA_PMR_FOR_SPECIALITY WHERE NOTE_TYPE_ID=iA.NOTE_TYPE  AND FACILITY_ID=? AND SPECIALITY_CODE IN  (SELECT  PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?))))");
								
								note_group_query.append(")");
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									note_group_query.append("and  a.NOTE_GROUP = ?");
								}


								
							}
								note_group_query.append("  order by 2");									

							pstmt		=	con.prepareStatement(note_group_query.toString());		
							
							pstmt.setString(count++,locale);	
							if(!p_note_type.equals("")&&ql_flag.equals("N"))						
								pstmt.setString(count++,p_note_type);
							else if (!appl_task_id.equals(""))
							{
								pstmt.setString(count++, appl_task_id);
							
								if (cntNote > 0)
								{
									//new								
									if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
									{
										pstmt.setString(count++,filter_by_ql);
									}
									else if(filter_by_ql.equals(""))
									{
										pstmt.setString(count++,"P");
									}
									if(filter_by_ql.equals("S"))
									{
										
										if(speciality_ql.equals(""))
										{
											pstmt.setString(count++,practitioner_id);
											pstmt.setString(count++,practitioner_id);
										}
										else
										{
											pstmt.setString(count++,speciality_ql);
										}
								
																		
									}
									else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
									{
										pstmt.setString(count++,practitioner_id);	
									}

								 
									//new
									//pstmt.setString(3,practitioner_id);
								}
								else
								{
									pstmt.setString(count++,resp_id);			
								}
								if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
								{
									 pstmt.setString(count++,practitioner_id);
									 pstmt.setString(count++,facility_id);
									 pstmt.setString(count++,facility_id);
									 pstmt.setString(count++,practitioner_id);
									 pstmt.setString(count++,practitioner_id);
								}
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									pstmt.setString(count++,note_group_req);
								}

							}						
							rs			=	pstmt.executeQuery();
						
							while(rs.next())
							{
								note_group		=	rs.getString("note_group");
								note_group_desc	=	rs.getString("note_group_desc");					
					%>
								<option value="<%=note_group%>" <%if(!note_group_id.equals("") && note_group_id.equals(note_group)){%>selected <%}%>><%=note_group_desc%></option>				
						<%
							}

							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
							
						}			
						
						%>
					</select>
				</td> </tr>
				<tr>
    <td class="LABEL" width='25%' id="td_service_code">
        <fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/>
    </td>
    <td class="fields" width='25%'>
        <input type="text" name="serv_disp" value="<%if(NoteTypeflag){%><%=serv_name_ql%><%}%>"  >
        <input type="button" value="?" class="button" onClick="callConditionLookupServ('<%=serv_facl_spec_yn%>')" name='search_btn_serv'>
        <input type="hidden" name="service_code" value="<%if(NoteTypeflag){%><%=medanc_serv_ql%><%}%>">
        <img src="../../eCommon/images/mandatory.gif"></img>
    </td>
    <td class="LABEL" width='25%' id="td_event_date_time" name="td_event_date_time">
        <fmt:message key="Common.datetime.label" bundle="${common_labels}"/>
    </td>
    <% if(p_date_time != null && !p_date_time.equals("")) { %>
        <td class="fields" width='25%'>
            <input type="text" name="event_date_time" id="event_date_time" value="<%=p_date_time%>" size="16" maxlength="16">
    <% } else { %>
        <td class="fields" width='25%'>
            <input type="text" name="event_date_time" id="event_date_time" value="<%=sys_date_time%>" size="16" maxlength="16" 
                onBlur='return checkIsValidDate(this,"<%=visit_adm_date%>","<%=days_backdate%>","<%=sys_date_time%>","DMYHM","<%=locale%>")'>
    <% } %>
        <button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;width: 16px; height: 16px;" onclick='showCalendarValidateForRecTime("event_date_time")'><img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto;"></button><img src="../../eCommon/images/mandatory.gif"></img>
    </td>
</tr>
<tr>	
				<td class="LABEL" width='25%' id="td_performed_by_id" name="td_performed_by_id"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
				
				<td class="fields" width='25%'><input type ="text" name ="performed_by_phy_name"  onBlur="javascript:callConditionLookup();" value="<%if(NoteTypeflag){%><%=perf_pract_name_ql%><%}%>" <%=disflag%>><input type="button" value="?" class="button" onClick="callConditionLookup()" name='search_btn' id='search_btn' <%=disflag%>>
				<input type="hidden"		name="performed_by_id" id="performed_by_id"					value="<%if(NoteTypeflag){%><%=performed_by_ql%><%}%>">
				<img src="../../eCommon/images/mandatory.gif"></img></td>
				<td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td  class="LABEL" width='25%' id="td_event_title_desc" name="td_event_title_desc"><fmt:message key="eCA.NoteTitle.label" bundle="${ca_labels}"/></td>
				<td  class="fields" width='25%'><input type="text" name="event_title_desc" id="event_title_desc" value="" size="60" maxlength="200" onBlur="return makeValidString(this);"></td>
				<!-- IN071264 Starts -->
				<td class="LABEL" width='25%'  style="display:none" id="autosaveontd" name="autosaveontd">Auto Save</td>
				<td class="LABEL" width='25%' valign="center"  style="display:none" id="autosaveon" name="autosaveon">
					<table border="0" cellpadding = 1 cellspacing="0" width="100%">
						<tr>
							<td width="20%"><img id="autoSaveImg" src="../../eCA/images/ToggleSwitchOff.png" onClick='autoSave(<%=auto_save_time%>)'/></td>
							<td class="LABEL" width="80%"><font color="red"><div id="timerlable" style="display:none">Time Remaining</div>&nbsp;<div id="timer" style="display:none"> 2:00</div></font></td>
						</tr>
					</table>
						
					<input type="hidden" id="autoSaveCheck" name="autoSaveCheck" id="autoSaveCheck" value="N"/>
				</td>
				<!-- IN071264 Ends -->
				<td  colspan = 2 width='50%' class ='button' align="right">
				<input type=button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HideHeader.label","ca_labels")%>" class=button onclick="compressHeaderFrames();" name="hideHeaderButton" id="hideHeaderButton" <%if(p_note_type.equals("")||(!ql_flag.equals("Y")&&!appl_task_id.equals("PROGRESS_NOTES"))){ %>disabled<%}%>></td>
			</tr>
		<%				
					if(!p_note_type.equals("")||ql_flag.equals("Y"))
					{  
						if(performed_by_name.equals(""))
							performed_by_name = perf_pract_name_ql;			
						
						
								
						if(error_flag && msgfrom.equals("DIS_ADV_NOT_EXISTS"))
						{%>
								
								<script>
								var msg = getMessage('DIS_ADV_NOT_EXISTS','CA');
								alert(msg);							
								messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
								</script>
				<%	}else if(error_flag && msgfrom.equals("DECEASED_ONLY"))
						{%>
								
								<script>
								var msg = getMessage('DECEASED_ONLY','CA');
								alert(msg);							
								messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
								</script>
				<%	}else if(!error_flag && msgfrom.equals("MAX_NOTES_LIMIT"))
						{%>
								<script>
									alert(getMessage("MAX_NOTES_LIMIT","CA"));							
								</script>
				<%  }else{%>
							<script>						
								
								var sec_count = "<%=sec_count%>";
								var doc_linked_note_yn = "<%=doc_linked_note_yn%>";
								var NoteTypeflag = <%=NoteTypeflag%>;
								
								 if ((NoteTypeflag == true)  && (parseInt(sec_count) > 0))
								 {		   									
										//console.log(parent.parent.document.getElementById("RecClinicalNotesFrame").contentWindow.document.getElementById("RecClinicalNotesSectionFrame"));
										//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=p_note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+encodeURIComponent("<%=event_title_desc%>","UTF-8")+'&note_status=<%=note_status%>&performed_by_pract='+encodeURIComponent("<%=perf_pract_name_ql%>","UTF-8")+'&performed_date=<%=p_date_time%>&attending_practitioner='+encodeURIComponent("<%=attending_practitioner%>","UTF-8")+'&speciality_name='+encodeURIComponent("<%=speciality_name%>","UTF-8")+'&Sex=<%=Sex%>&visit_adm_date=<%=visit_adm_date%>&med_service='+encodeURIComponent("<%=serv_name_ql%>","UTF-8")+'&accession_num=<%=accession_num%>&discharge_date=<%=discharge_date_time%>&location_code=<%=location_code%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';//IN041881
										
										top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=<%=p_note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&event_title_desc='+encodeURIComponent("<%=event_title_desc%>","UTF-8")+'&note_status=<%=note_status%>&performed_by_pract='+encodeURIComponent("<%=perf_pract_name_ql%>","UTF-8")+'&performed_date=<%=p_date_time%>&attending_practitioner=<%=attending_practitioner_temp%>&speciality_name='+encodeURIComponent("<%=speciality_name%>","UTF-8")+'&Sex=<%=Sex%>&visit_adm_date=<%=visit_adm_date%>&med_service='+encodeURIComponent("<%=serv_name_ql%>","UTF-8")+'&accession_num=<%=accession_num%>&discharge_date=<%=discharge_date_time%>&location_code=<%=location_code%>&doc_linked_note_yn=<%=doc_linked_note_yn%>';//IN041881
										  
										top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href='../../eCA/jsp/RecClinicalNotesToolbar.jsp?operation_mode=<%=operation_mode%>&doc_linked_note_yn=<%=doc_linked_note_yn%>&function_id=<%=function_id%>&appl_task_id=<%=appl_task_id%>';
										
							

								}else if (doc_linked_note_yn == "Y" && parseInt(sec_count) == 0 && NoteTypeflag == true)
								{
									top.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols="100%,0%,0%";

									top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&called_from=NOTES_HEADER';

									top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=<%=note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>&called_from=NOTES_HEADER';

									/*top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUpload.jsp?note_type=<%=p_note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>';
									top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = '../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=<%=p_note_type%>&facility_id=<%=facility_id%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&patient_class=<%=patient_class%>&appl_task_id=<%=appl_task_id%>';*/
						   
								}
						</script>

				<%		}	}
					} // end of else
						
				%>
					
					</table>
					<input type="hidden" name="prev_sec_hdg_code" id="prev_sec_hdg_code"			value="">
					<input type="hidden" name="prev_child_sec_hdg_code" id="prev_child_sec_hdg_code"		value="">
					<input type="hidden" name="multi_sec_hdg_code" id="multi_sec_hdg_code"			value="">
					<input type="hidden" name="multi_child_sec_hdg_code" id="multi_child_sec_hdg_code"	value="">
					<input type="hidden" name="prev_image_linked_yn" id="prev_image_linked_yn"		value="">
					<input type="hidden" name="prev_sec_type" id="prev_sec_type"				value="">
					<input type="hidden" name="prev_sec_result_link_type" id="prev_sec_result_link_type"	value="">
					<input type="hidden" name="avl_image_selected" id="avl_image_selected"			value="">
					<input type="hidden" name="addendumTxt" id="addendumTxt"					value="">	
					<input type="hidden" name="no_of_rows" id="no_of_rows"					value="">
					<input type="hidden" name="serv_facl_spec_yn" id="serv_facl_spec_yn"			value="<%=serv_facl_spec_yn%>">
					<input type="hidden" name="forwarded_clinician_id" id="forwarded_clinician_id"		value="">
					<input type="hidden" name="action_comment" id="action_comment"				value="<%=action_comment%>">
					<input type="hidden" name="enable_cannedtext" id="enable_cannedtext"			value="">
					<input type="hidden" name="performedby_name" id="performedby_name"			value="">
					<input type="hidden" name="loggedUser" id="loggedUser"					value="<%=loggedUser%>">
					<input type="hidden" name="autho_doct_name" id="autho_doct_name"				value="<%=autho_doct_name%>">
					<input type="hidden" name="modified_by" id="modified_by"					value="<%=strModifiedBy%>">
					<input type="hidden" name="episode_type" id="episode_type" 				value="<%=episode_type%>">
					<input type="hidden" name="patient_id" id="patient_id"					value="<%=patient_id%>">
					<input type="hidden" name="patient_class" id="patient_class"				value="<%=patient_class%>">
					<input type="hidden" name="encounter_id" id="encounter_id"				value="<%=encounter_id%>">
					<input type="hidden" name="visit_adm_date" id="visit_adm_date"				value="<%=visit_adm_date%>">
					<input type="hidden" name="sys_date_time" id="sys_date_time"				value="<%=sys_date_time%>">
					<input type="hidden" name="operation_mode" id="operation_mode"				value="<%=operation_mode%>">
					<input type="hidden" name="record_mode" id="record_mode"				value="">
					<input type="hidden" name="srl_no" id="srl_no"					value="<%=srl_no%>">
					<input type="hidden" name="amendment_type" id="amendment_type"				value="<%=amendment_type%>">
					<input type="hidden" name="accession_num" id="accession_num"				value="<%=accession_num%>">
					<input type="hidden" name="event_class" id="event_class"					value="<%=event_class%>">
					<input type="hidden" name="privilege_type" id="privilege_type"				value="<%=privilege_type%>">
					<input type="hidden" name="note_type_desc" id="note_type_desc"				value="<%=note_type_desc%>">
					<input type="hidden" name="event_type_caption" id="event_type_caption"			value="<%=event_type_caption%>">
					<input type="hidden" name="note_type_security_level" id="note_type_security_level"	value="<%=security_level%>">
					<input type="hidden" name="event_date_caption" id="event_date_caption"			value="<%=event_date_caption%>">
					<input type="hidden" name="event_perf_by_caption" id="event_perf_by_caption"		value="<%=event_perf_by_caption%>">
					<input type="hidden" name="event_title_caption" id="event_title_caption"			value="<%=event_title_caption%>">
					<input type="hidden" name="event_auth_by_caption" id="event_auth_by_caption"		value="<%=event_auth_by_caption%>">
					<input type="hidden" name="event_status_caption" id="event_status_caption"		value="<%=event_status_caption%>">
					<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
					<input type="hidden" name="query_string" id="query_string"				value="<%=request.getQueryString()%>">
					<input type="hidden" name="figer_print_auth_yn" id="figer_print_auth_yn"			value="<%=figer_print_auth_yn%>">
					<input type="hidden" name="appl_task_id" id="appl_task_id"				value="<%=appl_task_id%>">	
					<input type="hidden" name="med_service" id="med_service"					value="<%=service_desc%>">
					<input type="hidden" name="facility_name" id="facility_name"				value="<%=facility_name%>">
					<input type="hidden" name="service_name" id="service_name"				value="<%=service_name%>">
					<input type="hidden" name="speciality_name" id="speciality_name"				value="<%=speciality_name%>">
					<!-- Added by Deepa on 6/25/2009 at 6:00 PM for IN010888 -->
					<input type="hidden" name="speciality_code" id="speciality_code"				value="<%=speciality_code1%>">
					<input type="hidden" name="performing_phy_name" id="performing_phy_name"			value="<%=performed_by_name%>">
					<input type="hidden" name="attending_practitioner" id="attending_practitioner"		value="<%=attending_practitioner%>">
					<input type="hidden" name="sel_facility_id" id="sel_facility_id"				value="<%=facility_id%>">
					<input type="hidden" name="defa_speciality_code" id="defa_speciality_code"		value="<%=speciality_code%>">
					<input type="hidden" name="days_backdate" id="days_backdate"				value="<%=days_backdate%>">
					<input type="hidden" name="event_date_time_flag" id="event_date_time_flag"		value="">
					<input type="hidden" name="synchFlag" id="synchFlag"					value= "0">
					<input type="hidden" name="sel_note_type" id="sel_note_type"				value= "<%=p_note_type%>">
					<input type="hidden" name="locale" id="locale"						value= "<%=locale%>">
					<input type="hidden" name="Sex" id="Sex"						value= "<%=Sex%>">
					<input type="hidden" name="Dob" id="Dob"						value= "<%=Dob%>">
					<input type="hidden" name="module_id" id="module_id"						value= "<%=module_id%>">
					<input type="hidden" name="discharge_date" id="discharge_date"						value= "<%=discharge_date_time%>">
					<input type="hidden" name="location_code" id="location_code"						value= "<%=location_code%>">
					<input type="hidden" name="selection_type" id="selection_type"						value= "">
					<input type="hidden" name="ql_flag" id="ql_flag"						value= "<%=ql_flag%>">
					<input type="hidden" name="medanc_serv_ql" id="medanc_serv_ql"						value= "<%=medanc_serv_ql%>">
					<input type="hidden" name="serv_name_ql" id="serv_name_ql"						value= "<%=serv_name_ql%>">
					<input type="hidden" name="performed_by_ql" id="performed_by_ql"						value= "<%=performed_by_ql%>">
					<input type="hidden" name="perf_pract_name_ql" id="perf_pract_name_ql"						value= "<%=perf_pract_name_ql%>">
					<input type="hidden" name="transcription_yn" id="transcription_yn"						value= "<%=transcription_yn%>">
					<input type="hidden" name="called_from" id="called_from"		value= "<%=called_from%>">
					<input type="hidden" name="note_group_req" id="note_group_req"	value= "<%=note_group_req%>">
					<input type="hidden" name="contr_mod_accession_num" id="contr_mod_accession_num"	value= "<%=contr_mod_accession_num%>">
					<input type="hidden" name="contr_oth_accession_num" id="contr_oth_accession_num" value="<%=contr_oth_accession_num%>"> <!-- IN053733 -->
					<!-- <input type="hidden" name="doc_linked_note_yn" id="doc_linked_note_yn"						value= ""> --> 
					<input type="hidden" name="sec_count" id="sec_count"						value= "<%=sec_count%>"> 
					<input type="hidden" name="forwardToFac" id="forwardToFac" value= ""> <!--IN038176-->
					<input type="hidden" name="notifiable_code" id="notifiable_code" value="<%=notifiable_code%>"> <!--IN044085-->
					<input type="hidden" name="notifiable_emailYN" id="notifiable_emailYN" value="<%=notifiable_emailYN%>"> <!--IN044085-->
					<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>"><!-- IN041284-->
					<input type="hidden" name="noteSplCharValidate" id="noteSplCharValidate" value="<%=noteSplCharValidate%>"><!-- //IN059571-->
					<input type="hidden" name="p_event_class_widget" id="p_event_class_widget" value="<%=p_event_class_widget%>"><!-- IN037701 -->
					<input type="hidden" name="p_notes_view" id="p_notes_view" value="<%=l_notes_view%>"><!-- IN037701 -->
					<input type='hidden' name='c_note_type' id='c_note_type' value='<%=p_note_type%>'>
					<input type='hidden' name='site_manflg' id='site_manflg' value='<%=siteSpecFlag%>'><!-- IN064566 -->
					<input type='hidden' name='display' id='display' value='<%=display%>'><!-- IN063799 -->
					<input type='hidden' name='myHIXSiteFlg' id='myHIXSiteFlg' value='<%=myHIXSiteFlg%>'><!-- IN067607 -->
					<input type='hidden' name='myHIXNoteType' id='myHIXNoteType' value='<%=myHIXNoteType%>'><!-- IN067607 -->
					<input type='hidden' name='copiedFlagYN' id='copiedFlagYN' value='<%=copiedFlagYN%>'><!-- IN068105 -->
					<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
					<input type='hidden' name='accession_num_auto' id='accession_num_auto' value=''><!--IN071264-->
					<input type='hidden' name='auto_save_yn' id='auto_save_yn' value='<%=auto_save_yn%>'><!--IN071264-->
					<input type='hidden' name='operation_mode_as' id='operation_mode_as' value=''><!--IN071264-->
					<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'><!--IN071264-->
					
					
					<table id="headerLineTable" style="display:none" width="100%" border=1 style="border-color:#A0522D" align='center' cellspacing="0">
					<tr>
						<td class='CAHIGHERLEVELCOLOR' width='100%' align = 'left'  id=headerTitle>
							<fmt:message key="eCA.NOTESHEADERINFORMATION.label" bundle="${ca_labels}"/>
						</td>
						<td width='50%' style="background-color:#83AAB4" align = right class = 'CAHIGHERLEVELCOLOR'>
							<input type=button value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowHeader.label","ca_labels")%>" class=button onclick="expandHeaderFrames();">
						</td>
					</tr>
				</table>
				</form>
				</center>
<%
			//26826 Start.
			}else{
				%>				
				<script>
					alert(getMessage("DIAG_NOT_RECORDED","OR"));
				</script>				
				<%
			}
			//26826 End.
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<%
if("NOTIFIABLEFORM".equals(appl_task_id))//IN050839 
{
%>
	<script>	
	if( '<%=operation_mode%>' == "" ){
		populateNoteType(document.RecClinicalNotesHeaderForm.filter_by);//IN050839
		callNoteSectionRoutine();//IN050839
	}
	</script>

<%}%>
</body>
</html>
<!--IN071264 Starts-->
<script type="text/javascript">
if("Y"=='<%=auto_save_yn%>' && document.RecClinicalNotesHeaderForm.note_type.value!='' ){
	document.getElementById("autosaveontd").style.display ="";
	document.getElementById("autosaveon").style.display="";
	
}
var auto_save_mins;//IN071264
var index =0;//IN071264
var timeoutHandle;
function countdown(minutes) {
	
    var seconds = 60;
    if(index==0)//IN071264
    auto_save_mins = minutes;//IN071264
    var mins = minutes
    function tick() {
    	index++;
    	if("Y"==document.getElementById("autoSaveCheck").value){
	        var counter = document.getElementById("timer");
	        var current_minutes = mins-1
	        seconds--;
	        counter.innerHTML =
	        current_minutes.toString() + ":" + (seconds < 10 ? "0" : "") + String(seconds);
	        if( seconds > 0 ) {
	            timeoutHandle=setTimeout(tick, 1000);
	        } else {
	 
	            if(mins > 1){
	 
	               // countdown(mins-1);   never reach "00" issue solved:Contributed by Victor Streithorst
	               setTimeout(function () { countdown(mins - 1); }, 1000);
	 			
	            }else{
	            	RecordClinicalNotes('','Y');
	            	countdown(auto_save_mins);
	            }
	        }
	        
	    }
    }
    tick();
}
</script>
<!--IN071264 Ends-->
<%!
					
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String retValue)
	{
		return (inputString==null)	?	retValue	:	inputString;
	}
%>

