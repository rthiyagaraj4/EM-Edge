<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	//HttpSession httpSession = request.getSession(false);	
	//Properties p = (Properties)httpSession.getValue("jdbc");
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
	String strDocNum="";String strDocType="";String strDocDate=""; String strBillNum=""; String strTitle="";
			try
				{
					strDocType = request.getParameter("doc_type");
					if(strDocType==null) strDocType="";						
					strDocNum =request.getParameter("doc_num");
					if(strDocNum==null || strDocNum.equals("")) strDocNum="";
					strDocDate =request.getParameter("doc_date");
					if(strDocDate==null || strDocDate.equals("")) strDocDate="";
					strDocDate = com.ehis.util.DateUtils.convertDate(strDocDate,"DMYHMS","en",locale);
					strBillNum=(String) bl_labels.getString("eBL.BILL_NO.label");
					strTitle=(String) common_labels.getString("Common.PaymentDetails.label");									
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
//		System.out.println("params...@:"+params);
%>


			<iframe name='MenuTab' id='MenuTab'	src='../../eBL/jsp/BLViewEncounterPaymentDetMenuTab.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'> </iframe>
			<iframe name='PayDet' id='PayDet'	src='../../eBL/jsp/BLViewEncounterPaymentDet.jsp?tab_chk=pymtdet_tab&<%=params%>'   frameborder=0 		scrolling='no' noresize style='height:83vh;width:100vw'></iframe>
			<iframe name='PayDet' id='PayDet'	src='../../eBL/jsp/BLViewEncounterPaymentDetBtn.jsp'   frameborder=0 scrolling='no'noresize style='height:10vh;width:100vw'></iframe>			
			<!--<frame name='dummyframe' id='dummyframe'	src=''   frameborder=0 scrolling='no' >-->

</HTML>

