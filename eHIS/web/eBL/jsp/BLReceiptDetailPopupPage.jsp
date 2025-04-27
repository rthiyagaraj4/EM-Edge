<!DOCTYPE html>



<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<% 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
    <title><fmt:message key="eBL.Receipt_Detail.label" bundle="${bl_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</HEAD>
<%

String doc_type_code = request.getParameter("doc_type_code");
String doc_number  = request.getParameter("doc_number");
System.out.println("doc_type_code-"+doc_type_code+"-doc_number-"+doc_number);

%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
		<iframe name='receiptMain' id='receiptMain' 		frameborder='0'	 src="../../eBL/jsp/BLReceiptDetailMain.jsp?doc_type_code=<%=doc_type_code %>&doc_number=<%=doc_number %>"  scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
			<!-- <iframe name='PaymentFrame' id='PaymentFrame' frameborder='0' src='BillReceiptPaymentMain.jsp?billAmount=15000&calledFrom=BillMaintain' scrolling='no' noresize></iframe> -->
		
		
</HTML>


