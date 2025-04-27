<!DOCTYPE html>



<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<% 	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
    <title><fmt:message key="eBL.Receipt_Detail.label" bundle="${bl_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</HEAD>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
<%
String data = request.getParameter("data");
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<iframe name='receiptMain' id='receiptMain' frameborder='0' src="../../eBL/jsp/BLReceiptMultipleReportMain.jsp?data=<%=data %>" scrolling='no' noresize style='height:100vh;width:100vw'></iframe>	
		  <iframe name='receiptMain1' id='receiptMain1' frameborder='0' src="../../eBL/jsp/BLReceiptMultipleReportMain.jsp?data=<%=data %>" scrolling='no' noresize style='height:0vh;width:100vw'></iframe>			
		
</HTML>


