<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");

	if (bean_id		== null) bean_id = "";
	if (bean_name	== null) bean_name = "";//out.println("<script>alert('bean_id="+bean_id +",bean_name="+bean_name +"')</script>");
%>
<html>
<head>

	<title><fmt:message key="eOR.ChangePerformingLocation.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<%if (bean_id.equals("Or_RegisterOrder")) {%>
 	<script language="JavaScript" src="../../eOR/js/RegisterOrder.js"></script>
 	<%} else if(bean_id.equals("Or_ResultReporting")){%>
 	<script language="JavaScript" src="../../eOR/js/ResultReporting.js"></script>
 	<%} else if(bean_id.equals("Or_SpecimenOrder")){%>
 	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
 	<%}%>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
		function enableOK(obj) 
		{
		//alert("value is...."+obj.value);
			//alert(document.register_order_perform_locn.value)
			var formObj = document.register_order_perform_locn;
			if(obj.name == "performing_facility" && obj.value != "" && obj.value != formObj.perf_facility.value)
					formObj.ok_but.disabled = false;
			else if(obj.name == "performing_location" && obj.value != "" && obj.value != formObj.perf_location.value)
					formObj.ok_but.disabled = false;
			else
				formObj.ok_but.disabled = true;
}
</script>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="register_order_perform_locn" id="register_order_perform_locn">
<%
	//String bean_id = "Or_RegisterOrder" ;
	//String bean_name = "eOR.RegisterOrder";
	
    String performing_facility		= request.getParameter("performing_facility");
    String performing_location_type = request.getParameter("performing_location_type");
	String performing_location		= request.getParameter("performing_location");
	String order_id					= request.getParameter("orderId");
	String order_line_num			= request.getParameter("order_line_num");
	String order_category			= request.getParameter("order_category");
	String patient_id				= request.getParameter("patient_id");
	String sex						= request.getParameter("sex");
	String encounter_id				= request.getParameter("encounter_id");
	String int_or_ext				= request.getParameter("int_or_ext");
	String priority 				= request.getParameter("priority");
	String patient_class			= request.getParameter("patient_class");
	String order_type_code			= request.getParameter("order_type_code");
	String source_code				= request.getParameter("source_code");
	String source_type				= request.getParameter("source_type");
	ArrayList sysDateTime  = new ArrayList();
	if (performing_facility==null) performing_facility = "";
	if (performing_location_type==null) performing_location_type = "";
	if (performing_location==null) performing_location = "";
	if (order_id==null) order_id = "";
	if (order_line_num==null) order_line_num = "";
	if (order_category==null) order_category = "";
	if (patient_id==null) patient_id = "";
	if (sex==null) sex = "";
	if (encounter_id == null) encounter_id = "";
	if (int_or_ext == null) int_or_ext = "";

	String mode 						= "2";
	String order_catalog_code 			= "";
	ArrayList performing_facility_arr	= new ArrayList();
	ArrayList performing_location_arr 	= new ArrayList();

	if (bean_id.equals("Or_RegisterOrder")) {
		RegisterOrder bean 	= (RegisterOrder)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		order_catalog_code = bean.getOrderCatalogCode(order_id,order_line_num);
		performing_facility_arr = bean.getPerformingFacilityDetails();
		if (!performing_facility.equals("")) {
		   //out.println("<script>alert('performing_facility="+ performing_facility + ",order_category=" + order_category + ", order_catalog_code = " + order_catalog_code + "')</script>");
		   performing_location_arr = bean.getPerformingLocationDetails(performing_facility,order_category,order_catalog_code);
		}
		putObjectInBean(bean_id,bean,request);
	}else if(bean_id.equals("Or_ResultReporting")){
		
		ResultReportingBean bean 	= (ResultReportingBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		order_catalog_code = bean.getOrderCatalogCode(order_id,order_line_num);
		performing_facility_arr = bean.getPerformingFacilityDetails();
		
		if (!performing_facility.equals("")) {
		  // out.println("<script>alert('performing_facility="+ performing_facility + ",order_category=" + order_category + ", order_catalog_code = " + order_catalog_code + "')</script>");
		   performing_location_arr = bean.getPerformingLocationDetails(performing_facility,order_category,order_catalog_code);
		}
		putObjectInBean(bean_id,bean,request);
	}	
	else if(bean_id.equals("Or_SpecimenOrder"))
	{	
		SpecimenOrder bean 	= (SpecimenOrder)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		System.out.println("RegisterOrderPerformLocn.jsp,performing_facility=>"+performing_facility+",order_id=>"+order_id+",order_line_num=>"+order_line_num);
		order_catalog_code = bean.getOrderCatalogCode(order_id,order_line_num);
		performing_facility_arr = bean.getPerformingFacilityDetails();

		if (!performing_facility.equals("")) 
		{
			performing_location_arr = bean.getPerformingLocationDetails(performing_facility,"LB",order_catalog_code);
		}
		
		sysDateTime = bean.getSysDateTime();
		putObjectInBean(bean_id,bean,request);
	}

%>
	<table cellpadding=15 cellspacing=3 border='0' width='100%' height='100%' align='center'>
	  <TR>
			<TD class='label'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select name="performing_facility" id="performing_facility"  onChange='fillPerformingLocation(this);'><Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%for (int j = 0; j < performing_facility_arr.size(); j++) {String [] record = (String [])performing_facility_arr.get(j);%>
					<option value="<%=record[0]%>" <%=(record[0].equals(performing_facility))?"selected":""%>><%=record[1]%></option>
				<%}%>
				</Select><img src="../../eCommon/images/mandatory.gif" align=center></TD>
		</TR>
		
		<TR>
			<TD class='label'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><Select width='30' name="performing_location" id="performing_location"><Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%//System.out.println("==performing_location_arr.size()=="+performing_location_arr.size());
				for (int j = 0; j < performing_location_arr.size(); j++) {String [] record = (String [])performing_location_arr.get(j);%>
					<option value="<%=record[0]%>" <%=(record[0].equals(performing_location))?"selected":""%>><%=record[1]%></option>
				<%}%>
				</Select>
			</TD>
		</TR>
		
		<tr align='right'>
    		<td colspan='2' class='button'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' name='ok_but' class='button' onClick='updateChangePerformLocn();'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick="parent.document.getElementById('dialog_tag').close();">
    		</td>
	    </tr>
		<Input name='order_category' id='order_category' type='hidden' value='<%=order_category%>'>
		<Input name='order_catalog_code' id='order_catalog_code' type='hidden' value='<%=order_catalog_code%>'>
		<Input name='order_type_code' id='order_type_code' type='hidden' value='<%=order_type_code%>'>
		<Input name='order_no' id='order_no' type='hidden' value='<%=order_id%>'>
		<Input name='order_id' id='order_id' type='hidden' value='<%=order_id%>'>
		<Input name='order_line_num' id='order_line_num' type='hidden' value='<%=order_line_num%>'>
		<Input name='sex' id='sex' type='hidden' value='<%=sex%>'>
		<Input name='patient_id' id='patient_id' type='hidden' value='<%=patient_id%>'>
		<Input name='encounter_id' id='encounter_id' type='hidden' value='<%=encounter_id%>'>
		<Input name='int_or_ext' id='int_or_ext' type='hidden' value='<%=int_or_ext%>'>
		<Input name='patient_class' id='patient_class' type='hidden' value='<%=patient_class%>'>
		<Input name='priority' id='priority' type='hidden' value='<%=priority%>'>
		<Input name='source_type' id='source_type' type='hidden' value='<%=source_type%>'>
		<Input name='source_code' id='source_code' type='hidden' value='<%=source_code%>'>
		<Input name='performing_location_type' id='performing_location_type' type='hidden' value='<%=performing_location_type%>'>
		<Input name='bean_id' id='bean_id' type='hidden' value='<%=bean_id%>'>
		<Input name='bean_name' id='bean_name' type='hidden' value='<%=bean_name%>'>
		<Input name='mode' id='mode' type='hidden' value='<%=mode%>'>
		<Input name='perf_facility' id='perf_facility' type='hidden' value='<%=performing_facility%>'>
		<Input name='perf_location' id='perf_location' type='hidden' value='<%=performing_location%>'>
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<Input name='function_from' id='function_from' type='hidden' value='CHANGE_PERFORM_LOCN'>
		<%
		if (bean_id.equals("Or_SpecimenOrder")) {%>
		<input type ='hidden' name ='curr_sys_date' value ='<%=sysDateTime.get(2)%>'
		<%}%>
</table>

</FORM>
<!--<table cellpadding=0 cellspacing=0 border='0' width='98%'>
	<tr><td align=right colspan=3><input type=button class=button name="ok" id="ok" Value="Ok" onclick="closeDate();"></td></tr>
	</Table>-->
</body>
</html>

