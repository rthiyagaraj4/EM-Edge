<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import=" eSS.*,eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eSS.ImagePreview.label" bundle="${ss_labels}"/></title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()">
<%
	String imageURL			= request.getParameter("item_image_file");
	if(imageURL==null){
%>
		<h1><fmt:message key="eSS.InvalidPageCall.label" bundle="${ss_labels}"/></h1>
<%		
		return;
	}

%>
		<table cellspacing='0' cellpadding='0' width='100%' height='100%'>
		<tr>
		<td class='WHITE' align='center' valign='middle'>
		<img src="<%=request.getParameter("item_image_file")%>" border=0 align='center' >
		</td>
		</tr>
		<tr>
		<td class='WHITE' align='right' valign='middle' height='5%'>
		<font size="1" color="#663399"><b><fmt:message key="eSS.ImageURL.label" bundle="${ss_labels}"/></b> <%=imageURL%></font>
		</td>
		</tr>
		</table>
	</body>

</html>

