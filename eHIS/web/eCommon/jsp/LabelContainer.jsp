
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,com.ehis.persist.*" %>

<%
	String label = request.getParameter("labelId");
	
	String bundleName = "";	
	if (label.startsWith("Common")) bundleName = "eCommon.resources.Labels";
	else bundleName = label.substring(0,label.indexOf("."))+".resources.Labels";
	
	String message = SpringCacheBean.getLabel(pageContext,label,bundleName);

	out.print(message);
%>

