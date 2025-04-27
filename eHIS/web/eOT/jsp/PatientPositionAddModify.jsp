<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
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
<script language='javascript' src='../../eOT/js/Equipment.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String position_code = request.getParameter("position_code")==null?"":request.getParameter( "position_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String position_code_disable="";
String long_desc="";
String short_desc="";
String status="";
String sql="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql=" Select position_code, long_desc, short_desc, nvl(status,'E') status from OT_POSITION where position_code= ?";
		sql=" Select position_code, long_desc, short_desc, nvl(status,'E') status from OT_POSITION_LANG_VW where LANGUAGE_ID= ? AND position_code= ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,position_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			
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
		
	position_code_disable="disabled";	
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
<form name="equipment_form" id="equipment_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.PatientPositionServlet" method="post" target="messageFrame"> <br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%' align=center>
<!--<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>-->

<tr>
	<td class="label"><fmt:message key="Common.PositionCode.label" bundle="${common_labels}"/></td>
	<td class="fields">&nbsp;<input type="text" name="position_code" id="position_code" value="<%=position_code%>" size=4 maxlength=4  <%=position_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class="fields">&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size=30 maxlength=30 <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class="fields">&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"   size='15' maxlength='15' <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class="fields"><input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> ></td>
</tr>
<!--<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>-->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=position_code1 value="<%=position_code%>">
<input type=hidden name=long_desc1 value="<%=long_desc%>">
<input type=hidden name=short_desc1 value="<%=short_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


