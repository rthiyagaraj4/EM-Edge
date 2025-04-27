<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<% 
String orderId = request.getParameter("orderId");
String readonly = request.getParameter("readonly");
if(orderId == null || orderId.equals("null"))
	orderId = "";
if(readonly==null)	readonly="";
String bean_id		 = "Or_ResultEntry" ;
String bean_name	 = "eOR.ResultEntryBean";

ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;

String TDMReason				= bean.getTDMReason(orderId);
%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
%>
<head>
	<title>TDM Details</title>
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
<table cellpadding=0 cellspacing=0 border=0 align=center>
<tr><td align=center><TEXTAREA NAME="lineComment" ROWS="5" COLS="50" <%=readonly%> onKeyPress='javascript:CheckMaxLength(this,"256")' onBlur='makeValidString(this)'><%=TDMReason%></TEXTAREA></td></tr>
<tr><td class='button'><INPUT TYPE="button"  class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='javascript:checkLineComment(document.result_entry_line_comment.lineComment)'></td></tr>
</table>
</FORM>

</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

