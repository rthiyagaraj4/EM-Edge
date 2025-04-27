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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/11/2011    IN029659       Chowminya G    Incident No: IN029659 - < System allows to place the new orders using Copy Previous Order function- CRF Linked Issue> 
13/08/2013	  IN042045		 Chowminya G	System should not allow to copy for the drugs for which Verbal Order Applicable is not selected																														
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
19/03/2015  IN052649		Ramesh G										Previous orders - Default filter to be filtered by All or by specialty	 
27/07/2022	26826			Ramesh G										MMS-DM-CRF-0197 
31/05/2023		44884		Krishna		31/05/2023		Ramesh G 	MO-CRF-20183

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
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
	<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript"	src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	/* Mandatory checks start */
	String mode	   			= "1";// request.getParameter( "mode" ) ;

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id 				= request.getParameter( "function_id" ) ;
	String patient_id 				= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String patient_class 			= request.getParameter("patient_class");
	String pract_reln_id			= (String)request.getParameter("relationship_id");

	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String view_by					= request.getParameter("view_by");
	String order_type_desc		= request.getParameter("order_type_desc");
	String practitioner_type					= request.getParameter("practitioner_type");//IN042045
	bean.setLanguageId(localeName);

	bean_id					= (bean_id == null) ? "":bean_id.trim();
	bean_name				= (bean_name == null) ? "":bean_name.trim();
 	patient_id				= (patient_id == null) ? "":patient_id.trim();
 	function_id				= (function_id == null) ? "":function_id.trim();
 	encounter_id			= (encounter_id == null) ? "":encounter_id.trim();
 	patient_class			= (patient_class == null) ? "":patient_class.trim();
 	pract_reln_id			= (pract_reln_id == null) ? "":pract_reln_id.trim();
 	view_by					= (view_by == null) ? "L" : view_by.trim();
 	order_type_desc		= (order_type_desc == null) ? "" : order_type_desc.trim();

	//String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
	//String bean_name = "eOR.ExistingOrder";

	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id");
	String cur_encounter_id 	= encounter_id; //--[IN029659]
	String cur_patient_class 	= patient_class; //--[IN029659]
	resp_id					= (resp_id == null) ? "":resp_id.trim();
	practitioner_id			= (practitioner_id == null) ? "":practitioner_id.trim();
	facility_id				= (facility_id == null) ? "":facility_id;

//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");
	ArrayList Category_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();
/* Mandatory checks end */

	/*String[] allsess_vals = (String[])session.getValueNames();
	for(int i=0; i<allsess_vals.length; i++)
		out.println(allsess_vals[i]+" = ");*/


	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	// ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;



	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.clear() ;
	//bean.setMode( mode ) ;

	//String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("Sex"),"");
	String age						= bean.checkForNull(request.getParameter("Age"),"");
	String dob						= bean.checkForNull(request.getParameter("Dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");

	String date_from				= bean.checkForNull(request.getParameter("date_from"),"");
	String date_to					= bean.checkForNull(request.getParameter("date_to"),"");
	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type				= bean.checkForNull(request.getParameter("order_type"),"");
	String catalog					= bean.checkForNull(request.getParameter("catalog"),"");
	String clear					= bean.checkForNull(request.getParameter("clear"),"");
	Properties properties			= (Properties) session.getValue( "jdbc" );
//out.println("<script>alert('querystring="+request.getQueryString()+"')</script>");
	String pract_namefrom_db		= "";
	boolean canChangePractId		= true;
	int patient_id_length			= bean.getPatientIdLength(properties);
	String pract_idfrom_db			= "";
    String[] diag_code = bean.getDiagCode(properties);

    String curr_sys_date = "";
	//String curr_week_date  = "";
	//String last_week_date  = "";
	String last_month_date	= "";
	String copy_prev_order_from_date = (String) bean.getCopyPrevOrderFromDate(facility_id);
	if(!"0".equals(copy_prev_order_from_date)){
		date_from = copy_prev_order_from_date ;
	}
	try{
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){

	//	curr_week_date =  (String)sysdate.get(0);
	//	last_week_date =  (String)sysdate.get(1);
	//	curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();
	//	last_month_date = (String)sysdate.get(3);
		curr_sys_date	= (String)sysdate.get(0);
		last_month_date = (String)sysdate.get(4);

		//out.println("<script>alert('last_week_date="+last_week_date+"')</script>");
	}
	} catch (Exception e) {
		out.println("<script>alert('here:"+e.getMessage()+"')</script>");
	}
     curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);

    String  temp_last_month_date=last_month_date;
    String temp_curr_sys_date=curr_sys_date;
    //IN052649 Start.
	ArrayList orderingSpecialityDtl = (ArrayList)bean.getOrderingSpecialityType(facility_id,practitioner_id,cur_encounter_id);
	String	orderingspecialitycopypreviousorder=(String)orderingSpecialityDtl.get(0);
	String primarySpecialityCode = (String)orderingSpecialityDtl.get(1);
	String PrimarySpecialityDesc = (String)orderingSpecialityDtl.get(2);
	String currentEncSpecialityCode = (String)orderingSpecialityDtl.get(3);
	String currentEncSpecialityDesc = (String)orderingSpecialityDtl.get(4);
	String specialityCode ="";
	String specialityDesc ="";
	if("A".equals(orderingspecialitycopypreviousorder)){
		specialityCode ="";
		specialityDesc ="";
	}else if("P".equals(orderingspecialitycopypreviousorder)){
		specialityCode =primarySpecialityCode;
		specialityDesc =PrimarySpecialityDesc;
	}else if("E".equals(orderingspecialitycopypreviousorder)){
		specialityCode =currentEncSpecialityCode;
		specialityDesc =currentEncSpecialityDesc;
	}
	//IN052649 End.
/* Initialize Function specific end */
//26826 Start
HashMap  dxChkBfrPlaceOrderMap=new HashMap();
try{	
	dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patient_id,encounter_id,patient_class,facility_id,"");
}catch(Exception e)
{
	e.printStackTrace();				
}
// 26826  End.
// 44884 Start
	String practitionerRel=bean.getPractitionerRelation(practitioner_id,patient_id);
	HashMap restrictedNewOrdersSF=bean.restrictedNewOrdersSF(practitioner_id,practitionerRel,"");

//  44884 End.
%>
<body  onload="FocusFirstElement();populateCopyOrdersSearchValues('patient_class');populateCopyLocation(document.copy_orders_search.location_type);fillDefaultVals('<%=order_category%>','<%=order_type%>','<%=order_type_desc%>');populateCopyValues('<%=clear%>');populateCopyOrdersSearchValues('ord_cat')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="copy_orders_search" id="copy_orders_search" target="messageFrame" >

<table cellpadding="3" cellspacing="0" border="0" width="100%" align="center">


	<tr>
		<TD class="label" width="23%" nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></TD>
 		<TD class="fields" width="23%"  ><Select name="patient_class" id="patient_class"><Option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option></Select></TD>

       <td class="label" width="23%" nowrap><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class="fields" width="31%"  ><!--ADDED NEW LOOK UP  --> <input type="text" name="practitioner_desc" id="practitioner_desc" value="<%=pract_namefrom_db%>" size="14" maxlength="40" onFocus=""  readonly ><%if(canChangePractId){%><input type="button" name="practitioner_button" id="practitioner_button" class="button"   value="?" onClick="show_practitioner_window(document.getElementById('practitioner_desc'))">
		<input type="hidden" name="practitioner" id="practitioner" value="<%=pract_idfrom_db%>" size="30" maxlength="40" >
		<%}%></td>
	</tr>
	

		<tr>

		 <td class="label" width="23%" nowrap ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class="fields" width="23%"><SELECT name="order_category" id="order_category" onChange="populateCopyOrdersSearchValues('ord_cat');clearFields('CopyOrders');">  <!--onChange='populateOrderTyoes(this)'-->
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option>
		<%
			try{
				Category_Data = bean.getAllOrderCategory(properties);
				String[] record = null;

				for(int i=0; i<Category_Data.size(); i++){
					record = (String [])Category_Data.get(i);

					

		%>
				
		<option value="<%=record[0]%>"><%=record[1]%></Option>
		<%
				}
			}catch(Exception e){
				out.println(e);
			}
		%>
			</SELECT></td>
		<td class="label" width="23%"  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class="fields" width="31%"><input type='hidden' name='order_type' id='order_type' value=""><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="" onBlur="populateordertypeSearch(order_type_desc,order_type,'CopyOrders');"  maxlength='' ><input type="button" name="ordertypesearch" id="ordertypesearch" value='?'  class="button" tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'CopyOrders');"><!-- <SELECT name="order_type" id="order_type" onchange="populateCopyOrdersSearchValues('order_type')"> -->
				<!--  <option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</Option> -->
		<%
			/*try{
				String ord_cat = "";
				String[] record = null;
				OrderType_Data = bean.getOrderTypeData(properties, ord_cat);

				for(int i=0; i<OrderType_Data.size(); i++){
					record = (String [])OrderType_Data.get(i);
           */
		%>
			
		<%
				/*}
			}catch(Exception e){
				out.println("here : "+e);
			}*/
		%>
	<!-- 		</SELECT> --></td>
		</tr>
		<tr>
			<td class="label"  width="23%" nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class="fields" width="23%"><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type,'CopyOrders');"  maxlength='' ><input type="button" name=search value='?'  class="button" tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'CopyOrders');"></td>
		<%--<TD class="label"  nowrap>Diagnosis</TD>
		<TD colspan='3' id='diag_td'><input type='checkbox' value='N' onClick='chkDiagnosys(this)' name='diag_chk' id='diag_chk'></TD>--%>

		<%--<TD class="label" id='diag_button_td'>&nbsp;</TD>--%> <!-- onClick="showAllDiagnosisWindow('<%=diag_code[0]%>','<%=diag_code[1]%>')"-->
		<%--<td class="label" align="right">Occurrance</td>
		<TD class="label" align="left" id='occurance_td'>&nbsp;<Input type="text" name='occurrance' id='occurrance' size="3" maxlength="3" value="2" onKeyPress="return(ChkNumberInput(this,event,'0'))"></TD>--%>
		<td class="label" width="23%" nowrap><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td  class="fields" width="31%"><input type="text" name="catalog" id="catalog" value="<%=catalog%>" size="20" maxlength="40"></td>
	</tr>

	<tr>

		<td class="label" width="23%" nowrap><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<td class="fields" width="23%"><input type="text" name="date_from" id="date_from" value="<%=(date_from.equals("")?last_month_date:date_from)%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress="return OrAllowDateFormat()" nowrap><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer' nowrap></img>-<input type="text" name="date_to" id="date_to" value="<%=(date_to.equals(""))?curr_sys_date:date_to%>" size="10" maxlength="10" onBlur="checkDateRange(this,'copy_orders_search','DMY','<%=localeName%>')" onKeyPress="return OrAllowDateFormat()" nowrap><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer' nowrap><img src="../../eCommon/images/mandatory.gif"></img></td> 

		<TD class=label width="23%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<td class="fields" width="31%"><SELECT name="location_type" id="location_type" onChange='populateCopyLocation(this)'>
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		</SELECT><input type='text' name='locn_code' id='locn_code' value="" onBlur='populateMvLoaction(locn_code,locn)'  size="10" maxlength='' disabled><input type=button id='location_lookup' name=search value='?'  class=button onClick="populateMoveLoaction(locn_code,locn)" disabled><input type="hidden" name="locn" id="locn" value="">
		</td>


		
	</TR>
		
		<tr>

        <td  class="label"  nowrap width="23%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class="fields"  nowrap id='patient_id_td' width="23%"><input type="text"  name="patientId" id="patientId" value="<%=patient_id%>" onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this)"  size="20" maxlength="<%=patient_id_length%>" ><input align="right" type="button" name="search" id="search" value="?"  class="button" tabIndex="4" onClick="callPatientSearch()">
		</td>



			<td class="label"  nowrap width="23%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class="fields" width="31%"><input type="text" name="encounter_id" id="encounter_id" value="" size="12" maxlength="12" onKeyPress="return(ChkNumberInput(this,event,'0'))">
		</td>
	</tr>

 	
	<tr>
		<td class=label  nowrap width="23%"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td width="23%"><SELECT name="search_criteria" id="search_criteria">
				<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<!-- IN052649 Start -->
	<%if("N".equals(orderingspecialitycopypreviousorder)){ %>	
		<td   align="right" colspan='2'>
		<input type="hidden" name="OrderingSpecialityCopyPreviousOrder" id="OrderingSpecialityCopyPreviousOrder" value="<%=orderingspecialitycopypreviousorder %>">
		<input type="hidden" name="speciality_code" id="speciality_code" value="">
		<input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  onClick='populateCopyValues()'><input type="button" name="clear" id="clear" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearCopySearchValues()'></td>   <!--onClick='populateValues()' onClick='clearValues()'-->
	
	<%}else{%>
		<td class=label  nowrap width="23%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="15%">
						<Select name='OrderingSpecialityCopyPreviousOrder' id='OrderingSpecialityCopyPreviousOrder' onChange="specialityOnChange();">	
							<Option value='A' <%if(orderingspecialitycopypreviousorder.equals("A")) {out.println("selected");}%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></Option>
							<Option value='P' <%if(orderingspecialitycopypreviousorder.equals("P")) {out.println("selected");}%>><fmt:message key="eOR.primaryspeciality.label" bundle="${or_labels}"/></Option>
							<Option value='E' <%if(orderingspecialitycopypreviousorder.equals("E")) {out.println("selected");}%>><fmt:message key="eOR.encounterspeciality.label" bundle="${or_labels}"/></Option>
						</Select>
						<input type='text' name='speciality_desc' id='speciality_desc' value="<%=specialityDesc %>" onBlur='populateSpecialityOnBlur(speciality_code,speciality_desc)'  size='13' maxlength='20'>
						<input type=button id='speciality_lookup' name=search value='?'  class=button onClick="populateSpeciality(speciality_code,speciality_desc)">
						<input type="hidden" name="speciality_code" id="speciality_code" value="<%=specialityCode %>">
					</td>
					<td width="7%" align="right">
						<input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  onClick='populateCopyValues()'><input type="button" name="clear" id="clear" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearCopySearchValues()'>
					</td>
				</tr>
			</table>		
		</td>		
	<%} %>
	<!-- IN052649 End -->
	</tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="prac_sql" id="prac_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP")%>">
<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">

<input type=hidden name='encntr_id' id='encntr_id' value='<%=encounter_id%>'>
<input type=hidden name='cur_encounter_id' id='cur_encounter_id' value='<%=cur_encounter_id%>'> <!--[IN029659]-->
<input type=hidden name='cur_patient_class' id='cur_patient_class' value='<%=cur_patient_class%>'> <!--[IN029659]-->
<input type=hidden name='pract_reln_id' id='pract_reln_id' value='<%=pract_reln_id%>'>

<input type=hidden name='location_code' id='location_code' value='<%=location_code%>'>
<input type=hidden name='pat_class' id='pat_class' value='<%=patient_class%>'>
<input type=hidden name='p_called_from_ca' id='p_called_from_ca' value='<%=p_called_from_ca%>'>
<input type='hidden' name='pat_id' id='pat_id' value='<%=patient_id%>'>
<input type=hidden name='sex' id='sex' value='<%=sex%>'>
<input type=hidden name='age' id='age' value='<%=age%>'>
<input type=hidden name='dob' id='dob' value='<%=dob%>'>
<input type=hidden name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
<input type='hidden' name='view_by' id='view_by' value='<%=view_by%>'>
<input type='hidden' name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'><!-- IN042045 -->

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_last_month_date" id="temp_last_month_date" value="<%=temp_last_month_date %>">
<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">
<input type="hidden" name="querystring" id="querystring" value="<%=request.getQueryString()%>">

<!-- IN052649 Start -->
<input type="hidden" name="primarySpecialityCode" id="primarySpecialityCode" value="<%=primarySpecialityCode%>">
<input type="hidden" name="PrimarySpecialityDesc" id="PrimarySpecialityDesc" value="<%=PrimarySpecialityDesc%>">
<input type="hidden" name="currentEncSpecialityCode" id="currentEncSpecialityCode" value="<%=currentEncSpecialityCode%>">
<input type="hidden" name="currentEncSpecialityDesc" id="currentEncSpecialityDesc" value="<%=currentEncSpecialityDesc%>">
<input type="hidden" name="speciality_sql" id="speciality_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_AM_SPECIALITY_LOOKUP")%>">

<input type="hidden" name ="dxChkBfrPlaceOrderSpec" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderMI" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderOT" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderCN" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderLB" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderTR" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderPC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderPH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderNC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderDS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderRX" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderRD" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderCS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")%>"> <!-- 26826 -->
<input type="hidden" name ="dxChkBfrPlaceOrderOH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")%>"> <!-- 26826 -->
<!-- IN052649 End -->
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
</body>
</html>

<%
	//putObjectInBean(bean_id,bean,request);

%>

