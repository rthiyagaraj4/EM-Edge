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
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
	String type = request.getParameter("type");
	if(type!=null && !type.equals("")){
		if(type.equals("CY")){
			type="Cyto";
		}
	}
%>
<title><fmt:message key="ePH.WorksheetFor.label" bundle="${ph_labels}"/> <%=type%>  <fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/></title>
</head>     
<%
	String order_id = request.getParameter("order_id");
	String patient_id = request.getParameter("patient_id");
	String disp_stage = request.getParameter("disp_stage");
	String tot_num_of_drugs=request.getParameter("tot_num_of_drugs");
%>
<frameset rows="44%,0%,0%,50%,6%" id="ws_main">
	<frameset cols="45%,55%" id="ws_order_detail_cal_sec">
		<frame frameborder="0" noresize scrolling="auto" src="../../ePH/jsp/DispMedicationWSOrderDetailsFrame.jsp?patient_id=<%=patient_id%>&order_id=<%=order_id%>&disp_stage=<%=disp_stage%>" name="ws_order_details_frame"></frame>
		<frame frameborder="0" noresize scrolling="no" src="../../eCommon/html/blank.html" name="ws_cal_sec"></frame>
	</frameset>	
	<frame  frameborder="0" noresize scrolling="auto" src="../../eCommon/html/blank.html" name="ws_show_batches"></frame>
	<frame  frameborder="0" noresize scrolling="auto" src="../../ePH/jsp/DispMedicationWSBatchesButton.jsp?identity=" name="ws_batches_button"></frame>
	 <frame  frameborder="0" noresize scrolling="auto" src="../../eCommon/html/blank.html" name="ws_display_sec"></frame> 
	<frame  frameborder="0" noresize scrolling="no" src="../../ePH/jsp/DispMedicationWSActionButtons.jsp?tot_num_of_drugs=<%=tot_num_of_drugs%>" name="ws_action_buttons"></frame>
</frameset>
</html>
