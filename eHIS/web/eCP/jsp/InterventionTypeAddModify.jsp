<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*,java.text.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"%>

<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
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
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/InterventionType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String mode	   = request.getParameter("mode") ;
%>
<br><br><br><br><br><br><br><br><br>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod  method='POST' action='../../servlet/eCP.InterventionTypeServlet'
target='messageFrame'>

<% if (mode.equals("1")){%>

	<table cellpadding=0 cellspacing=0 border=0 width="92%" align='center'>
	    <tr>
		  <td width="22%" >&nbsp;</td>
  		  <td width="78%" colspan="2">&nbsp;</td>
	    </tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value='' name='intervention_type' id='intervention_type' onkeypress="return CheckForSpecChars(event);" onBlur="ChangeUpperCase(this);">	
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='60' maxlength='60' value='' name='intervention_long_desc' id='intervention_long_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value='' name='intervention_short_desc' id='intervention_short_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
       <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
		</tr>	
<tr><td colspan=2>&nbsp;</td></tr>
</table>
<%
	}
	else
	{
	conn = ConnectionManager.getConnection(request);

	String intervention_type=request.getParameter("intervention_type")==null ? "":request.getParameter("intervention_type");
	String short_desc="";
	String long_desc="";
	String eff_status="";
	String sys_defined="N";
	String readOnly="";

	try{
	//String query_assess = "select  long_desc,short_desc, eff_status from ca_intervention_type where  intervention_type=?";
	String query_assess = "SELECT  long_desc,short_desc, eff_status,system_defined_yn FROM ca_intervention_type_lang_vw WHERE  intervention_type=? AND language_id like ?";
	pstmt = conn.prepareStatement(query_assess);
	pstmt.setString(1,intervention_type);
	pstmt.setString(2,locale);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
	short_desc=rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	long_desc=rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
	sys_defined=rs.getString("system_defined_yn")==null ? "N":rs.getString("system_defined_yn");
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
	if(sys_defined.equals("Y"))
	{
		sys_defined="checked";
		readOnly="readonly";
	}
	else
	{
		sys_defined="";
		readOnly="";
	}
%>
<table cellpadding=0 cellspacing=0 border=0 width="92%" align='center'>
<tr><td colspan=2>&nbsp;</td></tr>
<tr>
<td class='label' width='22%' align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value="<%=intervention_type%>" readonly name='intervention_type' onkeypress="return CheckForSpecChars(event);" " >
<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<tr><td colspan=2>&nbsp;</td></tr>
<%
	if(eff_status.equals("E"))
	{
%>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='60' maxlength='60' value="<%=long_desc%>" name='intervention_long_desc' <%=readOnly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=short_desc%>"  name='intervention_short_desc' <%=readOnly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="22%" align="left" class="label"><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type=checkbox name="sys_defnd" id="sys_defnd"  <%=sys_defined%> disabled></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="22%" align="left" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
						 <tr><td colspan=2>&nbsp;</td></tr>

<% }else{ %>	
				<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='60' maxlength='60' value="<%=long_desc%>" readonly name='intervention_long_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='22%' align='left'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='78%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=short_desc%>" readonly name='intervention_short_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="22%" align="left" class="label"><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type=checkbox name="sys_defnd" id="sys_defnd"  <%=sys_defined%> disabled></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="22%" align="left" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>

<% } %>
      	</table>

	<% } %>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>
</body>
</html>

