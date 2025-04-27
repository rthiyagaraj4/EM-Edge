<!DOCTYPE html>
<%@page import="eBL.BLChargePatientMessage"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.google.gson.JsonArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error / Warnings</title>
<%
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>


<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
$(document).ready(function(){
	$('#btnClose').click(function(){
		/* window.returnValue = 'SUCCESS';
		window.close(); */
		let dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = 'SUCCESS';
	    
	    const dialogTag = parent.document.getElementById('dialog_tag');    
	    dialogTag.close();   
	});
});
</script>

</head>
<body>
<%
String beanId = "BLChargePatientMessage" ;
String beanName = "eBL.BLChargePatientMessage";
BLChargePatientMessage messageBean = (BLChargePatientMessage) getObjectFromBean(beanId, beanName, session);
if(messageBean == null){
	messageBean = new BLChargePatientMessage();
}
int sno = 1;
List<BLChargePatientMessage> warnList = messageBean.getWarningList();
List<BLChargePatientMessage> errorList = messageBean.getErrorList();

if(warnList == null){
	warnList = new ArrayList<BLChargePatientMessage>();
	
}
if(errorList == null){
	errorList = new ArrayList<BLChargePatientMessage>();
}
System.err.println(warnList);
System.err.println(errorList);
%>
<div style="position:absolute;top:0px;left:20px;width:600px;height:50px;overflow-x:hidden;overflow-y:auto; float: left;">
<table>
<tr>
	<td style="width: 10%;">
	&nbsp;
	</td>
</tr>
<tr>
	<td style="width: 90%;">
	<input type='button' id='btnClose' name='btnClose' id='btnClose' value='Close'>	
	</td>
</tr>
</table>
</div>

<div style="position:absolute;top:70px;left:10px;width:600px;height:210px;overflow-x:hidden;overflow-y:auto; float: left;">
<%
if(!warnList.isEmpty()){ %>

<table style="width: 95%;" align="center">	
	<tr >
		<td class='COLUMNHEADER' class='columnheader' >Warning Messages</td>
	</tr>
	<tr>
		<td class='LABEL' style="width: 70%">
			Below are the warnings for the selected services.
		</td>
	</tr>
	<%		
	sno = 1;
	for(BLChargePatientMessage loopBean: warnList){		
	%>
	<tr style="width: 70%">
		<td class='LABEL' >
		<%=sno %>) <%=loopBean.getTrxDoc() %> / <%=loopBean.getBlngServ() %> : <%=loopBean.getCode() %>
		</td>
	</tr>
	<%
	sno++;
	} %>
</table>
<br/>
<br/>
<%} %>


<%if(!errorList.isEmpty()){ %>

<table style="width: 95%;" align="center">	
	<tr>
		<td class='COLUMNHEADER' class='columnheader' >Error Messages</td>
	</tr>
	<tr>
		<td class='LABEL' style="width: 70%">
			Below are the Error for the selected services, and it has been unselected.
		</td>
	</tr>
	<%	
	sno = 1;
		for(BLChargePatientMessage loopBean: errorList){		
		
	%>
	<tr>
		<td class='LABEL' style="width: 70%" >
		<%=sno %>) <%=loopBean.getTrxDoc() %> / <%=loopBean.getBlngServ() %> : <%=loopBean.getCode() %>
		</td>
	</tr>
	<%
	sno++;
	} %>
</table>

<%} 

messageBean.clearAll();
%>
</div>
<br/>




</body>
</html>

