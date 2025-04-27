<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <jsp:useBean id="bean" scope="page" class="eOR.SpecialApproveOrders"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/SpecialApproveOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--onLoad='populateLocation(document.aspl_apprv_order.location_type)' -->
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	request.setCharacterEncoding("UTF-8");

	String bean_id = "Or_SpecialApproveOrders" ;
	String bean_name = "eOR.SpecialApproveOrders";
	//String disabled = "" ;
	Properties properties			= (Properties) session.getValue( "jdbc" );
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	
	//String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	bean.setLanguageId(localeName);
	/*ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){

		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		//curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	}*/
	if(last_week_date.equals("null")) last_week_date="";
	if(curr_week_date.equals("null")) curr_week_date="";
//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
/* Mandatory checks end */

	/* Initialize Function specific start */
	//SpecialApproveOrders bean = (SpecialApproveOrders)getBeanObject( bean_id,bean_name , request ) ;

//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

//	bean.clear() ;
//	bean.setMode( mode ) ;
	
	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength(properties);	


/* Initialize Function specific end */

/*out.println("<BR>"+(String)session.getValue("security_level"));
out.println("<BR>"+(String)session.getValue("practitioner_type"));
out.println("<BR>"+(String)session.getValue("ca_practitioner_id"));
out.println("<BR>"+(String)session.getValue("ca_resp_id"));
out.println("<BR>"+(String)session.getValue("facility_id"));*/

last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");
String  temp_curr_week_date=curr_week_date;
String temp_last_week_date=last_week_date;
String filter=request.getParameter("filter")==null?"AL":request.getParameter("filter");
String selected="selected";
%>
<form name='aspl_apprv_order' id='aspl_apprv_order' target='SpecialApprovalOrdersBottom' action='SpecialApprovalOrdersBottom.jsp'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<!-- <tr>
		<td colspan="7">&nbsp;</td>
	</tr> -->
	<tr>
		<td class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td  class='fields'><SELECT name="location_type" id="location_type" onChange=''>
			<option value=""> <fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value="C"> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
			<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			<option value="W"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/>
		</SELECT><Input name='locn_desc' id='locn_desc' type='text' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")%>'  size="15" onBlur="populateLoaction(locn_desc);" ><input class='button' type=button name=search value='?'  class=button onClick="populateLoaction(locn_desc)" size='15'><input type='hidden' name='locn' id='locn' value=''></td>
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="chckDate(this,'<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type=text name='period_to' id='period_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'aspl_apprv_order','DMY','<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align=center></img></td></tr>
<tr>
<td class='label' id='id_locn'  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='fields' ><input type='text' name='patientId' id='patientId' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>"><input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()">
</td>
<!--  Added By Arvind For CRF-804  -->

<td class="label"><fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/></td>
<td class="fields">
		<select name="filter" id="filter">		   
			<option value="AL" <%=filter.equalsIgnoreCase("AL")?"selected":""%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value="RP" <%=filter.equalsIgnoreCase("RP")?"selected":""%> ><fmt:message key="eOR.MyRelatedPatient.label" bundle="${or_labels}"/>
			<option value="MS" <%=filter.equalsIgnoreCase("MS")?"selected":""%> ><fmt:message key="eOR.MySpeciality.label" bundle="${or_labels}"/>
			</SELECT></td>

	<!-- End Here  -->

<td  class='button'>
<INPUT TYPE="button" name='search_btn' id='search_btn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='populateValues()'><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='resetValues()'></td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
<Script>
document.aspl_apprv_order.search_btn.disabled = true;
document.aspl_apprv_order.submit();</script>
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

