<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		String params = request.getQueryString();
		//System.out.println("function_id frame:"+params);
		//String patientId			= request.getParameter("patientId");
		//patientId					= patientId==null ?"":patientId;
		//System.out.println("patientId frame:"+patientId);
%>
<HTML>
<HEAD>
<title><fmt:message key="eBL.REC_ADHOC_DISC.label" bundle="${bl_labels}"/></title>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eBL/js/PkgVisitAdhocDiscount.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<iframe name='PkgVisitAdhocDiscountPatientHdrDtlsFrame' id='PkgVisitAdhocDiscountPatientHdrDtlsFrame' src='PkgVisitAdhocDiscountDtlsForPatient.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>
			<iframe name='PkgVisitAdhocDiscountPatientHdr' id='PkgVisitAdhocDiscountPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='PkgVisitAdhocDiscountDtlsFrame' id='PkgVisitAdhocDiscountDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
			<iframe SRC="../../eCommon/html/blank.html"	  name="PkgVisitAdhocDiscountBtnFrame" id="PkgVisitAdhocDiscountBtnFrame" frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
			<iframe SRC="../../eCommon/html/blank.html"	  name="submit_frame" id="submit_frame" frameborder=0 noresize scrolling='AUTO' style='height:0vh;width:100vw'></iframe>
</HTML>

