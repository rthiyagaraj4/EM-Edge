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
Date			Edit History   Name        Description
-----------------------------------------------------------------------
?             	100         	?           created
23/01/2012    	IN030563    	Ramesh G   	The Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? 
											Prompt once for all categories. 						 
											But the Pin No. is prompted each time we Place a Category and also when we record the category.

25/01/2012	  	IN030566		Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.	

25/09/2012		IN030279		Ramesh G	Bru-HIMS-CRF-160 							  
12/03/2013    	IN029601        Chowminya G Display Pregnancy details on place order - PH screen					  
22/03/2013		IN030469		DineshT		Order Entry Place order screen to show catalogs on load
22/05/2013    	IN029601        Chowminya G Display Pregnancy details on place order - PH screen- FD Modification 
18/06/2013    	IN040685        Chowminya G Display Pregnancy details on place order - PH screen- FD Modification 
-----------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
12/02/2018		IN066055		Raja S			12/02/2018		Ramesh 			ML-MMOH-CRF-0891.2
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657
-------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<html>
	<head>
		<title></title>
<%
	try
	{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// [IN030566] String temp_pass	= ((session.getAttribute("TEMP_PASS")!=null)||(session.getAttribute("TEMP_PASS")!=""))?(String)session.getAttribute("TEMP_PASS"):"";	//[IN030563]  

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function callexternalPH(patid,encid,user_id)
		{
			var extph_function_id=document.categoryForm.extph_function.value

			var query_string="Mode=GenerateExtURL&extph_function_id="+extph_function_id+"&patient_id="+patid+"&encounter_id="+encid+"&user_id="+user_id;
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr  = "<root><SEARCH ";
			xmlStr +=" /></root>";
			
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
			xmlHttp.open("POST","PlaceOrderIntermediate.jsp?"+query_string, false ) ;
			xmlHttp.send(xmlDoc);
			if(trimString(xmlHttp.responseText)!="Success")
			{
				responseText=trimString(xmlHttp.responseText);
				eval(responseText);
			}
		}
		</script>
		<STYLE>
		TD.ORSUBCOLOR
		{
			FONT-SIZE: 8pt ;
			COLOR:red;
			BACKGROUND-COLOR: WHITE;
			BORDER-STYLE: none;
			font-Weight : bold;
			WORD-WRAP: break-word
		}	
		</STYLE>
	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="parent.loadButtons();">
<form name="categoryForm" id="categoryForm">

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String patient_id					= request.getParameter("patient_id");
	String encounter_id					= request.getParameter("encounter_id");
	if(encounter_id==null)
		encounter_id					= request.getParameter("episode_id");
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");

	/* Initialize Function specific start */
	//OrderEntryBean bean 				= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setRDInstallYN(bean.getFacilityModuleInstallYn("RD"));//IN069657

	//  Get the bean_id and bean_name from the existing order, if it is "COPY_ORDER"
	MultiPatientOrdersBean multi_bean_obj= null; // For MULTI_PATIENT_ORDERS
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	ExistingOrder existing_bean_obj		= null; // For COPY_ORDER
	String function_from				= bean.checkForNull(request.getParameter("function_from"),"");
	//IN030279 Start.
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");		
	//IN030279 End.
	String function_id				= bean.checkForNull(request.getParameter("function_id"),"");
	String existing_bean_id				= "";
	String existing_bean_name			= "";
	String user_id = (String)session.getValue("login_user");//IN066055
	beanQueryObj.setSiteSpecific("EXTERNAL_PH");//IN066055
	String ext_PH_Link				= "";//IN066055

	if(function_from.equals("COPY_ORDER")) 
	{
		existing_bean_id				= "@existingorderbean"+patient_id+encounter_id;
		existing_bean_name				= "eOR.ExistingOrder";
		//existing_bean_obj				= (ExistingOrder)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		existing_bean_obj 				= (ExistingOrder)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
	} 
	else if(function_from.equals("EXTERNAL_ORDER")) 
	{
		existing_bean_id 				= "Or_ExternalOrders";
		existing_bean_name				= "eOR.ExternalOrdersBean";
		//external_bean_obj				= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj 				= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
	} 
	else if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		existing_bean_id 				= "Or_MultiPatientOrders";
		existing_bean_name 				= "eOR.MultiPatientOrdersBean";
		//multi_bean_obj				= (MultiPatientOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		multi_bean_obj 					= (MultiPatientOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		//multi_bean_obj = (MultiPatientOrdersBean)getObjectFromBean(existing_bean_id, existing_bean_name,session);
	}

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		ArrayList multi = (ArrayList)multi_bean_obj.getMultiPatientDetails();
		
		if(multi.size()>0)
		{
			HashMap multihash = new HashMap();
			multihash.put("key",multi);
			orderEntryRecordBean.setMultiPatientDetails("multi_patient_details", multihash);
		}
		
		HashMap outhash = new HashMap();
		outhash = (HashMap)orderEntryRecordBean.getMultiPatientDetails("multi_patient_details");
	}*/
	String existing_query_string		= "";
	String queryString						= "";
	ArrayList copyOrderDetails			= null;
	if(function_from.equals("COPY_ORDER"))	// Existing Order Bean
	{
		existing_query_string			= existing_bean_obj.getExistingQueryString();	// Get from the existing order, to send as a parameter when refreshing for COPY_ORDER
		/*Added by Uma on 2/24/2010 for IN019470*/
		if(existing_query_string.equals(""))
		{
			String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
			String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
			String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
			String age = request.getParameter("Age")==null?"":request.getParameter("Age");
			String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
			String visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			//String existing_order_called_from = request.getParameter("existing_order_called_from")==null?"":request.getParameter("existing_order_called_from");
			String multi_called_from = request.getParameter("multi_called_from")==null?"":request.getParameter("multi_called_from");
			String patient_class=(String)bean.getPatientClass()==null?"":(String)bean.getPatientClass();
			queryString = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&function_from=PASSED_ORDERS&location_type="+location_type+"&location_code="+location_code+"&p_called_from_ca=Y&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&episode_id="+encounter_id+"&locn_code="+location_code+"&locn_type="+location_type+"&patient_class="+patient_class+"&multi_called_from="+multi_called_from;
			existing_query_string = queryString;
		}
		/*Ends Here IN019470*/
	}
	else if(function_from.equals("EXTERNAL_ORDER"))
		existing_query_string			= external_bean_obj.getExistingQueryString();	// Get from the existing order, to send as a parameter when refreshing for EXTERNAL_ORDER
	else if(function_from.equals("MULTI_PATIENT_ORDERS"))
	{
		existing_query_string			= multi_bean_obj.getQryString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		/*Added by Uma on 2/18/2010 for IN017231*/
		String patientString			= (String)multi_bean_obj.getPatString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String encounterString			= (String)multi_bean_obj.getEncString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String episodeString			= (String)multi_bean_obj.getEpiString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String episodevisitString			=(String)multi_bean_obj.getVisitString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String patientclassString			= (String)multi_bean_obj.getPatClassString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		
		StringTokenizer stoken = new StringTokenizer(patientString,"!$!");
		StringTokenizer stoken1 = new StringTokenizer(encounterString,"!$!");
		StringTokenizer stoken2 = new StringTokenizer(episodeString,"!$!");
		StringTokenizer stoken3 = new StringTokenizer(episodevisitString,"!$!");
		StringTokenizer stoken4 = new StringTokenizer(patientclassString,"!$!");
		
		String [] record = null;
		ArrayList arr_patient_id		 = new ArrayList();
		
		while(stoken.hasMoreTokens()) 
		{
			record = new String [5];
			String mpatient_id		= stoken.nextToken();
			String mencounter_id		= stoken1.nextToken();
			String mepisode_id		= stoken2.nextToken();
			String mepisodevisit_id		= stoken3.nextToken();
			String mpatient_class		= stoken4.nextToken();
			if(mpatient_id == "~" || mpatient_id.equals("~")) mpatient_id="";
			if(mencounter_id == "~" || mencounter_id.equals("~")) mencounter_id="";
			if(mepisode_id == "~" || mepisode_id.equals("~")) mepisode_id="";
			if(mepisodevisit_id == "~" || mepisodevisit_id.equals("~")) mepisodevisit_id="";
			if(mpatient_class == "~" || mpatient_class.equals("~")) mpatient_class="";
			
			record[0]		= mpatient_id;
			record[1]		= mencounter_id;
			record[2]		= mepisode_id;
			record[3]		= mepisodevisit_id;
			record[4]		= mpatient_class;
			arr_patient_id.add(record);
		}
		bean.setMultiPatientDetails(arr_patient_id);
	}	
	/*Ends Here for IN017231*/
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	Properties properties				= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String ammend_called_from			= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_id						= bean.checkForNull(request.getParameter("order_id"),"");
	String order_line_num				= bean.checkForNull(request.getParameter("order_line_num"),"");
	String iv_prep_yn					= bean.checkForNull(request.getParameter("iv_prep_yn"),"");
	/*  CP Module Related parameters */
	String p_order_catalog_code				= bean.checkForNull(request.getParameter("p_order_catalog_code"),"");
	String p_start_date_time			= bean.checkForNull(request.getParameter("p_start_date_time"),"");
	String p_task_code					= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no				= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String reject_order					= bean.checkForNull(request.getParameter("reject_order"),"");
 	/* Till here CP Module related parameters*/
	String amend_key					= (bean.getPatientId()+bean.getEncounterId()+order_id);  // Unique key (For Existing Orders) to keep the Value in the Bean
//	String copy_key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For COPY Orders) to keep the Value in the Bean
	String key							= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For New Orders) to keep the Value in the Bean
	String ph_instal_yn					= "N";
	String lb_instal_yn		="N";			//=bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N"); // check whether the lb_module is installed or not, used in EJB
	String session_id					= bean.checkForNull(bean.getSessionId(),""); //  used in EJB
	String catalog						= "";

	// Till here
	HashMap previousValues 				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);

	// If it is an Amend/Review order, call a method to set the value in the bean.
	if(function_from.equals("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equals("RENEW_ORDER"))
	{
		if( function_from.equals("AMEND_ORDER") || function_from.equals("RENEW_ORDER")) 
		{
			bean.setAmendCode(amend_key,order_id.trim(),order_line_num);	
		}
        else if(function_from.equals("COPY_ORDER") && previousValues==null && (!reject_order.equalsIgnoreCase("Y")))
		{	// GET FROM THE Existing Order bean for the COPY_ORDER
			copyOrderDetails			= existing_bean_obj.getCopyOrderDetails();		// ArrayList
 			bean.setCopyOrderDetails(copyOrderDetails);		// Setting into the Order Entry Bean
			copyOrderDetails			= bean.getCopyOrderDetails();				// Getting the value for the COPY_ORDER
			catalog						= bean.setCopyCode(key, copyOrderDetails);	// Setting the value into tbe bean for the copy order, for the first time
			previousValues				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		}
		bean.setOrderId(order_id);
		bean.setOrderLineNo(order_line_num);
		bean.setAmendOrder(ammend_called_from);
		bean.setCalledFromFunction(function_from);
	}
	//IN030469, starts
	if(function_from.equals("HIGH_RISK_ASSESS"))
	{
		bean.setCatalogCodes((String)session.getValue(key+"CHK_BOX"));
		orderEntryRecordBean.setCheckedEntries(key, (HashMap)session.getValue(key+"CHK_BOX_DTLS"));
		previousValues				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	}
	//IN030469, ends
	

	HashMap amendPreviousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
	String category						= "";
	String ordering_applicable_yn		= "N";
   	String refresh_yn					= bean.checkForNull(bean.getRefreshYn(),"N");
   	// first time or in any case, refresh_yn will be "N", unless insertion/updation is done and catalog code is not more, then it will be set to "Y" in the removeBeanValues() method in the bean
    ph_instal_yn						= bean.getModuleInstallYn("PH"); // To check whether PH Module has been installed or not
	ArrayList OrderCategoryArr			= beanQueryObj.getOrderCategory(properties); // Get the Order category	
	HashMap hmOrderCategory				= new HashMap();
	HashMap hashMap						= new HashMap();
	String record[]						= null;
	//IN029601 - Start
	ArrayList PregDtls		= beanQueryObj.getPHPregDtls(properties,patient_id,encounter_id); 
	String record1[]						= null;
	String preg_trim					= "";
	String preg_stage					= "";
	String preg_chk					    = "N";	
	String PH_age_chk					= "N";
	String PH_param_chk					= "N";
	
	PH_age_chk = beanQueryObj.getPHagechk(properties,patient_id);	
	
	if(PregDtls!=null && PregDtls.size() > 0)
	{
		record1 = new String[3];
		for(int i=0;i<PregDtls.size(); i++) 
		{
			record1 = ((String[])PregDtls.get(i));
			preg_chk = record1[0];
		}
	}	
	//IN029601 - end	
	if(OrderCategoryArr!=null && OrderCategoryArr.size() > 0)
	{
		record = new String[2];
		for(int i=0;i<OrderCategoryArr.size(); i++) 
		{
			record = ((String[])OrderCategoryArr.get(i));
			hmOrderCategory.put( record[0] , record[0]);
			hmOrderCategory.put( record[0] , record[1]);
		} // end of for
	} // end of if OrderCategoryArr

	if(refresh_yn.equals("N") && (previousValues==null || (previousValues!=null && previousValues.size()==0) )&&(!function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS")))
    {
      	if(ph_instal_yn.equals("Y")) // Only if PH Module has been installed
      	{
			// Call a function to execute and based upon the ordering rule set up for the patient class, allow or come out
			ordering_applicable_yn		= bean.checkForNull(bean.getOrderingRuleYn("PH"),"N"); // Pass the order_category
			if(ordering_applicable_yn.equals("Y"))
				category				= "PH"; //If the User enters directly in the New Order, click the Place Order, then paint the Pharmacy Tab obly
		}
	}
	else
		category						= "";
 
	if(function_from.equalsIgnoreCase("AMEND_ORDER") || (previousValues!=null && previousValues.size()>0) || (category.equals("PH") && !function_from.equalsIgnoreCase("COPY_ORDER")) )
   	{
		//IN029601 - Start Modified
		if(category.equals("PH") && PregDtls!=null && PregDtls.size() > 0 && ("Y".equals(PH_age_chk)))
		{
%>
		<table width="100%" border="0" cellspacing=0 cellpadding="0" id="tab">

		<tr>
<%
		}
		else
		{
%>
		<table border="0" cellspacing=0 cellpadding="" id="tab">

		<tr>
<%
		}//IN029601 - End Modified
 		if(category.equals("PH") && (! (function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equalsIgnoreCase("RENEW_ORDER"))) )
		{ // || function_from.equalsIgnoreCase("RENEW_ORDER")
			hashMap.put("PH","PH"); //Putting the OrderCategory into the temporarily hashmap
		}
		else if(!(function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("RENEW_ORDER"))  ) // If it is coming for New orders or for COPY Order then only category has been selected
		{
			hashMap = bean.getOrderCategories(previousValues);
		}
		else 
		{// For Amend Order
 			hashMap = bean.getOrderCategories(amendPreviousValues);
		}
	
		if(hashMap!=null && hashMap.containsKey("CN")) 
		{ 
%>
			<td id="Consults"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
			<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Consults')">
<%
			if(hmOrderCategory.containsKey("CN")) 
			{ 
				out.println((String)hmOrderCategory.get("CN")); 
			} 
			else 
			{
%>
				<fmt:message key="eOR.Consults.label" bundle="${or_labels}"/>
<%
			}
%>
			</a></td>
<% 
		} 
		
		if(hashMap!=null && hashMap.containsKey("DS")) 
		{ 
%>
			<td id="DietaryService"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
			<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('DietaryService')">			
<%
			if(hmOrderCategory.containsKey("DS")) 
			{ 
				out.println((String)hmOrderCategory.get("DS")); 
			} 
			else 
			{
%>				
				<fmt:message key="eOR.Dietary.label" bundle="${or_labels}"/>
<%
			}
%>			</a></td>
<%		} 
			
		if(hashMap!=null && hashMap.containsKey("LB")) 
		{ 
%>
			<td id="Laboratory" class="CASECONDSELECTHORZ" onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);" 	onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
			<a style="color:white;cursor:pointer"  href="javascript:parent.change_tab_buttons('Laboratory')">
<%			
			if(hmOrderCategory.containsKey("LB")) 
			{ 
				out.println((String)hmOrderCategory.get("LB"));
			}
			else 
			{
%>
				<fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/>
			<%
			}
%>
			</a></td>
<%		} 
			
		if(hashMap!=null && hashMap.containsKey("MI")) 
		{ 
%>
			<td id="Miscellaneous" 	 class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer"  href="javascript:parent.change_tab_buttons('Miscellaneous')"><%if(hmOrderCategory.containsKey("MI")) { out.println((String)hmOrderCategory.get("MI")); } else {%><fmt:message key="eMP.Miscellaneous.label" bundle="${mp_labels}"/><%}%></a></td>
<% 
		} 
		
		if(hashMap!=null && hashMap.containsKey("NC")) 
		{
%>
			<td id="Nursing"	 class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Nursing')"><%if(hmOrderCategory.containsKey("NC")) { out.println((String)hmOrderCategory.get("NC")); } else {%><fmt:message key="eOR.NursingCare.label" bundle="${or_labels}"/><%}%></a></td>
<%	
		} 
		//[IN030566]
		if(hashMap!=null && hashMap.containsKey("OH")) 
		{ 
%>
			<td id="OralHealth" 	 class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('OralHealth')"><%if(hmOrderCategory.containsKey("OH")) { out.println((String)hmOrderCategory.get("OH")); } else {%><fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/><%}%></a></td>
		    
<%		}
		//[IN030566]
		if(hashMap!=null && hashMap.containsKey("CS")) 
		{ 
%>
			<td id="OrderSets" 	 class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('OrderSets')"><%if(hmOrderCategory.containsKey("CS")) { out.println((String)hmOrderCategory.get("CS")); } else {%><fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/><%}%></a></td>
		    
<%		} 
		
		if(hashMap!=null && hashMap.containsKey("PC")) 
		{ 
%>
			<td id="PatientCare"   class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('PatientCare')"><%if(hmOrderCategory.containsKey("PC")) { out.println((String)hmOrderCategory.get("PC")); } else {%><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/><%}%></a></td>
<%
		} 

		if(hashMap!=null && hashMap.containsKey("RD")) 
		{ 
%>
			<td id="Radiology"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Radiology')"><%if(hmOrderCategory.containsKey("RD")) { out.println((String)hmOrderCategory.get("RD")); } else {%><fmt:message key="Common.Radiology.label" bundle="${common_labels}"/><%}%></a></td>
<%
		} 

		if(hashMap!=null && hashMap.containsKey("RX")) 
		{ 
%>
			<td id="RadiologyDept"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('RadiologyDept')"><%if(hmOrderCategory.containsKey("RX")) { out.println((String)hmOrderCategory.get("RX")); } else {%><fmt:message key="eOR.RadiologyDept.label" bundle="${or_labels}"/><%}%></a></td>
<%
		} 
			
		if(hashMap!=null && hashMap.containsKey("OT")) 
		{ 
%>
			<td id="Surgical"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
		<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Surgical')">
<%
		if(hmOrderCategory.containsKey("OT")) 
		{ 
			out.println((String)hmOrderCategory.get("OT")); 
		} 
		else 
		{
%>
			<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
<%
		}
%>
		</a></td>
<%
		} 
			
		if(hashMap!=null && hashMap.containsKey("TR")) 
		{ 
%>
			<td id="Treatment"  class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap><a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Treatment')"><%if(hmOrderCategory.containsKey("TR")) { 
				out.println((String)hmOrderCategory.get("TR")); 
			} 
			else 
			{
%>
				<fmt:message key="Common.Treatment.label" bundle="${common_labels}"/><%
			}
%>
			</a></td>
		
<%
		} 
		
		if(hashMap!=null && hashMap.containsKey("PH")) 
		{
			//IN029601 - Start Modified
			PH_param_chk = beanQueryObj.getPHparamchk(properties);
			int week = 0;//IN040685
			if(PregDtls!=null && PregDtls.size() > 0 && ("Y".equals(PH_age_chk)) )
			{
				record1 = new String[3];
				for(int i=0;i<PregDtls.size(); i++) 
				{
					record1 = ((String[])PregDtls.get(i));
					if(record1[0].equals("Y"))
					{
						preg_stage = record1[2];
						week = Integer.parseInt(preg_stage); //IN040685
						
						preg_trim		= beanQueryObj.getPHTrimDtls(properties,preg_stage);		
						record1[0] = "Yes";
					}	
					else 
						record1[0] = "No";		

	%>
					<td  width="8%" id="Pharmacy"   class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
					<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Pharmacy')">
	<%
					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{
	%>
						<fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/>
	<%
					}
	%>
					</a>			
					</td>
						
					<td width="85%" align="left" nowrap>
						<td width="30%" class="ORSUBCOLOR" nowrap> Pregnant :</td> <td class="ORSUBCOLOR" nowrap><%=record1[0]%></td> 
	<%
					if(preg_chk.equals("Y"))//IN029601//IN040685 added conditions for trimester and stage display
					{
						if(!("0").equals(preg_trim))
						{
	%>	
							<td width="30%" class="ORSUBCOLOR" nowrap> Pregnancy Trimester :</td> <td class="ORSUBCOLOR" nowrap><%=preg_trim%></td> 
<%						}
						if(week <= 44)
						{
%>
						<td width="30%" class="ORSUBCOLOR" nowrap> Pregnancy Stage :</td> <td class="ORSUBCOLOR" nowrap><%=preg_stage%> Weeks</td> </td>
	<%	
						}	
					}
					else
					{
	%>	
						<td width="30%" class="ORSUBCOLOR" nowrap> </td> <td class="ORSUBCOLOR" nowrap></td> 
						<td width="30%" class="ORSUBCOLOR" nowrap></td> <td class="ORSUBCOLOR" nowrap></td> </td>
	<%					
						
					}
						
				} 
			}
			else 
			{
				if("Y".equals(PH_param_chk) && ("Y".equals(PH_age_chk)))
				{
%>
					<td  id="Pharmacy"   class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
					<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Pharmacy')">
<%
					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{
%>
						<fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/>
<%
					}
%>
						</a>			
					</td>
					<td width="85%" align="left" nowrap>
						<td width="30%" class="ORSUBCOLOR" nowrap> No Record of Pregnancy </td> <td class="ORSUBCOLOR" nowrap></td> 
						<td width="30%" class="ORSUBCOLOR" nowrap> </td> <td class="ORSUBCOLOR" nowrap></td> 
						<td width="30%" class="ORSUBCOLOR" nowrap></td> <td class="ORSUBCOLOR" nowrap></td> 
					</td>
<%
				}
				else
				{
%>
					<td  id="Pharmacy"   class="CAFIRSTSELECTHORZ"  onMouseOver="parent.callOnMouseOver(this);" onMouseOut="parent.callOnMouseOut(this);"   onClick="parent.changeColor(this,'OR_BUTTONS')" nowrap>
					<a style="color:white;cursor:pointer" href="javascript:parent.change_tab_buttons('Pharmacy')">
<%
					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{
%>
						<fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/>
<%
					}
%>
						</a>			
					</td>
<%
					
				}
			}	
			//IN029601 - end Modified
		} 
			
%>
		</tr>
		</table>
<%	} 
	else 
	{   // Refreshing Part Done Here
		/*Modified by Uma on 2/18/2010 for IN017231*/
		//IN066055 changes starts
		boolean isExternalPHEnabled = beanQueryObj.isSiteSpecific("EXTERNAL_PH");
		if(refresh_yn.equals("N") && ph_instal_yn.equals("N") && isExternalPHEnabled){
			String phExtUrlarr[] = null;
			String facility_id=(String)session.getValue("facility_id");
			String extFuncCalledFrom = "";
			HashMap tabdata				= new HashMap();
			String externalUrl = "";
			tabdata			= beanQueryObj.getExtPHValidation(properties,patient_id,encounter_id,user_id,facility_id);
%>
			<input type="hidden" name="extph_function" id="extph_function" value="">
			
<%
			if(tabdata.containsKey("ERROR")){
				out.println("<script>alert('Atleast one Diagnosis should be recorded')</script>");
			}else{

				if(tabdata.get("DISCHARGESTATUS").equals("7"))
				{
					out.println("<script>var confirmSelect = window.confirm('Do you want to open \"PHIS- Discharge Medication\" screen ?');");
					out.println("if(confirmSelect == true){document.categoryForm.extph_function.value='PHIS_DISCHARGE_MEDICATION'");
					out.println("}else{document.categoryForm.extph_function.value='PHIS_MEDICATION_ORDER'}</script>");
				}else{
					out.println("<script>document.categoryForm.extph_function.value='PHIS_MEDICATION_ORDER'</script>");
				}
			out.println("<script>callexternalPH('"+patient_id+"','"+encounter_id+"','"+user_id+"');</script>");
			}
			ext_PH_Link="EXT_PH_CALLED";
			
		}
		//IN066055 changes ends
			
			
		if(refresh_yn.equals("N") && ph_instal_yn.equals("N") && !ext_PH_Link.equals("EXT_PH_CALLED"))
		    out.println("<script>alert(parent.getMessage('CLICK_ONE_ORDERABLE','OR'))</script>");
		else if(refresh_yn.equals("N") && ph_instal_yn.equals("Y") && ordering_applicable_yn.equals("N"))
		{
			if(!function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
			{
		 		out.println("<script>alert(parent.getMessage('ORDERS_CANNOT_BE_PLACED','OR'))</script>");
			}
			else
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
			}
			/*Ends Here IN017231*/
		}
		else
		{
			bean.clear();// Clear the bean values
			if(function_from.equals("COPY_ORDER"))			// For COPY ORDER Only, to put it into existing orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				existing_bean_obj.clear(); // Clear the existing order bean also
			}
			else if(function_from.equals("EXTERNAL_ORDER"))	// For EXTERNAL ORDER Only, to put it into EXTERNAL orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				external_bean_obj.clear(); // Clear the External Order bean also
			}
			else if(function_from.equals("MULTI_PATIENT_ORDERS"))	// For MULTI PATIENT ORDER Only, to put it into Multi Patient Orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				//multi_bean_obj.clear(); // Clear the Multi Patient Order Bean also
			}
			//IN066055 starts
			else if (ext_PH_Link.equals("EXT_PH_CALLED")){
				//background leaves black to focus the external pharmacy
			}
			//IN066055 ends
			else out.println("<script>parent.refreshTab('','');</script>");	// For Other orders, reload to call existing orders
	 	}
	}
%>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
	<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
	<!-- IN030279 Start -->
	<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
	<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
	<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
	<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
	<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
	<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
	<!-- IN030279 End. -->
	<input type="hidden" name="location_type" id="location_type" value="<%=bean.getLocationType()%>">
	<input type="hidden" name="location_code" id="location_code" value="<%=bean.getLocationCode()%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
	<input type="hidden" name="lb_instal_yn" id="lb_instal_yn" value="<%=lb_instal_yn%>">
	<input type="hidden" name="session_id" id="session_id" value="<%=session_id%>">
	<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
	<input type="hidden" name="p_order_catalog_code" id="p_order_catalog_code" value="<%=p_order_catalog_code%>">
	<input type="hidden" name="p_start_date_time" id="p_start_date_time" value="<%=p_start_date_time%>">
	<input type="hidden" name="p_task_code" id="p_task_code" value="<%=p_task_code%>">
	<input type="hidden" name="p_task_srl_no" id="p_task_srl_no" value="<%=p_task_srl_no%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
	<input type="hidden" name="episode_id" id="episode_id" value="<%=beanQueryObj.checkForNull(request.getParameter("episode_id"),"")%>">
	<input type="hidden" name="pract_reln_id" id="pract_reln_id" value="<%=beanQueryObj.checkForNull(request.getParameter("pract_reln_id"),"")%>">
	<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value="<%=beanQueryObj.checkForNull(request.getParameter("p_called_from_ca"),"")%>">
	<input type="hidden" name="Sex" id="Sex" value="<%=beanQueryObj.checkForNull(request.getParameter("Sex"),"")%>">
	<input type="hidden" name="Age" id="Age" value="<%=beanQueryObj.checkForNull(request.getParameter("Age"),"")%>">
	<input type="hidden" name="Dob" id="Dob" value="<%=beanQueryObj.checkForNull(request.getParameter("Dob"),"")%>">
	<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=beanQueryObj.checkForNull(request.getParameter("visit_adm_date"),"")%>">
	<input type="hidden" name="licence_key" id="licence_key" value="<%=beanQueryObj.checkForNull(request.getParameter("licence_key"),"")%>">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=beanQueryObj.checkForNull(request.getParameter("pract_id"),"")%>">
	<input type="hidden" name="pract_name" id="pract_name" value="<%=beanQueryObj.checkForNull(request.getParameter("pract_name"),"")%>">
	<input type="hidden" name="order_mode" id="order_mode" value="<%=beanQueryObj.checkForNull(request.getParameter("order_mode"),"")%>">
	<input type="hidden" name="bt_module_install" id="bt_module_install" value="<%=beanQueryObj.checkForNull(request.getParameter("bt_module_install"),"")%>">
	<input type="hidden" name="called_from" id="called_from" value="<%=beanQueryObj.checkForNull(request.getParameter("called_from"),"")%>">
	<input type="hidden" name="time_frame" id="time_frame" value="<%=beanQueryObj.checkForNull(request.getParameter("time_frame"),"")%>">
	<!--<input type="hidden" name="tempPass" id="tempPass" value=""> [IN030566]--> <!-- [IN030563] --> 
<%
			// Nullifying the Objects
	copyOrderDetails		= null; // Nullifying the Objects
	previousValues			= null;	 amendPreviousValues	= null;
	record					= null;  OrderCategoryArr		= null;
	hmOrderCategory			= null;	 hashMap				= null;	
			
%>
	</form>

<%	if(function_from.equals("COPY_ORDER") && !(bean.checkForNull(catalog,"").equals("")) ) 
	{ 
%>
		<script>parent.setCopyCatalogCode("<%=catalog%>");</script>
<%	} 

	// set it back persistence
	putObjectInBean(bean_id,bean,request);

	if(function_from.equals("COPY_ORDER")) 
	{ 
		putObjectInBean(existing_bean_id,existing_bean_obj,request);
	} 
	else if(function_from.equals("EXTERNAL_ORDER")) 
	{
		putObjectInBean(existing_bean_id,external_bean_obj,request);
  	} 
	else if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		putObjectInBean(existing_bean_id,multi_bean_obj,request);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
	</body>
</html>

