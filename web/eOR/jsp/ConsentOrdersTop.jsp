<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ConsentOrdersTop.jsp -->
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
19/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage 
03/09/2013	  IN043052	   Karthi L		The new filter â??Specialityâ?? should not be displayed at Patient Chart>Record Consent
18/09/2013	  IN043437	   Karthi L		By selecting Specialty having Special characters we get wrong message prompt. 
21/10/2015	IN057196		Ramesh G		Recording Of Consent Form
17/10/2018	IN066709   Prakash C	ML-MMOH-CRF-1101
---------------------------------------------------------------------------------------------------------------
--> 
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <jsp:useBean id="bean" scope="page" class="eOR.ConsentOrders"/>
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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ConsentOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--onLoad='populateLocation(document.consent_order.location_type)'-->
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	String patient_id	   = request.getParameter( "patient_id" ) ;
	
	if(patient_id==null) patient_id = "";
 	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	bean.setLanguageId(localeName);
	//String disabled = "" ;
    int patient_id_length = 0;
	Properties properties			= (Properties) session.getValue( "jdbc" );
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	/* Initialize Function specific start */
	//ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id, bean_name ,request ) ;

	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	//bean.clear() ;
	//bean.setMode( mode ) ;
    patient_id_length = bean.getPatientIdLength(properties);
	//String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	/*Thai date validations 14/02/2007 start*/
	last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");

	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";
	//ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	
	/*for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		//System.out.println("last_week_date="+last_week_date);
		//System.out.println("curr_week_date="+curr_week_date);
		//curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}*/
	/*Thai date validations 14/02/2007 end*/
String  temp_curr_week_date=curr_week_date;
String temp_last_week_date=last_week_date;
//IN29559,starts
String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
String orderCategory = request.getParameter("orderCategory")==null?"":request.getParameter("orderCategory");
String consent_called_from = request.getParameter("p_consent_called_from")==null?"":request.getParameter("p_consent_called_from"); //IN043052
String consentRec_order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id"); //IN057196
//IN066709 Starts
String date=request.getParameter("date")==null?"":request.getParameter("date"); //Prakash
String date1="";
if(!date.equals("")){
	 date1=date.substring(0, 10);
}
String date2= com.ehis.util.DateUtils.minusDate(date1,"DMY",localeName,7,"d");
//IN066709 Ends

if(calledFrom.equals("TASK_LIST"))
{
	if(!fromDate.equals("") && !toDate.equals(""))
	{
		curr_week_date = fromDate;
		last_week_date = toDate;
	}
	else
	{
		curr_week_date = last_week_date;
		last_week_date = last_week_date;
	}
}
//IN057196 Start.
else if(calledFrom.equals("RECORD_CONSENT_WITH_ORDER")){
		if(!fromDate.equals("") && !toDate.equals("")){//IN066709
			curr_week_date = fromDate;
			last_week_date = toDate;
	//IN066709 Starts
		}else{
			curr_week_date = date2;
			last_week_date = date1;
		}	
	//IN066709 Ends
}
//IN057196 End.
//IN29559,ends
%>
<form name='consent_order' id='consent_order' target='ConsentOrderBottom' action='ConsentOrdersBottom.jsp'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

	<tr><td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="location_type" id="location_type" onChange=''>
			<option value=""> <fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value="C"> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
			<option value="D"> <fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<option value="E"> <fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			<option value="W"> <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			<option value="R"> <fmt:message key="Common.referral.label" bundle="${common_labels}"/> 
		</SELECT><Input name='locn_desc' id='locn_desc' type='text' value='<fmt:message key="Common.all.label" bundle="${common_labels}"/>'  size="15" onBlur="populateLoaction(locn_desc);" ><input class='button' type=button name=search id=search value='?'  class=button onClick="populateLoaction(locn_desc)" size='15'><input type='hidden' name='locn' id='locn' value=''></td>
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class=fields><input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type=text name='period_to' id='period_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'consent_order')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
		</tr>
		<tr>
		<td  class='label' id='id_locn'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text'  name='patientId' id='patientId' value="<%=patient_id%>" nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>"<%if(patient_id!=null && !patient_id.equals("")){%> readOnly<%}%>> <%if(patient_id==null || patient_id.equals("")) { %> <input class='button' type=button name=search id=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"><% } %>
		</td>	
		<!-- <td></td>  -->
		<!--  added for BRU-HIMS-CRF-359 [IN038797] - Start -->
		<!--  added Condition for - IN043052 -->
		<% if(consent_called_from.equals("")) { %> 
		<td class='label' ><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
				<td class='fields'  ><input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' onClick="if(document.forms[0].specialty.value == '')getSpecialty()"><input type="hidden" name="speciality_code" id="speciality_code" value=''></td>
		<td class='button'><INPUT TYPE="button" name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='populateValues()'><INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='resetValues()'>
		</td>
		
		<% } else {%>
			<td></td>		
			<td class='button'><INPUT TYPE="button" name='search_btn' id='search_btn' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='populateValues()'><INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='resetValues()'>
			</td>
		<%
		}
		%>
		<!-- BRU-HIMS-CRF-359 [IN038797] End -->
		</tr>
		</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id %>">
<input type="hidden" name="facility_id" id="facility_id" value="<%= facility_id %>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
 <input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<!--IN29559,starts-->
<input type="hidden" name="calledFrom" id="calledFrom" value="<%=calledFrom%>">
<input type="hidden" name="orderCategory" id="orderCategory" value="<%=orderCategory%>">
<input type='hidden' name='Splcode_desc_hid' id='Splcode_desc_hid' value=''> <!-- 43437 -->
<input type='hidden' name='consentRec_order_id' id='consentRec_order_id' value='<%=consentRec_order_id%>'><!-- IN057196 -->
<!--IN29559,ends-->
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
<Script>
document.consent_order.search_btn.disabled = true;
document.consent_order.submit();
</script>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

