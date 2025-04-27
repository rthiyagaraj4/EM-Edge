<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Review Date 		Review Name 		Description
-------------------------------------------------------------------------------------------------------------------------------------
27/12/2022		37051			Ramesh Goli		27/12/2022			Ramesh G 			ML-MMOH-CRF-1939.1
-------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<html>
	<head>
 	<title><fmt:message key="eOR.OTAppointment.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_id 			= CommonBean.checkForNull(request.getParameter("order_id"),"");
	String practitioner_id 		= CommonBean.checkForNull(request.getParameter("practitioner_id"),"");
	String pref_surg_date 		= CommonBean.checkForNull(request.getParameter("pref_surg_date"),"");
	if(!localeName.equals("en")){
	pref_surg_date = com.ehis.util.DateUtils.convertDate(pref_surg_date,"DMY","en",localeName);
	}

	String practitioner_name 	= CommonBean.checkForNull(request.getParameter("practitioner_name"),"");
	String fpp_yn		= CommonBean.checkForNull(request.getParameter("fpp_yn"),"");		//37051
	String fpp_category	= CommonBean.checkForNull(request.getParameter("fpp_category"),"");	//37051
    //out.println("<script>alert("+practitioner_id+practitioner_name+")</script>");

%>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name ="OTWaitingListAppointment">	
	<br>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align="CENTER">
		<tr><td class="LABEL">&nbsp;</td></tr>
		
		<tr>
		<td class="LABEL" align="CENTER" >
<% 
		out.println("Do you want to Schedule Theatre/Wait List?");
%>
		</tr>
		<tr><td class="LABEL">&nbsp;</td></tr>
		<tr><td class="LABEL">&nbsp;</td></tr>
		<tr>
			<td class="button" align="right" >
				<input type="button" name="book" id="book" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Schedule.label","common_labels")%>" onClick="bookOTAppointment()"><input type="button" name="waitList" id="waitList" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.WaitList.label","common_labels")%>" onClick="callOTwaitingList()"><input type="button" name="cancel" id="cancel" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="window.close()"> 
			</td>
		</tr>
	</table>
		<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
		<input type="hidden" name="pref_surg_date" id="pref_surg_date" value="<%=pref_surg_date%>">
		<input type="hidden" name="practitioner_name" id="practitioner_name" value="<%=practitioner_name%>">
		<input type="hidden" name="fpp_yn" id="fpp_yn" value="<%=fpp_yn%>">	<!-- 37051 -->
		<input type="hidden" name="fpp_category" id="fpp_category" value="<%=fpp_category%>"> <!-- 37051 -->
	</form>
	</body>
</html>
 

