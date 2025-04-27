<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------
29/02/2016	IN057106_changed Vijayakumar K	29/02/2016		Ramesh Goli		ML-MMOH-CRF-0328 files created newly
---------------------------------------------------------------------------------------------------------------
-->
<%@ page language="java" import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");

Connection			con		= null;
PreparedStatement	pstmt	= null;
ResultSet			rs		= null;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
  
  <head> <title><fmt:message key="eCA.antibodydetails.label" bundle="${ca_labels}"/> </title> </head>

  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table class='grid'  border='1' width='100%' cellpadding='3' cellspacing='0'>
		<tr>
			<td class='columnheadercenter'  width='30%' nowrap ><fmt:message key="eCA.antibodycode.label" bundle="${ca_labels}"/></td>
			<td class='columnheadercenter'  width='30%' nowrap ><fmt:message key="eCA.antibodydescription.label" bundle="${ca_labels}"/></td>
			<td class='columnheadercenter'  width='30%' nowrap ><fmt:message key="eCA.resultdatetime.label" bundle="${ca_labels}"/></td>
			
		</tr>
	</table>
	<% 
	con = ConnectionManager.getConnection(request);
	try
	{
		String antibody_details_query="SELECT a.ANTIBODY_CODE, SHORT_DESC, LAST_REPORTED_DATE FROM (SELECT A.ANTIBODY_CODE ANTIBODY_CODE,A.PATIENT_ID PATIENT_ID, A.LAST_REPORTED_DATE FROM BT_PATIENT_ANTIBODY A UNION SELECT DISTINCT C.ANTIBODY_CODE ANTIBODY_CODE,B.PATIENT_ID PATIENT_ID, C.LAST_REPORTED_DATE FROM BD_DONOR_MAST_DTLS B, BT_DONOR_ANTIBODY C WHERE B.DONOR_ID = C.DONOR_ID ) a,BT_ANTIBODY_CODE_MAST_LANG_VW b  WHERE a.ANTIBODY_CODE = b.ANTIBODY_CODE AND b.language_id = ? AND PATIENT_ID = ? ORDER BY LAST_REPORTED_DATE DESC";
		String antibody_code = "";
		String short_desc = "";
		String last_reported_date = "";
	
		pstmt= con.prepareStatement(antibody_details_query);
		pstmt.setString	(	1,	locale	);
		pstmt.setString	(	2,	p_patient_id	);
	
	
		rs= pstmt.executeQuery();
		out.println("<table border='1' width='100%' cellpadding='3' cellspacing=0>");
		while (rs.next())
		{
		
			
			antibody_code = rs.getString("ANTIBODY_CODE")==null?"":rs.getString("ANTIBODY_CODE");
			short_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			last_reported_date = rs.getString("LAST_REPORTED_DATE")==null?"":rs.getString("LAST_REPORTED_DATE");
		
			
			out.println("<tr><td width='30%' class='gridData' >"+antibody_code+"</td><td width='30%' class='gridData' >"+short_desc+"</td><td width='30%' class='gridData' >"+last_reported_date+"</td></tr>");	
	
		
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con);
		out.println("</table>");
	

	}
	catch(Exception e )
	{
		e.printStackTrace() ;
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

	 %>
</body>
</html>
