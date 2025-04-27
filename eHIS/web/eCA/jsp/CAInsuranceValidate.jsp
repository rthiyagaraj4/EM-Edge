<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN071639 		Sivabagyam			22/10/2019	Ramesh Goli			AAKH-CRF-0079.10							
28/01/2020  IN072296       SIVABAGYAM M  28/01/2020          Ramesh G      CA-AAKH-CRF-0079.10/02-Saved Approval Number doesn't display.					
------ ------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id="CAInsurenceAuthorizationFormsBean";
String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
CAInsurenceAuthorizationFormsBean bean	= (CAInsurenceAuthorizationFormsBean)getObjectFromBean( bean_id, bean_name , session); 

Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
hash						= (Hashtable)hash.get( "SEARCH" ) ;
Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");
String client_ip_address	= p.getProperty("client_ip_address");//IN072296
String loginuserid		=(String) session.getValue("login_user");//IN072296
String facility_id		=(String) session.getValue("facility_id");//IN072296
try{

		String approvalNumber=(String)hash.get("approvalNumber");
		String patient_id=(String)hash.get("patient_id");
		String encounter_id=(String)hash.get("encounter_id");
		String report_id=(String)hash.get("report_id");//IN072296
		//bean.insertApprovalNumber(patient_id,encounter_id,approvalNumber);//IN072296
		String result=bean.insertApprovalNumber(patient_id,encounter_id,report_id,approvalNumber,loginuserid,client_ip_address,facility_id);//IN072296
	}
catch (Exception e) {
	out.print("FAIL");
	e.printStackTrace();
}
putObjectInBean(bean_id,bean,session);

%>
