<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,,java.sql.CallableStatement,java.sql.Types,eCommon.Common.CommonBean,java.util.Properties,eOT.Common.OTRepository,eCommon.XSSRequestWrapper,eOT.OperationDtlBean,eOR.OrderEntryBillingQueryBean" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
	<head>
		<TITLE><fmt:message key="eOT.OverBookedCases.Label" bundle="${ot_labels}"/></TITLE>
		<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
		<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
		<script language='javascript'  src='../../eCommon/js/common.js' ></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
		
		
		<iframe name='header_frame' id='header_frame' src="../../eOT/jsp/OperOverBookingHdr.jsp?<%=request.getQueryString()%>"  noresize style="height:85vh;width:100vw"></iframe>
		
		<iframe name="footer_frame" id="footer_frame" id = "footer_frame"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:15vh;width:100vw"></iframe>	
		<!--
		<frame name="footer_frame" id="footer_frame" id = "footer_frame" frameborder="0" noresize src="../../eCommon/html/blank.html" >
		<frame name='footer_frame' id='footer_frame'	 src="../../eOT/jsp/OperOverBookingFtr.jsp?<%=request.getQueryString()%>" scrolling="no" frameborder=0 >	
		-->
	    
<form name="OperOverBookingFrame" id="OperOverBookingFrame">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
</form>
</html>

