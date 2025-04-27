<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
23/05/2019	IN068778		Selvin M		23/05/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@ page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../../eOR/js/ResultReporting.js' ></script>
	<script language='javascript' src='../../eOR/js/ImageVideosFileUpload.js' ></script>
</head>
<BODY CLASS="MESSAGE" onKeyDown="lockKey()">
<p align="left">
<%
	String error=request.getParameter( "err_num" );
	String query_String = request.getQueryString();

	if ( error != null ) {		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
		String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		
		ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);	
		fbean.clear();
		fbean.checkAndLoadBean(order_id, order_line_num);
		putObjectInBean("MULTIPLEFILEUPLOADBEAN",fbean,session);		
		
		if(error.equals("FILE_SIZE_NOT_SUPPORTED") || error.equals("FILE_NOT_SUPPORTED")){
			out.println("<script>alert(getMessage('"+error+"'))</script>");
		}
		else
			out.println("<script>alert('"+error+"')</script>");
		
		if ( error_value.equals( "1" ) ||  error_value.equals("true")){	
			out.println( "<script language='JavaScript'>onsuccess();</script>" ) ;			
		}
		
		out.println( "<script language='JavaScript'>enable_buttons('"+called_from+"','"+order_id+"','"+order_line_num+"');</script>" ) ;
	}
%>
</p>
</BODY>

