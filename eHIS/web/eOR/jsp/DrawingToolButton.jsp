<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eOR/js/DrawingTool.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name ="buttonForm" action="../../servlet/eOR.SubmitServlet" method="POST">
	<%
		String bean_id1				= request.getParameter("bean_id");
		String bean_name1			= request.getParameter("bean_name");
		String order_catalog_code	= request.getParameter("catalog_code");
 		 /* Initialize Function specific start */
		//OrderEntryBean bean		= (OrderEntryBean)mh.getBeanObject( bean_id1, request,  bean_name1 );
		OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;

		String bean_id				= "@OrderEntryDrawingToolBean"+bean.getPatientId()+bean.getEncounterId();
		String bean_name			= "eOR.OrderEntryDrawingToolBean";
		//OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)mh.getBeanObject( bean_id, request,  bean_name );
		OrderEntryDrawingToolBean beanObj	= (OrderEntryDrawingToolBean)getBeanObject( bean_id, bean_name, request ) ;
		// clear the bean
		beanObj.clear();
 	%>
 
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td  width="100%" class="Label" align="right" ><input type="button" name="clear" id="clear" class="BUTTON" value ="Clear" title ="Clear" onClick="Clear()"> <input type="button" name="record" id="record" class="BUTTON" value ="Record" title ="Record" onClick="apply()"> 
			 </tr>

		
		<input type="hidden" name="image_content" id="image_content" value=""> <!-- to store the image -->
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

		<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">

		<input type="hidden" name="bean_id1" id="bean_id1" value="<%=bean_id1%>">		<!-- order entry bean --> 
		<input type="hidden" name="bean_name1" id="bean_name1" value="<%=bean_name1%>"> <!-- order entry bean --> 
	
 
		<input type="hidden" name="mode" id="mode" value="1">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=bean.getPatientId()%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
		<input type="hidden" name="location_type" id="location_type" value="<%=bean.getLocationType()%>">
		<input type="hidden" name="location_code" id="location_code" value="<%=bean.getLocationCode()%>">
		<input type="hidden" name="episode_id" id="episode_id" value="<%=bean.getEpisodeID()%>">
		<input type="hidden" name="episode_visit_num" id="episode_visit_num" value="<%=bean.getEpisodeVisitNum()%>">
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=bean.getPractitionerId()%>">

		</table>
	 	</form>
	</body>
</html>

<%
		// set it back persistence
		putObjectInBean(bean_id1,bean,request);
		putObjectInBean(bean_id,beanObj,request);
%>

