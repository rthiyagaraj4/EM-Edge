<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
	<%-- JSP Page specific attributes start --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	</head>
<iframe name="page_blank" id="page_blank" src='../../eOR/jsp/PrivilegeGroupBlankFrom.jsp' framespacing="0" noresize frameborder="0"  scrolling="no" style='height:18vh;width:100vw'></iframe>
<iframe name="ordertypedtls_header" id="ordertypedtls_header" src='../../eOR/jsp/PrivilegeGroupOrderTypeHeader.jsp?<%=request.getQueryString()%>' frameborder="0" noresize width=1 scrolling="no" style='height:34vh;width:100vw'></iframe>
<iframe name="ordertypedtls_result_frame" id="ordertypedtls_result_frame" src='../../eOR/jsp/PrivilegeGroupOrderTypeResult.jsp?<%=request.getQueryString()%>' frameborder="0" noresize width=1 scrolling="auto" style='height:54vh;width:100vw'></iframe>


</html>


