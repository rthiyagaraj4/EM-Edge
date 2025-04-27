
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryFormatItem.js"></script>


<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name=list_dtl  id=list_dtl >
<%
int field_length = 2 ;
String field_mnemonic = (String)request.getParameter("field_mnemonic")==null?"":(String)request.getParameter("field_mnemonic");
if(field_mnemonic.equalsIgnoreCase("SPECIMEN_TYPE"))
{
	field_length = 3 ;
}
else
{
	field_length = 2 ;
}
%>
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' align=center>
<tr><td width="40%" class="label" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td><td class="fields"><input type=text name="desc" id="desc" value="" size=50 maxlength=50  onBlur = "return makeValidString(this);"><img src="../../eCommon/images/mandatory.gif"></td></tr>
<tr><td width="40%" class="label" ><fmt:message key="eOR.SequenceNumber.label" bundle="${or_labels}"/></td><td class="fields"><input type=text name="seq_no" id="seq_no" value="" size=<%=field_length%> maxlength=<%=field_length%> onKeyPress='return allowPositiveNumber()' onBlur="return checkPositiveNumber(this)"><img src="../../eCommon/images/mandatory.gif"></td></tr>
<tr>
	<td colspan=2 class='button'>
	<input type=hidden name="finalString" id="finalString" value="">
	<input type=hidden name="format_flag" id="format_flag" value="">
	<input type=button class="button" name="select" id="select" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>" onClick="javascript: return chkMandatory();">
	<input type=button class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="javascript: takeValues();">
	<input type=button  class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>"  onClick="javascript: removeValues();">
	<input type=button class="button" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="javascript:closeWindow()"> 
	</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value="">
<input type=hidden name='old_desc' id='old_desc' value="">
<input type=hidden name='old_seq_no' id='old_seq_no' value="">
<input type=hidden name='dontChk' id='dontChk' value="">

</form>
</body>
</html>

