<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unbilled Service Request </title>
<%	String queryString = request.getQueryString(); 	
%>
</head>
	<iframe frameborder='0' name='Unbilledservice' id='Unbilledservice' src='BillReceiptUnbillServReq.jsp?<%=queryString %>' noresize style='height:85vh;width:100vw'></iframe>
		<iframe frameborder='0' name='closewindow' id='closewindow' src='BillReceiptUnbillServReqClose.jsp?<%=queryString %>' scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	
</html>

