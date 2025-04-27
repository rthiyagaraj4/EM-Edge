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
----------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           										created
05/02/2014 	IN047918		NijithaS											KDAH-CRF-0284 
10/11/2016	IN055010		Karthi L											MMS-QH-CRF-0213
----------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 		10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.Common.* " contentType="text/html;charset=UTF-8" %>

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
	<script language="JavaScript" src="../js/OROrderTrackingRpt.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> <!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" >  -->
<%
/* Mandatory checks start */
	Connection connection =  null; // added for MMS-QH-CRF-0213 [IN055010] - Start
	try {
	request.setCharacterEncoding("UTF-8");

	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_PatOrderByPrivRelnBean" ;
	String bean_name = "eOR.PatOrderByPrivRelnBean";	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");	
	boolean isSiteSpecific = false; // added for MMS-QH-CRF-0213 [IN055010]
	connection = ConnectionManager.getConnection(request); 
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","MMS_ORD_TRK_REPORT"); // added for MMS-QH-CRF-0213 [IN055010]
		
	String curr_sys_date = "";
	String curr_week_date  = "";	
	String prev_date  = "";	
	Properties properties		= (Properties) session.getValue( "jdbc" );  
	int patient_id_length = bean.getPatientIdLength(properties);
	//String localeName =(String) properties.getProperty("LOCALE");	
	bean.setLanguageId(localeName); 	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
	//added for MMS-QH-CRF-0213 [IN055010]
	if(isSiteSpecific){
		curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMYHM",localeName,30,"d");
	}
	else {
		curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMYHM",localeName,7,"d");	
	}
	//added for MMS-QH-CRF-0213 [IN055010]
	prev_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMYHM",localeName,1,"d");

	ArrayList order_category = bean.getOrderCategoryWithoutCareSet(properties);

	String current_iplist = "disabled"; //KDAH-CRF-0284

%>
<form name='Or0rderTrackingRptForm' id='Or0rderTrackingRptForm' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0  width="100%" align="center" border='0'>
	<tr>
	  <th colspan="6" align="left"><fmt:message key="eOR.ReportCriteria.label" bundle="${or_labels}"/></th> <!--KDAH-CRF-0284 colspan increased-->
	  </tr>
	  <tr><td colspan="4">&nbsp;</td></tr>

<tr>
  <td class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class=fields><input type='text' name='p_patient_id' id='p_patient_id' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  maxlength='<%=patient_id_length%>' size='<%=patient_id_length%>'><input  type=button name=search1 value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
   <TD class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
   <td class=fields><SELECT name="p_source_type" id="p_source_type" onChange='populateSourceLocation(this)'>
			<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>			
		</SELECT><input type="text" value='' name="source_locn_desc" id="source_locn_desc" onblur='populateMoveLoaction1(source_locn_desc,p_source_code);' disabled><input type="button" name="SourceSearch" id="SourceSearch" value='?'  class=button tabIndex="4" onClick="populateMoveLoaction(source_locn_desc,p_source_code);" disabled><input type="hidden" name="p_source_code" id="p_source_code" value="">
		</td>
	<!-- KDAH-CRF-0284 Starts -->		
	<TD class=label ><fmt:message key="eOR.CurrentIPList.label" bundle="${or_labels}"/></TD>
	<TD class=fields>
		<input type='checkbox' name='P_IP_CHK_LIST' id='P_IP_CHK_LIST' value='N' onclick='ChkCurrectIPList()' <%=current_iplist%>>	
	</TD>
	<!-- KDAH-CRF-0284 Ends-->		
</tr>
<tr>
	<td class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	  <td class=fields >
	    <select name='p_status' id='p_status' onChange='checkTrackingStatus(this)' >
		<option value="EXT_ACTIVE"><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
		<option value="EXT_ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
		<option value="EXT_PEND_RVS"><fmt:message key="eOR.PendingReviews.label" bundle="${or_labels}"/></option>
		<option value="EXT_OUTSTAND"><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
		<option value="EXT_COMPL_ORD"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
		<option value="EXT_HOLD"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></option>
		<option value="EXT_DISC_CAN"><fmt:message key="eOR.DiscontinuedCancelled.label" bundle="${or_labels}"/></option>
		<option value="EXT_FUTURE_ORD"><fmt:message key="Common.FutureOrders.label" bundle="${common_labels}"/></option>
		<option value='EXT_APPT'><fmt:message key="eOR.AppmtBooked.label" bundle="${or_labels}"/></option>
		<option value='EXT_NOT_DONE'><fmt:message key="eOR.NOTDONE.label" bundle="${or_labels}"/><!--IN061903-->
	 </select>&nbsp;&nbsp;<span id="ElapsedOrders" nowrap><fmt:message key="eOR.ElapsedOrders.label" bundle="${or_labels}"/><input type="checkbox" name="p_elapsed_order_yn" id="p_elapsed_order_yn" value="N" onclick="ChkElapseOrders(this)"></span></td>
	 </td>
	 <td  class=label id='period_td' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
<td class=fields ><input type="text" name="p_period_from" id="p_period_from" value="<%=curr_week_date%>" size="16" maxlength="16" onBlur="checkIsValidDate(this,'DMYHM','<%=localeName%>','FROMDATE',document.getElementById('p_period_to'));" onKeyPress='return allowDateFormat()'><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('p_period_from',null,'hh:mm');" style='cursor:pointer'><font size="4">&nbsp;-&nbsp;</font><input type="text" name='p_period_to' id='p_period_to' value='<%=curr_sys_date%>' size="16" maxlength="16" onBlur="checkIsValidDate(this,'DMYHM','<%=localeName%>','TODATE',document.getElementById("p_period_from"));" onKeyPress='return allowDateFormat()'><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('p_period_to',null,'hh:mm');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
	 <td  class=label ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
	 <td class=fields ><select name="p_order_category" id="p_order_category" onChange="FillOrderType(this);">
		<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(order_category.size()>0){
			for(int i=0;i<order_category.size();i++){
				String[] ordertype = (String[])order_category.get(i);
		%>
				<option value="<%=ordertype[0]%>"><%=ordertype[1]%></option>
				
		<%  }
		}%>
	</select>
	</td>
	<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_order_type_code" id="p_order_type_code" onChange="populateLocnActivityType()">
		<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select></td>	
</tr>
<tr>
	<td class='label' nowrap ><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class='fields'><input type="text" name="activity_type_desc" id="activity_type_desc" value="" onblur='callActivitySearch1(activity_type_desc,p_activity_type);'><input type=button name=ActSearch value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,p_activity_type);"><input type="hidden" name="p_activity_type" id="p_activity_type" value=""></td>
	<td class=label >
 <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
<td class=fields ><input type='text'  name='p_ord_catalog' id='p_ord_catalog' value='' maxlength='20' size="15" >
				<select name="P_CAT_FILTER_CRITERIA" id="P_CAT_FILTER_CRITERIA">
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select>
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
	    <td class='fields' >
		  <input type="text" name="ordering_pract_desc" id="ordering_pract_desc" value="" onblur='orderingpractSearch1(ordering_pract_desc,p_ord_pract_id);'><input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="orderingpractSearch(ordering_pract_desc,p_ord_pract_id);">
		  <input type="hidden" name="p_ord_pract_id" id="p_ord_pract_id" value="">
		</td>
<td class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_priority" id="p_priority">
						<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="S"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_order_by" id="p_order_by">
		<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value="C" selected><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
	</select></td>
</tr>
</table>
<input type="hidden" name="to_date" id="to_date" value="<%=curr_sys_date%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
<input type="hidden" name="p_report_id" id="p_report_id" value="ORORDTRK">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"> 
<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_id%>"> 
<input type="hidden" name="language_id" id="language_id" value="<%=localeName.toLowerCase()%>"> 
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<input type="hidden" name="prev_date" id="prev_date" value="<%=prev_date%>">
	<input type="hidden" name="isSiteSpecific" id="isSiteSpecific" value="<%=isSiteSpecific%>"> <!-- MMS-QH-CRF-0213 [IN055010] -->
	
	
	</form>
	
<% // added for MMS-QH-CRF-0213 [IN055010] - Start
	} catch(Exception ex){
		
	}
	finally{
		if(connection != null) connection.close();
	}
	// added for MMS-QH-CRF-0213 [IN055010] - End
%>
</body>
</html>

