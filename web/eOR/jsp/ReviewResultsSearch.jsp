<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <!--
-----------------------------------------------------------------------
Date       	  Edit History  Name        Description
-----------------------------------------------------------------------
?             100         	?            created	
05/07/2012    IN033610      Chowminya G	 Add Notification Alert in summary 								 
-----------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	<link rel="StyleSheer" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/ReviewResults.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%String ca_normalcy_ind = request.getParameter("ca_normalcy_ind");
if (ca_normalcy_ind == null) ca_normalcy_ind = "";
if (ca_normalcy_ind.equals("X")) ca_normalcy_ind = "C";
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%--<Script>alert('<%=ca_normalcy_ind%>')</Script>--%>
<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";
	Properties properties=(Properties)session.getValue("jdbc");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";


	/* Initialize Function specific start */
	ReviewResults bean = (ReviewResults)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String patient_id = bean.checkForNull(request.getParameter("patient_id"),"");
	String patient_class = bean.checkForNull(request.getParameter("patient_class"),"");

	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();

	ArrayList EventClass	= new ArrayList();
	
	String curr_week_date="";
	String last_week_date="";
	/*Thai date validations start 14/02/2007*/
	ArrayList sysdate=new ArrayList();
	sysdate=(ArrayList)bean.getSysDateTime(properties);
	for(int j=0;j<sysdate.size();j++){

		last_week_date=(String)sysdate.get(0);
		curr_week_date=(String)sysdate.get(1);
	}
		
	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";
	if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_week_date=com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY","en",localeName);
	}
	String pract_relationship_id  = "";
	String get_task_applicability = bean.checkForNull((String)bean.getMenu("VIEW_CONF_RESULT",resp_id,pract_relationship_id,properties));
/*Thai date validations start 14/02/2007*/
/* Initialize Function specific end */
//
//<form name='review_result_search' id='review_result_search' target='messageFrame' >
String  temp_curr_week_date=curr_week_date;
String temp_last_week_date=last_week_date;
%>

<form name='review_result_search' id='review_result_search' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

<tr>
		<td  class='label' id='id_locn'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='patientId' id='patientId' value='<%=patient_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>" ><input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()">
		</td>
		<td class=label><fmt:message key="eOR.NormalcyIndicator.label" bundle="${or_labels}"/></td>
		<td class=fields><SELECT name="normalcy_ind" id="normalcy_ind">
				<option value='' <%=(ca_normalcy_ind.equals("Z")) ? "selected" : ""%>> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value='N' <%=(ca_normalcy_ind.equals("N")) ? "selected" : ""%>><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
				<option value='A' <%=(ca_normalcy_ind.equals("A")) ? "selected" : ""%>><fmt:message key="Common.Abnormal.label" bundle="${common_labels}"/></option>
				<option value='C' <%=(ca_normalcy_ind.equals("C")) ? "selected" : ""%>><fmt:message key="Common.CriticallyAbnormal.label" bundle="${common_labels}"/></option>
				<option value='Y' <%=(ca_normalcy_ind.equals("Y")) ? "selected" : ""%>><fmt:message key="eOR.NotifyAlert.label" bundle="${or_labels}"/></option>
				<!-- IN033610-->
			</SELECT>
		</td>
		</tr>
		
		<tr>
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/> </td>
		<td class=fields><input type="text" size="10" maxlength="10" value="<%=curr_week_date%>" id="period_from" name="period_from" onKeyPress="return OrAllowDateFormat();" onBlur="chckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type="text" name="period_to" id="period_to" value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'review_result_search');" onKeyPress="return OrAllowDateFormat();" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_to');" style='cursor:pointer'></img><img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	<td class=label><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="priority" id="priority">
				<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT> <!-- Normalcy Indicator --></td>
	</tr>

		<tr>
		
		<td class=label><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="result_type" id="result_type" onChange="populateEventClass(this);">
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='BLTF'><fmt:message key="eOR.BloodTransfusion.label" bundle="${or_labels}"/></option>
			<option value='LBIN'><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/></option>
			<option value='RDIN'><fmt:message key="Common.Radiology.label" bundle="${common_labels}"/></option>
			<option value='TRET'><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></option>
			<option value='PTCR'><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td class=label><fmt:message key="Common.EventClass.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="event_class" id="event_class">
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%
			EventClass = bean.getEventClass("");    //Pass the rec_type as null when loading
			for(int k=0; k<EventClass.size(); k++)
			{
				String[] records = (String[])EventClass.get(k);
		%>
					<option value=<%=records[0]%>><%=records[1]%></option>
		<%	} // End of for
		%>
		</SELECT><!-- Order By -->
		</td></tr>

		<tr><td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class=fields><Select name='group_by' id='group_by'>
		<Option value='P'><fmt:message key="eOR.PatientEvent.label" bundle="${or_labels}"/></Option>
		<Option value='E'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></Option>
		</Select></td>
	<td></td>
	<td class='button' align="right"><input type=button name='search_btn' id='search_btn' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td></tr>
	
	<%--<td class=label><fmt:message key="Common.EventClass.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="event_class" id="event_class">
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%
			EventClass = bean.getEventClass("");    //Pass the rec_type as null when loading
			for(int k=0; k<EventClass.size(); k++)
			{
				String[] records = (String[])EventClass.get(k);
		%>
					<option value=<%=records[0]%>><%=records[1]%></option>
		<%	} // End of for
		%>
		</SELECT>
		</td>
		<td class='button'><input type=button name='search' id='search' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td>
		</tr>--%>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class.trim()%>'>
<input type='hidden' name='ca_normalcy_ind' id='ca_normalcy_ind' value='<%=ca_normalcy_ind%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<input type="hidden" name="get_task_applicability" id="get_task_applicability" value="<%=get_task_applicability %>">
<%if ((!ca_normalcy_ind.equals("")) || (!patient_id.equals("")) || (!patient_class.equals(""))) {%>
<Script>populateValues();</Script>
<%}%>
</form>


<%
putObjectInBean(bean_id,bean,request);
%>

</body>
<script>//document.review_result_search.submit();
populateValues();</script>
</html>

