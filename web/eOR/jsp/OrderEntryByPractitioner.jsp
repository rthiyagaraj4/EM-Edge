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
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name       	R.Date		R.Name			 Description
-------------------------------------------------------------------------------------------------------
?             100            ?             		?							  created
27/11/2012	  IN036387		Ramesh G			?						MO Transactions->Manage Deceased/Body Part ->Specimen->Place Order->Place a Order Set category-> We get Internal Server Error 	
13/12/2013	  BS_INTN0001 Vijayakumar K 		?						reloading continuously when click on cancel in confirm dialog.
21/05/2014    IN044502     Chowminya			?						Bru-HIMS-CRF-400 
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
14/10/2019    IN071315	    Nijitha S   	23/10/2019	Ramesh G		GHL-CRF-0607	
-------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>

<%@ page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<jsp:useBean id="beanBillQueryObj" scope="page" class="eOR.OrderEntryBillingQueryBean"/>
<jsp:useBean id="OrScheduleFreq" scope="page" class="eOR.ScheduleFrequencyCompBean"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	String function_from			= request.getParameter("function_from");
	if(function_from==null) function_from = "";
	String p_called_from_widget = ((String)request.getParameter("p_called_from_widget"))==null?"":(String)request.getParameter("p_called_from_widget");//IN044502
 	String bean_id 					= "@orderentrybean"+patient_id+encounter_id;
	String bean_name 				= "eOR.OrderEntryBean";
	String ph_bean_id				= "";
	String ph_bean_name 			= "";
	String patient_class			= "";
	localeName = (String)session.getAttribute("LOCALE");
	beanQueryObj.setLanguageId(localeName);
	beanBillQueryObj.setLanguageId(localeName);

	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;

	bean.setLanguageId(localeName);
	bean.clearTemp();

	// Internally it will call the initialize() method in the bean which will initialize the values.
	bean.clear();  		// Clear the values in the bean(Only in this case, as exception this method is called,otherwise only on Record)
	String pharmacy_scope			= bean.checkForNull(request.getParameter("pharmacy_scope"),"");
%>

<html>
<head><title><fmt:message key="eOR.SearchForOrderingPractitioner.label" bundle="${or_labels}"/></title>

<% 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
	var message_yn = true;//BS_INTN0001	
	</script>
	<!--onLoad="validateOnLoad();"-->
</head>
	<iframe name="mainFrame" id="mainFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:100vh;width:99vw"></iframe>
	
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<%		
	// To clear the Values of the Pharmacy Bean (Prescription) & Drug Search Bean
	//out.println("<script>alert('in order entry by practitioner"+request.getQueryString()+"');</script>");
		String module_install_yn	= "N";
		module_install_yn 			= bean.checkForNull(bean.getModuleInstallYn("PH"),"N"); //Check if the PH module is installed or not
		if(!function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
		{
			if(module_install_yn.equalsIgnoreCase("Y")) // Only if Ph Module is installed
			{
				ph_bean_id 				= "@PrescriptionBean_1"+patient_id+encounter_id;
				ph_bean_name 			= "ePH.PrescriptionBean_1";
				//ePH.PrescriptionBean_1 ph_bean	= (ePH.PrescriptionBean_1)mh.getBeanObject( ph_bean_id, request,  ph_bean_name ) ;
				ePH.PrescriptionBean_1 ph_bean		= (ePH.PrescriptionBean_1)getBeanObject( ph_bean_id, ph_bean_name, request ) ;
				ph_bean.clear();  // Clear the values from the PH(Prescription) bean
				// Clear the PH Drug search also
				ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
				ph_bean_name 			= "ePH.DrugSearchBean";
				//ePH.DrugSearchBean ph_drug_bean	= (ePH.DrugSearchBean)mh.getBeanObject( ph_bean_id, request,  ph_bean_name ) ;
				ePH.DrugSearchBean ph_drug_bean		= (ePH.DrugSearchBean)getBeanObject( ph_bean_id, ph_bean_name, request ) ;
				ph_drug_bean.clear();  // Clear the values from the PH(Prescription) bean

				// set it back persistence
				//ph_bean_id 				= "@PrescriptionBean_1"+patient_id+encounter_id;
			}
		}


	   // Till here
	//	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
		//orderEntryRecordBean.setPatient(bean.getPatientId()); // Set for the current patient
		bean.clearDataBean(); // Clear the data stored(checked values if any) (Only in this case, as exception this method is called, otherwise only on Record)
		bean.clearBillBean();
		// Accessing the Multi Patient Orders Bean
		if(function_from.equals("MULTI_PATIENT_ORDERS"))
		{
			String multi_bean_id 			= "Or_MultiPatientOrders";
			String multi_bean_name 			= "eOR.MultiPatientOrdersBean";
			//MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)mh.getBeanObject( multi_bean_id, request,  multi_bean_name ) ;
			MultiPatientOrdersBean multi_bean= (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
			ArrayList multi_patient_details	= multi_bean.getMultiPatientDetails();
			bean.setMultiPatientDetails(multi_patient_details);// Set it in the Order Entry Bean, all the details

			// set it back in the persistence
			//putObjectInBean(multi_bean_id,multi_bean,request);
		}
		 
	/* Initialize Function specific end */

	String responsibility_id		= (String) session.getValue("responsibility_id");
	String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
	String practitioner_name		= (String) session.getValue("practitioner_name");
	String login_user               = (String) session.getValue("login_user");
	Properties properties			= (Properties) session.getValue( "jdbc" ); // Get the Properties to get pass and get the connection when ur using query bean and not using ur functional beans

	
	bean.setLoginPractId(practitioner_id) ;	

	if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
	{
 	   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties,login_user);
	   if (practitioner_details.length == 2) 
	   {
	       practitioner_id = practitioner_details[0];
	       practitioner_name = practitioner_details[1];
	   } // End of practitioner_details length
	} // end of if practitioner_id
	String practitioner_type    	= (String) session.getValue("practitioner_type");
	String facility_name			= (String) session.getValue("facility_name");
	patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");

	if(function_from.equals("EXTERNAL_ORDER")) 
	{
		practitioner_id    			= bean.checkForNull(request.getParameter("practitioner_id"),"");
		practitioner_name    		= bean.checkForNull(request.getParameter("practitioner_name"),"");
	}
	//if(patient_class.equalsIgnoreCase("EM"))
	//	location_type				= "E";
	//else if(patient_class.equalsIgnoreCase("DC"))
	//	location_type				= "D";

	if(location_type.equalsIgnoreCase("W"))
		location_type				= "N";
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");

	String relationship_id			= bean.checkForNull(request.getParameter("relationship_id"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");//IN071315
	String cname					= bean.checkForNull(request.getParameter("cname"),""); // If needed for the frame color
	String sex						= bean.checkForNull(request.getParameter("Sex"),"");
	String age						= bean.checkForNull(request.getParameter("Age"),"");
	String dob						= bean.checkForNull(request.getParameter("Dob"),""); 
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");  
	String ammend_called_from		= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_id					= bean.checkForNull(request.getParameter("order_id"),"");
	String order_line_num			= bean.checkForNull(request.getParameter("order_line_num"),"");
	String accession_type			= bean.checkForNull(request.getParameter("accession_type"),"");
	String accession_number			= bean.checkForNull(request.getParameter("accession_number"),"");
	String invoke_function          = bean.checkForNull(request.getParameter("invoke_function"),"");
	// If it is an Amend/Review order, call a method to set the value in the bean.
	if(function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("RENEW_ORDER"))
	{
		bean.setCalledFromFunction(function_from);
		bean.setOrderId(order_id);
		bean.setOrderLineNo(order_line_num);
		bean.setAmendOrder(ammend_called_from);
	}
	//IN044502 - Start
	if("CURRENT_MEDICATION".equals(p_called_from_widget))
	{
		HashMap hmRenewOrders = bean.getRenewOrderIds();
		if(null!=hmRenewOrders && hmRenewOrders.size() > 0)
		{
		bean.setCalledFromFunction("RENEW_ORDER");
		function_from = "RENEW_ORDER";
		}
	}
	//IN044502 - End
 	String order_category_yn 		= "";
	String order_type_code_yn 		= "";
	String order_privilege_level 	= "", op_episode_visit_num		= "";
	String pin_ident_by_category_yn = "", episode_id				= "";
	String attend_practitioner_id	= "", attend_practitioner_name	= "";
	String discharge_date_time		= "", service_code				= "";
	String sys_date					= "", team_id					= "";

	ArrayList billingInformation	= null;
	ArrayList PrEncounterDtls		= null;
	ArrayList newPatientReferalDtls	= null;
	String[] record 				= null;
	String billing_warning_message	= "";
	String billing_error_message	= "";
	boolean billing_error_disp		= true;
	//String PrivilegeApplicability = "N";
	String PrivilegeApplicabilityAuth = "N";
	String PrivilegeApplicabilityOrd = "N";
	String[] amendRecords 			 = null;
	String adtstatus 				 = "";
	String patientDischarged		 = "N";
	// Get the Sydate (Dual)
	sys_date						= bean.checkForNull(bean.getSysDate(),"");

	// Get the Values for the Presel Select
	StringTokenizer stPreSel = new StringTokenizer(beanQueryObj.getPreselSelectValues(properties),"~~");

	while(stPreSel!=null && stPreSel.hasMoreTokens())
	{
	 	order_category_yn 			= bean.checkForNull(stPreSel.nextToken(),"N");
 	 	order_type_code_yn 			= bean.checkForNull(stPreSel.nextToken(),"N");
	 	order_privilege_level		= bean.checkForNull(stPreSel.nextToken(),"");
	 	pin_ident_by_category_yn	= bean.checkForNull(stPreSel.nextToken(),"");
	}

 		// If it called from CP, set this parameters again in the bean, since these standard
		// Parameters are not passed from CP, they are null.
 	 
	if(encounter_id!=null && (!encounter_id.equals("")) && (function_from.equals("CP") || function_from.equals("MO")||(function_from.equals("MULTI_PATIENT_ORDERS"))))
   {
		PrEncounterDtls  = beanQueryObj.getCPSTDPREncounterDetails(properties, bean.getLoginFacilityId(),encounter_id);
		for(int j=0; j<PrEncounterDtls.size(); j++)
		{
			record 						= (String[])PrEncounterDtls.get(j);

			/*Added by Uma on 12/7/2010 for IN025361*/
			if(function_from.equals("MULTI_PATIENT_ORDERS"))
			{
				location_type				= bean.checkForNull(record[8],"");
			}
			else
			{
				attend_practitioner_id		= bean.checkForNull(record[0],practitioner_id);
				attend_practitioner_name	= bean.checkForNull(record[1],practitioner_name);
				discharge_date_time			= bean.checkForNull(record[2],"");
				episode_id					= bean.checkForNull(record[3],"");
				op_episode_visit_num		= bean.checkForNull(record[4],"");
				team_id						= bean.checkForNull(record[5],"");
				service_code				= bean.checkForNull(record[6],"");
				//IN036387 Start
				//visit_adm_date				= bean.checkForNull(record[7],"");
				if(function_from.equals("MO")){
					visit_adm_date				= bean.checkForNull(record[14],"");
				}else{
					visit_adm_date				= bean.checkForNull(record[7],"");
				}
				//IN036387 End.
				location_type				= bean.checkForNull(record[8],"");
				location_code				= bean.checkForNull(record[9],"");
				patient_class				= bean.checkForNull(record[10],"XT");
				sex							= bean.checkForNull(record[11],"");
				dob							= bean.checkForNull(record[12],"");
				age							= bean.checkForNull(record[13],"");
			}
		}
	} // End of function_from CP/MO (Module)
	else if((encounter_id==null || encounter_id.equals("") || encounter_id.equals("null")) && patient_class.equals("XT") && !function_from.equals("EXTERNAL_ORDER")) 
	{
		newPatientReferalDtls			= beanQueryObj.getNewBornReferralDetails(properties, bean.getLoginFacilityId());
		// If more than One record,  is there, then come out and display the alert
		if(newPatientReferalDtls.size()==1) 
		{
			for(int j=0; j<newPatientReferalDtls.size(); j++)
			{
				record 						= (String[])newPatientReferalDtls.get(j);
				location_code				= bean.checkForNull(record[0],"");
				location_type				= "R";
				record						= null;
			}
			if(location_code.equals(""))
			{
				out.println( "<script>alert(getMessage('REFERRAL_RECORD_NOT_FOUND','OR')); </script>" ) ;	
				return; //do not proceed
			}
		} // End of newPatientReferalDtls
		else if(newPatientReferalDtls.size()<1)
		{
			out.println( "<script>alert(getMessage('REFERRAL_RECORD_NOT_FOUND','OR')); </script>" ) ;	
			return; //do not proceed
		}
		else if(newPatientReferalDtls.size()>1)
		{
			out.println( "<script>alert(getMessage('REFERRAL_MORE_THAN_ONE_RECORD','OR')); </script>" ) ;	
			return; //do not proceed
		}
		if(newPatientReferalDtls!=null)
		{
			newPatientReferalDtls.clear();
			newPatientReferalDtls= null;
		}
	} //End of paitent_class.equals("XT") && !function_from.equals("PASSED_ORDERS")
		
	attend_practitioner_id	= bean.checkForNull(attend_practitioner_id,practitioner_id);
	attend_practitioner_name= bean.checkForNull(attend_practitioner_name,practitioner_name);
	patient_class			= bean.checkForNull(patient_class,"XT");
	

	//Set the Parameter values and other to the Bean

	//OrScheduleFreq.setPatientId(patient_id); // set the Patient Id
	//OrScheduleFreq.setEncounterId(encounter_id);
	session.putValue("Schdpatient_id",patient_id);
	session.putValue("Schdencounter_id",encounter_id);
	session.putValue("Schdpatient_id",patient_id);
	session.putValue("Schdencounter_id",encounter_id);
	bean.setPatientId(patient_id); // set the Patient Id
	bean.setEncounterId(encounter_id);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setResponsibilityId(responsibility_id);
	bean.setCalledFromCA(p_called_from_ca);
	bean.setRelationshipId(relationship_id);
	bean.setLocationType(location_type);
	bean.setLocationCode(location_code);
	bean.setSysDate(sys_date);// Set the Date

	bean.setPatientClass(patient_class);
	bean.setPractitionerId(practitioner_id);
	bean.setPractitionerName(practitioner_name);
	bean.setPractitionerType(practitioner_type);
	//if(!function_from.equals("MULTI_PATIENT_ORDERS"))
	bean.setOrderCategoryYn(order_category_yn);
	//else
		//bean.setOrderCategoryYn(order_category_yn);
	bean.setOrderTypeCodeYn(order_type_code_yn);
	bean.setOrderPrivilegeLevel(order_privilege_level);
	bean.setPinIdentByCategoryYn(pin_ident_by_category_yn);
	bean.setFrameColor(cname);
	bean.setSex(sex);
	bean.setAge(age);
	bean.setDob(dob);
	bean.setFacilityName(facility_name);
	bean.setVisitAdmDate(visit_adm_date);
	bean.setAccessionType(accession_type);
	bean.setAccessionNumber(accession_number);
	bean.setInvokeFunction(invoke_function);
	adtstatus = (String)beanQueryObj.getAdtStatus(properties,bean.getEncounterId(),bean.getLoginFacilityId());
	if(adtstatus.equalsIgnoreCase("08"))
	{
		patientDischarged = "Y";
	}
	else
	{
		patientDischarged = "N";
	}
	bean.setPatientDischarged(patientDischarged);
	// Till here
	
	// Get the Attend Practitioner Id and Attending Practitioner Name and Set it

	if((!bean.checkForNull(bean.getEncounterId(),"").equals("")) && !function_from.equals("CP") && !function_from.equals("MO"))
	{
		PrEncounterDtls  = beanQueryObj.getPREncounterDetails(properties, bean.getLoginFacilityId(),bean.getEncounterId());
		if(PrEncounterDtls!=null)
		{
			for(int j=0; j<PrEncounterDtls.size(); j++)
			{
				record 						= (String[])PrEncounterDtls.get(j);
				attend_practitioner_id		= bean.checkForNull(record[0],"");
				attend_practitioner_name	= bean.checkForNull(record[1],"");
				discharge_date_time			= bean.checkForNull(record[2],"");
				episode_id					= bean.checkForNull(record[3],"");
				op_episode_visit_num		= bean.checkForNull(record[4],"");
				team_id						= bean.checkForNull(record[5],"");
				service_code				= bean.checkForNull(record[6],"");
			}
		}
 	}  // End of function_from != "CP" 
		 


	attend_practitioner_id				= bean.checkForNull(attend_practitioner_id, "");
	practitioner_id						= bean.checkForNull(practitioner_id, "");

	bean.setAttendPractitionerId(attend_practitioner_id);
	bean.setAttendPractitionerName(attend_practitioner_name);
	bean.setDischargeDate(discharge_date_time);
	bean.setEpisodeID(episode_id);
	bean.setEpisodeVisitNum(op_episode_visit_num);
	bean.setTeamID(team_id);
	// Get the Service Code and set it
	bean.setServiceCode(service_code); // Encounter_id and facility_id will be taken from the bean methods

	// Till Here

	// Check the Billing Details Information,, To display alert or get an confirm
	//billingInformation 			= bean.getBillingInfo();
	/*Added by Uma on 3/12/2010 for IN019169 */
	if(function_from.equalsIgnoreCase("AMEND_ORDER"))
	{
		if((order_id.substring(0,2)).equalsIgnoreCase("PH"))
		{
			ArrayList AmendPlaceOrderHeader	= bean.getAmendPlaceOrderHeader(bean.getOrderId());// Only one record will be there for the order_id
			for(int i=0; i<AmendPlaceOrderHeader.size(); i++)
			{
				amendRecords = (String[])AmendPlaceOrderHeader.get(i);
			}
			if(AmendPlaceOrderHeader != null && AmendPlaceOrderHeader.size() == 0)
			{
				amendRecords = new String[11];
				amendRecords[0] = "";
				amendRecords[1] = "";
				amendRecords[2] = "";
				amendRecords[3] = "";
				amendRecords[4] = "";
				amendRecords[5] = "";
				amendRecords[6] = "";
				amendRecords[8] = "";
				amendRecords[9] = "";
				amendRecords[10] = "";
				
			}
			bean.setLoginFacilityId(amendRecords[4]);
		}
	}
	/*Ends Here by Uma on 3/12/2010 for IN019169 */
	billingInformation 				= beanBillQueryObj.getBillingInfo(properties, bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(), bean.getPatientId());
	if(billingInformation!=null && billingInformation.size() > 0)
	{
		for(int j=0; j<billingInformation.size(); j++)
		{
				record 					= (String[])billingInformation.get(j);
				billing_warning_message	= bean.checkForNull(record[0],"");
				billing_error_message	= bean.checkForNull(record[1],"");
		}
 		if(billing_warning_message.equals("") && billing_error_message.equals(""))
			billing_error_disp = true;
		else if(!billing_error_message.equals(""))
		{
			billing_error_disp = false;
			out.println( "<script>alert(\"" + billing_error_message+ "\") ; </script>" ) ;
		}
		else if(!billing_warning_message.equals(""))
		{
			//BS_INTN0001 starts
			//out.println( "<script>var message_yn = confirm(\"" + billing_warning_message+ "\");");
			//out.println(" if(!message_yn) { ");
			//out.println(" parent.location.reload(); ");
			//out.println(" } ");
			//out.println("</script>" ) ;
			out.println( "<script>message_yn = confirm(\"" + billing_warning_message+ "\");</script>");
			//BS_INTN0001 ends
		}
	} // End of if
	/* Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
	bean.setPrivilegeApplicability(bean.checkForNull(bean.getAuthorisationOrOrderingYn("ORD"),""));

    PrivilegeApplicabilityAuth = (String)bean.checkForNull(bean.getAuthorisationOrOrderingYn("AUT"),"");
	PrivilegeApplicabilityOrd = (String)bean.checkForNull(bean.getAuthorisationOrOrderingYn("ORD"),"");
	//PrivilegeApplicability =(String)bean.getPrivForPractYN();	
	session.putValue("PrivilegeApplicability",PrivilegeApplicabilityOrd);
	session.putValue("PrivilegeApplicabilityAuth",PrivilegeApplicabilityAuth);
	//if(PrivilegeApplicability.equals("N"))
	//{
		//out.println( "<script>alert(getMessage('ASSIGN_PRIVILEGE_TO_PRACT_YN_TO_ORDER','OR')); </script>" ) ;	
			//return; //do not proceed
	//}
	/*End here*/

 %>
<form name="orderEntry" id="orderEntry">
<%
	if(billing_error_disp)   // Billing Through
	{
 		// The Ordering Practitioner if not same as the Attending Practitioner, then check the below conditions
		if ( (!function_from.equals("EXTERNAL_ORDER")) && (!function_from.equals("CP") ) )
		{
			//&& (!attend_practitioner_id.equalsIgnoreCase(practitioner_id) || practitioner_id.equals("") && attend_practitioner_id.equals("")) ) || ( function_from.equals("") && attend_practitioner_id.equalsIgnoreCase(practitioner_id)) ) 
			

			// Check to call the Modal Window for the Practitioner
			//if(!(bean.getPractitionerType().equals("MD") || bean.getPractitionerType().equals("SG") || bean.getPractitionerType().equals("PS") || bean.getPractitionerType().equals("DN") || bean.getPractitionerType().equals("RD") || bean.getPractitionerType().equals("PT")))
			//IN063719 starts
			String restrictAEEncFlag = bean.getRestrictAEEncFlag();
			boolean activeEncounterCheck = bean.activeEncounterCheck(patient_id,encounter_id);
			//if((restrictAEEncFlag.equalsIgnoreCase("Y")) && (patient_class.equalsIgnoreCase("OP") || patient_class.equalsIgnoreCase("EM")) && !function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS") && activeEncounterCheck){
			if((restrictAEEncFlag.equalsIgnoreCase("Y")) && !function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS") && activeEncounterCheck){
				out.println( "<script>alert(getMessage('ORDER_RESTRICT_AE_AND_OP_ENCOUNTER','OR')); mainFrame.location.href='../../eCommon/html/blank.html';</script>");
			}//IN063719 ends
			else if((bean.checkForNull(bean.getCheckPlaceOthYN(bean.getPractitionerId(),bean.getResponsibilityId(),bean.getPractitionerType()),"N").equalsIgnoreCase("Y"))||(practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals(""))) 
			{ 				
			%>			
				<script>
				if(message_yn)//BS_INTN0001
	 					//callPractitioner("<%=patient_class%>"); // To call the Pracitioner Window.
						setTimeout (()=>{callPractitioner("<%=patient_class%>","<%=request.getQueryString()%>","<%=bean_id%>","<%=bean_name%>","<%=pharmacy_scope%>");},100)
				</script>
			<%		
			} 
			else 
			{ 
			%>					
				<script>mainFrame.location.href="../../eOR/jsp/OrderEntryMain.jsp?<%=request.getQueryString()%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>"</script>
<%			}
		} 
		else 
		{ // Proceed as normal one
%>
			<script>mainFrame.location.href="../../eOR/jsp/OrderEntryMain.jsp?<%=request.getQueryString()%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>"</script>
<%	}
	}  
	else 
	{	 %>
			<script>mainFrame.location.href="../../eCommon/html/blank.html"</script>
<%  
   }  %>
	<%
		// set it back persistence
		putObjectInBean(bean_id,bean,request);
		// For PH Related done it before itself , since they r not needed
	%>
</form>
</body>
</html>

