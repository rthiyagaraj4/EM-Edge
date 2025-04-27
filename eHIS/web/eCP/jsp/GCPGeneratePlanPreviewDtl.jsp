<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
23/05/2012    IN031808       Menaka V     		All the interventions has been attached to the respective frequencies in the function
												�Frequency For Interventions� in CA . However in the Generate Care Plan function , all the frequencies are displaying double .
-----------------------------------------------------------------------
-->
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Jerome
*	Created On		:	19/01/2005
* --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<html>
<title><fmt:message key="eCP.GeneratePlanDetail.label" bundle="${cp_labels}"/>
</title>
<script language="javascript">

var headTop = -1;
var FloatHead1;

function processScroll()
{
if (headTop < 0)
{
 saveHeadPos();
}
if (headTop>0)
{
if (document.documentElement && document.documentElement.scrollTop)
theTop = document.documentElement.scrollTop;
else if (document.body)
theTop = document.body.scrollTop;

if (theTop>headTop)
FloatHead1.style.top = (theTop-headTop) + 'px';
else
FloatHead1.style.top = '0px';
}
}

function saveHeadPos()
{
parTable = document.getElementById("headStart");
if (parTable != null)
{
headTop = parTable.offsetTop + 3;
FloatHead1 = document.getElementById("head1");
FloatHead1.style.position = "relative";
}
}
window.onscroll = processScroll;
</script>
<head>
	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCP/js/GCPGeneratePlanMenu.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script language ="JavaScript" src ="../../eCommon/js/common.js"></Script>
<Script language ="JavaScript" src ="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
</head>
<%
String mode			 = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
mode = "insert";
String patient_id	 = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounter_id	 = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");	
String goal_stmt	 = request.getParameter("goal_st")==null?"":request.getParameter("goal_st");
String selected_diagnosis = request.getParameter("selected_diag")==null?"":request.getParameter("selected_diag");
eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
java.util.Date date_time	 	= new java.util.Date();
String dateString 				= com.ehis.util.DateUtils.convertDate(dtSystemFormat.format(date_time),"DMYHM","en",locale);
boolean lib_flag=false;

StringBuffer sql		= new StringBuffer() ;
StringBuffer sql_select = new StringBuffer() ;
//StringBuffer sqlFrequency = new StringBuffer() ;

String sql_stage="",sql_posn="";
String classValue ="";
String intrvn_code_set="";
String interven_code="",tmp_interven_code="",group_id="";
String library_id="",term_set_id="",term_code="",goal_code="",intervention_code="",outcome_code="",target_date="";
String place_holder_val="";
String tmp_sel_diag ="",tmp_sel_diag1="";
String dayslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
String monthslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Months.label","cp_labels");
String minuteslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
String weekslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Weeks.label","cp_labels");
String hourslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
int version_no=0;
Connection con = null;
PreparedStatement ps = null,ps1 = null,pstmt = null,ps2=null;
ResultSet rs = null,rs1 = null,rs2 = null,rs3=null;
int i=0;
if(patient_id.equals("")){
	patient_id = bean.getPatientId();
}
goal_stmt = bean.getGoalStmt();
	
if(selected_diagnosis.equals("")){
	HashMap codeKeyValue = new HashMap();
	codeKeyValue =  bean.getSelectedIntvn();
	Set s=codeKeyValue.keySet();
	Object[] record =  s.toArray();
	ArrayList keyList=new ArrayList();
	for(int k=0;k<record.length;k++)
		keyList.add(record[k].toString());
	String record1= "";
	for(int c=0;c<keyList.size();c++){
		record1 = (String)keyList.get(c);
	if(record1.indexOf("#")==-1){
		tmp_sel_diag = (String)codeKeyValue.get(record1);
		if(keyList.contains("#"+record1)){
			tmp_sel_diag1 = (String)codeKeyValue.get("#"+record1);
			if(tmp_sel_diag1!= null){
				tmp_sel_diag1=tmp_sel_diag1.substring(0,tmp_sel_diag1.indexOf("~"));
				tmp_sel_diag = tmp_sel_diag.substring(0,tmp_sel_diag.indexOf("|,")+1)+tmp_sel_diag1+tmp_sel_diag.substring(tmp_sel_diag.indexOf("|,")+1);
			}
		}
		if(tmp_sel_diag!= null)
			selected_diagnosis =selected_diagnosis +  record1+tmp_sel_diag;                
	}
	}
}
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="gen_preview_details" id="gen_preview_details"  method ='post' target='messageFrame' action='../../servlet/eCP.GCPGeneratePlanServlet'>
<%
try{
	if(!selected_diagnosis.equals("")){
		
		String values="";int tcnt=0,outcnt=0,intvcnt=0;
		StringTokenizer stk= new StringTokenizer(selected_diagnosis,"~");
		//int cnt = stk.countTokens();
		while(stk.hasMoreTokens()){
			values= stk.nextToken();
			StringTokenizer stk1= new StringTokenizer(values,",");
			while(stk1.hasMoreTokens()){
				library_id=stk1.nextToken();
				if(stk1.hasMoreTokens())
					version_no=Integer.parseInt(stk1.nextToken());
				if(stk1.hasMoreTokens())
					term_set_id=stk1.nextToken();
				if(stk1.hasMoreTokens())
					term_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					goal_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					target_date=stk1.nextToken();
				if(stk1.hasMoreTokens())
					intervention_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					outcome_code=stk1.nextToken();

				place_holder_val =place_holder_val + "('"+(library_id)+ "',"+(version_no)+",'"+(term_set_id)+ "','"+(term_code)+ "','"+(goal_code)+ "')," ;  ;
			
				outcnt=0;	
				StringTokenizer stk2= new StringTokenizer(outcome_code,"|");
				while(stk2.hasMoreTokens()){
					outcome_code=stk2.nextToken();
					group_id = outcome_code.substring((outcome_code.indexOf("*")+1),outcome_code.length());
					outcome_code=outcome_code.substring(0,(outcome_code.indexOf("*")));
%>
				<input type ='hidden' name='outcome_code<%=outcnt%><%=tcnt%>' id='outcome_code<%=outcnt%><%=tcnt%>' value='<%=outcome_code%>'>	
				<input type ='hidden' name='out_group_id<%=outcnt%><%=tcnt%>' id='out_group_id<%=outcnt%><%=tcnt%>' value='<%=group_id%>'>	
<%
					outcnt++;
				}
				intvcnt=0;
			StringTokenizer stk3= new StringTokenizer(intervention_code,"|");
				while(stk3.hasMoreTokens()){
					intervention_code=stk3.nextToken();
					group_id =intervention_code.substring((intervention_code.indexOf("*")+1),intervention_code.length());
					intervention_code=intervention_code.substring(0,(intervention_code.indexOf("*")));
				if(intrvn_code_set.equals(""))
					intrvn_code_set ="\'"+intervention_code+"\'";
				else
					intrvn_code_set=intrvn_code_set+",\'"+intervention_code+"\'";
				%>
				<input type ='hidden' name='intervent_code<%=intvcnt%><%=tcnt%>' id='intervent_code<%=intvcnt%><%=tcnt%>' value='<%=intervention_code%>'>
				<input type ='hidden' name='int_group_id<%=intvcnt%><%=tcnt%>' id='int_group_id<%=intvcnt%><%=tcnt%>' value='<%=group_id%>'>	
<%		
					intvcnt++;
				}	
								
			}
%>
			<input type ='hidden' name='library_id<%=tcnt%>' id='library_id<%=tcnt%>' value='<%=library_id%>'>	
			<input type ='hidden' name='version_no<%=tcnt%>' id='version_no<%=tcnt%>' value='<%=version_no%>'>
			<input type ='hidden' name='term_set_id<%=tcnt%>' id='term_set_id<%=tcnt%>' value='<%=term_set_id%>'>
			<input type ='hidden' name='term_code<%=tcnt%>' id='term_code<%=tcnt%>' value='<%=term_code%>'>
			<input type ='hidden' name='goal_code<%=tcnt%>' id='goal_code<%=tcnt%>' value='<%=goal_code%>'>
			<input type ='hidden' name='target_date<%=tcnt%>' id='target_date<%=tcnt%>' value='<%=target_date%>'>
			<input type ='hidden' name='out_cnt<%=tcnt%>' id='out_cnt<%=tcnt%>' value='<%=outcnt%>'>	
			<input type ='hidden' name='intv_cnt<%=tcnt%>' id='intv_cnt<%=tcnt%>' value='<%=intvcnt%>'>	
<%	
		if(lib_flag){
			lib_flag=false;
		}
		else
			tcnt++;	
		}
%>
	<input type ='hidden' name='tcode_cnt' id='tcode_cnt' value='<%=tcnt%>'>
<% 
	}
	if(place_holder_val	.length()>0){
		place_holder_val	= place_holder_val.substring(0,place_holder_val.length()-1);
		
	}else{
		place_holder_val = "('','','','','')";
	}

HashMap inter_details = null;
String sel_inter_code=intrvn_code_set;
if(sel_inter_code.equals(""))
	sel_inter_code = "''";
	inter_details =bean.getInterDetail();
	con = ConnectionManager.getConnection(request);

/*	sql.append("SELECT A.INTERVENTION_CODE,A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC ,A.SHORT_DESC Intervention_Desc FROM CA_INTERVENTION A, CA_INTERVENTION_TYPE B WHERE A.INTERVENTION_TYPE=B.INTERVENTION_TYPE AND A.INTERVENTION_CODE IN(");
	sql.append(sel_inter_code);
	sql.append(")AND A.EFF_STATUS='E' AND B.EFF_STATUS='E' order by 3,4 "); */
	sql.append("SELECT A.INTERVENTION_CODE,A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC ,A.SHORT_DESC Intervention_Desc FROM CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE A.INTERVENTION_TYPE=B.INTERVENTION_TYPE AND A.INTERVENTION_CODE IN(");
	sql.append(sel_inter_code);
	sql.append(")AND A.EFF_STATUS='E' AND B.EFF_STATUS='E' AND A.LANGUAGE_ID ='");
	sql.append(locale);
	sql.append("' AND B.LANGUAGE_ID = A.LANGUAGE_ID order by 3,4 ");
	/*
	sql_select.append("SELECT   a.freq_code code, b.freq_desc description, d.freq_durn, d.freq_durn_unit, DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)',  '' ) freq_durn_unit_legend, DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI' ),  'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, MIN (  NVL (rel_start_period, 0) * DECODE (rel_start_period_unit,  'M', 1, 'H', 60, 'D', 1440, 'W', 10080, 'L', 43200, 0) ) rel_start_min, 'Y' default_yn FROM ca_intervention_freq a, am_frequency b, am_duration_type c, (SELECT a.freq_code, freq_durn_unit, a.freq_durn, rel_start_period, rel_start_period_unit FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit, DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ), DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit, DECODE (b.repeat_durn_type, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', '' ) freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ? AND b.freq_code = a.freq_code) ORDER BY 8 desc, 2");
	*/
	sql_select.append("SELECT   a.freq_code code, b.freq_desc description, d.freq_durn, d.freq_durn_unit,d.freq_durn_unit freq_durn_unit_legend, DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI' ),  'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, MIN (  NVL (rel_start_period, 0) * DECODE (rel_start_period_unit,  'M', 1, 'H', 60, 'D', 1440, 'W', 10080, 'L', 43200, 0) ) rel_start_min, 'Y' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b, am_duration_type c, (SELECT a.freq_code, freq_durn_unit, a.freq_durn, rel_start_period, rel_start_period_unit FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	//sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) and b.language_id = ? GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit,DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ),DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit,b.repeat_durn_type freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");//IN031808
	sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) and b.language_id = ? GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit,DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ),DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit,b.repeat_durn_type freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? and b.language_id = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");//IN031808
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ? AND b.freq_code = a.freq_code  and b.language_id = ?) ORDER BY 8 desc, 2");

//	sql_stage = "SELECT DISTINCT CP_STAGE.STAGE_CODE,SHORT_DESC CARE_PLAN_STAGE FROM CP_STAGE ,CP_LIBRARY_INTERVENTION A WHERE EFF_STATUS='E' AND (A.LIBRARY_ID,A.VERSION_NO,A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE) IN ("+place_holder_val+") AND   A.INTERVENTION_CODE = ? ORDER BY 2 ";
	sql_stage = "SELECT DISTINCT CP_STAGE.STAGE_CODE,SHORT_DESC CARE_PLAN_STAGE FROM CP_STAGE_lang_vw CP_STAGE,CP_LIBRARY_INTERVENTION A WHERE EFF_STATUS='E' AND (A.LIBRARY_ID,A.VERSION_NO,A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE) IN ("+place_holder_val+") AND   A.INTERVENTION_CODE = ? AND CP_STAGE.LANGUAGE_ID = ? ORDER BY 2";
	
//	sql_posn = "SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) ORDER BY 2";
	sql_posn = "SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION_LANG_VW AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) AND LANGUAGE_ID = ? ORDER BY 2";
//System.err.println("@@@PLACE : "+place_holder_val);
	ps = con.prepareStatement(sql.toString());
	rs = ps.executeQuery();
	pstmt = con.prepareStatement(sql_select.toString());
	ps1 = con.prepareStatement(sql_stage);
	ps2 = con.prepareStatement(sql_posn);
%>
	<div id="headStart" style="position: absolute;">	
	<table border='0' cellspacing='0' cellpadding='3' width='132%' height='' align='center' id="partTable">
	<tr id="head1">
			
			<th height='1%' width='3%' class='PLANSUBHEAD1'><font size="1" color="">&nbsp;</font></th>
			<th height='1%' width='21%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></font></th> 
			<th height='1%' width='15%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></font></th>
			<th height='1%' width='7%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></font></th>
			<th height='1%' width='14%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.duration.label" bundle="${common_labels}"/></font></th>
			<th height='1%' width='15%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></font></th>
			<th height='1%' width='10%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></font></th> 
			<th height='1%' width='8%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.priority.label" bundle="${common_labels}"/></font></th>
			<th height='1%' width='11%' class='PLANSUBHEAD1'><font size="1" color=""><fmt:message key="Common.Position.label" bundle="${common_labels}"/></font></th>
	</tr>
<%
		while(rs.next()){
			String inter_type="";
			
			if ( i % 2 == 0 )
				classValue = "GRPEVEN" ;
			else
				classValue = "GRPEVEN" ;

			/********************/
			String freq_cd="",dur="",dur_unit="",dur_unit_legd="";
						
			String  selected = "",tmp_value="";
			String temp_inter_val="";
			String tmp_st_date="", tmp_stage="*A", tmp_postn=" ",tmp_prior="", tmp_date="",tmp_fre_cd="",tmp_dur="",tmp_other_freq="",tmp_dur_unit="",tmp_dur_unit1="";
			temp_inter_val = (String)inter_details.get(rs.getString(1));
			if(temp_inter_val!= null){
				StringTokenizer stk=new StringTokenizer(temp_inter_val,",");
				while(stk.hasMoreTokens()){
					tmp_stage=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_prior=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_postn=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_st_date= com.ehis.util.DateUtils.convertDate(stk.nextToken(),"DMYHM","en",locale);
					if(stk.hasMoreTokens())
						tmp_fre_cd= stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_dur= stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_dur_unit1= stk.nextToken();
					
					if(tmp_dur_unit1.equals("D"))
						tmp_dur_unit = dayslegend;
					else if(tmp_dur_unit1.equals("H"))
						tmp_dur_unit = hourslegend;
					else if(tmp_dur_unit1.equals("M"))
						tmp_dur_unit = minuteslegend;
					else if(tmp_dur_unit1.equals("L"))
						tmp_dur_unit = monthslegend;
					else if(tmp_dur_unit1.equals("W"))
						tmp_dur_unit = weekslegend;
					if(stk.hasMoreTokens())
						tmp_date= com.ehis.util.DateUtils.convertDate(stk.nextToken(),"DMYHM","en",locale);
					if(stk.hasMoreTokens())
						tmp_other_freq= stk.nextToken();
				}
			}
			
			/*********************/
			interven_code=rs.getString(1);inter_type=rs.getString(2);
			if(!tmp_interven_code.equals(inter_type.trim()))	{	
%>
	<tr>
		<td class='GRPEVEN1' height='1%' width = '' colspan='10'>
		<font size="1"><B><%=rs.getString(3)%></B></font></td>
    </tr>
	
<%
		tmp_interven_code = inter_type;//inter_type="O";
	}
	String classValue1="";
	if(inter_type.equals("O"))
		classValue1= "ORDERS";
	else
		classValue1=classValue;
%>
		
	<tr>
		<td class='<%=classValue%>' height='1%' width = '' align='center'><FONT SIZE="3" class='<%=classValue1%>' >&nbsp;&nbsp;</FONT></td>	
		<td class='<%=classValue%>' height='1%' width = '' colspan=''><font size="1"  color=""> <B> <%=rs.getString(4)%></B></font></td>
		<td class='<%=classValue%>' height='1%' width = '' align='center' ><font size="1" color="">
			<input type="text" name="st_date<%=i%>" id="st_date<%=i%>" value='<%=tmp_st_date==""?dateString:tmp_st_date%>'  size='15' onBlur='checkValidDateTime(this);chkDate(this,<%=i%>);calculateEndDt("<%=i%>",true,"dur_type");'' style='font-size:7pt'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("st_date<%=i%>",null,"hh:mm",true);'  onBlur='retFocus("st_date","<%=i%>")' ></font></td>
		<td class='<%=classValue%>' height='1%' width = '' align='left'><font size="1" color="">
		<select name="freq_select<%=i%>" id="freq_select<%=i%>" onChange='chkDuration(<%=i%>,true);' style='font-size:7pt;'>
		
<% 
	//System.err.println("@@@INTVN : "+interven_code);
		pstmt.setString(1,interven_code);
		pstmt.setString(2,interven_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,interven_code);
		pstmt.setString(5,locale);//IN031808
		pstmt.setString(6,interven_code);
		pstmt.setString(7,locale);
		String end_dt="";
		String rel_prd="";
		String default_yn="";
		int rel_start_prd=0,rel_start_prd1=0;
		rs1 = pstmt.executeQuery();
		dur="";
		dur_unit="";
		dur_unit_legd="";
		end_dt="";
		while(rs1.next())
		{  
				freq_cd = rs1.getString(1)==null?"0":rs1.getString(1);
				tmp_value = rs1.getString(1)+","+rs1.getString(3)+","+rs1.getString(4);
				if(rel_prd.equals("")){
					rel_prd = rs1.getString(7)==null?"0":rs1.getString(7);
					rel_start_prd1 = Integer.parseInt(rel_prd);
				}else{
					if(rs1.getString(7) != null){
						if(!(rel_start_prd1 >rs1.getInt(7))){
							rel_start_prd =rs1.getInt(7);
							rel_start_prd1=rs1.getInt(7);
						}
					}
					else{
						rel_start_prd =0;
						rel_start_prd1=0;
					}
				}
				selected = "";
			default_yn=rs1.getString("default_yn")==null?"":rs1.getString("default_yn");
			if(default_yn.equalsIgnoreCase("Y")){
				dur = rs1.getString(3)==null?"0":rs1.getString(3);
				dur_unit = rs1.getString(4)==null?"":rs1.getString(4);
				dur_unit_legd = rs1.getString(5)==null?"":rs1.getString(5);
				end_dt = rs1.getString(6)==null?"":com.ehis.util.DateUtils.convertDate(rs1.getString(6),"DMYHM","en",locale);
				selected="selected";
%>
				<option value='<%=tmp_value%>' style='background-color:#FFA8A8;color:<%=select_color(rs1.getString(1),tmp_fre_cd,"#FFFFFF")%>' <%=select(rs1.getString(1),tmp_fre_cd)%>><%=rs1.getString(2).trim()%></option>
<%   		
			}
			else{
				selected="";
				if(dur.equals(""))
					dur = rs1.getString(3)==null?"0":rs1.getString(3);
				if(dur_unit.equals("")){
					dur_unit = rs1.getString(4)==null?"":rs1.getString(4);
				}
				else{
					if((rs1.getString(4)!=null)&&(tmp_fre_cd.equals(freq_cd))){
						if(!tmp_dur_unit1.equals("")){
							dur_unit=rs1.getString(4);
						}
					}
				}
				if(dur_unit_legd.equals(""))
					dur_unit_legd = rs1.getString(5)==null?"":rs1.getString(5);
				if(dur_unit_legd.equals("")) 
					dur_unit_legd="";
				if(dur_unit_legd.equals("D")) 
					dur_unit_legd =dayslegend;
				if(dur_unit_legd.equals("H"))
					dur_unit_legd=hourslegend;
				if(dur_unit_legd.equals("M")) 
					dur_unit_legd= minuteslegend;
				if(dur_unit_legd.equals("L")) 
					dur_unit_legd= monthslegend;
				if(dur_unit_legd.equals("W")) 
					dur_unit_legd=weekslegend;

				if(end_dt.equals(""))
					end_dt = rs1.getString(6)==null?"":com.ehis.util.DateUtils.convertDate(rs1.getString(6),"DMYHM","en",locale);
%>
				<option value='<%=tmp_value%>' style='color:#990000' <%=select(rs1.getString(1),tmp_fre_cd)%>><%=rs1.getString(2).trim()%></option>
<%
			}
		} 
%>
		<BR><label id='other_freq<%=i%>' class='label' style='font-size:7pt'><%=tmp_other_freq%></label>
		</font></td>
		<td class='<%=classValue%>' height='1%' width = '' align='center' class='<%=classValue%>' id='chk_durn<%=i%>'>
			<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" value='<%=tmp_dur==""?dur:tmp_dur%>' size='1'  maxlength='2' onBlur='CheckNum(this);calculateEndDt("<%=i%>",true,"dur_type");' style='font-size:7pt' ><font size="1" >
			<label class='label' id='durn<%=i%>' style='font-size:7pt'><!-- <%=tmp_dur_unit==""?dur_unit_legd:tmp_dur_unit%> -->
			</label></font>
			<select name="dur_type<%=i%>" id="dur_type<%=i%>" onChange='calculateEndDt("<%=i%>",true,"dur_type")' style='font-size:7pt'>
<%	
				char ch_durn_unit=' ';
				if(tmp_dur_unit1.equals(""))
					tmp_dur_unit1 = dur_unit;
				if(!dur_unit.equals(""))
					ch_durn_unit=dur_unit.charAt(0);
				else if(!tmp_dur_unit1.equals(""))
					ch_durn_unit=tmp_dur_unit1.charAt(0);

				switch(ch_durn_unit){
					case 'M' :
%>
						<option value="M" style="color:<%=select_color(tmp_dur_unit1,"M","#990000")%>" <%=select(tmp_dur_unit1,"M")%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
<%			
					case 'H':
%>
						<option value="H" style="color:<%=select_color(tmp_dur_unit1,"H","#990000")%>" <%=select(tmp_dur_unit1,"H")%>><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
<%
					case 'D':
%>
						<option value="D" style="color:<%=select_color(tmp_dur_unit1,"D","#990000")%>" <%=select(tmp_dur_unit1,"D")%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
	<%
					case 'W':
%>
					<option value="W" style="color:<%=select_color(tmp_dur_unit1,"W","#990000")%>" <%=select(tmp_dur_unit1,"W")%>><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/></option>
<%
					case 'L':
%>
						<option value="L" style="color:<%=select_color(tmp_dur_unit1,"L","#990000")%>" <%=select(tmp_dur_unit1,"L")%>><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
<%
							break;
					default:
%>
						<option value="M" style="color:<%=select_color(tmp_dur_unit1,"M","#990000")%>" <%=select(tmp_dur_unit1,"M")%>><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
						<option value="H" style="color:<%=select_color(tmp_dur_unit1,"H","#990000")%>" <%=select(tmp_dur_unit1,"H")%>><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/> </option>
						<option value="D" style="color:<%=select_color(tmp_dur_unit1,"D","#990000")%>" <%=select(tmp_dur_unit1,"D")%>><fmt:message key="Common.days.label" bundle="${common_labels}"/> </option>
						<option value="W" style="color:<%=select_color(tmp_dur_unit1,"W","#990000")%>" <%=select(tmp_dur_unit1,"W")%>><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/> </option>
						<option value="L" style="color:<%=select_color(tmp_dur_unit1,"L","#990000")%>" <%=select(tmp_dur_unit1,"L")%>><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
<%
				}
%>
			</select>
		</td>
		<td class='<%=classValue%>' height='1%' width = '' align='center'><font size="1">
			<input type="text" name="end_date<%=i%>" id="end_date<%=i%>" value='<%=tmp_date==""?end_dt:tmp_date%>'  size='15' onBlur='checkValidDateTime(this);checkGRDate(st_date<%=i%>,this);chkEndDate("<%=i%>")' style='font-size:7pt'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("end_date<%=i%>",null,"hh:mm",true);'  onBlur='retFocus("end_date","<%=i%>")'></font>
		</td>
		<td class='<%=classValue%>' height='1%' width = '' align='left' colspan=''><font size="1"> <!-- <B>Stage:</B></font>&nbsp; -->
			<select name="intvn_stage<%=i%>" id="intvn_stage<%=i%>" style='font-size:7pt'>
			<option value="*A" <%=select(tmp_stage,"*A")%> >--- <fmt:message key="Common.all.label" bundle="${common_labels}"/> ---</option>
<%
			ps1.setString(1,interven_code);
			ps1.setString(2,locale);
			rs2 =ps1.executeQuery();
			while(rs2.next()){
%>
				<option value='<%=rs2.getString(1)%>' style="color:<%=select_color(rs2.getString(1),tmp_stage,"#990000")%>" <%=select(rs2.getString(1),tmp_stage)%>><%=rs2.getString(2).trim()%></option>
					
<%
			}
%>
			</select></td>
		<td class='<%=classValue%>' height='1%' width = '' colspan='' align='center'><font size="1" >
			<select name="prior<%=i%>" id="prior<%=i%>" style='font-size:7pt'>
				<option value="N" style="color:<%=select_color(tmp_prior,"N","#990000")%>" <%=select(tmp_prior,"N")%>><fmt:message key="Common.Normal.label" bundle="${common_labels}"/>  </option>
				<option value="H" style="color:<%=select_color(tmp_prior,"H","#990000")%>" <%=select(tmp_prior,"H")%>><fmt:message key="Common.High.label" bundle="${common_labels}"/>    </option>
				<option value="C" style="color:<%=select_color(tmp_prior,"C","#990000")%>" <%=select(tmp_prior,"C")%>><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></option>
			</select>
		</td> 
		
		<td class='<%=classValue%>' height='1%' width = '' align='left'>
			<select name="postn<%=i%>" id="postn<%=i%>" style='font-size:7pt'>
			<option value=" ">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			ps2.setString(1,interven_code);
			ps2.setString(2,locale);
			rs3 =ps2.executeQuery();
			while(rs3.next()){  
%>
				<option value='<%=rs3.getString(1)%>' style="color:<%=select_color(rs3.getString(1),tmp_postn,"#990000")%>" <%=select(rs3.getString(1),tmp_postn)%>><%=rs3.getString(2).trim()%></option>
			   		
<%	
			}
%>
			</select>
		</td>
	</tr>	
	
	<input type ='hidden' name='temp_inter_val<%=i%>' id='temp_inter_val<%=i%>' value='<%=temp_inter_val%>'> 
	<input type ='hidden' name='inter_code<%=i%>' id='inter_code<%=i%>' value='<%=rs.getString(1)%>'>
	<input type ='hidden' name='intervention_type<%=i%>' id='intervention_type<%=i%>' value='<%=rs.getString(2)%>'>
	<input type ='hidden' name='freq_code<%=i%>' id='freq_code<%=i%>' value='<%=tmp_fre_cd==""?freq_cd:tmp_fre_cd%>'>
	<input type ='hidden' name='duration<%=i%>' id='duration<%=i%>' value='<%=tmp_dur==""?dur:tmp_dur%>'>
	<input type ='hidden' name='durn_type<%=i%>' id='durn_type<%=i%>' value='<%=tmp_dur_unit1==""?dur_unit:tmp_dur_unit1%>'>
	<input type ='hidden' name='start_date<%=i%>' id='start_date<%=i%>' value='<%=dateString%>'>
	<input type ='hidden' name='rel_start_prd<%=i%>' id='rel_start_prd<%=i%>' value='<%=rel_start_prd%>'>

<%
		i++;	
	}
%>
	<input type ='hidden' name='count' id='count' value='<%=i%>'>
	<input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
	<input type ='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type ='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
	<input type ='hidden' name='goal_stmt' id='goal_stmt' value='<%=goal_stmt%>'>
	<input type ='hidden' name='care_plan_start_date' id='care_plan_start_date' value='<%=dateString%>'>
	<input type ='hidden' name='care_plan_end_date' id='care_plan_end_date' value='<%=dateString%>'>
	<input type ='hidden' name='target_date' id='target_date' value='<%=dateString%>'>
	<input type ='hidden' name='selected_diagnosis' id='selected_diagnosis' value='<%=selected_diagnosis%>'>
	<input type ='hidden' name='curr_care_manager' id='curr_care_manager' value=''>	
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
	<input type ='hidden' name='freq_sql' id='freq_sql' value="select freq_code code,freq_desc description,repeat_durn_type from am_frequency where eff_status = 'E' and upper(freq_code) like upper(?) and upper(freq_desc) like  upper(?)">
</table>	
</div>

<%
	if(selected_diagnosis.equals("") && i==0){
			out.println("<script>alert(getMessage('NO_INTERVENTION_SELECTED','CP'));</script>");

		}

	}
	catch(Exception ee)
	{
		//out.println("Exception in Generate Preview "+ee.toString());//common-icn-0181
		ee.printStackTrace();
	}
	finally
	{
		try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(ps1 != null) ps1.close();
				if(ps2 != null) ps2.close();
				if(rs1 != null) rs1.close();
				if(pstmt != null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){out.println(e);}
	}

%>

</form>
</body>
</html>
<%!
	String select(String str1, String str2){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
			return "selected";
			else
			return "";
	}
	String select_color(String str1, String str2,String color){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
				return color;
			else
				return "";
	}
%>
<script>
//to set the default value to the duration type list
var i = parseInt(document.gen_preview_details.count.value);
var plan_start_dt =parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value
for(var tmp=0;tmp<i;tmp++){
	var tmp_value="";
	var freq_durn_value="";var freq_durn_unit="";var st_date ="";
	var durnUnit;
	if(eval("document.gen_preview_details.st_date"+tmp)!= undefined)
		st_date = eval("document.gen_preview_details.st_date"+tmp).value;
	st_date = plan_start_dt ;
	if(eval("document.gen_preview_details.rel_start_prd"+tmp)!= undefined)
		var rel_start_prd = eval("document.gen_preview_details.rel_start_prd"+tmp).value;
	var fromarray;
	var fromDt;
	var timarray;
	var finalDt="";
	if(st_date.length > 0)
	{
		fromDt = st_date.split(" ");
		fromarray = fromDt[0].split("/");
				
		timarray = fromDt[1].split(":");
		var dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		dt.setHours(timarray[0], timarray[1]);
		timarray[1]=dt.getMinutes()+parseInt(rel_start_prd);
		dt.setHours(timarray[0], timarray[1]);
		var date= ""+dt.getDate()+"";
		var month= ""+parseInt(dt.getMonth()+1)+"";
		var hours= ""+dt.getHours()+"";
		var minutes= ""+dt.getMinutes()+"";
		if(date.length == 1)
			date="0"+date;
		if(month.length == 1)
			month="0"+month;
		if(hours.length == 1)
			hours="0"+hours;
		if(minutes.length == 1)
			minutes="0"+minutes;
		finalDt = finalDt +date + "/";
		finalDt = finalDt +month + "/";
		finalDt = finalDt +dt.getFullYear() + " ";
		finalDt = finalDt +hours + ":";
		finalDt = finalDt +minutes ;
		if(eval("document.gen_preview_details.st_date"+tmp)!= undefined)
			eval("document.gen_preview_details.st_date"+tmp).value = finalDt;
	}
	if(eval("document.gen_preview_details.temp_inter_val"+tmp)!= undefined)
	{
		if(eval("document.gen_preview_details.temp_inter_val"+tmp).value == "null")
		{
			if(eval("document.gen_preview_details.freq_select"+tmp)!= undefined)
				var tmp_value=eval("document.gen_preview_details.freq_select"+tmp).options[0].value;
			durnUnit = tmp_value.split(",");
			if(durnUnit.length>0){
				if(eval("document.gen_preview_details.durn_value"+tmp)!= undefined)
					eval("document.gen_preview_details.durn_value"+tmp).value =durnUnit[1];
				freq_durn_unit = durnUnit[2];
				if(eval("document.gen_preview_details.dur_type"+tmp)!= undefined)
				{
					var freq_unit_length=eval("document.gen_preview_details.dur_type"+tmp).length;
					for(i1=0;i1<freq_unit_length;i1++){
						var val=eval("document.gen_preview_details.dur_type"+tmp).options[i1].value;
						if(freq_durn_unit == val){
							eval("document.gen_preview_details.dur_type"+tmp).options[0].selected = true ;
							eval("document.gen_preview_details.dur_type"+tmp).options[0].style.color = "#990000" ;
						}
					}
				}
			/*	if(freq_durn_unit == 'M'){
					eval("document.gen_preview_details.dur_type"+tmp).options[0].selected = true ;
					eval("document.gen_preview_details.dur_type"+tmp).options[0].style.color = "#990000" ;
				}else if(freq_durn_unit == 'H'){
					eval("document.gen_preview_details.dur_type"+tmp).options[1].selected = true ;
					eval("document.gen_preview_details.dur_type"+tmp).options[1].style.color = "#990000" ;
				}else if(freq_durn_unit == 'D'){
					eval("document.gen_preview_details.dur_type"+tmp).options[2].selected = true ;
					eval("document.gen_preview_details.dur_type"+tmp).options[2].style.color = "#990000" ;
				}else if(freq_durn_unit == 'W'){
					eval("document.gen_preview_details.dur_type"+tmp).options[3].selected = true ;
					eval("document.gen_preview_details.dur_type"+tmp).options[3].style.color = "#990000" ;
				}else if(freq_durn_unit == 'L'){
					eval("document.gen_preview_details.dur_type"+tmp).options[4].selected = true ;
					eval("document.gen_preview_details.dur_type"+tmp).options[4].style.color = "#990000" ;
				}else if(freq_durn_unit == "null" || freq_durn_unit == '' ){
				}*/
				//eval("document.gen_preview_details.freq_select"+tmp).options[1].selected = true ;
				//eval("document.gen_preview_details.freq_select"+tmp).options[1].style.color = "#FFFFFF" ;
				//eval("document.gen_preview_details.freq_select"+tmp).options[1].style.backgroundColor = "#FFA8A8" ;
				if(eval("document.gen_preview_details.freq_code"+tmp)!= undefined)
					eval("document.gen_preview_details.freq_code"+tmp).value = durnUnit[0];
			}
		}
	}
calculateEndDt(tmp,'true','dur_type');
chkStage("gen_preview_details");
	
}
</script>

