<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language='javascript'>
			function funOnLoad()
			{
				document.forms[0].elements(0).focus();
			}
			function retModal(obj)
			{
				if (obj == 1)
				{
					var returnArray = new Array ("1")
					parent.window.returnValue = returnArray;
				}	
					
				if (obj == 2)
				{
					var returnArray = new Array ("2")
					parent.window.returnValue = returnArray;
				}	
				parent.window.close();
			}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!--	<title>Confirmation of Billing group</title> -->
	<title><fmt:message key="eBL.CONFIRMATION_OF_BILLING_GROUP.label" bundle="${bl_labels}"/></title>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='Confirm_form_blng' id='Confirm_form_blng'>
<br>
<table border='0' cellspacing='0' cellpadding='3' align='center' width='100%'>
<!--
<td align='center'>
<input type='button' class='button' name='renew_ok' id='renew_ok' value='Renew Now' onClick ='return retModal(1);'>&nbsp; 
</td>
<td align='center'>
<input type='button' class='button' name='visit_ok' id='visit_ok' value='Change to Visitor' onClick ='return retModal(2);'>&nbsp;
</td> -->
<tr>
	<td width="25%" class="label" ><h5><fmt:message key="eBL.PATIENT_HCARD_NOT_AVAILABLE_EXPIRED.label" bundle="${bl_labels}"/>?</h5></td>
	<td width="25%"  class="label"  ></td>
	<td width="25%"  class="label"  ></td>
	<td width="25%"  class="label"  ></td>
</tr>
<tr>
	<td width="25%" class="button"><input type='button' class='button' name='visit_ok' id='visit_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='return retModal(2);'></td>
	<td width="25%"  class="label"  ></td>
	<td width="25%"  class="label"  ></td>
	<td width="25%"  class="label"  ></td>
</tr>
</table>
</form>
</body>
</html>




