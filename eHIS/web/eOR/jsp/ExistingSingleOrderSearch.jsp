<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
21/06/2013    IN041068    ChowminyaG  System does not refresh �one day and continue order� screen
17/12/2020	11330		Sivabagyam M		17/12/2020		Ramesh G	SKR-SCF-1518 
28/02/2022      IN27707         Suji Keerthi.G      28/02/2022      Ramesh G        SKR-CRF-0052  
-----------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
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
	<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingSingleOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
  	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
 	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		async function change_common_tab(obj)
		{ 
			if( (obj=="NewOrders"))
			{
				var retVal 			= 	new String();
				var dialogHeight 	= "95vh" ;
				var dialogWidth  	= "98vw" ;
				var dialogTop    	= "80";
				var status 			= "no";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
				retVal = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?<%=request.getQueryString()%>&p_called_from_ca =Y&function_id=CONT&option_id=NEW_ORDERR&patient_id="+document.getElementById("patientId").value,arguments,features);
				parent.document.location.reload();//IN041068
			}
			else if(obj == "Allergies")
			{
				var retVal 			= 	new String();
				var dialogHeight 	= "95vh" ;
				var dialogWidth  	= "98vw" ;
				var dialogTop    	= "80";
				var status 			= "no";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
				retVal = await top.window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+document.getElementById("patientId").value,arguments,features);
			}	
			else if(obj == "PharmacyOrders")
			{
				var retVal 			= 	new String();
				var dialogHeight 	= "95vh" ;
				var dialogWidth  	= "98vw" ;
				var dialogTop    	= "80";
				var status 			= "no";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
				retVal =await  top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?<%=request.getQueryString()%>&p_called_from_ca=Y&function_id=PH&p_scope=PH&option_id=PH_ORDER&patient_id="+document.getElementById("patientId").value,arguments,features);
				parent.document.location.reload();//IN041068
			}
		}


	</script>
</head>
<body  onload='FocusFirstElement();disableActivity()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 //IN27707 Starts
	Connection con			= null;
	boolean isDfltOrderSts = false;
	try {	
		con				= ConnectionManager.getConnection(request);
		isDfltOrderSts = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","DEFAULT_ORDER_STATUS");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally{ 	
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
	//IN27707 Ends
	
	String mode	   = "1";// request.getParameter( "mode" ) ;
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	String pract_reln_id = (String)request.getParameter("pract_reln_id");
	
	String function_from = (String)request.getParameter("function_from");
	String existing_order_called_from = (String)request.getParameter("function_from")==null?"":(String)request.getParameter("function_from");
	String multi_called_from = (String)request.getParameter("multi_called_from")==null?"":(String)request.getParameter("multi_called_from");
	String include_checkout_patients = (String)request.getParameter("include_checkout_patients")==null?"":(String)request.getParameter("include_checkout_patients");
	if(function_from==null) function_from = "";
 	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
	String bean_name	= "eOR.ExistingOrder";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";
	Properties properties	= (Properties) session.getValue( "jdbc" );

	ArrayList Category_Data = new ArrayList();
	
	if(patient_id!=null)	patient_id = patient_id.trim();		else patient_id = "";
	if(encounter_id!=null)	encounter_id = encounter_id.trim();	else encounter_id = "";
	if(patient_class==null || patient_class=="null" || patient_class.equals("null")) patient_class = "";
	if(patient_class!=null)	patient_class = patient_class.trim();		else patient_class = "";

	bean.setLanguageId(localeName);

	ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	beanObj.setLanguageId(localeName);
	beanObj.setFunctionId(beanObj.checkForNull(request.getParameter("function_id")));

	beanObj.clear() ;
	beanObj.setMode( mode ) ;
    beanObj.setExistingQueryString(request.getQueryString());
	int activeAllergydtls = 0;
	activeAllergydtls = beanObj.getActiveAllergyDetails(patient_id); 
	
	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("Sex"),"");
	String age						= bean.checkForNull(request.getParameter("Age"),"");
	String dob						= bean.checkForNull(request.getParameter("Dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");
	String curr_sys_date			= "";
	String last_month_date			= "";
	String sys_time_sec				= "";
	String next_week_date = "";
	String after_three_days="",last_week_date="";//11330
	// Get the date Sysdate and one month backward date
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);

	//for(int i=0;i<sysdate.size();i++){ //COMMENTED AFTER 11330 
		curr_sys_date	= (String)sysdate.get(0);
		last_month_date = (String)sysdate.get(4);
		sys_time_sec	 = (String)sysdate.get(5);
		next_week_date = (String)sysdate.get(3);
		after_three_days=(String)sysdate.get(6);//11330
		last_week_date=(String)sysdate.get(1);//11330
		//curr_sys_date	= (String)sysdate.get(2);
		//last_month_date = (String)sysdate.get(3);

	//}
	
	if(visit_adm_date == null || visit_adm_date.equals("null"))
		visit_adm_date = "";

    if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";
	if(last_month_date.equals("null") || last_month_date.equals(" ")) last_month_date="";
	if(next_week_date.equals("null") || next_week_date.equals(" ")) next_week_date="";
	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";//11330
	if(after_three_days.equals("null") || after_three_days.equals(" ")) after_three_days="";//11330

    curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);
	next_week_date = com.ehis.util.DateUtils.convertDate(next_week_date,"DMY","en",localeName);
	after_three_days = com.ehis.util.DateUtils.convertDate(after_three_days,"DMY","en",localeName);//11330
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);//11330

 String  temp_last_month_date=last_month_date;
 String temp_curr_sys_date=curr_sys_date;
 String  temp_next_week_date=next_week_date;
 //IN27707 Starts
 String def_order_check_all="",def_order_check_act="";
 String order_status_check = bean.getOrderStatusType(); 
 if(order_status_check.equals("ALL")){
	 def_order_check_all ="selected"; 
 }
 else {
	 def_order_check_act ="selected";
 }
//IN27707 Ends
/* Initialize Function specific end */

%>

<form name='existing_order_search' id='existing_order_search' target='messageFrame' >
<input type="hidden" name="patientId" id="patientId" value="<%=patient_id%>">
<input type="hidden" name="encntr_id" id="encntr_id" value="<%=encounter_id%>">

<table cellpadding=3 cellspacing=0 width="100%" border="0" align=center id='detailTable'>
<%
 if(function_from!=null && function_from.equals("PASSED_ORDERS")||multi_called_from.equals("MULTI_PATIENT_ORDER"))
 {
 %>
	<tr>
		<td colspan="4">
			<a href="#" onclick="callMultiPatientOrders()"><B><fmt:message key="eOR.BackToMultiPatientOrders.label" bundle="${or_labels}"/></B></a>
		</td>
	</tr>
	<%
	}
	%>
	<tr >
		<td width='10%'class=label nowrap><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
		<td width='20%'class="fields"><SELECT name="view" id="view">
			<% if ( (patient_class!=null && !patient_class.equals("") && !patient_class.equals("XT"))) 
			{ 
				if(function_from.equals("PASSED_ORDERS")&&multi_called_from.equals("MULTI_PATIENT_ORDER"))
				{
				}
				else
				{
				%> 
					<option value='C'><fmt:message key="eOR.CurrentEncounterOrders.label" bundle="${or_labels}"/>  </option>
				<%
				}
			}
			%>
				<option value='A'><fmt:message key="Common.AllOrders.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		
		<td class=label width='10%' nowrap align='left'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class="fields" width='20%'><SELECT name="ord_status" id="ord_status" onChange='displayLegendForButton(this)'>
		<!--IN27707 Starts-->
		<% 
		if(isDfltOrderSts){ %>
		    <option value='Z' <%=def_order_check_all%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='OA' <%=def_order_check_act%>><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
		
		<% }else{ %>
			<option value='Z' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> <!--11330-->
			<!-- <option value='P'><fmt:message key="Common.PendingforReviews.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>-->
			<option value='OA' selected ><fmt:message key="Common.active.label" bundle="${common_labels}"/></option><!--11330-->
			<!--<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
			<option value='D'><fmt:message key="eOR.DiscontinuedCancelled.label" bundle="${or_labels}"/></option>
			<option value='H'><fmt:message key="Common.Hold.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/></option>-->
			<%} %>
			<!--IN27707 Ends-->
			</SELECT><span id="displayOrders" nowrap align="left" style="display:none"><fmt:message key="eOR.ElapsedOrders.label"bundle="${or_labels}"/><input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'></span>
		</td>
		<td width='20%'></td>
		<td width='20%' class='fields' nowrap align='right'><input type=button class=button name='NewOrders' id='NewOrders'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NewOrders.label","common_labels")%>'  onClick='change_common_tab("NewOrders")'><input type=button name='PharmacyOrders' id='PharmacyOrders' class=button  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orders.label","common_labels")%>' onClick='change_common_tab("PharmacyOrders")'><input type='button' class=button name='Allergies' id='Allergies'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")%>'<%if(activeAllergydtls>0){out.println("style='background-color:RED'");}%> onClick='change_common_tab("Allergies")'></td>
		</tr>
		<tr style="display:none">
		<td class=label  ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<!--<td class="fields"><SELECT name="order_category" id="order_category" onChange="clearFields('ExistingOrder');">
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%
			try
		   {
				Category_Data = bean.getAllOrderCategory(properties);
				String[] record = null;
				for(int i=0; i<Category_Data.size(); i++)
				{
					record = (String [])Category_Data.get(i);
				%>
					<option value=<%=record[0]%> ><%=record[1]%>
				<%
				}
			}catch(Exception e)
			{
			//	out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181

			}
		%>
			</SELECT></td>-->

		<td class=label  nowrap style="display:none"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class="fields" style="display:none"><input type='hidden' name='order_type' id='order_type' value=""><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="" onBlur="populateordertypeSearch(order_type_desc,order_type,'ExistingOrder');"  maxlength='' ><input type="button" name="ordertypesearch" id="ordertypesearch" value='?'  class="button" tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'ExistingOrder');"></td> 
     
	</tr>
	<tr style="display:none">
			<td class=label nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/> </td>
			<td class="fields" ><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type,'ExistingOrder');"  maxlength='' ><input type="button" name=search value='?'  class="button" tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'ExistingOrder');"></td>

			<td class=label nowrap><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name='catalog' id='catalog' value='' size="22" maxlength="40" onKeyPress="callSearch()">
			<SELECT name="search_criteria" id="search_criteria">
				<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>		
	</tr>
	<tr>
<!-- 		<td class=label align='right'>Cosign</td>
		<td>&nbsp;<SELECT name="cosign" id="cosign">
				<option value='N'>Not Applicable</option>
				<option value='P'>Pending</option>
				<option value='D'>Done</option>
			</SELECT>
		</td> -->
		<input type=hidden name='cosign' id='cosign' value="N">
		<td class=label ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<%-- <td class="fields" nowrap><input type="text" name="date_from" id="date_from" value="<%=last_month_date%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>-<input type=text name='date_to' id='date_to' value="<%=next_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'existing_order_search')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'></td> <!--11330--> --%>
		<td class="fields" nowrap><input type="text" name="date_from" id="date_from" value="<%=last_week_date%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>-<input type=text name='date_to' id='date_to' value="<%=after_three_days%>" size="10" maxlength="10" onBlur="checkDateRange(this,'existing_order_search')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'></td> <!--11330-->
		
		<td  class='label' nowrap style="display:none"> <fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class="fields" style="display:none"><SELECT name="priority" id="priority">
				<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td></td>
		<td colspan=2 align='left' >
				<input type=button class=button name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='populateValues("SEARCH")'><input type=button name='clear' id='clear' class=button  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'><input type='hidden' class=button name='print' id='print'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick='printValues()'><% if(p_called_from_ca!=null && !p_called_from_ca.equals("PASSED_ORDERS")){%><input type='hidden' class=button name='copyorders' id='copyorders' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CopyPreviousOrders.label","or_labels")%>' onClick='callCopyPreviousOrders()'><%}%><input type='hidden' name='copyorders_btn_type' id='copyorders_btn_type' value='C'></td><!--Modified for IN27707-->
		
	</tr>
	<tr style="display:none">
		<td class=label nowrap><fmt:message key="eOR.ViewOrderBy.label" bundle="${or_labels}"/></td>
		<td class="fields"><SELECT name="view_by" id="view_by" onchange='disableActivity()'>
		<option value='H'><fmt:message key="Common.Header.label" bundle="${common_labels}"/></option>
		<option value='L' <%if(patient_class.equals("IP") || patient_class.equals("EA")) out.println(" selected ");%>><fmt:message key="Common.Line.label" bundle="${common_labels}"/></option>
		</SELECT></td>

		<td class=label ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class="fields"><SELECT name="order_by" id="order_by">
		<option value='D'><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
		<option value='O'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
		<option value='T'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
		</SELECT></td>
		
		
	</tr>
	<!-- Menaka Starts -->
	<tr style="display:none">
		<td class=label nowrap><fmt:message key="eOR.OrderFrequency.label" bundle="${or_labels}"/></td>
		<td class="fields"><SELECT name="order_frequency" id="order_frequency">
		<option value='A'><fmt:message key="eOR.All.label" bundle="${or_labels}"/></option>
		<option value='SO'><fmt:message key="eOR.SingleOrder.label" bundle="${or_labels}"/></option>
		<option value='CO'><fmt:message key="eOR.ContinuousOrder.label" bundle="${or_labels}"/></option>
		</SELECT></td>

		<td class=label ><fmt:message key="eOR.GroupBy.label" bundle="${or_labels}"/></td>
		<td class="fields"><SELECT name="group_by" id="group_by">
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='D'><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></option>
		<option value='O'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
		<option value='T'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
		</SELECT></td>
	</tr>
	<!-- Menaka Ends -->
	<tr><%//bean.getSysDate()%>
	<td colspan=1 ><td>
		<td class='label'style="display:none"> <fmt:message key="Common.Ason.label" bundle="${common_labels}"/> <B><%=sys_time_sec%></B></td>
		
		
		<td colspan=2 align='center' >
				<input type='hidden' class=button name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='populateValues()'><input type='hidden' name='clear' id='clear' class=button  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'><input type='hidden' class=button name='print' id='print'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick='printValues()'><% if(p_called_from_ca!=null && !p_called_from_ca.equals("PASSED_ORDERS")){%><input type='hidden' class=button name='copyorders' id='copyorders' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CopyPreviousOrders.label","or_labels")%>' onClick='callCopyPreviousOrders()'><%}%><input type='hidden' name='copyorders_btn_type' id='copyorders_btn_type' value='C'></td>

	</tr>

</table>
<%
if(!imgUrl.equals(""))
{
%>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%
}
%>

<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>

<input type=hidden name='pract_reln_id' id='pract_reln_id' value='<%=pract_reln_id%>'>
<input type=hidden name='location_type' id='location_type' value='<%=location_type%>'>
<input type=hidden name='location_code' id='location_code' value='<%=location_code%>'>
<input type=hidden name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type=hidden name='p_called_from_ca' id='p_called_from_ca' value='<%=p_called_from_ca%>'>
<input type=hidden name='sex' id='sex' value='<%=sex%>'>
<input type=hidden name='age' id='age' value='<%=age%>'>
<input type=hidden name='dob' id='dob' value='<%=dob%>'>
<input type=hidden name='visit_adm_date' id='visit_adm_date' value='<%=visit_adm_date%>'>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<Input type='hidden' name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
<Input type='hidden' name='function_from' id='function_from' value='<%=function_from%>'>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<input type="hidden" name="temp_last_month_date" id="temp_last_month_date" value="<%=temp_last_month_date %>">
<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">
<input type="hidden" name="temp_next_week_date" id="temp_next_week_date" value="<%=temp_next_week_date %>">
<input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>">

<input type="hidden" name="existing_order_called_from" id="existing_order_called_from" value="<%= existing_order_called_from %>">
<input type="hidden" name="multi_called_from" id="multi_called_from" value="<%= multi_called_from %>">

<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="order_category" id="order_category" value="">

</form>

</body>
</html>
<%	
if((request.getParameter("function_from")) != null && 				request.getParameter("function_from").equals("CHART_SUMMARY"))
		out.println("<script>populateValues()</script>");
 if(function_from!=null && function_from.equals("PASSED_ORDERS")) 
{ 
%>
	<input type="hidden" name='queryString' id='queryString' value="<%=request.getQueryString()%>" >
<%
} 	
	putObjectInBean(bean_id,beanObj,request);
%>
<SCRIPT>
	populateValues('LOAD'); //Modified for IN27707
</SCRIPT>

