<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%   String acode    =    "";
     String AREA_DESC=    "";
	 request.setCharacterEncoding("UTF-8");
     acode	       =	(request.getParameter("acode")==null)? "" : request.getParameter("acode");
     AREA_DESC	   =	(request.getParameter("AREA_DESC")==null)? "" : request.getParameter("AREA_DESC");
%>
	<html>
	<head>
	<!-- <title>Patient(s) in <%=acode%> / <%=AREA_DESC%></title> -->

	<title><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.in.label" bundle="${common_labels}"/> <%=acode%> / <%=AREA_DESC%></title>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js'></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'>
	<center>
	<form name='MOAreaAvailpopulate_form' id='MOAreaAvailpopulate_form' >
<%
	String classValue	= "";
	Connection	con		= null;
	Statement	st		= null;
	ResultSet	rs		= null;
	
	String facility_id  = "";
	String regno        = "";
	String pid          = "";
	String PATIENT_NAME = "";
	String bed_no       = "";
	int rowIndex        = 1;
	int count	    	= 0;
		
	try
	{
		con				  =	(Connection)ConnectionManager.getConnection(request);
		facility_id		  =	(String)		session.getValue("facility_id");
		String locale=(String)session.getAttribute("LOCALE"); 
		StringBuffer sql2 =new StringBuffer();
		sql2.setLength(0);
		sql2.append("select count(*) from mo_mortuary_regn_vw where facility_id='"+facility_id+"' and area_code='"+acode+"' and release_body_date is null order by REGISTRATION_NO");
	   	st	=	con.createStatement();
		rs  =st.executeQuery(sql2.toString());
	    sql2.setLength(0);
		while(rs!=null && rs.next())
		{
			count = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(count>0)
		{
%>  <table cellspacing=0 align='center' cellpadding=0 width='100%' border='1' cellpadding=0 cellspacing=0>
		<td class='columnheader' width='10%'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td> 
		<td class='columnheader' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='30%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='1%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<%
		StringBuffer sql1 =new StringBuffer();
		sql1.setLength(0);
		sql1.append("select REGISTRATION_NO, PATIENT_ID,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,bed_no from mo_mortuary_regn_vw where facility_id='"+facility_id+"' and area_code='"+acode+"' and release_body_date is null order by REGISTRATION_NO");
		st	=	con.createStatement();
		rs=st.executeQuery(sql1.toString());
		while(rs!=null && rs.next())
		{
		classValue	=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
		rowIndex++;
		regno = rs.getString("REGISTRATION_NO");
		if(regno==null) regno = "&nbsp;";
		pid = rs.getString("PATIENT_ID");
		if(pid==null) pid = "&nbsp;";
		PATIENT_NAME = rs.getString("PATIENT_NAME");
		if(PATIENT_NAME==null) PATIENT_NAME = "&nbsp;";
		bed_no = rs.getString("bed_no");
		if(bed_no == null) bed_no = "&nbsp;";
%>
	<tr>
	    <td class='<%=classValue%>' > <font size=1><%=regno%></td>
		<td class='<%=classValue%>' > <font size=1><%=pid%></td>
		<td class='<%=classValue%>' > <font size=1><%=PATIENT_NAME%></td>
		<td class='<%=classValue%>' > <font size=1><%=bed_no%></td></tr>
<%
		}
		}
		else
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); cancelOperation();</script>");
		}
	    if(rs!=null) rs.close();
		if(st!=null) st.close();
	}
	catch(Exception e)
	{
		out.println("Exception@1: " +e);
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	</table>
	<p align='center'>
	&nbsp;
	<input type='button' class='BUTTON' name='cancel' id='cancel' value='Close' onClick='cancelOperation()'>
	</p>
	<br>
	</form>
	</center>
	</body>
	</html>

