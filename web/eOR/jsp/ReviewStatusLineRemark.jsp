<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<SCRIPT LANGUAGE="JavaScript">
<!--
function doInit(){
	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	document.getElementById("remark").value = val
}

//-->
</SCRIPT>

<%
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewStatus" ;
	String bean_name = "eOR.ReviewStatusBean";
	//out.println(request.getQueryString());
	String lineStatus = request.getParameter("lineStatus");
	String lineStatusRemark = request.getParameter("lineStatusRemark");
	if(lineStatusRemark == null || lineStatusRemark.equals("null"))
		lineStatusRemark = "";
	if(lineStatus == null || lineStatus.equals("null"))
		lineStatus = "";
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ReviewStatusBean bean = (ReviewStatusBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;

	ArrayList OrderStatus = new ArrayList();
	OrderStatus = bean.getOrderStatus();
%>

<html>
<head>

	<title><fmt:message key="eOR.StatusRemark.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ReviewStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body onload='doInit()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name='review_status_line_remark' id='review_status_line_remark' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%" height="100%">
<tr>
	<td class='label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='label'>
		<select name='order_status' id='order_status'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%
		try{
		if(OrderStatus!=null)
		{	
			for( int i=0; i<OrderStatus.size(); i++)
			{	String[] record = new String[3];
				record = (String[])OrderStatus.get(i);
				if(record[1].equalsIgnoreCase(lineStatus.trim())){
				%>
					<option value='<%=record[1]%>' selected><%=record[0]%></option>
				<%}else if(record[2].trim().equalsIgnoreCase(record[1].trim()) && lineStatus.trim().equals("")){
				%>
					<option value='<%=record[1]%>' selected><%=record[0]%></option>
				<%}else{%>
					<option value='<%=record[1]%>'><%=record[0]%></option>
		<%}}}
		}catch(Exception e){}
		%>
		</select>
	</td>
	</tr>
	<tr>
	<td class=fields colspan="2"><TEXTAREA NAME="remark" ROWS="6" COLS="45" onKeyPress='javascript:CheckMaxLength(this,"256")'></TEXTAREA>
	</td>
</tr>
<tr>
	<td colspan='3' class=button><INPUT TYPE="button"  class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='javascript:checkLineStatus(document.review_status_line_remark.order_status, document.review_status_line_remark.remark)'>
	</td>
</tr>
</table>
</FORM>
<%
	putObjectInBean(bean_id,bean,request);
%>
</BODY>
</HTML>

