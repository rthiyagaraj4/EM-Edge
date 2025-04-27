<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
		System.out.println("sStyle "+sStyle);	
String patientId=request.getParameter("patientId");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script>
function checkVal(value){
	document.getElementById('typeSel').value=value;
	/*  alert(document.getElementById("patientId").value)
	alert(document.getElementById('typeSel').value)
	 */
	 if(value=="S"){
		document.getElementById('self').checked=true;
		if(document.getElementById('Others').checked==true){
			document.getElementById('Others').checked=false;	
		}
		if(document.getElementById('form60').checked==true){
			document.getElementById('form60').checked=false;	
		}
		//alert(document.getElementById('self').checked)
	}
	if(value=="O"){
		document.getElementById('Others').checked=true;
		if(document.getElementById('self').checked==true){
			document.getElementById('self').checked=false;	
		}
		if(document.getElementById('form60').checked==true){
			document.getElementById('form60').checked=false;	
		}
	}
	if(value=="F"){
		document.getElementById('form60').checked=true;
		if(document.getElementById('self').checked==true){
			document.getElementById('self').checked=false;	
		}
		if(document.getElementById('Others').checked==true){
			document.getElementById('Others').checked=false;	
		}
	}
	//alert(document.getElementById('self').checked)
	parent.frames[1].location.href="../../eBL/jsp/TCSAddlIdProofDtls.jsp?selType="+value+"&patientId="+document.getElementById("patientId").value;
	
}
</script>			
</head>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload='checkVal("F");'>
	<form name='AddlTCSOption' id='AddlTCSOption'>
	<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
		<tr>
			<td nowrap class='fields' width="15%">&nbsp;</td>
			<td nowrap class='fields' width="10%">
				<input type='radio' id='self' name='self' id='self' value='S' onclick="checkVal('S')" checked> &nbsp;
				<b><fmt:message key="Common.self.label" bundle="${common_labels}"/></b>
			</td>
			<td nowrap class='label' width="20%">&nbsp;</td>
			<td nowrap class='fields' width="10%">
				<input type='radio' id='Others' name='Others' id='Others' value='Others' onclick="checkVal('O')"> &nbsp;
				<b><fmt:message key="Common.others.label" bundle="${common_labels}"/></b>
			</td>
			<td nowrap class='label' width="20%">&nbsp;</td>
			<td nowrap class='fields' width="10%">
				<input type='radio' id='form60' name='form60' id='form60' value='Form 60' onclick="checkVal('F')"> &nbsp;
				<b><fmt:message key="eBL.form60.label" bundle="${bl_labels}"/></b>
			</td>
			<td nowrap class='label' width="15%">&nbsp;</td>
		</tr>
	</TABLE>
	<input type='hidden' name='typeSel' id='typeSel' id='typeSel' value='' />
	<input type='hidden' name='patientId' id='patientId' id='patientId' value='<%=patientId%>' />
</body>
</html>

