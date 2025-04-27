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
<%@page  import="java.util.*, webbeans.eCommon.ConnectionManager,eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/RegisterOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
  	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onLoad="populateLocnOrdType('order_category');populateLocnOrdType('ord_type');" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

 
	
 	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";
   // String isLabInstalled_yn = "";
	//String isRDInstalled_yn = "",isOTInstalled_yn = "";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	
/* Mandatory checks end */

	/* Initialize Function specific start */
	RegisterOrder bean = (RegisterOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	int patient_id_length = bean.getPatientIdLength();
	
	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	try{
		ArrayList sysdate = (ArrayList)bean.getSysDateTime();
		for(int i=0;i<sysdate.size();i++){
	
			last_week_date =  (String)sysdate.get(0);
			curr_week_date =  (String)sysdate.get(1);
			curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	
		}
	} catch (Exception e) {
		//out.println("<script>alert('here:"+e.getMessage()+"')</script>");//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	/*Thai date validations 15/02/2007 start */
	if(last_week_date.equals("null") || (last_week_date.equals(" "))) last_week_date="";
	if(curr_week_date.equals("null") || (curr_week_date.equals(" "))) curr_week_date="";
	if(curr_sys_date.equals("null") || (curr_sys_date.equals(" "))) curr_sys_date="";
	if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_week_date = com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY","en",localeName);
	curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
	}

/* Initialize Function specific end */
 String  temp_curr_week_date=curr_week_date;
String temp_last_week_date=last_week_date;

%>

<form name='register_order_search' id='register_order_search' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td class=label><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<TD class=fields><Select name="ord_cat" id="ord_cat" onChange="populateLocnOrdType('ord_type');"><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></Select><input type=hidden name='order_category' id='order_category' value=''></TD>
		<%--<td><input type=text name='order_category_disp' id='order_category_disp' value='<%=order_category[1]%>'><input type=hidden name='order_category' id='order_category' value='<%=order_category[0]%>'></td>--%>
		<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
        <TD class=fields><select name=order_type onChange="clearactivityvalues();"><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></Select><input type=hidden name='single_multi' id='single_multi' value='M'></TD>
		<td colspan=4></td>
		</tr>
	
	<tr>
		<td class='label'><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class='fields'><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur='populateActivitySearch(activity_type_desc,activity_type);'  maxlength='' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type);"></td>
		</td>
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="location_type" id="location_type" onChange='clearvalues()'>
				<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
			</SELECT><input type='text' name='locn_code' id='locn_code' value="" onBlur='populateMvLoaction(locn_code,locn)'  size="10" maxlength='' disabled><input type=button id='location_lookup' name=search value='?'  class=button onClick="populateMoveLoaction(locn_code,locn)" disabled><input type="hidden" name="locn" id="locn" value="">
		</td><td class='label' colspan=2></td>
	</tr><tr>
	<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class=fields><input type="text" name="date_from" id="date_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'><font size="4">-</font><input type=text name='date_to' id='date_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'register_order_search')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'></td>
	<td class='label'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="priority" id="priority">
				<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td colspan=4></td>
	</tr>
<tr>
		<td class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class=fields><input type='text' width='16%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td class=label><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class=fields><input type=text name='encntr_id' id='encntr_id' value='' maxlength=12 onKeyPress='return OrAllowPositiveNumber()'  onBlur='OrCheckPositiveNumber(this)'></td><td colspan=4></td></tr>

	<tr>
		<td class=label><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=fields><input type=text name='order_no' id='order_no' value='' maxlength=15  onBlur='ChangeUpperCase(this)' ></td>
	<td id='int_or_ext_lbl_show' class='label'><fmt:message key="eOR.TaskStatus.label" bundle="${or_labels}"/></td>
	<td class=fields id='int_or_ext_show'><select name='int_or_ext' id='int_or_ext'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></option><option value='R'><fmt:message key="eOR.AcknolwedgetheResults.label" bundle="${or_labels}"/></option></select></td><td class='label' colspan=2></td>
	</tr>
	<tr>
	<td class='label'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td><td><input type='hidden' name='performing_location_code' id='performing_location_code' value=""><input type='text' width='16%' name='performing_type_desc' id='performing_type_desc' value="" onBlur='populateperformingSearch(performing_type_desc,performing_location_code);'  maxlength='' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callperformingSearch(performing_type_desc,performing_location_code);">
	</td>
	<td id='specimen_no_lbl_show' name='specimen_no_lbl_show' class=label></td>
	<td id='specimen_no_show' name='specimen_no_show'></td><input type=hidden name='view_by' id='view_by' value = "H"><td colspan=4></td>
	</tr>
	
	 <tr>
	 <%--<td><%
			if(orderType.size() == 1){
				String[] ord_type = new String[2];
				ord_type = (String[])orderType.get(0);
		%>

				<input type=text name='order_type_disp' id='order_type_disp' value='<%=ord_type[1]%>'>
				<input type=hidden name='order_type' id='order_type' value='<%=ord_type[0]%>'>
				<input type=hidden name='single_multi' id='single_multi' value='S'>
		<%
			}else{
				out.println("<input type=hidden name='single_multi' id='single_multi' value='M'>");
				out.println("<select name=order_type><option value=''><fmt:message key='Common.all.label" bundle='${common_labels}'/></option>");
				for(int i=0; i<orderType.size(); i++){
					String[] ord_type = new String[2];
					ord_type = (String[])orderType.get(i);
		%>
				<option value='<%=ord_type[0]%>'><%=ord_type[1]%></option>
		<%		}
				out.println("</select>");
			}
			%>
		</td>--%>
	<td class='label' colspan=2></td>
    <td ></td><td class='button' align='right'><input type=button class=button name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='populateValues()'><input type=button name='clear_btn' id='clear_btn' class=button value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td><td colspan=4></td>
	</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<Input type="hidden" name="isRDInstalled_yn" id="isRDInstalled_yn" value="">

<Input type="hidden" name="isOTInstalled_yn" id="isOTInstalled_yn" value="">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<input type="hidden" name="cat_value" id="cat_value" value="">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">

<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="referral_sql" id="referral_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_R")%>">
<input type="hidden" name="performing_sql" id="performing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_OTH")%>">


<%
	putObjectInBean(bean_id,bean,request);

%>
</form>

</body>
</html>

