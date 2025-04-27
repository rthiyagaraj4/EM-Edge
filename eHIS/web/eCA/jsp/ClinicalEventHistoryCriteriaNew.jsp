<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
28/08/2019	IN071263	sivabagyam M 	07/04/2019		Ramesh G		CA-MO-CRF-20101.6/03-Select-drop down
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
04/11/2020		IN073728	Nijithas		04/11/2020		Ramesh 		MO-CRF-20101.16
---------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>	
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
	<script language='javascript' src='../../eCA/js/MedicationOrders.js'></script>
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

</HEAD>
<FORM name="criteria_form" id="criteria_form">
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	//IN069654  starts
	PreparedStatement stmtsql = null;
	ResultSet rs = null;
	//IN069654 ends
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	PreparedStatement pstmt1 = null;//IN071596
	PreparedStatement pstmt7= null;//IN072762
	PreparedStatement pstmt8= null;//IN072762
	ResultSet rset1 = null;//IN071596
	ResultSet rs7 = null;//IN072762
	ResultSet rs8 = null;//IN072762
	String facilityId 	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String resp_id	= (String)session.getValue("responsibility_id");//IN069654
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	//IN069654 starts
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patientclass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	String grphistory_type			= "";//IN071596
	String fromDate="",toDate="";
	String normalcy_ind="",abnormal1="",date_Ordr="",fid="",fname="";
	String facility_Id_param="";
	String view_by = "", patient_class1 = "";
	String event_class = "",	event_group = "", event_item = "", abnormal = "";
	String date_checked = "", event_checked = "checked";
	String all_check = "selected";
	String self_checked = "";
	String speciality_checked = "";
	String personal_view = "";
	String event_group_desc = "";
	String event_item_desc = "";
	String date_ind = "", date_val = "", date_unit = "", date_ref = "";
	StringTokenizer strToken = null;
	//IN069654 ends
try{

	con = ConnectionManager.getConnection(request);
	String sql_facility="",sql_hist="";//IN071596
	sql_facility="select facility_id,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"', 1) facility_name,DECODE(FACILITY_ID,?,'Y','N') facility_YN  from sm_facility_for_user where appl_user_id=?";
	sql_hist="SELECT HIST_TYPE FROM sm_quick_link_list_vw WHERE QUICK_LINK_REF=?";//IN071596
//IN069654 starts
	String sqlConfResult = "select GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) viewConfRes from dual";
	String viewConfRes = "";
	String sqlFilter = "";
	String column_id = "",	column_desc = "",	value_type = "",	actual_value = "";
	String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
	String final_value = "";
	String field_desc = "";
	HashMap map = new HashMap();
	String default_sql = "";
	boolean isfacilitySelct=false;//IN070032
	StringBuffer default_query = new StringBuffer();
	ArrayList<String> functionIds = new ArrayList<String>();//IN070032
	functionIds.add("FACILITY_SELCT_NCEH");//IN070032
	int Existance_Count = 0;
	String login_user	= (String)session.getValue("login_user");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	String bean_id					= "CAClinicalHistoryBean" ;
	String bean_name				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);	
	bean.setSiteSpecific(functionIds,"CA");//IN070032
	isfacilitySelct = bean.isSiteSpecific("FACILITY_SELCT_NCEH");//IN070032
	//IN073728 Starts
	String hist_type_new =  "" ;
	ArrayList eventHistArr = new ArrayList() ;
	String bean_id_new					= "NewClinicalEventHistBean" ;
	String bean_name_new			= "eCA.NewClinicalEventHistBean";
	NewClinicalEventHistBean beanNew	= (NewClinicalEventHistBean)getBeanObject( bean_id_new, bean_name_new , request) ; 
	//IN073728 Ends
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

		if(ql_ref.equals("") && !default_yn.equals("N"))
		{
			default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'FLOW_SHEET_NEW' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
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

			default_query.append("select A.QUICK_LINK_REF quick_link_ref from ");
			if(Existance_Count>0)
				default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
			else
				default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
			default_query.append(" and OPTION_ID = 'FLOW_SHEET_NEW' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y'");
			default_query.append(" and added_facility_id = ? "); 
			
			stmtsql = con.prepareStatement(default_query.toString());
			if(Existance_Count>0)
				stmtsql.setString(1,login_user);
			else
				stmtsql.setString(1,resp_id);
			stmtsql.setString(2,facilityId); 
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
		//IN071596 starts
			pstmt1=con.prepareStatement(sql_hist);
			pstmt1.setString(1,ql_ref);
			rset1=pstmt1.executeQuery();
			while(rset1.next())
			{
				grphistory_type=rset1.getString("HIST_TYPE")==null?"":rset1.getString("HIST_TYPE");
			}
			if(pstmt1 != null) pstmt1.close();
			if(rset1 != null) rset1.close();
			//IN071596 ends
			//IN073728 Starts
			if("*ALL".equals(grphistory_type)){
				
				eventHistArr = beanNew.getHistRecType(con,locale);
				for(int i =0;i < eventHistArr.size(); i ++){
					String[] eventHistStr =(String[])eventHistArr.get(i);
					hist_type_new = eventHistStr[0];
				
					sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ? AND HIST_TYPE = ? " ;
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,ql_ref);
					stmtsql.setString(2,hist_type_new);
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

						map.put(column_id+hist_type_new,final_value);

						
					}
					System.out.println("map==>"+map);
					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();
				}
			}
			else{
				
				sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
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

					//map.put(column_id+grphistory_type,final_value);
					map.put(column_id,final_value);


				}
				//out.println(map);
				if(stmtsql != null) stmtsql.close();
				if(rs != null) rs.close();
			}
			
			
			
/* 			
			sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
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
			if(rs != null) rs.close(); *///IN073728 Ends
		}
			
	}
	catch(Exception e)
	{
		//out.println("Exception in try of FlowSheetCriteria.jsp  -"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	//IN069654 ends
	if (fromDate.equals(""))
	{
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d");

	}
	else
	{
        toDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	    fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM","en",locale);
    }
    //IN069654 starts
	if(resp_id == null) resp_id ="";
	if(facilityId == null)facilityId="";	
	
	if(!ql_ref.equals(""))
	{//IN073728 Starts
		if("*ALL".equals(grphistory_type))
				{
				eventHistArr = beanNew.getHistRecType(con,locale);
					for(int m=0;m<eventHistArr.size();m++){
						normalcy_ind="";
						abnormal1="";
						date_Ordr="";
						event_class = "";
						event_group = ""; 
						event_item = "";
						abnormal = "";
						event_group_desc = "";
						event_item_desc = "";
						toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d");
						String[] eventHistStr =(String[])eventHistArr.get(m);
						personal_view = "";
						hist_type_new = eventHistStr[0];
						if(!"*ALL".equals(grphistory_type)){
							hist_type_new = "";
						}
					field_desc = (String) map.get("PERSONAL_VIEW"+hist_type_new) == null ? "S" : (String) map.get("PERSONAL_VIEW"+hist_type_new);
					if(!field_desc.equals(""))
					{
						personal_view = field_desc;
						if(personal_view.equals("A"))
						{
							all_check = "selected";
							self_checked = "";
							speciality_checked = "";
						}
						else if(personal_view.equals("S"))
						{
							all_check = "";
							self_checked = "selected";
							speciality_checked = "";
						}
						else if(personal_view.equals("M"))
						{
							all_check = "";
							self_checked = "";
							speciality_checked = "selected";
						}
					}
					else{
						personal_view = "S";
						all_check = "";
						self_checked = "selected";
						speciality_checked = "";
					}
					%>
					<input type='hidden'  name ='default_personalView<%=hist_type_new%>' value = "<%=personal_view%>">
					<%
						field_desc = (String) map.get("EVENT_CLASS"+hist_type_new) == null ? "" : (String) map.get("EVENT_CLASS"+hist_type_new);
						
						if(!field_desc.equals(""))
							event_class = field_desc;
						%>
						<input type='hidden'  name ='default_eventClass<%=hist_type_new%>' value="<%=event_class%>">
						<%
							field_desc = (String) map.get("EVENT_GROUP"+hist_type_new) == null ? "" : (String) map.get("EVENT_GROUP"+hist_type_new);
							if(!field_desc.equals(""))
								event_group = field_desc;
							%>
							<input type='hidden'  name ='default_eventGroup<%=hist_type_new%>' value = "<%=event_group%>">
							<%
								sqlFilter = "select long_desc description from CR_CLN_EVT_GRP_LANG_VW where EVENT_GROUP = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
								stmtsql = con.prepareStatement(sqlFilter);
								stmtsql.setString(1,event_group);
								stmtsql.setString(2,locale);
								rs = stmtsql.executeQuery();
								if(rs.next())
									event_group_desc = rs.getString("description") == null ? "" : rs.getString("description");
								if(rs != null) rs.close();
								if(stmtsql != null) stmtsql.close();
						%>
						<input type='hidden'  name ='default_eventGroupDesc<%=hist_type_new%>' value = "<%=event_group_desc%>">
						<%
						field_desc = (String) map.get("EVENT_ITEM"+hist_type_new) == null ? "" : (String) map.get("EVENT_ITEM"+hist_type_new);
						if(!field_desc.equals(""))
							event_item = field_desc;
						%>
						<input type='hidden'  name ='default_eventItem<%=hist_type_new%>' value = "<%=event_item%>">
						<%
							if(!grphistory_type.equals("MEDN") && !event_item.equals(""))//Adding start for //IN072762
							{
								sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
								stmtsql = con.prepareStatement(sqlFilter);
								stmtsql.setString(1,event_item);
								stmtsql.setString(2,locale);
								rs = stmtsql.executeQuery();
								if(rs.next())
									event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
								if(rs != null) rs.close();
								if(stmtsql != null) stmtsql.close();
							}
							if(grphistory_type.equals("MEDN") && !event_item.equals(""))
							{
								pstmt8 = con.prepareStatement("select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?");
							    pstmt8.setString(1,event_item);
								pstmt8.setString(2,locale);
								rs8 = pstmt8.executeQuery();
									if(rs8.next())
									{
									  event_item_desc = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
														
								 	}
									if(rs8 != null) rs8.close();
									if(pstmt8 != null) pstmt8.close();
							}//Addding end for //IN072762
						%>
						<input type='hidden'  name ='default_eventItemDesc<%=hist_type_new%>' value = "<%=event_item_desc%>">
						<%
					field_desc = (String) map.get("PATIENT_CLASS"+hist_type_new) == null ? "" : (String) map.get("PATIENT_CLASS"+hist_type_new);
					if(!field_desc.equals(""))
					{
						patient_class1 = field_desc;
						if(patient_class1.equals("CURR_PAT_CLASS"))
							patient_class1 = patientclass;
					}
					else
						patient_class1="";	
					%>
					<input type='hidden'  name ='default_patientClass<%=hist_type_new%>' value = "<%=patient_class1%>">
					<%
					field_desc = (String) map.get("VIEW_BY"+hist_type_new) == null ? "" : (String) map.get("VIEW_BY"+hist_type_new);
					if(!field_desc.equals(""))
					{
						view_by = field_desc;
						if(view_by.equals("I"))
						{
							date_checked = "checked";
							event_checked = "";
						}
						else if(view_by.equals("P"))
						{
							date_checked = "";
							event_checked = "checked";
						}
					}
					%>
					<input type='hidden'  name ='default_viewBy<%=hist_type_new%>' value = "<%=view_by%>">
					<%
					field_desc = (String) map.get("ABNORMAL"+hist_type_new) == null ? "" : (String) map.get("ABNORMAL"+hist_type_new);
					abnormal1=field_desc;
					if(field_desc.equals("Y"))
						abnormal = "checked";
					else
						abnormal = "";
					%>
					<input type='hidden'  name ='default_abnormal<%=hist_type_new%>' value = "<%=abnormal1%>">
					<%
					field_desc = (String) map.get("DISPLAY_ORDER"+hist_type_new) == null ? "" : (String) map.get("DISPLAY_ORDER"+hist_type_new);
					date_Ordr=field_desc;
					%>
					<input type='hidden'  name ='default_date<%=hist_type_new%>' value = "<%=date_Ordr%>">
					<%
					field_desc=(String) map.get("FACILITY_ID"+hist_type_new) == null ? "" : (String) map.get("FACILITY_ID"+hist_type_new);//
					if(field_desc.equals("LOGGED_IN_FCY"))
						facility_Id_param=facilityId;
					else if(!field_desc.equals(""))
						facility_Id_param=field_desc;
					else
						facility_Id_param="";
					%>
					<input type='hidden'  name ='def_facility<%=hist_type_new%>' value = "<%=facility_Id_param%>">
					<%
					field_desc = (String) map.get("NORMALCY_IND"+hist_type_new) == null ? "" : (String) map.get("NORMALCY_IND"+hist_type_new);
					normalcy_ind=field_desc;
					%>
					<input type='hidden'  name ='default_normalcyInd<%=hist_type_new%>' value = "<%=normalcy_ind%>">
					<%
					field_desc = (String) map.get("ENCOUNTER_ID"+hist_type_new) == null ? "" : (String) map.get("ENCOUNTER_ID"+hist_type_new);
					if(!field_desc.equals(""))
					{
						if(field_desc.equals("ENCOUNTER_ID"))
							encounterid = encounterId;
					}
					else
						encounterid ="";//IN070032
					%>
					<input type='hidden'  name ='default_encounterid<%=hist_type_new%>' value = "<%=encounterid%>">
					<%
					field_desc = (String) map.get("PERIOD_FROM"+hist_type_new) == null ? "" : (String) map.get("PERIOD_FROM"+hist_type_new);
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
					%>
					<input type='hidden'  name ='default_fromDate<%=hist_type_new%>' value = "<%=fromDate%>">
					<%
					field_desc = (String) map.get("PERIOD_TO"+hist_type_new) == null ? "" : (String) map.get("PERIOD_TO"+hist_type_new);
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
					%>
					<input type='hidden'  name ='default_toDate<%=hist_type_new%>' value = "<%=toDate%>">
					<%	}
			}
		else//IN073728 ENDS
		{
			field_desc = (String) map.get("PERSONAL_VIEW") == null ? "S" : (String) map.get("PERSONAL_VIEW");
			if(!field_desc.equals(""))
			{
				personal_view = field_desc;
				if(personal_view.equals("A"))
				{
					all_check = "selected";
					self_checked = "";
					speciality_checked = "";
				}
				else if(personal_view.equals("M"))
				{
					all_check = "";
					self_checked = "";
					speciality_checked = "selected";
				}
				else if(personal_view.equals("S"))
				{
					all_check = "";
					self_checked = "selected";
					speciality_checked = "";
				}
			}
			%>
			<input type='hidden'  name ='default_personalView' value = "<%=personal_view%>">
			<%
				field_desc = (String) map.get("EVENT_CLASS") == null ? "" : (String) map.get("EVENT_CLASS");
				
				if(!field_desc.equals(""))
					event_class = field_desc;
				%>
				<input type='hidden'  name ='default_eventClass' value="<%=event_class%>">
				<%
					field_desc = (String) map.get("EVENT_GROUP") == null ? "" : (String) map.get("EVENT_GROUP");
					if(!field_desc.equals(""))
						event_group = field_desc;
					%>
					<input type='hidden'  name ='default_eventGroup' value = "<%=event_group%>">
					<%
						sqlFilter = "select long_desc description from CR_CLN_EVT_GRP_LANG_VW where EVENT_GROUP = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
						stmtsql = con.prepareStatement(sqlFilter);
						stmtsql.setString(1,event_group);
						stmtsql.setString(2,locale);
						rs = stmtsql.executeQuery();
						if(rs.next())
							event_group_desc = rs.getString("description") == null ? "" : rs.getString("description");
						if(rs != null) rs.close();
						if(stmtsql != null) stmtsql.close();
				%>
				<input type='hidden'  name ='default_eventGroupDesc' value = "<%=event_group_desc%>">
				<%
				field_desc = (String) map.get("EVENT_ITEM") == null ? "" : (String) map.get("EVENT_ITEM");
				if(!field_desc.equals(""))
					event_item = field_desc;
				%>
				<input type='hidden'  name ='default_eventItem' value = "<%=event_item%>">
				<%
				if(!grphistory_type.equals("MEDN") && !event_item.equals(""))//Adding start for //IN072762
				{
					sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,event_item);
					stmtsql.setString(2,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
						event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
				}
				if(grphistory_type.equals("MEDN") && !event_item.equals(""))
				{
					pstmt8 = con.prepareStatement("select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?");
				    pstmt8.setString(1,event_item);
					pstmt8.setString(2,locale);
					rs8 = pstmt8.executeQuery();
						if(rs8.next())
						{
						  event_item_desc = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
											
					 	}
						if(rs8 != null) rs8.close();
						if(pstmt8 != null) pstmt8.close();
				}//Addding end for //IN072762
				%>
				<input type='hidden'  name ='default_eventItemDesc' value = "<%=event_item_desc%>">
				<%
			field_desc = (String) map.get("PATIENT_CLASS") == null ? "" : (String) map.get("PATIENT_CLASS");
			if(!field_desc.equals(""))
			{
				patient_class1 = field_desc;
				if(patient_class1.equals("CURR_PAT_CLASS"))
					patient_class1 = patientclass;
			}
			else
				patient_class1="";	
			%>
			<input type='hidden'  name ='default_patientClass' value = "<%=patient_class1%>">
			<%
			field_desc = (String) map.get("VIEW_BY") == null ? "" : (String) map.get("VIEW_BY");
			if(!field_desc.equals(""))
			{
				view_by = field_desc;
				if(view_by.equals("I"))
				{
					date_checked = "checked";
					event_checked = "";
				}
				else if(view_by.equals("P"))
				{
					date_checked = "";
					event_checked = "checked";
				}
			}
			%>
			<input type='hidden'  name ='default_viewBy' value = "<%=view_by%>">
			<%
			field_desc = (String) map.get("ABNORMAL") == null ? "" : (String) map.get("ABNORMAL");
			abnormal1=field_desc;
			if(field_desc.equals("Y"))
				abnormal = "checked";
			else
				abnormal = "";
			%>
			<input type='hidden'  name ='default_abnormal' value = "<%=abnormal1%>">
			<%
			field_desc = (String) map.get("DISPLAY_ORDER") == null ? "" : (String) map.get("DISPLAY_ORDER");
			date_Ordr=field_desc;
			%>
			<input type='hidden'  name ='default_date' value = "<%=date_Ordr%>">
			<%
			field_desc=(String) map.get("FACILITY_ID") == null ? "" : (String) map.get("FACILITY_ID");//
			if(field_desc.equals("LOGGED_IN_FCY"))
				facility_Id_param=facilityId;
			else if(!field_desc.equals(""))
				facility_Id_param=field_desc;
			else
				facility_Id_param="";
			%>
			<input type='hidden'  name ='def_facility' value = "<%=facility_Id_param%>">
			<%
			field_desc = (String) map.get("NORMALCY_IND") == null ? "" : (String) map.get("NORMALCY_IND");
			normalcy_ind=field_desc;
			%>
			<input type='hidden'  name ='default_normalcyInd' value = "<%=normalcy_ind%>">
			<%
			field_desc = (String) map.get("ENCOUNTER_ID") == null ? "" : (String) map.get("ENCOUNTER_ID");
			if(!field_desc.equals(""))
			{
				if(field_desc.equals("ENCOUNTER_ID"))
					encounterid = encounterId;
			}
			else
				encounterid ="";//IN070032
			%>
			<input type='hidden'  name ='default_encounterid' value = "<%=encounterid%>">
			<%
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
			%>
			<input type='hidden'  name ='default_fromDate' value = "<%=fromDate%>">
			<%
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
			%>
			<input type='hidden'  name ='default_toDate' value = "<%=toDate%>">
			<%	
		}
		
		
	}//IN073728
%>
<!--IN069654 ends -->
<br>
	<TABLE  cellpadding=3 cellspacing=0 width="90%" align=left border=0>
		<TR>
			<TD class="label" width='10%'>
				<fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</TD>
			<TD class="fields" >
				<input type="text" maxlength=16 size="16" value='<%=fromDate%>' name="from_date" id="from_date" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'> 
				<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date');" /> 
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<input type="text" maxlength=16 size="16" value='<%=toDate%>' name="to_date" id="to_date" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'> 
				<img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');" />
			</TD>
		  <TD class="label" width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></TD>
			<TD class="fields">
				<input type="text" name="encounter_id" id="encounter_id" value="<%=encounterid%>" maxlength=12 size=13 onKeyPress = 'return allowValidNumber(this,event,12,0)' onblur = 'isNumeric(this)'> 
			</TD>
			<TD class="label">Facility</TD>
			<TD width='10%' class="fields">
				<SELECT name="fac_id_sel" id="fac_id_sel">
<%
	String selString ="";//IN070032
	String facility_YN="";//IN070032
	pstmt=con.prepareStatement(sql_facility,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	pstmt.setString(1,facility_Id_param);
	pstmt.setString(2,p_user_name);
	rset=pstmt.executeQuery();
	while(rset.next())
	{
		//String facility_YN=rset.getString("facility_YN");//IN070032
		 facility_YN=rset.getString("facility_YN");//IN070032
		if(facility_YN.equals("Y"))
			facilityId=facility_Id_param;
     }
	rset.beforeFirst();
	if(rset!=null)
	{
	//IN070032 starts
		if(isfacilitySelct)//IN071263
		{
		 selString = "<option selected>-------------Select----------------</option>";
		}
		else
			 selString ="";
	   while(rset.next())
	   {
		 fid= rset.getString("facility_id")==null?"":rset.getString("facility_id");
		 fname=rset.getString("facility_name")==null?"":rset.getString("facility_name");
		 if(!(facility_Id_param.equals("")) && !(isfacilitySelct)){
			if(facilityId.equals(fid))//IN069654
			{
				selString += "<option selected value='"+fid+ "' >"+fname+"  </option>";
			}else{
				selString += "<option value='"+fid+ "' >"+fname+"</option>";
		    }
		}
		 else if(facility_Id_param.equals("")&&isfacilitySelct)
		 {
			 if(facilityId.equals(fid))//IN069654
				{
					selString += "<option  value='"+fid+ "' >"+fname+"  </option>";
				}else{
					selString += "<option value='"+fid+ "' >"+fname+"</option>";
			    }
		 }
		 else
		 {
			 if(facilityId.equals(fid))//IN069654
				{
					selString += "<option selected value='"+fid+ "' >"+fname+"  </option>";
				}else{
					selString += "<option value='"+fid+ "' >"+fname+"</option>";
			    }
		 }
	   }
	   	System.out.println("selString: "+selString);
		out.println(selString);
    }//IN070032 ends
	if(rset != null)rset.close();
	if(pstmt != null)pstmt.close();
	%>
	
				</SELECT>
			</TD>
			<TD class="label" align="left">
				<input type="button" class=button name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="populateValues('','ONCLICK')">
			</TD>
		</TR>
	</TABLE>
<input type='hidden'  name ='patient_id' value = "<%=patientid%>">
<input type='hidden'  name ='enc_id' value = "<%=encounterid%>">
<input type='hidden'  name ='ql_ref' value = "<%=ql_ref%>"><!--IN069654-->
<input type='hidden'  name='relationship_id' id='relationship_id' value ="<%=reln_id%>">
<input type='hidden'  name='grphistory_type' id='grphistory_type' value ="<%=grphistory_type%>"><!--IN071596-->
<input type='hidden'  name ='queryString' value = "<%=request.getQueryString()%>">
<input type='hidden' value="" name="histSelectedCriteria" id="histSelectedCriteria" /><!--IN073728 -->
</FORM>
<script>
populateValues('','ONLOAD');
</script>
</BODY>
<%
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
</HTML>

