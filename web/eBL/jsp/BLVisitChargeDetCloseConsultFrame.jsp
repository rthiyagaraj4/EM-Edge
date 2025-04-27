<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- CRF-362 SCRUM related changes starts -->
<%
	String bedChargeYN=request.getParameter("ae_bed_charge_appl_yn");
//	System.err.println("bedChargeYN:"+bedChargeYN);
	if(bedChargeYN==null) bedChargeYN="N";
	if(bedChargeYN.equals("Y"))
	{
%>
	<title><fmt:message key="eBL.CHARGE_DTL.label" bundle="${bl_labels}"/></title>
<%
	} 
	else 
	{
%>
	<title><fmt:message key="eBL.VISIT_CHARGE_DTL.label" bundle="${bl_labels}"/></title>
<%
	}

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


	<iframe  src='../../eBL/jsp/BLVisitChargeDet.jsp?<%=request.getQueryString()%>' frameborder=0 style="height: 92vh;width: 90vw;" noresize scrolling=yes></iframe>

	<iframe SRC="../../eCommon/html/blank.html" frameborder=0  scrolling='no' noresize style='height:1vh;width:90vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0  scrolling='no' noresize style='height:0vh;width:90vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0  scrolling='no' noresize style='height:0vh;width:90vw'></iframe>

	<iframe SRC='../../eBL/jsp/BLVisitChargeDetCloseConsult.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling='no' noresize style='height:0vh;width:90vw'></iframe>


</head>

</html>

