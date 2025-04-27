<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	try
	{
		//String total_addl_charge_for_payer = request.getParameter("total_addl_charge_for_payer");
		//if(total_addl_charge_for_payer == null) total_addl_charge_for_payer="";
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
		window.close();
	}
</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<form name='AddlServChargeDtlsBtnForm' id='AddlServChargeDtlsBtnForm'>	
	<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>	
		<tr>
		<td width='25%' class="fields">
			<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="showModifyMealPlanRecords()">
		</td>
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

