<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
");
			parent.sendtextframe.document.getElementById("chatwith").innerHTML = "<font color=black size=1 >Status: chatting with " +userName+"</font>"
			parent.blankframe1.document.tempForm.submit();
			parent.sendtextframe.document.form1.sendButton.disabled=true;
			parent.sendtextframe.document.forms[0].instantsendmsg.focus();
			return;
		}
	}
}
//function to accept characters from the keyboard

</SCRIPT>
</head>
<%



%>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" bgcolor=#E2E3F0 >
<FORM METHOD=POST name="form1" id="form1">
<TABLE border=1 bordercolor=#10319C width='100%'>
<TR>
<TD>
<TABLE cellpadding='3' cellspacing='0' border=0 align=left>
<!-- <tr>
	<TD align=left width="100%" height="10"></td>
	<TD align=left width="100%"></td>
</tr> -->
<TR>
	<td width="100%" align=left><font color='brown' size='2' style='font-weight:bold' >&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.TypeYourMessagehere.label" bundle="${ca_labels}"/>:</font></td>
	<td width="100%" align=left><font color='brown' size='2' style='font-weight:bold' ></font></td>
</tr>
<!-- <tr>
	<TD align=left width="100%" height="5"></td>
	<TD align=left width="100%" ></td>
</tr> -->
<tr>
	<td align=left width='80%'>&nbsp;&nbsp;&nbsp;<textarea NAME="instantsendmsg"  scrolling="auto" value ="" rows=2 cols=49 onkeyUP="enableButton(this)" onkeyDown="enableButton(this)" onkeypress="return funcenter()"></textarea>&nbsp;<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Send.label","ca_labels")%>' name="sendButton" class="BUTTON" disabled onclick="appendtext(this)" style="height:38">&nbsp;</td>
</tr>
<!-- <tr>
	<TD align=left width="80%" height="5"></td>
	<TD align=left width="100%"></td>
</tr> -->
</table>	</TD>
</TR>
</TABLE>
<TABLE border=1 cellpadding='3' cellspacing='0' bordercolor=#10319C width='100%'>
<TR>	
	<TD align=left width="100%" height="22" id="chatwith"></td>
	<TD align=left width="100%"></td>
</tr> 
</TABLE>
<input type="hidden" name="to_user" id="to_user" value="">
<input type="hidden" name="to_user_resp_id" id="to_user_resp_id" value="">
<input type="hidden" name="login_user" id="login_user" value="">
</FORM>
</body>
</html>

