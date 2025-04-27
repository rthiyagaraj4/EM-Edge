<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
11/09/2013   IN043253	 Chowminya	Ticksheet has more than 5 sections in it, the 6th section onwards displays below and it is hidden
30/07/2020	 IN073551	 Nijitha	30/07/2020	Ramesh G 	MMS-KH-SCF-0092
-----------------------------------------------------------------------
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title><fmt:message key="eOR.OrderEntryResultMain.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%     
	//out.println("<script>alert('additional OrderEntryFrameSet"+request.getQueryString()+"');</script>");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String  tab_name 			= request.getParameter("tab_name");
	if(tab_name == null || tab_name.equals("")) tab_name = "";
	String ammend_called_from	= request.getParameter("ammend_called_from");
	String function_from = request.getParameter("function_from");//IN073551
	if(ammend_called_from == null || ammend_called_from.equals("")) ammend_called_from = "";
	String called_from			= request.getParameter("called_from"); // Parameter is passed from OrderEntryCommonTabs.jsp
	String licence_key			= request.getParameter("licence_key"); // Parameter is passed from OrderEntryCommonTabs.jsp
	if(called_from == null || called_from.equals("")) called_from = "";
	if(licence_key == null || licence_key.equals("")) licence_key = "";
	if(ammend_called_from.equalsIgnoreCase("existing_order") && tab_name.equals(""))
		tab_name				 = "PlaceOrder";
	else if(licence_key.equals("ORPV") && called_from.equals("ON_LOAD") && tab_name.equals(""))
		tab_name				 = "PlaceOrder";	//If it Pharmacy Version for Alrabha
	else if("HIGH_RISK_ASSESS".equals(function_from))//IN073551
		tab_name				 = "PlaceOrder";//IN073551
		

	String frequent_orders_allowed_yn	= "N";  // Remove this variable and reference later, when frequent order is given


 	if(tab_name.equals("") || tab_name.equals("FrequentOrders") && frequent_orders_allowed_yn.equals("Y"))
	{
		if(!ammend_called_from.equalsIgnoreCase("existing_order"))
		{
%>
 			<!-- <frameset cols="50%,50%" framespacing=0 name="OrderEntryFrameset"> -->
				<iframe name="criteriaMainFrame" id="criteriaMainFrame" src= "../../eOR/jsp/OrderEntryRecentlyFrameSet.jsp?search_by=practitioner&<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:30vh;width:99vw'></iframe>
				<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eOR/jsp/OrderEntryRecentlyFrameSet.jsp?search_by=patient&<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:56vh;width:99vw'></iframe>
			<!-- </frameset> -->
<%		}  else { %>
			<script>alert(getMessage("FREQUENT_NOT_SELECT","COMMON"));</script>
<%		} %> 
 
<%	} else if(tab_name.equals("") || tab_name.equals("AdditionalSearch"))
	{ //out.println("<script>alert('frameset"+request.getQueryString()+"');</script>");
%>
	<!-- 	<frameset rows="30%,*,0" framespacing=0 name="OrderEntryFrameset"> -->
			<iframe name="criteriaMainFrame" id="criteriaMainFrame" src= "../../eOR/jsp/OrderEntryAdditionalSearch.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:24vh;width:99vw'></iframe>
			<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style='height:70vh;width:99vw'></iframe>
			<iframe name="orderTypeLookUpFrame"  id="orderTypeLookUpFrame" 	src= "../../eCommon/html/blank.html" framespacing="0"	 	noresize frameborder="0"  scrolling="yes" style='height:0vh;width:100vw'></iframe>
	<!-- 	</frameset> -->
<%	} else if(tab_name.equals("TickSheet")){ %>
	<!-- 	<frameset rows="22%,6%,*" framespacing=0 name="OrderEntryFrameset"> -->
			<iframe name="criteriaMainFrame" id="criteriaMainFrame" src= "../../eOR/jsp/OrderEntryTickSheets.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:30vh;width:99vw'></iframe>
			<iframe name="criteriaDetailFrame"  id="criteriaDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0" scrolling="auto" style='height:56vh;width:99vw'></iframe><!-- IN043253 -->
			<iframe name="criteriaTickSheetsFrame" id="criteriaTickSheetsFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0" style='height:72vh;width:100vw'></iframe>
		<!-- </frameset> -->
<%	} else if(tab_name.equals("CareSet")){ %>
		<!-- <frameset rows="35%,*,7%" framespacing=0 name="OrderEntryFrameset">-->
			<iframe name="criteriaMainFrame" id="criteriaMainFrame" src= "../../eOR/jsp/OrderEntryCareSetSearch.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:30vh;width:99vw'></iframe>
			<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="auto" style='height:56vh;width:99vw'></iframe>
			<iframe name="criteriaButtonFrame"   id="criteriaButtonFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:53vh;width:99vw'></iframe>
	<!--  	</frameset>-->
<%	} else if(tab_name.equals("")  || tab_name.equals("PlaceOrder")){ %>

		<!-- <frameset rows="7%,*" framespacing=0 name="OrderEntryFrameset"> -->
			<iframe name="criteriaCategoryButtonFrame" id="criteriaCategoryButtonFrame" src= "../../eOR/jsp/OrderEntryCategoryButtons.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:6vh;width:100vw'></iframe>
			<iframe name="criteriaPlaceOrderFrame"  id="criteriaPlaceOrderFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:92vh;width:100vw'></iframe>
		<!-- </frameset>-->
<%	} %>
</html>

