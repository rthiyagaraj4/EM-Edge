<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*, webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ResultReporting.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultReporting" ;
	String bean_name = "eOR.ResultReportingBean";

	String bean_id1 = "Or_PatientValidate";
	String bean_name1 = "eOR.PatientValidate";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String option_id			= request.getParameter("option_id");

	String isLabInstalled_yn = "",isRDInstalled_yn = "";

	if(option_id == null){option_id = "";}

	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");

	//String from_ca = request.getParameter("CA");
	String from_ca = "";

	if (from_ca == null) from_ca = "";

	patient_id = (patient_id == null) ? "" : patient_id;
	encounter_id = (encounter_id == null) ? "" : encounter_id;

	//When it comes after clikling the cancel button  in the reult Entry
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
	else
	{
		//if(practitioner_type.equals("NS"))
		//	pract_type_is_NS = true;
	}

/* Mandatory checks end */%>
<%if (from_ca.equals("Y")) {%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="populateLocnOrdType('location_type','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');populateLocnOrdType('locn','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');populateSourceLocation(document.result_reporting_search.source_location_type);defaultOrderCategory();resubmit();">
<%} else {%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="populateLocnOrdType('location_type','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');populateLocnOrdType('locn','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');populateSourceLocation(document.result_reporting_search.source_location_type);defaultOrderCategory();resubmit();">
<%}%>

<% 
	/* Initialize Function specific start */
	//ResultReportingBean bean = (ResultReportingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;

	int patient_id_length = bean.getPatientIdLength();

	//String curr_sys_date = bean.getSysDate();
	String curr_sys_date = "";
	//String curr_week_date  = "";
	String last_week_date  = "";
	try{
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		//curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
		//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
	}
	} catch (Exception e) {
		//out.println("<script>alert('here:"+e.getMessage()+"')</script>");//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	ArrayList location=new ArrayList();
	String[] order_category = new String[2];
	//ArrayList orderType = new ArrayList();
	try{
		//out.println("practitioner_id="+practitioner_id+", resp_id="+resp_id+", facility_id="+facility_id+"<br>");
		order_category	= bean.getOrdercategory(practitioner_id, resp_id);
		//out.println("order_category[0]="+order_category[0]+", order_category[1]="+order_category[1]);

		if(pract_type_is_NS)
			location = bean.getLocation(facility_id, practitioner_id, "");

	//	orderType = bean.getOrderType(order_category[0], practitioner_id, resp_id);
	}catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}


try{
	//String isLabInstalled_yn = "";
	//if(order_category[0].equals("LB")){
		isLabInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RL");
		/*if((isLabInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getOrMessage('LAB_MODULE_INSTALLED')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}

	//if(order_category[0].equals("RD")){
		isRDInstalled_yn = (String) bean.isModuleInstalled(facility_id,"RD");
		/*if((isRDInstalled_yn.trim()).equals("Y")){
			out.println("<script>alert(getOrMessage('RADIOLOGY_MODULE_INSTALLED')); document.location.href='../../eCommon/html/blank.html'</script>");
		}*/
	//}
}catch(Exception e){
}

/* Initialize Function specific end */
%>

<form name='result_reporting_search' id='result_reporting_search' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>
	<tr>
		<%--<td class=label align='right'>Location Type</td>--%>
		<input type=hidden name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
<%
if (pract_type_is_NS)
{%>
		<td>&nbsp;<SELECT name='location_type' id='location_type' onChange='populateLocation(this)'>
				<option value=''>All</option>
				<option value='C'>Clinic</option>
				<option value='W'>Nursing Unit</option>
		</td>
		<td class=label align='right' id='id_locn' >&nbsp;Location</td>
		<td>&nbsp;<SELECT name="locn" id="locn">
					<option value=''>All</option>
		<%
				for(int i=0; i<location.size(); i++){
					String[] location_i = new String[2];
					location_i = (String[])location.get(i);
		%>
				<option value='<%=location_i[0]%>'><%=location_i[1]%></option>
		<%}%>
		</select>
		<input type=hidden name='order_category' id='order_category' value='NC'>
		</td>
<%}else{%>
		<%--<td>&nbsp;<input type='text' name='location_type' id='location_type' value='Departmental Service' ></td>
		<td class=label align='right' id='id_locn' >&nbsp;Location</td>
		<TD>&nbsp;<Select name="locn" id="locn" onChange="populateLocnOrdType('locn','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');"><option value=''>&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;</option></Select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		<input type=hidden name='order_category' id='order_category' value=''>
		</TD>--%>
		<%--<Script>document.getElementById("locn").value='<%=can_order_category%>';alert(document.getElementById("locn").value)</Script>--%>
		<%--<td>&nbsp;<input type=text name='locn' id='locn' value='<%=order_category[1]%>'>
		<input type=hidden name='order_category' id='order_category' value='<%=order_category[0]%>'>
		</td>--%>
<%}%>
		<td colspan=6></td>
		<input type='hidden' name='location_type' id='location_type' value='Departmental Service' >
	</tr>
	<tr>
<%
if (pract_type_is_NS)
{%>
		<td class=label align='right'>Priority</td>
		<td>&nbsp;<SELECT name="priority" id="priority" >
				<option value=''>All</option>
				<option value='R'>Routine</option>
				<option value='S'>Stat</option>
				<option value='U'>Urgent</option>
			</SELECT>
			<input type=hidden name='single_multi' id='single_multi' value='S'>
		</td>
		<td class=label align='right'></td>
		<td>&nbsp;</td>
<%}else{%>
		<%--<Script>document.getElementById("order_type").value='<%=can_order_type%>';document.getElementById("single_multi").value='<%=can_single_multi%>'</Script>--%>
		<%--<td>&nbsp;<%
			if(orderType.size() == 1){
				String[] ord_type = new String[2];
				ord_type = (String[])orderType.get(0);
		%>
				<input type=text name='order_type_disp' id='order_type_disp' value='<%=ord_type[1]%>'>
				<input type=hidden name='order_type' id='order_type' value='<%=ord_type[0]%>'>
				<input type=hidden name='single_multi' id='single_multi' value='S'>
		<%
			}else{
				out.print("<input type=hidden name='single_multi' id='single_multi' value='M'>");
				out.print("<select name=order_type><option value=''>All</option>");
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
        <td class=label align='right' id='id_locn' >Order Category</td>
		<TD>&nbsp;<Select name="locn" id="locn" onChange="populateLocnOrdType('locn','<%=can_order_category%>','<%=can_order_type%>','<%=can_performing_location_code%>');"><option value=''>&nbsp;&nbsp;&nbsp;---All---&nbsp;&nbsp;&nbsp;</option></Select>&nbsp;<%--<img src="../../eCommon/images/mandatory.gif"></img>--%>
		<input type=hidden name='order_category' id='order_category' value=''>
		</TD>
		<td class=label align='right'>Order Type</td>
		<TD>&nbsp;<select name=order_type><option value=''>All&nbsp;&nbsp;&nbsp;&nbsp;</option></Select><input type=hidden name='single_multi' id='single_multi' value='M'></TD>
		<td id='performing_locn_lbl_show' class='label' align='right' nowrap>&nbsp;</td>
		<td id='performing_locn_show' align='left'>&nbsp;</td>

<%}%>
		<%--<td > &nbsp;</td>
		<td>&nbsp;</td>--%>
	</tr>

	<tr>
		<td class=label align='right'>Priority</td>
		<td>&nbsp;<SELECT name="priority" id="priority">
				<option value='' >All</option>
				<option value='R' >Routine</option>
				<option value='S' >Stat</option>
				<option value='U' >Urgent</option>
			</SELECT>
			<Script>document.getElementById("priority").value='<%=can_priority%>'</Script>
		</td>
		<%--<td class='label' align='right'>Period From</td>
		<%if (from_ca.equals("Y")) {%>
		<td align='left' title='<%=from_ca%>'>&nbsp;<input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from',null,'hh:mm');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD>
		<%} else {%>
		<td align='left' title='<%=from_ca%>'>&nbsp;<input type="text" name="date_from" id="date_from"  size="16" maxlength="16" value="<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_from:curr_week_date%>" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from',null,'hh:mm');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD>
		<%}%>

		<td class='label' align='right'>To</td><td align='left'>&nbsp;<input type=text name='date_to' id='date_to'  size=16 maxlength=16 value="<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_to:last_week_date%>" onBlur="checkValidDateTime(this)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to',null,'hh:mm');" style='cursor:pointer'></td>--%>
		<td class='label' align='right'>Period From</td>
		<%if (from_ca.equals("Y")) {%>
		<td align='left'>&nbsp;<input type="text" name="date_from" id="date_from" value="" size="10" maxlength="10" onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD>
		<%} else {%>
		<td align='left'>&nbsp;<input type="text" name="date_from" id="date_from" value="<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_from:last_week_date%>" size="10" maxlength="10" onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD>
		<%}%>
		<td class='label' align='right'>To</td><td align='left'>&nbsp;<input type=text name='date_to' id='date_to' value='<%=(CancelFlag.trim().equalsIgnoreCase("Y"))?can_date_to:last_week_date%>' size="10" maxlength="10" onBlur="checkDateRange(this,'result_reporting_search')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%--<td>&nbsp;</td>--%>
	</tr>
	<%
	//out.println("patient_id="+patient_id+", encounter_id="+encounter_id);

	if(CancelFlag.trim().equalsIgnoreCase("Y"))	 {
		if(!option_id.trim().equalsIgnoreCase("TASK_ORDER_REPORT")){
			patient_id="" ;
			encounter_id="";
		}
	}

	if(patient_id==null || patient_id.equals("null") || patient_id.equals(""))
	{
		patient_id="";
		encounter_id="";
	%>
	<tr>
		<td class=label align='right'>Patient ID</td>
		<td>&nbsp;<input type='text' width='16%' name='patient_id' id='patient_id' value='<%= can_patient_id %>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  maxlength='<%=patient_id_length%>' ><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td> <%--onBlur='ChangeUpperCase(this);validPatient(this);'--%>
		<td class=label align='right'>Order ID</td>
		<td>&nbsp;<input type=text name='order_id' id='order_id' value='<%=can_order_id%>' maxlength=15 onBlur='ChangeUpperCase(this)'></td>
		<td class=label align='right'>Encounter ID</td>
		<td>&nbsp;<input type=text name='encounter_id' id='encounter_id' value='<%=can_encounter_id%>' onBlur="OrCheckNumber1(this)" maxlength=12 onKeyPress='return OrAllowPositiveNumber()' colspan=3><input type='hidden' name='patient_id_found' id='patient_id_found' value='no'></td>
	</tr>
	<tr>
	<td class=label align='right'>Catalog</td>
		<td>&nbsp;<input type=text name='catalog' id='catalog' value='' size="22" maxlength="40" ></td>
		<td class=label align='right'>Search Criteria</td>
		<td>&nbsp;<SELECT name="search_criteria" id="search_criteria">
				<option value='S'>Starts With</option>
				<option value='C'>Contains</option>
				<option value='E'>Ends With</option>
			</SELECT>
		</td><td class=label align='right'>Task Status</td>
		<td id='task_status_show'>&nbsp;<SELECT name="task_status" id="task_status">
		<option value='Z'>All</option>
		<%--<option value='E'>Elapsed</option>
		<option value='O' >Overdue</option>
		<option value='D'>Due</option>
		<option value='F' >Future</option>
		<option value='C' >Complete</option>--%>
		<option value='X'>External Orders</option>
		<option value='R'>Acknolwedge the Results</option>
		</SELECT></td>

	</tr>
 	<TR>
 		<TD class=label align='right'>Source</TD>
		<td class=label  colspan='3'>&nbsp;<SELECT name="source_location_type" id="source_location_type" onChange='populateSourceLocation(this)'>
			<option value=''>All</option>
			<option value='C'>Clinic</option>
			<option value='N'>Nursing Unit</option>
		</SELECT>&nbsp;<SELECT name="source_locn" id="source_locn"  >
					<option value="">All&nbsp;&nbsp;&nbsp;</option>
			</SELECT>&nbsp;
		</td><td class=label align='right'>Group By</td>
		<td>&nbsp;<SELECT name="group_by" id="group_by">
            <option value="D">Date/Time </option>
            <option value="P">Patient ID </option>
        	<option value="C">Order Category </option>
        	<option value="T">Order Type </option>
        	<option value="L">Location </option>
        	<option value="U">Priority </option>
        	<option value="O">Orderable </option>
		</SELECT></td>
     </TR>
     <tr>
        <td id='specimen_no_lbl_show' class='label' align='right' nowrap>&nbsp;</td>
		<td id='specimen_no_show' align='left'>&nbsp;</td>
		<%--<td class=label align='right'>View Order By</td>
		<td>&nbsp;<SELECT name="view_by" id="view_by"  onChange='fillTaskStatus(this);'>
		<option value='H'>Header</option>
		<option value='L' >Line</option>
		</SELECT></td>--%>
        <TD colspan='2'>&nbsp;<Input name='view_by' id='view_by' type='hidden' value='H'></TD>
		<td colspan='2'></td>
     </tr>
	<%--<tr>
		<td class=label align='right'>&nbsp;</td>
		<td>&nbsp;</td>
		<td class=label align='right'>&nbsp;
		</td>
		<td>&nbsp;</td>
	</tr>--%>
	<tr>
		<td colspan=6 align=right>
	<%
	}else{
	%>
	<tr>
	<td class=label align='right'>Catalog</td>
		<td>&nbsp;<input type=text name='catalog' id='catalog' value='' size="22" maxlength="40" ></td>
		<td class=label align='right'>Search Criteria</td>
		<td>&nbsp;<SELECT name="search_criteria" id="search_criteria">
				<option value='S'>Starts With</option>
				<option value='C'>Contains</option>
				<option value='E'>Ends With</option>
			</SELECT>
		</td>
		<td class=label align='right'>Task Status</td>
		<td id='task_status_show'>&nbsp;<SELECT name="task_status" id="task_status">
		<option value='Z'>All</option>
		<%--<option value='E'>Elapsed</option>
		<option value='O' >Overdue</option>
		<option value='D'>Due</option>
		<option value='F' >Future</option>
		<option value='C' >Complete</option>--%>
		<option value='X'>External Orders</option>
		<option value='R'>Acknolwedge the Results</option>
		</SELECT></td>
	</tr>
	<tr>
	   <TD class=label align='right'>Source</TD>
		<td class=label  colspan='3'>&nbsp;<SELECT name="source_location_type" id="source_location_type" onChange='populateSourceLocation(this)'>
			<option value=''>All</option>
			<option value='C'>Clinic</option>
			<option value='N'>Nursing Unit</option>
		</SELECT>&nbsp;<SELECT name="source_locn" id="source_locn"  >
					<option value="">All&nbsp;&nbsp;&nbsp;</option>
			</SELECT>&nbsp;
		</td>
		<%--<td class=label align='right'>View Order By</td>
		<td>&nbsp;<SELECT name="view_by" id="view_by" onChange='fillTaskStatus(this);'>
		<option value='H'>Header</option>
		<option value='L' >Line</option>
		</SELECT></td>--%>
		<TD class='label' colspan='2'>&nbsp;<Input name='view_by' id='view_by' type='hidden' value='H'></TD>
	</tr>
	<tr>
        <td class=label align='right'>Group By</td>
		<td>&nbsp;<SELECT name="group_by" id="group_by">
            <option value="P">Patient ID </option>
        	<option value="C">Order Category </option>
        	<option value="T">Order Type </option>
        	<option value="L">Location </option>
        	<option value="D">Date/Time </option>
        	<option value="U">Priority </option>
        	<option value="O">Orderable </option>
		</SELECT></td>
		<td id='specimen_no_lbl_show' class='label' align='right' nowrap>&nbsp;</td>
		<td id='specimen_no_show' align='left'>&nbsp;</td>
        <td colspan='2' align=right>
		<input type='hidden' name='patient_id_found' id='patient_id_found' value='yes'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%= patient_id %>'>
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		<input type='hidden' name='order_id' id='order_id' value=''>
	<%
	}
	%>
		<input type=button class=button name='search' id='search' value='Search'  onClick='populateValues()'>&nbsp;<input type=button name='clear' id='clear' class=button value='Clear' onClick='clearValues()'>&nbsp;&nbsp;</td>
	</tr>

</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<Input type="hidden" name="isRDInstalled_yn" id="isRDInstalled_yn" value="<%=isRDInstalled_yn%>">
<Input type="hidden" name="isLabInstalled_yn" id="isLabInstalled_yn" value="<%=isLabInstalled_yn%>">
<Input type="hidden" name="bean_id1" id="bean_id1" value="<%=bean_id1%>">
<Input type="hidden" name="bean_name1" id="bean_name1" value="<%=bean_name1%>">
<Input type="hidden" name="CancelFlag" id="CancelFlag" value="<%=CancelFlag%>">
<Input type="hidden" name="from_ca" id="from_ca" value="<%=from_ca%>">
<Input type="hidden" name='default_order_category' id='default_order_category' value=''>
</form>

</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

