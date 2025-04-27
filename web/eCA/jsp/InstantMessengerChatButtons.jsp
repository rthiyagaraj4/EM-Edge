<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
");
	parent.blankframe2.document.tempForm2.submit();
	parent.sendtextframe.document.forms[0].instantsendmsg.focus();
}
//-->
</SCRIPT>
</head>
<body   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"onunload="exit()" onmousedown="CodeArrest()">
<FORM METHOD=POST  name="formbutton" id="formbutton">
<TABLE border=1 bordercolor=#10319C width='100%'>
<tr>
<td>
	<TABLE width='100%' cellpadding='3' cellspacing='0' border='0' >
 <tr>
		<TD  width="100%" height="20">			</td>
		<TD  width="100%">			</td>
	</tr>
	<tr>
		<TD align=center><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>'  class="BUTTON" onclick="appendtext()"></td>
	</tr>
	<tr>
		<TD  width="100%" height="10">			</td>
		<TD  width="100%">			</td>
	</tr> 
	<tr>
		<TD align=center><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SignOut.label","ca_labels")%>' class="BUTTON" onclick="exit()"></TD>
	</tr>
	 <tr>
		<TD  width="100%" height="20">			</td>
		<TD  width="100%">			</td>
	</tr> 
	<tr>
		<TD  width="100%" height="10">			</td>
		<TD  width="100%">			</td>
	</tr> 
</td>
</tr>
</table>
</table>
</body>
</FORM>
</html>

