<!DOCTYPE html>
<!--  Author 	:	Arun M (157457)
Module name 	:	ePH
Function 	:	RePrint for Home Medication Summary-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhReprintHomeMdn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<form name="PhReprintHomeMednAddform" id="PhReprintHomeMednAddform" >
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="AddDetailTable">
		<tr> 
			<th  width="25%"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </th>
			<th width="15%"><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
			<th width="10%" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
		</tr>
		<tr><td class='label' colspan='8' height='15'></td></tr>
		<tr>
			<TD align="center"><INPUT TYPE="text" name="item_desc" id="item_desc" SIZE="80" MAXLENGTH="40" ></TD>
			<TD align="center"><INPUT TYPE="text" name="instruction" id="instruction" SIZE="50" MAXLENGTH="80" ></TD>
			<TD align="center"><INPUT TYPE="text" name="qty_value" id="qty_value" SIZE="5" maxlength='5'  onKeyPress="return allowValidNumber(this,event,8,2);" onblur="checkForPositiveNumber(this);" ></TD>
			<td width="10%" align="left"><input type="button" name="btnAdd" id="btnAdd" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="AddDtlRec()" ></td>
		</tr>
	</table>
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
</form>
</body>
</html>

<%
//putObjectInBean(bean_id,bean,request);
%>

