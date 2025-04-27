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
*	Created On		:	30 Dec 2004

--%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>

<html>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script language="javascript" src="../js/CpMessages.js"></script>  
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script src="../js/LevelOfCareForDependency.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <%
  
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			  <tr><td colspan="4">&nbsp</td></tr>
			    <tr>
				<td align="right" class="label" width="25%"><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/>&nbsp;</td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;
				<select name="level_care_code" id="level_care_code" onChange="clearDetail()">
				<option value="" selected> &nbsp&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				<%
					String level_care ="";
					level_care = "Select level_of_care_code, level_of_care_desc from am_level_of_care where eff_status = 'E' order by level_of_care_desc";
					pstmt =con.prepareStatement(level_care);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next())
					 {
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
				%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
			  </tr>
			 <tr><td colspan="4">&nbsp</td></tr>
		  </table>	
	  </form>
 <%}catch(Exception e)
	{
		out.println("Error is ---"+e);
	}
finally
  {
  			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
  }
%>
</body>
</html>




