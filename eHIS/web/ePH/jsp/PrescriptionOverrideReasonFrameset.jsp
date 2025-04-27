<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------
22-05-2022                        prathyusha                                           AAKH-CRF-0140
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/    
%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String calledFor = request.getParameter("calledFor")==null?"":request.getParameter("calledFor");
		String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		if(calledFrom.equals("INTRACTIONDTLS")){
			if(calledFor.equals("Alert")){
%>
				<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.Alert.label" bundle="${common_labels}"/>
<%
			}
			else{
%>
				Drug Interaction Details
<%
			}
		}//added for AAKH-CRF-0140 START
		else if(calledFrom.equals("ABUSEDTLS")){
			
			if(calledFor.equals("Alert")){
%>
				Drug Abuse &nbsp; <fmt:message key="Common.Alert.label" bundle="${common_labels}"/>
<%
			}
			else{
%>
				Drug Abuse Alert 
<%
			}//added for AAKH-CRF-0140 end
		}
		else{
%>
			<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>
<%
		}
%>
		</title>
	</head>

<%
		String query_str	=	request.getQueryString(); 
		if(calledFrom.equals("INTRACTIONDTLS")){
%>
			<iframe name="f_overrideReason" id="f_overrideReason" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/PrescriptionDrugInteractionDetails.jsp?<%=query_str%>" style="height:92vh;width:100vw"></iframe>
<%
		}
		else if(calledFrom.equals("ABUSEDTLS")){//added for AAKH-CRF-0140 
	%>
   	<iframe name="f_overrideReason" id="f_overrideReason" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/PrescriptionDrugAbuseDetails.jsp?<%=query_str%>" style="height:5vh;width:100vw"></iframe>
	<%		
		}
		else{
%>
			<iframe name="f_overrideReason" id="f_overrideReason" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/PrescriptionOverRideReason.jsp?<%=query_str%>" style="height:92vh;width:100vw"></iframe>
<%
		}
%>
		<iframe name="f_overrideReasonClose" id="f_overrideReasonClose" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/PrescriptionClose.jsp?<%=query_str%>" style="height:5vh;width:100vw"></iframe>

</html>

