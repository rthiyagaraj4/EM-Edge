<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";
	String bean_id1 = "Or_ResultReporting";
	String bean_name1 = "eOR.ResultReportingBean";
	String ref_form_text = "";
	//String reason = "";
	RegisterOrder bean = (RegisterOrder)getBeanObject( bean_id,bean_name , request) ;
	ResultReportingBean bean1 = (ResultReportingBean)getBeanObject( bean_id1,bean_name1 , request) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	bean_id = (String)hash.get("bean_id");
	bean_name = (String)hash.get("bean_name");
	bean_id1 = (String)hash.get("bean_id1");
	bean_name1 = (String)hash.get("bean_name1");

	if(hash.containsKey("referral_form_text"))
	{
		ref_form_text = (String)hash.get("referral_form_text");
		bean.setRefFormContent(ref_form_text);
		bean1.setRefFormContent(ref_form_text);
	}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
	
%>
