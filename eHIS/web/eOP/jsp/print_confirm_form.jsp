<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" %>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
		String referralid = request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
		String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
		
		String appt_ref_no = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");
		String locncode = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String locntype = request.getParameter("locn_type")==null?"L":request.getParameter("locn_type");
		String message  = request.getParameter("message")==null?"":request.getParameter("message");
		String module_id="";
		String report_id="";
		String display_id = "";
		String confirm="";
		if (call_from.equals("OA_APPT"))
		{
			module_id="OA";
			report_id="OARAPSL";
			display_id= appt_ref_no;
		}
		else
		{
			module_id ="OP";
			report_id ="OPRFLETR";
			display_id= referralid;
		}
		if (call_from.equals("PAT_CHECKOUT"))
		{
			confirm =message + "?";
			message="";
			display_id="";
		}

%>
<script language="JavaScript">
var iname = "test";
		function returnText(val)
		{
		if(val == 'O')
			{
				document.forms[0].submit();
			}
			
			parent.window.close();

		}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown = 'lockKey();'>
	<form name="RegPatReferralPrint_form" id="RegPatReferralPrint_form" action="../../servlet/eOP.RegPatReferralServlet" method="post" target="messageFrame">
		<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%">
		<tr>
			<td align=center class=LABEL><%=message%><b><%=display_id%></b></td>
		</tr>
	   <tr><td class='DEFAULTBLANKROW2PT' colspan=2>&nbsp;</td></tr></tr>
		<tr>
			<td align=center  class=LABEL><%=confirm%></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td align=center>
				<input type="button" class=BUTTON value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onClick="returnText('O')"><input type="button" class=BUTTON value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>' onClick="returnText('C')">
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		</table>
		<input type="hidden" name="call_from" id="call_from" value="<%=call_from%>">	
		<input type="hidden" name="appt_ref_no" id="appt_ref_no" value="<%=appt_ref_no%>">	
		<input type="hidden" name="referral_id" id="referral_id" value="<%=referralid%>">	
		<input type="hidden" name="locn_code" id="locn_code" value="<%=locncode%>">	
		<input type="hidden" name="locn_type" id="locn_type" value="<%=locntype%>">	
		<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">	
		<input type="hidden" name="report_id" id="report_id" value="<%=report_id%>">	
		<input type="hidden" name="operation_type" id="operation_type" value="print">	

	</form>
</body>
</html>

