<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	// Note :This Current page Existing Code have been Moved to OrderEntryTickSheetPanelsResult.jsp with the new code changes.
	
	String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //Ramesh
	
	String atomic_file_name		= "../../eCommon/html/blank.html";
	String group_file_name		= "../../eCommon/html/blank.html";
	String profile_file_name	= "../../eCommon/html/blank.html";
	String frame_size			= "0%,0%,0%";
	String order_catalog_nature = "";
	session.removeAttribute("orderSetVal");
	session.removeAttribute("panelVal");
	session.removeAttribute("individualVal");
	session.removeAttribute("pageVist");
	
	group_file_name		= "../../eOR/jsp/OrderEntryTickSheetPanelsResult.jsp?"+request.getQueryString()+"&order_nature=S&order_catalog_nature="+order_catalog_nature+"&order_dispaly_verticalYN="+order_dispaly_verticalYN;
			
	atomic_file_name	= "../../eOR/jsp/OrderEntryTickSheetPanelsResult.jsp?"+request.getQueryString()+"&order_nature=A&order_catalog_nature="+order_catalog_nature+"&order_dispaly_verticalYN="+order_dispaly_verticalYN;
	
	profile_file_name	= "../../eOR/jsp/OrderEntryTickSheetPanelsResult.jsp?"+request.getQueryString()+"&order_nature=P&order_catalog_nature="+order_catalog_nature+"&order_dispaly_verticalYN="+order_dispaly_verticalYN;
			 
%>
<html>
<head><title><fmt:message key="eOR.OrderEntryTickSheetItems.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="javascript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="javascript" src="../../eOR/js/OrderEntryToolTip.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!-- <frameset rows='<%=frame_size%>' framespacing=3 name="sectionFrame"> -->
	<iframe name="resultHdrFrame" id="resultHdrFrame" src= "<%=group_file_name%>" framespacing="0" noresize frameborder="0"  scrolling="yes"  style='height:0vh;width:90vw;display:none;'></iframe>
	<iframe name="resultListFrame" id="resultListFrame" src= "<%=profile_file_name%>"  framespacing="0" noresize frameborder="0"  scrolling="yes"  style='height:0vh;width:90vw;display:none'></iframe>
	<iframe name="resultDtlFrame" id="resultDtlFrame" src= "<%=atomic_file_name%>" framespacing="0" noresize frameborder="0"  scrolling="yes"  style='height:75vh;width:99vw'></iframe>
<!-- </frameset> -->
		

</html>


