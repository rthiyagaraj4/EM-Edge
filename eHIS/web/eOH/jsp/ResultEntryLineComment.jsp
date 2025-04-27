<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String line_narration = request.getParameter("line_narration");
String readonly = request.getParameter("readonly");
if(line_narration == null || line_narration.equals("null"))
	line_narration = "";
//if(readonly==null)	readonly="";
//out.println("line_narration===="+line_narration);
%>
<html>

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_entry_line_comment' id='result_entry_line_comment' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center height="100%" width="100%">
<tr><td class=fields><TEXTAREA NAME="lineComment" ROWS="5" COLS="59" <%=readonly%> onKeyPress='javascript:CheckMaxLength(this,"256")' onBlur='makeValidString(this)'><%=line_narration%></TEXTAREA></td></tr>
<tr><td class=button><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='javascript:checkLineComment(document.result_entry_line_comment.lineComment)'></td></tr>
</table>
</FORM>

</BODY>
</HTML>

