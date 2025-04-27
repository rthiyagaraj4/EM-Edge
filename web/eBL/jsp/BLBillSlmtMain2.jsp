<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<!-- <TITLE><fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>-->
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

	<%	
	//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	try
	{
		String query_string="";

		query_string = (request.getQueryString());
//		System.out.println("query_string in Main2.jsp:"+ query_string);
%>	



<title>
	<%=request.getParameter("title")%>
</title>

</HEAD>
 

<iframe SRC= "../../eBL/jsp/BLBillSlmtDet2.jsp?<%=query_string%>" NAME="BillSlmtEntryFrame" frameborder=0 noresize scrolling='no' style='height:24vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/html/blank.html" name="BillSlmtTypeFrame" id="BillSlmtTypeFrame" frameborder=0 noresize scrolling='no' style='height:45vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/jsp/error.jsp" name="BillSlmtValidationFrame" id="BillSlmtValidationFrame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
<iframe SRC="../../eBL/jsp/BLBillSlmtConfirm.jsp?<%=query_string%>" NAME="BillSlmtToolBarFrame" frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/html/blank.html" name="dummyframe" id="dummyframe" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/jsp/error.jsp" name="processframe" id="processframe" frameborder=0 noresize scrolling='no' style='height:15vh;width:100vw'></iframe>	

<%	
	}
	catch(Exception e)
	{
		System.out.println("main exception in blmain-"+e);
	}
%>
</HTML>

