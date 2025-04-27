<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/Reasons.js'></script>
 <script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String reason_code = request.getParameter("reason_code")==null?"":request.getParameter( "reason_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String reason_code_disable="";
String reason_desc="";
String status="";
String sql="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql="select reason_code,reason_desc, nvl(status,'E') status from  OT_REASONS where reason_code= ?";
		sql="select reason_code,reason_desc, nvl(status,'E') status from  OT_REASONS_LANG_VW where reason_code= ? AND LANGUAGE_ID='"+locale+"' ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,reason_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			reason_desc=rs.getString("reason_desc");
						
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
	reason_code_disable="disabled";	
}catch(Exception e)
	{
		e.printStackTrace();
		//System.err.println("Err ReasonsAddModify" +e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//System.err.println("Err ReasonsAddModify" +e);
			}
		
		}
}
%>
<form name="reason_form" id="reason_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ReasonsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding="3" width='100%'  align="center">
<tr>
	<td class='label' width="25%">
	<fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" colspan="3">
	<input type="text" name="reason_code" id="reason_code" value="<%=reason_code%>" size=6 maxlength=6  <%=reason_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class='label' width="25%" valign=top >
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'	width="25%" >
	<textarea  name="reason_desc" rows=5 cols=40  onBlur="checkMaxLimit1(this,255);makeValidString(this)" <%=disable_flag%>><%=reason_desc%></textarea><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='fields' width="25%" colspan="2"> </td>
</tr>

<tr>
	<td class='label' width="25%" >
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
	<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
	<td class='fields' width="25%" colspan="2"> </td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="reason_code1" id="reason_code1" value="<%=reason_code%>">
<input type="hidden" name="reason_desc1" id="reason_desc1" value="<%=reason_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


