<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Hema Malini B
*	Created On		:	22 Jan 2005

-->

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>

<html>
<head>
  <%
  //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script src="../js/CPAccessRights.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function clearval()
{
	document.cp_access_right_header.practitioner_name.value="";
} 
</script>
</head>
<body onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
 <% 
	  Connection con 	      = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
	<form name="cp_access_right_header" id="cp_access_right_header">
	 <br>
     <table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
	 	 <tr><td colspan="4">&nbsp;</td></tr>
     <tr>
		<td align="right" class="label" >&nbsp;<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align="left" class="label" >&nbsp;
		<select name="practitioner_type" id="practitioner_type" onchange='clearDetail();'>
		<option value="" selected> &nbsp&nbsp--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		<%
		String pract_type ="";
		pract_type = "Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
		pstmt =con.prepareStatement(pract_type);
		rs = pstmt.executeQuery( );
		while(rs!=null  && rs.next())
		 {
			out.println("<option value='"+rs.getString("pract_type")+"'>"+rs.getString("desc_userdef")+""); 
		 }
		%>
		</select>
		</td> <td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr><td align="right" class="label">&nbsp;<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align="left" class="label" >&nbsp;&nbsp;<input type="text" name="practitioner_name" id="practitioner_name" maxlength="30" size="30" onchange='clearDetail();'></td>
		<TD align='left'>
			<SELECT name="search_text" id="search_text" onchange='clearDetail();'><!-- onchange="clearval()"-->
			<OPTION Value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="S">Stats With</OPTION>
			<OPTION Value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
		</TD><td>&nbsp;</td>
		</tr>
		<tr><td align="right" class="label">&nbsp;<fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align="left" class="label" >&nbsp;&nbsp;<input type="text" name="practitioner_id" id="practitioner_id" maxlength="15" size="15" onchange='clearDetail();'></td>
		<td>&nbsp;</td>
		<td  align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;</td>
		
		 </tr>
		 <tr><td colspan="4">&nbsp;</td></tr>
		  </table>	
	  </form>
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
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




