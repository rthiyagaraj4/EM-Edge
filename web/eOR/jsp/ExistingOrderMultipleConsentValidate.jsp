
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id , bean_name, request) ;
	beanObj.clear();
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	String queryMode = (String) hash.get("QUERYMODE");
	System.out.println("=queryMode=="+queryMode+"Hash=="+hash);
	if(null!=queryMode && queryMode.equalsIgnoreCase("update"))
		{
			String consent_form_id = (String)hash.get("consent_form_id") ;
			String consent_form_stage = (String)hash.get("consent_form_stage") ;
			String order_sequence = (String)hash.get("order_sequence") ;
			String default_chk = (String)hash.get("default_chk") ;
			String ord_catalog_code = (String)hash.get("ord_catalog_code") ;
			String key=ord_catalog_code+"!!"+order_sequence;
			String value=consent_form_id+"!!"+consent_form_stage+"!!"+default_chk;
			System.out.println("key="+key+"==value=="+value);
			boolean dupilcate=beanObj.setModifyValues(key,value);
			if (dupilcate)
			{
			//System.out.println("coming here");
			String htmlVal = "document.getElementById('dupilcate').value=' "+dupilcate+" ' ";
			out.println(htmlVal);
			}
		}
		if(null!=queryMode && queryMode.equalsIgnoreCase("update_hdr"))
		{
			String consent_form_id = (String)hash.get("consent_form_id") ;
			String catalogIndex = (String)hash.get("catalogIndex") ;
			String consent_form_stage = (String)hash.get("consent_form_stage") ;
			String order_sequence = (String)hash.get("order_sequence") ;
			String default_chk = (String)hash.get("default_chk") ;
			String ord_catalog_code = (String)hash.get("ord_catalog_code") ;
			String key=ord_catalog_code+"!!"+order_sequence;
			String value=consent_form_id+"!!"+consent_form_stage+"!!"+default_chk;
			//System.out.println("key="+key+"==value=="+value);
			boolean dupilcate=beanObj.setModifyValues(key,value);
			if (dupilcate)
			{
			//System.out.println("coming here");
			String htmlVal = "document.getElementById('dupilcate'+catalogIndex).value=' "+dupilcate+" ' ";
			out.println(htmlVal);
			}
		}
	
	%>
