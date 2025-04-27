<!DOCTYPE html>

<%--
*	Created By		:	Sanjay Patil
*	Created On		:	19 jan 2005
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../js/EpisodeOfCare.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String mode	   = request.getParameter("mode") ;
%>
<br><br><br><br><br><br><br><br><br>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod  method='POST' action='../../servlet/eMR.EpisodeOfCareServlet'
target='messageFrame'>
<% if (mode.equals("1")){%>

	<table cellpadding=0 cellspacing=0 border=0 width="95%" align='center'>
	    <tr>
		 <!--  <td  >&nbsp;</td> -->
  		  <td  colspan="2">&nbsp;</td>
	    </tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align='left'>&nbsp;<input type='text' size='20' maxlength='20' value='' name='eoc_code' id='eoc_code' onkeypress="return CheckForSpecChars(event);" onBlur=ChangeUpperCase(this); >
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp;<input type='text' size='60' maxlength='100' value='' name='episode_long_desc' id='episode_long_desc'> &nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td align='left'>&nbsp;<input type='text' size='40' maxlength='50' value='' name='episode_short_desc' id='episode_short_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		
       <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align='left'>&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
		</tr>	

       <tr>
      <td colspan="5">&nbsp;</td>
      </tr>

	</table>
	<%}
	else{
		String eoc_code=request.getParameter("eoc_code")==null ? "":request.getParameter("eoc_code");

	String short_desc="";
	String long_desc="";
	String eff_status="";

	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
	String query_episode = "Select short_desc, long_desc, eff_status from mr_episode_of_care where  eoc_code='"+eoc_code+"'";
	pstmt = conn.prepareStatement(query_episode);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
	short_desc=rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	long_desc=rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
	}
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e){
	//out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(conn,request);
	}
	
	%>

		<table cellpadding=0 cellspacing=0 border=0 width="95%" align='center'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp;<input type='text' size='10' maxlength='10' value="<%=eoc_code%>" readonly name='eoc_code' onkeypress="return CheckForSpecChars(event);" >
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
	<%if(eff_status.equals("E"))
		{
		%>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp<input type='text' size='60' maxlength='100' value="<%=long_desc%>" name='episode_long_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp;<input type='text' size='40' maxlength='50' value="<%=short_desc%>"  name='episode_short_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td  align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
				<tr>
<td colspan='2'>&nbsp;</td>
</tr>
<% }else{ %>	
				<tr>
			<td class='label' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp;<input type='text' size='60' maxlength='100' value="<%=long_desc%>" readonly name='episode_long_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label'  align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td  align='left'>&nbsp;<input type='text' size='40' maxlength='50' value="<%=short_desc%>" readonly name='episode_short_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
				 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td  align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
<tr>
<td colspan='2'>&nbsp;</td>
</tr>

<% } %>
      	</table>

	<% } %>
		
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

	</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

