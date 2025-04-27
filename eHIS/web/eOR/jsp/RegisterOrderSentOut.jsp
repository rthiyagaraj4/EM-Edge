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
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id						= request.getParameter("bean_id");
	String bean_name					= request.getParameter("bean_name");

	if (bean_id			== null) bean_id	= "";
	if (bean_name		== null) bean_name	= "";
%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<title><fmt:message key="eOR.SendOut.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 <!--	<script language="JavaScript" src="../../eOR/js/RegisterOrder.js"></script>-->
	<%if (bean_id.equals("Or_RegisterOrder")) {%>
 	 <script language="JavaScript" src="../../eOR/js/RegisterOrder.js"></script> 
 	<%} else {%>
 	<script language="JavaScript" src="../../eOR/js/ResultReporting.js"></script>
 	<%}%>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="register_order_sent_out" id="register_order_sent_out">
<%
		//String bean_id = "Or_RegisterOrder" ;
	//String bean_name = "eOR.RegisterOrder";
//out.println("<script>alert('bean_id:::"+bean_id+"');</script>");
    String performing_facility  		= request.getParameter("performing_facility");
    String performing_location_type  	= request.getParameter("performing_location_type");
	String performing_location  		= request.getParameter("performing_location");
	String order_id  					= request.getParameter("orderId");
	String order_line_num  				= request.getParameter("order_line_num");
	String order_category  				= request.getParameter("order_category");
	String patient_id 					= request.getParameter("patient_id");
	String sex 							= request.getParameter("sex");
	String encounter_id 				= request.getParameter("encounter_id");
	String priority 					= request.getParameter("priority");
	String patient_class 				= request.getParameter("patient_class");
	String order_type_code				= request.getParameter("order_type_code");
	String source_code					= request.getParameter("source_code");
	String source_type					= request.getParameter("source_type");
	//String temp="";
	if (performing_facility==null) performing_facility = "";
	if (performing_location_type==null) performing_location_type = "";
	if (performing_location==null) performing_location = "";
	if (order_id==null) order_id = "";
	if (order_line_num==null) order_line_num = "";
	if (order_category==null) order_category = "";
	if (patient_id==null) patient_id = "";
	if (sex==null) sex = "";
	if (encounter_id == null) encounter_id = "";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	String mode 					= "2";
	
	ArrayList ref_sent_remarks_arr	= new ArrayList();
	ArrayList sys_date_arr			= new ArrayList();
	ArrayList ref_form_arr			= new ArrayList();
	ArrayList ord_catalog_arr		= new ArrayList();
	String ref_date_time            = "";
	String ref_sent_pract_id  		= "";
	String order_catalog_code		= "";
	String order_catalog_desc		= "";

	if (bean_id.equals("Or_RegisterOrder")) {
		RegisterOrder bean 	= (RegisterOrder)getBeanObject( bean_id,bean_name ,request) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		//order_catalog_code 		= bean.getOrderCatalogCode(order_id,order_line_num);
		ref_sent_remarks_arr 	= bean.getReferralFacility();
		sys_date_arr			= bean.getSysDateTime();
		if (sys_date_arr != null && sys_date_arr.size() > 0) {
			ref_date_time            = (String)sys_date_arr.get(3);
			if (ref_date_time==null || ref_date_time.equals(" ") || ref_date_time.equals("null")) ref_date_time="";
		}
		ref_sent_pract_id  = bean.getPractitionerName(practitioner_id);
		ref_form_arr = bean.getRefusalForm();
		ord_catalog_arr= bean.getOrderCatalog(order_id,order_line_num);
		for (int i = 0; i < ord_catalog_arr.size(); i++) {
			String [] record = (String [])ord_catalog_arr.get(i);
			order_catalog_code = record[0];
			order_catalog_desc = record[1];
		}

		putObjectInBean(bean_id,bean,request);
//out.println("<script>alert('performing_location_type::"+performing_location_type+", performing_location:::"+performing_location+",performing_facility::"+performing_facility+" ');</script>");
	} else {
		ResultReportingBean bean 	= (ResultReportingBean)getBeanObject( bean_id,bean_name ,request) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		//order_catalog_code 		= bean.getOrderCatalogCode(order_id,order_line_num);
		ref_sent_remarks_arr 	= bean.getReferralFacility();
		sys_date_arr			= bean.getSysDateTime();
		if (sys_date_arr != null && sys_date_arr.size() > 0) {
			ref_date_time            = (String)sys_date_arr.get(3);
			if (ref_date_time==null || ref_date_time.equals(" ") || ref_date_time.equals("null")) ref_date_time="";
		}
		ref_sent_pract_id  = bean.getPractitionerName(practitioner_id);
		ref_form_arr = bean.getRefusalForm();
		ord_catalog_arr= bean.getOrderCatalog(order_id,order_line_num);
		for (int i = 0; i < ord_catalog_arr.size(); i++) {
			String [] record = (String [])ord_catalog_arr.get(i);
			order_catalog_code = record[0];
			order_catalog_desc = record[1];
		}

		putObjectInBean(bean_id,bean,request);
	}


%>
	<table cellpadding=3 cellspacing=0 border='0' width='100%' height='100%' align=center>
	
	    <TR><TD class='label' colspan='2'></TD></TR>
    	<TR>
			<TD class='label' width='40%'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></TD>
			<TD class='fields' width='60%'><Select width='30' name="ref_facility_id" id="ref_facility_id" ><Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%for (int j = 0; j < ref_sent_remarks_arr.size(); j++) {String [] record = (String [])ref_sent_remarks_arr.get(j);%>
					<option value="<%=record[0]%>" ><%=record[1]%></option>
				<%}%>
				</Select><img src="../../eCommon/images/mandatory.gif" align=center/></TD>
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
		<TR>
			<TD class='label' width='40%'><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></TD>
			<%if (localeName!="en")
				ref_date_time=com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM","en",localeName);
				
			%>
			<TD class='label' width='60%'><B><%=ref_date_time%></B><Input name='ref_date_time' id='ref_date_time' type='hidden' value='<%=ref_date_time%>'></TD>
		</TR>
		<TR><TD colspan='2'></TD></TR>
		<TR>
			<TD class='label' width='40%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></TD>
			<TD class='label' width='60%'><B><%=ref_sent_pract_id%></B><Input name='ref_sent_pract_id' id='ref_sent_pract_id' type='hidden' value='<%=practitioner_id%>'></TD>
		</TR>
		<TR><TD colspan='2'></TD></TR>
		<tr>
			<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class=fields><TEXTAREA NAME="ref_sent_remarks" ROWS="3" COLS="25" onkeyPress='checkMaxLimit(this,500)'  onBlur="return makeValidString(this);"></TEXTAREA></td>   <%--<img src="../../eCommon/images/mandatory.gif" align=center/>--%>
		</tr>
		<TR><TD colspan='2'></TD></TR>
		<tr>
			<td class='label' width='40%'><fmt:message key="eOR.ReferralForm.label" bundle="${or_labels}"/></td>
			<!-- <TD class='label' width='60%' align='left' OnClick='javascript:showRefusalDesc()'>&nbsp;<a href='#'>Refusal Text</a></TD>  -->
			<td class='fields' width='60%'><select name="refferal_form" id="refferal_form" onchange="showRefusalText(this)" >
			<Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%for (int i = 0; i < ref_form_arr.size(); i++) {
					String [] record = (String [])ref_form_arr.get(i);%>
					<option value="<%=record[0]%>" ><%=record[1]%></option>
				<%}%>
				</select>
				<label class='label' id='refusal_text'></label>	
			</td>
		</tr>
		<tr>
    		<td colspan='2' class='button'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='updateSentOut();'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'>
    		</td>
	    </tr>
		<Input name='order_category' id='order_category' type='hidden' value='<%=order_category%>'>
		<Input name='order_catalog_code' id='order_catalog_code' type='hidden' value='<%=order_catalog_code%>'>
		<Input name='order_type_code' id='order_type_code' type='hidden' value='<%=order_type_code%>'>
		<Input name='order_catalog_desc' id='order_catalog_desc' type='hidden' value='<%=order_catalog_desc%>'>
		<Input name='order_no' id='order_no' type='hidden' value='<%=order_id%>'>
		<Input name='order_id' id='order_id' type='hidden' value='<%=order_id%>'>
		<Input name='order_line_num' id='order_line_num' type='hidden' value='<%=order_line_num%>'>
		<Input name='encounter_id' id='encounter_id' type='hidden' value='<%=encounter_id%>'>
		<Input name='patient_id' id='patient_id' type='hidden' value='<%=patient_id%>'>
		<Input name='patient_class' id='patient_class' type='hidden' value='<%=patient_class%>'>
		<Input name='priority' id='priority' type='hidden' value='<%=priority%>'>
		<Input name='ref_form_id' id='ref_form_id' type='hidden' value=''>
		<Input name='sex' id='sex' type='hidden' value='<%=sex%>'>
		<Input name='source_type' id='source_type' type='hidden' value='<%=source_type%>'>
		<Input name='source_code' id='source_code' type='hidden' value='<%=source_code%>'>
		<Input name='performing_location_type' id='performing_location_type' type='hidden' value='<%=performing_location_type%>'>
		<Input name='performing_location' id='performing_location' type='hidden' value='<%=performing_location%>'>
		<Input name='performing_facility' id='performing_facility' type='hidden' value='<%=performing_facility%>'>
		<Input name='bean_id' id='bean_id' type='hidden' value='<%=bean_id%>'>
		<Input name='bean_name' id='bean_name' type='hidden' value='<%=bean_name%>'>
		<Input name='mode' id='mode' type='hidden' value='<%=mode%>'>
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<Input name='function_from' id='function_from' type='hidden' value='SENT_OUT'>

</table>

</FORM>
</body>
</html>

