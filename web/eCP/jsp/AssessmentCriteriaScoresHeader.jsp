
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
*	Created By		:	Vinay
*	Created On		:	31 Jan 2005
--%>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	 //This file is saved on 16/12/2005.
	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <script language="JavaScript" src="../../eCP/js/common.js"></script> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/AssessmentCriteriaScore.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String assessnote = "";
%>
<script>
function Getcatgcode()
{
	var assess_note = document.assess_crit_score_header.assess_note.value;
	parent.parent.f_query_add_mod.assess_crit_score_addmod.location.href = "../../eCommon/html/blank.html";
	document.assess_crit_score_header.assess_catg.value = "";

	var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eCP/jsp/AssessmentCriteriaScoresDynamicValues.jsp'><input type='hidden' name='assess_note' id='assess_note' value='"+assess_note+"'></form></body></html>"
	parent.parent.f_query_add_mod.blankFrame.document.write(htmlvalue);
	parent.parent.f_query_add_mod.blankFrame.document.dynamic_value.submit();
}
function callResult()
{
	var assess_note = document.assess_crit_score_header.assess_note.value;
	var assess_catg = document.assess_crit_score_header.assess_catg.value;
	var fields  = new Array (document.assess_crit_score_header.assess_note,document.assess_crit_score_header.assess_catg)
	var names = new Array(getLabel("eCP.AssessmentNote.label","CP"),getLabel("eCP.AssessmentCategory.label","CP"))
	var	msgFrame=parent.parent.messageFrame;
	 if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, msgFrame))
	{
		parent.parent.f_query_add_mod.assess_crit_score_addmod.location.href = "../../eCP/jsp/AssessmentCriteriaScoresAddModify.jsp?assess_note="+assess_note+"&assess_catg="+assess_catg;
	}
}
function clearVal()
{
	parent.parent.f_query_add_mod.assess_crit_score_addmod.location.href ="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
}
</script>
</head>
<body onKeyDown="lockKey()" OnMouseDown='CodeArrest()'> 
<form name='assess_crit_score_header' id='assess_crit_score_header'>
<%
try
{
con = ConnectionManager.getConnection(request);
%>
<TABLE border="0" cellpadding="7" cellspacing="0" width="100%" align='right'>
<TR>
	<TD class='label' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></TD>
	<TD>
	<SELECT name="assess_note" id="assess_note" onchange='Getcatgcode()'>
	<OPTION value="">-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</OPTION>
<%
//	assessnote = "select ASSESS_NOTE_ID ,ASSESS_NOTE_DESC from cp_assess_note where EFF_STATUS='E'order by ASSESS_NOTE_DESC";
	assessnote = "select ASSESS_NOTE_ID ,ASSESS_NOTE_DESC from cp_assess_note_lang_vw where EFF_STATUS='E' and language_id='"+locale+"' order by ASSESS_NOTE_DESC";
	stmt = con.createStatement();
	rs = stmt.executeQuery(assessnote);
	if(rs!=null)
	{
		while (rs.next())
		{
			out.println("<option value='"+rs.getString("ASSESS_NOTE_ID")+"'>"+rs.getString("ASSESS_NOTE_DESC")+"</option>");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
%>
		</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</TD>
	<TD>&nbsp;</TD>
</TR>
<TR>
	<TD class='label' align='right'><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></TD>
	<TD>
		<SELECT name="assess_catg" id="assess_catg" onchange="clearVal()">
		<OPTION value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
		</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</TD>
	<TD><INPUT class="button" TYPE="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='callResult()'></TD>
</TR>
	<TR>
	</TR>
	<TR>
		<TD class='Querydata'><fmt:message key="eCP.NotApplicable0.label" bundle="${cp_labels}"/></TD>
		<TD class='Querydata'>&nbsp;&nbsp;&nbsp;<fmt:message key="eCP.Normal1.label" bundle="${cp_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="eCP.Abnormal25.label" bundle="${cp_labels}"/></TD>
		<TD class='Querydata'><fmt:message key="eCP.CriticallyAbnormal69.label" bundle="${cp_labels}"/></TD>
	</TR>
</TABLE>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='right'>
</TABLE>
<%
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>

