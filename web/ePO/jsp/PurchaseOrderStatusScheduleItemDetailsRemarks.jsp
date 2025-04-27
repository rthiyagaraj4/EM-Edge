<!DOCTYPE html>
<%@ page import=" " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eSS/js/SSAcknowledgment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	</head>
<%
		
		String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");	
		
		
	%>
<body onload='FocusFirstElement();'>
	<form name= "formPoStatusScheduleRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="remarks" rows="6" cols="40" readonly><%=remarks%></textarea>&nbsp;
			</td>
	  </tr>
	  <tr>
		<td  colspan="2" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close();"></td>
	  </tr>
	</table>
		
	</form>
	</body>
</html>

