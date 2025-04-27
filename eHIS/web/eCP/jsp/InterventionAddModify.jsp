<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 								 
-----------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>



<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.*,eCP.*, eCommon.Common.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/Intervention.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String mode=request.getParameter("mode");
  Connection con=null;

  Statement Intervention_stmt=null;
  ResultSet Intervention_rs=null;
  Statement Intervention_durn_stmt=null;
  ResultSet Intervention_durn_rs=null;
  Statement Intervention_result_stmt=null;
  ResultSet Intervention_result_rs=null;
  PreparedStatement Intervention_modify_pstmt=null;
  ResultSet Intervention_modify_rset=null;
  PreparedStatement result_measure_pstmt=null;
  ResultSet result_measure_rset=null;

  String Intervention_sql="";
  String intervention_type="";
  String intervention_desc="";

  try
  {
  con=ConnectionManager.getConnection(request);	
  Intervention_stmt=con.createStatement();

 // Intervention_sql="select intervention_type,short_desc from ca_intervention_type where eff_status = 'E' order by short_desc";
  Intervention_sql="SELECT intervention_type,short_desc FROM ca_intervention_type_lang_vw WHERE eff_status = 'E' and language_id = '"+locale+"' and SYSTEM_DEFINED_YN='N' ORDER BY short_desc";

  Intervention_rs= Intervention_stmt.executeQuery(Intervention_sql);
  //***********************************************************************

  String Intervention_durn_sql="";
  String durn_type[]=new String[5];
  String durn_desc[]=new String[5];

  int i=0;
  int size=0;

  Intervention_durn_stmt=con.createStatement();

  //Intervention_durn_sql="select durn_type, durn_desc from am_duration_type order by durn_desc";
  Intervention_durn_sql="SELECT durn_type, durn_desc FROM am_duration_type_lang_vw where language_id = '"+locale+"' ORDER BY durn_desc";

  Intervention_durn_rs= Intervention_durn_stmt.executeQuery(Intervention_durn_sql);
  		try{
		   if(Intervention_durn_rs!=null)
		     {
			 while(Intervention_durn_rs.next())
			  {
					durn_type[i]= Intervention_durn_rs.getString("durn_type");
					durn_desc[i]=  Intervention_durn_rs.getString("durn_desc");
					i++;
					size=Intervention_durn_rs.getRow();
			  }	
			 }	 
			
		}catch(Exception exp){exp.toString();} 

//******************************************************************

  String Intervention_result_sql="";
  String result_type="";
  String result_type_desc="";

  Intervention_result_stmt=con.createStatement();

  //Intervention_result_sql="select result_type, result_type_desc from ca_result_type order by result_type_desc";
  Intervention_result_sql="SELECT result_type, result_type_desc FROM ca_result_type_lang_vw where language_id = '"+locale+"' and result_type not in('NT') ORDER BY result_type_desc";

  Intervention_result_rs= Intervention_result_stmt.executeQuery(Intervention_result_sql);

  //**********************************************************************
 String patient_instructions_id = "";  //IN030473
 String patient_instructions_description ="";   //IN030473
 PreparedStatement patient_instructions_pstmt=null;
 ResultSet patient_instructions_rset=null;
%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement();CheckMandatoryResult();">
<form name="Intervention_form" id="Intervention_form" action="../../servlet/eCP.InterventionServlet" method="post" target="messageFrame">
 <table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<% 
if(mode.equals("1"))
{
%>
  <tr>
  <td colspan="5">&nbsp;</td>
  </tr>
 
  <tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  align="left" >
      &nbsp;&nbsp;&nbsp;<input type="text" name="intervention_code" id="intervention_code" size="10" value='' maxlength="10" onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event)"> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>
  <tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="50" value='' maxlength="60" onBlur='makeValidString(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;&nbsp;<TextArea name="long_desc" cols="50" rows="3" onKeyPress=" checkMaxLimit(this,400)" value='1' onBlur="callCheckMaxLength(this,400);makeValidString(this);" style='{ font-size: ;}'></textarea>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
   <tr>
	<td  align="left" class="label" width="25%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>&nbsp;</td>
    </tr>
 
     </table>
   <table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<tr>
<th align="left" colspan="5">&nbsp;<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></th>
</tr>
  <tr>
	
	<td  align="left" class="label" width="45%"><fmt:message key="Common.InterventionType.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<select name="intervention_type" id="intervention_type" onchange="ChangeList(this);">
    	  <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		 <%
		try{
		   if(Intervention_rs!=null)
		     {
			 while(Intervention_rs.next())
			  {
					intervention_type= Intervention_rs.getString("intervention_type");
					intervention_desc=  Intervention_rs.getString("short_desc");
    	 %>
		 <option value="<%=intervention_type%>"><%=intervention_desc%></option>
		 <%}}}catch(Exception exp){exp.toString();} %>
	  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<select name="dependency" id="dependency" onchange="ChangeList(this);">
    <option value="">----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option>
  	<% 
			 for(int count=1;count<10;count++){	  
	 %>
		 <option value="<%=count%>"><%=count%></option>
		 <%} %>
	  </select></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationToPerformIntervention.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durn" id="durn" size="2" value='' maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durn_unit" id="durn_unit" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			 
		<% for(i=0;i<size;i++){	  
	 %>
		 <option value="<%=durn_type[i]%>"><%=durn_desc[i]%></option>
		 <%} %>
	
	  </select>&nbsp;<img id="durn_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>

	<tr>
	<td  align="left" class="label" width="45%" ><fmt:message key="eCP.DurationBeforeStartTimeWhenTaskBecomesDue.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnBeforeStart" id="durnBeforeStart" size="2" value='' maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnBeforeStart_unit" id="durnBeforeStart_unit" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	 <%
	 for(i=0;i<size;i++){	  
	 %>	 <option value="<%=durn_type[i]%>"><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_bf_st_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr> 
	 <tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationAfterStartTimeWhenTaskBecomesOverDue.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnAfterStart" id="durnAfterStart" value='' size="2" maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnAfterStart_unit" id="durnAfterStart_unit" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
	 %>
		 <option value="<%=durn_type[i]%>"><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_af_st_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationAfterEndTimeForMarkingTasksAsExpired.label" bundle="${cp_labels}"/>  </td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnAfterEnd" id="durnAfterEnd" size="2" value='' maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnAfterEnd_unit" id="durnAfterEnd_unit" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
	 %>
		 <option value="<%=durn_type[i]%>"><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_af_end_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="eCP.BackdateLimitForResultingOfTasks.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnBackDate" id="durnBackDate" size="2" value='' maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnBackDate_unit" id="durnBackDate_unit" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
	 %>
		 <option value="<%=durn_type[i]%>"><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="bklimit_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label"><fmt:message key="eCP.UseAsAdHocIntervention.label" bundle="${cp_labels}"/></td>
    <td  align="left">&nbsp;<input type="checkbox" name="adhoc_intervention" id="adhoc_intervention" value="Y" checked onclick="ChangeAdhoc();"></td>
	</tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<select name="result_type" id="result_type" onchange="ChangeList(this);checkMandatory(this);" >
    <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	  <%
		try{
		   if(Intervention_result_rs!=null)
		     {
			 while(Intervention_result_rs.next())
			  {
					result_type= Intervention_result_rs.getString("result_type");
					result_type_desc=Intervention_result_rs.getString("result_type_desc");
      %>
		 <option value="<%=result_type%>"><%=result_type_desc%></option>
		 <%}}}catch(Exception exp){exp.toString();} %>
	  </select></td>
    </tr>
	<tr>
      <td  align="left" class="label" width="45%"><fmt:message key="eCP.ResultMeasure.label" bundle="${cp_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;<input type="text" value='' name="result_measure" id="result_measure" size="30" readonly maxlength="30" onBlur='makeValidString(this);' value="" ><input type="button" class="button" name="result_measure_lookup" id="result_measure_lookup" value="?" onclick="ViewResultMeasure(result_measure);">&nbsp;<img id="result_measure_img" src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></img></td>
	  <input type="hidden" name="result_id" id="result_id" value="">
    </tr>
   <tr>
      <td  align="left" class="label" width="45%"><fmt:message key="eCP.GuidelinesToPerformIntervention.label" bundle="${cp_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;<TextArea name="guidelines" cols="38" rows="3"	onkeyPress="checkMaxLimit(this,4000);" onBlur="callCheckMaxLength(this,4000);makeValidString(this)" value="" ></textarea></td>
    </tr>
	<!-- IN030473 Start. -->
	<tr>
	  <td  align="left" class="label" width="45%"><fmt:message key="eCP.PatientInstructionsIntervention.label" bundle="${cp_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;<input type="text" value="<%=patient_instructions_description%>"  name="patient_instructions" size="30" maxlength="30" readonly onBlur='makeValidString(this)'><input type="button" class="button" name="patient_instructions_lookup" id="patient_instructions_lookup" value="?" onclick="ViewPatientInstructions(patient_instructions);"></td>
	  <input type="hidden" name="patient_instructions_id" id="patient_instructions_id" value="<%=patient_instructions_id%>">
    </tr>
	<!-- IN030473 End. -->
<% 
}
else if(mode.equals("2"))
{
String intervention_code=request.getParameter("intervention_code")==null ? "":request.getParameter("intervention_code");
String short_desc="";
String eff_status="";
String appl_dependency_level="";
String long_desc="";
String intervention_type_modify="";
String result_type_modify="";
String result_id="";
String intervention_durn="";
String lmt_for_tsk_due_bf_st_tm="";
String lmt_for_tsk_due_bf_st_tm_unit="";
String lmt_for_tsk_odue_af_st_tm="";
String lmt_for_tsk_odue_af_st_tm_unit="";
String lmt_for_tsk_exp_af_end_tm="";
String lmt_for_tsk_exp_af_end_tm_unit="";
String intervention_guideline="";
String bkdate_lmt_for_tsk_result="";
String bkdate_lmt_for_tsk_result_unit="";
String use_as_adhoc_intervention_yn="";
String intervention_durn_unit="";
String intervention_type_code="";
String result_type_desc_modify="";
String system_defined_yn="N";

//String modify_sql="select a.intervention_code ,a.short_desc,a.eff_status,a.appl_dependency_level,a.long_desc,a.intervention_type,a.result_type,a.result_id,a.intervention_durn,a.lmt_for_tsk_due_bf_st_tm,a.lmt_for_tsk_due_bf_st_tm_unit,a.lmt_for_tsk_odue_af_st_tm,a.lmt_for_tsk_odue_af_st_tm_unit,a.lmt_for_tsk_exp_af_end_tm,a.lmt_for_tsk_exp_af_end_tm_unit,a.intervention_guideline,a.bkdate_lmt_for_tsk_result,a.bkdate_lmt_for_tsk_result_unit,a.use_as_adhoc_intervention_yn,a.intervention_durn_unit,b.short_desc intervention_desc,b.intervention_type intervention_type_code,c.result_type_desc from ca_intervention a,ca_intervention_type b,ca_result_type c where a.intervention_code=? and a.intervention_type=b.intervention_type and a.result_type=c.result_type(+)";
// IN030473 Start.
//String modify_sql="SELECT a.intervention_code ,a.short_desc,a.eff_status,a.appl_dependency_level,a.long_desc,a.intervention_type,a.result_type,a.result_id,a.intervention_durn,a.lmt_for_tsk_due_bf_st_tm,a.lmt_for_tsk_due_bf_st_tm_unit,a.lmt_for_tsk_odue_af_st_tm,a.lmt_for_tsk_odue_af_st_tm_unit,a.lmt_for_tsk_exp_af_end_tm,a.lmt_for_tsk_exp_af_end_tm_unit,a.intervention_guideline,a.bkdate_lmt_for_tsk_result,a.bkdate_lmt_for_tsk_result_unit,a.use_as_adhoc_intervention_yn,a.intervention_durn_unit,b.short_desc intervention_desc,b.intervention_type intervention_type_code,c.result_type_desc FROM ca_intervention_lang_vw a, ca_intervention_type_lang_vw b,ca_result_type_lang_vw c WHERE a.intervention_code LIKE ? AND a.intervention_type=b.intervention_type AND a.result_type=c.result_type(+) AND A.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID AND C.LANGUAGE_ID(+) = A.LANGUAGE_ID";
String modify_sql="SELECT a.intervention_code ,a.short_desc,a.eff_status,a.appl_dependency_level,a.long_desc,a.intervention_type,a.result_type,a.result_id,a.intervention_durn,a.lmt_for_tsk_due_bf_st_tm,a.lmt_for_tsk_due_bf_st_tm_unit,a.lmt_for_tsk_odue_af_st_tm,a.lmt_for_tsk_odue_af_st_tm_unit,a.lmt_for_tsk_exp_af_end_tm,a.lmt_for_tsk_exp_af_end_tm_unit,a.intervention_guideline,a.bkdate_lmt_for_tsk_result,a.bkdate_lmt_for_tsk_result_unit,a.use_as_adhoc_intervention_yn,a.intervention_durn_unit,b.short_desc intervention_desc,b.intervention_type intervention_type_code,c.result_type_desc,a.consent_form_id,b.system_defined_yn FROM ca_intervention_lang_vw a, ca_intervention_type_lang_vw b,ca_result_type_lang_vw c WHERE a.intervention_code LIKE ? AND a.intervention_type=b.intervention_type AND a.result_type=c.result_type(+) AND A.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID AND C.LANGUAGE_ID(+) = A.LANGUAGE_ID";
// IN030473 End.
Intervention_modify_pstmt=con.prepareStatement(modify_sql);
Intervention_modify_pstmt.setString(1,intervention_code);

Intervention_modify_rset=Intervention_modify_pstmt.executeQuery();

if(Intervention_modify_rset!=null)
{
	while(Intervention_modify_rset.next())
	{
	short_desc=Intervention_modify_rset.getString("short_desc");
	eff_status=Intervention_modify_rset.getString("eff_status");
	appl_dependency_level=Intervention_modify_rset.getString("appl_dependency_level")==null?"":Intervention_modify_rset.getString("appl_dependency_level");
	long_desc=Intervention_modify_rset.getString("long_desc");
	intervention_type_modify=Intervention_modify_rset.getString("intervention_type");
result_type_modify=Intervention_modify_rset.getString("result_type")==null?"":Intervention_modify_rset.getString("result_type");
	result_id=Intervention_modify_rset.getString("result_id")==null?"":Intervention_modify_rset.getString("result_id");
	intervention_durn=Intervention_modify_rset.getString("intervention_durn")==null?"":Intervention_modify_rset.getString("intervention_durn");
    lmt_for_tsk_due_bf_st_tm=Intervention_modify_rset.getString("lmt_for_tsk_due_bf_st_tm")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_due_bf_st_tm");
	lmt_for_tsk_due_bf_st_tm_unit=Intervention_modify_rset.getString("lmt_for_tsk_due_bf_st_tm_unit")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_due_bf_st_tm_unit");
	lmt_for_tsk_odue_af_st_tm=Intervention_modify_rset.getString("lmt_for_tsk_odue_af_st_tm")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_odue_af_st_tm");
	lmt_for_tsk_odue_af_st_tm_unit=Intervention_modify_rset.getString("lmt_for_tsk_odue_af_st_tm_unit")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_odue_af_st_tm_unit");
	lmt_for_tsk_exp_af_end_tm=Intervention_modify_rset.getString("lmt_for_tsk_exp_af_end_tm")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_exp_af_end_tm");
	lmt_for_tsk_exp_af_end_tm_unit=Intervention_modify_rset.getString("lmt_for_tsk_exp_af_end_tm_unit")==null?"":Intervention_modify_rset.getString("lmt_for_tsk_exp_af_end_tm_unit");
	intervention_guideline=Intervention_modify_rset.getString("intervention_guideline")==null?"":Intervention_modify_rset.getString("intervention_guideline");
	bkdate_lmt_for_tsk_result=Intervention_modify_rset.getString("bkdate_lmt_for_tsk_result")==null?"":Intervention_modify_rset.getString("bkdate_lmt_for_tsk_result");
	bkdate_lmt_for_tsk_result_unit=Intervention_modify_rset.getString("bkdate_lmt_for_tsk_result_unit")==null?"":Intervention_modify_rset.getString("bkdate_lmt_for_tsk_result_unit");
	use_as_adhoc_intervention_yn=Intervention_modify_rset.getString("use_as_adhoc_intervention_yn")==null?"N":Intervention_modify_rset.getString("use_as_adhoc_intervention_yn");
	intervention_durn_unit=Intervention_modify_rset.getString("intervention_durn_unit")==null?"":Intervention_modify_rset.getString("intervention_durn_unit");
	intervention_desc=Intervention_modify_rset.getString("intervention_desc")==null?"":Intervention_modify_rset.getString("intervention_desc");
	patient_instructions_id=Intervention_modify_rset.getString("consent_form_id")==null?"":Intervention_modify_rset.getString("consent_form_id");//IN030473
	intervention_type_code=Intervention_modify_rset.getString("intervention_type_code")==null?"":Intervention_modify_rset.getString("intervention_type_code");
	result_type_desc_modify=Intervention_modify_rset.getString("result_type_desc")==null?"":Intervention_modify_rset.getString("result_type_desc");
	system_defined_yn=Intervention_modify_rset.getString("system_defined_yn")==null?"N":Intervention_modify_rset.getString("system_defined_yn");
	}
}
//String durn_unit="";
String status="";
String readOnly="";
String disable="";
String select_intervention_result="";
String select_intervention_type="";
String select_dependency="";
String select_durn="";
String select_durnBeforeStart="";
String select_durnAfterStart="";
String select_durnAfterEnd="";
String select_durnBackDate="";
String adhoc_select="";
String result_measure_disable="";
String visible="";
String tempreadOnly="";

if(eff_status.equals("E"))
{
	status="checked";
	disable="";
	readOnly="";
}
else if(eff_status.equals("D")) 
{
	status="";
	disable="disabled";
	readOnly="readonly";
}

if(use_as_adhoc_intervention_yn.equals("Y"))
	adhoc_select="checked";
else if(use_as_adhoc_intervention_yn.equals("N"))
	adhoc_select="";

if(result_type_modify.equals("")|| result_type_modify==null || system_defined_yn.equals("Y"))
	visible="hidden";
else
	visible="visible";

if(result_type_modify.equals("")|| result_type_modify==null || eff_status.equals("D") || system_defined_yn.equals("Y"))
	result_measure_disable="disabled";
else 
	result_measure_disable="";
if(system_defined_yn.equals("Y"))
{
	tempreadOnly=readOnly;
	readOnly="readonly";
}
%>
  <tr>
  <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  align="left" >
      &nbsp;&nbsp;&nbsp;<input type="text" name="intervention_code" id="intervention_code" size="10" value='<%=intervention_code%>' readonly maxlength="10" onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event)"> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>
<tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="50" value='<%=short_desc%>' <%=readOnly%> maxlength="60" onBlur='makeValidString(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td  align="left" class="label" width="25%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;&nbsp;<TextArea name="long_desc" cols="50" rows="3" onKeyPress=" checkMaxLimit(this,400)" value='' onBlur="callCheckMaxLength(this,400);makeValidString(this);" <%=readOnly%>><%=long_desc%></textarea>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
 <tr>
<% 
	if(system_defined_yn.equals("Y"))
	{
		readOnly=tempreadOnly;
	}
%>
	<td  align="left" class="label" width="25%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=status%> onclick="oneffStatusCheck()">&nbsp;</td>
    </tr>
</table>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<tr>
<th align="left" colspan="5">&nbsp;<fmt:message key="Common.Attributes.label" bundle="${common_labels}"/></th>
</tr>
  <tr>
	<td  align="left" class="label" width="45%"><fmt:message key="Common.InterventionType.label" bundle="${common_labels}"/></td>
<%	 if(system_defined_yn.equals("N"))
	 {
%>
    <td  align="left" >&nbsp;&nbsp;<select name="intervention_type" id="intervention_type" <%=disable%> onchange="ChangeList(this);">
    	  <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<%
		try{
		   if(Intervention_rs!=null)
		     {
			 while(Intervention_rs.next())
			  {
					intervention_type= Intervention_rs.getString("intervention_type");
					intervention_desc=  Intervention_rs.getString("short_desc");
					if(intervention_type.equals(intervention_type_modify))
				    	select_intervention_type="selected";
					else
						select_intervention_type="";
    	 %>
		 <option value="<%=intervention_type%>" <%=select_intervention_type%>><%=intervention_desc%></option>
		 <%}}}catch(Exception exp){exp.toString();} %>
	  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
<%  }
	else
	{
%>
		 <td  align="left" >&nbsp;&nbsp;<select name="intervention_type" id="intervention_type" disabled>
    	  <option value="<%=intervention_type_modify%>"><%=intervention_desc%></option>
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
<%
	}
%>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>
		    <td  align="left" >&nbsp;&nbsp;<select name="dependency" id="dependency" <%=disable%> onchange="ChangeList(this)">
			  <option value="" selected>----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option>
    	 	 <%int temp=0;
			 if(appl_dependency_level.equals(""))
			  {
				for(int a=1;a<=10;a++)
				{
			  %>
              <option value="<%=a%>"><%=a%></option>
			  <%
				}
			 }else{
		  temp=Integer.parseInt(appl_dependency_level);
				}
	   for(int count=1;count<10;count++){	  
		 			if(count==temp)
				    	select_dependency="selected";
					else
						select_dependency="";
	 %>
		 <option value="<%=count%>" <%=select_dependency%>><%=count%></option>
		 <%} %>

	  </select></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationToPerformIntervention.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durn" id="durn" size="2" value="<%=intervention_durn%>" <%=readOnly%> maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durn_unit" id="durn_unit" <%=disable%> onchange="ChangeDurnUnit(this);">
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			 
		<% for(i=0;i<size;i++){	  
					if(durn_type[i].equals(intervention_durn_unit))
				    	select_durn="selected";
					else
						select_durn="";

	 %>
		 <option value="<%=durn_type[i]%>" <%=select_durn%>><%=durn_desc[i]%></option>
	 <%}%>
  </select>&nbsp;<img id="durn_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%" ><fmt:message key="eCP.DurationBeforeStartTimeWhenTaskBecomesDue.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnBeforeStart" id="durnBeforeStart" size="2" value='<%=lmt_for_tsk_due_bf_st_tm%>' <%=readOnly%> maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnBeforeStart_unit" id="durnBeforeStart_unit" <%=disable%> onchange="ChangeDurnBeforeStartUnit(this)">
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			 <%

	 for(i=0;i<size;i++){	  
		 	if(durn_type[i].equals(lmt_for_tsk_due_bf_st_tm_unit))
				    	select_durnBeforeStart="selected";
					else
						select_durnBeforeStart="";
	 %>	 <option value="<%=durn_type[i]%>" <%=select_durnBeforeStart%>><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_bf_st_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr> 
	 <tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationAfterStartTimeWhenTaskBecomesOverDue.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnAfterStart" id="durnAfterStart" value='<%=lmt_for_tsk_odue_af_st_tm%>' <%=readOnly%> size="2" maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnAfterStart_unit" id="durnAfterStart_unit" <%=disable%> onchange="ChangeDurnAfterStartUnit(this)">
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
		 		 	if(durn_type[i].equals(lmt_for_tsk_odue_af_st_tm_unit))
				    	select_durnAfterStart="selected";
					else
						select_durnAfterStart="";

	 %>
		 <option value="<%=durn_type[i]%>" <%=select_durnAfterStart%>><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_af_st_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%" nowrap><fmt:message key="eCP.DurationAfterEndTimeForMarkingTasksAsExpired.label" bundle="${cp_labels}"/>  </td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnAfterEnd" id="durnAfterEnd" size="2" value='<%=lmt_for_tsk_exp_af_end_tm%>' <%=readOnly%> maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnAfterEnd_unit" id="durnAfterEnd_unit" <%=disable%> onchange="ChangeDurnAfterEndUnit(this)">
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
		 		 	if(durn_type[i].equals(lmt_for_tsk_exp_af_end_tm_unit))
				    	select_durnAfterEnd="selected";
					else
						select_durnAfterEnd="";


	 %>
		 <option value="<%=durn_type[i]%>" <%=select_durnAfterEnd%> ><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="durn_af_end_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="eCP.BackdateLimitForResultingOfTasks.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="text" name="durnBackDate" id="durnBackDate" size="2" value='<%=bkdate_lmt_for_tsk_result%>' <%=readOnly%> maxlength="2" onKeyPress="return callCheckForNumber(event)" onblur="return CheckZero(this)">&nbsp;&nbsp;<select name="durnBackDate_unit" id="durnBackDate_unit" <%=disable%> onchange="ChangeDunBackDateUnit(this)">
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<% for(i=0;i<size;i++){	  
		 		 	if(durn_type[i].equals(bkdate_lmt_for_tsk_result_unit))
				    	select_durnBackDate="selected";
					else
						select_durnBackDate="";
	 %>
		 <option value="<%=durn_type[i]%>" <%=select_durnBackDate%>><%=durn_desc[i]%></option>
		 <%} %>
	  </select>&nbsp;<img id="bklimit_img" src='../../eCommon/images/mandatory.gif' ></img></td>
    </tr>
	<tr>
	<td  align="left" class="label" width="45%"><fmt:message key="eCP.UseAsAdHocIntervention.label" bundle="${cp_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="checkbox" name="adhoc_intervention" id="adhoc_intervention" value="<%=use_as_adhoc_intervention_yn%>" <%=adhoc_select%> <%=disable%> onclick="ChangeAdhoc();">&nbsp;</td>
    </tr>
    <tr>
	<td  align="left" class="label" width="45%"><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
<%
	if(system_defined_yn.equals("N"))
	{
%>
    <td  align="left" >&nbsp;&nbsp;<select name="result_type" id="result_type" <%=disable%> onchange="ChangeList(this);checkMandatory(this);">
   <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
		try
		{
		   if(Intervention_result_rs!=null)
		     {
			 while(Intervention_result_rs.next())
			  {
					result_type= Intervention_result_rs.getString("result_type");
					result_type_desc=  Intervention_result_rs.getString("result_type_desc");
					if(result_type.equals(result_type_modify))
				      	select_intervention_result="selected";
					else
						select_intervention_result="";
			  
 %>
		 <option value="<%=result_type%>" <%=select_intervention_result%>> <%=result_type_desc%></option>
<%				}
			}
		}catch(Exception exp){exp.toString();} 
%>
	  </select></td>
<%
	}
	else
	{
%>
			<td  align="left" >&nbsp;&nbsp;<select name="result_type" id="result_type" disabled >
			<option value="<%=result_type_modify%>"><%=result_type_desc_modify%></option>
		</select></td>
<%	}
%>
    </tr>
<%
String result_measure_sql="";
String result_measure_description="";
if(!(result_type_modify.equals("")))
{
if(result_type_modify.equals("DP"))
{
	//result_measure_sql ="select long_desc description from am_discr_msr where result_type in ('V','Z') and  eff_status='E' and discr_msr_id=?"; 
	result_measure_sql ="SELECT long_desc description FROM am_discr_msr_lang_vw WHERE result_type IN ('V','Z') AND  eff_status='E' AND discr_msr_id = ? and language_id = ?"; 
}
else if(result_type_modify.equals("DA"))
{
 		//result_measure_sql ="select long_desc description from am_discr_msr where result_type not in ('G','V','Z') and eff_status = 'E' and discr_msr_id=?";  
 		result_measure_sql ="SELECT long_desc description FROM am_discr_msr_lang_vw WHERE result_type NOT IN ('G','V','Z') AND eff_status = 'E' AND discr_msr_id=? and language_id = ?";  
}
else if(result_type_modify.equals("RM"))
{
 		//result_measure_sql ="select chart_result_type_desc description from or_chart_result_type where eff_status = 'E' and chart_result_type=?";
 		result_measure_sql ="SELECT chart_result_type_desc description FROM or_chart_result_type_lang_vw WHERE eff_status = 'E' AND chart_result_type=? and language_id = ?";
}
else if(result_type_modify.equals("NT"))
{
 		//result_measure_sql ="select assess_note_desc description from cp_assess_note where eff_status ='E' and assess_note_id=?";
 		result_measure_sql ="SELECT assess_note_desc description FROM cp_assess_note_lang_vw WHERE eff_status ='E' AND assess_note_id=? and language_id = ?";
}
else if(result_type_modify.equals("OR"))
{
 		 //result_measure_sql="select long_desc description from or_order_catalog where eff_status ='E' and order_catalog_code=?";
 		 result_measure_sql="SELECT long_desc description FROM or_order_catalog_lang_vw WHERE eff_status ='E' AND order_catalog_code=? and language_id = ?";
}
else if(result_type_modify.equals("CH"))
{
	//result_measure_sql ="select long_desc description from ca_chart where eff_status ='E' and chart_id=?";
	result_measure_sql ="SELECT long_desc description FROM ca_chart_lang_vw WHERE eff_status ='E' AND chart_id=? and language_id = ?";
}
result_measure_pstmt=con.prepareStatement(result_measure_sql);
result_measure_pstmt.setString(1,result_id);
result_measure_pstmt.setString(2,locale);

result_measure_rset=result_measure_pstmt.executeQuery();

if(result_measure_rset!=null)
{
	while(result_measure_rset.next())
	{
       result_measure_description=result_measure_rset.getString("description");
	}
}
}
// IN030473 Start.
if(!(patient_instructions_id.equals("")))
{
patient_instructions_pstmt =con.prepareStatement("SELECT CONSENT_FORM_LABEL description FROM OR_CONSENT_FORM WHERE CONSENT_FORM_ID=?");
patient_instructions_pstmt.setString(1,patient_instructions_id);
patient_instructions_rset=patient_instructions_pstmt.executeQuery();
if(patient_instructions_rset!=null)
{
	while(patient_instructions_rset.next())
	{
       patient_instructions_description=patient_instructions_rset.getString("description");
	}
}
}
// IN030473 End.
%>
	<tr>
	  <td  align="left" class="label" width="45%"><fmt:message key="eCP.ResultMeasure.label" bundle="${cp_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;<input type="text" value="<%=result_measure_description%>" readonly name="result_measure" size="30" maxlength="30" onBlur='makeValidString(this)'><input type="button" class="button" name="result_measure_lookup" id="result_measure_lookup" value="?" onclick="ViewResultMeasure(result_measure);" <%=result_measure_disable%>>&nbsp;<img id="result_measure_img" src='../../eCommon/images/mandatory.gif' style="visibility:<%=visible%>"></img>&nbsp;</td>
	  <input type="hidden" name="result_id" id="result_id" value="<%=result_id%>">
    </tr>
   <tr>
      <td  align="left" class="label" width="45%"><fmt:message key="eCP.GuidelinesToPerformIntervention.label" bundle="${cp_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;<TextArea name="guidelines" cols="38" rows="3"	onkeyPress="checkMaxLimit(this,4000);" onBlur="callCheckMaxLength(this,4000);makeValidString(this)" value="" <%=readOnly%>><%=intervention_guideline%></textarea></td>
    </tr>
	<!-- IN030473 Start. -->
	<tr>
	  <td  align="left" class="label" width="45%"><fmt:message key="eCP.PatientInstructionsIntervention.label" bundle="${cp_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;<input type="text" value="<%=patient_instructions_description%>" readonly name="patient_instructions" size="30" maxlength="30" onBlur='makeValidString(this)'><input type="button" class="button" name="patient_instructions_lookup" id="patient_instructions_lookup" value="?" onclick="ViewPatientInstructions(patient_instructions);"></td>
	  <input type="hidden" name="patient_instructions_id" id="patient_instructions_id" value="<%=patient_instructions_id%>">
    </tr>
	<!-- IN030473 End. -->
<input type="hidden" name="intervention_type1" id="intervention_type1" value="<%=intervention_type_modify%>">
<input type="hidden" name="dependency1" id="dependency1" value="<%=appl_dependency_level%>">
<input type="hidden" name="durn_unit1" id="durn_unit1" value="<%=intervention_durn_unit%>">
<input type="hidden" name="durnBeforeStart_unit1" id="durnBeforeStart_unit1" value="<%=lmt_for_tsk_due_bf_st_tm_unit%>">
<input type="hidden" name="durnAfterStart_unit1" id="durnAfterStart_unit1" value="<%=lmt_for_tsk_odue_af_st_tm_unit%>">
<input type="hidden" name="durnAfterEnd_unit1" id="durnAfterEnd_unit1" value="<%=lmt_for_tsk_exp_af_end_tm_unit%>">
<input type="hidden" name="durnBackDate_unit1" id="durnBackDate_unit1" value="<%=bkdate_lmt_for_tsk_result_unit%>">
<input type="hidden" name="result_type1" id="result_type1" value="<%=result_type_modify%>">
<input type="hidden" name="adhoc_intervention1" id="adhoc_intervention1" value="<%=use_as_adhoc_intervention_yn%>">
<input type="hidden" name="system_defined_yn" id="system_defined_yn" value="<%=system_defined_yn%>">
<% } %>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>
<%
  }catch(Exception e)
  {
//	out.println(e.toString());//COMMON-ICN-0181
    e.printStackTrace();//COMMON-ICN-0181
  }
finally
{
    if(Intervention_rs !=null) Intervention_rs.close();
    if(Intervention_durn_rs!=null) Intervention_durn_rs.close();
	if(Intervention_result_rs!=null) Intervention_result_rs.close();
	if(Intervention_modify_rset!=null) Intervention_modify_rset.close();
	if(result_measure_rset!=null) result_measure_rset.close();

	if(Intervention_stmt !=null) Intervention_stmt.close();
	if(Intervention_durn_stmt!=null) Intervention_durn_stmt.close();
	if(Intervention_result_stmt!=null) Intervention_result_stmt.close();
	if(Intervention_modify_pstmt!=null) Intervention_modify_pstmt.close();
	if(result_measure_pstmt!=null) result_measure_pstmt.close();
 
	ConnectionManager.returnConnection(con,request);
}
%>

