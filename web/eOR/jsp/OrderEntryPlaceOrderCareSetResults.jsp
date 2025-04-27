<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description 
-------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
31/05/2013    IN040092		Karthi L      When we Place "Order Set" Billing details are displayed.
13/08/2013	  IN042045		Chowminya G	    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
02/07/2014	  IN048467 		Nijitha S										HSA-CRF-0150
09/05/2016	  IN058388-		Raja S			System displays ?Reqd/opt? in place order screen incorrect. It should be display according to 	
			  IN058669						setup.(ML-BRU-SCF-1659,SKR-SCF-1121)
15/02/2017	  IN063561		Raja S			OR->Place Order ->Order Set ->Error in Placing Order Set from Place order Screen_UT
27/03/2017	IN063686		Vijayakumar K									 PMG2017-GHL-CRF-0001 [IN:063686]
03/07/2017	  IN062607		Raja S			03/07/2017		Ramesh G			ML-MMOH-CRF-0727
19/10/2017	IN065324		Dinesh T		To display the price in OR screen and the billing status in Manage Specimen screen
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
-------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------
06/07/2018	IN067246		Raja S			06/07/2018		Ramesh G			GHL-CRF-0516
17/07/2018	IN064543		Kamalakannan	17/07/2018		Ramesh G			ML-MMOH-CRF-0776	
01/08/2018	IN64543			Dinesh T		01/08/2018		Ramesh G			ML-MMOH-CRF-0776
13/11/2018  IN069001		sivabagyam		13/11/2018  	Ramesh G 			GHL-SCF-1391
09/01/2019  IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
21/04/2019	IN070295		Ramesh G		21/04/2019		Ramesh G			ML-BRU-SCF-1939
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
09/03/2020	  IN072669		Nijitha S	09/03/2020		Ramesh G
25/03/2020	IN072744		Nijitha S	25/03/2020			Ramesh G			ML-MMOH-CRF-1229
07/06/2020	IN072524		Nijitha S     	07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
29/10/2020	IN073712		Nijitha S     	29/10/2020		Ramesh G		ML-MMOH-CRF-1229.3
07/04/2023	42107			Ramesh G   										GHL-SCF-1702
-------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*,webbeans.eCommon.*"%><!--IN062607-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
try
{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- for Tool Tip-->

<script>
		// Violation, but to make the alignment size same as the top frame...
		function alignWidth() 
		{
			parent.legendsFrame.document.getElementById("titleTab").width=document.getElementById("detailTab").rows(1).offsetWidth;
			if(document.getElementById("detailTab").rows(1)!=null) 
			{
				for(i=0;i<document.getElementById("detailTab").rows(1).cells.length;i++) 
				{   // Depending upon the first row
					var wid=document.getElementById("detailTab").rows(1).cells(i).offsetWidth;
					if(parent.legendsFrame.document.getElementById("titleTab").rows(0).cells(i))
						parent.legendsFrame.document.getElementById("titleTab").rows(0).cells(i).width=wid;
				}
			}
		}
		function alignPreviewWidth() 
		{
			if(document.getElementById("detailTab").rows(1)!=null) 
			{
				for(i=0;i<document.getElementById("detailTab").rows(1).cells.length;i++)
				{   // Depending upon the first row
					var wid=document.getElementById("detailTab").rows(1).cells(i).offsetWidth;
					if(document.getElementById("titleTab").rows(0).cells(i))
					{
						document.getElementById("titleTab").rows(0).cells(i).width=wid;							
					}
				}
			}
		}
		function moveFrame()
		{
			var temp=document.body.scrollLeft;
			scrollValue=temp;
			if(parent.legendsFrame)
			{
				if(parent.legendsFrame.location.href.indexOf(".jsp") != -1)
				{
					parent.legendsFrame.document.body.scrollLeft=temp;
				}
			}
		}
	</script>

<title><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></title>
</head>
<style TYPE="text/css"> </style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="ClinicalComment();" onScroll="moveFrame()">
<form name="placeOrderForm" id="placeOrderForm">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String called_from="OH";
	String called_from="";
	String order_id					= "", order_line_no			= "";
	ExternalOrdersBean external_bean_obj= null;

	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String patient_email_id="";
	String existing_bean_id 		= "";
	String existing_bean_name="";
	String check="";
	String priority_value="";
	/*Added by Uma on 3/13/2010 for IN019490*/
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String patientDischargedYn      = "N";
	String instrn_content_type		= "T";//IN064543
	int drugintercnt = 0;//IN071260
	/*Ends Here*/

	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean	= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
   	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	//orderEntryRecordBean.setLanguageId(localeName);
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();	
	
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); //added for IN035929[IN040092]
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";

	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	 bean1.setLanguageId(localeName);
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String key						= (bean.getPatientId()+bean.getEncounterId());
	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	  // Unique key to keep the Value in the Bean
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
	String passed_from = request.getParameter("passed_from")==null?"":request.getParameter("passed_from");
	String time_frame = request.getParameter("time_frame")==null?"":request.getParameter("time_frame");
	String order_category="";
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
	String called_function = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	patientDischargedYn = (String)bean.getPatientDischarged();
	if(passed_from.equalsIgnoreCase("Rapid Preview"))
	{
		order_category			= request.getParameter("p_order_category")==null?"": request.getParameter("p_order_category");
	}
	else
	{
  		order_category			= request.getParameter("order_category")==null?"": request.getParameter("order_category");
	}
	
	String auth_reqd				= "X";
   	String lb_instal_yn				= bean.checkForNull(request.getParameter("lb_instal_yn"),"N");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN036387 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN036387 End.
	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String session_id				= bean.checkForNull(request.getParameter("session_id"),"");
	//order_category="CS";

	String l_patient_class = bean.getPatientClass();//IN065324

	if(function_from.equalsIgnoreCase("EXTERNAL_ORDER"))
	{
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";
		//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj		= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		/*Added by Uma on 3/13/2010 for IN019490*/
		ref_facility_id				= bean.checkForNull(external_bean_obj.getFacilityId(),"");
		ref_date_time				= bean.checkForNull(external_bean_obj.getReferral_date(),"");
		ref_sent_pract_id			= bean.checkForNull(external_bean_obj.getPractitionerId(),"");
		ref_sent_remarks			= bean.checkForNull(external_bean_obj.getRemarks(),"");
		/*Ends Here for IN019490*/
		//external_bean_obj.setLanguageId(localeName);
		// Bean instance is needed, if it is coming from the external orders, to default the order_category and the order_type_code
		called_from		= bean.checkForNull(external_bean_obj.getCalledFrom());
		if(called_from.equalsIgnoreCase("OH"))
	{
			called_from="OH";
	}else
	{
		called_from="";
	}
}
	
   	String order_catalog_code 		= bean.checkForNull(bean.getOrderCatalogCode(previousValues,order_category,practitioner_type),"");//IN042045
	String order_type_catalog 		= "";
	String order_type_catalog_sort = "";//IN058388-IN058669
	String specialty_code			= "";
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	//bean.getOrderTypeCatalog(previousValues);
	String classValue				= "", chk_class_value = "";
	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
	//java.util.Date date_time	 	= new java.util.Date();
	//String dateString 			 	= dtSystemFormat.format(date_time);
	String dateString 				= bean.getSysDate();
	ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
	ArrayList PlaceOrderSetItems 	= null;
	ArrayList PlaceOrderItems 		= null;
	ArrayList drugclass				= null;
	ArrayList arrDrugDtls			= null;
	String order_types_comb			= "";  // Get the order_type for the individual category -- to get format id
	int count						= 0;
	int display_auth_count			= 0, format_mandatory_count = 0;
	int format_count 				= 0;//age_in_days					= 0;
	String frequency_val			= "",  qty_value = "";//preps_instrn 			= "",
	String duration_value			= "",  qty_uom	 = "",qty_uom_shortdesc="";//preps_dept_instrn		= "",
	String max_durn_value			= "";//pat_preps_instrn			= "",
	String chk_for_max_durn_action = "";//sex_yn					= "",
	String format_id				= "", prompt_msg			= "";
	String format_id_mandatory_yn	= "N", facility_name		= "";
	String order_set_order_catalog	= "";
	String sec_start_date_time		= "";
	String drug_class				= "";
	String performing_dept_loc_code = "", performing_dept_loc_desc = "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;  String[] frequencyRecords = null;
	String[] care_set_count 		= null;  //String[] durationRecords  = null;
	String[] care_set_group			= null;  String[] deptLocation	   = null;
	String[] deptLocation1			= null;  String[] orderTypeRecords = null;
	String[] reqd_or_opt_ind		= null; // To store the value required/optional/deselected
	String[] rel_start_date_time	= null; // To store the start_date_time
	String[] start_time				= null; // To store the hours(So that it can be used when the header is changed )
	String[] records				= null;
	String[] records1				= null;
	String[] secondaryOrders		= null;
	ArrayList performingLocationCode =new ArrayList();
	String performingLocation[] =null;
	//IN062607 Starts
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	boolean l_show_order_set_bill_dtls = false;//IN065324
	String perfLocnMandFlag = "";//IN066377
	String bt_order_type_code = "";//IN066377
	int non_billing_numbering =0;//IN068314
	try
	{
		con				=	ConnectionManager.getConnection(request);
		dup_custSpecificFlg = CommonBean.isSiteSpecific(con, "OR","TWICE_DUPLICATE_ALERT");
		if(dup_custSpecificFlg)
			dupchk_siteSpecFlag ="Y";
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);

	}
	
	ArrayList PlaceOrderType		= null; ArrayList PlaceOrderFrequency = null;
	String rd_install_yn			= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N";
	String checkedField				= "";
	String disableField				= "";
	String check_box_value			= "N";
	int t							= 0;
	StringTokenizer stFormat		= null;

	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	HashMap instructionsMap = new HashMap();
	Object patprepsinstrns      = "IS";
	if(passed_from.equalsIgnoreCase("Rapid Preview"))
	{
%>

<table border="1" cellpadding=0 cellspacing=0  width="100%" id="titleTab">
		<tr>
			<td class=' columnheader' width="0%">&nbsp;</td>
			<td class=' columnheader' width="0%" ><a class="gridLink" href="#" onClick="changeAllStartDateTime()" title="Do you want to change the Start Date Time, Click here"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></td>
			<td class=' columnheader' width="0%"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td> 
			<td class=' columnheader' width="0%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class=' columnheader' width="0%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=' columnheader' width="0%"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
			<td class=' columnheader' width="0%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
  			<td class=' columnheader' width="0%">&nbsp;</td>
			<td class=' columnheader' width="0%" ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
			<!--<th width="">End Date</th> -->
		</tr>
	</table>
	<%}
		/* For Order Set Billing Added by Uma 2/6/2009*/
		String billing_order_set_details[] = bean.getOrderSetBillDetails(order_catalog_code);
		String order_set_bill_yn = bean.checkForNull(billing_order_set_details[1],"N");
		String care_set_catalog_desc = bean.checkForNull(billing_order_set_details[0],"");
		String charge_yn = bean.checkForNull(billing_order_set_details[2],"");
		String order_set_fpp_yn = bean.checkForNull(billing_order_set_details[3],"");//IN072524
		String order_set_fpp_category=bean.checkForNull(billing_order_set_details[4],"");//IN072524
		if(charge_yn.equalsIgnoreCase("N"))
		{
			order_set_bill_yn = "N";
		}
		/* ends*/


		%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" id="detailTab">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

<%

		//IN065324, starts
		if(is_bt_view_bill_dtls && "BT".equals(order_category) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(order_category))
		{
			l_show_order_set_bill_dtls = true;
		}
		//IN065324, ends

		//if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !order_category.equals("BT"))//IN065324
		if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && l_show_order_set_bill_dtls)//IN065324
		{
			int numbering=0;
			//String displaytooltip="";
			//IN072524 Starts
			if("Y".equals(order_set_fpp_yn)){
				BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),order_set_fpp_yn,order_set_fpp_category) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			}else{
				BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			}
			//IN072524 Ends
			if(BillChargeInfo==null) 
				BillChargeInfo= new ArrayList();
			billing_details = null;
			for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
			{
				billing_details 	= (String[])BillChargeInfo.get(m);
				setBills_dtls		= new HashMap();
				setBills_dtls.put("charged_yn"       , billing_details[1]);
				setBills_dtls.put("total_payable"    , billing_details[2]);
				setBills_dtls.put("patient_payable"  , billing_details[3]);
				setBills_dtls.put("quantity"         , qty_value);
				setBills_dtls.put("incl_excl_action" , billing_details[4]);
				setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
				setBills_dtls.put("preapp_yn"        , billing_details[5]);
				setBills_dtls.put("patient_paid_amt" , billing_details[6]);
				setBills_dtls.put("bl_panel_str"     , billing_details[0]);
				setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
				setBills_dtls.put("serv_panel_code"  , billing_details[11]);
				setBills_dtls.put("p_episode_type"	 , billing_details[13]);
				setBills_dtls.put("p_episode_id"	 , billing_details[14]);
				setBills_dtls.put("p_visit_id"		 , billing_details[15]);
				setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
				setBills_dtls.put("rate"		 , "");
				setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
				setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
				setBills_dtls.put("fpp_yn"		 , order_set_fpp_yn);//IN072524
				setBills_dtls.put("fpp_category"		 , order_set_fpp_category);//IN072524
				//servicepanel=bean.checkForNull(billing_details[10],"");
				//servicepanelcode=bean.checkForNull(billing_details[11],"");
				orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code, setBills_dtls); 
				 if(!billing_details[9].equals(""))
				{
					numbering=1;
				%> 
				<script>alert("<%=billing_details[9]%>");</script>
				<% 
				}
				if(billing_details[10].equals("")||billing_details[11].equals(""))
				{
							numbering=1;
				%>
				<script>
						var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
						msg=msg.replace('{1}',"<%=order_catalog_code%>");
						alert(msg);
				</script>
				<% 
					}
				}
				if(numbering==1 && order_set_bill_yn.equalsIgnoreCase("Y") && charge_yn.equalsIgnoreCase("Y"))
				{	
				%>
				<script>
						//parent.criteriaDetailFrame.document.getElementById("recordApply").disabled=true;
						parent.criteriaDetailFrame.document.getElementById("record").disabled=true;
				</script>
				<%
				}
				bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code);
		%>
						</td><tr><td class="<%=classValue%>"></td><td class="<%=classValue%>"></td><td class="<%=classValue%>"></td><td colspan="7" class="<%=classValue%>"><!-- <table cellpadding=0 cellspacing=0 border=0 width='100%' align='right' style='border-width:0' class="grid"> --> <!--  commentedfor IN035929[IN040092] --><!--IN072524-->
						<table cellpadding=0 cellspacing=0 border=0 width='100%' align='right' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%> class="grid"> <!--  condition added for IN035929[IN040092] -->

						<tr >	
						<!--IN072524 Starts-->
						<%
							if("Y".equals(order_set_fpp_yn))
							{	
							%>
							<input type="hidden" name="fpp_yn<%=count %>" id="fpp_yn<%=count %>"  value="<%=order_set_fpp_yn%>" >
							<td rowspan="2" width='20%' class="<%=classValue%>" style='border-width:0;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${or_labels}"/>:</B></font>
						
								<select name="fpp_category<%=count %>" id="fpp_category<%=count %>"  onchange="reviseBillingchrgs('<%=count %>','ORDER_SET')" >
									<option value="S" <%="S".equals(order_set_fpp_category)?"selected":""%>><fmt:message key="eOR.Simple.label" bundle="${common_labels}"/></option>
									<option value="M" <%="M".equals(order_set_fpp_category)?"selected":""%>><fmt:message key="eOR.Medium.label" bundle="${common_labels}"/></option>
									<option value="C" <%="C".equals(order_set_fpp_category)?"selected":""%>><fmt:message key="eOR.Complex.label" bundle="${common_labels}"/></option>
								</select>
							
							</td>
							<%}%>
							<!--IN072524 Ends-->
							<td colspan="" width='15%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='15%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
								<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")%></span></font></td>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=order_catalog_code%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font>
								</td>
							<%
							}
							%>
							<!--added against ML-ML-MMOH-CRF-1229.3-->
							<td colspan="" class="<%=classValue%>" id='ordersetlevel' style='border-width: 0;text-align: center;'><font class='label' size="1"><a class="gridLink"  href="javascript:callReviseBilling('','ORDER_SET','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','','')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> <!--View / Edit--></a><!-- IN073712 -->
					</td>
					</tr>
					</table></td></tr>
		<%
		}


		// New Orders, Painting	 of the Care Sets
		if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
		{
			for(t=0; t<PlaceOrdercareSetCount.size(); t++)
			{
				String billinginterface="";
				String servicepanel="";
				String servicepanelcode="";
				String finbill="";
				String displaytooltip="";
				String speciality_code[]=new String[3];
				ArrayList speciality=new ArrayList();
				String displays_style1="visibility:hidden";
				String displays_style2="visibility:hidden";
				String displays_style3="visibility:hidden";
				String displays_style4="visibility:hidden";
				String comment 			  = "";
				String pat_preps_instrns ="";
				String pat_preps_pat_instrns="";
				String pat_preps_dep_instrns="";
				String def_duration = "";
				
			    int numbering=0;
				format_id_mandatory_yn = "N";
				care_set_count = (String[])PlaceOrdercareSetCount.get(t);		// To get the order_category, category description and count
				String forceStatus=bean.getForceStatus(practitioner_type,care_set_count[1]);
				String fStatus[]=forceStatus.split(":");
				// Get the auth Reqd Yn
				//auth_reqd = bean.getAccessReqd(care_set_count[1],"auth_yn");	// Column Name. auth_yn is passed
				//if(fStatus[0].equals("Y"))
				//auth_reqd="X";
	
				// Pass the order_category and the order_types for the order_category to get the format_id
				order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");  // Order Types Combination for the order_category
				// Get the Format Id for the Header
				format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
 
				if(!format_id.trim().equals("") )
				{
					stFormat = new StringTokenizer(format_id,"~");
					while(stFormat.hasMoreTokens())
 					{
 						format_id_mandatory_yn	 	= stFormat.nextToken();
 						format_id 	 	 			= stFormat.nextToken();
 					}
					stFormat = null;
 				}
 				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
 					out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='N'>");
 				else
 					out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='Y'>");
					// Second Query where u will get all the order_type_code and order_catalog_code
		%>
			<tr>
				<td class="CAHIGHERLEVELCOLOR">
				<input type="hidden" name="hdr_format_id_mandatory_yn<%=t%>" id="hdr_format_id_mandatory_yn<%=t%>" value="<%=format_id_mandatory_yn%>" >
				<input type="hidden" name="hdr_care_set_order_category<%=t%>" id="hdr_care_set_order_category<%=t%>" value="<%=care_set_count[1]%>" >
				<input type="hidden" name="hdr_order_catalog_code<%=t%>" id="hdr_order_catalog_code<%=t%>" value="<%=order_catalog_code%>" >
				<input type="hidden" name="hdr_format_id<%=t%>" id="hdr_format_id<%=t%>" value="<%=format_id%>" >
<%		 
				if(!format_id.equals("")) {
%>
					<a class='gridLink'  href='javascript:orderFormatForCareSetsHeader("<%=format_id%>","<%=care_set_count[1]%>","<%=order_catalog_code%>",<%=t%>,"")' title='Order Format'>
<%					if(format_id_mandatory_yn.equals("Y"))
						out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
					else
						out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
 						//out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='"+format_id_mandatory_yn+"'>");
				}
%>
				</td>
				<td colspan="5" align="left" class="CAHIGHERLEVELCOLOR"><%=care_set_count[2]%></td>
				<!-- Modified by Uma on 3/11/2010 for IN019871 -->
			 	<td id="hdg<%=t%>" class="CAHIGHERLEVELCOLOR" nowrap>				<%if(!auth_reqd.equalsIgnoreCase("X")){displays_style3="visibility:visible";displays_style4="visibility:hidden";}else{displays_style4="visibility:visible";displays_style3="visibility:hidden";}%><label  id="press_link"  style="<%=displays_style3%>"><%	out.println("&nbsp;");%></label><label  id="press_links"  style="<%=displays_style4%>"><font color="#FFFFCC"><fmt:message key="eOR.PressLinkto.label" bundle="${or_labels}"/></font></label><label id="authorizedId<%=t%>" align="left" class="CAHIGHERLEVELCOLOR"><%if(!auth_reqd.equalsIgnoreCase("X")){	displays_style1="visibility:visible";displays_style2="visibility:hidden";}else{displays_style1="visibility:hidden";displays_style2="visibility:visible";}	%><label  id="auths"  style="<%=displays_style2%>"><a class='gridLink' href='javascript:CareSetCheckAuthorization("<%=auth_reqd%>")'><font color="#FFFFCC"><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></font></a></label><label  id="auth"  style="<%=displays_style1%>"><%out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");%></label><input type="hidden" name="auth_reqd<%=count%>" id="auth_reqd<%=count%>" value="<%=auth_reqd%>"></label>
				</td>
				<!-- Ends Here -->
		<td id="imageId<%=t%>" align="left" class="CAHIGHERLEVELCOLOR"><%out.println("<img id=\"textimg"+count+"\" src=\"../../eOR/images/Authorization.gif\" align=\"left\">");%></td> 
		<td align="left" class="CAHIGHERLEVELCOLOR">&nbsp;</td>  				
	</tr>
		<%
		int total_recs = 0;	//IN071260
				//IN063686 starts
				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
				//IN063686 ends
				//System.err.println("PlaceOrderSetItems==========="+PlaceOrderSetItems);
				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
				rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
				start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time

				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
				{
					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
					order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
				    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					order_type_catalog_sort = order_type_catalog_sort+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"',"+ (k+1) + ",";//IN058388-IN058669
				    reqd_or_opt_ind[k]		= care_set_group[5];
				    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
				    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
				}
				if(order_set_order_catalog.length() > 0)
					order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
				if(order_type_catalog.length() > 0)
					order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
				if(order_type_catalog_sort.length() > 0) //IN058388-IN058669
					order_type_catalog_sort = order_type_catalog_sort.substring(0, order_type_catalog_sort.length()-1);//IN058388-IN058669
				//IN063561 starts
				if(order_type_catalog_sort.length() == 0)
					order_type_catalog_sort = "'',''";
				//IN063561 ends


				//PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview //commented for IN058388-IN058669
				PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"",order_type_catalog_sort); // Last parameter to identify normalOE or from preview  //IN058388-IN058669(last parameter to order the catalog)
				// New Orders, Painting	 of the Care Sets

				//System.err.println("PlaceOrderItems=============="+PlaceOrderItems);

				if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
				{
					for(int i=0; i<PlaceOrderItems.size(); i++)
					{	
						String locn_appt_reqd_yn="";
						records		= (String[])PlaceOrderItems.get(i);
						records1	= (String[])PlaceOrderItems.get(i);
						instrn_content_type = records[73];//IN064543
						/*if ( i% 2 == 0 )
						{
							classValue 			= "QRYEVEN" ;
							chk_class_value		= "QRYEVEN" ;
						}
						else
						{
							classValue		 	= "QRYODD" ;
							chk_class_value		= "QRYODD" ;
						}*/
						classValue="gridData";
						chk_class_value="gridData";
						//if(fStatus[0].equals("Y"))
						//records[48]="Y";
						if(fStatus[1].equals("Y"))
						records[49]="Y";
						if(records[51].equalsIgnoreCase("Y"))
							chk_class_value = "eORConsent" ;

						// Get the Values to be Defaulted, Putting into the string array to be retrieved later		

						Default = bean.getPlaceOrderSetDefault(records[0],order_catalog_code);
						for(int j=0;j<Default.size();j++)
						{
							recordDefault	 = ((String[])Default.get(j));					
							if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
							if(recordDefault!=null){
								qty_value	 = 	bean.checkForNull(recordDefault[8],"1");
								if(qty_value.equals("0")) qty_value = "1";
								qty_uom		 =  bean.checkForNull(recordDefault[9],"");
								qty_uom_shortdesc =  bean.checkForNull(recordDefault[10],"");
							}else{
								qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
							}
						}
						// Till Here
%>
		<tr>
<%
				checkedField= "";disableField="";check_box_value="N";
				if(reqd_or_opt_ind[i].equalsIgnoreCase("R"))
				{
					check_box_value = "Y";
					checkedField 	= "CHECKED";
					disableField	= "DISABLED";
				}
				else if(reqd_or_opt_ind[i].equalsIgnoreCase("O"))
				{
					check_box_value = "Y";
					checkedField 	= "CHECKED";
					disableField	= "";
				}
				else if(reqd_or_opt_ind[i].equalsIgnoreCase("D"))
				{
					check_box_value = "N";
					checkedField 	= "";
					disableField	= "";
				}
				String EnableEmail="N";		
				String data[] = null;
				//String data[] = bean.getEmailDataDetails((String)bean.getLoginFacilityId());Commented Email part as told by Rajan
				if(data!=null && data.length>0)
				{
					patient_email_id=bean.checkForNull(data[1],"");
				}				
				arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+records[0],records[0]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
				  		pat_preps_pat_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
				  		pat_preps_dep_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(2),""); // dep instrns
			  			pat_preps_instrns     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
				 }
				if(comment.equals("")&&pat_preps_instrns.equals("")&&pat_preps_pat_instrns.equals("")&&pat_preps_dep_instrns.equals(""))
				{
					String sex_yn="";
					int age_in_days=0;
					String pat_pat_preps_instrns="";
					
					if(bean.checkForNull(records[35],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(records[0],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(records[0]);  // For Patient Preps. Insructions.					
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(patprepsinstrns),"");  // For Patient Preps. Insructions.
					}
					if((!pat_pat_preps_instrns.equals("")&&pat_pat_preps_instrns.length()>0))
					{
						EnableEmail="Y";
					}
				}
				else
				{
					EnableEmail="Y";
				}
					%>
				<input type="hidden" name="enable_email<%=count%>" id="enable_email<%=count%>" value="<%=EnableEmail%>">
					
				<td style="width:2"  id="billing<%=count%>" class="<%=chk_class_value%>"><input type="checkbox" name="ck<%=records[0]%>" id="ck<%=records[0]%>" value="<%=check_box_value%>" onClick="setCheckValue(this,'<%=records[0]%>','<%=count%>')" <%=checkedField%> <%=disableField%>><input type="hidden" name="h1<%=records[0]%>" id="h1<%=records[0]%>" value="<%=records[3]%>"><input type="hidden" name="h2<%=records[0]%>" id="h2<%=records[0]%>" value="<%=records[4]%>"></td>
				<td width="" id="billing1<%=count%>" class="<%=classValue%>"><input type="hidden" name="catalog_code<%=count%>" id="catalog_code<%=count%>" value="<%=records[0]%>"><input type="text" id="start_date_time_id<%=count%>" name="start_date_time<%=count%>" onkeyDown='chkBackSpace();'  value="<%=com.ehis.util.DateUtils.convertDate(rel_start_date_time[i],"DMYHM","en",localeName)%>" size="14" maxLength="16"  onBlur=" checkStartDateTim(this,<%=count%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('start_date_time_id<%=count%>',null,'hh:mm','','');" style='cursor:pointer'><input type="hidden" name="start_time<%=count%>" id="start_time<%=count%>" value="<%=start_time[i]%>" size="14" maxLength="16"></td>
				<td width=""  id="billing2<%=count%>" class="<%=classValue%>" onMouseOver='showToolTip("<%=records[0]%>","placeOrderForm")' onMouseOut="hideToolTip()"><font size="1">
				<%=records[1]%>
<%
			speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);
			if(speciality.size()>0)
			{
				for(int sc=0;sc<speciality.size();sc++)
				{
						speciality_code=(String[])speciality.get(sc);
				}
			}
			if(speciality_code[0].equalsIgnoreCase("Y"))
			{
				if(records[48].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")||speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required	 validateDateWithTime(this)
				{
					records[48]="Y";
				    display_auth_count++;
%>					&nbsp;<img id='authorization<%=count%>' src="../../eOR/images/Authorization.gif" align="center"></img>
<%			}	
			}
			else
			{
					if(records[48].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")) // For Authorization Required	 validateDateWithTime(this)
					{
						records[48]="Y";
						display_auth_count++;
%>					&nbsp;<img id='authorization<%=count%>' src="../../eOR/images/Authorization.gif" 	align="center"></img>
<%				}	
				}
				
%>
				</font><input type="hidden" name="cat_desc<%=count%>" id="cat_desc<%=count%>" value="<%=records[1]%>"><input type="hidden" name="type_desc<%=count%>" id="type_desc<%=count%>" value=""></td>
				<td width="" id="billing3<%=count%>" class="<%=classValue%>" align="right">
					<select name="order_type_code<%=count%>" id="order_type_code<%=count%>" disabled>
<%				    PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(records[4].equals(orderTypeRecords[0]))
							out.println("<option value=\""+orderTypeRecords[0]+"\" selected> "+orderTypeRecords[1]+" </option>");
						else
							out.println("<option value=\""+orderTypeRecords[0]+"\"> "+orderTypeRecords[1]+" </option>");
					}
%>					</select>
					<input type="hidden" name="order_type<%=count%>" id="order_type<%=count%>" value="">
				</td>
				<%if(!passed_from.equalsIgnoreCase("Rapid Preview"))
				{
					
				%>
				<td width="" id="billing4<%=count%>" class="<%=classValue%>">
					<select name="priority<%=count%>" id="priority<%=count%>" onChange="setOrderPriority('priority','<%=records[0]%>',<%=count%>)"><!--IN048467-->
					<%if ( !((records[52]).equals("3"))) {%>
					   <option value=R><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					<%}
					  if (((records[52]).equals("")) || ((records[52]).equals("2")) ) {%>
					   <option value=U><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					<%}
					if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					%>
					   <option value=S><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
					<%}%>
   			 		</select>
				</td>
			<%}else{%>
					<!-- 42107 Start.  -->
						<!-- input type="hidden" name="priority<//%=count%>" value="<//%=priority_value%>"> -->
						<!-- input type="hidden" name="priority_appl<//%=count%>" value="<//%=records[52]%>"> -->
					<!-- 42107 End. -->	
						
						<%
				if ( !((records[52]).equals("3")) && priority_value.equals("")) { 
					priority_value = "R";
				} else if (priority_value.equals("") && ( ((records[52]).equals("")) || ((records[52]).equals("2"))) ) {  
					priority_value = "U";
				} else if(priority_value.equals("") && (((records[52]).equals("")) || ((records[52]).equals("3"))) ) {
					priority_value = "S";
				} else priority_value  = "R";%>
				<!--  42107 Start. -->
				<input type="hidden" name="priority<%=count%>" id="priority<%=count%>" value="<%=priority_value%>">
				<input type="hidden" name="priority_appl<%=count%>" id="priority_appl<%=count%>" value="<%=records[52]%>">
				<!-- 42107 End.  -->
				<td  class="<%=classValue%>" align="right" nowrap id="priority_id<%=i%>" ><font size="1">
<%				if ( priority_value.equalsIgnoreCase("R")) { %>
					<a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>','<%=records[0]%>')" <%} %> title="Routine"><b><fmt:message key="Common.routine.label" bundle="${common_labels}"/></b>
<%				} else if(priority_value.equalsIgnoreCase("U")) { %>
					  <a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>')" <%} %>  title="Urgent"><b><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></b>
<%				} else if(priority_value.equalsIgnoreCase("S")) { %>
					 <a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>')" <%} %>  title="Stat"><b><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></b>
<%				}   %>
				</td>
				<%}%>
						
				<td width="" id="billing5<%=count%>" class="<%=classValue%>"><input type="text" style="text-align:'right'" name="quantity<%=count%>" id="quantity<%=count%>" value="<%=qty_value%>" size="2" maxLength="6" onKeyPress="return(ChkNumberInput(this,event,'2'))" onBlur="checkValidNumber('',this);calculateDosage(<%=count%>);reviseBillingchrgs('<%=count%>','NEW_ORDER')" <% if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); %>>
					&nbsp;
					<% if (qty_uom.equals("")) 
					   {
						 //out.println(records[11]);modified by Ambiga.M on 1/19/2010 for 18146
						 out.println(records[68]);
					   }
					   else
						{			
							//out.println(qty_uom);
							out.println(qty_uom_shortdesc);
						}
					%>
				</td>
				<td width="" id="billing6<%=count%>" class="<%=classValue%>">
				<%
				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				%>
					<select name="frequency_code<%=count%>" id="frequency_code<%=count%>" onChange="setFrequency(this,<%=count%>,'<%=records[0]%>','<%=bean.getLoginFacilityId()%>','onChange')">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
					PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","",care_set_count[1],records[4],recordDefault[0]); //Pass the order_category and catalog_code
					
						for(int j=0; j<PlaceOrderFrequency.size(); j++)
						{							
							frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
							if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
							{
								out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
								frequency_val = frequencyRecords[2];
							}
							else
							{
								if(recordDefault != null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2]))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									frequency_val = recordDefault[0];
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
									frequency_val = "";
								}
							}	
						}
					%>
					</select>
<% 					//if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
				}
				else
				{
				%>
					<select name="frequency_code<%=count%>" id="frequency_code<%=count%>" disabled>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					</select>
				<%
				}
				%>
					<input type="hidden" name="frequency_val<%=count%>" id="frequency_val<%=count%>" value="<%=frequency_val%>" >
					<input type="hidden" name="schedule_yn<%=count%>" id="schedule_yn<%=count%>" value="N" >
					<input type="hidden" name="schedule_mandatorily_yn<%=count%>" id="schedule_mandatorily_yn<%=count%>" value="N" >
					<input type="hidden" name="freq_nature<%=count%>" id="freq_nature<%=count%>" value="F" >
					<input type="hidden" name="repeat_value<%=count%>" id="repeat_value<%=count%>" value="" >
				</td>
				<td width="" id="billing7<%=count%>" class="<%=classValue%>">
<%
					if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
					{
						duration_value = "90";
					}
					else
					{
						if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
						if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
						if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
						if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					}
%>
					<input type="text" class="NUMBER" name="duration_value<%=count%>" id="duration_value<%=count%>" value="<%=duration_value%>" size="2" maxLength="3" onKeyPress="return(ChkNumberInput(this,event,'0'))" onBlur='checkMaxValue(this,"<%=max_durn_value%>","<%=chk_for_max_durn_action%>",escape("<%=prompt_msg%>"),"<%=records[19]%>","<%=count%>")'  <%if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");%>>
					<input type="hidden" class="NUMBER" name="duration_def_value<%=count%>" id="duration_def_value<%=count%>" value="<%=duration_value%>" >
				</td>
				<td width="" id="billing9<%=count%>" class="<%=classValue%>">
					<select name="duration_code<%=count%>" id="duration_code<%=count%>" DISABLED>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
					if(care_set_count[1].equals("PH") && records[4].equals("MS")&& recordDefault[0].equals(""))
					{
						def_duration = "D";
%>
						<option value="D" selected><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
<%
					}
					else
					{
						def_duration = "";
					}
%>
				</select>
					<input type="hidden" name="duration<%=count%>" id="duration<%=count%>" value="<%=def_duration%>">
					</td>
				</tr>
<%
			format_id = bean.checkForNull(records[47],"");
			format_id_mandatory_yn = "N";
			if(!records[47].trim().equals(""))
			{
	     		StringTokenizer stFormatID 	= new StringTokenizer(records[47],"~");
	     		while(stFormatID.hasMoreTokens())
	     		{
	     			format_id_mandatory_yn  = stFormatID.nextToken();
	     			format_id 				= stFormatID.nextToken();
	     		}
				stFormatID	= null;
	 		}
%>
			<tr>
				<input type="hidden" name="format_id_val<%=count%>" id="format_id_val<%=count%>" value="<%=format_id%>">
				<input type="hidden" name="format_id_mandatory_yn<%=count%>" id="format_id_mandatory_yn<%=count%>" value="<%=format_id_mandatory_yn%>" >
				<td class="<%=classValue%>" id="orderformat<%=count%>" rowspan='2'><font size="1"> &nbsp;<!--IN068314-->
		

		<%	  //added for multiconsent
			      if(records[51].equalsIgnoreCase("Y"))
				{
				%>
					<input class="button" type="button" name="consent_id_lookup<%=count%>" id="consent_id_lookup<%=count%>" title='Consent Required' value="C" onClick="callMultipleConsent('<%=records[0]%>','<%=records[1]%>','','','<%=order_category%>','<%=count%>')">
					  <%	
		
					ArrayList multiConsentList = new ArrayList();
					String[] multiConsentValues = null;
					String[] multiConsentDtls = null;
					boolean consentflag = false;
					multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
					multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
					if(multiConsentList==null || multiConsentList.size()==0)
					{
						multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
					}
		
					if(multiConsentDtls != null)
					{	
						int num_of_consent_req_bo=0;
						int num_of_consent_req_br=0;
						int num_consent_bo=0;
						int num_consent_br=0;
						if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) ))
						{
						
							for(int m=0;m<multiConsentList.size();m++)
							{
								multiConsentValues = (String[])multiConsentList.get(m);
								num_of_consent_req_bo=Integer.parseInt(multiConsentValues[7]);
								num_of_consent_req_br=Integer.parseInt(multiConsentValues[8]);					
								if(multiConsentValues[6].equals("F"))
								{
									if(multiConsentValues[3].equals("A"))
									{
										if(num_of_consent_req_bo!=num_consent_bo)
										{
											num_consent_bo++;
											consentflag = true;
										}										
									}
									else if(multiConsentValues[3].equals("R"))
									{
										if(num_of_consent_req_br!=num_consent_br)
										{
											num_consent_br++;
											consentflag = true;
										}										
									}
									if(consentflag)
									{
										%>
										<input type='hidden' value="Y" name="consent_chk<%=count%><%=total_recs%>" id="consent_chk<%=count%><%=total_recs%>">
										<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id<%=count%><%=total_recs%>">
										<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_stages<%=count%><%=total_recs%>">
										<%
										total_recs++;
										consentflag = false;
									}		
								}
							}							
							%>
							<Input type='hidden' name="consent_form_list<%=count%>" id="consent_form_list<%=count%>" value="<%=multiConsentDtls[0]%>">
							<Input type='hidden' name="total_recs<%=count%>" id="total_recs<%=count%>" value="<%=total_recs%>">
							<%
						}
						else
						{
							if(multiConsentDtls[0].equals("F"))
							{	
								if(!bean.checkForNull(multiConsentDtls[3]).equals(""))
								{
									total_recs = total_recs++;
								}
								%>							
								<input type="hidden" value='<%=multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")%>' name="consent_stages<%=count%>0">		
								<input type="hidden" value="Y" name="consent_chk<%=count%>0" id="consent_chk<%=count%>0">
								<input type='hidden' value="<%=multiConsentDtls[3]%>" name="consent_form_id<%=count%>0">							
							<%
							}
							%>
							<Input type='hidden' name="consent_form_list<%=count%>" id="consent_form_list<%=count%>" value="<%=multiConsentDtls[0]%>">
							<Input type='hidden' name="total_recs<%=count%>" id="total_recs<%=count%>" value="<%=total_recs%>">
							<%
						}
						%>
							<Input type='hidden' name="multiConsentList<%=count%>" id="multiConsentList<%=count%>" value="<%=total_recs%>">
						<%
					}
				}		
				
				secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class
				if (bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
				    sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties,records[0],"R",bean.getPatientClass()),""); // Pass the catalog_code,priority default as "R" and patient_class
					sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);

%>
                <Script>
					(document.getElementById("start_date_time<%=count%>")).value = '<%=sec_start_date_time%>';
                </Script>
				<a class="gridLink" href="javascript:viewSecondaryOrders('<%=count%>','<%=bean.getPatientClass()%>')"> <img src='../../eOR/images/SecondaryOrder.gif' border='0'  title='Secondary Orders Exists'></img>&nbsp;</a>
				<%}%>
<%
				if(!format_id.equals(""))  // check for the Format
				{
			//		arrSeqNo = (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(records[0], records[0]+"_"+count);
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean
%>
			<%--			<a href="javascript:orderFormatForLines('format_id_val<%=count%>','<%=count%>','<%=records[0]%>','<%=format_id_mandatory_yn%>','<%=care_set_count[1]%>','<%=records[44]%>','<%=records[43]%>')" title='Order Line Format'><img src='../../eOR/images/Flex_red.gif' align='center'></img></a> --%>
<%			/*			if(arrSeqNo!=null && arrSeqNo.size()>0) // if it is not from the bean
						{
							out.println("<script>setOrderFormatLine('"+count+"','Y')</script>");
						}
						else
						{
			 	    		out.println("<script>setOrderFormatLine('"+count+"','N')</script>");
						}
			*/
						format_mandatory_count++;
					}
					else
					{
%>
			<%--		<a href="javascript:orderFormatForLines('format_id_val<%=count%>','<%=count%>','<%=records[0]%>','<%=format_id_mandatory_yn%>','<%=care_set_count[1]%>','<%=records[44]%>','<%=records[43]%>')" title='Order Line Format'><img src='../../eOR/images/Flex_blue.gif' align='center'></img></a> --%>
<%		 	//    		out.println("<script>setOrderFormatLine('"+count+"','Y')</script>");
		 	    		format_count++;
		 	   		} // else of format_id_mandatory_yn
			   	}
%>
				<input type="hidden" name="sec_tasks_type<%=count%>" id="sec_tasks_type<%=count%>" value="<%=secondaryOrders[1]%>">
				</td>
				<td class="<%=classValue%>" id="billing10<%=count%>" align="left"  rowspan='2'><font size="1"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></font><input type="text" name="end_date_time<%=count%>" id="end_date_time<%=count%>" size="8" maxLength="16" value="" readOnly></td>
<%
				if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
				{
					out.println("<script>calculateEndDateTime('"+rel_start_date_time[i]+"','D','90',"+count+",'');</script>");
				}
%>
				<td class="<%=classValue%>" id="billing11<%=count%>" rowspan='2' align="left" colspan='2' nowrap><label  id="schedule<%=count%>" Title="Schedule">&nbsp;</label><!-- </td>
				<td class="<%=classValue%>" align="left"> --><font size="1">&nbsp;<%	
					//if( (care_set_count[1].equals("LB") && lb_instal_yn.equals("Y")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || !care_set_count[1].equals("NC")  ) { changed on 7/9/2007 for lb_instal_yn by uma
					if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) {%>
					<font size="1"><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></b></font><br>
<%				} 
				
				//if( (care_set_count[1].equals("LB") && lb_instal_yn.equals("Y")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || (!care_set_count[1].equals("NC") && !care_set_count[1].equals("PH")) ) {changed on 7/9/2007 for lb_instal_yn by uma
				if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) 
				{%>					
	 				<select name="performing_facility_id<%=count%>" id="performing_facility_id<%=count%>" onchange='clearDepLocn("<%=count%>","<%=records[0]%>","<%=care_set_count[1]%>","<%=orderTypeRecords[0]%>","<%=rd_install_yn%>",this);setPerformingFacility("performing_facility_id<%=records[0]%>",this);'>
					<%					
						performingLocationCode = bean.getPerformingLocation(care_set_count[1],orderTypeRecords[0],records[0]);
						if(bean.getTempvalue("performing_facility_id"+records[0])==null)
						{
							for(int j=0; j<performingLocationCode.size(); j++)
							{
								performingLocation	= (String[]) performingLocationCode.get(j);	
								if(performingLocation[0].equals(records[5])) //let the last one be selected 
								{
									out.println("<option value=\""+performingLocation[0]+"\" selected> "+performingLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+performingLocation[0]+"\" > "+performingLocation[1]+" </option>");
								}
							}
						}
						else
						{
							for(int j=0; j<performingLocationCode.size(); j++)
							{
								performingLocation	= (String[]) performingLocationCode.get(j);			
								if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
								{
									out.println("<option value=\""+performingLocation[0]+"\" selected> "+performingLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+performingLocation[0]+"\" > "+performingLocation[1]+" </option>");
								}
							}
						}				
				%>
 				</select></font>/
				<%
				}
				else
				{
					%>
					<font size="1"><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/>&nbsp;:</b><br>
					<%				
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
					%>
 					<%=facility_name%></font>/
					<input type="hidden" name="performing_facility_id<%=count%>" id="performing_facility_id<%=count%>" value="<%=records[5]%>">
				<%
				}
				if((care_set_count[1].equals("LB") )|| (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX"))||(care_set_count[1].equals("TR")) ||(care_set_count[1].equals("MI"))||(care_set_count[1].equals("PC"))) 
				{ 		
				%>
				<select name="performing_dept_loc_code<%=count%>" id="performing_dept_loc_code<%=count%>" onchange=' getApptReqdYN("<%=records[0]%>",this,"<%=count%>");'>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],lb_instal_yn,rd_install_yn);changed on 7/9/2007 for lb_instal_yn by uma 
						ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],orderTypeRecords[0],rd_install_yn);
					
						for(int j=0; j<DeptLocationCode.size(); j++)
						{
							deptLocation	= (String[]) DeptLocationCode.get(j);
							if(deptLocation[2] != null && deptLocation[2].equals("Y"))  // default_yn
							{
								out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								
							}
							else 
							{
								out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
							}

						}
 						if(DeptLocationCode!=null) {
							DeptLocationCode.clear();
							DeptLocationCode	= null;
						}
%>
				</select>
<%				} else if(care_set_count[1].equals("PH")){
						
						drugclass						= beanQueryObj.getDrugDetails(properties, records1[0]);
   						for(int k=0; k<drugclass.size(); k++)  // Only one record
						{
							records1					= (String[]) drugclass.get(k);
							drug_class					= records1[13] ;
						}
						facility_name = bean.getPerformingFacilityName(records[5]);	  %>
					<%=facility_name%>  
					<select name="performing_dept_loc_code<%=count%>" id="performing_dept_loc_code<%=count%>" >
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						ArrayList DeptLocCode1 = bean.getPerformDeptLocation1(records[5], records[0],records[52],records[4],drug_class);
						for(int j=0; j<DeptLocCode1.size(); j++)
						{
							deptLocation1	= (String[]) DeptLocCode1.get(j);
				 			// Should be handled in PH, since not handled, done here
							if(deptLocation1[0]!=null && deptLocation1[0].indexOf("|")!=-1){
								performing_dept_loc_code = deptLocation1[0].substring(0,deptLocation1[0].indexOf("|"));
							}
							else
								performing_dept_loc_code = deptLocation1[0];
							if(deptLocation1[1]!=null &&  deptLocation1[1].indexOf("|")!= -1){
								performing_dept_loc_desc = deptLocation1[1].substring(0,deptLocation1[1].indexOf("|"));
							}
							else
								performing_dept_loc_desc = deptLocation1[1];
							// Till here

							out.println("<option value=\""+performing_dept_loc_code+"\" SELECTED> "+performing_dept_loc_desc+" </option>");
						}
						if(DeptLocCode1!=null) {
							DeptLocCode1.clear();
							DeptLocCode1	= null;
						}
				}else { %>
					<input type="hidden" name="performing_dept_loc_code<%=count%>" id="performing_dept_loc_code<%=count%>" value="">
					
<%				}


				%>
				
				</font>
				
				<!-- IN066377 start -->
				<%	//IN066377 start
						try
						{
							con				=	ConnectionManager.getConnection(request);
							String sql = "select * from or_order_perf_locn_mand where order_category=?";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,care_set_count[1]);
							rs = pstmt.executeQuery();
							if(rs.next()){
								perfLocnMandFlag = bean.checkForNull(rs.getString(l_patient_class),"N");
								//IN070295 Start.
								%>
								<input type="hidden" name="perfLocnMandFlag<%=count%>" id="perfLocnMandFlag<%=count%>" value="<%=perfLocnMandFlag%>"><!--IN066377-->
								<%
								//IN070295 End.
							}
							if (pstmt!=null) pstmt.close();
							if( rs!=null) rs.close();
							String btOrderTypeQuery = "SELECT DISTINCT order_type_code FROM or_order_catalog WHERE order_category = 'LB' AND order_type_code IN ( SELECT order_type_code FROM rl_section_code WHERE section_code IN ( SELECT bt_section_code FROM rl_param))";
							pstmt = con.prepareStatement(btOrderTypeQuery);
							rs = pstmt.executeQuery();
							if(rs.next()){
								bt_order_type_code = rs.getString("order_type_code")==null ?"":rs.getString("order_type_code");
							}
							if (pstmt!=null) pstmt.close();
							if( rs!=null) rs.close();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						finally
						{
							if(con!=null) 
								ConnectionManager.returnConnection(con,request);
						}
						//IN066377 end
					%>	
					 <%
					//for RADIOLOGY
					 if(("RD".equals(care_set_count[1])) && ("Y".equals(rd_install_yn))){ 
							if("Y".equals(perfLocnMandFlag)){%>	
								<img src="../../eCommon/images/mandatory.gif">
								<%}
						}						
						//EXCEPT RADIOLOGY
						String cat_type_code = records[4];	
						if((!"RD".equals(care_set_count[1])) && ("Y".equals(perfLocnMandFlag)) && !(cat_type_code.equals(bt_order_type_code))){%>
								<img src="../../eCommon/images/mandatory.gif">
						<%}
						%><!-- IN066377 end -->
				
				
				
				</td>
				<td colspan="4" id="billing12<%=count%>" rowspan='2' class="<%=classValue%>" align="left" style="text-align:left" style='border-right-width: 0;' >
				<%				
				
				boolean show_bill_dtls = false;//IN065324
				
				//IN065324, starts
				if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(records[43].trim()))
				{
					show_bill_dtls = true;
				}
				//IN065324, ends
				

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN68314 Starts
					//BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],rel_start_date_time[i], localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					if("Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],records[75]) ;
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],rel_start_date_time[i], localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN68314 Ends
					if(BillChargeInfo!=null)
					{
						
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
							billing_details 	= (String[])BillChargeInfo.get(k);
							setBills_dtls		= new HashMap();
		
							setBills_dtls.put("charged_yn"       , billing_details[1]);							
							setBills_dtls.put("total_payable"    , billing_details[2]);
							setBills_dtls.put("patient_payable"  , billing_details[3]);
							setBills_dtls.put("quantity"         , qty_value);
							setBills_dtls.put("incl_excl_action" , billing_details[4]);
							setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);//IN068314
							setBills_dtls.put("fpp_category"		 , records[75]);//IN068314
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");	orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							 if(!billing_details[9].equals(""))
							{numbering=1;finbill="Billing";%>

								 <script>alert("<%=billing_details[9]%>");billchecking("<%=records[0]%>");displaycolor("<%=count%>");</script>

							<% displaytooltip=billing_details[9];
						  	} 
							if(billing_details[10].equals("")||billing_details[11].equals(""))
							{
								numbering=1;
							
								%>
								<script>
										 var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
										msg=msg.replace('{1}',"<%=records[0]%>");
										alert(msg);
										billchecking("<%=records[0]%>");displaycolor("<%=count%>");
								</script>
								<% 
								displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							}
						}
					}
					if(numbering==1 && (order_set_bill_yn.equalsIgnoreCase("N"))&&(charge_yn.equalsIgnoreCase("Y")))
					{
							Set setValues			= null;
							Iterator iterator 		= null;
							if(previousValues!=null)		// Get the Previous Values from the Bean
   	 						{
	 								setValues 			= previousValues.keySet();
									iterator 				= setValues.iterator();
									String chk_value="";
									//String check="";
										//String order_category	= "";
	 		                         String order_type		= "";
   									for(int z=0;z<previousValues.size();z++)
   									{
   										entryValue 	 = ((String)iterator.next()) ;
										chk_value= (String)previousValues.get(entryValue);
										keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
										//hashEntry.put(entryValue,"Y");
										if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
										{
											if(!chk_value.equals("N"))
											{
												check=records[0];
												if((entryValue.substring(2)).equals(check))
												{
													hashEntry.put(entryValue,"N");
												}
												else
												{
													hashEntry.put(entryValue,"Y");
												}
											}
										}
										else // If it is hidden Field
										{
											if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
											{
												order_category = (String)previousValues.get("h1"+keyItems[1]) ;
												hashEntry.put("h1"+keyItems[1],order_category) ;
											}
											else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
											{
												order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
												hashEntry.put("h2"+keyItems[1],order_type) ;
											}
										}
								}
						}
						orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						previousValues=(HashMap)orderEntryRecordBean.getCheckedEntries(key);
					}
				

						
						//}
					//}
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
							
%>
				<!--	<table cellpadding=0 cellspacing=0 border=1 width='100%' align='left' style='border-width:0' class="grid"> --> <!--  commented for IN035929[IN040092] -->
				 <table cellpadding=0 cellspacing=0 border=1 width='100%' align='left' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%>  class="grid"> 
				 <!--  modified for IN035929[IN040092] -->
					
						<tr >	
						<!--IN068314 Starts-->
						<%
							if("Y".equals(records[74]))
							{	%>
							<input type="hidden" name="fpp_yn<%=count%>" id="fpp_yn<%=count%>"  value="<%=records[74]%>" ><!-- IN072744 -->
							<td rowspan="2" colspan="" width='50%' class="<%=classValue%>" style='border-width:0;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${common_labels}"/>:</B></font>
						
								<select name="fpp_category<%=count%>" id="fpp_category<%=count%>"  onchange="reviseBillingchrgs('<%=count%>','NEW_ORDER')" ><!-- IN072744 -->
									<option value="S" <%="S".equals(records[75])?"selected":""%>><fmt:message key="eOR.Simple.label" bundle="${common_labels}"/></option>
									<option value="M" <%="M".equals(records[75])?"selected":""%>><fmt:message key="eOR.Medium.label" bundle="${common_labels}"/></option>
									<option value="C" <%="C".equals(records[75])?"selected":""%>><fmt:message key="eOR.Complex.label" bundle="${common_labels}"/></option>
								</select>
							
							</td>
							<%}else{ %> 
							<td width='50%' rowspan="2" class="<%=classValue%>" style='border-width:0;'>&nbsp;</td>
							<%} %>
							<!--IN068314 Ends-->
							<td colspan="" width='10%' class="<%=classValue%>" style='border-width: 0;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
							<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
								<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'  nowrap><font class='fields' size="1"><span id='bill_now_<%=count%>' style='visibility:<%=(((bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"N").equalsIgnoreCase("Y"))&&((bean.checkForNull(records[33],"N").equalsIgnoreCase("Y"))))?"visible":"hidden")%>'><fmt:message key="eOR.BillLater.label" bundle="${or_labels}"/><input type="checkbox" name='bill_now_check<%=count%>' id='bill_now_check<%=count%>'value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>" <%=(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")%> onclick="changeBillNow(this,'<%=count%>')" ></span></font><%if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){%>(<fmt:message key="eOR.ApptRequired.label" bundle="${or_labels}"/>)<%}%></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=count%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=count%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=count%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")%></span></font></td>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=count%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font></td>
							<%
							}
							%>
						</tr>
								<input type="hidden" name="bill_now<%=count%>" id="bill_now<%=count%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
							   <input type="hidden" name="bill_now_check_Df<%=count%>" id="bill_now_check_Df<%=count%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
								<input type="hidden" name="future_date<%=count%>" id="future_date<%=count%>"  value="<%=billing_details[18]%>" >
								<input type="hidden" name="round_off_start_time<%=count%>" id="round_off_start_time<%=count%>"  value="<%=billing_details[19]%>" >
					</table>
<%				} else{ billing_call_yn = "N";
						out.println("&nbsp;");
				}

%>					
				</td>
				<%if(numbering==0)
					{%>
				<td id ="order<%=count%>" class="<%=classValue%>" rowspan='2' align="left" <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%>>&nbsp;<font size="1"> <!--  added for IN035929[IN040092] --><!--IN068314-->
<%
				
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT")&& order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y") && show_bill_dtls)//IN065324
				{
					//billing_call_yn		= "Y";
					//if(numbering==0)
					//{
%>
					<!-- <a href="javascript:callBilling('<%=count%>','NEW_ORDER')" title='Charge Details'><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></a> -->
					<a class="gridLink"  href="javascript:callReviseBilling('<%=count%>','NEW_ORDER','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','','')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> <!--View / Edit--></a>

					<%
					} 
					else 
						billing_call_yn = "N"; 
					%> 
					</font>
					</td>
					<%
					}
					else
					{
					%>
						<td id ="order<%=count%>" style="background=#FF7DD0;" rowspan='2'></td><!--IN068314--><%
					}
					/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
					if(records[48].equalsIgnoreCase("Y"))
					{
						String PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth);
						if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
						{
							numbering=1;	
							non_billing_numbering=1;//IN068314
							billinginterface = "auth_interface";
						%>
							 <script>
								 var msg=getMessage("PRIV_ORDER_AUTH_RIGHTS","OR");
								msg=msg.replace('{1}',"<%=records[0]%>");
								alert(msg);
								billchecking("<%=records[0]%>");
								displaycolor("<%=count%>");//IN072744
								disableFPPCategoryOrderset("<%=count%>");//IN068314//IN072744
							</script>
								<% 		
								displaytooltip=bean.getMessage(localeName,"PRIV_ORDER_AUTH_RIGHTS","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						}
					}
					if(records[69].equalsIgnoreCase("N"))
					{
						numbering=1;		
						non_billing_numbering=1;//IN068314
						billinginterface = "operational_interface";
						%>
						 <script>
							 var msg=getMessage("CATALOG_OPERATIONAL_MODULE","OR");
							msg=msg.replace('{1}',"<%=records[0]%>");
							alert(msg);
							billchecking("<%=records[0]%>");
							displaycolor("<%=count%>");//IN072744
							disableFPPCategoryOrderset("<%=count%>")//IN068314//IN072744
						</script>
							<% 		
							displaytooltip=bean.getMessage(localeName,"CATALOG_OPERATIONAL_MODULE","OR");
							displaytooltip=displaytooltip.replace("{1}",records[0]);
					}
								
					if(numbering==1)
					{
						Set setValues			= null;
						Iterator iterator 		= null;
						if(previousValues!=null)		// Get the Previous Values from the Bean
						{
							setValues 			= previousValues.keySet();
							iterator 				= setValues.iterator();
							String chk_value="";
							//String check="";
							//String order_category	= "";
							String order_type		= "";
							for(int z=0;z<previousValues.size();z++)
							{
								entryValue 	 = ((String)iterator.next()) ;
								chk_value= (String)previousValues.get(entryValue);
								keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
								//hashEntry.put(entryValue,"Y");
								if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
								{
									if(!chk_value.equals("N"))
									{
										check=records[0];
										if((entryValue.substring(2)).equals(check))
										{
											hashEntry.put(entryValue,"N");
																										
										}
										else
										{
											hashEntry.put(entryValue,"Y");
										}
									}
								}
								else // If it is hidden Field
								{
									if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
									{
										order_category = (String)previousValues.get("h1"+keyItems[1]) ;
										hashEntry.put("h1"+keyItems[1],order_category) ;
									}
									else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
									{
										order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
										hashEntry.put("h2"+keyItems[1],order_type) ;
									}
								}
							}
						}
								orderEntryRecordBean.setCheckedEntries(key, hashEntry);
								previousValues=(HashMap)orderEntryRecordBean.getCheckedEntries(key);
					}
					/*Ends Here*/
					//ININ071260 Starts
					HashMap<String, String> interactionYN = null;
					String checkUncheck =null;
					HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
					if("LB".equals(care_set_count[1])){
							System.out.println("order_catalog_code===>"+order_catalog_code+"---"+records[0]);
							bean.chkDrugInteractionForLB(records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
							interactionYN=bean.getDruginteractionYN();
							interdrugDtls = bean.getDruginteractionDtl();
							if(null!=interdrugDtls)
								drugintercnt =	interdrugDtls.size();
							checkUncheck =	interactionYN.get(records[0]);
						if("R".equals(checkUncheck)){
						%>
						 <script>
								labdruginterchk("<%=records[0]%>");		
							
						 </script>
						
						<%}
						%>
						<script>
							setDrugInteraction("<%=total_recs%>","<%=drugintercnt%>");
						</script>
						<% }//IN071260 ENDS	%>
					
					<%
					if(bean.checkForNull(records[66],"N").equalsIgnoreCase("N"))
					{
						records[66] = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, care_set_count[1]),"N");
					}
					if(charge_yn.equalsIgnoreCase("N"))
					{
						if(billing_call_yn.equals("Y"))
							billing_call_yn = "N";
					}
					%>
					<input type="hidden" name="order_catalog_nature<%=count%>" id="order_catalog_nature<%=count%>" value="<%=records[2]%>">
					<input type="hidden" name="quantity_uom<%=count%>" id="quantity_uom<%=count%>" value="<%=records[11]%>">
					<input type="hidden" name="freq_applicable_yn<%=count%>" id="freq_applicable_yn<%=count%>" value="<%=records[14]%>">
					<input type="hidden" name="soft_stop_yn<%=count%>" id="soft_stop_yn<%=count%>" value="<%=records[19]%>">
					<input type="hidden" name="cont_order_yn<%=count%>" id="cont_order_yn<%=count%>" value="<%=records[20]%>">
					<input type="hidden" name="chk_for_dupl_yn<%=count%>" id="chk_for_dupl_yn<%=count%>" value="<%=records[22]%>">
					<input type="hidden" name="chk_for_dupl_status<%=count%>" id="chk_for_dupl_status<%=count%>" value="<%=records[23]%>">
					
					<input type="hidden" name="chk_for_dupl_ahead_action<%=count%>" id="chk_for_dupl_ahead_action<%=count%>" value="<%=records[24]%>">
					<input type="hidden" name="chk_for_dupl_ahead_period<%=count%>" id="chk_for_dupl_ahead_period<%=count%>" value="<%=records[25]%>">
					<input type="hidden" name="chk_for_dupl_ahead_unit<%=count%>" id="chk_for_dupl_ahead_unit<%=count%>" value="<%=records[26]%>">
					<input type="hidden" name="chk_for_dupl_behind_action<%=count%>" id="chk_for_dupl_behind_action<%=count%>" value="<%=records[27]%>">
					<input type="hidden" name="chk_for_dupl_behind_period<%=count%>" id="chk_for_dupl_behind_period<%=count%>" value="<%=records[28]%>">
					<input type="hidden" name="chk_for_dupl_behind_unit<%=count%>" id="chk_for_dupl_behind_unit<%=count%>" value="<%=records[29]%>">

					<input type="hidden" name="appt_reqd_yn<%=count%>" id="appt_reqd_yn<%=count%>" value="<%=records[33]%>">
					<input type="hidden" name="locn_appt_reqd_yn<%=count%>" id="locn_appt_reqd_yn<%=count%>" value="<%=locn_appt_reqd_yn%>">
					<input type="hidden" name="appt_time<%=count%>" id="appt_time<%=count%>" value="<%=records[34]%>">
					<input type="hidden" name="pat_instrn_age_sex_yn<%=count%>" id="pat_instrn_age_sex_yn<%=count%>" value="<%=records[35]%>">
					<input type="hidden" name="complete_on_order_yn<%=count%>" id="complete_on_order_yn<%=count%>" value="<%=records[37]%>">
					<!-- <input type="hidden" name="bill_yn<%=count%>" id="bill_yn<%=count%>" value="<%=records[38]%>"> -->
					<input type="hidden" name="bill_yn<%=count%>" id="bill_yn<%=count%>" value="<%=billing_call_yn%>">
					<input type="hidden" name="result_applicable_yn<%=count%>" id="result_applicable_yn<%=count%>" value="<%=records[39]%>">
					<input type="hidden" name="result_auth_reqd_yn<%=count%>" id="result_auth_reqd_yn<%=count%>" value="<%=records[40]%>">
					<input type="hidden" name="chart_result_type<%=count%>" id="chart_result_type<%=count%>" value="<%=records[41]%>">
					<input type="hidden" name="contr_msr_mod_id<%=count%>" id="contr_msr_mod_id<%=count%>" value="<%=records[43]%>">
					<input type="hidden" name="contr_msr_panel_id<%=count%>" id="contr_msr_panel_id<%=count%>" value="<%=records[44]%>">
					<input type="hidden" name="ord_auth_reqd_yn<%=count%>" id="ord_auth_reqd_yn<%=count%>" value="<%=records[48]%>">
					<input type="hidden" name="ord_cosign_reqd_yn<%=count%>" id="ord_cosign_reqd_yn<%=count%>" value="<%=records[49]%>">
					<input type="hidden" name="ord_spl_appr_reqd_yn<%=count%>" id="ord_spl_appr_reqd_yn<%=count%>" value="<%=records[50]%>">
					<input type="hidden" name="ord_consent_reqd_yn<%=count%>" id="ord_consent_reqd_yn<%=count%>" value="<%=records[51]%>">
					<input type="hidden" name="activity_type<%=count%>" id="activity_type<%=count%>" value="<%=records[53]%>">
					<input type="hidden" name="check_for_dupl_level<%=count%>" id="check_for_dupl_level<%=count%>" value="<%=records[54]%>">
					<input type="hidden" name="routine_appt_reqd_yn<%=count%>" id="routine_appt_reqd_yn<%=count%>" value="<%=records[55]%>">
					<input type="hidden" name="stat_appt_reqd_yn<%=count%>" id="stat_appt_reqd_yn<%=count%>" value="<%=records[56]%>">
					<input type="hidden" name="urgent_appt_reqd_yn<%=count%>" id="urgent_appt_reqd_yn<%=count%>" value="<%=records[57]%>">
					<input type="hidden" name="routine_chk_for_dupl_yn<%=count%>" id="routine_chk_for_dupl_yn<%=count%>" value="<%=records[58]%>">
					<input type="hidden" name="urgent_chk_for_dupl_yn<%=count%>" id="urgent_chk_for_dupl_yn<%=count%>" value="<%=records[59]%>">
					<input type="hidden" name="stat_chk_for_dupl_yn<%=count%>" id="stat_chk_for_dupl_yn<%=count%>" value="<%=records[60]%>">
					<input type="hidden" name="consent_stage<%=count%>" id="consent_stage<%=count%>" value="<%=records[61]%>">
					
					<!--added on 08/05/07 -->
					<input type="hidden" name="num_of_consent_req_bo<%=count%>" id="num_of_consent_req_bo<%=count%>" value="<%=records[64]%>">
					<input type="hidden" name="num_of_consent_req_br<%=count%>" id="num_of_consent_req_br<%=count%>" value="<%=records[65]%>">
					<input type="hidden" name="billing_interface<%=count%>" id="billing_interface<%=count%>" value="<%=billinginterface%>">
					<input type="hidden" name="service_panel<%=count%>" id="service_panel<%=count%>" value="<%=servicepanel%>">
					<input type="hidden" name="service_panel_code<%=count%>" id="service_panel_code<%=count%>" value="<%=servicepanelcode%>">
					<input type="hidden" name="numbering<%=count%>" id="numbering<%=count%>" value="<%=numbering%>">
					<input type="hidden" name="FinBill<%=count%>" id="FinBill<%=count%>" value="<%=finbill%>">
					<input type="hidden" name="clin_cmts_reqd_yn<%=count%>" id="clin_cmts_reqd_yn<%=count%>" value="<%=bean.checkForNull(records[66],"N")%>">
					<input type="hidden" name="authorised_yn<%=count%>" id="authorised_yn<%=count%>" value="N">
				<%if(speciality_code[0].equalsIgnoreCase("Y"))
					{
				%>
						<input type="hidden" name="splty_code<%=count%>" id="splty_code<%=count%>" value="<%=speciality_code[1]%>">
						<input type="hidden" name="auth_yn<%=count%>" id="auth_yn<%=count%>" value="<%=speciality_code[2]%>">
				<%
					}else
					{%>
						<input type="hidden" name="splty_code<%=count%>" id="splty_code<%=count%>" value="">
						<input type="hidden" name="auth_yn<%=count%>" id="auth_yn<%=count%>" value="<%=bean.checkForNull(records[67],"N")%>">
				<%}%>

					
					<!-- ends here-->
					
					
					<input type="hidden" name="group_order_category<%=count%>" id="group_order_category<%=count%>" value="<%=care_set_count[1]%>">
					<input type="hidden" name="billing_call_yn<%=count%>" id="billing_call_yn<%=count%>" value="<%=billing_call_yn%>">
					<input type="hidden" name="specimen_type<%=count%>" id="specimen_type<%=count%>" value="">
					<input type="hidden" name="nurse_collect<%=count%>" id="nurse_collect<%=count%>" value="N">
					<input type="hidden" name="care_set_authorized<%=count%>" id="care_set_authorized<%=count%>" value="false">
					<input type="hidden" name="order_id<%=count%>" id="order_id<%=count%>" value=""> <!-- For Copy Order -->
					<input type="hidden" name="order_line_num<%=count%>" id="order_line_num<%=count%>" value=""> <!-- For Copy Order -->
					<input type="hidden" name="line_preps<%=count%>" id="line_preps<%=count%>" value=""> <!-- For Copy Order -->
					<input type="hidden" name="line_pat_instrn<%=count%>" id="line_pat_instrn<%=count%>" value=""> <!-- For Copy Order -->
					<input type="hidden" name="line_dept_instrn<%=count%>" id="line_dept_instrn<%=count%>" value=""> <!-- For Copy Order -->
					<input type="hidden" name="line_comments<%=count%>" id="line_comments<%=count%>" value="">
					<%if(numbering==1){%><input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=displaytooltip%>"> 
					<%}else{%>
					<input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=bean.checkForNull(records[62],"")%>">
					<%}%><%-- explanatory_text--%>
					<input type="hidden" name="auto_report_yn<%=count%>" id="auto_report_yn<%=count%>" value="<%=bean.checkForNull(records[63],"")%>"> <%-- auto_report_yn--%>
					<input type="hidden" name="skip_auth<%=count%>" id="skip_auth<%=count%>" value="<%=records[70]%>"><!--IN048467 - HSA-CRF-0150-->	
					<input type="hidden" name="prn_regd_ord<%=count%>" id="prn_regd_ord<%=count%>" value="<%=records[72]%>"><!--IN065942-->
					<input type="hidden" name="instrn_content_type<%=count%>" id="instrn_content_type<%=count%>" value='<%=bean.checkForNull(records[73],"T")%>'><!--IN065942-->
					<input type="hidden" name="non_billing_numbering<%=count%>" id="non_billing_numbering<%=count%>"  id ="non_billing_numbering<%=count%>" value="<%=non_billing_numbering %>" /><!--IN068314 -->
			</tr>

<%			// If it is only Pharmacy Category
			if(records[3].equals("PH")) { 
				// Pharmacy Order Set Related
				
				String form_code				= "", form_desc					= "";
				String route_code				= ""; //route_desc				= "";
				String strength_value			= "", dosage_type				= "";
				//String ori_dosage_type			= "";
				String pres_base_uom				= "";
				String dosage_legend			= "", dosage_option				= "";
				String strength_uom_desc		= "", strength_per_pres_uom		= "";
				String strength_per_value_pres_uom="", fract_dose_round_up_yn	= "";
				String content_in_pres_base_uom	= "", prn_doses_pres_prd_fill	= "";
				String dosage					= "", stock_uom					= "";//,drug_class="" ;
				String[] dosageRecords			= null; String[] routeDetails	= null;
				String[] uomDetails				= null;
				String[] ph_records				= null;
				ArrayList RouteCode				= null; ArrayList UOMDtls		= null;
				// Till here
				arrDrugDtls						= beanQueryObj.getDrugDetails(properties, records[0]);
				for(int j=0; j<arrDrugDtls.size(); j++)  // Only one record
				{
						ph_records						= (String[]) arrDrugDtls.get(j);
						form_code					= ph_records[2] ; 
						form_desc					= ph_records[3] ; 
						route_code					= ph_records[4] ;
						//route_desc					= records[5] ; 
						strength_value				= ph_records[6] ; 
						strength_uom_desc			= ph_records[7] ; 
						pres_base_uom				= ph_records[8] ; 
					//	drug_class					=records[13] ;


						strength_per_pres_uom		= ph_records[14] ;
						strength_per_value_pres_uom = ph_records[15] ;
						fract_dose_round_up_yn		= ph_records[18] ;
						content_in_pres_base_uom	= ph_records[19] ;
						prn_doses_pres_prd_fill		= ph_records[20] ;
						stock_uom					= ph_records[21] ;
						// To get the dosage_type and build the legend and the list item
						dosageRecords				= beanQueryObj.getDosage(strength_value,records[11]); //records[11] = calc_dosg_by_freq_durn_yn
						dosage_type					= dosageRecords[0];
						//ori_dosage_type				= dosageRecords[1];
						dosage_legend				= dosageRecords[2];
						dosage_option				= dosageRecords[3];
						dosage						= dosageRecords[4];
 				} // End of for j 
				arrDrugDtls			= null;
%>
			<table>
			<tr>
				<td class="<%=classValue%>" align="left">&nbsp;</td>
				<td class="<%=classValue%>" align="left" >&nbsp;</td>
				<td class="<%=classValue%>" align="left" colspan="2"><font size="1" color="blue"><fmt:message key="Common.Form.label" bundle="${common_labels}"/><b><%=form_desc%></b> <fmt:message key="Common.Strength.label" bundle="${common_labels}"/> <b><%=strength_value%></b> <%=strength_uom_desc%></font>
					<input type="hidden" name="form_code<%=count%>" id="form_code<%=count%>" value="<%=form_code%>">
					<input type="hidden" name="strength_value<%=count%>" id="strength_value<%=count%>" value="<%=strength_value%>">	
				</td>
				<td class="<%=classValue%>" align="left" ><font size="1"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></font> &nbsp;
					<select name="route_code<%=count%>" id="route_code<%=count%>">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%						RouteCode = beanQueryObj.getRouteDetails(properties, form_code);
						for(int j=0; j<RouteCode.size(); j++)
						{
							routeDetails	= (String[]) RouteCode.get(j);
							if(route_code.equals(routeDetails[0]))
								out.println("<option value=\""+routeDetails[0]+"\" SELECTED> "+routeDetails[1]+" </option>");
							else 
								out.println("<option value=\""+routeDetails[0]+"\"> "+routeDetails[1]+" </option>");
						}
%>
					</select>
				</td>

				<td class="<%=classValue%>" align="left"><font size="1"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></font> &nbsp;
					<select name="dosage_by<%=count%>" id="dosage_by<%=count%>" onChange="changeDosage(this, <%=count%>)">
						<%=dosage_option%>
 					</select>
				</td>
 				<td id="dosage_id<%=count%>" class="<%=classValue%>" align="left">&nbsp;<%=dosage_legend%>
 				</td>
				<td class="<%=classValue%>" align="left"><input type="text" name="dosage<%=count%>" id="dosage<%=count%>" size="4" maxLength="6" value="<%=dosage%>" onKeyPress="return(ChkNumberInput(this,event,'2'))" onBlur="calculatePHQuantity(<%=count%>)"> </td>
				<td class="<%=classValue%>" align="left">
					<select name="uom<%=count%>" id="uom<%=count%>">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%						if(dosage_type.equals("S")){
							out.println("<option value=\""+strength_uom_desc+"\" SELECTED> "+strength_uom_desc+" </option>");
						}else  {
							UOMDtls = beanQueryObj.getUOMDetails(properties, form_code);
							for(int j=0; j<UOMDtls.size(); j++)
							{
								uomDetails	= (String[]) UOMDtls.get(j);

								if(pres_base_uom.equals(uomDetails[0]))
								{
									out.println("<option value=\""+uomDetails[0]+"\" SELECTED> "+uomDetails[1]+" </option>");
								}
								else{ 
									out.println("<option value=\""+uomDetails[0]+"\"> "+uomDetails[1]+" </option>");
								}
							}
						}
%>						
					</select>
				</td>
				<input type="hidden" name="dosage_type<%=count%>" id="dosage_type<%=count%>" value="<%=dosage_type%>">
				<input type="hidden" name="strength_uom_desc<%=count%>" id="strength_uom_desc<%=count%>" value="<%=strength_uom_desc%>">
				<input type="hidden" name="stock_uom<%=count%>" id="stock_uom<%=count%>" value="<%=stock_uom%>">
				<input type="hidden" name="strength_per_pres_uom<%=count%>" id="strength_per_pres_uom<%=count%>" value="<%=strength_per_pres_uom%>">
				<input type="hidden" name="strength_per_value_pres_uom<%=count%>" id="strength_per_value_pres_uom<%=count%>" value="<%=strength_per_value_pres_uom%>">
				<input type="hidden" name="fract_dose_round_up_yn<%=count%>" id="fract_dose_round_up_yn<%=count%>" value="<%=fract_dose_round_up_yn%>">
				<input type="hidden" name="content_in_pres_base_uom<%=count%>" id="content_in_pres_base_uom<%=count%>" value="<%=content_in_pres_base_uom%>">
				<input type="hidden" name="prn_doses_pres_prd_fill<%=count%>" id="prn_doses_pres_prd_fill<%=count%>" value="<%=prn_doses_pres_prd_fill%>">
				<input type="hidden" name="pres_base_uom<%=count%>" id="pres_base_uom<%=count%>" value="<%=pres_base_uom%>">
				<!--<input type="hidden" name="instrn_content_type<%=count%>" id="instrn_content_type<%=count%>" value="<%=instrn_content_type%>">--><!--IN064543-->
			</tr>
	
<%			} // End of records[3] 
%>
			<tr>
				<td colspan="9" class="ORQRYEVENBORDER">&nbsp;</td>
			</tr>
<%						if(display_auth_count == 0 )	// To Hide the Authorization if no items have any authorization
							out.println("<script>setTimeout('hideCareSetAuthorization("+t+")',150);</script>");
							
						if(care_set_count[1].equals("PH") && records[4].equals("MS"))
						{
							if(!recordDefault[0].equals(""))
								out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+count+","+count+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
						}
						else
							out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+count+","+count+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
						count++;
					}
				}
				else
				{
				%>
					<script>
						/*Addded by Uma on 3/24/2010 for IN019999*/
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);
						
						//if(parent.criteriaDetailFrame.document.getElementById("recordApply")){
							if(parent.criteriaDetailFrame.document.getElementById("record")){
						
							parent.criteriaDetailFrame.document.getElementById("record").disabled=true;
						}

						if(parent.criteriaDetailFrame.document.getElementById("recordPreview"))
							parent.criteriaDetailFrame.document.getElementById("recordPreview").disabled=true;
						if(top.content==null)
							window.close();
						/*Ends Here by Uma for IN019999*/
					</script> 
				
				<%
				}
				%>
<%
				// Any Fields needed Format (mandatory) in the line level, legend has to be displayed in the button frame
				out.println("<script>setTimeout('setFormatLegends("+format_mandatory_count+","+format_count+")',200);</script>");
				order_set_order_catalog = ""; // Remove the values
				order_type_catalog			 = ""; // Remove the values
				order_type_catalog_sort		 = ""; // Remove the values //IN058388-IN058669
				out.println("<input type='hidden' name='care_set_order_category"+t+"' id='care_set_order_category"+t+"' value='"+care_set_count[1]+"'>");
				display_auth_count = 0;
				
			} // End of For PlaceOrderSetItems
			out.println("<input type='hidden' name='care_set_count' id='care_set_count' value='"+t+"'>");
	
				
		}	// End of if PlaceOrderSetItems (Outer Loop)
%>
</table>
		<input type="hidden" name="patient_email_id" id="patient_email_id" value="<%=patient_email_id%>">
		<input type="hidden" name="mode" id="mode" value="1">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>">
		<input type="hidden" name="total_rows" id="total_rows" value="<%=count%>"><!--used for New orders-->
		<input type="hidden" name="amend_total_rows" id="amend_total_rows" value="0">
		<input type="hidden" name="check_box_val" id="check_box_val" value="">

		<input type="hidden" name="authorized" id="authorized" value=""><!--used for New orders-->
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="location_type" id="location_type" value="">
		<input type="hidden" name="location_code" id="location_code" value="">
		<input type="hidden" name="priority_hdr" id="priority_hdr" value="">
		<input type="hidden" name="order_date_time" id="order_date_time" value="">
		<input type="hidden" name="header_comments" id="header_comments" value="">
		<input type="hidden" name="order_category" id="order_category" value="">
		<input type="hidden" name="total_size" id="total_size" value="">		
		<input type="hidden" name="consented" id="consented" value="">
		<input type="hidden" name="cosigned" id="cosigned" value="">
		<input type="hidden" name="special_approved" id="special_approved" value="">
		<input type="hidden" name="lb_instal_yn" id="lb_instal_yn" value="<%=lb_instal_yn%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="ordering_practitioner" id="ordering_practitioner" value="<%=bean.getPractitionerId()%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
		<!-- IN036387 Start -->
		<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
		<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
		<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
		<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
		<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
		<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
		<!-- IN036387 End. -->
		<input type="hidden" name="p_task_code" id="p_task_code" value="<%=p_task_code%>">
		<input type="hidden" name="p_task_srl_no" id="p_task_srl_no" value="<%=p_task_srl_no%>">
		<input type="hidden" name="primary_order_type" id="primary_order_type" value=""> <!-- Used for Primary Order Type OT Ordercategory -->
		<input type="hidden" name="rd_install_yn" id="rd_install_yn" value="">
		<input type="hidden" name="ot_install_yn" id="ot_install_yn" value="">

		<input type="hidden" name="sex" id="sex" value="<%=bean.getSex()%>">
		<input type="hidden" name="dob" id="dob" value="<%=bean.getDob()%>">
		<input type="hidden" name="session_id" id="session_id" value="<%=session_id%>">
		<input type="hidden" name="care_set_catalog_code" id="care_set_catalog_code" value="<%=order_catalog_code%>">
		<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
			 <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->
		<input type="hidden" name="cosign_reqd_yn" id="cosign_reqd_yn" value=""> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn='Y' when nurse is logging in -->
		<%if(passed_from.equalsIgnoreCase("Rapid Preview"))
		{
		%>
			<input type="hidden" name="function_name" id="function_name" value="PREVIEW"> <!-- For Order Format Line Level -->
			<input type="hidden" name="record_from" id="record_from" value="PREVIEW">
		<%
		}
		else
		{
		%>
			<input type="hidden" name="function_name" id="function_name" value="ORDER_SET"> <!-- For Order Format Line Level -->
			<input type="hidden" name="record_from" id="record_from" value="ORDER_SET">
		<%
		}
		%>
	<%	
	
	%>	
		<input type="hidden" name="validated_status" id="validated_status" value="validation_reqd">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
		<input type="hidden" name="email_yn" id="email_yn" value="N"><!-- For Email -->
		<input type="hidden" name="appl_user_name" id="appl_user_name" value="<%=appl_user_name%>"> 
		 <!-- For Order Set Billing Added by Uma 2/6/2009 -->
		<input type="hidden" name="order_set_bill_yn" id="order_set_bill_yn" value="<%=order_set_bill_yn%>">
		<input type="hidden" name="charge_yn" id="charge_yn" value="<%=charge_yn%>">
		<input type="hidden" name="care_set_catalog_desc" id="care_set_catalog_desc" value="<%=care_set_catalog_desc%>">
		<input type="hidden" name="checkCount" id="checkCount" value="">
		<!-- Added by Uma on 3/13/2010 for IN019490 -->
		<input type="hidden" name="ref_facility_id" id="ref_facility_id" value="<%=ref_facility_id%>"><!--External Orders-->
		<input type="hidden" name="ref_date_time" id="ref_date_time" value="<%=ref_date_time%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_pract_id" id="ref_sent_pract_id" value="<%=ref_sent_pract_id%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_remarks" id="ref_sent_remarks" value="<%=ref_sent_remarks%>"><!--External Orders-->
		<!-- Ends Here by Uma on 3/13/2010 for IN019490 -->
		<input type="hidden" name="show_bill_info_yn" id="show_bill_info_yn" value="<%=show_bill_info_yn%>"> <!-- added for IN035929[IN040092] -->
		<input type="hidden" name="twicedupchkflg" id="twicedupchkflg" value="<%=dupchk_siteSpecFlag%>"> <!-- IN062607 -->
		<input type="hidden" name="pract_type" id="pract_type" value="<%=practitioner_type%>"><!--IN065942-->
		<input type="hidden" name="orset_ind_flag" id="orset_ind_flag" value="<%=orset_ind_flag%>"><!--IN067246-->
		<input type="hidden" name="called_function" id="called_function" value="<%=called_function%>"><!--IN067246-->
		
		<input type="hidden" name="call_function" id="call_function" value="ORSET"><!--IN066377-->  
		<input type="hidden" name="bt_order_type_code" id="bt_order_type_code" value="<%=bt_order_type_code%>"><!--IN066377-->
		<input type="hidden" name="interactionDrugsCnt" id="interactionDrugsCnt"  id ="interactionDrugsCnt" value="<%=drugintercnt %>" />	<!-- IN071260 -->
<%		
		// Nullifying the Objects
		previousValues			= null;		// Nullifying the Objects
		PlaceOrdercareSetCount	= null;  PlaceOrderSetItems 	= null;
		PlaceOrderItems 		= null;  drugclass				= null;
		Default					= null;	 PlaceOrderType			= null; 
		PlaceOrderFrequency		= null;	
		stFormat				= null;	 secondaryOrders		= null;
		


		// set it back persistence
		putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
	</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
 		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
 		   	<tr>
 		 		<td width='100%' id='t'></td>
 			</tr>
 		</table>
	</div>
</body>
	<script>
	skipAuthIndicator();//IN048467
	if(parent.legendsFrame)
	{
		if(parent.legendsFrame.document.getElementById("titleTab")!=null) {
			alignWidth();
		}
	}
	else
	{
		alignPreviewWidth();
	}
	<!-- added for IN035929[IN040092] -->
	var show_bill_info_yn = document.placeOrderForm.show_bill_info_yn.value; 
	if(show_bill_info_yn=='Y') {
		showBillingTable();
	}	
	<!-- END for IN035929[IN040092] -->
	
	</script>
	<script>
		chkCount();
	</script>
</html>

