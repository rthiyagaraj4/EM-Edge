<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mode = request.getParameter("mode");
//System.out.println("====="+request.getParameter("mode"));
if(mode == null || mode.equals("null")) mode="";
String tabvalue = request.getParameter("tabvalue");
if(tabvalue == null || tabvalue.equals("null"))tabvalue="";
//out.println("<script>alert('mode :"+tabvalue+"');</script>");
//out.println("<script>alert('QueryString() :"+request.getQueryString()+"');</script>");
%>
<html>
<head><title>PrivilegeGroupMainSelect</title>
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
</head>
<frameset rows='45%,*%'>
<frameset cols='50%,50%'> 
<frame name="ordercataegorydtls" src="../../eOR/jsp/PrivilegeGroupOrderCategory.jsp?&tabvalue=<%=tabvalue%>&mode=<%=mode%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="ordertypedtls" src='../../eCommon/html/blank.html' frameborder="0" noresize width=1 scrolling="no"></frame>
</frameset>
<frameset rows='38%,50%'> 
<frame name="detailFrameCatalog" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="detailFramecatalogDetails" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
</frameset>
</frameset>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formMainSelect" id="formMainSelect">
<input type=hidden name="mode" id="mode" value='<%=mode%>'>
</form>
</body>
</html>
