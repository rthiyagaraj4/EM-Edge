<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Deficiency
	Function		:	This function is used add and modify the records
-->

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String operation="", deficiency_code="", short_desc="", long_desc="", eff_status="";
	String sql_defeciency="", modify_prop="", checked_prop="", mandatory_prop="";

	Connection con			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs			=	null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		

		operation=request.getParameter("operation");
		deficiency_code	= request.getParameter("deficiency_code");

		if(operation==null || operation.equals("null")) operation="insert";
		if(deficiency_code==null || deficiency_code.equals("null")) deficiency_code="";

		if(deficiency_code.equals(""))checked_prop="checked";

		if(operation.equals("modify"))
		{
			
			if(!(deficiency_code.equals("")))
			{
				sql_defeciency	=	"select long_desc, short_desc, eff_status from fm_deficiency where deficiency_code='"+deficiency_code+"'";
				rs=stmt.executeQuery(sql_defeciency);
				
				if(rs !=null && rs.next())
				{
					long_desc	= rs.getString("long_desc");
					short_desc	= rs.getString("short_desc");
					eff_status	= rs.getString("eff_status");
				}

				if(long_desc == null || long_desc.equals("null")) long_desc="";
				if(short_desc == null || short_desc.equals("null")) long_desc="";
				if(eff_status == null || eff_status.equals("null")) eff_status="D";
				
				if(eff_status.equals("E"))
				{
					checked_prop="checked";
					modify_prop="";
					mandatory_prop="readOnly";
				}
				else if(eff_status.equals("D"))
				{
					checked_prop="";
					modify_prop="readOnly";
					mandatory_prop="readOnly";
				}
			}
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exzception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con);
	}
	%>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="javascript" src="../js/FMDeficiency.js"></script>
	<script language="javascript" src="../js/FMCommon.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


</head>
<body ONLoad='javascript:document.forms[0].deficiency_code.focus();' OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="FMDeficiencyForm" id="FMDeficiencyForm" action="../../servlet/eFM.FMDeficiencyServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border="0" cellpadding="5" cellspacing="0" align='center' width='80%'>
<center>
<tr>
	<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='deficiency_code' id='deficiency_code' size='8' maxlength='8'  value='<%=deficiency_code%>' <%=mandatory_prop%> onKeyPress='return CheckForSpecChars(event);' onBlur='ChangeUpperCase(this);'><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' <%=modify_prop%> onBlur="makeValidString(this);" value="<%=long_desc%>"><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' <%=modify_prop%> onBlur="makeValidString(this);" value="<%=short_desc%>"><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E' <%=checked_prop%>></td>
</tr>
</center>
</table>
<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
</form>
</body>
</html>

