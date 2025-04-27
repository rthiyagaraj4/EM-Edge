<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<% 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
    <title><fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</HEAD>
<%

String doctype = request.getParameter("billdoctypecode");
String docnum  = request.getParameter("billdocnum");
String blnggrp	= request.getParameter("blnggrp");
String genlater	= request.getParameter("billgenlater");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		<iframe name='pline' id='pline' 		frameborder='0'	src="BLBillSlmtMain.jsp?billdoctypecode=<%=doctype %>&billdocnum=<%=docnum %>&blnggrp=<%=blnggrp %>&billgenlater=<%=genlater%>&billMaintain=Y "  scrolling='no' noresize style='height:100vh;width:100vw'></iframe> 
			<!-- <iframe name='PaymentFrame' id='PaymentFrame' frameborder='0' src='BillReceiptPaymentMain.jsp?billAmount=15000&calledFrom=BillMaintain' scrolling='no' noresize></iframe> -->
		
		
</HTML>


