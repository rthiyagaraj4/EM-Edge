
<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<HTML>
<HEAD>
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHPickList.js"></SCRIPT>
</HEAD>
<%
	String type = request.getParameter("type");	   
		if(type == null) type = "";
%>	
<form name="formViewFillListButtons" id="formViewFillListButtons">
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
	<TR>
	<td align="right" > <input type="button" class="button" name="printpicklist" id="printpicklist" value='<fmt:message key="ePH.PrintPickList.label" bundle="${ph_labels}"/>' onclick="genPickList();"></td>
	<td align="right"> <input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close();"></td>
	</TR>
</table>
</form>
</HTML>

