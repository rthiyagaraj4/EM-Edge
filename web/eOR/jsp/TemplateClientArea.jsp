<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%

%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>



	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="JavaScript" src="../js/Template.js"></script>
</head>
	<frameset rows="94.3%,5.9%" frameSpacing="0">
			<frameset cols="41%,59%" frameborder="yes" frameSpacing="0">
				<frame name="templateAssociateFrame" scrolling='no' noresize frameborder='no'  src="TemplateAssociate.jsp">
				<frame name="templateOrderListFrame" frameborder='no' scrolling='yes' noresize 	src="TemplateOrderList.jsp">
			</frameset>
	
		<frame name="templateRecordFrame" frameborder='no' scrolling='no' noresize src="TemplateRecord.jsp">
	</frameset>
 
</html>
