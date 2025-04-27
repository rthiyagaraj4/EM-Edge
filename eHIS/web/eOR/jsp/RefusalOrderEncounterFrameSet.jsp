<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- RefusalOrderOrderableFrameSet.jsp -->

<%-- JSP Page specific attributes start --%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
 
<html>
<title><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></title>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String getPatientId=request.getParameter("patientId"); 
%>
<!-- <frameset rows="0%,87%" name="refusal_encounter_frame_set">-->
	<iframe src="../../eCommon/html/blank.html" name="refusal_encounter_label1" id="refusal_encounter_label1"  scrolling='no' frameborder="0" noresize style='height:0vh;width:100vw'></iframe>
	<%
			if(!getPatientId.equals(""))
			{//System.out.println("111111111111");
			%>
	<iframe src="RefusalOrderEncounterResult.jsp?patientid=<%= getPatientId %>" name="refusal_encounter_result"    scrolling='no' frameborder="0" noresize style='height:100vh;width:100vw'></iframe>
	<%
			}
			else
			{
	//System.out.println("22222");%>

		<iframe src="../../eCommon/html/blank.html" name="refusal_encounter_result" id="refusal_encounter_result"    scrolling='no' frameborder="0" noresize style='height:100vh;width:100vw'></iframe>
			<%
			}
			%>
<--</frameset>-->
</html>

