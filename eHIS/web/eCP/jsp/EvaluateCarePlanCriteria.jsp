<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay.
*	Created On		:	19 Mar 2005
--%>
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String p_pract_id = (String)session.getAttribute("ca_practitioner_id");
	String facilty_id = (String)session.getAttribute("facility_id");
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs = null;
	PreparedStatement stmt_pract=null;
    ResultSet rset_pract=null;  
	String readonly = "";
	String disable = "";
	String display="", visible="";;
	String pract_name="";
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String p_patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String sql_pract="select practitioner_name from am_practitioner_lang_vw where practitioner_id=? and language_id=?";
	stmt_pract=con.prepareStatement(sql_pract);
	stmt_pract.setString(1,p_pract_id);
	stmt_pract.setString(2,locale);
	rset_pract=stmt_pract.executeQuery();
	if(rset_pract!=null)
	{
		while(rset_pract.next())
		{
			pract_name=rset_pract.getString("practitioner_name");
		}
	}
	if(!p_patient_id.equals(""))
	{
		readonly = "readonly"; 
		disable = "disabled"; 
		display = "none";
		visible	= "hidden";
	}
	String sql_source = "Select locn_type, short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','N') and language_id='"+locale+"' order by short_desc";
	try
	{
		stmt = con.prepareStatement(sql_source);
		rs = stmt.executeQuery();
%>
<body OnMouseDown='CodeArrest()' onload='Load_Diagnosis()'>
<form name='eval_cp_crit' id='eval_cp_crit'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr style='display:<%=display%>;'>
	<td class='label' align='right' width='12%'><fmt:message key="Common.source.label" bundle="${common_labels}"/></td>
	<td width='50%'>&nbsp;&nbsp;
		<SELECT name="eval_src" id="eval_src" onchange='popuval()'>
			<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("locn_type")+"'>"+rs.getString("short_desc")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
%>
		</SELECT>&nbsp;<SELECT name="eval_ind" id="eval_ind">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
	<td colspan=4></td>
</tr>
<tr>
	<td class='label' align='right' width='12%'><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></td>
	<td width = '30%'>&nbsp;<INPUT TYPE="text" name="eval_cp_care_mnagr" id="eval_cp_care_mnagr"  value="<%=pract_name%>" size="30" onblur="show_CareManager(this,eval_cp_care_mnagr,care_manager_id);"><input type=hidden name="care_manager_id" id="care_manager_id" value="<%=p_pract_id%>"><INPUT TYPE="button" class="button" value="?" onClick="show_CareManager(this,eval_cp_care_mnagr,care_manager_id);">
	</td>
	<td class='label' align='right' width='6%'>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
	<td colspan='2'>&nbsp;<select name="eval_diag" id="eval_diag" onchange="Load_Diagnosis();">
			<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>

<%
	String sql_diag = "select term_set_id from mr_term_set_for_facility where facility_id = ?  order by term_set_id";
	stmt = con.prepareStatement(sql_diag);
	stmt.setString(1,facilty_id);
	rs = stmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("term_set_id")+"'>"+rs.getString("term_set_id")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
%>
		</select>&nbsp;<select name="diagnosis" id="diagnosis">
	<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	</select>
	</td>
</tr>

<tr>
	<td class='label' align='right' width='12%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
	<td class='label' width='20%'>&nbsp;<input name='eval_frmdate' id='eval_frmdate' id='eval_id_frmdate' type='text' size='8' maxlength='10' value='' onBlur="CheckDate(this)" onKeyPress='return AllowDateFormat(event);'><img  name='eval_frmdate_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(eval_frmdate,'eval_id_frmdate');">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input name='eval_todate' id='eval_todate' id='eval_id_todate' type='text' size='8' maxlength='10' value='' onBlur="CheckDate(this);chkfrmdate()" onKeyPress='return AllowDateFormat(event);'><img  name='eval_todate_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(eval_todate,'eval_id_todate');">	</td>
	<td class='label' align='right'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;</td>
	<td colspan='2'>&nbsp;<SELECT name="view_plans" id="view_plans">
	<option value='A'><fmt:message key="eCP.ActivePlans.label" bundle="${cp_labels}"/></option>
	<option value='L'><fmt:message key="eCP.AllPlans.label" bundle="${cp_labels}"/></option>
	</SELECT>&nbsp;<SELECT name="view_summary" id="view_summary">
	<option value='S'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
	<option value='D'><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
	</SELECT></td>
</tr>
<tr >
	<td class='label' align='right' width='12%' ><font style='visibility:<%=visible%>;'>
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</font></td>
	<td width='20%' >&nbsp;&nbsp;
<INPUT TYPE="text" name="patient_id" id="patient_id" size="15" value="<%=p_patient_id%>" <%=readonly%> style='visibility:<%=visible%>;' >
	<INPUT TYPE="button" class="button" value="?" <%=disable%> onclick="PatientSearch()" style='visibility:<%=visible%>;'>	</td>
	<td colspan='2'></td>
	<td align='right'><INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callresult();"><INPUT TYPE='button' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearresult()'><!-- <INPUT TYPE="button" class="button" value="Variance"  onclick="showvariance();"> --></td>
</tr>
</table>
<%
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		try
		{
		if(rs!=null) rs.close();
		if(rset_pract!=null) rset_pract.close();
		if(stmt_pract!=null) stmt_pract.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
%>
<INPUT TYPE="hidden" value="<%=facilty_id%>" name="facilty_id">
<input type=hidden name="p_patient_id" id="p_patient_id" value="<%=p_patient_id%>">
<INPUT TYPE="hidden" value="<%=encounter_id%>" name="encounter_id">
<input type="hidden" name=locale value="<%=locale%>">
</form>
</body>
</html>

