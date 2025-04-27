<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_ViewOrder" ;
	//String bean_name = "eOR.ViewOrder";


	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String result_comment = request.getParameter("result_comment");
	//out.println(row_index);
	//if(row_index==null)	row_index="";

	//String templateText = bean.getClobData(row_index);
	//out.println("template_id= "+template_id+"msr_desc="+msr_desc+);
%>

<html>
<head>
	<title><fmt:message key="eOR.ResultComment.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body style='background-color:#E2E3F0;' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='result_clob_data_view' id='result_clob_data_view' METHOD=POST>
<table cellpadding=0 cellspacing=0 border=0 align=center width='100%'>
<tr><td align=center><TEXTAREA NAME="" ROWS="6" COLS="60" readonly><%=result_comment%></TEXTAREA></td></tr>
<tr><td class='button'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td></tr>
</table>
</FORM>
</BODY>
</HTML>

