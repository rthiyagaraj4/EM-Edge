<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	17 March 2005
-->

<%-- JSP Page specific attributes start --%>
<%@page language="java" import="java.util.*, java.sql.*, webbeans.eCommon.*, com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/ReviseCarePlan.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String p_pract_id=(String)session.getValue("ca_practitioner_id");
String pract_name="";
String facility_id=(String)session.getValue("facility_id");
String p_encounter_id=request.getParameter("encounter_id");
Connection conn=null;

PreparedStatement stmt_pract=null;
ResultSet rset_pract=null;

PreparedStatement stmt_diagnosis_set=null;
ResultSet rset_diagnosis_set=null;

PreparedStatement stmt_diagnosis=null;
ResultSet rset_diagnosis=null;
try{
	conn = ConnectionManager.getConnection(request);

	String p_patient_id=request.getParameter("patient_id");

	String sql_pract="select practitioner_name from am_practitioner where practitioner_id=?";

	stmt_pract=conn.prepareStatement(sql_pract);
	stmt_pract.setString(1,p_pract_id);
	rset_pract=stmt_pract.executeQuery();

	if(rset_pract!=null)
	{
		while(rset_pract.next())
		{
			pract_name=rset_pract.getString("practitioner_name");
		}
	}

	String term_set_id="";
	%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name="ReviseCarePlanCriteria_Form" id="ReviseCarePlanCriteria_Form" method="post">
	<table cellpadding=0 cellspacing=0 border=0 width="100%">
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td width="15%" class="label" align="right"><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/>&nbsp;&nbsp;&nbsp</td>
	<td width="70%" class="data" align="left">
	<input type="text" name="caremanager_name" id="caremanager_name" value="<%=pract_name%>">
	<input type=hidden name="care_manager_id" id="care_manager_id" value="<%=p_pract_id%>"><input type="button" class="button" name="caremanagerlookup_button" id="caremanagerlookup_button" value="?" onClick="show_CareManager(this,caremanager_name,care_manager_id);">
	</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td width="15%" class="label" align="right"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp</td>
	<td width="70%" class="data" align="left">
	<select name="diagnosis_set" id="diagnosis_set" onChange="Load_Diagnosis();">
	<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
	String sql_diagnosis_set="select term_set_id from mr_term_set_for_facility where facility_id =? order by term_set_id";

	stmt_diagnosis_set=conn.prepareStatement(sql_diagnosis_set);
	stmt_diagnosis_set.setString(1,facility_id);

	rset_diagnosis_set=stmt_diagnosis_set.executeQuery();

	if(rset_diagnosis_set!=null)
	{
		while(rset_diagnosis_set.next())
		{
			term_set_id=rset_diagnosis_set.getString("term_set_id");
	%>
	<option value="<%=term_set_id%>"><%=term_set_id%></option>
	<%
		}
	}
	%>
	</select>
	<select name="diagnosis" id="diagnosis">
	<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	</select>
	</td>
	</tr>
	</table>
	<table cellpadding=0 cellspacing=0 border=0 width="100%">
	<tr>
	<td width="85%"  class="label">&nbsp;</td>
	<td width="15%"  class="label"><input type="button" class="button" name='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' value="Search" align="right" onClick="ShowActivePlansResult();">&nbsp;&nbsp<input type="button" class="button" name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="ClearActivePlansResult();"></td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	</table>
	<input type=hidden name="patient_id" id="patient_id" value="<%=p_patient_id%>">
	<input type=hidden name="encounter_id" id="encounter_id" value="<%=p_encounter_id%>">
	<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>">
<%}catch(Exception e){
		System.err.println(e.toString());
		e.printStackTrace();
}finally{
	  if (rset_pract != null)   rset_pract.close();
	  if (rset_diagnosis_set != null)   rset_diagnosis_set.close();
  	  if (rset_diagnosis != null)   rset_diagnosis.close();

	  if (stmt_pract != null) stmt_pract.close();
	  if (stmt_diagnosis_set != null) stmt_diagnosis_set.close();
	  if (stmt_diagnosis != null) stmt_diagnosis.close();

	  ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

