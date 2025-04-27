<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
	<%-- JSP Page specific attributes start --%>
<%@ page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

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
	<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//System.out.println("Query String-----"+request.getQueryString());
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>
<iframe name="ordercatalog_header" id="ordercatalog_header" src='../../eOR/jsp/PrivilegeGroupCatalogHeader.jsp?<%=request.getQueryString()%>' frameborder="0" noresize width=1 scrolling="no" style='height:21vh;width:100vw'></iframe>
<iframe name="ordercatalog_result" id="ordercatalog_result" src='../../eOR/jsp/PrivilegeGroupCatalogDetails.jsp?<%=request.getQueryString()%>' frameborder="0" noresize width=1 scrolling="auto" style='height:86vh;width:100vw'></iframe>


</html>


