<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/dchk.js' language='javascript'></script> 
	<script language='javascript' src="../../eMR/js/CreatePatientFile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String call_from=request.getParameter("call_from");
	if(call_from==null) call_from="";
	
%>
<body onKeyDown='lockKey()'>
<FORM name="Record_Diag" id="Record_Diag" METHOD=POST ACTION="">
		<table border ='0' cellpadding=0 cellspacing=0 width="100%">
		<tr>
		<%if (call_from.equals("MODIFY_DEATH_DETAILS"))
		{
			
			%>
				<td width="50%" class='fields'>&nbsp;</td>
				<td width="50%"  class='button'>			
		<%}else
		{%>
				<td width="75%" class='fields'>&nbsp;</td>
				<td width="25%"  class='button'>
		<%}%>
			<%
			if (call_from.equals("MODIFY_DEATH_DETAILS"))
			{	%>
				<input type='button' name='Save' id='Save' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='apply3()'>
			<%}
			else if (!call_from.equals("MR_VIEW_DTH_REG"))
			{	%>
				<input type='button' name='Save' id='Save' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='apply2()'>
			<%}%>
				<input type='button' name='Cancel' id='Cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onclick='cancelPage()'>
			</td>

		</tr>
</FORM>
</body>
</html>

