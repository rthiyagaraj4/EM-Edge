<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eFM.CancelRequestRemarks.label" bundle="${fm_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	String RemarksValue = request.getParameter("RemarksValue");
	String RemarksType	= request.getParameter("RemarksType");

	if(RemarksValue == null || RemarksValue.equals("null")) RemarksValue = "";

	String p_disb_col	="";

	if(RemarksType.equals("R"))
	{
		p_disb_col	=	"readonly";
	}
	%>
</head>
<body onload="doInit()"  onKeyDown = 'lockKey()' onUnload ="closeWin();" style='background-color:#E2E3F0;'>
	<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
		<tr>
			<td  class='label' width='10%'></td>
		</tr>
		<tr>
			<td  width='90%' class='fields'><textarea name="comments" rows="5" cols="60" onkeypress="checkMaxLimit(this,100)" onBlur="makeValidString(this);checklength()" <%=p_disb_col%>></textarea></td>
		</tr>
	</table>
	<center><input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose("<%=RemarksType%>")'></center>
</body>
</html>

