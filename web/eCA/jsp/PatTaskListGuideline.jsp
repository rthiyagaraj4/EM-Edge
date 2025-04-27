<!DOCTYPE html>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        Description
------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           created
04/12/2012		IN036670		Ramesh G	Patient Instructions for Interventions is associated for a Care Plan->The Care Plan is generated->
											Manage Care Plan Task List and View Care Plan details we get Null in Intervention Details 
------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title>Guide Lines</title>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- <link rel="stylesheet" type="text/css" href="../html/IeStyle.css">	 -->
</head>
<%
Connection con = null;
ResultSet rs = null;
PreparedStatement stmt = null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String guideline = "";
String intervention_short_desc = "";
String intervention_code ="";
try
{
	intervention_code = request.getParameter("intervention_code")==null?"":request.getParameter("intervention_code");
	con = ConnectionManager.getConnection(request);
	//String qry = "select INTERVENTION_GUIDELINE, SHORT_DESC from ca_intervention where INTERVENTION_CODE = '" + intervention_code + "' ";
	//[IN036670] Start.
	//String qry = "select INTERVENTION_GUIDELINE, CA_GET_DESC.CA_INTERVENTION(?,?,'2') SHORT_DESC from ca_intervention ";  
	String qry = "select INTERVENTION_GUIDELINE, CA_GET_DESC.CA_INTERVENTION(?,?,'2') SHORT_DESC from ca_intervention  where INTERVENTION_CODE = ?";  
	//[IN036670] End.
	stmt = con.prepareStatement(qry);
	stmt.setString(1,intervention_code);
	stmt.setString(2,locale);
	stmt.setString(3,intervention_code);  //[IN036670]
	rs = stmt.executeQuery();
	if(rs.next())
	{
		guideline = rs.getString("INTERVENTION_GUIDELINE");
		intervention_short_desc = rs.getString("SHORT_DESC");
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	
}
%>
<body onKeyDown='lockKey()'>
<table border='0' cellpadding='0' cellspacing='0' width="100%"  align='center'>
	<tr>
		<td class="label">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Intervention.label" bundle="${common_labels}"/>:<b><%=intervention_short_desc%></b>
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
	<tr>
		<td align="center" class="label">
			<textarea rows=14 cols=65 readonly><%=guideline%></textarea>
			<input type="button" name="closeWindow" id="closeWindow" class="button" onclick="javascript:window.close();" value="   Close   ">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
	<tr>
		<td align='center'>
			
		</td>
	</tr>
</table>
</body>
</html>

