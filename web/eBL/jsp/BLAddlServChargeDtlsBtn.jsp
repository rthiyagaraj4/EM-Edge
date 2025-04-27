<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	try
	{
		String total_addl_charge_for_payer = request.getParameter("total_addl_charge_for_payer");
		if(total_addl_charge_for_payer == null) total_addl_charge_for_payer="";
//		System.out.println("total_addl_charge_for_payer:"+total_addl_charge_for_payer);
%>
<head>	
<% 
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>
	function close_window()
	{
		//window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<form name='AddlServChargeDtlsBtnForm' id='AddlServChargeDtlsBtnForm'>	
	<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>	
		<tr>
			<td class="label" width="100%"><div align='right'><B><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;&nbsp;<B><%=total_addl_charge_for_payer%></B></div></td>	
		</tr>         
		<tr>
			<td class='button' width="100%" align='right' >
			<input  type='button'  name="close_button" id="close_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class='button' onClick='close_window();'></td>
		</tr>         
	</table> 
	
</form>	 
</body>
<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception in AddlServChargDtlsBtn page:"+e);
	}
%>
</html>

