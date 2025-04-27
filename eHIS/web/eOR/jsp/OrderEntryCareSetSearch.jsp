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
-----------------------------------------------------------------------
Date		Edit History  		    Name      		 Rev. Date	Rev. Name 	Description
-----------------------------------------------------------------------
?                   100                      ?          	    ?		   ?		 created
13/08/2013	  IN042045		 Chowminya G		    ?		   ?		 System should not allow to copy for the drugs for which Verbal Order Applicable is not selected		
30/10/2017	  IN061906		Kamalakannan G		30/10/2017	Ramesh G	 Added onchange careSetSearch() for populating the data while for orderset while changing the options
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
-----------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>

<%-- Mandatory declarations end --%>

<%!
    private String replace(String str ,String change ,String replace,String quotes){
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		if (quotes.equalsIgnoreCase("Y"))
			str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
		else if (quotes.equalsIgnoreCase("N"))
			str   = str.substring(0,t) + " " + replace.trim()+ " " + str.substring(t+1)  ;
		return str ;
	}
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id					= request.getParameter("patient_id");
	String encounter_id					= request.getParameter("encounter_id");
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");
	/*Added by Uma on 2/22/2010 for IN017231*/
	String function_from 			= request.getParameter("function_from")==null?"":request.getParameter("function_from");
	/*Ends Here IN017231*/
	String disableOrderCategory 		= "";
	String disableOrderType				= "";
	String care_set_order				= "";
	String care_set_value				= "";
	String disableField					= "";
	/* Mandatory checks end */
	/* Initialize Function specific	 start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		beanQueryObj.setLanguageId(localeName);
		OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* Initialize Function specific end */
	//Properties properties				= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	String ammend_called_from			= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_category				= "";
	if(bean.getOrderCategoryYn().equalsIgnoreCase("Y"))
				order_category 			= bean.checkForNull(bean.getOrderCategoryValue(),"");

    if(patient_id == null ) patient_id = "";
	if (encounter_id == null ) encounter_id = "";

	String sql_or_order_entry_diagnosis = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DIAGNOSIS");

    String sql_or_order_entry_pat_diagnosis = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_PAT_DIAG_CODE_SELECT");
	sql_or_order_entry_pat_diagnosis    =  replace(sql_or_order_entry_pat_diagnosis,"?",patient_id,"Y");
	sql_or_order_entry_pat_diagnosis    =  replace(sql_or_order_entry_pat_diagnosis,"?",encounter_id,"Y");
	if(bean.getPatientId().equals(""))
	{
		if(!patient_id.equals(""))
		{
			bean.setPatientId(patient_id); // set the Patient Id
			bean.setEncounterId(encounter_id);
		}
	}
	//[IN036868] Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//[IN036868] End.
	String key							= (bean.getPatientId()+bean.getEncounterId());
	String licence_key					= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	HashMap previousValues				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);

	String keyItems[]					= null;
	Set setValues 						= null;
	Iterator iterator 					= null;
	if(previousValues!=null)
	{
		setValues 						= previousValues.keySet();
		iterator 						= setValues.iterator();
		// At the most there will be only one record for the caresets
		for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		{
			String entryValue = ((String)iterator.next()) ;
			keyItems = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
			if( keyItems[0].equals("ck"))     // If it is a check Box
			{
				care_set_value = keyItems[1];
				care_set_order = (String)previousValues.get("h1"+keyItems[1]) ; // Get the Order category
				if(! (care_set_order.equalsIgnoreCase("CS") || care_set_order.equalsIgnoreCase("PH")))
					care_set_value 	= "";
				else
					disableField	= "DISABLED";
			}
		} // End of for
	} // End of if
	// Get the Diagnosis Code and Scheme
	String[] diag_code = bean.getDiagCode();	//There are two values..
	String[] record	   = null;
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
%>
<html>
<head><title><fmt:message key="eOR.OrderEntryCareSetSearch.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="careSetSearchForm" id="careSetSearchForm">
		<table cellpadding="3" cellspacing='0' border='0' width='100%' align="center">
		
		<tr>
			<td class='label'  nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
			<select name="order_category" id="order_category" onChange="allowNewOrders(this,'careSetSearchForm');"; <%=disableField%>>
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
				ArrayList OrderCategory = bean.getOrderCategory("ALL_ORDER");
				 for(int i=0; i<OrderCategory.size(); i++)
				 {
					record = (String[])OrderCategory.get(i);
 					if(ammend_called_from.equalsIgnoreCase("existing_order") || (bean.getOrderCategoryYn().equalsIgnoreCase("Y") && !bean.getOrderCategoryValue().equalsIgnoreCase("")))
						disableOrderCategory = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderCategory = "";
					if( (bean.getOrderCategoryValue().equalsIgnoreCase(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order") || bean.getOrderCategoryYn().equals("Y") ))  || (licence_key.equals("ORPV")) )
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\" > "+record[1]+"");
					record = null;
				 }
				OrderCategory = null;
%>			</select> 
<%
				if(bean.getOrderCategoryYn().equals("Y"))
					out.println("<img src=\"../../eCommon/images/mandatory.gif\"></img>");
%>
			</td>
			<td class='label' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class="fields" nowrap><input type='hidden' name='order_type' id='order_type' value=""><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="" onBlur="populateordertypeSearch(order_type_desc,order_type,'careSetSearchForm');clearactivityvalues('careSetSearchForm');"  maxlength='' ><input type=button name="ordertypesearch" id="ordertypesearch" value='?'  class=button tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'careSetSearchForm');">			
			<img src="../../eCommon/images/mandatory.gif" id="order_type_mand" style="visibility:hidden"></img> 
			</td>
		</tr>
		<tr>

			<td class="label" ><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
			<td class="fields" ><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type,'careSetSearchForm');"  maxlength='' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'careSetSearchForm');">
			</td>
			<td class='label' ><fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/></td>
			<!-- IN061906 start --><td class='fields' >	<select name="care_sets" id="care_sets" <%=disableField%> onChange="checkOrderSet(this);"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><!-- IN061906 end --><!--IN069027 added onchange method checkOrderSet -->
			<%
				ArrayList CareSets =	null;
				if(bean.getOrderCategoryYn().equals("N")) // If order category for presel_order_category_yn is "N"
				{
					CareSets = bean.getCareSets("","","","",""); // First Type OrderCategory is passed as '' to populate all and second parameter is diagnosis, pass it as '' for all and third one for activity_type passed it as ''
					for(int i=0; i<CareSets.size(); i++)
					{
						record = (String[])CareSets.get(i);
						if(care_set_value.equals(record[0]))
							out.println("<option value = \""+record[0]+"::"+record[2]+"\" selected> "+record[1]+"");
						else
							out.println("<option value = \""+record[0]+"::"+record[2]+"\"> "+record[1]+"");
						record	= null;
					}
					CareSets = null;
				}
%>		</select>
			<img src="../../eCommon/images/mandatory.gif"></img>
			</td>
</tr>
			<td class='label'  nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
			<td  class="fields" id="diagnosis_id" colspan="4">
				<select name="diagnosis" id="diagnosis" onChange="clearOrderable(this);" <%=disableField%>><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<option value="P"><fmt:message key="Common.PatientSpecific.label" bundle="${common_labels}"/>
				<%--<option value="D">Patient/Diagnosis--%></select>
				<select name="diag_code_scheme" id="diag_code_scheme" onChange="clearOrderable(this);">
		<%
			ArrayList Diag_scheme =	null;
			String diag_scheme_value="ICD10";
			Diag_scheme = bean.getDiagScheme();
			for(int i=0; i<Diag_scheme.size(); i++)
			{
					record = (String[])Diag_scheme.get(i);
					if(diag_scheme_value.equals(record[0]))
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record	= null;
			}
			Diag_scheme = null;
			%></select><input type="text" name="orderable_text" id="orderable_text" value = "" size="20" maxlength="20" DISABLED onChange="specific.click()"><input type="button" class="button" name="specific" id="specific" value="?" onClick="showDiagnosis(this,'<%=diag_code[0]%>','<%=diag_code[1]%>')" <%=disableField%>>
				<input type="hidden" name="orderable_text_id" id="orderable_text_id" value = "">
			</td>
			
		</tr>
		<tr>
			<td class="label"></td>
			<td class="button" colspan="4" align='right'><input type="radio" name="time_frame" id="time_frame" value="T"><fmt:message key="eOR.ByTimeframeCategory.label" bundle="${or_labels}"/><input type="radio" name="time_frame" id="time_frame" value="C" checked><fmt:message key="eOR.ByCategoryTimeframe.label" bundle="${or_labels}"/>
			<input type="radio" name="time_frame" id="time_frame" value="M"><fmt:message key="eOR.Matrix.label" bundle="${or_labels}"/></td>
			
		
		<!--</table>
		<table border="0" cellspacing="0" cellpadding="3" align="center" width="10%">

		<!--<tr>
		<td width="80%" class="white">
			<input type="button" name="authorize" id="authorize" value="Authorize Mode" class="button" onClick="chkForAuthorization(this)">
		</td>
		</tr>-->
		
		</tr>
		<tr> 
		<td colspan="3"></td>
		
			  
			
			 			<td class="button"  align="right"  nowrap>
				<input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="careSetSearch()" TITLE="Search"><input type="button" class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="clearCareSetSearch()" TITLE="Clear"></td>
			 

			
		</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
		<input type="hidden" name="order_category_yn" id="order_category_yn" value="<%=bean.getOrderCategoryYn()%>">
		<input type="hidden" name="order_type_yn" id="order_type_yn" value="<%=bean.getOrderTypeCodeYn()%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=bean.getPatientId()%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=bean.getPractitionerId()%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
		<input type="hidden" name="location_type" id="location_type" value="<%=bean.getLocationType()%>">
		<input type="hidden" name="location_code" id="location_code" value="<%=bean.getLocationCode()%>">
		<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=bean.getPractitionerType()%>"><!-- IN042045 -->
		<!-- IN036868 Start -->
		<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
		<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
		<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
		<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
		<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
		<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
		<!-- IN036868 End. -->
		<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="admission_date" id="admission_date" value="<%=bean.getVisitAdmDate()%>">
		<input type="hidden" name="discharge_date_time" id="discharge_date_time" value="<%=bean.getDischargeDateTime()%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

		<input type="hidden" name="care_set_order_category" id="care_set_order_category" value=""> <!-- Used to Keep the Category which will be used to identify whether it is Order Set/Pharmacy/Lab Order -->
		<input type="hidden" name="care_set_val" id="care_set_val" value=""> <!-- Used to Keep the Order Care Set Value-->
		<input type="hidden" name="temp_care_set_val" id="temp_care_set_val" value="<%=care_set_value%>"> <!-- To Keep the Temporary care set value, if it has been entered already -->
		<!-- Added by Uma on 2/22/2010 for IN017231 -->
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>"> <!-- To Keep the Temporary function_from value Ends Here for IN017231-->


		<input type="hidden" name="sql_or_order_entry_diagnosis" id="sql_or_order_entry_diagnosis" value="<%=sql_or_order_entry_diagnosis%>">
		<input type="hidden" name="sql_or_order_entry_pat_diagnosis" id="sql_or_order_entry_pat_diagnosis" value="<%=sql_or_order_entry_pat_diagnosis%>">
		<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
		<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
		<script>
		if(document.careSetSearchForm.order_category.value!='')
			populateOrderTypeCareSet(document.careSetSearchForm.order_category)
		if(document.careSetSearchForm.care_sets.value!='')
			getCareSetValue(document.careSetSearchForm.care_sets)
		</script>
		<%

			if(disableOrderCategory.equalsIgnoreCase("DISABLED"))
				out.println("<script>disableOrderCategory('careSetSearchForm')</script>");
			if(disableOrderType.equalsIgnoreCase("DISABLED"))
				out.println("<script>disableOrderType('careSetSearchForm')</script>");
				out.println("<script>OrderTypedisable('careSetSearchForm')</script>");

			// Nullifying the objects
			record			= null;		previousValues	= null;
			keyItems		= null;		setValues 		= null;
			iterator 		= null;		OrderCategory	= null;
			diag_code		= null;
			CareSets		= null;

			// no need to set it back persistence
			// putObjectInBean(bean_id,bean,request);
		%>

	</form>
</body>
</html>

