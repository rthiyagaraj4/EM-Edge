
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,java.net.*,java.text.*,eCA.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/01/2024                 Hariharan k       	08/01/2024	            Ramesh Goli     ML-MMOH-CRF-2086
------------------------------------------------------------------------------------------------------------------------------
*/ %>


<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>

<%
	String	patient_id				 =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	
    Connection con 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	int PatientID_count= 0;
	try
	{    
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement( "SELECT COUNT(*)  TOTAL_COUNT FROM MP_PATIENT WHERE PATIENT_ID =? " ) ;
		pstmt.setString(1,patient_id);
		
		resultSet = pstmt.executeQuery() ;
		while ( resultSet != null && resultSet.next() ) {
			PatientID_count =  resultSet.getInt("TOTAL_COUNT");
		     out.print(PatientID_count);
		}
	} catch ( Exception e )	{
		
		e.printStackTrace() ;
		throw e ;
	} finally {
		
		
		if(con!=null) ConnectionManager.returnConnection(con,request);

	}%>
	
		
