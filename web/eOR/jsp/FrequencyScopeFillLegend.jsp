<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
	
	//String bean_id = request.getParameter( "bean_id" ) ;
//	String fill = request.getParameter( "fill" ) ;
	
	//FrequencyScopeBean beanObj = (FrequencyScopeBean)mh.getBeanObject( bean_id, request , "eOR.FrequencyScopeBean") ;
	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	//String freq_code = (String)hash.get("freq_code") ;
	//String record="";
	
	String legend = "";//(String)beanObj.getFreqValues(freq_code) ;
	
	if(legend  == null) 		legend  = "";
	else						legend  = legend .trim();

 	out.println( "fillLegendText(\"" + legend + "\") ; " ) ;
		
%>
