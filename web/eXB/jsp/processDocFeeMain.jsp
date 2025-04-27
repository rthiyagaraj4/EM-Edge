<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>  
 
<%@ page contentType="text/html;charset=UTF-8" %>
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8"); 
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXB/js/ProcessDocFee.js'></script>
<script language="javascript" src="../../eXI/js/MonitorItems.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String monQryCriteriaURL = "../../eXI/jsp/MonitorItemsMoreCriteria.jsp?funcID=XF_DF_HEALTHCAREDELIVERY&queueType=ONLINE";
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXB/jsp/processDocFee.jsp' frameborder=0 noresize scrolling='no' style='height:30%;width:100vw'></iframe><iframe name='monitorItemsMoreCriteria' id='monitorItemsMoreCriteria' src='<%= monQryCriteriaURL %>' frameborder=0 noresize scrolling='yes' style='height:120%;width:100vw'></iframe><iframe name='schemaBrowserResultFrame' id='schemaBrowserResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='' style='height:50%;width:100vw'></iframe>
</html>

