<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id 		= request.getParameter( "bean_id" ) ;
	//String patient_id 	= request.getParameter( "patient_id" ) ;
	//String flag			= request.getParameter("flag");

	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;



	//PatientValidate beanObj = (PatientValidate)mh.getBeanObject( bean_id, request , "eOR.PatientValidate") ;
	PatientValidate beanObj = (PatientValidate)getBeanObject( bean_id, "eOR.PatientValidate", request ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    String patient_id = (String)hash.get("patient_id") ;
    if ( patient_id == null || patient_id.equals( "" ) )
		patient_id = "";
    //out.println("alert('"+patient_id+"')");
    String[] record = beanObj.isValidPatient(patient_id) ;
    out.println( "addPatientList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
	
	putObjectInBean(bean_id,beanObj,request);

%>
