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
Date       Edit His	tory   Name        	Description
-----------------------------------------------------------------------
?             100         ?           	created
27/08/2013  IN041702   Chowminya G     When click at the icon or menu 'Pharmacy Order' the screen will display â??Order screenâ??
20/05/2014	IN044502   Nijitha S	   Bru-HIMS-CRF-400	
13/08/2014	IN049419	Ramesh G		An Audit Trail for Additional Information Amendment of Order
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

01/11/2016	IN061988		Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
27/05/2019	IN069027		Ramesh G										MMS-DM-CRF-0150
14/10/2019  IN071315		Nijitha S       14/10/2019		Ramesh G		GHL-CRF-0607
12/12/2019	IN072036		sivabagyam	 	12/12/2019		Ramesh G      	BSP-SCF-0080
24/02/2019	IN072532		Nijitha S	 	12/12/2019		Ramesh G 		CA-ML-MMOH-CRF-1229/05-Order set category order
23/08/2020	IN073695	 	Durga N			23/08/2020		Ramesh G 		OR-Common-Health Risk Assessment	
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%><!--IN068314-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>

<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<style>
		.HIDENEWORDERS
		{
			display:none;
		}
	</style>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>-->
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>	
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script><!-- Used for Prescription -->
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		/*
		 *   Script Used here (violation), Need to pass the Query String to the Functions Called,
		 */
		// To change the Tabs, from the Existing Orders to New Orders or vice versa
		//function change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from,function_id)//Commented for IN071315
		function change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from,function_id,p_called_from_ca)//IN071315
		{ 
				
				//if( (obj=="NewOrders" && function_from=="COPY_ORDER" && called_from=="ON_LOAD")) //IN073695
				if( (obj=="NewOrders" && (function_from=="COPY_ORDER"||function_from=="HIGH_RISK_ASSESS") && called_from=="ON_LOAD")) //IN073695
				{	
					colorChange();					
				}
				if((obj=="ExistingOrders" && licence_key=="ORPV" && called_from=="ON_LOAD"))
				{
					
					//(licence_key=="ORPV") Only For Alrabha Version(Pharmacy Version) to load the Pharamacy Tab
					colorChange();
					//IN041702 - pass pharmacy_scope parameter 
					parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
				}
				else if( obj=="ExistingOrders" && (function_from!="EXTERNAL_ORDER" || function_from!="MULTI_PATIENT_ORDERS" || function_from!="CP" || function_from!="MO"|| function_from!="REPLACE_ADD" )  )
				{	
					if(pharmacy_scope!='' && pharmacy_scope=='PH')
					{
						colorChange();
						//IN069027 Start.
						//parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
						if("Y"==(document.forms[0].dxChkBfrPlaceOrderSpec.value)){							
							parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
						}else{
							alert(getMessage("DIAG_NOT_RECORDED","OR"));							
							//alert('Patient Diagnosis not recorded, please complete to proceed further.');							
						}
						//IN069027 End.
					}//Menaka Starts
					else if(function_id=='CONT')
					{
						colorChange();
						//IN041702 - pass pharmacy_scope parameter
						parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
					}//Menaka Ends
					else
					{

						parent.orderDetailFrame.location.href = "../../eOR/jsp/ExistingOrder.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&function_from="+function_from+"&p_called_from_ca="+p_called_from_ca;//Added for IN071315

						if(multi_called_from=="MULTI_PATIENT_ORDER")
						{
							if(document.OrCommonForm.newOrders)
							{
								document.OrCommonForm.newOrders.style.display = "none";
							}
						}

					}
				}			
				else
				{
					//IN069027 Start.					
					//parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;  //IN041702 - pass pharmacy_scope parameter
					if( obj=="NewOrders" && function_from!="AMEND_ORDER"){
						if("Y"==(document.getElementById('dxChkBfrPlaceOrderSpec').value)){
							parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
						}else{	
							alert(getMessage("DIAG_NOT_RECORDED","OR"));			
							//alert('Patient Diagnosis not recorded, please complete to proceed further.');
							if("0"!=(document.forms[0].newOrdersPosition.value))
							changeColor(document.getElementById("existingOrders"),"COMMON");
						}
					}else{					
						parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
					}
					//IN069027 End.
				}

				if(top.content)
					top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
			
		}

		function colorChange() 
		{
			if(document.OrCommonForm.existingOrders)
				document.OrCommonForm.existingOrders.className  = "CAFIRSTSELECTHORZ";
			if(document.OrCommonForm.newOrders)
				document.OrCommonForm.newOrders.className		= "CASECONDSELECTHORZ";
		}

	</script>
	<STYLE TYPE="text/css"></STYLE>
 </head>
<%	
	//Added on 21/05/2003
	/*
	 *  Common to make the Button enable or disable
	 */
    String params					= request.getQueryString() ;
   	String bed_num                  = beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
	String room_num                 = beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	
//	String bean_id 					= "@accessrightbean"+patient_id+encounter_id;
//	String bean_name 				= "eOR.Common.AccessRightBean";
	String multi_bean_id 			= "Or_MultiPatientOrders";
	String multi_bean_name 			= "eOR.MultiPatientOrdersBean";
	String facility_id				= (String)session.getValue("facility_id");
	Properties properties			= (Properties) session.getValue( "jdbc" );
	beanQueryObj.setLanguageId(localeName);	
	//Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String function_from			= beanQueryObj.checkForNull(request.getParameter("function_from"),"");
	//Added for Bru-HIMS-CRF-400[IN044502] Start	
	String or_bean_id 						= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name 					= "eOR.OrderEntryBean";
	OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	bean.setLanguageId(localeName);
	HashMap hmRenewOrders = bean.getRenewOrderIds();
	if(null!=hmRenewOrders && hmRenewOrders.size() > 0){
	bean.setCalledFromFunction("RENEW_ORDER");
	function_from = "RENEW_ORDER";
	}
	//Added for Bru-HIMS-CRF-400[IN044502] End
	//IN049419 Start.	
		String amend_reason = request.getParameter("amendDesc")==null?"":(String)request.getParameter("amendDesc");
		bean.setAmend_reason(amend_reason);
		String amend_auditTrailYN =  bean.getOrderFormatAuditTrailYN();
		bean.setAmend_auditTrailYN(amend_auditTrailYN);
	//IN049419 End.
 	//String ext_bean_id 			= "externalordersbean";
	//String ext_bean_name 			= "eOR.ExternalOrdersBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//AccessRightBean bean 		= (AccessRightBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//		AccessRightBean  bean		= (AccessRightBean)getBeanObject( bean_id, bean_name, request ) ;
//		bean.clear();
	ArrayList multi_patient_details	=  null;
	if(function_from != null && function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
		//MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)mh.getBeanObject( multi_bean_id, request,  multi_bean_name ) ;
	//	ExternalOrdersBean ext_bean = (ExternalOrdersBean)mh.getBeanObject( ext_bean_id, request,  ext_bean_name ) ;
	/* Initialize Function specific end */
		multi_patient_details	= multi_bean.getMultiPatientDetails();
		
	}
	String responsibility_id		= (String) session.getValue("responsibility_id");
	String ammend_called_from 		= beanQueryObj.checkForNull(request.getParameter("ammend_called_from"),"");
	String multi_called_from 		= beanQueryObj.checkForNull(request.getParameter("multi_called_from"),"");
	if(!ammend_called_from.equals(""))
		ammend_called_from 			= ammend_called_from.trim();
	if(!multi_called_from.equals(""))
		multi_called_from 			= multi_called_from.trim();
	String relationship_id			= beanQueryObj.checkForNull(request.getParameter("relationship_id"),"");
	String p_called_from_ca			= beanQueryObj.checkForNull(request.getParameter("p_called_from_ca "),"");
	String or_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("OR", facility_id, properties),"N");
 	String ph_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("PH", facility_id, properties),"N");
	//String p_option_function_name	= beanQueryObj.checkForNull(request.getParameter("p_option_function_name"),"");
	String function_id				= beanQueryObj.checkForNull(request.getParameter("function_id"),"ORDERS");
  	// Function_id will be passed from Pharmacy module as "MEDICATION_ADMIN"/"EXTERNAL_ORDERS", IF NOTHING IS PASSED DEFAULT IS ORDERS	
  	String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String allergy_display_yn 		= "";
	String active_display_yn 		= "";
	String demography_display_yn 	= "";
	//String drug_display_yn			= "X";
	String disabledField			= "";
	String disp_patient_id			= patient_id;
	// Get the Main Tabs (Existing Order/New Order)
	String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
	String login_user               = (String) session.getValue("login_user");
	String patient_class			= beanQueryObj.checkForNull(request.getParameter("patient_class"),"");
//	String practitioner_name		= "";
	String class_name_first			= "";
//	String class_name_second		= "";
	String record[]					= null;
	if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
	{
	   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
	   if (practitioner_details.length == 2) 
		{
	       practitioner_id		= practitioner_details[0];
	    //   practitioner_name	= practitioner_details[1];
	   } // End of practitioner_details length
	} // end of if practitioner_id
	ArrayList MainTabsHdg		= beanQueryObj.getMainTabs(properties, practitioner_id, patient_class, function_id); 
	String cnsnt_with_order_yn			= beanQueryObj.checkForNull(request.getParameter("cnsnt_with_order_yn"),"N"); //IN057196
	//HashMap hashMapMainsTab		= new HashMap();	
	String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("p_scope"),"");
	//IN069027 Start.
	HashMap  dxChkBfrPlaceOrderMap=new HashMap();
	dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patient_id,encounter_id,patient_class,facility_id,function_from);
	//IN069027 End.
	//IN068314 Starts
	String episode_type ="";
	if("IP".equals(patient_class))	
		episode_type ="I";
	else if("OP".equals(patient_class))
		episode_type ="O";
	else if("EM".equals(patient_class))
		episode_type ="E";
	else if("DC".equals(patient_class))
		episode_type ="D";	
	
	Connection connection =  null;
	Boolean isfppapplicable= false;//IN068314
	try{
		connection = ConnectionManager.getConnection(request); 
		
		isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");//IN068314
		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			if(connection!=null) connection.close();
		}
	if(isfppapplicable && !"EXTERNAL_ORDER".equals(function_from) )//IN072532
		bean.setFpp_patient_yn(bean.getFPPPatientYN(facility_id, episode_type, encounter_id));
	bean.setIsfppapplicable(isfppapplicable);
	//IN068314 Ends
// Till here 21/05/2003
%>
<%
	if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
	{
		for(int i=0; i<MainTabsHdg.size(); i++)
		{
			record = (String[])MainTabsHdg.get(i);
			//Put it in the hashmap for the check for the body onload 
			//hashMapMainsTab.put(record[0],record[1]);
			//if(hashMapMainsTab.containsKey("newOrders")) 
				//break; // come out of the loop because , the first one is the New Orders Tab
		//} 
		//if((hashMapMainsTab!=null && hashMapMainsTab.containsKey("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))))
		if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER") || function_from.equals("HIGH_RISK_ASSESS"))))
		{ 	
			%>				
			<body onLoad="change_common_tab('ExistingOrders','<%=licence_key%>','<%=function_from%>','<%=pharmacy_scope%>','ON_LOAD','<%=multi_called_from%>','<%=function_id%>','<%=p_called_from_ca%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()"><!--Menaka--><!-- p_called_from_ca add for 71315 -->
		<%
		}
		//else if(hashMapMainsTab!=null && hashMapMainsTab.containsKey("newOrders")) 
		else if((record[0].equalsIgnoreCase("newOrders")) && (!(function_from.equals("PASSED_ORDERS")) ) )  
		{
		%>	
			<body onLoad="change_common_tab('NewOrders','<%=licence_key%>','<%=function_from%>','<%=pharmacy_scope%>','ON_LOAD','<%=multi_called_from%>','<%=function_id%>','<%=p_called_from_ca%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()"><!-- Menaka --><!--IN041702 included pharmacy_scope & function_id--> <!-- p_called_from_ca add for 71315 -->
		<%
		} 
	} // End of  MainTabsHdg
}
%>
<!--<form name="commonTab" id="commonTab">-->
<form name="OrCommonForm" id="OrCommonForm">
	<table id="tab" name="tab" cellspacing=0 cellpadding="0" border="0" align=center width="100%">
<%
	String location_type 			= request.getParameter("location_type");
	if(location_type!=null && location_type.equalsIgnoreCase("W"))
		location_type	 			= "N";
	String location_code 			= request.getParameter("location_code");
	if(or_module_install_yn.equals("Y"))
	{
%>
	<tr>
	<%
		if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
		{
			for (int i = 0; i < MainTabsHdg.size(); i++) {
			record = (String[]) MainTabsHdg.get(i);
			class_name_first = "CAFIRSTSELECTHORZ";
    
			if (i == 0 || (function_from.equals("EXTERNAL_ORDER") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD"))) {
			class_name_first = "CASECONDSELECTHORZ";
			}
    
			if (record[0].equalsIgnoreCase("existingOrders") && 
				!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))) {
				// Name (record[0] --> Sys_tab_name --> System defined
				%>
				<td id="existingOrders" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap>
					<a style='color:white;cursor:pointer' href="javascript:change_common_tab('ExistingOrders','<%=licence_key%>','<%=function_from%>','','ON_CLICK','<%=multi_called_from%>')">
						<%=record[1]%>
					</a>
				</td>
				<%
				} else if (record[0].equalsIgnoreCase("newOrders")) {
					if (!(function_from.equals("PASSED_ORDERS") && multi_called_from.equals("MULTI_PATIENT_ORDER"))) {
				%>
				<td id="newOrders" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap>
                <a style='color:white;cursor:pointer' href="javascript:change_common_tab('NewOrders','<%=licence_key%>','<%=function_from%>','','ON_CLICK','<%=multi_called_from%>')">
                    <% if (function_from.equalsIgnoreCase("AMEND_ORDER")) out.println("Amend Orders"); else out.println(record[1]); %>
                </a>
            </td>
            <input type="hidden" id="newOrdersPosition" value="<%=i%>"/> <!-- IN069027 -->
            <%
        }
    }
}
	   } // End of MainTabsHdg
%>
<%			// To check whether the user has access to view or not , other wise button gets disabled
		if(p_called_from_ca.equals("Y"))
		{
			//if(ph_module_install_yn.equals("Y"))
			//	drug_display_yn		= beanQueryObj.getMenu("PAT_DRUG_PROFILE",responsibility_id,relationship_id);
			allergy_display_yn 		= beanQueryObj.getMenu("ALLERGY_LST",responsibility_id,relationship_id, properties);
			active_display_yn 		= beanQueryObj.getMenu("PROBLEM_LST",responsibility_id,relationship_id, properties);
			demography_display_yn 	= beanQueryObj.getMenu("DEMOGRAPY_VIEW",responsibility_id,relationship_id, properties);
		}			
		%>			
		<td class="LABEL" width="100%"></td>
		<%
			if(multi_patient_details==null || (multi_patient_details!=null && multi_patient_details.size()==1) ) 
			{
				if(multi_patient_details!=null && multi_patient_details.size() > 0)
				{
				  record					= (String[]) multi_patient_details.get(0);
				  disp_patient_id			=  beanQueryObj.checkForNull(record[0],"");	// FIRST One Patient_id, Second --> encounter-id, third-->patient_class
				}
				%>
				<!-- IN061988 Below line newly add patient_class and encountier_id parameters in callDrugProfile function -->
					<%if(ph_module_install_yn.equals("Y"))
					{%> 
					<td  style="background-color: white; padding-left: 2px; border: 2px solid #000000;border-right: none;border-bottom: 1px solid #e00000;"  >
					<input type="button" name="drug_profile" id="drug_profile" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugProfile.label","common_labels")%>" onClick='callDrugProfile("<%=patient_id%>","<%=patient_class%>","<%=encounter_id%>")'  >
					</td>
					<% } %>
					<td style="background-color: white;border: 2px solid #000000; border-right: none; border-bottom: 1px solid #000000; border-left: none;">
					<input type="button" name="allergies" id="allergies" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")%>" onClick='callAllergies("<%=disp_patient_id%>")' <%if(allergy_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%> >
					</td>
					<td  style="background-color: white;border: 2px solid #000000; border-right: none; border-bottom: 1px solid #000000; border-left: none;">
					<input type='button' name='active' id='active' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActiveProblems.label","common_labels")%>' onClick='callActive("<%=disp_patient_id%>","<%=encounter_id%>")' <%if(active_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%>>
					</td>
					<td style="background-color: white; padding-right: 2px; border: 2px solid #000000; border-bottom: 1px solid #000000; border-left: none;">
					<input type='button' name='demographic' id='demographic' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")%>' onClick='callDemographic("<%=disp_patient_id%>")' <%if(demography_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%>>
					</td>
<% 
		} // end of   multi_patient_details
%>
		</tr>
<%} 
	   else 
	   {
	%>
			<script>
				alert(getMessage("OR_MODULE_INSTALL","OR"));
				document.location.href = "../../eCommon/html/blank.html";
			</script>
		<%		
		}
		%>
	</table>
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
	<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
	<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
	<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
	<input type="hidden" name="module_id" id="module_id" value=""><!-- Used to identify from which tab(Lab,Radiology,Treatment) it is currently used,  -->
	<input type="hidden" name="ph_load_yn" id="ph_load_yn" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
	<input type="hidden" name="ph_priority" id="ph_priority" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
	<input type="hidden" name="ph_order_date_time" id="ph_order_date_time" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
	<input type="hidden" name="params" id="params" value="<%=params%>">
	<input type="hidden" name="called_from" id="called_from" value="ON_LOAD">
	<input type="hidden" name="licence_key" id="licence_key" value="<%=licence_key%>">
	<input type="hidden" name ="cnsnt_with_order_yn" value="<%=cnsnt_with_order_yn%>"> <!-- IN057196 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderSpec" id ="dxChkBfrPlaceOrderSpec" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderMI" id ="dxChkBfrPlaceOrderMI" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderOT" id ="dxChkBfrPlaceOrderOT" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderCN" id ="dxChkBfrPlaceOrderCN" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderLB" id ="dxChkBfrPlaceOrderLB" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderTR" id ="dxChkBfrPlaceOrderTR" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderPC" id ="dxChkBfrPlaceOrderPC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderPH" id ="dxChkBfrPlaceOrderPH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderNC" id ="dxChkBfrPlaceOrderNC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderDS" id ="dxChkBfrPlaceOrderDS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderRX" id ="dxChkBfrPlaceOrderRX" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderRD" id ="dxChkBfrPlaceOrderRD" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderCS" id ="dxChkBfrPlaceOrderCS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")%>"> <!-- IN069027 -->
	<input type="hidden" name ="dxChkBfrPlaceOrderOH" id ="dxChkBfrPlaceOrderOH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")%>"> <!-- IN072036 -->
</form>
</body>
</html> 

 

