<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/15/2021              IN0071699          ChandraShekar Raju                                  				 MO-CRF-20166
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* " contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	    
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/Request.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 <title>
<%
        String request_by_store			=		request.getParameter("request_by_store")==null?"":request.getParameter( "request_by_store" ) ;
		String request_on_store			=		request.getParameter("request_on_store")==null?"":request.getParameter( "request_on_store" ) ; 
		String item_code				=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		String called_from              =       request.getParameter("called_from")==null?"":request.getParameter( "called_from" ) ;
        String bean_id					=		"RequestStatusBean";
		String bean_name				=		"eST.RequestStatusBean";

		RequestStatusBean bean		    =		(RequestStatusBean) getBeanObject(bean_id,bean_name,request); 
		bean.setLanguageId(locale);
		String store_desc               =       "";
		boolean searched				=	(request.getParameter("searched") == null) ?false:true;
		if(called_from.equals("REQ")){
			store_desc                =bean.getStoreDesc(request_by_store);
%>
         Issue History. Requesting(Receiving)Store:- <%=store_desc%>
<%}else{
	        store_desc                =bean.getStoreDesc(request_by_store);
%>
        Issue History. Request On(Issuing)Store:- <%=store_desc%>
<%}
%>
</title>
	</head>
</html>

