<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head> 
<title><fmt:message key="Common.referral.label" bundle="${common_labels}"/><fmt:message key="Common.notes.label" bundle="${common_labels}"/></title>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
		String referralid = request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
		String locncode = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String locntype = request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
%>
<script language="JavaScript">
<!--
		function returnText(val)
		{
			if(val == 'O')
			{
//				if(document.forms[0].print_yn.checked == true)
				document.forms[0].submit();
			}
			parent.window.close();

		}
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown = 'lockKey();'>
	<form name="RegPatReferralPrint_form" id="RegPatReferralPrint_form" action="../../servlet/eOP.RegPatReferralServlet" method="post" target="messageFrame">
		<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%">
		<tr>
			<td align=center class=LABEL><fmt:message key="Common.referralid.label" bundle="${common_labels}"/> : <b> <%=referralid%></b></td>
		</tr>
		<tr><td>&nbsp;</td></tr>

		<tr>
			<td align=center  class=LABEL><fmt:message key="eOP.PrintReferralLetter.label" bundle="${op_labels}"/> ?</td>
		</tr>
		<tr><td>&nbsp;</td></tr>

		<tr>
			<td align=center>
				<input type="button" class=BUTTON value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onClick="returnText('O')">&nbsp;&nbsp;
				<input type="button" class=BUTTON value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>' onClick="returnText('C')">
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		</table>

		<input type="hidden" name="referral_id" id="referral_id" value="<%=referralid%>">	
		<input type="hidden" name="locn_code" id="locn_code" value="<%=locncode%>">	
		<input type="hidden" name="locn_type" id="locn_type" value="<%=locntype%>">	
		<input type="hidden" name="operation_type" id="operation_type" value="print">	

	</form>
</body>
</html>

