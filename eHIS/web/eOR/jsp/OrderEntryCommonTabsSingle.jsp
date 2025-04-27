<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>

<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%  request.setCharacterEncoding("UTF-8");
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
	
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>	
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script><!-- Used for Prescription -->
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		
		function change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from)
		{ 
			
			if((obj=="ExistingOrders" && licence_key=="ORPV" && called_from=="ON_LOAD"))
			{
				colorChange();
				
				parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from;
			}
			else if( obj=="ExistingOrders" && (function_from!="EXTERNAL_ORDER" || function_from!="MULTI_PATIENT_ORDERS" || function_from!="CP" || function_from!="MO"|| function_from!="REPLACE_ADD" )  )
			{			
				if(pharmacy_scope!='' && pharmacy_scope=='PH')
				{
					colorChange();
					parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&pharmacy_scope="+pharmacy_scope;
				}
				else if(obj=="ExistingOrders")
				{
   		  			parent.orderDetailFrame.location.href = "../../eOR/jsp/ExistingOrder.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&function_from="+function_from;

					if(multi_called_from=="MULTI_PATIENT_ORDER")
					{
						if(document.OrCommonForm.newOrders)
						{
							document.OrCommonForm.newOrders.style.display = "none";
						}
					}

				}
				
		  	}			
			else if(obj=="NewOrders")
			{
				parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from;
			}
			else
				{
   		  			parent.orderDetailFrame.location.href = "../../eOR/jsp/ExistingSingleOrder.jsp?<%=request.getQueryString()%>&licence_key="+licence_key+"&called_from="+called_from+"&function_from="+function_from;

					if(multi_called_from=="MULTI_PATIENT_ORDER")
					{
						if(document.OrCommonForm.newOrders)
						{
							document.OrCommonForm.newOrders.style.display = "none";
						}
					}

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
	String params					= request.getQueryString() ;
   	String bed_num                  = beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
	String room_num                 = beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	
	String multi_bean_id 			= "Or_MultiPatientOrders";
	String multi_bean_name 			= "eOR.MultiPatientOrdersBean";
	String facility_id				= (String)session.getValue("facility_id");
	Properties properties			= (Properties) session.getValue( "jdbc" );
	beanQueryObj.setLanguageId(localeName);	
	
	String function_from			= beanQueryObj.checkForNull(request.getParameter("function_from"),"");
 	
	ArrayList multi_patient_details	=  null;
	if(function_from != null && function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
		
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
	
	String function_id				= beanQueryObj.checkForNull(request.getParameter("function_id"),"ORDERS");
  	
  	String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String allergy_display_yn 		= "";
	String active_display_yn 		= "";
	String demography_display_yn 	= "";
	
	String disabledField			= "";
	String disp_patient_id			= patient_id;
	
	String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
	String login_user               = (String) session.getValue("login_user");
	String patient_class			= beanQueryObj.checkForNull(request.getParameter("patient_class"),"");

	String class_name_first			= "";

	String record[]					= null;
	if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
	{
	   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
	   if (practitioner_details.length == 2) 
		{
	       practitioner_id		= practitioner_details[0];
	    } 
	}
	ArrayList MainTabsHdg		= beanQueryObj.getMainTabs(properties, practitioner_id, patient_class, function_id); 
	
	String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("p_scope"),"");

%>
<%
	if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
	{
		for(int i=0; i<MainTabsHdg.size(); i++)
		{
			record = (String[])MainTabsHdg.get(i);
					
			if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))))
			{ 			
				%>				
				<body onLoad="change_common_tab('','<%=licence_key%>','<%=function_from%>','<%=pharmacy_scope%>','ON_LOAD','<%=multi_called_from%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<%
			}
			else if((record[0].equalsIgnoreCase("newOrders")) && (!(function_from.equals("PASSED_ORDERS")) ) )  
			{
				%>	
				<body onLoad="change_common_tab('ExistingOrders','<%=licence_key%>','<%=function_from%>','','ON_LOAD','<%=multi_called_from%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<%
			} 
		} 
	}
%>

<form name="OrCommonForm" id="OrCommonForm">
	<table id="tab" cellspacing=0 cellpadding="3" border="0" align=center width="100%">
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
			for(int i=0; i<MainTabsHdg.size(); i++)
			{
				record					= (String[])MainTabsHdg.get(i);
				class_name_first		= "CAFIRSTSELECTHORZ";
				if(i==0 || (function_from.equals("EXTERNAL_ORDER") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD" )) )	// Only for the first record
					class_name_first	= "CASECONDSELECTHORZ";
				if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER") )) ) 
				{  //Name (record[0] --> Sys_tab_name --> System defined 
				%> 
					<td id="existingOrders" 	class="<%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('','<%=licence_key%>','<%=function_from%>','','ON_CLICK','<%=multi_called_from%>')">One Day - Continue</a></td>
<% 			} 
				else if((record[0].equalsIgnoreCase("newOrders"))) //&& (!(function_from.equals("PASSED_ORDERS")) ) )
				{  
					if((function_from.equals("PASSED_ORDERS")) &&(multi_called_from.equals("MULTI_PATIENT_ORDER")))
					{
					}
					else
					{
%>
					<td id="ExistingOrders" 	class="<%=class_name_first%>"  style="display:" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('ExistingOrders','<%=licence_key%>','<%=function_from%>','','ON_CLICK','<%=multi_called_from%>')"> <% if(function_from.equalsIgnoreCase("AMEND_ORDER")) out.println("Amend Orders"); else out.println("Existing Orders"); %></a></td>
					
<%			} 
			  }
			} // End of for
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
					<td class="COMMON_BUTTONS"  width="30%" style="display:none"><%if(ph_module_install_yn.equals("Y")){%> <input type="button" name="drug_profile" id="drug_profile" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugProfile.label","common_labels")%>" onClick='callDrugProfile("<%=patient_id%>")'  ><% } %><input type="button" name="allergies" id="allergies" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")%>" onClick='callAllergies("<%=disp_patient_id%>")' <%if(allergy_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%> ><input type='button' name='active' id='active' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActiveProblems.label","common_labels")%>' onClick='callActive("<%=disp_patient_id%>","<%=encounter_id%>")' <%if(active_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%>><input type='button' name='demographic' id='demographic' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")%>' onClick='callDemographic("<%=disp_patient_id%>")' <%if(demography_display_yn.equals("X")) out.println("DISABLED");%>  <%=disabledField%>></td>
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
</form>
</body>
</html> 

 

