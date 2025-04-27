<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.OTRepository,eOT.*" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<head><title>Select Primary Speciality </title></head>
<%
	String bean_id = "OTBillingBean";
	String bean_name = "eOT.OTBillingBean";
	OTBillingBean otBillingBean = (OTBillingBean)mh.getBeanObject(bean_id, request, bean_name);
	OtCommonGettersSetters passDets = new OtCommonGettersSetters();
	int chkBookingExistDays = Integer.parseInt(request.getParameter("chkBookingExistDays") == null ? "0" : request.getParameter("chkBookingExistDays"));
	String patientId = checkForNull(request.getParameter("patientId"));
	String calledFrom = checkForNull(request.getParameter("called_from"));
	String orderid = checkForNull(request.getParameter("orderid"));
	String locale = checkForNull(request.getParameter("locale"));
	String selOrderIds = checkForNull(request.getParameter("selOrderIds"));
	System.err.println("====chkBookingExistDays=ammendBookings=="+chkBookingExistDays);
	System.err.println("====patientId==ammendBookings==="+patientId);
	System.err.println("====locale==ammendBookings==="+locale);
	System.err.println("====selOrderIds==ammendBookings==="+selOrderIds);
	passDets.setPatientId(patientId);
	passDets.setLanguageId(locale);
	ArrayList getBookingDetailsList = otBillingBean.getBookingDetails(passDets, chkBookingExistDays);
	System.err.println("====getBookingDetailsList===="+getBookingDetailsList);
%>
<body>
	<form name="ammendBookingForm" id="ammendBookingForm" >
	<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0'>		
		<tr>
			<td class="columnHeader"></td>
			<td class="columnHeader"><fmt:message key="eOT.BookingNumber.Label" bundle="${ot_labels}"/></td>
			<td class="columnHeader"><fmt:message key="eOT.BookingDateTime.Label" bundle="${ot_labels}"/></td>
			<td class="columnHeader"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
			<td class="columnHeader"><fmt:message key="eOT.Procedure(s).Label" bundle="${ot_labels}"/></td>
			<td class="columnHeader"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="columnHeader"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
		</tr>
<%
			OtCommonGettersSetters getBookingDets = new OtCommonGettersSetters();
			for(int i=0; i<getBookingDetailsList.size(); i++)
			{
				getBookingDets = (OtCommonGettersSetters) getBookingDetailsList.get(i);
				//EMERGENT
				String classValue="";
				if(checkForNull(getBookingDets.getOverBookedStatus()).equalsIgnoreCase("Y")){ //057504
					
					classValue="EMERGENT"; //057504
				}else{
					classValue="gridData"; //057504
				}
%>
				<tr>
					<td class="<%=classValue%>">
						<input type="radio" name="selectDate" id="selectDate" id="selectDate" value="<%=getBookingDets.getBookingDate()%>" onclick="loadDetails('<%=i%>');">
					</td>
					<td class="<%=classValue%>"> <%=getBookingDets.getBookingNum()%> </td>
					<td class="<%=classValue%>"> <%=getBookingDets.getFromDateTime()%> </td>
					<!--<td class="<%=classValue%>"> <%=getBookingDets.getBookingDate()%> <%=getBookingDets.getFromTime()%> </td>-->
					<td class="<%=classValue%>"> <%=getBookingDets.getOperRoomDesc()%> </td>
					<td class="<%=classValue%>"> <%=getBookingDets.getOperShortDesc()%> </td>
					<td class="<%=classValue%>"> <%=getBookingDets.getSpecialityDesc()%> </td>
					<!--Added Against For All Surgeon Not displayed starts-->
					<!--<td class="<%=classValue%>"> <%=checkForNull(getBookingDets.getSurgeonName())%> </td>-->
					
					<%
						if(checkForNull(getBookingDets.getSurgeonName()).equals("")){
					
					%>	
					<td class="<%=classValue%>">All Surgeon</td>
					<%
						}else{
					%>
					<td class="<%=classValue%>"> <%=checkForNull(getBookingDets.getSurgeonName())%> </td>
					<%
						
						}
					%>
					<!--Added Against For All Surgeon Not displayed ends-->
				</tr>
				<input type="hidden" name="bookingDate<%=i%>" id="bookingDate<%=i%>" id="bookingDate<%=i%>" value="<%=getBookingDets.getBookingDate()%>">
				<%
						String start_time="";
						String FromDate=getBookingDets.getFromDateTime();
						String FromTime=getBookingDets.getFromTime();
						start_time=FromDate+" "+FromTime;
						System.err.println("start_time : "+start_time);
				%>
				<input type="hidden" name="fromTime<%=i%>" id="fromTime<%=i%>" id="fromTime<%=i%>" value="<%=getBookingDets.getFromDateTime()%>">
				<!--<input type="hidden" name="fromTime<%=i%>" id="fromTime<%=i%>" id="fromTime<%=i%>" value="11/09/2015 23:30">-->
				<input type="hidden" name="maxToTime<%=i%>" id="maxToTime<%=i%>" id="maxToTime<%=i%>" value="<%=getBookingDets.getBookingTime()%>">
				<input type="hidden" name="operRoomCode<%=i%>" id="operRoomCode<%=i%>" id="operRoomCode<%=i%>" value="<%=getBookingDets.getOperRoomCode()%>">
				<input type="hidden" name="operRoomDesc<%=i%>" id="operRoomDesc<%=i%>" id="operRoomDesc<%=i%>" value="<%=getBookingDets.getOperRoomDesc()%>">
				<input type="hidden" name="surgeonCode<%=i%>" id="surgeonCode<%=i%>" id="surgeonCode<%=i%>" value="<%=getBookingDets.getSurgeonCode()%>">
				<input type="hidden" name="surgeonName<%=i%>" id="surgeonName<%=i%>" id="surgeonName<%=i%>" value="<%=getBookingDets.getSurgeonName()%>">

				<input type="hidden" name="fromDateTime<%=i%>" id="fromDateTime<%=i%>" id="fromDateTime<%=i%>" value="<%=getBookingDets.getFromDateTime()%>">
				<input type="hidden" name="calledFrom<%=i%>" id="calledFrom<%=i%>" id="calledFrom<%=i%>" value="<%=calledFrom%>">
				<input type="hidden" name="specialityDesc<%=i%>" id="specialityDesc<%=i%>" id="specialityDesc<%=i%>" value="<%=getBookingDets.getSpecialityDesc()%>">
				<input type="hidden" name="orderId<%=i%>" id="orderId<%=i%>" id="orderId<%=i%>" value="<%=getBookingDets.getOrderId()%>">
				<input type="hidden" name="selBookingNumber<%=i%>" id="selBookingNumber<%=i%>" id="selBookingNumber<%=i%>" value="<%=getBookingDets.getBookingNum()%>">
				<input type="hidden" name="OverBookedStatus<%=i%>" id="OverBookedStatus<%=i%>" id="OverBookedStatus<%=i%>" value="<%=getBookingDets.getOverBookedStatus()%>">
<%
			}
%>
				<input type="hidden" name="patientId" id="patientId" id="patientId" value="<%=patientId%>">
				<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
				<input type="hidden" name="selOrderIds" id="selOrderIds" id="selOrderIds" value="<%=selOrderIds%>">
				<input type="hidden" name="ammendFlag" id="ammendFlag" id="ammendFlag" value="Y">
		</table>

		<!--table width="100%" border="0" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td class="button"  colspan="3"  align="right">
					<input type="button" class="button" name="ammendBooking" id="ammendBooking" value ="Ammend Booking" onclick="doAmmend();">
					<input type="button" class="button" name="close" id="close" value ="Close" onclick="window.close()">
				</td>
		</table-->

	</form>
</body>

