<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
String mode = request.getParameter("mode");
if(mode == null || mode.equals("null"))mode="";
//out.println("<script>alert('mode :"+mode+"');</script>");
//out.println("<script>alert('QueryString() :"+request.getQueryString()+"');</script>");
%>
<html>
<head>
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%

//String bean_id = "privilegegroupbean" ;
//String bean_name = "eOR.PrivilegeGroupBean";

//PrivilegeExceptionGrpBean bean = (PrivilegeExceptionGrpBean)getBeanObject(bean_id,bean_name,request) ;
/* Initialize Function specific end */

//bean.clear();
%>
<frameset rows="18%,12%,*%,0%" framespacing=0>
<frame name="headerFrame" src= "../../eOR/jsp/PrivilegeGroupHdr.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="tabFrame" src="../../eOR/jsp/PrivilegeGroupTab.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="mainDetails" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
<frame name="colorcode" src='../../eCommon/html/blank.html' framespacing="0" noresize frameborder="0"  scrolling="no"></frame>

</frameset>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formMain" id="formMain">
<input type=hidden name="mode" id="mode" value='<%=mode%>'>
</form>
</body>
</html>

