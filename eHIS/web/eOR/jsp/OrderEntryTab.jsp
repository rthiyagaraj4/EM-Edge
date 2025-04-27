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
Date       		Edit History   Name       Description
-----------------------------------------------------------------------
?             	100         ?          	created
23/01/2012    	IN030563    Ramesh G	The Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? 
										Prompt once for all categories. 						 
										But the Pin No. is prompted each time we Place a Category and also when we record the category.

25/01/2012		IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
25/09/2012		IN030279	Ramesh G	Bru-HIMS-CRF-160 
22/03/2013		IN030469	DineshT		Order Entry Place order screen to show catalogs on load
13/06/2013		IN038776	Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes
27/05/2019		IN069027	Ramesh G								MMS-DM-CRF-0150
31/05/2023		44884		Krishna		MO-CRF-20183
-----------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>

<%@page import="eOR.*,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<html>
<head><title><fmt:message key="eOR.OrderEntryMain.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// [IN030566] session.setAttribute("TEMP_PASS","");  //[IN030563]
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		//var check_box_val	= new Array(); //Global Variable, used to keep track of the code selected(order wise)
	</script>

	<%

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
        response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String ammend_called_from		= request.getParameter("ammend_called_from");

		beanQueryObj.setLanguageId(localeName);

		if(ammend_called_from == null)
				ammend_called_from 		= "";
		String function_from			= request.getParameter("function_from");
		if(function_from == null)	function_from 	= "";
		//IN030279 Start.
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");		
		//IN030279 End.
		String order_id					= request.getParameter("order_id");
		if(order_id == null)
							order_id 	= "";
		String iv_prep_yn				= request.getParameter("iv_prep_yn");
		String patient_id				= request.getParameter("patient_id");
		if(patient_id == null)	patient_id 	= "";
		//[IN038776] Start.
		if((session.getAttribute(patient_id+"ScreeningServiceValues"))!=null){
				session.setAttribute(patient_id+"ScreeningServiceValues",""); 
		}
		if((session.getAttribute(patient_id+"Check_Boxs"))!=null){
				session.setAttribute(patient_id+"Check_Boxs","");  
		}
		//[IN038776] End.
		String encounter_id				= request.getParameter("episode_id");
		String bean_id 					= request.getParameter("bean_id");
		String bean_name 				= request.getParameter("bean_name");
		String patient_class 			= request.getParameter("patient_class");
		String existing_order_called_from 			= request.getParameter("existing_order_called_from")==null?"":request.getParameter("existing_order_called_from");
		String multi_called_from 			= request.getParameter("multi_called_from")==null?"":request.getParameter("multi_called_from");
		String reject_order 			= request.getParameter("reject_order")==null?"":request.getParameter("reject_order");
		String strGender				="";
		String temp						="";
		String[] newrecord 					= null;
		String[] details 					= null;
		String[] apend 					= null;
		String login_user               = (String) session.getValue("login_user");
		String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
 		if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
		{
			   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
				if (practitioner_details.length == 2)	
				{
			       practitioner_id		= practitioner_details[0];
 				} // End of practitioner_details length
		} // end of if practitioner_id
  		String responsibility_id		= (String) session.getValue("responsibility_id");
		String relationship_id			= request.getParameter("relationship_id");
		//String p_option_function_name	= request.getParameter("p_option_function_name");
		String function_id				= request.getParameter("function_id");
		if(function_id==null)	function_id = "ORDERS";
		
		// Function_id will be passed from Pharmacy module as "MEDICATION_ADMIN"/"EXTERNAL_ORDERS", IF NOTHING IS PASSED DEFAULT IS ORDERS
 	//	String class_value				= "";
		String first_class_value		= "";
		String default_tab				= "";
	    String bt_module_install		= request.getParameter("bt_module_install");
	   	if(bt_module_install==null)	bt_module_install = "";
	   	String called_from				= request.getParameter("called_from");
	   	if(called_from==null)	called_from = "";
		String p_order_catalog_code			= beanQueryObj.checkForNull(request.getParameter("p_order_catalog_code"),"");
   		String p_task_code				= beanQueryObj.checkForNull(request.getParameter("p_task_code"),"");
		String p_task_srl_no			= beanQueryObj.checkForNull(request.getParameter("p_task_srl_no"),"");
		String p_start_date_time		= beanQueryObj.checkForNull(request.getParameter("p_start_date_time"),"");
		
		String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the class
		ArrayList TabsHdg				= new ArrayList();
		String[] record					= null;
		String patfinal="";
		String location_code            =beanQueryObj.checkForNull(request.getParameter("location_code"),"");
		String location_type           =beanQueryObj.checkForNull(request.getParameter("location_type"),"");
		String bed_num                  =beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
		String room_num                 =beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	
	//	String access_bean_id 			= "@accessrightbean"+patient_id+encounter_id;
	//	String access_bean_name			= "eOR.Common.AccessRightBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		//AccessRightBean access_bean   = (AccessRightBean)mh.getBeanObject( access_bean_id, request,  access_bean_name ) ;
	//	AccessRightBean access_bean	    = (AccessRightBean)getBeanObject( access_bean_id, access_bean_name, request ) ;
	   	String transfusion_display_yn   = "X";
	   	if(licence_key.equals("ORFV") && bt_module_install.equals("Y"))
	   	{
	   		ArrayList BloodTransfusion  = new ArrayList();
	   		// Check atleast any one record is present or not
	   		transfusion_display_yn		= beanQueryObj.getMenu("TRANS_HIST",responsibility_id,relationship_id, properties);
			if(!transfusion_display_yn.equals("X") )
	   			BloodTransfusion 		= beanQueryObj.getBloodTransfusion(patient_id, properties);

	   		if(BloodTransfusion.size() == 0)
	   			transfusion_display_yn 	= "X";
		}

		String ph_install_yn			= beanQueryObj.getModuleInstallYn("PH", properties);
		//String patient_details			= beanQueryObj.checkForNull(request.getParameter("patient_details"),"");
  		TabsHdg	= beanQueryObj.getTabs(properties, practitioner_id,patient_class,function_id, ph_install_yn); //Pass the Practitoner_id and the Team_id

	/* Initialize Function specific end */
		String exist_order_category = beanQueryObj.checkForNull(request.getParameter("exist_order_category"),"");;
  		String exist_order_type_code= beanQueryObj.checkForNull(request.getParameter("exist_order_type_code"),"");;
  		//--String exist_activity_type_code= beanQueryObj.checkForNull(request.getParameter("exist_activity_type_code"),"");;
  		//--String exist_activity_type_desc= beanQueryObj.checkForNull(request.getParameter("exist_order_type_code"),"");;
		String exist_activity_type_code="";
		String exist_activity_type_desc="";

 
		ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
		String existing_bean_id		= "";
		String existing_bean_name	= "";
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";

		if(function_from.equals("EXTERNAL_ORDER")) 
		{ // Get the Bean Instance of External Orders
			if(called_from.equalsIgnoreCase("OH"))
			{
				external_bean_obj	    = (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
				external_bean_obj.setOrderCatalogCode(beanQueryObj.checkForNull(request.getParameter("p_order_catalog_code"),""));
				external_bean_obj.setOrderCategory("CS");
			 	external_bean_obj.setOrderType(beanQueryObj.checkForNull(request.getParameter("order_type_code"),""));
				external_bean_obj.setCalledFrom("OH");
				putObjectInBean(existing_bean_id,external_bean_obj,request);
			}
		}  

		if(function_from.equals("EXTERNAL_ORDER")) 
		{ // Get the Bean Instance of External Orders
			
			//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  	existing_bean_name ) ;
			external_bean_obj	    = (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
			p_order_catalog_code	= beanQueryObj.checkForNull(external_bean_obj.getOrderCatalogCode(),"");
			exist_order_category	= beanQueryObj.checkForNull(external_bean_obj.getOrderCategory(),"");
			exist_order_type_code	= beanQueryObj.checkForNull(external_bean_obj.getOrderType(),"");
			exist_activity_type_code	= beanQueryObj.checkForNull(external_bean_obj.getActivity_Type(),"");
			exist_activity_type_desc	= beanQueryObj.checkForNull(external_bean_obj.getActivity_Desc(),"");
					
			//Modified by Ambiga.M for 19623 (if condition added to avoid nullPointer exception)
			if(!patient_id.equals(""))
			{
				ArrayList patDetails=external_bean_obj.getPatientName(patient_id) ;
				for( int i=0 ; i< patDetails.size() ; i++ ) 
				{
					newrecord = (String[])patDetails.get(i);
				}
			temp= newrecord[0];
			details=temp.split(":");
			apend=details[1].split("/");
			
			
			if(newrecord[1].equals("M"))
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");					
			}
			else if(newrecord[1].equals("F"))
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					
			}
			else
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					
			}
			 patfinal=details[0]+":"+strGender+"/"+apend[1];
		 }

		} else if(function_from.equals("CP") || function_from.equals("MO")) 
		{	// For CP/MO
		// Get the order_category and the order_type_code
 			String[] category_details= new String[2];	
			category_details		= beanQueryObj.getCategoryDetails(properties, p_order_catalog_code); // Get the 	Details
			exist_order_category	= beanQueryObj.checkForNull(category_details[0],"");
			exist_order_type_code	= beanQueryObj.checkForNull(category_details[1],"");
			category_details		= null; // Nullifying the objects
 		}// End of function-from

 		String frequent_orders_allowed_yn	=  "N"; // Remove this variable and reference later, when frequent order is given
		String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("pharmacy_scope"),"");
	//IN069027 starts
		OrderEntryBean bean1					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean1.setLanguageId(localeName);
		//44884 Start.
		String practitionerRel=bean1.getPractitionerRelation(bean1.getPractitionerId(),patient_id);
		HashMap restrictedNewOrdersSF=bean1.restrictedNewOrdersSF(bean1.getPractitionerId(),practitionerRel,function_from);
		//44884 End.
		String  ph_instal_yn						= bean1.getModuleInstallYn("PH");	
	//IN069027 ends
	%>
	<STYLE>	<!-- override the color from the IeStyle.css -->
		TD.OR_PLACEORDER 
		{
			color:BLACK;
			FONT-SIZE: 8pt ;
			background-color:#C0C0C0;
			border-width: thin ;
			border-style: double ;
			BORDER-LEFT-COLOR: RED;
			BORDER-RIGHT-COLOR: RED;
			BORDER-TOP-COLOR: RED;
			BORDER-BOTTOM-COLOR: RED ;
		}
	</STYLE>
</head>
 
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 	<form name="formTab" id="formTab" >
	<table id="tab" cellspacing=0 cellpadding="0" border="0">
	<tr>
	<%
	if(TabsHdg!=null && TabsHdg.size() > 0 ) 
	{
		for(int i=0; i<TabsHdg.size(); i++)
		{
			record = (String[])TabsHdg.get(i);
 			if(i==0)	// Only for the first record
			{
			
 				first_class_value	= "CASECONDSELECTHORZ";
				if(record[i].equalsIgnoreCase("frequentOrders")) 
				{ 
					default_tab		= "FrequentOrders";	// Get only the first tab, so that to load 
					if(frequent_orders_allowed_yn.equals("Y"))
					{
						default_tab		= "FrequentOrders";	// Get only the first tab, so that to load 
					//else if(record[i].equalsIgnoreCase("drawingTools") || drawing_tools_allowed_yn.equals("Y") ) 
					//	default_tab		= "DrawingTools";	
					}
					else 
					{
						default_tab		= "AdditionalSearch";	// Get only the first tab, so that to load 
					}
   				} else if(record[i].equalsIgnoreCase("additionalSearch"))
				{
					default_tab		= "AdditionalSearch";	// Get only the first tab, so that to load the tab(obj-->name-->called on click of the hyperlink)
				}
				else if(record[i].equalsIgnoreCase("tickSheet"))
				{
					default_tab		= "TickSheet";			// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("image"))
				{
					default_tab		= "Image";				// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("careSet"))
				{
					default_tab		= "CareSet";			// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("placeOrder"))
				{
					default_tab		= "PlaceOrder";			// Get only the first tab, so that to load the tab
				}
 				if((function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equals("RENEW_ORDER"))||function_id.equalsIgnoreCase("MEDICATION_ADMIN")||function_id.equalsIgnoreCase("EXTERNAL_ORDERS")||pharmacy_scope.equals("PH"))
				{
					if(function_from.equalsIgnoreCase("COPY_ORDER"))
					{
						existing_bean_id				= "@existingorderbean"+patient_id+encounter_id;
						existing_bean_name				= "eOR.ExistingOrder";
						ExistingOrder existing_bean_obj = (ExistingOrder)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
						ArrayList copyOrderDetails			= new ArrayList();
						copyOrderDetails = (ArrayList)existing_bean_obj.getCopyOrderDetails();
						if(copyOrderDetails!=null)
						{
							default_tab		= "PlaceOrder";			// Get only the first tab, so that to load the tab
						}						
					}
					else
					{
						default_tab		= "PlaceOrder";		
					}
				}
			} 
			else 
			{
				first_class_value		= "CAFIRSTSELECTHORZ";
				//	class_value				= "CAFIRSTSELECTHORZ";
			}
			
			if(default_tab.equals("PlaceOrder"))
			{
				first_class_value	= "CAFIRSTSELECTHORZ";
			//	class_value			= "CASECONDSELECTHORZ";
			}
 			if(licence_key.equals("ORPV") && called_from.equals("ON_LOAD"))
			{
				default_tab				= "PlaceOrder";
				first_class_value		= "CAFIRSTSELECTHORZ";
			//	class_value 			= "CASECONDSELECTHORZ";
			}
			 if(record[0].equalsIgnoreCase("frequentOrders")  && frequent_orders_allowed_yn.equals("Y"))  
			{ //Name (record[0] --> Sys_tab_name --> System defined
			 
			%>			 	
					<td id="frequentOrders" class="<%=first_class_value%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="display(this)" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_tab('FrequentOrders')"><%=record[1]%></a></td>
			 
 
			 
			<%
				} 
				else if(record[0].equalsIgnoreCase("additionalSearch") && !function_from.equals("HIGH_RISK_ASSESS")) //IN030469
				{ //Name (record[0] --> Sys_tab_name --> System defined

					if((!called_from.equalsIgnoreCase("OH"))&&(!(function_id.equalsIgnoreCase("MEDICATION_ADMIN")))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
					{
					%>
						<td id="additionalSearch" class="<%=first_class_value%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="display(this)" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_tab('AdditionalSearch')"><%=record[1]%></a></td>
					<%	
					}
				} 
				else if(record[0].equalsIgnoreCase("tickSheet") && !function_from.equals("HIGH_RISK_ASSESS"))  //IN030469
				{ 
					
					if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
					{
					%>
						<td id="tickSheet" class="<%=first_class_value%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="display(this)" nowrap><a style='color:white;cursor:pointer'  href="javascript:change_tab('TickSheet')"><%=record[1]%></a></td>
					<%
					}
				} 
				else if(record[0].equalsIgnoreCase("image") && !function_from.equals("HIGH_RISK_ASSESS")) //IN030469
				{
					if(licence_key.equals("ORFV") && !function_from.equals("EXTERNAL_ORDER"))
					{ 
						if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))						
						{
						%>
							<td id="image" class="<%=first_class_value%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="display(this)" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_tab('Image')"><%=record[1]%></a></td>
						<%
						}
					}
				} 
				else	if(record[0].equalsIgnoreCase("careSet") && !function_from.equals("HIGH_RISK_ASSESS"))    //IN030469
				{
 					 if(!function_from.equals("AMEND_ORDER") && !function_from.equals("EXTERNAL_ORDER"))					
					{ 	// For New Orders
						if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
						{
					%>
						<td id="careSet"  class="<%=first_class_value%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="display(this)" nowrap><a style='color:white;cursor:pointer' href="javascript:change_tab('CareSet')"><%=record[1]%></a></td>
					<%
						}
					}
				} 
				else if(record[0].equalsIgnoreCase("placeOrder"))  
				{ 
				%>
				
					<td id="placeOrder"	 class="OR_PLACEORDER"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);"  nowrap>
					<a style='color:white;cursor:pointer' href="javascript:checkPharmacy(this)"><%=record[1]%></a></td> <!--IN030469--><!--IN069027 checkPharmacy method added-->
			<%	
				}
			} // End of for
		} // End of if TabsHdg.size()
	
		if(function_from.equals("EXTERNAL_ORDER")) 
		{ 
		%>
			<td id="patientDetails" class="LABEL"><b><%=patfinal%></b></td>			
		<%
		} 
		if(licence_key.equals("ORFV") && bt_module_install.equals("Y") && !transfusion_display_yn.equals("X")) 
		{ 
		%>
			<td id="empty_tab" colspan="6" width="60%" >&nbsp;</td>
			<td id="bloodTransfusion" width="22%"  class="EMERGENT" align="right" ><a style='color:white;cursor:pointer' href="javascript:callBloodHistory()" title="Blood Transfusion" COLOR="BLUE"><font size="1"><b><fmt:message key="Common.TransfusionHistory.label" bundle="${common_labels}"/></b></font></a></td> 
		<%
		}
		%>


		<%	
		if(frequent_orders_allowed_yn.equals("Y")) 
		{
		%>
			<input type='hidden' name='flag' id='flag' value='FrequentOrders'>
		<%
		} 
		else 
		{ %>
			<input type='hidden' name='flag' id='flag' value='AdditionalSearch'>
		<%	
		} 
		%>			
	</tr>
	</table>
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
	<!-- IN030279 Start -->
	<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
	<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
	<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
	<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
	<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
	<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
	<!-- IN030279 End. -->
   	<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
   	<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
	<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
	<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
	<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
	<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
	<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
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
	<input type="hidden" name="p_order_catalog_code" id="p_order_catalog_code" value="<%=p_order_catalog_code%>">
	<input type="hidden" name="p_start_date_time" id="p_start_date_time" value="<%=p_start_date_time%>">
	<input type="hidden" name="p_task_code" id="p_task_code" value="<%=p_task_code%>">
	<input type="hidden" name="p_task_srl_no" id="p_task_srl_no" value="<%=p_task_srl_no%>">
	<input type="hidden" name="ck<%=p_order_catalog_code%>" id="ck<%=p_order_catalog_code%>" value="Y">	<!--catalog_code-->
	<input type="hidden" name="h1<%=p_order_catalog_code%>" id="h1<%=p_order_catalog_code%>" value="<%=exist_order_category%>"><!--exist_order_category-->
	<input type="hidden" name="h2<%=p_order_catalog_code%>" id="h2<%=p_order_catalog_code%>" value="<%=exist_order_type_code%>"><!--exist_order_type_code-->
	
	<input type="hidden" name="exist_activity_type_code" id="exist_activity_type_code" value="<%=exist_activity_type_code%>">
	<input type="hidden" name="exist_activity_type_desc" id="exist_activity_type_desc" value="<%=exist_activity_type_desc%>">
	<input type="hidden" name="existing_order_called_from" id="existing_order_called_from" value="<%=existing_order_called_from%>">
	<input type="hidden" name="multi_called_from" id="multi_called_from" value="<%=multi_called_from%>">
	<input type="hidden" name="reject_order" id="reject_order" value="<%=reject_order%>">
	<input type="hidden" name="ph_instal_yn" id="ph_instal_yn" value="<%=ph_instal_yn%>">
	<!-- 44884 Start. -->
	<input type="hidden" name ="practitionerRel" id ="practitionerRel" value="<%=beanQueryObj.checkForNull(practitionerRel,"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSMI" id ="restBfrPlaceOrderSMI" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSMI"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSOT" id ="restBfrPlaceOrderSOT" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOT"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSCN" id ="restBfrPlaceOrderSCN" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCN"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSLB" id ="restBfrPlaceOrderSLB" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSLB"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSTR" id ="restBfrPlaceOrderSTR" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSTR"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSPC"  id ="restBfrPlaceOrderSPC" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSPH"  id ="restBfrPlaceOrderSPH" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPH"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSNC" id ="restBfrPlaceOrderSNC" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSNC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSDS" id ="restBfrPlaceOrderSDS" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSDS"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSRX" id ="restBfrPlaceOrderSRX" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRX"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSRD"  id ="restBfrPlaceOrderSRD" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRD"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderSCS" id ="restBfrPlaceOrderSCS" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCS"),"N")%>">			
	<input type="hidden" name ="restBfrPlaceOrderSOH"  id ="restBfrPlaceOrderSOH" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOH"),"N")%>">

	<input type="hidden" name ="restBfrPlaceOrderFMI" id ="restBfrPlaceOrderFMI" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFMI"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFOT" id ="restBfrPlaceOrderFOT" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOT"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFCN" id ="restBfrPlaceOrderFCN" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCN"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFLB"  id ="restBfrPlaceOrderFLB" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFLB"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFTR" id ="restBfrPlaceOrderFTR" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFTR"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFPC"   id ="restBfrPlaceOrderFPC" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFPH"  id ="restBfrPlaceOrderFPH" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPH"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFNC" id ="restBfrPlaceOrderFNC" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFNC"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFDS" id ="restBfrPlaceOrderFDS" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFDS"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFRX"  id ="restBfrPlaceOrderFRX" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRX"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFRD" id ="restBfrPlaceOrderFRD" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRD"),"N")%>">
	<input type="hidden" name ="restBfrPlaceOrderFCS"  id ="restBfrPlaceOrderFCS" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCS"),"N")%>">			
	<input type="hidden" name ="restBfrPlaceOrderFOH" id ="restBfrPlaceOrderFOH" value="<%=beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOH"),"N")%>">
	<!-- 44884 End. -->
</form>
	<script>change_tab("<%=default_tab%>")</script>
	<script>
	//IN030469, starts
	if('<%=function_from%>' == 'HIGH_RISK_ASSESS')
	document.getElementById('placeOrder').click();
	//IN030469, ends
	</script>
<%
	if(!p_order_catalog_code.equals("")) // When only comes from external order
			out.println("<script>loadPreview(\""+function_from+"\",\""+p_order_catalog_code+"\",\""+exist_order_category+"\")</script>");
%>
</body>
</html>

<%

		// set it back persistence		(no need to set)
		//putObjectInBean(bean_id,bean,request);
		//putObjectInBean(access_bean_id,access_bean,request);
		
%>

