<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           										created
25/09/2012		IN030279		Ramesh G											Bru-HIMS-CRF-160 								 
08/01/2013   IN036513            Karthi L    										System displaying all the locations, including  Facility 2  locations in the  Location search criteria
05/02/2014 		IN047918		NijithaS											KDAH-CRF-0284 
-------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 		10/07/2017		Ramesh G		ML-MMOH-CRF-0555	
28/08/2017	IN065091			Krishna Gowtham J 		29/08/2017		Ramesh G		GHL-CRF-0440.1	
03/10/2017  IN061908		 		Krishna Gowtham	J		04/10/2017		Ramesh G		ML-MMOH-CRF-0560
16/10/2017	IN065433			Krishna Gowtham J 		16/10/2017		Ramesh G		OR-ML-MMOH-CRF-0560/01-Result-Reporting			
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>
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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script>
	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> <!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" >  -->
<%
/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_PatOrderByPrivRelnBean" ;
	String bean_name = "eOR.PatOrderByPrivRelnBean";
	//IN030279 Start
	String function_from= ((String)request.getParameter("function_from"))==null?"":((String)request.getParameter("function_from"));
	String patient_id= ((String)request.getParameter("patient_id"))==null?"":((String)request.getParameter("patient_id"));
	//IN030279 End.
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id"); // added for IN036513
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";
	
	//IN065091 starts
	String BTColorYN 		= "";
	Connection connection 	=  null;
	boolean isSiteSpecificBillStatus = false; 	
	try
	{
		connection				= ConnectionManager.getConnection(request);
		boolean isSiteSpecificBTColor = false;
		isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");
		isSiteSpecificBTColor = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BLOOD_ORDERS_ACK");
		if(isSiteSpecificBTColor){
			BTColorYN = "Y";
		}
		else{
			BTColorYN = "N";
		}
	} catch (Exception e) {out.println(e.toString());}
	finally{
		if(connection!=null)
		ConnectionManager.returnConnection(connection,request);
	}
	//IN065091 ends

/* Mandatory checks end */

	/* Initialize Function specific start */
//	PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id,bean_name,request ) ;

//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

//	bean.clear() ;
//	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);

	String curr_sys_date = "";
	String curr_week_date  = "";
	String last_week_date  = "";
	Properties properties		= (Properties) session.getValue( "jdbc" );  
	int patient_id_length = bean.getPatientIdLength(properties);
 	/*ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);

	for(int i=0;i<sysdate.size();i++){
		last_week_date =  (String)sysdate.get(0);
		curr_week_date =  (String)sysdate.get(1);
		curr_sys_date =  (String)sysdate.get(2);
	}
if(last_week_date.equals("null")) last_week_date="";
if(curr_week_date.equals("null")) curr_week_date="";
if(curr_sys_date.equals("null")) curr_sys_date="";*/
last_week_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
curr_week_date	= com.ehis.util.DateUtils.minusDate(last_week_date,"DMY",localeName,7,"d");
curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
//IN065433 starts
	String load_search 				= request.getParameter("load_search");
	load_search						= (load_search == null) ? "Y" : load_search;
//IN065433 ends

	ArrayList order_category = bean.getOrderCategoryWithoutCareSet(properties);

	//ArrayList orderType=new ArrayList();

	//ArrayList PracType=	bean.getPractitionerID(properties);

/* Initialize Function specific end */
String current_iplist = "disabled"; //IN047918
%>
<form name='PatOrderByPrivReln_search' id='PatOrderByPrivReln_search' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0  width="100%" align=center border='0'>

<tr>
	<td class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name='status' id='status' onChange='checkStatus(this)' ><option value="EXT_ACTIVE"><fmt:message key="Common.active.label" bundle="${common_labels}"/></option><option value="EXT_ALL">--<fmt:message key="Common.all.label" bundle="${common_labels}"/>--</Option><option value="EXT_PEND_RVS"><fmt:message key="eOR.PendingReviews.label" bundle="${or_labels}"/></option><option value="EXT_OUTSTAND"><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option><option value="EXT_COMPL_ORD"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option><option value="EXT_HOLD"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></option><option value="EXT_DISC_CAN"><fmt:message key="eOR.DiscontinuedCancelled.label" bundle="${or_labels}"/></option><option value="EXT_FUTURE_ORD"><fmt:message key="Common.FutureOrders.label" bundle="${common_labels}"/></option><option value='EXT_APPT'><fmt:message key="eOR.AppmtBooked.label" bundle="${or_labels}"/></option><!--IN061903 start--><option value='EXT_NOT_DONE'><fmt:message key="eOR.NOTDONE.label" bundle="${or_labels}"/></option><!--IN061903 ends--></select><span id="displayOrders" name="displayOrders" nowrap align="left"><fmt:message key="eOR.ElapsedOrders.label"bundle="${or_labels}"/><input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'></span></td>
	<td class='label' ><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name="ordering_pract_desc" id="ordering_pract_desc" value="" onblur='callpractSearch1(ordering_pract_desc,ordering_pract);'><input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="callpractSearch(ordering_pract_desc,ordering_pract);"><input type="hidden" name="ordering_pract" id="ordering_pract" value=""></td>
</tr>
<tr>
	 <td  class=label ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
	 <td class=fields ><select name="order_category" id="order_category" onChange="FillOrderType(this);">
		<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(order_category.size()>0){
			for(int i=0;i<order_category.size();i++){
				String[] ordertype = (String[])order_category.get(i);
		%>
				<option value="<%=ordertype[0]%>" ><%=ordertype[1]%></option>
		<%  }
		}%>
	</select>
	</td>
	<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="order_type" id="order_type" onChange="populateLocnActivityType()">
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select></td>	
</tr>
<tr>
	<td class='label' nowrap ><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class='fields'><input type="text" name="activity_type_desc" id="activity_type_desc" value="" onblur='callActivitySearch1(activity_type_desc,activity_type);'><input type=button name=ActSearch value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type);"><input type="hidden" name="activity_type" id="activity_type" value=""></td>
	<td class=label >
 <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
<td class=fields ><input type='text'  name='item' id='item' value=''  onKeyPress='callSearch();' maxlength='20' size=15 ><select name="search_crt" id="search_crt">
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
	</select>
</td>

</tr>

<tr>
<td  class=label id='period_td' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
<td class=fields ><input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>" size="10" maxlength="10" onBlur="chckDate(this,'<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from');" style='cursor:pointer'><font size="4">-</font><input type=text name='period_to' id='period_to' value='<%=last_week_date%>' size="10" maxlength="10" onBlur="checkDateRange(this,'PatOrderByPrivReln_search','DMY','<%=localeName%>')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to');" style='cursor:pointer'>
</td>
<td class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name=urgency>
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="S"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class=fields>
	<!--IN030279 Start -->
	<!--
	<input type='text' width='16%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' size='<%=patient_id_length%>'  >
	<input  type=button name=search1 value='?'  class=button tabIndex="4" onClick="callPatientSearch()">
	-->
	<input type='text' width='16%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' size='<%=patient_id_length%>' <%if("MO".equals(function_from)){%>disabled <%}%>>
	<%if(!"MO".equals(function_from)){%>
		<input  type=button name=search1 value='?'  class=button tabIndex="4" onClick="callPatientSearch()">	
	<%}else{%>
		<script>
			document.PatOrderByPrivReln_search.patientId.value="<%=patient_id%>";
		</script>
	<%}%>
	<!-- IN030279 End.  -->
</td>
<td class=label width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
<td class=fields ><input type='text' size=10 name='encounterId' id='encounterId' value='' nowrap onBlur="OrCheckNumber1(this)" maxlength=12 onKeyPress='return OrAllowPositiveNumber()'>
 </tr>
<tr>
<!--<td class=label width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td class=fields width='25%'><SELECT name="location_type" id="location_type" onChange='populateLocationOnChange(this)'>
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
     					<option value='W'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
</SELECT><SELECT name="locn" id="locn" >
			<option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
</SELECT></td>-->

<TD class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<td class=fields><SELECT name="location_type" id="location_type" onChange='populateSourceLocation(this)'>
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
		</SELECT><input type="text" value='' name="source_locn_desc" id="source_locn_desc" onblur='populateMoveLoaction1(source_locn_desc,locn);'><input type=button name=SourceSearch value='?'  class=button tabIndex="4" onClick="populateMoveLoaction(source_locn_desc,locn);" disabled><input type="hidden" name="locn" id="locn" value="">
		</td>
<!-- IN047918 Starts-->		
<TD class=label ><fmt:message key="eOR.CurrentIPList.label" bundle="${or_labels}"/></TD>
<TD class=fields>
		<input type='checkbox' name='current_ip_list_check' id='current_ip_list_check' value='N' onclick='ChkCurrectIPList()' <%=current_iplist%>>	
</TD>
<!--IN047918 Ends-->
<td class=label ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
<td class=fields ><select name="order_by" id="order_by">
	<option value="P"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
	<option value="C"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
	<option value="T"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
	<option value="L"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
	<option value="D"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
	<option value="U"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></option>
</select></td>
</tr>
<tr>
	<td class=label nowrap><fmt:message key="eOR.ViewOrderBy.label" bundle="${or_labels}"/></td>
	<td class="fields">
		<SELECT name="view_by" id="view_by">
			<option value='H'><fmt:message key="Common.Header.label" bundle="${common_labels}"/></option>
			<option value='L' <%if(isSiteSpecificBillStatus){%> SELECTED <%}%>><fmt:message key="Common.Line.label" bundle="${common_labels}"/></option>
		</SELECT>
	</td>
	<td ></td>
	 <td   class='button' align="right"><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='populateValues()'><input type=button name='clear' id='clear' class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'></td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="templocale" id="templocale" value="<%=localeName%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
<input type="hidden" name="referral_sql" id="referral_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_R")%>">
<input type="hidden" name="Orderby_pract" id="Orderby_pract" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_AM_PRACT")%>">
<input type="hidden" name="facilityid" id="facilityid" value="<%=facility_id%>"> <!-- added for IN036513 -->
<input type="hidden" name="BTColorYN" id="BTColorYN" value="<%=BTColorYN%>"> <!-- added for IN065091 -->
<!--IN061908 Start-->
<%if("Y".equals(load_search)){%> <!--IN065433 ends-->
<script>
	populateValues();
</script>
<%}%> <!--IN065433 ends-->
<!--IN061908 End-->
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

