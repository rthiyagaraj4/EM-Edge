<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/WoundType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<!--body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false"-->  <!--Commented Against GHL-SCF-1519-->
<body>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");

String wound_type_code = request.getParameter("wound_type_code")==null?"":request.getParameter( "wound_type_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String wound_type_code_disable="";

String long_desc="";
String wound_text="";

String status="";
String sql="";

if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql=" Select wound_type_code, long_desc, wound_text, nvl(status,'E') status from OT_WOUND_TYPE where wound_type_code= ?";

		sql="Select wound_type_code, long_desc, wound_text, nvl(status,'E') status from OT_WOUND_TYPE_LANG_VW where LANGUAGE_ID= ? AND wound_type_code= ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,wound_type_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			long_desc=rs.getString("long_desc");
			wound_text=rs.getString("wound_text");
			
			status=rs.getString("status");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	wound_type_code_disable="disabled";	
}catch(Exception e)
	{
	e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		}
}
%>
<form name="wound_type_form" id="wound_type_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.WoundTypeServlet" method="post" target="messageFrame"> 
<br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%'  align=center>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->

<tr>
	<td class='label'>
		<fmt:message key="eOT.WoundTypeCode.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="wound_type_code" id="wound_type_code" value="<%=wound_type_code%>" size=4 maxlength=4  <%=wound_type_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class='label'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size=30 maxlength=30 <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class='label' valign=top>
		<fmt:message key="Common.Text.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<textarea  name="wound_text" rows=5 cols=40 onBlur="checkMaxLimit1(this,200);makeValidString(this)" <%=disable_flag%>><%=wound_text%></textarea>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class='label'>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=wound_type_code1 value="<%=wound_type_code%>">
<input type=hidden name=long_desc1 value="<%=long_desc%>">
<input type=hidden name=wound_text1 value="<%=wound_text%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


