
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% /*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		           Rev.Date		   Rev.Name			   Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
14/12/2023    53188       K krishna pranay           15/12/2023     Ramesh Goli         ML-MMOH-SCF-2591
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<head>

<script language="JavaScript">
</script>

</head>

<BODY CLASS="MESSAGE"  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<p align="left">
<%   
     request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097//53188
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String error=request.getParameter( "err_num" );

	if ( error != null ) {
		out.println( error ) ;


		String queryString = (String) session.getValue( "IPQueryString" ) ;
		if ( queryString == null ) queryString = "" ;
		out.println( "<script language='JavaScript'>if(parent.commontoolbarFrame) parent.commontoolbarFrame.location.href='CommonToolBarLocalModal.jsp?" + queryString + "';</script>" ) ;

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>parent.onSuccess();</script>" ) ;
	}

%>
</p>
</BODY>

