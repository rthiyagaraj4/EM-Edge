<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<title><fmt:message key="eOR.ChangeChargeType.label" bundle="${or_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>  
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	
 	<script language="JavaScript" src="../../eOR/js/CompleteOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<!-- <script>
	function checkMaxLimitLocal(obj,maxSize){

		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
		}	
	</script> -->
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" >
<FORM name="completeRemarks" id="completeRemarks">
<Table cellpadding=0 cellspacing=0 border='0' width='100%' align='center' height='100%'>
<%
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String complete_remarks 	= request.getParameter("complete_remarks");
	if (complete_remarks == null) complete_remarks = "";
	String order_id		=  request.getParameter("orderId");
	if(order_id==null) order_id="";
	String order_line_num		=  request.getParameter("order_line_num");
	if(order_line_num==null) order_line_num="";
	String function_from = request.getParameter("function_from");
	if(function_from==null) function_from="";
	String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");
	String catalog_desc = request.getParameter("catalog_desc")==null?"":request.getParameter("catalog_desc");
	String charge_type_code = request.getParameter("charge_type_code")==null?"":request.getParameter("charge_type_code");
	String charge_type_desc = request.getParameter("charge_type_desc")==null?"":request.getParameter("charge_type_desc");
	String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String bean_id = "Or_CompleteOrder" ;
	String bean_name = "eOR.CompleteOrderBean";
	CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	ArrayList charge_type = new ArrayList();
	//System.out.println("order_category==="+order_category);
	charge_type = bean.getChargeType(order_category);
	//System.out.println("####qrystr="+request.getQueryString());
%>
<tr><td colspan='2'></td></tr>
<tr><td class='label' align='right'  width='48%'><fmt:message key="eOR.ExistingCharge Type.label" bundle="${or_labels}"/></td>
<td  class='label'  width='52%'><font size="1"><B><%=charge_type_desc%></B></font><input type="hidden" name="charge_type_code" id="charge_type_code" value="<%=charge_type_code%>">
</td></tr>
<tr><td colspan='2'></td></tr>
<tr><td class='label' align='right'><fmt:message key="eOR.NewChargeType.label" bundle="${or_labels}"/></td>
<td class='label' align=''><select name="new_charge_type" id="new_charge_type" >
<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
	String[] record= null;
	//System.out.println("charge_type===="+charge_type.size());
	for(int j=0;j<charge_type.size();j++){
	record = new String[2];
	record = (String[])charge_type.get(j);
	%><option value='<%=record[0]%>'><%=record[1]%></option>
<%
}
%>
</select><img src="../../eCommon/images/mandatory.gif"></td>
</tr>

<tr><td colspan='2'></td></tr>
<!-- <tr><td class='label' align='right' width='50%'>Remarks</td><td><TextArea rows='5' cols='30' name='complete_remarks' value=''  width='50%' onkeypress="checkMaxLimitLocal(this,2000)" onBlur="makeValidString(this);chkRemarksLength();" ><%=complete_remarks%></TextArea><img src="../../eCommon/images/mandatory.gif">
</td></tr> -->

<tr><td colspan='2' class='button'><Input class='button' type='button' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='callOrder()'><Input class='button' type='button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='clickClose();'></td></tr>

<input type="hidden" name="qrystr" id="qrystr" value="<%=request.getQueryString()%>">
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
<input type="hidden" name="catalog_desc" id="catalog_desc" value="<%=catalog_desc%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
 
<input type="hidden" name="mode" id="mode" value="2"> 

</Table>
</Form>
</Body>
</Html>
<%
	putObjectInBean(bean_id,bean,request);
%>

