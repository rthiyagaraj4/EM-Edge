
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.sql.*,java.util.*, eOR.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
 if(operation_mode.equals("patIDValid"))
{
	Connection con = null;
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	String facilityid=(String)session.getValue("facility_id");
	String patientIdStatus="";
	patdata.setFacility_id(facilityid);
	try
	{
		con =  ConnectionManager.getConnection(request);
		String pat_id = request.getParameter("patientId");
		patientIdStatus = patdata.CheckStatus(con,pat_id);
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		out.println("Exception caught in IPConsultationIntermediate.jsp validate pat_id" + e);
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	out.println("patValidCheck(\""+patientIdStatus+"\");");
}
%>
