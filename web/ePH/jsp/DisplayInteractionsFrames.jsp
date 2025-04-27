 <!--This file is saved on 07/11/2005-->
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> <fmt:message key="ePH.DrugToDrugInteractions.label" bundle="${ph_labels}"/> </title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
</head>
<%
String patientid=request.getParameter("patientid");
String orderid=request.getParameter("orderid");
String encounterid=request.getParameter("encounterid");
String url;
url="../../ePH/jsp/DisplayInteractions.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid="+encounterid;
String JSFile=request.getParameter("JSFile");
%>
<iframe name="f_interactions" id="f_interactions" frameborder="3" scrolling="auto" noresize src="<%=url%>" style="height:85vh;width:100vw"></iframe><iframe name="f_interactionsclose" id="f_interactionsclose" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DisplayInteractionsButton.jsp?JSFile=<%=JSFile%>" style="height:15vh;width:100vw"></iframe>
</html>

