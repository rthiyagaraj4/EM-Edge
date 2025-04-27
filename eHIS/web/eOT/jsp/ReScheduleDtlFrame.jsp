<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<%
	 //String strLegends="Patient ID,Name,Procedure,Reschedule Reason,Surgeon";
     StringBuffer sbr = new StringBuffer();
	//String 	rescheduledreason =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RescheduledReason.label","or_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Procedure(s).Label","ot_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RescheduledReason.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels"));
	String strLegends=sbr.toString();
	sbr.setLength(0);
    String strSizes="15,25,15,30,15";
	String source="../../eOT/jsp/HdrComDisplay.jsp?";
	String function_id ="OT_TO_BE_RESCHD_CASES";
	String param="legends="+strLegends+"&sizes="+strSizes+"&function_id="+function_id;
	source=source+param;
%>
<!--  <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>'
	 frameborder=0 scrolling='no' noresize> -->	
	<iframe name='schdule_dtl' id='schdule_dtl' 		src="../../eOT/jsp/ReScheduleDtl.jsp?<%=request.getQueryString()%>" frameborder=0 style='height:96vh;width:97vw'></iframe>


