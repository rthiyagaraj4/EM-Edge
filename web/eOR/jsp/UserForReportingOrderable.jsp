<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/UserForReportingOrderable.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
 
<body  STYLE="" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<%
	/* Mandatory checks start */

	
	String ord_category_text	= request.getParameter("ord_category_text");
	String ord_category_value	= request.getParameter("ord_category_value");
	String ord_type_value		= request.getParameter("ord_type_value");
	String ord_type_text		= request.getParameter("ord_type_text");
	//System.out.println("=======ord_type_text========in jsp==="+ord_type_text);
	//String function_id			= request.getParameter("function_id");
	String mode					= request.getParameter("mode");

	String bean_id = "Or_UserForReporting" ;
	String bean_name = "eOR.UserForReporting";
	//ArrayList Category_Data = new ArrayList();

	if (ord_category_text == null || ord_category_text.equals("null")  ) ord_category_text=""; else ord_category_text = ord_category_text.trim();
	if (ord_category_value == null || ord_category_value.equals("null")  ) ord_category_value=""; else ord_category_value = ord_category_value.trim();
	if (ord_type_value == null || ord_type_value.equals("null")  ) ord_type_value=""; else ord_type_value = ord_type_value.trim();
	if (ord_type_text == null || ord_type_text.equals("null")  ) ord_type_text=""; else ord_type_text = ord_type_text.trim();
	if (mode == null || mode.equals("null")  ) mode=""; else mode = mode.trim();

	//UserForReporting bean = (UserForReporting)mh.getBeanObject( bean_id, request,  bean_name ) ;
		
	
	//boolean clearDBbean		=  bean.clearDBRec();
	
%>

 
<form name="formOrderableHeader" id="formOrderableHeader" method="post" >
<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" align="center">
<tr>
	<td   class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td><td class='data'  id="ord_category"><%=ord_category_text%></td>
	<input type=hidden name="order_category" id="order_category" value='<%=ord_category_value%>'>
	<td   class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<%if(ord_type_value.equals("*ALL")||ord_type_value.equals("")){%>
			<td><SELECT name="order_type" id="order_type" onChange='refreshScr()'>
					
	<%}else{%>
		<td class='data'  id="ord_type"><%=ord_type_text%></td>
	<%}%>
</tr>
</table>
<input type=hidden name="bean_id" id="bean_id" value='<%=bean_id%>'>
<input type=hidden name="bean_name" id="bean_name" value='<%=bean_name%>'>
<input type=hidden name="order_type_text" id="order_type_text" value='<%=ord_type_text%>'>
<input type=hidden name="order_type_value" id="order_type_value" value='<%=ord_type_value%>'>
<input type=hidden name="order_category_text" id="order_category_text" value='<%=ord_category_text%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</form>
</body>
</html>
<%if(ord_type_value.equals("*ALL")||ord_type_value.equals("")){%>
<script>populateOrderTypes()</script>
<%}%>

