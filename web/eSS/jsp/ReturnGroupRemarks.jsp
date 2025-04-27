<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.ReturnGroupBean" contentType="text/html;charset=UTF-8" %>
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
		<script language="JavaScript" src="../../eSS/js/ReturnGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<title>Reason For Return</title>
	</head>
<%
		String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");	
	
	%>
<body onload='FocusFirstElement();'>
	<form name= "formreturngroupRemarks">
	
		<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="remarks" rows="5" cols="40" onKeyPress="return false;" readonly><%=remarks%></textarea>
			</td>
	  </tr>
	  <tr>
	  <td colspan=2>&nbsp;</td>
		<td align=center><input type="button" align='center' class="button" name="close" id="close" value=" Ok " onClick="window.close();"></td>
	  </tr>
	</table>
		</form>
	</body>
</html>

