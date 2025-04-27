
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------
Date       	Edit History   	Name        Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------
?           100         	?           							created
24/12/2015	IN058704		Karthi L								MMOH-SCF-0323 - IN058704
31/05/2023		44884		Krishna		31/05/2023		Ramesh G 	MO-CRF-20183
--------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head><title><fmt:message key="eOR.OrderEntryExternalOrder.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" 	src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->

	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExternalOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "Or_ExternalOrders" ;
	String bean_name = "eOR.ExternalOrdersBean";
	//String strOrdCat = "";
	String patient_class = "XT"; // For external orders
	String qryString	= request.getQueryString();
	String patientId	= request.getParameter("patientId");
	String patient_details	= request.getParameter("patient_details")==null?"": request.getParameter("patient_details");
	//IN039587 Starts
	String sex = 	request.getParameter("Sex")==null?"": request.getParameter("Sex");
	String Age = 	request.getParameter("Age")==null?"": request.getParameter("Age");
	String dob = 	request.getParameter("Dob")==null?"": request.getParameter("Dob"); //added for MMOH-SCF-0323 - IN058704
	//IN039587 Ends
	//System.out.println("qryStringqryString==="+qryString);
 	/*Calendar calendar = new GregorianCalendar();
	String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	int dat = Integer.parseInt(date);
	if(dat<10)
		date = "0"+date;
	String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
	int mon = Integer.parseInt(month);
	if(mon<10)
		month = "0"+month;
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String hour = String.valueOf(calendar.get(Calendar.HOUR));
	int h = Integer.parseInt(hour);
	if(h < 10)
	    hour = "0"+hour;
	String minute = String.valueOf(calendar.get(Calendar.MINUTE));
	int min = Integer.parseInt(minute);
	if(min < 10)
	    minute = "0"+minute;

	String currDate = date +"/"+ month + "/" + year + " " + hour + ":" + minute;
	*/
	//ExternalOrdersBean bean = (ExternalOrdersBean)mh.getBeanObject( bean_id, request,bean_name ) ;
	ExternalOrdersBean bean = (ExternalOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear();
	bean.setLanguageId(localeName);
	String currDate		= null;
	ArrayList sysdate	= (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++){
		currDate =  (String)sysdate.get(2);//bean.getSysDate();
 	}


	if(currDate.equals("null")) currDate="";
	
	if ( !localeName.equals("en") )
{ 

	currDate = com.ehis.util.DateUtils.convertDate(currDate,"DMYHM","en",localeName);
}
	sysdate			= null;   

//44884 Start.
String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
	String practitionerRel=bean.getPractitionerRelation(practitioner_id,patientId);
	HashMap restrictedNewOrdersSF=bean.restrictedNewOrdersSF(practitioner_id,practitionerRel,"EXTERNAL_ORDER");
	//44884 End.	

%>

<!--Onload='Clear(),populateList(),FocusFirstElement()-->
<style>
textarea {
  resize: none;
}
</style>
<body  Onload="//populateList()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formExternalOrders" id="formExternalOrders" target='' method ="post" action='../../eOR/jsp/ExternalOrdersCall.jsp'>
<table cellpadding='12' cellspacing=0 border='0' width="100%" height="92%" align="center">
<tr>
			<td  class='label' id='facility_id'  colspan="0" width='2%' nowrap><fmt:message key="Common.ReferralFacility.label" bundle="${common_labels}"/></td>
			<td class="fields" ><input type="text" name="facility_desc" id="facility_desc" maxlength='30' size='30' value="" onBlur='populateFacilityDesc(this)'><input type="button" class="button" name="facility_search" id="facility_search" value="?" onClick='populateFacility(facility_desc)'><input type="hidden" name="facility_code" id="facility_code" value=''>
			<td class='label' colspan=4></td>
</tr>
<tr>
			<td  class='label' id='practitioner_id'  colspan="0" width='2%' nowrap > <fmt:message key="eOR.ReferralPractitioner.label" bundle="${or_labels}"/></td>
			<td class='fields' tabIndex="4" colspan=2><SELECT name="practitionerId" id="practitionerId" onChange="getPractitionerName(this)"><option value=""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>
			</SELECT><input type='text'  name='practitionerName' id='practitionerName' value='' nowrap  size="30" maxLength="30"><!--<input align='right' class='button' type=button name=search value='?'  class=button tabIndex="5"
			onClick="practitioner_display(practitioner)">onBlur="onblur_pract_disp(this)"-->
			<img
			src="../../eCommon/images/mandatory.gif" align=center></td>
			<td class='label' colspan=3></td>
</tr>
<tr>
			<td  class='label' id='date_id'  colspan="0" width='2%' nowrap><fmt:message key="eOR.DateofRegistration.label" bundle="${or_labels}"/></td>
			<td class='fields' colspan=2 tabIndex="6"><input type='text'  id="Referral_id" 	name='Referral_date' id='Referral_date'  value="<%=currDate%>" maxlength="16" size="14"   onkeyPress='return CheckForNumsAndColon(event);return checkMaxLimit(this,16)' onBlur="chckDate(this,'<%=localeName%>','<%=currDate%>')"> <img src="../../eCommon/images/CommonCalendar.gif"
			onclick="return showCalendar('Referral_id',null,'hh:mm');" style='cursor:pointer'>
			<img src="../../eCommon/images/mandatory.gif" align=center>
			</td>
			<td class='label' colspan=3></td>
</tr>
<tr>
			<td  class='label' id=''  width='3%' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' height="20%"width="60%" tabIndex="6" colspan=5><textarea cols="65"   rows="5" name="remarks" id=""   onBlur="makeValidString( this );SPCheckMaxLen('Remarks',this,500,'')"  onkeyPress='return checkMaxLimit(this,500)' ></textarea>
			<img src="../../eCommon/images/mandatory.gif" align=center></td>
</tr>
<%
	ArrayList obj = (ArrayList) bean.getOrderCat();
	Vector shDesc =  new Vector();
	Vector ordCat =  new Vector();
%>
<tr>
	<td class='label' id='ord_cat' colspan="0" width='2%' nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class='fields' tabindex="7" nowrap colspan=3><select name="order_category" id="order_category" onchange="clearFields();">
			<option selected > ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>
			<%
				if(!obj.isEmpty())
				{
					shDesc = (Vector )obj.get(0); // vector for all short descriptions
					ordCat = (Vector )obj.get(1); // vector for all order categories
				}
						
				for(int i=0;i<shDesc.size();i++)
				{
		%>
				<option value="<%= ordCat.get(i) %>"><%= (String )shDesc.get(i) %> </option>
		<%
				}
	 	%>
		</select><img src="../../eCommon/images/mandatory.gif" align=center>
		<td class='label' nowrap>
		<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='hidden' name='order_type' id='order_type' value=""><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="" onBlur="populateordertypeSearch(order_type_desc,order_type);"  maxlength='' ><input type="button" name="ordertypesearch" id="ordertypesearch" value='?'  class="button" tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type);">
		 <!-- <select name="order_type" id="order_type" onchange="clearOrderable();populateActivityType(this)">
			<option selected > ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>
		</select> -->
</td>
	<!-- <td class='label' colspan=2></td> -->
</tr>
<tr>
<td class='label' nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
	<td class='fields' colspan="3"><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type);"  maxlength='' ><input type="button" name=search value='?'  class="button" tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type);"><!-- <select name="activity_type" id="activity_type">  
			<option selected > ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>
	</select> --></td>
	<td class='label' nowrap>
	<fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="orderable" id="orderable" value="" size="30" maxLength="40" onBlur='callOrderablesearch(orderable)'><input type='button' name='buttonOrderable' id='buttonOrderable' value='?' class='button' onClick='callOrderable(orderable)'>
	 <input type="hidden" name="ordercode" id="ordercode" value="">
	</td>
 <!-- <td class='label' colspan=2></td> -->
</tr>
<tr>
	<td  colspan=6 class='button' valign='bottom' tabIndex="7" align="right"><!--<INPUT TYPE='button'
	value='Previous Orders' class='button' onClick="PatientPendingOrders()">&nbsp;--><INPUT TYPE='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button'
	OnClick="Clear()"><INPUT TYPE='button'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PlaceOrder.label","common_labels")%>' class='button' onClick="PlaceOrder()"></td></tr>
</table>

<input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRACTITIONER_LOOKUP") %>">
<!--<input type='hidden' name='practitionerId' id='practitionerId' value=''>-->
<input type='hidden' name='function_from' id='function_from' value='EXTERNAL_ORDER'>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="qryString" id="qryString" value="<%=qryString%>">
<input type="hidden" name="patient_details" id="patient_details" value="<%=patient_details%>">
<input type="hidden" name="facility" id="facility" value="">
<input type="hidden" name="source_use_at_lb_ord_yn" id="source_use_at_lb_ord_yn" value="">
<input type="hidden" name="source_use_at_rd_ord_yn" id="source_use_at_rd_ord_yn" value="">
<input type="hidden" name="applicability_for_direct_ord" id="applicability_for_direct_ord" value="">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="tmplocale" id="tmplocale" value="<%=localeName%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=currDate%>">
<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="ref_facility_sql" id="ref_facility_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDERS_REFERRAL_LOOKUP")%>">
<!-- IN039587 Starts -->
<input type="hidden" name="Sex" id="Sex" value="<%=sex%>">
<input type="hidden" name="Age" id="Age" value="<%=Age%>">
<input type="hidden" name="Dob" id="Dob" value="<%=dob%>" <!--  added for MMOH-SCF-0323 - IN058704-->
<!-- IN039587 Ends -->

<!-- 44884 Start. -->
	<input type="hidden" name ="practitionerRel" value="<%=bean.checkForNull(practitionerRel,"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSMI" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSMI"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSOT" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOT"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSCN" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCN"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSLB" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSLB"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSTR" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSTR"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSPC" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSPH" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPH"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSNC" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSNC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSDS" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSDS"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSRX" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRX"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSRD" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRD"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSCS" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCS"),"N")%>">			
	<input type="hidden" name ="restBfrPlaceOrderSOH" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOH"),"N")%>">

	<input type="hidden" name ="restBfrPlaceOrderFMI" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFMI"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFOT" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOT"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFCN" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCN"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFLB" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFLB"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFTR" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFTR"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFPC" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFPH" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPH"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFNC" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFNC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFDS" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFDS"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFRX" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRX"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFRD" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRD"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFCS" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCS"),"N")%>">			
	<input type="hidden" name ="restBfrPlaceOrderFOH" value="<%=bean.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOH"),"N")%>">
	<!-- 44884 End. -->

</form>
</frame>

</body>
</html>


<%
	putObjectInBean(bean_id,bean,request);
%>

