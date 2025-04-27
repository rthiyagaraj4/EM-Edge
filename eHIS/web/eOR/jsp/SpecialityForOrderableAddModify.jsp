<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eOR/js/SpecialityForOrderable.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORGeneraOl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="f_query_add_mod_header" id="f_query_add_mod_header" src= "../../eOR/jsp/SpecialityForOrderableAddModifyHeader.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:4vh;width:100vw"></iframe>
<iframe name="f_query_add_mod_dtl_header" id="f_query_add_mod_dtl_header" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:17vh;width:100vw"></iframe>
<iframe name="f_query_add_mod_detail" id="f_query_add_mod_detail" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="no" style='height:80vh;width:100vw'></iframe>

</html>

