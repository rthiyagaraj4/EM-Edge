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
*	Created By		:	nikhil
*	Created On		:	25 jan 05
-->
<%@ page  language="java" import ="com.ehis.eslp.*, java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eOR.Common.*,java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
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
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/Reason.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
<%
	Connection con				=		null;
	PreparedStatement ps		=		null;
	ResultSet rs				=		null;

	con							=		ConnectionManager.getConnection(request);

	String mode					=		request.getParameter("mode");
	String jv_reason_code		=		"";
	String jv_reason_desc		=		"";
	String jv_activity_code		=		"";
	String jv_activity_desc		=		"";
	String jv_eff_status		=		"";
	try
	{
%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="ReasonAddModify_Form" id="ReasonAddModify_Form" method="post" action='../../servlet/eCP.ReasonServlet' target="messageFrame">
<br><br><br><br>

<%if(mode.equals("1")){%>
<table cellpadding=0 cellspacing=0 width="75%" align="center">

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
	<td align="left" >&nbsp;<input type="text" name="reason_code" id="reason_code" value="" size="4" maxlength="4" onKeyPress="return CheckForSpecChars(event);">
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>
</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></td>
	<td >&nbsp;<input type="text" name="reason" id="reason" value="" size="30" maxlength="30">
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>
</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
	<td  >&nbsp;<select name="activity_code" id="activity_code">
		<option value="" selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>		
		<%
		//ps = con.prepareStatement("select activity_type_code, activity_type_desc from cp_activity_type order by activity_type_desc");
		ps = con.prepareStatement("SELECT ACTIVITY_TYPE_CODE, ACTIVITY_TYPE_DESC FROM CP_ACTIVITY_TYPE_LANG_VW WHERE language_id='"+locale+"'"+ "ORDER BY ACTIVITY_TYPE_DESC");
		rs = ps.executeQuery();
		while(rs != null && rs.next()){
		%>
			<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
		<%
		}
		
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif"></img>

	</td>
</tr>


<tr>
	<td colspan="5">&nbsp;</td>
</tr>

</tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td >&nbsp;<input type="checkbox" name="eff_status" id="eff_status" checked>
	</td>
</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>
</table>

<%} else if(mode.equals("2")) {
	

	jv_reason_code			=		request.getParameter("reason_code")==null ? "":request.getParameter("reason_code");
	//ps						=		con.prepareStatement("select a.reason_code, a.reason_desc, a.activity_type_code, b.activity_type_desc, a.eff_status from cp_reason a, cp_activity_type b where a.activity_type_code = b.activity_type_code and upper(a.reason_code) like upper(?)");
	ps						=		con.prepareStatement("SELECT a.reason_code, a.reason_desc, a.activity_type_code, b.activity_type_desc, a.eff_status FROM cp_reason_lang_vw a, cp_activity_type_lang_vw b WHERE a.activity_type_code = b.activity_type_code AND a.reason_code = ? AND a.language_id = ? AND a.language_id = b.language_id");
	ps.setString(1, jv_reason_code);
	ps.setString(2, locale);
	rs						=		ps.executeQuery();
	rs.next();

	jv_reason_code			=		rs.getString(1)==null ? "" : rs.getString(1);
	jv_reason_desc			=		rs.getString(2)==null ? "" : rs.getString(2);
	jv_activity_code		=		rs.getString(3)==null ? "" : rs.getString(3);
	jv_activity_desc		=		rs.getString(4)==null ? "" : rs.getString(4);
	jv_eff_status			=		rs.getString(5)==null ? "" : rs.getString(5);
	
	%>

<table cellpadding=0 cellspacing=0 width="75%" align="center">

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
	<td  >&nbsp;<input type="text" name="reason_code" id="reason_code" value="<%=jv_reason_code%>" size="4" maxlength="4" readonly>
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>

</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></td>
<%if(jv_eff_status.equals("E")){%>
	<td >&nbsp;<input type="text" name="reason" id="reason" value="<%=jv_reason_desc%>" size="30" maxlength="30">
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>
<%}else{%>
	<td >&nbsp;<input type="text" name="reason" id="reason" value="<%=jv_reason_desc%>" size="30" readonly>
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>

<%}%>
</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
<%if(jv_eff_status.equals("E")){%>
	<td  >&nbsp;<select name="activity_code" id="activity_code">
		<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<%
		//ps = con.prepareStatement("select activity_type_code, activity_type_desc from cp_activity_type order by activity_type_desc");
	
	ps = con.prepareStatement("SELECT ACTIVITY_TYPE_CODE, ACTIVITY_TYPE_DESC FROM CP_ACTIVITY_TYPE_LANG_VW WHERE language_id='"+locale+"'"+ "ORDER BY ACTIVITY_TYPE_DESC");
		rs = ps.executeQuery();
		while(rs != null && rs.next()){
			if(jv_activity_code.equals(rs.getString(1))){
		%>
			<option value="<%=rs.getString(1)%>" selected><%=rs.getString(2)%></option>
			<%}else{%>
			<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
		<%}}
		
		%>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		<input type="hidden" name="activity_desc" id="activity_desc" value="<%=jv_activity_desc%>">

	</td>
<%}else{%>
	<input type="hidden" name="activity_code" id="activity_code" value="<%=jv_activity_code%>">
	<td  >&nbsp;<input type="text" name="activity_desc" id="activity_desc" value="<%=jv_activity_desc%>" readonly>
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>
	
<%}%>
		
</tr>


<tr>
	<td colspan="5">&nbsp;</td>
</tr>

</tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td >
	<%if(jv_eff_status.equals("E")){%>
	<input type="checkbox" name="eff_status" id="eff_status" checked>
	<%}else{%>
	<input type="checkbox" name="eff_status" id="eff_status">
	<%}%>
	</td>
</tr>

<tr>
	<td colspan="5">&nbsp;</td>
</tr>
</table>
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
<%
}
catch(Exception exp)
{
	//out.println(exp.getMessage());//COMMON-ICN-0181
	exp.printStackTrace();
}finally{
		  if(rs!=null)
			  rs.close();
		  if(ps!=null)
			  ps.close();
		  ConnectionManager.returnConnection(con,request);
}
%>
</html>

