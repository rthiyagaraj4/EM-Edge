<!DOCTYPE html>

  

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>                                
<head>                                
	<%
	  request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>     
<%
	String order_id   = request.getParameter("order_id");
	String patient_id = request.getParameter("patient_id");
	String disp_stage = request.getParameter("disp_stage");
%>
<iframe frameborder="0" noresize scrolling="auto" src="../../ePH/jsp/DispMedicationWSOrderDetails.jsp?patient_id=<%=patient_id%>&order_id=<%=order_id%>&disp_stage=<%=disp_stage%>" name="ws_order_details" id="ws_order_details" style="height:89vh;width:100vw"></iframe>
	<iframe frameborder="0" noresize scrolling="no" name="ws_preview_details" id="ws_preview_details" src="../../ePH/jsp/DispMedicationWSPreviewDetails.jsp?" style="height:11vh;width:100vw"></iframe>

</html>

