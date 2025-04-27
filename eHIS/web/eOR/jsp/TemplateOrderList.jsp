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
	<iframe name="templateListFrame" id="templateListFrame" scrolling='auto' noresize frameborder='yes'  src="TemplateList.jsp" style='height:94vh;width:100vw'></iframe>
	<iframe name="templatePreviewFrame" id="templatePreviewFrame" frameborder='no' scrolling='no' noresize src="TemplatePreview.jsp" style='height:6vh;width:100vw'></iframe>
 
</html>

