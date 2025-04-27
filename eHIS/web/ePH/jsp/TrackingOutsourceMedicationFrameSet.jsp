<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params			= request.getQueryString() ;
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		if(!callFrom.equals("RESULT")){
			if(callFrom.equals("SENTDTL") || callFrom.equals("VIEWOUTSOURCEDTL") ){
%>
				<title><fmt:message key="ePH.Outsource.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<%
			}
			else{
%>
				<title><fmt:message key="ePH.ReceivedProductDetails.label" bundle="${ph_labels}"/></title>
<%
			}
		}
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</HEAD>
<%
	if(callFrom.equals("RESULT")){
%>
		<frameset rows="40%,*" id="TrackingOutsourceMedicationFrameSet"  border='0'>
			<frame name="f_criteria" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/TrackingOutsourceMedicationCriteria.jsp?<%=params%>">
			<frame name="f_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">	
<!--			<frame name="f_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">	-->
<%
	}
	else{
%>
		<frameset rows="*,50" id="TrackingOutsourceMedicationViewDtls"  border='0'>
			<frame name="f_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/TrackingOutsourceMedicationActionDtls.jsp?<%=params%>">
			<frame name="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/TrackingOutsourceMedicationButton.jsp?<%=params%>">
<%
	}
%>
	</frameset>	
</HTML>
