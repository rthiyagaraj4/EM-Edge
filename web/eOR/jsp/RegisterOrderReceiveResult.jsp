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
<%@page  import="java.util.*, eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper " %>
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

	if (bean_id			== null) bean_id	= "";
	if (bean_name		== null) bean_name	= "";
%>
<html>
<head>

	<title><fmt:message key="eOR.ReceiveResult.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../../eOR/js/RegisterOrder.js"></script>
	<%if (bean_id.equals("Or_RegisterOrder")) {%>
 	<script language="JavaScript" src="../../eOR/js/RegisterOrder.js"></script>
 	<%} else {%>
 	<script language="JavaScript" src="../../eOR/js/ResultReporting.js"></script>
 	<%}%>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>


 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="register_order_receive_result" id="register_order_receive_result">
<%
	//String bean_id = "Or_RegisterOrder" ;
	//String bean_name = "eOR.RegisterOrder";
	
    String performing_facility  = request.getParameter("performing_facility");
    String performing_location_type  = request.getParameter("performing_location_type");
	String performing_location  = request.getParameter("performing_location");
	String order_id  = request.getParameter("orderId");
	String order_line_num  = request.getParameter("order_line_num");
	String order_category  = request.getParameter("order_category");
	String patient_id = request.getParameter("patient_id");
	String sex = request.getParameter("sex");
	String dob = request.getParameter("dob");
	String encounter_id = request.getParameter("encounter_id");

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
	//ring facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	String mode 					= "2";
	String order_catalog_code 		= "";
	String practitioner_name		= "";
	//ring referred_date            = "";
	//ring sent_out_practitioner    = "";
	ArrayList sys_date_arr			= new ArrayList();
	String sys_date_time            = "";
	ArrayList referred_details		= new ArrayList();
	String [] record				= {"","","","","",""};
	//String ref_facility_id			= "";
    String ref_date_time			= "";
//    String ref_sent_pract_id		= "";
    String ref_facility_name		= "";
    String ref_practitioner_name	= "";
    String ord_date_time			= "";

	

	if (bean_id.equals("Or_RegisterOrder")) 
	{
		RegisterOrder bean 	= (RegisterOrder)getBeanObject( bean_id,  bean_name ,request ) ;
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		order_catalog_code 		= bean.getOrderCatalogCode(order_id,order_line_num);
		practitioner_name		= bean.getPractitionerName(practitioner_id);
		sys_date_arr			= bean.getSysDateTime();
		if (sys_date_arr != null && sys_date_arr.size() > 0) {
			sys_date_time		= (String)sys_date_arr.get(3);
		}
		referred_details		= bean.getReferredDetails(order_id,order_line_num);

		putObjectInBean(bean_id,bean,request);
	} 
	else
	{
		ResultReportingBean bean 	= (ResultReportingBean)getBeanObject( bean_id, bean_name ,request);
		bean.setLanguageId(localeName);
		bean.setMode(mode);
		order_catalog_code 		= bean.getOrderCatalogCode(order_id,order_line_num);
		practitioner_name		= bean.getPractitionerName(practitioner_id);
		sys_date_arr			= bean.getSysDateTime();
		if (sys_date_arr != null && sys_date_arr.size() > 0)
		{
			sys_date_time		= (String)sys_date_arr.get(3);
		}
		referred_details		= bean.getReferredDetails(order_id,order_line_num);
		putObjectInBean(bean_id,bean,request);
	}

	String sql_or_user_for_review_practitioner_lookup = OrRepositoryExt.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRACTITIONER_LOOKUP");

    if (referred_details != null && referred_details.size() > 0) 
	{
		record				= (String[])referred_details.get(0);
	}

    if ((record != null) && (record.length == 6)) 
	{
  //  	ref_facility_id				= record[0];
    	ref_date_time				= record[1];
  //  	ref_sent_pract_id			= record[2];
    	ref_facility_name			= record[3];
    	ref_practitioner_name		= record[4];
    	ord_date_time				= record[5];
    }
	if( ref_date_time==null|| ref_date_time.equals("null") || ref_date_time.equals(" ")) ref_date_time="";
	if(ord_date_time==null|| ord_date_time.equals("null") || ord_date_time.equals(" ")) ord_date_time="";
	if(sys_date_time==null || sys_date_time.equals("null") || sys_date_time.equals(" ")) sys_date_time="";
	if(!localeName.equals("en"))
	{
		ref_date_time = com.ehis.util.DateUtils.convertDate(ref_date_time,"DMYHM","en",localeName);
		ord_date_time=com.ehis.util.DateUtils.convertDate(ord_date_time,"DMYHM","en",localeName);
		sys_date_time=com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",localeName);
	}
%>
	<table cellpadding=3 cellspacing=0 border='0' align='center' width='100%' height='100%'>
	<%--<Script>alert('<%=order_catalog_code%>')</Script>--%>
	    <TR><TD class='label' colspan='2'></TD></TR>
	    <TR>
			<TD class='label' width='40%'><fmt:message key="eOR.ReportingPractitioner.label" bundle="${or_labels}"/></TD>
			<TD class='label' width='60%'><Input name='ref_report_pract_id' id='ref_report_pract_id' type='text' value=''  maxlength='30' size='30' onBlur='makeValidString(this);'><img src="../../eCommon/images/mandatory.gif" align=center/></TD>
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
    	<TR>
			<TD class='label' width='40%'><fmt:message key="eOR.ReportingDate.label" bundle="${or_labels}"/></TD>
			<TD class='label' width='60%'><input type="text" name="ref_report_date_time" id="ref_report_date_time"  size="16" maxlength="16" value="<%=sys_date_time%>" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('ref_report_date_time',null,'hh:mm');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center/></TD>
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
		<TR>
			<TD class='label' width='40%'><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></TD>
			<TD class='label' width='60%'><B><%=ref_facility_name%></B></TD>
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
		<TR>
			<TD class='label' width='40%'><fmt:message key="eOR.DateofReferral.label" bundle="${or_labels}"/></TD>
			<TD class='label' width='60%'><B><%=ref_date_time%></B></TD>
		</TR>
		<TR><TD colspan='2'></TD></TR>
		<TR>
			<TD class='label' width='40%'><fmt:message key="Common.ReferredPractitioner.label" bundle="${common_labels}"/></TD>
			<TD class='label' width='60%'><B><%=ref_practitioner_name%></B></TD>
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
	    <TR>
			<TD class='label' width='40%'><fmt:message key="eOR.ReceivingPractitioner.label" bundle="${or_labels}"/></TD>
			<TD class='fields' width='60%'><Input name='practitioner' id='practitioner' type='text' value='<%=practitioner_name%>' nowrap  size="15" onBlur="practitioner_display(practitioner);"><input class='button' type=button name=search value='?'  class=button tabIndex="5" onClick="practitioner_display(practitioner)"><input type='hidden' name='ref_recieved_pract_id' id='ref_recieved_pract_id' value='<%=practitioner_id%>'><img src="../../eCommon/images/mandatory.gif" align=center></TD> <!-- onBlur="onblur_pract_disp(this)" -->
		</TR>
		<TR><TD class='label' colspan='2'></TD></TR>
    	<TR>
			<TD class='label' width='40%'><fmt:message key="eOR.DateofReceipt.label" bundle="${or_labels}"/></TD>
			<TD class='label' width='60%'><input type="text" name="ref_recieved_date_time" id="ref_recieved_date_time"  size="16" maxlength="16" value="<%=sys_date_time%>" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('ref_recieved_date_time',null,'hh:mm');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center/></TD>
		</TR>
		<TR><TD colspan='2'></TD></TR>
		<tr>
			<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td><TEXTAREA NAME="ref_recieved_remarks" ROWS="3" COLS="25" onkeyPress='checkMaxLimit(this,500)'  onBlur="return makeValidString(this);"></TEXTAREA></td>   <%--<img src="../../eCommon/images/mandatory.gif" align=center/>--%>
		</tr>
		<TR><TD colspan='2'></TD></TR>
		<tr>
    		<td  colspan='2' class='button'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='updateReceiveResult();'>
    		<INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'>
    		</td>
	    </tr>
		<Input name='order_category' id='order_category' type='hidden' value='<%=order_category%>'>
		<Input name='order_catalog_code' id='order_catalog_code' type='hidden' value='<%=order_catalog_code%>'>
		<Input name='order_no' id='order_no' type='hidden' value='<%=order_id%>'>
		<Input name='order_id' id='order_id' type='hidden' value='<%=order_id%>'>
		<Input name='encounter_id' id='encounter_id' type='hidden' value='<%=encounter_id%>'>
		<Input name='patient_id' id='patient_id' type='hidden' value='<%=patient_id%>'>
		<Input name='sex' id='sex' type='hidden' value='<%=sex%>'>
		<Input name='dob' id='dob' type='hidden' value='<%=dob%>'>
		<Input name='order_line_num' id='order_line_num' type='hidden' value='<%=order_line_num%>'>
		<Input name='ord_date_time' id='ord_date_time' type='hidden' value='<%=ord_date_time%>'>
		<Input name='sys_date_time' id='sys_date_time' type='hidden' value='<%=sys_date_time%>'>
		<Input name='qry_string' id='qry_string' type='hidden' value='<%=request.getQueryString()%>'>
		<Input name='bean_id' id='bean_id' type='hidden' value='<%=bean_id%>'>
		<Input name='bean_name' id='bean_name' type='hidden' value='<%=bean_name%>'>
		<Input name='mode' id='mode' type='hidden' value='<%=mode%>'>
		<Input name='function_from' id='function_from' type='hidden' value='RECEIVE_RESULT'>
        <input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=sql_or_user_for_review_practitioner_lookup%>">
		<Input name="localeName" id="localeName" type='hidden' value="<%=localeName%>">

</table>

</FORM>
</body>
</html>

