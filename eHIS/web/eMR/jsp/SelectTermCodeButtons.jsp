<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Vinay
*	Created On		:	07 Feb 2005
--%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String display_clos_btn=checkForNull(request.getParameter("display_clos_btn"),"Y");
	String btn_display="inline";
	if(display_clos_btn.equals("N")){
		btn_display="none";
	}

%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<script language="JavaScript" src="../js/Accuracy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function termcodeval()
{
	if(document.sel_term_code_button.select_yn.value=="Y")
	{
		parent.parent.window.returnValue = document.sel_term_code_button.termcode.value;
		parent.parent.parent.document.getElementById("dialog_tag").close();
	}
	else
		alert(getMessage("LEVEL_NOT_SELECT",'MR'));
}
function wincls()
{
	const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");
	dialogTag.close(); 
}
</script>
</head>
<body onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="" name="sel_term_code_button" id="sel_term_code_button">
<table width="97%">
<tr>
	<td align="right" class='button' width="100%">
		<INPUT class="button" TYPE="button" value="Select" onclick="termcodeval()"><INPUT class="button" TYPE="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick='parent.parent.parent.document.getElementById("dialog_tag").close();' style="display:<%=btn_display%>">
	</td>
</tr>
</table>
<INPUT TYPE="hidden" name="termcode" id="termcode" value="">
<INPUT TYPE="hidden" name="select_yn" id="select_yn" value="">
</FORM>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

