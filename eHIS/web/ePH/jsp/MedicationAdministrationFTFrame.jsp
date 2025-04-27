<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
   <%
   
 //Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
   request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
   response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
   response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
   //ends
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="JavaScript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 <%
	String params = request.getQueryString() ;
	String disa   = request.getParameter("disa");
	String admin_to_date  =	 request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
	String nursing_unit	  = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	String patient_id	  =	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
%>
	<iframe name="f_patient_details" id="f_patient_details" scrolling="auto"   noresize frameborder="0" src="../../ePH/jsp/MedicationAdministrationFTBedFrame.jsp?<%=params%>&disa="<%=disa%> style="height:100vh;width:100vw"></iframe>
	<iframe name="f_admin_chart" id="f_admin_chart" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe>
	<iframe name="f_admin_new_entry" id="f_admin_new_entry" frameborder="0" scrolling="auto" noresize src="" style="height:0vh;width:100vw"></iframe>
	<iframe name="f_admin_button" id="f_admin_button" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/MedicationAdministrationFTButtons.jsp?alternate_drug=N&patient_id=<%=patient_id%>&nursing_unit=<%=nursing_unit%>&admin_to_date=<%=admin_to_date%>" style="height:15vh;width:100vw"></iframe>
</html>


