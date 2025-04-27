<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
15/05/2018  	IN065254		Kamalakannan G  		15/05/2018 		 Ramesh G 		GHL_CRF_0485
21/05/2018 		IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/02
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.*, eCP.*, eMR.*, eCA.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eOR.* ,eOR.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
	request.setCharacterEncoding("UTF-8");
	//String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; commenetd for checkstyle
	String bean_id = "CP_ReportBean" ;
	String bean_name = "eCP.ReportBean";
	ReportBean bean = (ReportBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	bean.callTaskStatusOnLinePrintReport(hash,request,response);
	
	%>
