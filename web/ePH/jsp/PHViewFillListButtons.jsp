<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<HTML>
<HEAD>
	
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	 
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IPFill.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String type = request.getParameter("type");	   
		if(type == null) type = "";
%>	
<form name="formViewFillListButtons" id="formViewFillListButtons">
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
	<TR>
	<td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#CC6600"><b><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></b></td> 
	<!-- <td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#CC00CC"><b><fmt:message key="Common.multiple.label" bundle="${common_labels}"/> <fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></b></td> -->							   
	<td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#990033"><img 	 src='../../eCommon/images/disabled.gif' align='center'> - <b><fmt:message key="ePH.NoStock.label" bundle="${ph_labels}"/> <fmt:message key="Common.available.label" bundle="${common_labels}"/></b></td>
	<td align="right" > <input type="button" class="button" name="GenerateFillList" id="GenerateFillList" value='<fmt:message key="ePH.GenerateFillList.label" bundle="${ph_labels}"/>' onclick="genFillList();"></td>
	<td align="right"> <input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="parent.parent.document.getElementById('dialog_tag').close();"></td>
	</TR>
</table>
</form>
</HTML>

