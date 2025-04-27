<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OrganDisposal.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String disposal_code = request.getParameter("disposal_code")==null?"":request.getParameter( "disposal_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String disposal_code_disable="";
String disposal_desc="";
String status="";
String sql="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
//		sql="select disposal_code,disposal_desc, nvl(status,'E') status from  OT_ORGAN_DISPOSAL where disposal_code= ?";

		sql="select disposal_code,disposal_desc, nvl(status,'E') status from  OT_ORGAN_DISPOSAL_LANG_VW where disposal_code= ? AND LANGUAGE_ID = ?";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,disposal_code);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			disposal_desc=rs.getString("disposal_desc");
						
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
		
	disposal_code_disable="disabled";	
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
<form name="organDisposal_form" id="organDisposal_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.OrganDisposalServlet" method="post" target="messageFrame"> 
<br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%'  align=center>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr -->

<tr>
	<td class='label'><fmt:message key="eOT.DisposalCode.Label" bundle="${ot_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="disposal_code" id="disposal_code" value="<%=disposal_code%>" size=4 maxlength=4  <%=disposal_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="disposal_desc" id="disposal_desc" value="<%=disposal_desc%>"  size=30 maxlength=30 <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='fields' class=label><input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> ></td>
</tr>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=disposal_code1 value="<%=disposal_code%>">
<input type=hidden name=disposal_desc1 value="<%=disposal_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


