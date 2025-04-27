<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
25/05/2012    IN032015		 Menaka V		The copy paste option is not working on the default view. The same is possible on the Expanded
											view. Should be able to have expanded view as a default one.
13/12/2012	  IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
											more appealing. Keeping the display of information more clear and visible.  
22/11/2012	  IN035961		Vijayakumar K	Issue: When we Click on ?Search? button we get exception error.
27/02/2013	  IN037937		vijayakumark 	System is displaying the Clinical Event History in ?Flow Sheet? view mode and search criteria fields filled by default,even though no quick link is selected. 
07/06/2013	  IN040459		Chowminya G 	Flow Sheet component as disabled,while defining Quick link this Flow sheet getting populated
9/12/2014	  IN052796		Nijitha			ML-BRU-SCF-1481
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/01/2016	IN58138			Karthi L										Need to provide an alternative view to enable the quicksheet view by event and not by group.																			
07/10/2016	IN047572		Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
19/10/2016	IN062196		Raja S											CRF-CIS-CA-MMS-QH-CRF-0177 /1-Search results not displayed in new lookup window
03/08/2017	IN064826		Krishna Gowtham J 03/08/2017		Ramesh G		SS-SCF-0768
19/01/2018  	IN066218  		PRATHYUSHA P	  28/1/2018		Ramesh G		ML-MMOH-CRF-0985.1
15/03/2018	IN066119		Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
24/04/2018	IN067371		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-1024
17/10/2018  IN068011		Ramesh G		17/10/2018		Ramesh G		ML-MMOH-CRF-1204
25/10/2018  IN068703         Ramya Maddena   25/10/2018      Ramesh G        ML-MMOH-SCF-1089
02/01/2019  IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
24/07/2024	64273			Ramesh			24/07/2024		Ramesh G		MMS-DM-CRF-0260
14/08/2024	65094			Kishore Kumar	 16/08/2024    Ramesh Goli      ML-MMOH-CRF-2149
14/10/2024	70699	                Gunasekar        15/09/2024    Ashwini Ragupathi     ML-MMOH-CRF-1759
----------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		// added by Arvind @ 04-12-08 
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>	
  	<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<!-- IN035961 start -->
	<script language='javascript'>
		
	function isNumeric(obj) {
	var numb = '0123456789';
	var inputparam = obj.value;
	var blnVal = isValid(inputparam,numb);
	if(blnVal == false)
	{
	obj.value = '';
	alert(getMessage("CHARACTER_NOT_ALLOWED",'CA')); 
	obj.focus();
	return blnVal;
	}
	else
	{
	return blnVal;
	}
	}

	function isValid(parm,val) {
	if (parm == "") return true;
	for (i=0; i<parm.length; i++) {
	if (val.indexOf(parm.charAt(i),0) == -1) return false;
	}
	return true;
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- IN035961 end -->
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    
	String bean_id1 = "eCA.ChartRecordingAddGroupBean" ; //Added for ML-MMOH-CRF-2149
	String bean_name1 = "eCA.ChartRecordingAddGroupBean"; //Added for ML-MMOH-CRF-2149
	ChartRecordingAddGroupBean bean1 = (eCA.ChartRecordingAddGroupBean)getBeanObject( bean_id1, bean_name1, request) ; //Added for ML-MMOH-CRF-2149 

	String locale = (String) p.getProperty("LOCALE");
	
	String resp_id	= (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patientclass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	String EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String event_called = request.getParameter("event_called")==null?"":request.getParameter("event_called");
	String facility_Id_param="";
	String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String p_hist_type = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");//IN035950
	String facilityId = (String)session.getValue("facility_id"); //IN037937
	
	//IN066218 START
	String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
	String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
	String history_type_2T=request.getParameter("history_type")==null?"":request.getParameter("history_type");
	String history_type_3T=request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String event_class_2T=request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String order_type_3T=request.getParameter("order_type_3T")==null?"":request.getParameter("order_type_3T"); //39052
	String event_class_3T=request.getParameter("event_class_3T")==null?"":request.getParameter("event_class_3T");//39052
	String from_date_2T=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date_2T=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String event_item_2T=request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	String archivalYN	= request.getParameter("archivalYN")==null?"": request.getParameter("archivalYN"); //52176
	String from_date_enable = "";
	String to_date_enable = "";
	String view_optin_diaable="";
	if("Y".equals(calling_from_2T)){
		from_date_enable = "disabled";
		to_date_enable = "disabled";		
		view_optin_diaable	= "disabled";	
	}
	//IN066218 END.
	String flowSheetModeSelect ="";	//IN066218
	String treeViewModeSelect = ""; 	//IN066218
	if(patientclass.equals("OP"))
		encounterid = "";
	else
		encounterid = encounterid;
	
	String option_id_res	= request.getParameter("option_id_res")==null?"": request.getParameter("option_id_res"); //Added for ML-MMOH-CRF-2149
	bean1.setRestrictCEHTree(option_id_res);
	Connection con = null;
	PreparedStatement stmt = null;
	PreparedStatement stmtsql = null;
	ResultSet rs = null;
	ResultSet rsql = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	String sql = "";
	String code = "";
	String desc = "";
    String from_date_param = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	String flowsheet_id = request.getParameter("flowsheet_id") == null ? "" : request.getParameter("flowsheet_id");
	String check_prop = "";
	String view_by = "", patient_class = "", hist_type = "", flowsheet = "";
	String facility = "", event_class = "",	event_group = "", event_item = "", abnormal = "", order_asc = "";
	//String normalcy_ind = "";
	String date_checked = "", event_checked = "checked";
	String event_group_enable = "disabled";
	String event_group_read = "readonly";
	String event_item_read = "readonly";
	String event_group_desc = "";
	String event_item_desc = "";
	String order_desc = "selected";
	String color_sel = "", ind_sel = "";
	String flowsheet_sel = "";
	String date_ind = "", date_val = "", date_unit = "", date_ref = "";
	StringTokenizer strToken = null;
	String legend_type = "";
	boolean isSiteSpecificForLabPrint = false;//IN066453
	try
	{
	con = ConnectionManager.getConnection(request);

//	String sysdateSql="select to_char(sysdate-7,'dd/mm/yyyy hh24:mi')  fromDate,to_char(sysdate,'dd/mm/yyyy hh24:mi') toDate from dual";
	String fromDate="",toDate="";

	String sqlConfResult = "select GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) viewConfRes from dual";
	String viewConfRes = "";
	String sqlFilter = "";
	String column_id = "",	column_desc = "",	value_type = "",	actual_value = "";
	String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
	String final_value = "";
	String field_desc = "", event_class_enable = "disabled";
	String sel = "";
	String iSel = "", dSel = "", oSel = "", Esel = "", Xsel = "";
	HashMap map = new HashMap();
	String default_sql = "";
	StringBuffer default_query = new StringBuffer();
	int Existance_Count = 0;
	String login_user	= (String)session.getValue("login_user");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	//String view_mode ="C";//IN032015
	String view_mode ="E";//IN032015
	//ADDED FOR  IN066119 start
	String bean_id					= "CAClinicalHistoryBean" ;
	String bean_name				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	isSiteSpecificForLabPrint = CommonBean.isSiteSpecific(con, "CA","CEH_LAB_PRINT_REST");//IN066453
	//ADDED FOR IN066119 end
	try
	{
		stmtsql = con.prepareStatement(sqlConfResult);
		stmtsql.setString(1,resp_id);
		stmtsql.setString(2,reln_id);
		rs = stmtsql.executeQuery();

		while(rs.next())
		{
			viewConfRes = rs.getString("viewConfRes");
		}

		if(stmtsql != null) stmtsql.close();
		if(rs != null) rs.close();
	//IN066119 starts
		if(!calling_from_2T.equals("Y")){
		che_default_mode=bean.getClinicalHistViewMode(con);
		}
	//IN066119 ends

		//IN066218 Start.
		if(che_default_mode.equals("F")){
			flowSheetModeSelect ="checked";
			treeViewModeSelect = ""; 
		}
		else if(che_default_mode.equals("T")){
			flowSheetModeSelect ="";
			treeViewModeSelect = "checked"; 
		}
		//IN066218 End.
		if(ql_ref.equals("") && !default_yn.equals("N"))
		{
			//default_sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and DEFAULT_YN = 'Y' and rownum=1 and OPTION_ID = 'FLOW_SHEET'";
			//default_sql = "SELECT 1 existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.default_yn = 'Y' AND a.option_id = b.option_id AND b.option_id = 'FLOW_SHEET' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y' AND ROWNUM = 1";
			//Changed by T.Dinesh for INC 17746 on 31/12/2009
			default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'FLOW_SHEET' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
			stmtsql = con.prepareStatement(default_sql);
		
			stmtsql.setString(1,login_user);
			stmtsql.setString(2,resp_id);
			stmtsql.setString(3,locale);
			rs = stmtsql.executeQuery();
			if(rs.next())
			{
				Existance_Count = rs.getInt("EXISTANCE_COUNT");
			}
			if(rs != null) rs.close();
			if(stmtsql != null) stmtsql.close();

			default_query.append("select A.QUICK_LINK_REF from ");
			if(Existance_Count>0)
				default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
			else
				default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
			default_query.append(" and OPTION_ID = 'FLOW_SHEET' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y'");
			default_query.append(" and added_facility_id = ? "); //IN037937
			
			stmtsql = con.prepareStatement(default_query.toString());
			if(Existance_Count>0)
				stmtsql.setString(1,login_user);
			else
				stmtsql.setString(1,resp_id);
			stmtsql.setString(2,facilityId); //IN037937
			rs = stmtsql.executeQuery();

			if(rs.next())
			{
				ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
			}

			if(stmtsql != null) stmtsql.close();
			if(rs != null) rs.close();
		}

		if(!ql_ref.equals(""))
		{
			sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
			stmtsql = con.prepareStatement(sqlFilter);
			stmtsql.setString(1,ql_ref);
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
					if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
					{
						if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
						{
							final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
						}
						else
							final_value = "";
					}
					else
						final_value = relative_value;
				}

				map.put(column_id,final_value);


			}
			//out.println(map);
			if(stmtsql != null) stmtsql.close();
			if(rs != null) rs.close();
		}
			
	}
	catch(Exception e)
	{
		//out.println("Exception in try of FlowSheetCriteria.jsp -"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}

	if (from_date_param.equals(""))
	{
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d");

	}
	else
	  {
        toDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			//com.ehis.util.DateUtils.convertDate(from_date_param,"DMYHM","en",locale);
	    fromDate = com.ehis.util.DateUtils.convertDate(from_date_param,"DMYHM","en",locale);
			//com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d"); 

	  }

		String accessFacilityYN = "A", disableFacilityId = "";
		if(resp_id == null) resp_id ="";
		//String facilityId = (String)session.getValue("facility_id");//IN037937
		String loggedin_clinician_id		=	(String) session.getValue("ca_practitioner_id");
		String practitioner_type	=	(String) session.getValue("practitioner_type");
		if(facilityId == null)facilityId="";	
		
		String query_task_access = "SELECT get_task_applicability('ACC_ALL_FCY_HIST', null, ? ,?) from dual";
		pstmt = con.prepareStatement(query_task_access);
		pstmt.setString(1,resp_id);
		pstmt.setString(2,reln_id);
		rset = pstmt.executeQuery();
		if(rset.next()){
			accessFacilityYN = rset.getString(1);
		}
		if(rset!=null) rset.close();
		if(pstmt != null ) pstmt.close();

		if(accessFacilityYN.equals("X")){
			disableFacilityId = "disabled";
		}
		
		
		pstmt = con.prepareStatement("Select LEGEND_TYPE from CR_CLIN_EVENT_PARAM");
		rset = pstmt.executeQuery();
		if(rset.next())
		{
			legend_type = rset.getString("LEGEND_TYPE") == null ? "S" : rset.getString("LEGEND_TYPE");
		}
		if(legend_type.equals("S"))
		{
			ind_sel = "selected";
			color_sel = "";
		}
		else
		{
			ind_sel = "";
			color_sel = "selected";
		}

		if(!ql_ref.equals(""))
		{
			field_desc = (String) map.get("FLOWSHEET_VIEW") == null ? "" : (String) map.get("FLOWSHEET_VIEW");
			if(field_desc.equals("Y"))
				check_prop ="checked";
			else if(field_desc.equals("N"))
				check_prop ="";

			field_desc=(String) map.get("FACILITY_ID") == null ? "" : (String) map.get("FACILITY_ID");
			if(field_desc.equals("LOGGED_IN_FCY"))
				facility_Id_param=facilityId;
			else if(!field_desc.equals(""))
				facility_Id_param=field_desc;
			else
				facility_Id_param="";
			field_desc = (String) map.get("HIST_REC_TYPE") == null ? "" : (String) map.get("HIST_REC_TYPE");
			if(!field_desc.equals(""))
				hist_type = field_desc;
			
			if(!hist_type.equals(""))
			{
				event_class_enable = "";
				event_item_read = "";
				field_desc = (String) map.get("EVENT_CLASS") == null ? "" : (String) map.get("EVENT_CLASS");
				
				if(!field_desc.equals(""))
					event_class = field_desc;
				if(!event_class.equals(""))
				{
					event_group_enable = "";
					event_group_read = "";
					field_desc = (String) map.get("EVENT_GROUP") == null ? "" : (String) map.get("EVENT_GROUP");
					//field_code=
					if(!field_desc.equals(""))
						event_group = field_desc;
					if(!event_group.equals(""))
					{
						sqlFilter = "select long_desc description from CR_CLN_EVT_GRP_LANG_VW where EVENT_GROUP = ? and hist_rec_type = ? and LANGUAGE_ID = ?";
						stmtsql = con.prepareStatement(sqlFilter);
						stmtsql.setString(1,event_group);
						stmtsql.setString(2,hist_type);
						stmtsql.setString(3,locale);
						rs = stmtsql.executeQuery();
						if(rs.next())
							event_group_desc = rs.getString("description") == null ? "" : rs.getString("description");
						if(rs != null) rs.close();
						if(stmtsql != null) stmtsql.close();
						
					}
				}
				field_desc = (String) map.get("EVENT_ITEM") == null ? "" : (String) map.get("EVENT_ITEM");
				if(!field_desc.equals(""))
					event_item = field_desc;
				if(!event_item.equals(""))
				{
					sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = ? and LANGUAGE_ID = ?";
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,event_item);
					stmtsql.setString(2,hist_type);
					stmtsql.setString(3,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
						event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
				}
			}
			field_desc = (String) map.get("PATIENT_CLASS") == null ? "" : (String) map.get("PATIENT_CLASS");
			if(!field_desc.equals(""))
			{
				patient_class = field_desc;
				if(patient_class.equals("CURR_PAT_CLASS"))
					patient_class = patientclass;

				if(patient_class.equals("IP"))
				{
					iSel = "selected"; dSel = ""; oSel = ""; Esel = ""; Xsel = "";
				}
				else if(patient_class.equals("DC"))
				{
					iSel = ""; dSel = "selected"; oSel = ""; Esel = ""; Xsel = "";
				}
				else if(patient_class.equals("OP"))
				{
					iSel = ""; dSel = ""; oSel = "selected"; Esel = ""; Xsel = "";
				}
				else if(patient_class.equals("EM"))
				{
					iSel = ""; dSel = ""; oSel = ""; Esel = "selected"; Xsel = "";
				}
				else if(patient_class.equals("XT"))
				{
					iSel = ""; dSel = ""; oSel = ""; Esel = ""; Xsel = "selected";
				}
			}
			field_desc = (String) map.get("FACILITY_ID") == null ? "" : (String) map.get("FACILITY_ID");
			if(!field_desc.equals(""))
			{
				facility = field_desc;
				if(facility.equals("LOGGED_IN_FCY"))
					facility = facilityId;
			}
			field_desc = (String) map.get("FLOWSHEET_ID") == null ? "" : (String) map.get("FLOWSHEET_ID");
			if(!field_desc.equals(""))
			{
				flowsheet = field_desc;
			}
			field_desc = (String) map.get("VIEW_BY") == null ? "" : (String) map.get("VIEW_BY");
			if(!field_desc.equals(""))
			{
				view_by = field_desc;
				if(view_by.equals("D"))
				{
					date_checked = "checked";
					event_checked = "";
				}
				else if(view_by.equals("D"))
				{
					date_checked = "";
					event_checked = "checked";
				}
			}
			field_desc = (String) map.get("ABNORMAL") == null ? "" : (String) map.get("ABNORMAL");
			if(field_desc.equals("Y"))
				abnormal = "checked";
			else
				abnormal = "";
			field_desc = (String) map.get("DISPLAY_ORDER") == null ? "" : (String) map.get("DISPLAY_ORDER");
			if(field_desc.equals("D"))
			{
				order_desc = "selected";
				order_asc = "";
			}
			else if(field_desc.equals("A"))
			{
				order_desc = "";
				order_asc = "selected";
			}
			field_desc = (String) map.get("NORMALCY_IND") == null ? "" : (String) map.get("NORMALCY_IND");
			if(field_desc.equals("C"))
			{
				color_sel = "selected";
				ind_sel = "";
			}
			else if(field_desc.equals("I"))
			{
				color_sel = "";
				ind_sel = "selected";
			}
			field_desc = (String) map.get("ENCOUNTER_ID") == null ? "" : (String) map.get("ENCOUNTER_ID");
			if(!field_desc.equals(""))
			{
				if(field_desc.equals("ENCOUNTER_ID"))
					encounterid = encounterId;
			}
			else
				encounterid = "";

			field_desc = (String) map.get("PERIOD_FROM") == null ? "" : (String) map.get("PERIOD_FROM");
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
				if(date_ind.equals("B"))
					fromDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					fromDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
			}
			field_desc = (String) map.get("PERIOD_TO") == null ? "" : (String) map.get("PERIOD_TO");
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
				if(date_ind.equals("B"))
					toDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					toDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
			}
			//view_mode = (String) map.get("VIEW_MODE") == null ? "C" : (String) map.get("VIEW_MODE");//IN032015	
			view_mode = (String) map.get("VIEW_MODE") == null ? "E" : (String) map.get("VIEW_MODE");//IN032015	
			
			if(view_mode.equals(""))
			{
				//view_mode = "C";//IN032015
				view_mode = "E";//IN032015
			}
			
		}
		//IN035950 Starts
		if("CA_CLINICIAN_WIDGET".equals(p_called_from) )
		{
			fromDate="";
			toDate="";
		}
		//IN035950 Ends
		/* Ends */
		//IN066218) Start.
		if("Y".equals(calling_from_2T) )
		{
			if(from_date_2T !="")
			fromDate=java.net.URLDecoder.decode(from_date_2T,"UTF-8");
			if(to_date_2T !="")
			toDate=java.net.URLDecoder.decode(to_date_2T,"UTF-8");
		}
		//IN066218 End.
%>
	<form name="flowsheet_criteria_form" id="flowsheet_criteria_form">

<table  cellpadding=3 cellspacing=0 width="100%" align=center border=0>
<tr>
			
<td class="label" width='15%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%' >
				<input type="text" maxlength=16 size="16" value='<%=fromDate%>' name="from_date" id="from_date" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");' <%=from_date_enable%> ><img src="../../eCommon/images/CommonCalendar.gif" <%=from_date_enable%> onclick="return showCalendarValidate('from_date');" /> 
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<input type="text" maxlength=16 size="16" value='<%=toDate%>' name="to_date" id='to_date' onBlur='chkDateTime(this,"DMYHM","<%=locale%>");' <%=to_date_enable%>><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');"  <%=to_date_enable%>/></td>
			<td class="label" width='15%'>	
				<!-- <fmt:message key="eCA.FlowSheetView.label" bundle="${ca_labels}"/>&nbsp;<input type="checkbox" name="chkFlowSheet" id="chkFlowSheet" onClick="displayViewBy()"></font> -->
				<fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="Common.mode.label" bundle="${common_labels}"/>
			</td>
			<!-- 	//flowSheetModeSelect and treeViewModeSelect ADDED FOR  ML-MMOH-CRF-0985.1 (IN066218)  -->
			<!--<td class="fields" width='35%'><input type="radio" value="F" name="view_mode" id="view_mode" <%=flowSheetModeSelect%> onClick="displayViewBy()">&nbsp;<fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/> &nbsp;&nbsp;<input type="radio" value="T" name="view_mode" id="view_mode" <%=treeViewModeSelect%> onClick="displayViewBy()">&nbsp;<fmt:message key="eCA.tree.label" bundle="${ca_labels}"/>   //commented for IN061884-->
			<td class="fields" width='35%'><input type="radio" value="F" name="view_mode" id="view_mode" <%=flowSheetModeSelect%> onClick="displayViewBy()">&nbsp;<fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/> &nbsp;&nbsp;<input type="radio" value="T"  name="view_mode" id="view_mode" <%=treeViewModeSelect%> onClick="displayViewBy()">&nbsp;<fmt:message key="eCA.tree.label" bundle="${ca_labels}"/> &nbsp;&nbsp;<input type="radio" value="G" <%=view_optin_diaable%>  name="view_mode" onClick="displayViewBy()">&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/><!--Modified for IN061884-->
			</td>
	</tr>				
			<!--<table width='100%'>
			<tr>-->
			
			<table   cellpadding=3 cellspacing=0 width="100%" ID='CE' align=center style='display:inline' >
			<tr>
			<td  class='label' width='15%'><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/></font>	</td>
			<td class='label' width='35%'><input type="radio" value="E" name="view_by" id="view_by" <%=event_checked%>>&nbsp;<fmt:message key="Common.Event.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="D" name="view_by" id="view_by" <%=date_checked%>>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></font></td>
			<td width='15%'></td> <td width='35%'></td>

			</tr>
			</TABLE>

			<table  cellpadding=3 cellspacing=0 width="100%" ID='FS'  style='display:none' align=center >
			<TR>
			<td  class='label' width='15%'><fmt:message key="eCA.FlowSheets.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='35%'><SELECT name='cboFlowSheetComp' id='cboFlowSheetComp'><OPTION VALUE="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</OPTION>
								<%
									if (rs!=null) rs.close();
									if(stmt != null)stmt.close();
									//stmt = con.prepareStatement("SELECT FLOW_SHEET_ID,SHORT_DESC FROM CA_FLOW_SHEET WHERE EXISTS (SELECT 1 FROM  CA_FLOW_SHEET_APPLICABLITY WHERE FLOW_SHEET_ID=CA_FLOW_SHEET.FLOW_SHEET_ID AND PRACT_TYPE=? AND (PRACTITIONER_ID='*ALL' OR PRACTITIONER_ID=?) AND (SPECIALITY_CODE ='*ALL' OR SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE FROM  AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE  FACILITY_ID=? AND PRACTITIONER_ID=? ))) order by 2");	
									//stmt = con.prepareStatement("SELECT FLOW_SHEET_ID, SHORT_DESC FROM CA_FLOW_SHEET_LANG_VW WHERE EXISTS(SELECT 1 FROM CA_FLOW_SHEET_APPLICABLITY WHERE FLOW_SHEET_ID=CA_FLOW_SHEET_LANG_vw.FLOW_SHEET_ID AND PRACT_TYPE=? AND (PRACTITIONER_ID='*ALL' OR PRACTITIONER_ID=?) AND (SPECIALITY_CODE ='*ALL' OR SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE FROM  AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE  FACILITY_ID=? AND PRACTITIONER_ID=? ))) AND LANGUAGE_ID = ? order by 2");
									stmt = con.prepareStatement("SELECT FLOW_SHEET_ID, SHORT_DESC FROM CA_FLOW_SHEET_LANG_VW WHERE EXISTS(SELECT 1 FROM CA_FLOW_SHEET_APPLICABLITY WHERE FLOW_SHEET_ID=CA_FLOW_SHEET_LANG_vw.FLOW_SHEET_ID AND PRACT_TYPE=? AND (PRACTITIONER_ID='*ALL' OR PRACTITIONER_ID=?) AND (SPECIALITY_CODE ='*ALL' OR SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE FROM  AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE  FACILITY_ID=? AND PRACTITIONER_ID=? ))) AND EFF_STATUS = 'E' AND LANGUAGE_ID = ? order by 2");//IN040459
									stmt.setString(1,practitioner_type);
									stmt.setString(2,loggedin_clinician_id);
									stmt.setString(3,loggedin_clinician_id);
									stmt.setString(4,facilityId);
									stmt.setString(5,loggedin_clinician_id);
									stmt.setString(6,locale);
									rs = stmt.executeQuery();

									while(rs.next())
									{
										if(flowsheet.equals(rs.getString("FLOW_SHEET_ID")))
											flowsheet_sel = "selected";
										else
											flowsheet_sel = "";
						%>
										<option value="<%=rs.getString("FLOW_SHEET_ID")%>" <%=flowsheet_sel%>><%=rs.getString("SHORT_DESC")%></option>
						<%
									}
									if (rs!=null) rs.close();
									if(stmt != null)stmt.close();
									%>	
								</SELECT>
							</td>
			<td width='15%'></td> <td width='35%'></td>	
							</TR>
					</TABLE>
								
					<!-- <td align='left' id='tdView' style='display'>&nbsp;<font class='label'>View By</font>&nbsp;&nbsp;<input type="radio" value="E" name="view_by" id="view_by" checked>&nbsp;<font class='label'>Event</font><input type="radio" value="D" name="view_by" id="view_by">&nbsp;<font class='label'>Date</font>
					</td>  -->
				<!--</tr>
				</table>-->
			

	<!-- 		<td colspan='1' align='left'><font class='label'>Flow Sheet View </font>&nbsp;<input type="checkbox" name="chkFlowSheet" id="chkFlowSheet" onClick="displayViewBy()"></td><td colspan='2' align='left' id='tdView' style='display'>&nbsp;<font class='label'>View By</font>&nbsp;&nbsp;<input type="radio" value="E" name="view_by" id="view_by" checked>&nbsp;Event<input type="radio" value="D" name="view_by" id="view_by">&nbsp;Date</td> -->
		
	

	<table border=0  cellpadding=3 cellspacing=0 width="100%" id='moreCriteria' style='display:none' align=center  >
		<tr>
			<td class="label"  width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		  <!--
			<td class="label">
			<input type="radio" value="I" name="episode_type" id="episode_type">IP&nbsp;&nbsp;
			<input type="radio" value="O" name="episode_type" id="episode_type">OP&nbsp;&nbsp;
			<input type="radio" value="B" name="episode_type" id="episode_type" checked>Both
			</td>
		  -->
			<td class="fields" width='35%'>
			<select name="episode_type" id="episode_type">
			<option value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------
			<option value="I" <%=iSel%>><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>			
			<option value="D" <%=dSel%>><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<option value="O" <%=oSel%>><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
			<option value="E" <%=Esel%>><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			<option value="X" <%=Xsel%>><fmt:message key="Common.external.label" bundle="${common_labels}"/>
			</select>
			</td>
			<td class="label"  width='15%'><fmt:message key="Common.History.label" bundle="${common_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%' >
			<%
			sql = "select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT','MERP','CHIC','MHD') AND LANGUAGE_ID = ? order by 2";   //CHIC  addded againt 64273 //Added not in MHD for ML-MMOH-CRF-1759
			stmt = con.prepareStatement(sql);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();
			if("CA_RESULTS_WIDGET".equals(p_called_from) )
			{
				%>
				<select name="history_type" id="history_type" disabled><option value=""></option>
				<%
				while(rs.next())
				{
					if(p_hist_type.equals(rs.getString("hist_rec_type")))
					{
						out.println("<option value='"+rs.getString("hist_rec_type")+"' selected>"+rs.getString("short_desc")+"</option>");
						break;
					}
				}
				%>
				</select>
				<%
			}
			//IN066218 Start.
			else if("Y".equals(calling_from_2T) && !history_type_2T.equals("") )
			{
				%>
				<select name="history_type" id="history_type" disabled><option value=""></option>
				<%
				while(rs.next())
				{
					if(history_type_2T.equals(rs.getString("hist_rec_type")))
					{
						out.println("<option value='"+rs.getString("hist_rec_type")+"' selected>"+rs.getString("short_desc")+"</option>");
						break;
					}
				}
				
				%>
				</select>
				
				
				<%
			} //IN066218 End.
			else if(!history_type_3T.equals("") )
			{
				%>
				<select name="history_type" id="history_type" disabled><option value=""></option>
				<%
				while(rs.next())
				{
					if(history_type_3T.equals(rs.getString("hist_rec_type")))
					{
						out.println("<option value='"+rs.getString("hist_rec_type")+"' selected>"+rs.getString("short_desc")+"</option>");
						break;
					}
				}
				
				%>
				</select>
				
				
				<%
			}
			else
			{
			%>
			<select name="history_type" id="history_type" onChange='selectEventClass(this);disableButtons(this,<%=isSiteSpecificForLabPrint%>)'><option value="">------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option> 

			<%
				//colspan=4
				//sql = "select hist_rec_type, short_desc from cr_hist_rec_type where hist_rec_type not in('DIAG','ALGY','MEDN','NBDT','FEVT') order by 2 ";
				/*
				sql = "select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT','MERP','CHIC') AND LANGUAGE_ID = ? order by 2";  //CHIC  addded againt 64273
				stmt = con.prepareStatement(sql);
				stmt.setString(1,locale);
				rs = stmt.executeQuery(); */
				while(rs.next())
				{
					code = rs.getString("hist_rec_type");
					desc = rs.getString("short_desc");
					if(hist_type.equals(code))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+code+"' "+sel+">"+desc+"</option>");
				}
			} 
			%>
			</select>&nbsp;<!-- <img src="../../eCommon/images/mandatory.gif"></img> -->
			</td>
			</tr>

			<tr>
			<td class="label" width='15%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%'><select name="facility_id" id="facility_id" <%=disableFacilityId%>><option value="">-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
			<%
				if (rs!=null) rs.close();
				if(stmt != null)stmt.close();
				//String facility_query = "select substr(facility_name,1,15) facility_name, facility_id from sm_facility_param order by facility_name";

				String facility_query = "select substr(facility_name,1,15) facility_name, facility_id from sm_facility_param_VW where language_id = ?  order by facility_name";
				stmt = con.prepareStatement(facility_query);
				stmt.setString(1,locale);
				rs = stmt.executeQuery();
				String selected = "";
				while(rs.next())
				{
					String fac_code = rs.getString("facility_id");
					String fac_desc = rs.getString("facility_name");
                    //for IN14542 commented as it is defaulting the facilityid.
					if(facility_Id_param.equals(fac_code))
					{
					   selected = "selected";
					}
					if(accessFacilityYN.equals("X")){
						out.println("<option value='"+fac_code+"' "+selected+" >"+fac_desc+"</option>");
						
					}
					else{
						out.println("<option value='"+fac_code+"' "+selected+">"+fac_desc+"</option>");
					}
					selected = "";
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			%>
			</select></td>

		
		
			<td class="label"  width='15%'><fmt:message key="Common.EventClass.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%'>
			<select name="event_class" id="event_class" <%=event_class_enable%> onChange='enableEventGrp(this)'>
			<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<%
			//IN066218 Start.
			//if(!hist_type.equals(""))
			if((!hist_type.equals("")) ||(("Y".equals(calling_from_2T)  && !history_type_2T.equals("")  )) || (!history_type_3T.equals("")))
				{
					String p_history_type="";
					//String P_event_class_2T=""; commented for checkstyle
					StringBuffer sqlBuffer = new StringBuffer();
					if(!hist_type.equals(""))
						p_history_type=hist_type;
					else if(!history_type_2T.equals(""))
						p_history_type=history_type_2T;
					else if(!history_type_3T.equals(""))
						p_history_type=history_type_3T;
					
					sqlBuffer.append(" select EVENT_CLASS, long_desc, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? ");
					sqlBuffer.append(" and language_id = ? order by long_desc ");
					
					stmt = con.prepareStatement(sqlBuffer.toString());
					stmt.setString(1,p_history_type);
					stmt.setString(2,locale);					
			//IN066218 End.		
					rs = stmt.executeQuery();
					while(rs.next())
					{
						code = rs.getString("event_class");
						desc = rs.getString("short_desc");
						if(event_class.equals(code) || event_class_2T.equals(code) || event_class_3T.equals(code))
							sel = "selected";
						else
							sel = "";
						out.println("<option value='"+code+"' "+sel+">"+desc+"");
					}
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				}
				
			%>
			</select><input type='hidden' name='event_class_defaulted' id='event_class_defaulted' value='<%=event_class%>'/>
			</td>
			</tr>
			<tr>
			<td class="label" width='15%'><fmt:message key="eCA.EventGroup.label" bundle="${ca_labels}"/></td>
			<td class=fields width='35%'>
				<input type="hidden" maxlength=15 size="15" name="event_group" id="event_group" value='<%=event_group%>'><input type="text" maxlength=15 size="15" name="event_group1" id="event_group1" onBlur='checkGroup(this)' value='<%=event_group_desc%>' <%=event_group_read%> <%=event_group_enable%>><input type="button" class="button" name="event_group_but" id="event_group_but" value="?" onClick="SearchEventGroup();" <%=event_group_enable%>>
			<input type='hidden' name='event_group_defaulted' id='event_group_defaulted' value='<%=event_group_desc%>'/>
			</td>
			<td class="label"  width='15%'><fmt:message key="eCA.EventItem.label" bundle="${ca_labels}"/></td>
			<td class=fields width='35%' >
			<% //IN066218 Start.
			if("Y".equals(calling_from_2T)  && !event_item_2T.equals(""))
			{
				sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = ? and LANGUAGE_ID = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,event_item_2T);
				stmtsql.setString(2,history_type_2T);
				stmtsql.setString(3,locale);
				rs = stmtsql.executeQuery();
				if(rs.next()){
					event_item = event_item_2T;
					event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
				}
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			//IN066218 End.
			%>
				<input type="hidden" maxlength=15 size="15" name="event_item" id="event_item" value='<%=event_item%>'><input type="text" maxlength=15 size="15" name="event_item1" id="event_item1" onBlur='checkItem(this)' value='<%=event_item_desc%>' <%=event_item_read%> <%=event_class_enable%>><input type="button" class="button" name="event_item_but" id="event_item_but" value="?" onClick="SearchEventItem();" <%=event_class_enable%>>
			<input type='hidden' name='event_item_defaulted' id='event_item_defaulted' value='<%=event_item_desc%>'/>
			</td>
			<!--<td>&nbsp;</td> -->
		</tr>
		<tr>
			<td class="label" width='15%'><fmt:message key="Common.Abnormalonly.label" bundle="${common_labels}"/></font></td>
			<td class=fields width='35%' ><input type="checkbox" name="chkAbnormal" id="chkAbnormal" value="N" <%=abnormal%>></td>
			<td class="label" width='15%'>	
			<fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%'>	<select name='graphorder' id='graphorder'>
				<option value='asc' <%=order_asc%>><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
				<option value='desc' <%=order_desc%>><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
			</select>
			
			</td>
		<!--  MMS-QH-CRF-0177 [IN047572] Start	-->			
		</tr>
		<tr>
		<td class="label"  width='15%'>
					<fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
			<td class='fields'width='35%'> 
				<input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search1' id='search1' value='?'  class='button' onClick="if(document.forms[0].specialty.value == '')getSpecialty()"><input type="hidden" name="speciality_code" id="speciality_code" value=''> <!-- IN062196 changed search button name as search1 -->		
			</td>
			<td class='label'width='15%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
				<td class='fields'width='35%'>
				<input type='text'  name='attend_pract_desc' id='attend_pract_desc' value='' onBlur='getPractitioner1(this)' size='20' maxlength='20'><input type='button' name='search2' id='search2' value='?'  class='button' onClick="if(document.forms[0].attend_pract_desc.value == '')getPractitioner()"><input type="hidden" name="attend_pract_code" id="attend_pract_code" value=''>  <!-- IN062196 changed search button name as search2 -->
			</td>
		</tr>
		<!--  MMS-QH-CRF-0177 [IN047572] End	-->
</table>
		<table border=0 cellpadding=3 cellspacing=0 width="100%" >
		<tr>
			<td class="label" id="encid" style="" width='15%'>
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='fields' id="encidval" style="" width='35%'> 
			<!-- IN035961 start -->
			<!--<input type="text" name="encounter_id" id="encounter_id" value="<%=encounterid%>" maxlength=12 size=13 onKeyPress = 'return allowValidNumber(this,event,12,0)'>-->
			<input type="text" name="encounter_id" id="encounter_id" value="<%=encounterid%>" maxlength=12 size=13 onKeyPress = 'return allowValidNumber(this,event,12,0)' onblur = 'isNumeric(this)'>
			<!-- IN035961 end -->
			</td>
				<td class='label' id="NorInd" style="" width='15%'><fmt:message key="eCA.NormalcyIndication.label" bundle="${ca_labels}"/></td>
				<td class='fields'  id="NorIndval" style="" width='35%'>
				<select name='cboNormalcyInd' id='cboNormalcyInd'><option value='I' <%=ind_sel%>><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></option><option value='C' <%=color_sel%>><fmt:message key="Common.Color.label" bundle="${common_labels}"/></option></select>
				</td>
			<!--IN061884 changes starts-->
		</tr>
		 <tr>
		<td class="label" width='15%' id="grp_view" style="display:none"><fmt:message key="eCA.View.label" bundle="${ca_labels}"/></td>
		<td class="fields" width='35%' id="grp_view_val" style="display:none"><fmt:message key="Common.Panel.label" bundle="${common_labels}"/> <input type="radio" value="P" name="group_panel" id="group_panel" checked>&nbsp; &nbsp;&nbsp;<fmt:message key="Common.Individual.label" bundle="${common_labels}"/><input type="radio" value="A" name="group_panel" id="group_panel">&nbsp;
		</td>
			<td class="label" id="grphisttype" style=''  width='15%'><fmt:message key="Common.History.label" bundle="${common_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class="fields" id="grphisttypeval" style='' width='35%' >
			<%
			sql = "select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT','MERP','CHIC','MHD') AND LANGUAGE_ID = ? order by 2";  //CHIC  addded againt 64273  //Added not in MHD for ML-MMOH-CRF-1759
			stmt = con.prepareStatement(sql);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();
			%>
			<select name="grphistory_type" id="grphistory_type" id="grphistory_type" onChange='selectEventClass(this);'><option value="">------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option> 

			<%while(rs.next())
				{
					code = rs.getString("hist_rec_type");
					desc = rs.getString("short_desc");
					if(hist_type.equals(code))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+code+"' "+sel+">"+desc+"</option>");
				}
			%>
			</select>&nbsp;
			</td>
		</tr> 
		<!--IN061884 changes ends-->
		<tr>
		<!--  INT-CRF-BRU-CIS-004 - IN058138 -->	
		<tr id = "show_ordby_event" >
			<td class="label" id ="evtcod_label_id" width='15%' style="display"><fmt:message key="eCA.dispbyevent.label" bundle="${ca_labels}"/></td>
			<td class=fields id ="evtcod_check_id" width='35%' style="display"><input type="checkbox" name="orderByEvent" id="orderByEvent" value="N" ></td>
		</tr>
		<!--  INT-CRF-BRU-CIS-004 - IN058138 -->
		<!--			Added By	: Arvind Singh Pal
						Purpose		: Created For GHL-CRF-0043 
						Date			: 12 November 2009

		-->

		<td class="label" width='15%' id="show_txt_rsult" style=""><fmt:message key="eCA.ShowTextResult.label" bundle="${ca_labels}"/></td>

		<td class="fields" width='35%' id="show_exp" style=""><input type="radio" value="E" name="show_mode" id="show_mode" <%if(view_mode.equals("E")){ %>checked<%}%>>&nbsp;<fmt:message key="eCA.Expanded.label" bundle="${ca_labels}"/> &nbsp;&nbsp;<input type="radio" value="C" name="show_mode" id="show_mode" <%if(view_mode.equals("C")){%>checked<%}%> >&nbsp;<fmt:message key="eCA.Collapsed.label" bundle="${ca_labels}"/>
		</td> 

		<!--End Here -->

			<td colspan = 4 width='100%' align ='right'>
<!-- 			<%	
			if(EHR_YN.equals("N") )  // If this page is not called from Centralised Server
			{
			%>
			<input type="button" class='button' name='EHRView' id='EHRView'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EHRView.label","ca_labels")%>' onClick="callEHRViewer();">	
			<%
			}
			%> -->
			<input type="button" class=button name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="makeVisible(this);populateControl('','')">&nbsp;
			<input type="button" class=button name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onClick="clearForm('C');displayViewBy();"> <!-- clear_buttons_enable added for IN066218-->
			<input id="moreCri" style="" type="button" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")%>'  name='more' onClick="makeVisible(this);">
			</td>
		</tr>
		<!-- <tr>
			<td class="label" align="right" nowrap colspan='6'>&nbsp;&nbsp;</td>
		</tr>  --> 
		</table>
		<!-- // added by Arvind @ 04-12-08  -->

		<%  if(!imgUrl.equals("")){%>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end here -->

	<input type="hidden" name="Patient_id" id="Patient_id" value="<%=patientid%>">
	<!-- <input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>"> -->
	<input type="hidden" name="enc_id" id="enc_id" value="<%=request.getParameter("encounter_id")%>">
	<input type="hidden" name="viewConfRes" id="viewConfRes" value="<%=viewConfRes%>">
	<input type="hidden" name="queryStrForCmnts" id="queryStrForCmnts" value="<%=request.getQueryString()%>">
	<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
	<input type='hidden' name='EHR_YN' id='EHR_YN' value='<%=EHR_YN%>' >
	<input type='hidden' name='event_called' id='event_called' value='<%=event_called%>' >
	<input type='hidden' name='relationship_id' id='relationship_id' value='<%=reln_id%>' >
	<!--IN035950 Starts -->
	<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from%>' >
	<input type='hidden' name='p_event_class_widget' id='p_event_class_widget' value='<%=p_event_class%>' >
	<input type='hidden' name='hist_type' id='hist_type' value='<%=p_hist_type%>' >
	<input type='hidden' name='Splcode_desc_hid' id='Splcode_desc_hid' value=''> <!-- MMS-QH-CRF-0177 [IN047572]  -->
	<input type='hidden' name='practCode_desc_hid' id='practCode_desc_hid' value=''> <!-- MMS-QH-CRF-0177 [IN047572]  -->
	<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityId%>'> <!--  MMS-QH-CRF-0177 [IN047572]  -->
	<input type='hidden' name='isSiteSpecificForLabPrint' id='isSiteSpecificForLabPrint' value='<%=isSiteSpecificForLabPrint%>'><!--IN066453-->
	<input type='hidden' name='p_review_rad_yn' id='p_review_rad_yn' value='<%=p_review_rad_yn%>'><!--IN071561-->
	<input type='hidden' name='order_type_3T' id='order_type_3T' value='<%=order_type_3T%>'> <!-- 39052 -->
	<input type='hidden' name='archivalYN' id='archivalYN' value='<%=archivalYN%>'> <!-- 52176 -->
	<!--IN035950 Ends -->
	</form>
	
<%
		if(map != null) map.clear();
		if(rs !=null) rs.close();
		if(rsql!=null) rsql.close();
		if(rset!=null) rset.close();
		if(stmt != null ) stmt.close();
		if(pstmt != null) pstmt.close();
		if(stmtsql!=null) stmtsql.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
	<script>
		if('<%=ql_ref%>' != '')
		{
			if('<%=check_prop%>' == 'checked') //{ Commented for IN064826
				document.flowsheet_criteria_form.view_mode[0].click();
				//IN067371 Changes starts
			else{
				if('<%=ql_ref%>' !='0000')
				document.flowsheet_criteria_form.view_mode[1].click();	
			}
				//IN067371 Changes ends
				//if(document.flowsheet_criteria_form.cboFlowSheetComp != null)
					//document.flowsheet_criteria_form.cboFlowSheetComp.value = '<%=flowsheet_id%>';
				document.flowsheet_criteria_form.search.click();
			//} Commented for IN064826	
		}
		//IN035950 Starts
displayViewBy();		
		if('<%=p_called_from%>' == "CA_CLINICIAN_WIDGET" || '<%=p_called_from%>' == "CA_RESULT_ENCT_WIDGET"  ||'<%=calling_from_2T%>' =="Y")//IN052796 // calling_from_2T added for IN066218
		{
			//IN068011 Start.
			if('<%=calling_from_2T%>' =="Y"){
				document.flowsheet_criteria_form.event_class.disabled = false;
				document.flowsheet_criteria_form.event_item1.readOnly = false;
				document.flowsheet_criteria_form.event_item1.disabled = false;//New
				document.flowsheet_criteria_form.event_item_but.disabled = false;
				document.flowsheet_criteria_form.event_group1.readOnly = false;
				document.flowsheet_criteria_form.event_group1.disabled = false;//New
				document.flowsheet_criteria_form.event_group_but.disabled = false;
				
			}
			//IN068011 End.
			document.flowsheet_criteria_form.search.click();			
		}
		//IN035950 Ends
		<!--  INT-CRF-BRU-CIS-004 - IN058138 -->
		if(document.forms[0].view_mode[1].checked) {
			document.getElementById('evtcod_label_id').style.display = "none";
			document.getElementById('evtcod_check_id').style.display = "none";
		}
		<!--  INT-CRF-BRU-CIS-004 - IN058138 -->
		document.getElementById('from_date').onblur();
	</script>
</body>
</html>
<!-- IN068703--Start-->
<script>
populateControl('','');
</script>
<!--- IN068703 ends--->

