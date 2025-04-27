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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name="templateDescriptionFrame" id="templateDescriptionFrame" src="TemplateDescription.jsp" scrolling='no' noresize frameborder='no' style='height:22vh;width:100vw'></iframe>
	<iframe name="templateClientAreaFrame" id="templateClientAreaFrame" frameborder='no' scrolling='no' noresize src="TemplateClientArea.jsp" style='height:88vh;width:100vw'></iframe>
 
</html>

