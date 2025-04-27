<!DOCTYPE html>
<!--
-------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------
18/04/2023	   38981        Krishna Pranay   18/04/2023     Ramesh G     ML-MMOH-CRF-1986

-------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>

<HTML>
<HEAD>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown='lockKey()'>
<table border='0' width='15%' id='dataTable' cellpadding='0' cellspacing='0' align='right'>
	 <tr>
		<td class='button'>
		<input type='button' name='closeWindow' id='closeWindow' class="button" align='right' class='button' onclick="parent.parent.document.getElementById('dialog_tag').close(); " value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>   '>
		</td>
	</tr>
	</table>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

