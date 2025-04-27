<!DOCTYPE html>
<!--
   		 Developed By  :- Maheshwaran K for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
   		 Function      :-  To Display the Surgery OT Order related to the Patient IDs
		 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/ecis.css'></link> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String patient_id=request.getParameter("patient_id");
	String booking_ref_no = request.getParameter( "booking_ref_no")  ;
	%><TITLE><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></TITLE>
		   	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/SurgeryOrderLookUpResult.jsp?patient_id=<%=patient_id%>&booking_ref_no=<%=booking_ref_no%>' frameborder=0 scrolling='auto' noresize></iframe>
</html>

