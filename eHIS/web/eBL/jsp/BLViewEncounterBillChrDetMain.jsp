<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	//HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	String strDocNum="";String strDocType="";String strDocDate=""; String strBillNum=""; String strTitle="";
			try
				{
					strDocType = request.getParameter("doc_type");
					if(strDocType==null) strDocType="";						
					strDocNum =request.getParameter("doc_num");
					if(strDocNum==null || strDocNum.equals("")) strDocNum="";
					strDocDate =request.getParameter("doc_date");
					strDocDate = com.ehis.util.DateUtils.convertDate(strDocDate,"DMYHMS","en",locale);
					if(strDocDate==null || strDocDate.equals("")) strDocDate="";
					strBillNum=(String) bl_labels.getString("eBL.BILL_NO.label");
					strTitle=(String) bl_labels.getString("eBL.BILL_CHARGE_DET.label");
				}catch(Exception e)
					{
						System.out.println("title"+ e);
					}
%>
<HTML>
<head>
   <title>
        <%=strTitle%> -- <%=strBillNum%> - <%=strDocType%> / <%=strDocNum%> /  <%=strDocDate%>
   </title>
</head>
<!--
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
		String params = request.getQueryString();		
%>

	  <iframe name='' id=''	src='../../eBL/jsp/BLViewEncounterBillChrDet.jsp?<%=params%>'  frameborder=0 noresize scrolling='no'  style='height:90vh;width:100vw'></iframe><iframe SRC="../../eBL/jsp/BLViewEncounterBillChrDetBtn.jsp"	  name="" id="" frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>	
</HTML>

