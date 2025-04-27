<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/10/2017  IN061908	Krishna Gowtham	J	04/10/2017		Ramesh G		ML-MMOH-CRF-0560
16/10/2017  IN065433	Krishna Gowtham J 	16/10/2017		Ramesh G		OR-ML-MMOH-CRF-0560/01-Result Reporting
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,java.sql.*,eOR.*,webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
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
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ResultReporting.js"></script>
<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	
	/* Mandatory checks start */
	String mode				= request.getParameter( "mode" ) ;
	String function_id		= request.getParameter( "function_id" ) ;
	String bean_id			= "Or_ResultReporting" ;
	String bean_name		= "eOR.ResultReportingBean";
	String bean_id1			= "Or_PatientValidate";
	String bean_name1		= "eOR.PatientValidate";
	String practitioner_id	= (String)session.getValue("ca_practitioner_id");	
	String facility_id		= (String)session.getValue("facility_id");	
	String resp_id			= (String)session.getValue("responsibility_id");
	String practitioner_type= (String)session.getValue("practitioner_type");
	String option_id		= request.getParameter("option_id");
	String called_from		= request.getParameter("called_from");
	if(called_from==null) called_from= "";
	if(option_id == null){option_id = "";}
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String pract_reln_id		= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String from_ca = "";
	if (from_ca == null) from_ca = "";
	//When it comes after clikling the cancel button  in the reult Entry
	String performed_only = request.getParameter("performed_only")==null?"N":request.getParameter("performed_only");	
	String CancelFlag			= request.getParameter("CanelFlag");
	String can_location_type	= request.getParameter("can_location_type");
	String can_location			= request.getParameter("can_location");
	String can_order_category	= request.getParameter("can_order_category");
	String can_single_multi		= request.getParameter("can_single_multi");
	String can_priority			= request.getParameter("can_priority");
	String can_date_from		= request.getParameter("can_date_from");
	String can_date_to			= request.getParameter("can_date_to");
	String can_patient_id		= request.getParameter("can_patient_id");
	String can_order_id			= request.getParameter("can_order_id");
	String can_encounter_id		= request.getParameter("can_encounter_id");
	String can_patient_id_found	= request.getParameter("can_patient_id_found");
	String can_order_type		= request.getParameter("can_order_type");
	String can_performing_location_code = request.getParameter("can_performing_location_code");
	String can_catalog_desc				= request.getParameter("can_catalog_desc");
	String can_search_criteria			= request.getParameter("can_search_criteria");
	String can_task_status				= request.getParameter("can_task_status");
	String can_source_location_type		= request.getParameter("can_source_location_type");
	String can_source_locn 				= request.getParameter("can_source_locn");
	String can_group_by 				= request.getParameter("can_group_by");
//IN065433 starts
	String load_search 				= request.getParameter("load_search");
	load_search						= (load_search == null) ? "Y" : load_search;
//IN065433 end
	can_catalog_desc 		= (can_catalog_desc == null) ? "" : can_catalog_desc;
	can_search_criteria 		= (can_search_criteria == null) ? "" : can_search_criteria;
	can_source_location_type 		= (can_source_location_type == null) ? "" : can_source_location_type;
	can_source_locn 		= (can_source_locn == null) ? "" : can_source_locn;
	can_group_by 		= (can_location_type == null) ? "" : can_group_by;
	can_task_status 		= (can_task_status == null) ? "" : can_task_status;
	CancelFlag					= (CancelFlag == null) ? "" : CancelFlag;
	can_location_type 		= (can_location_type == null) ? "" : can_location_type;
	can_location 			= (can_location == null) ? "" : can_location;
	can_order_category 		= (can_order_category == null) ? "" : can_order_category;
	can_single_multi 		= (can_single_multi == null) ? "" : can_single_multi;
	can_priority 			= (can_priority == null) ? "" : can_priority;
	can_date_from 			= (can_date_from == null) ? "" : can_date_from;
	can_date_to 			= (can_date_to == null) ? "" : can_date_to;
	can_patient_id 			= (can_patient_id == null) ? "" : can_patient_id;
	can_order_id 			= (can_order_id == null) ? "" : can_order_id;
	can_encounter_id 		= (can_encounter_id == null) ? "" : can_encounter_id;
	can_patient_id_found 	= (can_patient_id_found == null) ? "" : can_patient_id_found;
	can_order_type 			= (can_order_type == null) ? "" : can_order_type;
	can_performing_location_code = (can_performing_location_code == null) ? "" : can_performing_location_code;
	boolean pract_type_is_NS = false;
	if(resp_id== null)resp_id = "";
	if(practitioner_type == null)
		practitioner_type = "";
	String checked="";
	if(performed_only.equals("Y"))
		   checked = "checked";
/* Mandatory checks end */
// Added By Arvind for PMG20089-CRF-0804
	String period_mod_rslt_completed = "0";
	String by_24hrs_yn="N";
//End 
%>

<%
if (from_ca.equals("Y")) {%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="populateLocnOrdType('location_type','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');defaultOrderCategory();resubmit();">
<%} else {%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="populateLocnOrdType('location_type','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');defaultOrderCategory();resubmit();">
<%}

/* Initialize Function specific start */
ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id,bean_name , request ) ;
bean.setFunctionId(bean.checkForNull(function_id));
bean.clear() ;
bean.setMode( mode ) ;
bean.setLanguageId(localeName);
int patient_id_length = bean.getPatientIdLength();

String curr_sys_date = "";
String last_week_date  = "";
try{
ArrayList sysdate = (ArrayList)bean.getSysDateTime();
for(int i=0;i<sysdate.size();i++){
last_week_date =  (String)sysdate.get(0);
curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
}
} catch (Exception e) {
		out.println("<script>alert('here:"+e.getMessage()+"')</script>");
	}
	/*Thai date validations 17/02/2007 start */
	if(last_week_date.equals("null") || (last_week_date.equals(" "))) last_week_date="";
	if(curr_sys_date.equals("null") || (curr_sys_date.equals(" "))) curr_sys_date="";
	if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
	}
	/*Thai date validations 17/02/2007 end */

String  temp_curr_sys_date=curr_sys_date;
String temp_last_week_date=last_week_date;
	ArrayList location=new ArrayList();
try{
	if(pract_type_is_NS)
	location = bean.getLocation(facility_id, practitioner_id, "");
	ArrayList<String> arrList = bean.getORParamVals();
	if(arrList != null && arrList.size()>0)
	{
		/*	if (arrList.get(1).equals("Y"))		
				period_mod_rslt_completed =  com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMYHM",localeName,Integer.parseInt(arrList.get(0)),"d");
			else*/
				period_mod_rslt_completed = arrList.get(0)==null?"0":arrList.get(0); //com.ehis.util.DateUtils.minusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", localeName),"DMY",localeName,Integer.parseInt(arrList.get(0)),"d");
				by_24hrs_yn = arrList.get(1)==null?"N":arrList.get(1); //com.ehis.util.DateUtils.minusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", localeName),"DMY",localeName,Integer.parseInt(arrList.get(0)),"d");
	

	}
	}catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();
	}


/* Initialize Function specific end */
%>

<form name='result_reporting_search' id='result_reporting_search' target='messageFrame'>
<table cellpadding=3 cellspacing=0 border=0 width="100%"  align=center>
	<tr>
	<input type=hidden name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
	<%
if (pract_type_is_NS)
{%>
		<td width="25%"><SELECT name='location_type' id='location_type' onChange='populateLocation(this)'>
				<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='W'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		</td>
		<td width="25%" class=label id='id_locn' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td><SELECT name="locn" id="locn">
					<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
				for(int i=0; i<location.size(); i++){
					String[] location_i = new String[2];
					location_i = (String[])location.get(i);
		%>
				<option value='<%=location_i[0]%>'><%=location_i[1]%></option>
		<%}%>
		</select>
		<!--<input type=hidden name='order_category' id='order_category' value='NC'>-->
		</td>
<%}%>		
<td colspan=4></td>
		<input type='hidden' name='location_type' id='location_type' value='Departmental Service' >
	</tr>
<%
if (pract_type_is_NS)
{%>	<tr>
		<td class=label width="25%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><SELECT name="priority" id="priority" >
				<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
			<input type=hidden name='single_multi' id='single_multi' value='S'>
		</td>
		<td class=label></td>
		<td class=fields></td></tr>
<%} else{%>
	<tr>
	<td class=label id='id_locn' width="25%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<TD class=fields width="25%"><Select name="locn" id="locn" onChange="populateLocnOrdType('locn','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');"><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></Select>
	<input type=hidden name='order_category' id='order_category' value=''>
	</TD>
	<td class=label width="25%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<TD class=fields width="25%"><select name=order_type id=order_type onChange='clearActivityTypeList("document")'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></Select><input type=hidden name='single_multi' id='single_multi' value='M'></TD></tr>

<%}

if(CancelFlag.trim().equalsIgnoreCase("Y"))	 {
	if(!option_id.trim().equalsIgnoreCase("TASK_ORDER_REPORT1")){
	patient_id="" ;
	encounter_id="";
		}
}
%>

<tr>
		<td class='label' width="25%"><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class='fields' width="25%"><input type="text" name="activity_type_desc" id="activity_type_desc" value="" onblur='callActivitySearch1(activity_type_desc,activity_type);'><input type=button name=ActSearch value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type);"><input type="hidden" name="activity_type" id="activity_type" value=""></td>
		<TD class=label width="25%"><fmt:message key="Common.source.label" bundle="${common_labels}"/></TD>
		<td class=fields width="25%"><SELECT name="source_location_type" id="source_location_type" onChange='populateSourceLocation(this)'>
			<option value='' <%=eHISFormatter.select("" ,can_source_location_type)%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='C' <%=eHISFormatter.select("C" ,can_source_location_type)%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value='N' <%=eHISFormatter.select("N" ,can_source_location_type)%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value='R' <%=eHISFormatter.select("R" ,can_source_location_type)%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
		</SELECT><input type="text" value='' name="source_locn_desc" id="source_locn_desc" onblur='populateMoveLoaction1(source_locn_desc,source_locn);'><input type=button name=SourceSearch id=SourceSearch value='?'  class=button tabIndex="4" onClick="populateMoveLoaction(source_locn_desc,source_locn);" disabled><input type="hidden" name="source_locn" id="source_locn" value="">
		</td></tr>
		
		<tr>
		<td class='label' width="25%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<%if (from_ca.equals("Y")) {%>
		<td class=fields width="25%"><input type="text" name="date_from" id="date_from" value="" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()' style="width:70px"><img src="../../eCommon/images/CommonCalendar.gif"  id="fromCal" align=center onclick="return showCalendar('date_from');" style='cursor:pointer'><%} else {%><td class=fields width="25%"><input type="text" name="date_from" id="date_from" value="<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_from:last_week_date%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()' style="width:70px"><img src="../../eCommon/images/CommonCalendar.gif" id="fromCal" onclick="return showCalendar('date_from');" style='cursor:pointer'><font size="4">-</font><%}%><input type=text name='date_to' id='date_to' value='<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_to:last_week_date%>' size="10" maxlength="10" onBlur="checkDateRange(this,'result_reporting_search')" onKeyPress='return OrAllowDateFormat()' style="width:70px"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" id="toCal" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></td>
		
		<td class='label' width="25%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><SELECT name="priority" id="priority">
				<option value='' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='R' ><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S' ><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U' ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
			<Script>document.getElementById("priority").value='<%=can_priority%>'</Script>
		</td></tr>

<%if(patient_id.equals(""))
{
		patient_id="";
		encounter_id="";
	%>
		<tr><td class=label width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type='text' width='16%' name='patient_id' id='patient_id' value='<%=can_patient_id%>'  onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  maxlength='<%=patient_id_length%>' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
		<td class=label width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class=fieldswidth="25%"><input type=text name='encounter_id' id='encounter_id' value='<%=can_encounter_id%>' onBlur="OrCheckNumber1(this)" maxlength=12 onKeyPress='return OrAllowPositiveNumber()' colspan=3><input type='hidden' name='patient_id_found' id='patient_id_found' value='no'></td>
		</tr>
		<tr>
		<td class=label width="25%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type=text name='order_id' id='order_id' value='<%=can_order_id%>' maxlength=15 onBlur='ChangeUpperCase(this);'></td>
		<td class=label width="25%"><%if(called_from==null || !called_from.equals("Coding")) { %><fmt:message key="eOR.TaskStatus.label" bundle="${or_labels}"/><% }  else {%> <fmt:message key="Common.Task.label" bundle="${common_labels}"/> <% } %></td>
		<td class=fields id='task_status_show' width="25%"><SELECT name="task_status" id="task_status" onChange='taskValue(this);'>
		<option value='Z' <%=eHISFormatter.select("Z" ,can_task_status)%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(called_from==null || !called_from.equals("Coding")) { %> 
		<option value='X' <%=eHISFormatter.select("X" ,can_task_status)%>><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></option>
		<option value='R' <%=eHISFormatter.select("R" ,can_task_status)%>><fmt:message key="eOR.AcknolwedgetheResults.label" bundle="${or_labels}"/></option>
<%	} else { %> <!-- if it is coming from coding -->
		<option value='C' <%=eHISFormatter.select("C" ,can_task_status)%>><fmt:message key="eOR.Coded.label" bundle="${or_labels}"/></option>
		<option value='U' <%=eHISFormatter.select("U" ,can_task_status)%>><fmt:message key="eOR.Uncoded.label" bundle="${or_labels}"/></option>
<% } %>
		</SELECT><input type='hidden' name='taskCode' id='taskCode' value=''></td>
		</tr>
		<TR>
		<%if(patient_id.equals("")){%>
		<td class=label width="25%"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type=text name='catalog' id='catalog' value='<%=can_catalog_desc %>' size="16" maxlength="40" ><SELECT name="search_criteria" id="search_criteria">
				<option value='S' <%=eHISFormatter.select("S" ,can_search_criteria)%>><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C' <%=eHISFormatter.select("C" ,can_search_criteria)%>><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E' <%=eHISFormatter.select("E" ,can_search_criteria)%>><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td> 
			 <%}else{%>
			<td class=label width="25%"></td>
			 <%}%>
 		<td class=label width="25%"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		 <td class=fields width="25%"><SELECT name="group_by" id="group_by">
            <option value="D" <%=eHISFormatter.select("D" ,can_group_by)%>><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
            <option value="P" <%=eHISFormatter.select("P" ,can_group_by)%>><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
        	<option value="C" <%=eHISFormatter.select("C" ,can_group_by)%>><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
        	<option value="T" <%=eHISFormatter.select("T" ,can_group_by)%>><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
        	<option value="L" <%=eHISFormatter.select("L" ,can_group_by)%>><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
        	<option value="U" <%=eHISFormatter.select("U" ,can_group_by)%>><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option>
        	<option value="O" <%=eHISFormatter.select("O" ,can_group_by)%>><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option>
		</SELECT></td>
		</TR>
     <tr>
		<td class='label' width="25%"><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td><td><input type='hidden' name='performing_location_code' id='performing_location_code' value=""><input type='text' width='16%' name='performing_type_desc' id='performing_type_desc' value="" onBlur='populateperformingSearch(performing_type_desc,performing_location_code);'  maxlength='<%=patient_id_length%>' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callperformingSearch(performing_type_desc,performing_location_code);">
		<!-- Start  -->
		
		<td colspan="2" class='label'><input type='checkbox' name='performed_only' id='performed_only' value="" <%=checked%> ><fmt:message key="eOR.PerformedOnly.label" bundle="${or_labels}"/></td>
		
		<!-- end  -->
		</td>
		<td id='specimen_no_lbl_show' class='label'></td>
		<td id='specimen_no_show' colspan=4></td>
		 <Input name='view_by' id='view_by' type='hidden' value='H'>
		</tr>
	<tr align="right">
	<td class='label' width="25%"></td>
	<td class='label'width="25%"></td>
	<td width="25%"></td>
	<td class='button' colspan=4><input type=button class='button' name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td></tr>
	<%
	} else {%>
	<tr>
		<td class=label width="25%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type=text name='order_id' id='order_id' value='<%=can_order_id%>' maxlength=15 onBlur='ChangeUpperCase(this);'></td>
		<td class=label width="25%"><%if(called_from==null || !called_from.equals("Coding")) { %><fmt:message key="eOR.TaskStatus.label" bundle="${or_labels}"/> <% }  else {%> <fmt:message key="Common.Task.label" bundle="${common_labels}"/> <% } %></td>
		<td id='task_status_show' class='fields'width="25%"><SELECT name="task_status" id="task_status" onChange='taskValue(this)'>
		<option value='Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%if(called_from==null || !called_from.equals("Coding")) { %> 
		<option value='X'><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></option>
		<option value='R'><fmt:message key="eOR.AcknolwedgetheResults.label" bundle="${or_labels}"/></option>
<%	} else { %> <!-- if it is coming from coding -->
		<option value='C'><fmt:message key="eOR.Coded.label" bundle="${or_labels}"/></option>
		<option value='U'><fmt:message key="eOR.Uncoded.label" bundle="${or_labels}"/></option>
<% } %>
		</SELECT><input type='hidden' name='taskCode' id='taskCode' value=''></td></tr>
		<tr>
		<td class=label width="25%"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type=text name='catalog' id='catalog' value='' size="20" maxlength="40" ><SELECT name="search_criteria" id="search_criteria">
				<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		 <td class=label width="25%"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><SELECT name="group_by" id="group_by">
            <option value="P"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
        	<option value="C"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/> </option>
        	<option value="T"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </option>
        	<option value="L"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
        	<option value="D"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
        	<option value="U"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option>
        	<option value="O"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option>
		</SELECT></td>
		 </tr>
		<tr>
		<td class='label' width="25%"><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td><td><input type='hidden' name='performing_location_code' id='performing_location_code' value=""><input type='text' width='16%' name='performing_type_desc' id='performing_type_desc' value="" onBlur='populateperformingSearch(performing_type_desc,performing_location_code);'  maxlength='<%=patient_id_length%>' ><input type=button name=search id=search value='?'  class=button tabIndex="4" onClick="callperformingSearch(performing_type_desc,performing_location_code);">
		</td>
		<!-- Start  -->
		
		<td colspan="2" class='label'><input type='checkbox' name='performed_only' id='performed_only' value="" <%=checked%> ><fmt:message key="eOR.PerformedOnly.label" bundle="${or_labels}"/></td>
		<!-- end  -->
		<td id='specimen_no_lbl_show' class='label'></td>
		<td id='specimen_no_show' colspan=4></td>
        <Input name='view_by' id='view_by' type='hidden' value='H'>
		<tr>
		<%if(patient_id.equals("")){%>
		<td class=label width="25%"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td class=fields width="25%"><input type=text name='catalog' id='catalog' value='<%=can_catalog_desc %>' size="16" maxlength="40" ><SELECT name="search_criteria" id="search_criteria">
				<option value='S' <%=eHISFormatter.select("S" ,can_search_criteria)%>><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C' <%=eHISFormatter.select("C" ,can_search_criteria)%>><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E' <%=eHISFormatter.select("E" ,can_search_criteria)%>><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td> 
			 <%}else{%>
			<td class=label width="25%"></td>
			<td class=label width="25%"></td>
			<td colspan=3></td>
			 <%}%>
		<td class='button' colspan=4><input type=button class='button' name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td></tr>
		
		<input type='hidden' name='patient_id_found' id='patient_id_found' value='yes'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%= patient_id %>'>
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		
	<%
	} %>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<Input type="hidden" name="isRDInstalled_yn" id="isRDInstalled_yn" value="">

<Input type="hidden" name="isOTInstalled_yn" id="isOTInstalled_yn" value="">
<Input type="hidden" name="bean_id1" id="bean_id1" value="<%=bean_id1%>">
<Input type="hidden" name="bean_name1" id="bean_name1" value="<%=bean_name1%>">
<Input type="hidden" name="CancelFlag" id="CancelFlag" value="<%=CancelFlag%>">
<Input type="hidden" name="from_ca" id="from_ca" value="<%=from_ca%>">
<Input type="hidden" name='default_order_category' id='default_order_category' value=''>
<Input type="hidden" name='called_from' id='called_from' value="<%=called_from%>">
<Input type="hidden" name='can_source_locn' id='can_source_locn' value="<%=can_source_locn%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<input type="hidden" name="temp_patientid" id="temp_patientid" value="<%=can_patient_id %>">
<input type="hidden" name="temp_orderid" id="temp_orderid" value="<%=can_order_id %>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="pract_reln_id" id="pract_reln_id" value="<%=pract_reln_id%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="referral_sql" id="referral_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_R")%>">
<input type="hidden" name="performing_sql" id="performing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_PERFORM_LOCN_OTH")%>">
<input type="hidden" name="period_mod_rslt_completed" id="period_mod_rslt_completed" value="<%=period_mod_rslt_completed%>">
<input type="hidden" name="by_24hrs_yn" id="by_24hrs_yn" value="<%=by_24hrs_yn%>">
<!--IN061908 Start-->
<%if("Y".equals(load_search)){%> <!--IN065433 start-->
<script>
	populateValues();
</script>
<%}%> <!--IN065433 end-->
<!--IN061908 End-->
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

