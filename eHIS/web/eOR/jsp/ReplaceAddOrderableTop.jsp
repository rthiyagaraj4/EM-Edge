<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>

 	<script language="JavaScript" src="../../eOR/js/CompleteOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="replaceOrderableTop" id="replaceOrderableTop">
<%
	
	int i=0;
	//String curr_sys_date       = request.getParameter("curr_sys_date");
	//if (curr_sys_date == null) curr_sys_date = "";
    //String complete_date        = request.getParameter("complete_date");
	//if (complete_date == null) complete_date = curr_sys_date;
    String complete_remarks 	= request.getParameter("complete_remarks");
	if (complete_remarks == null) complete_remarks = "";
	String catalog_code = request.getParameter("catalog_code")==null?"&nbsp;":request.getParameter("catalog_code");
	String catalog_desc = request.getParameter("catalog_desc")==null?"&nbsp;":request.getParameter("catalog_desc");
	
	String bean_id = "Or_CompleteOrder" ;
	String bean_name = "eOR.CompleteOrderBean";
	CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name , request) ;
	//11g Conversion Start.
	String order_id		=  request.getParameter("orderId");
	if(order_id==null) order_id="";
	String order_line_num		=  request.getParameter("order_line_num");
	if(order_line_num==null) order_line_num="";
	//11g Conversion End.
	bean.setLanguageId(localeName);
	ArrayList orderables = new ArrayList();
	orderables = bean.getReplaceOrderable(catalog_code,order_id,order_line_num); //11g Conversion

%>
<Table cellpadding=3 cellspacing=0 border='0' width='100%'>
<tr><td class='label' width='48%'><fmt:message key="eOR.ExistingOrderable.label" bundle="${or_labels}"/></td>
<td  class='label'  width='52%'><font size="1"><B><%=catalog_desc%></B></font>
</td></tr>

<tr><td class='label'><fmt:message key="eOR.ReplacewithOrderable.label" bundle="${or_labels}"/></td>
<td class='label'><select name="replaceadd_orderable0" id="replaceadd_orderable0">
<option value='*ALL3'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
String[] record= null;
for(int j=0;j<orderables.size();j++){
	record = new String[2];
	record = (String[])orderables.get(j);
	%><option value='<%=record[0]%>'><%=record[1]%></option>
<%
}
%>
</select><Input class='button' type='button' name='add0' id='add0' value='V' onClick='insertRow(0)' style='visibility:visible'></td>
</tr>
<%
for(i=1;i<10;i++){
%>
<tr id='replaceRow<%=i%>' style='display:none'><td class='label' ></td>
<td class='label'><select name="replaceadd_orderable<%=i%>" id="replaceadd_orderable<%=i%>">
<option value='*ALL<%=i%>'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
for(int j=0;j<orderables.size();j++){
	record = new String[2];
	record = (String[])orderables.get(j);
	%><option value='<%=record[0]%>'><%=record[1]%></option>
<%
}
%>
</select><Input class='button' type='button' name='add<%=i%>' id='add<%=i%>' value='V' onClick='insertRow(<%=i%>)' style='visibility:visible'><Input class='button' type='button' name='del<%=i%>' id='del<%=i%>' value='-' onClick='deleteRow(<%=i%>)' style='visibility:visible'></td>
</tr>	

<%
}
%>
<input type="hidden" name="qrystr" id="qrystr" value="<%=request.getQueryString()%>">
<input type="hidden" name="row_cnt" id="row_cnt" value="0">

<Table>
</Form>
</Body>
</Html>
<%
	putObjectInBean(bean_id,bean,request);
%>

