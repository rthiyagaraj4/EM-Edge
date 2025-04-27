<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eOT.resources.*" import ="eCommon.Common.CommonBean,eOT.*,eCommon.XSSRequestWrapper,eOT.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eOT/html/style.css' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
    <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
    <%
    	System.err.println("request.getQueryString PendingOrderTail.jsp : "+request.getQueryString());
	String bookingPriorityOrdersYN="";
	String ammendBooking="";//MMS-CRF-186
	bookingPriorityOrdersYN=request.getParameter("bookingPriorityOrdersYN");
	ammendBooking=request.getParameter("ammendBooking");//MMS-CRF-186
	System.err.println("bookingPriorityOrdersYN PendingOrderTail.jsp : "+bookingPriorityOrdersYN);
	 String	called_from = CommonBean.checkForNull(request.getParameter("called_from")); // [IN:057473]
    %>
    <form >
    <table border="1" cellpadding=3  cellspacing="1" width="100%">
		
    <!--MMS-QH-CRF-186-->
	<%
		if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")){
	%>
		<td align=='right' width='2%' class='gridDataPriority'>&nbsp; </td>
		 <td align='left' class='label'><fmt:message key="eOT.priority1Case.label" bundle="${ot_labels}"/></td>
	<%
	}%>
	<%
		if(!called_from.equalsIgnoreCase("OT_MENU")) { // [IN:057473]
	%>
	<%
			if(ammendBooking.equalsIgnoreCase("Y") && ammendBooking!=null){ //MMS-CRF-186
		%>
		<td align=='right' width='2%' class='gridDataBookingAvailabel'>&nbsp; </td>
		<td align='left' class='label'><fmt:message key="eOT.FutureAppointmentExists.Label" bundle="${ot_labels}"/> </td>
		<%
			}//MMS-CRF-186
		%>
		 
		 <td align=='right' width='2%' class='gridData'><img id="img_src_res" src='../../eOT/images/Obtained.PNG'>&nbsp; </td>
		 <td align='left' class='label'><fmt:message key="eOT.ConsentRecorded.Label" bundle="${ot_labels}"/></td>
		 <td align=='right' width='2%' class='gridData'><img id="img_src_res" src='../../eOT/images/NotObtained.PNG'>&nbsp; </td>
		 <td align='left' class='label'><fmt:message key="eOT.ConsentRequiredandNotRecorded.Label" bundle="${ot_labels}"/></td>
	<%
		} // [IN:057473] 
	%>
    </table>
    </form>
    </body>
</html>

