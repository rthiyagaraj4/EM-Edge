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
*	Created By		:	Sreenivasulu.Y
*	Created On		:	24 Dec 2004

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/AssessmentCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode	   = request.getParameter("mode") ;
	
%>
<br><br><br><br><br><br><br><br><br>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod  method='POST' action='../../servlet/eCP.AssessmentCategoryServlet'
target='messageFrame'>

<% if (mode.equals("1")){%>

	<table cellpadding=0 cellspacing=0 border=0 width="75%" align='center'>
	    <tr>
		  <td width="40%" >&nbsp;</td>
  		  <td width="60%" colspan="2">&nbsp;</td>
	    </tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='10' maxlength='10' value='' name='assess_catg_code' id='assess_catg_code' onkeypress="return CheckForSpecChars(event);" onBlur=ChangeUpperCase(this); >
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value='' name='assessment_long_desc' id='assessment_long_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='15' maxlength='15' value='' name='assessment_short_desc' id='assessment_short_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		
       <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
		</tr>	

	
	</table>
	<%}
	else{

	String assess_catg_code=request.getParameter("assess_catg_code")==null ? "":request.getParameter("assess_catg_code");
	String short_desc="";
	String long_desc="";
	String eff_status="";
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
	String query_assess = "Select short_desc, long_desc, eff_status from CP_ASSESS_CATG_lang_vw where  assess_catg_code=? and language_id=?";
	pstmt = conn.prepareStatement(query_assess);
	pstmt.setString(1,assess_catg_code);
	pstmt.setString(2,locale);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
	short_desc=rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	long_desc=rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
	}
	}catch(Exception e){
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(conn,request);
	}
	
	%>

		<table cellpadding=0 cellspacing=0 border=0 width="70%" align='center'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='10' maxlength='10' value="<%=assess_catg_code%>" readonly name='assess_catg_code' onkeypress="return CheckForSpecChars(event);" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
	<%if(eff_status.equals("E"))
		{
		%>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=long_desc%>" name='assessment_long_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='15' maxlength='15' value="<%=short_desc%>"  name='assessment_short_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
<% }else{ %>	
				<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=long_desc%>" readonly name='assessment_long_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='15' maxlength='15' value="<%=short_desc%>" readonly name='assessment_short_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
				 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>

<% } %>
      	</table>

	<% } %>
		
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

	</form>
</body>
</html>

