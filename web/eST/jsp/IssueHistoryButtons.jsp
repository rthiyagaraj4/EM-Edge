<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/15/2021              IN0071699          ChandraShekar Raju                                  				 MO-CRF-20166
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.AcknowledgmentBean" contentType="text/html;charset=UTF-8" %>
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
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/Request.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
	</head>

<body onload='FocusFirstElement();'>
	<form name= "historyButtonframe">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
	  <tr>
		<td  width="80%" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='const dialogTag = parent.parent.document.getElementById("dialog_tag");dialogTag.close();'></td>
	  </tr>
	</table>
		
	</form>
	</body>
</html>

