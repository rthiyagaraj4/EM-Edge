<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<html>
	<%
    request.setCharacterEncoding("UTF-8");
	String ref_comp=request.getParameter("ref_comp");
	if(ref_comp == null) ref_comp = "";

	%>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../../eMP/js/RegPatReferral1.js'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<style>
textarea {
  resize: none;
}
</style>
<%
if(!ref_comp.equals("reg_pat"))
{
%>
<title><fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/></title>
<%
}
else
{
%>
<title><fmt:message key="Common.notes.label" bundle="${common_labels}"/></title>
<%
}
%>

<body onLoad='populateRemarks()' onKeyDown = 'lockKey();'>
<%

    String from = request.getParameter("from") ;
	if (from==null) from ="";
	String mode=(request.getParameter("mode") == null)?"":request.getParameter("mode");
	String read = "";
	if (from.equals("search") || mode.equals("RegisterMoreReferral"))
	{
    	read = "readOnly";
	}
    else
	{
	   read = "";
	}

%>
<form method=post action="">

<table cellpadding=0 cellspacing=0 width='100%' align=center>
<%
if(ref_comp.equals("reg_pat"))
{
%>
<style>
textarea {
  resize: none;
}
</style>
<tr>
   <td class=LABEL ><fmt:message key="eMP.OtherDocAttached.label" bundle="${mp_labels}"/>&nbsp;</td>
	<td class='fields' ><TEXTAREA  name='other_doc_att'  onblur='makeValidString(this);return checkMaxLenNotes(this,"Other Document Attached")' rows="3" cols=80 ></TEXTAREA>  
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
   <td class=LABEL ><fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/>&nbsp;</td>
    <td class='fields'><textarea name="referral_notes" onBlur = 'makeValidString(this);checkMaxLenNotes(this);' rows="3" cols="80" <%=read%>></textarea></td>
    <td>&nbsp;</td>
</tr>
	<tr>
    <td >&nbsp;</td>
    <td align=right><input type=button class=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/> ' onclick='close_meNotes()'></td>
    <td >&nbsp;</td>
</tr>
	<%
}
else
{
%>
	<tr>
	 <td class='fields'><textarea name="referral_notes" onBlur = 'makeValidString(this);checkMaxLenNotes(this);' rows="7" cols="75" <%=read%>></textarea></td>   
	</tr>
	<tr>    
		<td align=right><input type=button class=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_meNotes()'></td>		
	</tr>
<%
}
%>
<input type='hidden' name='ref_comp' id='ref_comp' value='<%=ref_comp%>'>
</form>
</body>
</html>

