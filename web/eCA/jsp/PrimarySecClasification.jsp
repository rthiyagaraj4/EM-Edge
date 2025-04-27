<!DOCTYPE html>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2022  36285          Hariharan k       		            Ramesh Goli              MMs-DM-CRF-0221.v1.0(003)
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,java.net.*,java.text.*,eCA.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	System.out.println("----------PrimarySec...........");
/*
     String bean_id 						= "@ProceduresBean";// 36285
     String bean_name 					= "eCA.ProceduresBean";// 36285
     ProceduresBean bean					= (ProceduresBean)getBeanObject( bean_id, bean_name, request ) ;// 36285
     int  validatePrimaryClassificationAvaliableYN = bean.getProceduresData(patient_id,proc_code,proc_code_schem,facility_id);
	*/
	String  patient_id		= request.getParameter( "patient_id" );
   // String  proc_code		= request.getParameter( "proc_code" );
    String  proc_code_scheme		= request.getParameter( "proc_code_scheme" );
    String  facility_id		= request.getParameter( "facility_id" );
    System.out.println("patient_id-----"+patient_id);
    //System.out.println("proc_code---"+proc_code);
    //System.out.println("proc_code_scheme----"+proc_code_scheme);
    //System.out.println("facility_id-----"+facility_id);
    
	
    Connection con 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	int primaryClassification_count= 0;
	try
	{    
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement( "SELECT COUNT(*)  TOTAL_COUNT  FROM pr_encounter_procedure WHERE PATIENT_ID=? AND  PROC_CODE_SCHEME =?   AND facility_id =?  AND CLASSIFITION_TYPE = 'P' AND ERROR_YN='N' " ) ;
		pstmt.setString(1,patient_id);
		//pstmt.setString(2,proc_code);
		pstmt.setString(2,proc_code_scheme);
		pstmt.setString(3,facility_id);
		
		resultSet = pstmt.executeQuery() ;
		while ( resultSet != null && resultSet.next() ) {
			 primaryClassification_count =  resultSet.getInt("TOTAL_COUNT");
		     //System.out.println("----primaryClassification_count-----"+ primaryClassification_count);
		    
		     out.print(primaryClassification_count);
		}
	} catch ( Exception e )	{
		
		e.printStackTrace() ;
		throw e ;
	} finally {
		
		
		if(con!=null) ConnectionManager.returnConnection(con,request);

	}
		
%>
