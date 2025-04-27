<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<% 
		request.setCharacterEncoding("UTF-8");
		//Added for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
			String called_frm	=	request.getParameter("called_frm");
			if(called_frm == null)	
				called_frm = "";
			String title_desc="";	
			title_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CurrentMedication.label", "ph_labels");
			String params = request.getQueryString() ;
		%>
		<title><%=title_desc%></title>
	</head>

		<% 
			if(called_frm.equals("PH")){ 
		%>
				<iframe name="f_active_order_details" id="f_active_order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/SRRPrescriptionActiveOrderDetails.jsp?<%=params%>" style="height:90vh;width:100vw"></iframe>
				<iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/SRRPrescriptionClose.jsp?called_from=PH" style="height:90vh;width:100vw"></iframe>
		<% 
			}
			else { 
		%>
				<iframe name="DrugLabe_active_order_details" id="DrugLabe_active_order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/SRRDrugLabelActiveOrderDetails.jsp?<%=params%>" style="height:10vh;width:100vw"></iframe>
				<iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/SRRPrescriptionClose.jsp?" style="height:10vh;width:100vw"></iframe>
		<% 
			}
		%>

</html>


