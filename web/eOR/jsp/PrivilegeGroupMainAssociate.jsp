<!DOCTYPE html>
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mode = request.getParameter("mode");
if(mode == null || mode.equals("null"))mode="";
//out.println("<script>alert('mode :"+mode+"');</script>");
//out.println("<script>alert('QueryString() :"+request.getQueryString()+"');</script>");
%>
<html>
<head>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<frameset cols='20%,80%'> 
<frame name="menuFrame" src="../../eOR/jsp/PrivilegeGroupTree.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="DetailsOfNode" src="../../eOR/jsp/PrivilegeGroupMainAssociateFrame.jsp?<%=request.getQueryString()%>" frameborder="0" noresize width=1 scrolling="no"></frame>
</frameset>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formMainAssociate" id="formMainAssociate">
<input type=hidden name="mode" id="mode" value='<%=mode%>'>
</form>
</body>
</html>

