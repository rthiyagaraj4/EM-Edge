<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String called_from_patientChart = request.getParameter("called_from_patientChart")==null?"N":request.getParameter("called_from_patientChart");
		String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String facility_id = (String) session.getAttribute("facility_id");
		System.out.println("PATIENT ID- called_from_patientChart-->"+facility_id);
		System.out.println("encounterid-called_from_patientChart-->"+encounterid);
		if("Y".equals(called_from_patientChart)){ %>
			<frameset rows="*">
				<frame name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/CAInsuranceAuthorizationForm.jsp?patientid=<%=patientid%>&encounterid=<%=encounterid%> "> 
		<%}else{ %>
			<frameset rows="10%,*%,0%">
				<frame name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CAInsuranceAuthorizationFormCriteria.jsp"> 
				<frame name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">
				<FRAME name="f_query_print" id="f_query_print" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCA/jsp/CAInsuranceAuthorizationFormPrint.jsp">
		<%} %>
			</FRAMESET>		
</html>

