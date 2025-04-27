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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
10/08/2011    28198         Menaka      	Incident No: 28198 - <System not allows amending start date of 
												Radiology Order When Schedule Applicable= Unchecking.> 
23/09/2011	  28806			Menaka			Incident No: 28806 - <Radiology order-> setup schedule 
												applicable=Checked , it can?t change start date by click on ?Start date? header and can?t click on ?calendar icon? but user can change start date by typing new date and time on that field.>		 
06/09/2011    IN31901       NijithaS    	Incident No: IN31901 - Bru-HIMS-CRF-263		                                         		 
14/09/2012    IN035095		vijayakumark 	default performing location  should be login facility
25/09/2012	  IN030279		Ramesh G		Bru-HIMS-CRF-160 								 
03/04/2013    IN035929 		Karthi L		    When user Place in OR/CA, user should not see Service charges. 							 
08/05/2013    IN039607 		Karthi L		    Charges are not posted in Billing Module if ?Display Billing Information? is Unchecked in OR Parameter for Facility .
07/06/2013    IN040531		Nijitha S		    ALPHA- OR- Getting Script Error while "Amend" the Placed Orders.
22/07/2013    IN041421      Chowminya G         Special characters -record consent "Internal Server Error"	
13/08/2013	  IN042045		Chowminya G	    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
23/09/2013    IN043099		Nijitha 		CRF-OT-Bru-Hims-CRF-004.2/03-Booking Priority field is not displayed when Surgery type is amended
06/01/2014	  IN044014		Chowminya		System is not defaulting the Department if users selecting the performing location
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
24/02/2014	  IN046975		Chowminya	25/02/2014		Ramesh G			System display 1st order quantity as 2 units but display total charge as 1 unit
01/03/2014	  IN047469		Chowminya   05/03/2014		Ramesh G			Amend Orders splitting issue and performing location in multifacility scenario issue
14/03/2014    IN041644		Nijitha S		 								Prescription - Authorization of Drugs â?? Based on Rules.
18/03/2014	  IN047739		Chowminya										Perform location code wrong in Amend
02/07/2014	  IN048467 		Nijitha S										HSA-CRF-0150
03/07/2014    IN049984		Chowminya										performing loc setup for catalog done but it is not appear during transaction	
26/08/2014    IN050607		Nijitha S										KDAH-SCF-0255	
16/06/2016	  IN029076      Raja S											Start Date becomes blank after refreshing the order screen
09/06/2017	  IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]	
03/07/2017	  IN062607		Raja S		03/07/2017		Ramesh G			ML-MMOH-CRF-0727
19/10/2017	  IN065324		Dinesh T										To display the price in OR screen and the billing status in Manage Specimen screen
15/12/2017	  IN065942		Dinesh T	15/12/2017		Ramesh G			In Nuclear medicine  department we required the barcode functionality at the time of 
08/02/2018	  IN066436		Raja S		08/02/2018		Ramesh G			SS-SCF-0777
17/07/2018	IN064543	Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776																			name of study.
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
24/08/2018	IN68475			Dinesh T		24/08/2018	Ramesh G			Amend an order which has comments in the order format window. 
																			The preview window is not showing the already recorded comments 
																			in the preview window which is invoked on press of Preview button on the right corner of the bottom of the screen
09/01/2019  	IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
06/02/2019	IN069674 		Kamalakannan G		06/02/2019		Ramesh G.		AMS-CRF-0139/03 
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
17/02/2020	IN071260	Nijitha S	17/02/2020	Ramesh G	MMS-KH-CRF-0029.3
17/03/2020	IN072683	Nijitha S	17/03/2020	Ramesh G	MMS-KH-CRF-0029.3
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
22/12/2020	10503		Nijitha S	22/12/2020	Ramesh G	ML-MMOH-CRF1229.4
15/03/2021  15911		Durga Natarajan		15/03/2021		RAMESH G		ALPHA-CA-Text Block Label Name 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eOR.Common.*, java.util.*,java.net.URLEncoder,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.sql.*,webbeans.eCommon.*"%><!--IN062607-->
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>-->
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- for Tool Tip-->
	<script>
		// Violation, but to make the alignment size same as the top frame...
		function alignWidth(order_set_bill_yn) 
		{
			//var last=eval(document.getElementById('detailTab').rows.length-2);
			var row=0;
			if(order_set_bill_yn=="Y")
			{
				row=1;
			}
			else
			{
				row=0;
			}
			parent.legendsFrame.document.getElementById('titleTab').width =	document.getElementById('detailTab').offsetWidth+'px';
			if(document.getElementById('detailTab')!=null&&document.getElementById('detailTab').rows[row]!=null) 
			{
					for( i=0;i<document.getElementById('detailTab').rows[row].cells.length;i++) 
					{   // Depending upon the first row
						//for(i=0;i<document.getElementById('detailTab').rows(last).cells.length;i++) {
						//var wid=document.getElementById('detailTab').rows(last).cells(i).offsetWidth;
						var wid=document.getElementById('detailTab').rows[row].cells[i].offsetWidth+'px';						
						var wid1= parent.legendsFrame.document.getElementById('titleTab').rows[0].cells[i].offsetWidth+'px';
						//	if(eval(wid1) < eval(wid)){
						if(parent.legendsFrame.document.getElementById('titleTab').rows[0].cells[i])
							parent.legendsFrame.document.getElementById('titleTab').rows[0].cells[i].style.width=wid;
						

					//	} else {
					//		document.getElementById('detailTab').rows(last).cells(i).width = wid1;
					//	}
					}
					
				}    
			}	

			function moveFrame()
			{
				var temp=document.body.scrollLeft;
				scrollValue=temp;

				if(parent.legendsFrame.location.href.indexOf(".jsp") != -1)
				{
					parent.legendsFrame.document.body.scrollLeft=temp;
				}
			}		
</script>
	<title><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></title>
</head>
<style TYPE="text/css"></style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="ClinicalComment();" onscroll='moveFrame()'>
<form name="placeOrderForm" id="placeOrderForm" >
<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String temptype="";
	String check="";
	String patient_email_id="";
	Object prepins				= "IS";
	String order_types_comb = "";
	ArrayList OrderFormatTypes = new ArrayList();
	int count = 0;
	ArrayList arrSeqNo1			= new ArrayList();
	String ind_catalog_code	= "", ind_row_value			= "";
	String[] order_type_records = null;
	int row_value=0;
	String order_type_code = "";
	String field_mnemonic	= "";
	int seq_num				= 0 , new_seq_num = 0;
	int old_seq_num			= 0;
	String old_field_mnemonic="";
	Hashtable template			= null;
	boolean exists			= false;
	String field_type		= "";
	String field_values		= "";
	String dflt_value		= "";
	String fac_selected		= "";//IN044014

	/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	int numbering = 0;
	int non_billing_numbering=0;//IN068314		
	String billinginterface="";
	String displaytooltip="";
	/* Ends Here*/
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	beanQueryObj.setLanguageId(localeName);

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";

	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	   bean1.setLanguageId(localeName);
	 String practitioner_id = (String)session.getValue("ca_practitioner_id");
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
	 String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	
	String data[] = null;
	//String data[]=bean.getEmailDataDetails((String)bean.getLoginFacilityId());Commented Email part as told by Rajan
	if(data!=null && data.length>0)
	{
		patient_email_id=bean.checkForNull(data[1],"");
	}	
	/* Initialize Function specific end */
	String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
   	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
   	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
	String forceStatus				= bean.getForceStatus(practitioner_type,order_category);
	String fStatus[]=forceStatus.split(":");
	String lb_instal_yn				= bean.checkForNull(request.getParameter("lb_instal_yn"),"N");
	String rd_instal_yn				= "N";
	//IN069657, starts
	/*if(order_category.equals("RD"))
  	rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
  	*/
	rd_instal_yn =  bean.getRDInstallYN();
	//IN069657, ends
	String session_id				= bean.checkForNull(request.getParameter("session_id"),"");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN030279 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN030279 End.
	//IN062607 Starts

	String l_patient_class = bean.checkForNull(request.getParameter("patient_class"),"");//IN065324
	String perfLocnMandFlag = "N";//IN066377
	String bt_order_type_code = "";//IN066377
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	//IN072654 Starts
	HashMap<String,String> tempMap = new HashMap<String,String>();
	HashMap<String, ArrayList<OrderDrugInteractionVO>> dtlsTemp = new HashMap<String, ArrayList<OrderDrugInteractionVO>>();
	bean.setDruginteractionYN(tempMap);
	bean.setDruginteractionDtl(dtlsTemp);
	//IN072654 Ends
	try
	{
		con				=	ConnectionManager.getConnection(request);
		dup_custSpecificFlg = CommonBean.isSiteSpecific(con, "OR","TWICE_DUPLICATE_ALERT");
		if(dup_custSpecificFlg)
			dupchk_siteSpecFlag ="Y";
	//IN066377 start
		String sql = "select * from OR_ORDER_PERF_LOCN_MAND where order_category=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,order_category);
		rs = pstmt.executeQuery();
		if(rs.next()){
			perfLocnMandFlag = bean.checkForNull(rs.getString(l_patient_class),"N");
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
	//IN066377 end
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	}
	//IN062607 Ends
	
	String p_start_date_time		= bean.checkForNull(request.getParameter("p_start_date_time"),"");
	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String called_from			= bean.checkForNull(request.getParameter("called_from"),"");
 	String classValue				= "", chk_class_value = "";
	String existing_bean_id			= "", existing_bean_name="";
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String ammend_start_date_time	= "";
	HashMap instructionsMap = new HashMap();
	
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	if(function_from.equals("EXTERNAL_ORDER")) 
	{ // Get the Bean Instance of External Orders
		existing_bean_id 			= "Or_ExternalOrders";
		existing_bean_name			= "eOR.ExternalOrdersBean";
		//external_bean_obj			= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj			= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		ref_facility_id				= bean.checkForNull(external_bean_obj.getFacilityId(),"");
		ref_date_time				= bean.checkForNull(external_bean_obj.getReferral_date(),"");
		ref_sent_pract_id			= bean.checkForNull(external_bean_obj.getPractitionerId(),"");
		ref_sent_remarks			= bean.checkForNull(external_bean_obj.getRemarks(),"");
		// Get the External Order Reference Values, to be inserted into the or_order table%>
	<%
	} // End of function-from
	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
	//java.util.Date date_time	 	= new java.util.Date();
	//String dateString 			= dtSystemFormat.format(date_time);

	String dateString				= bean.getSysDate();
	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
	ArrayList AmendPlaceOrderItems	= null;
	ArrayList AmendSchedule			= null;
	ArrayList AmendPlaceOrderFrequency= null;
	//ArrayList AmendPlaceOrderDuration= null;
	ArrayList AmendSpecimenNurse	 = null;
	if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
		AmendPlaceOrderItems		= bean.getAmendPlaceOrdersResult(bean.checkForNull(bean.getOrderId(),""));
	String specialty_code			= "";
	String auth_reqd				= "";
	//auth_reqd						= (String)bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	int i							= 0, amend_count		= 0, display_special_count   = 0;
	int display_auth_count			= 0, amend_format_count = 0, format_mandatory_count = 0;
	int drugintercnt = 0;//IN068314
	int format_count 		= 0, display_cosign_count   = 0;//age_in_days					= 0, 
	String preps_instrn 			= "", frequency_val		= "", qty_value				= "";
	String preps_dept_instrn		= "", duration_value	= "", qty_uom				= "",qty_uom_shortdesc				   = "";;
	String pat_preps_instrn			= "", max_durn_value	= "";
	String chk_for_max_durn_action = "";//sex_yn					= "",
	String format_id				= "", prompt_msg		= "";
	String format_id_mandatory_yn	= "", comments			= "";
	String amend_specimen_type		= "", amend_nurse_collect_yn = "N", amend_start_disabled = "";
	String amend_appt_reqd_yn		= "N",amend_routine_appt_reqd_yn="N";
	String amend_stat_appt_reqd_yn	= "N",amend_urgent_appt_reqd_yn ="N";
  	String order_id					= "", order_line_no			= "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;
	String[] amendRecords 			= null;
	//String[] peformingFacility		= null; 
	String[] AmendfrequencyRecords = null;

	String[] records				= null; //String[] amendDurationRecords  = null;
	String[] orderTypeRecords		= null; String[] frequencyRecords	   = null;
	//String[] durationRecords		= null; 
	String[] deptLocation		   = null;
	String[] performingLocation		   = null;
	String[] secondaryOrders		= new String[2];
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N", facility_name	= "";
	String sec_start_date_time		= "";
	String amend_billing_call_yn	= "N";
	ArrayList DeptLocationCode 		= null;
	ArrayList performingLocationCode= null;
	ArrayList PlaceOrderType		= null;
	ArrayList PlaceOrderFrequency	= null;
	StringTokenizer stFormatID		= null;
	HashMap copyOrderDetails		= null;

	HashMap bill_set_dtls				= null;
	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	HashMap ordersetBills_dtls			= null;
	String[] billing_details 		= null;
	String[] order_billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	String patientDischargedYn      = "N";
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); // added for IN035929
%>
<table width="100%" border="0" cellspacing="0" cellpadding="3" id="detailTab" class="grid">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<%
	String order_set_bill_yn = "N";
	String[] OrderSetValues = new String[9];
	String bill_orderId = "";
	String bill_order_line_num = "";
	String bill_dateString = "";
	String bill_order_catalog_code = "";
	String order_qty = "";
	String bill_order_category = "";
	String bill_order_set_desc = "";
	String charge_yn = "";
	String fpp_yn_set = "";//10503
	String fpp_category_set = "";//10503
	patientDischargedYn = (String)bean.getPatientDischarged();
	if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
	{
		bill_orderId=bean_qryobj.getOrderSetId(bean.checkForNull(bean.getOrderId(),""));
		if(bill_orderId==null) bill_orderId="";
		if(!bill_orderId.equals(""))
		{
			OrderSetValues=bean_qryobj.getOrderSetDetails(bill_orderId);
			bill_order_line_num=bean.checkForNull(OrderSetValues[1],"");
			bill_dateString=bean.checkForNull(OrderSetValues[2],"");
			bill_order_catalog_code=OrderSetValues[3];
			order_qty=bean.checkForNull(OrderSetValues[4],"");
			order_set_bill_yn=bean.checkForNull(OrderSetValues[5],"");
			bill_order_category=bean.checkForNull(OrderSetValues[6],"");
			bill_order_set_desc=bean.checkForNull(OrderSetValues[7],"");
			charge_yn=bean.checkForNull(OrderSetValues[8],"");
			fpp_yn_set=bean.checkForNull(OrderSetValues[9],"");//10503
			fpp_category_set=bean.checkForNull(OrderSetValues[10],"");//10503
			//if(charge_yn.equalsIgnoreCase("N"))
			//{
				//order_set_bill_yn = "N";
			//}
		}
	}
	
	boolean show_order_set_bt_bill_dtls = false;//IN065324

	//IN065324, starts
	if(is_bt_view_bill_dtls && "BT".equals(bill_order_category) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)))
	{
		show_order_set_bt_bill_dtls = true;
	}
	else if("Y".equals(fpp_yn_set)){//10503 Starts
		show_order_set_bt_bill_dtls = true;
	}//10503 Ends
	else
	{
		show_order_set_bt_bill_dtls = false;
	}
	//IN065324, ends
	
	//if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !bill_order_category.equals("BT"))//IN065324
	if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && show_order_set_bt_bill_dtls)//IN065324
	{
		numbering = 0;
		//10503 Starts
		//BillChargeInfo		= bean_qryobj.getBillChargeDetails(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		if("Y".equals(fpp_yn_set))
		{
			BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),fpp_yn_set,fpp_category_set) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			
		}
		else{
			BillChargeInfo		= bean_qryobj.getBillChargeDetails(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		//10503 Ends
		if(BillChargeInfo==null) 
			BillChargeInfo= new ArrayList();
		order_billing_details = null;
		for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
		{
			order_billing_details 	= (String[])BillChargeInfo.get(m);
			ordersetBills_dtls		= new HashMap();
			ordersetBills_dtls.put("charged_yn"       , order_billing_details[1]);
			ordersetBills_dtls.put("total_payable"    , order_billing_details[2]);
			ordersetBills_dtls.put("patient_payable"  , order_billing_details[3]);
			ordersetBills_dtls.put("quantity"         ,order_qty);
			ordersetBills_dtls.put("incl_excl_action" , order_billing_details[4]);
			ordersetBills_dtls.put("incl_excl_action_orginal" , order_billing_details[16]);
			ordersetBills_dtls.put("preapp_yn"        , order_billing_details[5]);
			ordersetBills_dtls.put("patient_paid_amt" , order_billing_details[6]);
			ordersetBills_dtls.put("bl_panel_str"     , order_billing_details[0]);
			ordersetBills_dtls.put("serv_panel_ind"   , order_billing_details[10]);
			ordersetBills_dtls.put("serv_panel_code"  , order_billing_details[11]);
			ordersetBills_dtls.put("p_episode_type"	 , order_billing_details[13]);
			ordersetBills_dtls.put("p_episode_id"	 , order_billing_details[14]);
			ordersetBills_dtls.put("p_visit_id"		 , order_billing_details[15]);
			ordersetBills_dtls.put("Future_order_yn"		 , order_billing_details[17]);
			ordersetBills_dtls.put("rate"		 , "");
			ordersetBills_dtls.put("excl_incl_ind_for_screen"		 , order_billing_details[4]);
			ordersetBills_dtls.put("mod_physician_id"		 , order_billing_details[20]);
			ordersetBills_dtls.put("fpp_yn"		 , fpp_yn_set);//10503
			ordersetBills_dtls.put("fpp_category"		 , fpp_category_set);//10503
			//servicepanel=bean.checkForNull(billing_details[10],"");
			//servicepanelcode=bean.checkForNull(billing_details[11],"");
			orderEntryBillBean.setOrderBillDtls(bill_orderId+OrderSetValues[1],ordersetBills_dtls); 
			 if(!order_billing_details[9].equals(""))
			{
				numbering=1;
			%> 
			<script>alert("<%=order_billing_details[9]%>");</script>
			<% 
			}
			if(order_billing_details[10].equals("")||order_billing_details[11].equals(""))
			{
						numbering=1;
			%>
			<script>
					var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
					msg=msg.replace('{1}',"<%=bill_order_catalog_code%>");
					alert(msg);
			</script>
			<% 
				}
			}
			if(numbering==1&& order_set_bill_yn.equalsIgnoreCase("Y"))
			{	
			%>
			<script>
					parent.criteriaDetailFrame.document.getElementById('recordApply').disabled=true;
			</script>
			<%
			}
			bill_set_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bill_orderId+OrderSetValues[1]);
	%>
					<tr>
					
					<td class="<%=classValue%>"></td><td class="<%=classValue%>"></td><td class="<%=classValue%>"></td><td colspan="6" class="<%=classValue%>">
					<table cellpadding=0 cellspacing=0 border=0 width='100%' align='right' style='border-width:0' class="grid">
				
						
					<tr >
						<!--10503 Starts-->
						<%
							if("Y".equals(fpp_yn_set))
							{	
							%>
							
							<input type="hidden" name="fpp_yn<%=count %>" id="fpp_yn<%=count %>"  value="<%=fpp_yn_set%>" >
							<td rowspan="2" width='20%' class="<%=classValue%>" style='border-width:0;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${common_labels}"/>:</B></font>
						
								<select name="fpp_category<%=count %>" id="fpp_category<%=count %>"  disabled onchange="reviseBillingchrgs('<%=count %>','ORDER_SET_AMEND')" >
									<option value="S" <%="S".equals(fpp_category_set)?"selected":""%> ><fmt:message key="eOR.Simple.label" bundle="${common_labels}"/></option>
									<option value="M" <%="M".equals(fpp_category_set)?"selected":""%> ><fmt:message key="eOR.Medium.label" bundle="${common_labels}"/></option>
									<option value="C" <%="C".equals(fpp_category_set)?"selected":""%> ><fmt:message key="eOR.Complex.label" bundle="${common_labels}"/></option>
								</select>
							
							</td>
							
							<%}%>
							<!--10503 Ends-->
						<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
						<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
						<%
						if(bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='25%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
						<%
						}
						%>
					</tr>
					<tr>
						<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_set_dtls.get("total_payable"),"0.0")%></span></font></td>
						<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_set_dtls.get("patient_payable"),"0.0")%></span></font></td>
						<%
						if(bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_set_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_set_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")%></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=bill_order_catalog_code%>'><%=bean.checkForNull((String)bill_set_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_set_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font>
							</td>
						<%
						}
						%>
						<td colspan="" id='ordersetlevel'  class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><!-- //10503  -->
						<a class="gridLink"  href="javascript:callReviseBilling('1','ORDER_SET_AMEND','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_set_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_set_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_set_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_set_dtls.get("p_visit_id"),"")%>','<%=bean.checkForNull(bill_orderId,"")%>','<%=bean.checkForNull((String)bill_order_line_num,"")%>')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> <!--View / Edit--></a>
						</td>
					</tr>
				</table></td></tr>
		<input type="hidden" name="bill_dateString" id="bill_dateString" value="<%=bill_dateString%>">
		<input type="hidden" name="order_set_catalog_code" id="order_set_catalog_code" value="<%=bill_order_catalog_code%>">
		<input type="hidden" name="order_qty" id="order_qty" value="<%=order_qty%>">
		<input type="hidden" name="order_set_orderid" id="order_set_orderid" value="<%=bean.checkForNull(bill_orderId,"")%>"><!-- //10503  -->
		<input type="hidden" name="order_set_orderlineno" id="order_set_orderlineno" value="<%=bean.checkForNull((String)bill_order_line_num,"")%>"><!-- //10503  -->
	<%
	}

	// Amend/Review Order Painting Here
	if(AmendPlaceOrderItems!=null)
	{
		for(amend_count=0; amend_count<AmendPlaceOrderItems.size(); amend_count++)
		{	
			//String comment 			 =  "";
			//String pat_preps_pat_instrns="";
			//String pat_preps_dep_instrns="";
			//String pat_preps_instrns="";  
			amendRecords			= (String[])AmendPlaceOrderItems.get(amend_count);
			
			classValue="gridData";
			chk_class_value="gridData";
			String amend_speciality_code[]=new String[3];
			ArrayList amend_speciality=new ArrayList();
			amend_speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),amendRecords[2],bean.getEncounterId(),bean.getLoginFacilityId(),amendRecords[4],specialty_code,auth_reqd);
			if(amend_speciality.size()>0)
			{
				for(int as=0;as<amend_speciality.size();as++)
				{
						amend_speciality_code=(String[])amend_speciality.get(as);
				}
			}
			if(amend_speciality_code[0].equalsIgnoreCase("Y"))
			{
				if(amendRecords[7].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")||amend_speciality_code[0].equalsIgnoreCase("Y"))
					amendRecords[7]="Y";
			}
			else
			{
				if(amendRecords[7].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y"))
					amendRecords[7]="Y";
			}
			
			if(fStatus[1].equalsIgnoreCase("Y"))
			amendRecords[9]=fStatus[1];

			if(amendRecords[22].equalsIgnoreCase("Y")) // consent_reqd_yn
				chk_class_value = "eORConsent" ;

			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			Default = bean.getPlaceOrderDefault(amendRecords[2]);
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
			}		
			// Till Here
			amend_start_disabled		= "";
			amend_appt_reqd_yn			= amendRecords[48];	amend_routine_appt_reqd_yn	= amendRecords[56];
			amend_stat_appt_reqd_yn		= amendRecords[57];	amend_urgent_appt_reqd_yn	= amendRecords[58];
			if(amend_appt_reqd_yn.equals("Y")) 
			{	// If appt_reqd_yn is "Y"
				if(!amendRecords[54].equals("") && !amendRecords[55].equals("")) 
				{ // if already appt has been booked, 
					amend_start_disabled	= "DISABLED";
					amend_appt_reqd_yn		= "N"; amend_routine_appt_reqd_yn="N";
					amend_stat_appt_reqd_yn	= "N"; amend_urgent_appt_reqd_yn ="N";
 				} else 
				{
					amend_start_disabled = "";
				}
			}
			ammend_start_date_time = amendRecords[10];
%>
			<tr>
				<td width="2%"  class="<%=chk_class_value%>"><input type="checkbox" name="ck<%=amendRecords[2]%>" id="ck<%=amendRecords[2]%>" value="Y" checked onClick="setCheckValue(this)" DISABLED><input type="hidden" name="h1<%=amendRecords[2]%>" id="h1<%=amendRecords[2]%>" value="<%=amendRecords[4]%>"><input type="hidden" name="h2<%=amendRecords[2]%>" id="h2<%=amendRecords[2]%>" value="<%=amendRecords[3]%>"></td>
				
				<!--28198 Modified Starts-->
				<td width="12%" class="<%=classValue%>">
				<!--28806 Modified by Menaka-->
					<input type="text" name="amend_start_date_time<%=amend_count%>" id="amend_start_date_time<%=amend_count%>"	  value='<%=bean.getTempvalue("amend_start_date_time"+amendRecords[2])==null?com.ehis.util.DateUtils.convertDate
					(amendRecords[10],"DMYHM","en",localeName):bean.getTempvalue("amend_start_date_time"+amendRecords[2])%>'
					size="14" maxLength="16" <%=amend_start_disabled%> <%=order_category.equals("RD")?(amend_appt_reqd_yn.equalsIgnoreCase("Y")?"readonly":""):"" %> 
					onBlur="checkAmendStartDateTime(this,<%=amend_count%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>','amend_start_date_time<%=amendRecords[2]%>','<%=amendRecords[2]%>','','<%=bean.getLoginFacilityId()%>','<%=order_category%>','<%=amend_appt_reqd_yn%>');"><img src="../../eCommon/images/CommonCalendar.gif"  <%=amend_start_disabled%> onClick="return showCalendarValidate('amend_start_date_time<%=amend_count%>',null,'hh:mm','amend_start_date_time<%=amend_count%>','<%=amendRecords[2]%>');" style='cursor:pointer' <%= order_category.equals("RD")?(amend_appt_reqd_yn.equalsIgnoreCase("Y")?"disabled":""):"" %>><input type="hidden" name="old_amend_start_date_time<%=amend_count%>" id="old_amend_start_date_time<%=amend_count%>" value='<%=com.ehis.util.DateUtils.convertDate(amendRecords[10],"DMYHM","en",localeName)%>'>
					</td>
				<!--28198 Modified Ends-->
				
				<input type="hidden" name="amend_catalog_code<%=amend_count%>" id="amend_catalog_code<%=amend_count%>" value="<%=amendRecords[2]%>">
				<td width="18%" class="<%=classValue%>" onMouseOver='showToolTip("<%=amendRecords[2]%>","placeOrderForm")' onMouseOut="hideToolTip()"><font size="1">
					<%=amendRecords[24]%>
<%
				if(!bean.checkForNull(amendRecords[64],"").equals("")) {
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		
%>
				<input type="hidden" name="amend_cat_desc<%=amend_count%>" id="amend_cat_desc<%=amend_count%>" value="<%=amendRecords[24]%>">
				</td>
				<td width="12%" class="<%=classValue%>">
					<input type="text" name="amend_order_type_desc<%=amend_count%>" id="amend_order_type_desc<%=amend_count%>" value="<%=amendRecords[26]%>" size="14" maxLength="15" READONLY> 
					<input type="hidden" name="amend_order_type<%=amend_count%>" id="amend_order_type<%=amend_count%>" value="<%=amendRecords[3]%>">
				</td>
				<td width="6%" class="<%=classValue%>">
					<% if(amendRecords[6].equalsIgnoreCase("R")) out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+""); else if(amendRecords[6].equalsIgnoreCase("U")) out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+""); else out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+""); %>
					<input type="hidden" name="amend_priority<%=amend_count%>" id="amend_priority<%=amend_count%>" value="<%=amendRecords[6]%>">
				</td>
				<td width="5%" class="<%=classValue%>"><input type="text" style="text-align:'right'" name="amend_quantity<%=amend_count%>" id="amend_quantity<%=amend_count%>" value="<%=bean.getTempvalue("amend_quantity"+amendRecords[2])==null?amendRecords[18]:bean.getTempvalue("amend_quantity"+amendRecords[2])%>" size="2" maxLength="6" onKeyPress="return(ChkNumberInput(this,event,'2'))"  onBlur="checkValidNumber('amend_quantity<%=amendRecords[2]%>',this);reviseBillingchrgs('<%=i%>','AMEND_ORDER')" <%if(amendRecords[34].equalsIgnoreCase("N")) out.println("READONLY");%>>&nbsp;<%=amendRecords[73]%></td>
				<%	//IN046975 - Added to set the quantity value to the tempvalue for the correct charge calculation while navigating between place order n additional search tab
				if(!amendRecords[18].equals(bean.getTempvalue("amend_quantity"+amendRecords[2])) && bean.getTempvalue("amend_quantity"+amendRecords[2]) != null)
					amendRecords[18] = bean.getTempvalue("amend_quantity"+amendRecords[2]);
				//IN046975	
				%>
				<td width="17%" class="<%=classValue%>">
				<%
				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				%>
					<select name="amend_frequency_code<%=amend_count%>" id="amend_frequency_code<%=amend_count%>" onChange="setAmendFrequency(this,<%=amend_count%>,'<%=amendRecords[2]%>','<%=bean.getLoginFacilityId()%>','onChange')" <%= order_category.equals("RD")?"disabled":"" %>>
					<option value="" <%=bean.getTempvalue("amend_frequency_code"+amendRecords[2])==null?"":bean.getTempvalue("amend_frequency_code"+amendRecords[2]).equals("")?"selected":""%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						AmendPlaceOrderFrequency = bean.getPlaceOrderFrequency(amendRecords[2],"","","","",""); // Pass Order_category and Catalog_code

					if(bean.getTempvalue("amend_frequency_code"+amendRecords[2])!=null)
						for(int j=0; j<AmendPlaceOrderFrequency.size(); j++)
						{
							
							AmendfrequencyRecords = (String[]) AmendPlaceOrderFrequency.get(j);
							if(amendRecords[13].equalsIgnoreCase(AmendfrequencyRecords[2])  ||  bean.getTempvalue("amend_frequency_code"+amendRecords[2]).equals(AmendfrequencyRecords[0]))
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\" SELECTED> "+AmendfrequencyRecords[1]+" </option>");
							else
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\"> "+AmendfrequencyRecords[1]+" </option>");
						}
						else
							for(int j=0; j<AmendPlaceOrderFrequency.size(); j++)
						{
							
							AmendfrequencyRecords = (String[]) AmendPlaceOrderFrequency.get(j);
							if(amendRecords[13].equalsIgnoreCase(AmendfrequencyRecords[2]))
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\" SELECTED> "+AmendfrequencyRecords[1]+" </option>");
							else
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\"> "+AmendfrequencyRecords[1]+" </option>");
						}
					%>
					</select>
					<input type="hidden" name="amend_frequency_val<%=amend_count%>" id="amend_frequency_val<%=amend_count%>" value="<%=amendRecords[13]%>" >
					<input type="hidden" name="old_amend_frequency_val<%=amend_count%>" id="old_amend_frequency_val<%=amend_count%>" value="<%=amendRecords[13]%>" >
					<%
					if(AmendSchedule!=null && AmendSchedule.size() > 0)
					{
					%>
					
						<input type="hidden" name="amend_schedule_yn<%=amend_count%>" id="amend_schedule_yn<%=amend_count%>" value="Y" >
						<input type="hidden" name="amend_schedule_mandatorily_yn<%=amend_count%>" id="amend_schedule_mandatorily_yn<%=amend_count%>" value="Y" >
					<%
					}
					else
					{
						%>
					
						<input type="hidden" name="amend_schedule_yn<%=amend_count%>" id="amend_schedule_yn<%=amend_count%>" value="N" >
						<input type="hidden" name="amend_schedule_mandatorily_yn<%=amend_count%>" id="amend_schedule_mandatorily_yn<%=amend_count%>" value="N" >
					<%
					}
				}
				else
				{
				%>
					<select name="amend_frequency_code<%=amend_count%>" id="amend_frequency_code<%=amend_count%>" disabled>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					</select>
					<input type="hidden" name="amend_schedule_yn<%=amend_count%>" id="amend_schedule_yn<%=amend_count%>" value="N" >
					<input type="hidden" name="amend_schedule_mandatorily_yn<%=amend_count%>" id="amend_schedule_mandatorily_yn<%=amend_count%>" value="N" >
					<input type="hidden" name="amend_frequency_val<%=amend_count%>" id="amend_frequency_val<%=amend_count%>" value="" >
					<input type="hidden" name="old_amend_frequency_val<%=amend_count%>" id="old_amend_frequency_val<%=amend_count%>" value="" >
				<%
				}
				%>
				</td>
				<td width="4%" class="<%=classValue%>">
					<input type="text" class="NUMBER" name="amend_duration_value<%=amend_count%>" id="amend_duration_value<%=amend_count%>" value="<%=bean.getTempvalue("amend_duration_value"+amendRecords[2])==null?amendRecords[14]:bean.getTempvalue("amend_duration_value"+amendRecords[2])%>" size="2" maxLength="3" <%= order_category.equals("RD")?"readonly":"" %> onKeyPress="return(ChkNumberInput(this,event,'0'))" <%if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");%> onBlur='callamend_duration_value("amend_duration_value<%=amendRecords[2]%>",this)'>
					<input type="hidden" nowrap name="amend_end_date_time<%=amend_count%>" id="amend_end_date_time<%=amend_count%>" value="<%=amendRecords[17]%>" size="13" maxLength="16">
				</td>
				<td width="11%" class="<%=classValue%>">
					<select name="amend_duration_code<%=amend_count%>" id="amend_duration_code<%=amend_count%>"  DISABLED>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						/*AmendPlaceOrderDuration = bean.getPlaceOrderDuration();
						for(int j=0; j<AmendPlaceOrderDuration.size(); j++)
						{
							amendDurationRecords = (String[]) AmendPlaceOrderDuration.get(j);
							if(amendRecords[15].equalsIgnoreCase(amendDurationRecords[0]))
								out.println("<option value=\""+amendDurationRecords[0]+"\" SELECTED> "+amendDurationRecords[1]+" </option>");
							else
								out.println("<option value=\""+amendDurationRecords[0]+"\"> "+amendDurationRecords[1]+" </option>");
						}*/
					%>
					</select>
					<input type="hidden" name="amend_duration<%=amend_count%>" id="amend_duration<%=amend_count%>" value="<%=amendRecords[15]%>">
				</td>
			</tr>
<%
		amend_format_count = bean.getFormatAmendCount(bean.getOrderId(),amendRecords[1]);
		//if(amend_format_count==0)//Commented for IN043099
		//{//Commented for IN043099
			format_id = bean.checkForNull(amendRecords[29],"");
			if(!amendRecords[29].trim().equals(""))
			{
     			stFormatID 	= new StringTokenizer(amendRecords[29],"~");
     			while(stFormatID.hasMoreTokens())
     			{
     				format_id_mandatory_yn  = stFormatID.nextToken();
     				format_id 				= stFormatID.nextToken();
     			}
				stFormatID	= null; //Nullifying the objects
 			}
 		//}//Commented for IN043099
		//IN066436 starts
		String format_id_line = bean.checkForNull(amendRecords[29],"");
		if(!amendRecords[29].trim().equals(""))
		{
			stFormatID 	= new StringTokenizer(amendRecords[29],"~");
			while(stFormatID.hasMoreTokens())
			{
				format_id_mandatory_yn  = stFormatID.nextToken();
				format_id_line			= stFormatID.nextToken();
			}
			stFormatID	= null; //Nullifying the objects
		}
		//IN066436 ends
%>
		<input type="hidden" name="amend_format_id<%=amend_count%>" id="amend_format_id<%=amend_count%>" value="<%=format_id_line%>"><!--IN066436-->
		<tr>
				<td class="<%=classValue%>" ><font size="1">
					<input type="hidden" name="amend_format_id_val<%=amend_count%>" id="amend_format_id_val<%=amend_count%>" value="<%=format_id%>">
					<input type="hidden" name="amend_format_id_yn<%=amend_count%>" id="amend_format_id_yn<%=amend_count%>" value="Y">
    <%    //  This added For MultipleConsent
	          if(amendRecords[22].equalsIgnoreCase("Y"))
			 {
			 %>
				<input class="button" type="button" name="amend_consent_id_lookup<%=amend_count%>" id="amend_consent_id_lookup<%=amend_count%>"  title='Consent Required' value="C" onClick="callMultipleConsent('<%=amendRecords[2]%>','<%=URLEncoder.encode(amendRecords[24],"UTF-8")%>','<%=amendRecords[0]%>','<%=amendRecords[1]%>','<%=order_category%>','<%=amend_count%>')"> <!-- IN041421 -->
				<!-- <IMG id='amend_consent_id_lookup<%=i%>' style='cursor:pointer' SRC="../images/consentJ.JPG" WIDTH="25" HEIGHT="16" BORDER=0 ALT="Consent Required" onClick="callMultipleConsent('<%=amendRecords[2]%>','<%=amendRecords[24]%>','<%=amendRecords[0]%>','<%=amendRecords[1]%>','<%=order_category%>','<%=i%>')"> -->   
			<%	
	 			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
			 	ArrayList amendMultiConsentList = new ArrayList();
				String[] amendMultiConsentValues = null;
				String[] amendMultiConsentDtls = null;
				String consent_req_bef_order = "0"; 
				String consent_req_bef_regn = "0";
				String amendMultiConsentLine[] = new String[4];
				amendMultiConsentLine=bean1.MultiListConsentsLine(bean.checkForNull(bean.getOrderId(),""),amendRecords[1]);
				consent_req_bef_order = (String) amendMultiConsentLine[2];
				consent_req_bef_regn = (String)amendMultiConsentLine[3];
				amendMultiConsentDtls		= bean1.MultiListDtls(amendRecords[2],practitioner_id);
				amendMultiConsentList		= bean1.MultiListConsentsdtl(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1], practitioner_id);
				if(amendMultiConsentList==null || amendMultiConsentList.size()==0)
				{
					amendMultiConsentList		= bean1.MultiListConsents(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1],practitioner_id);
				}
				int amend_total_recs = 0;				
				if(amendMultiConsentDtls != null)
				{	
					if(amendMultiConsentList.size() > 0 && amendMultiConsentDtls.length > 0 && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn)) > 1 ) ))
					{		
						for(int m=0;m<amendMultiConsentList.size();m++)
						{
							amendMultiConsentValues = (String[])amendMultiConsentList.get(m);
							if(amendMultiConsentValues[6].equals("F"))
							{
								%>
								<input type='hidden' value="Y" name="amend_consent_chk<%=amend_count%><%=m%>" id="amend_consent_chk<%=amend_count%><%=m%>">
								<input type='hidden' value="<%=amendMultiConsentValues[1]%>" name="amend_consent_form_id<%=amend_count%><%=m%>">
								<input type='hidden' value="<%=amendMultiConsentValues[3]%>" name="amend_consent_stages<%=amend_count%><%=m%>">
							<%
							}
							amend_total_recs++;
						}						
						%>
						<Input type='hidden' name="amend_consent_form_list<%=amend_count%>" id="amend_consent_form_list<%=amend_count%>" value="<%=amendMultiConsentValues[6]%>">
						<Input type='hidden' name="amend_total_recs<%=amend_count%>" id="amend_total_recs<%=amend_count%>" value="<%=amend_total_recs%>">
					<%
					}
					else
					{
						if(amendMultiConsentList.size()==1)
						{
							amendMultiConsentValues = (String[])amendMultiConsentList.get(0);
							if(amendMultiConsentValues[6].equals("F"))
							{
								if(!(bean.checkForNull(amendMultiConsentValues[1])).equals(""))
								{
									amend_total_recs = amend_total_recs++;
								}
							//if(amendMultiConsentDtls[0].equals("F"))
							//{
							%>							
								<input type="hidden" value='<%=amendMultiConsentDtls[4].equals("Release")?"A":(amendMultiConsentDtls[4].equals("Registration")?"R":"")%>' name="amend_consent_stages<%=amend_count%>0">		
								<input type="hidden" value='Y' name="amend_consent_chk<%=amend_count%>0" id="amend_consent_chk<%=amend_count%>0">
								<!-- <input type='hidden' value="<%=amendMultiConsentDtls[3]%>" name="amend_consent_form_id<%=amend_count%>0">	 -->
								<input type='hidden' value="<%=amendMultiConsentValues[1]%>" name="amend_consent_form_id<%=amend_count%>0">
						<%
						}
					}
						%>
							<Input type='hidden' name="amend_consent_form_list<%=amend_count%>" id="amend_consent_form_list<%=amend_count%>" value="<%=amendMultiConsentDtls[0]%>">
							<Input type='hidden' name="amend_total_recs<%=amend_count%>" id="amend_total_recs<%=amend_count%>" value="<%=amend_total_recs%>">						
					<%
					//}
				}
			}
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/    
   /*upto here	MultipleConsent	*/	
				%>
				<Input type='hidden' name="amend_MultiConsentList<%=amend_count%>" id="amend_MultiConsentList<%=amend_count%>" value="<%=amend_total_recs%>">
			 <%
			}
			 secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, amendRecords[2], bean.getPatientClass()); //Pass the catalog_code and patient_class
			// secondayOrders will have to 2 values , count and the sec_order_catalog_type
			if (bean.checkForNull((String)secondaryOrders[0]).equals("Y"))
			{
				sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, amendRecords[2],amendRecords[6],bean.getPatientClass()),"");
				sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);	
			%>
                <Script>
				if(document.getElementById('start_date_time')<%=amend_count%>)
	                document.getElementById('start_date_time')<%=amend_count%>.value = '<%=sec_start_date_time%>';
                </Script>
                 <a class="gridLink" href="javascript:viewSecondaryOrders('<%=amend_count%>','<%=bean.getPatientClass()%>')"> <img src='../../eOR/images/SecondaryOrder.gif' border='0'  title='Secondary Orders Exists'></img>&nbsp;</a>
            <%
			}
			%>
				<input type="hidden" name="amend_sec_tasks_type<%=amend_count%>" id="amend_sec_tasks_type<%=amend_count%>" value="<%=secondaryOrders[1]%>"> <!--Keep the Seconday order catalog_type -->
				</td>
				<td class="<%=classValue%>"><label class="<%=classValue%>"  id="amend_schedule<%=amend_count%>" Title="Schedule">&nbsp;
				<%
				// If Schedule Frequency is there, retrieve the values and store it in the bean
				bean.setAmendScheduleFrequency(amendRecords[0],amendRecords[1],amendRecords[2],amend_count);
				AmendSchedule = bean.getScheduleFrequencyStr("AmendSchedule"+amendRecords[2],String.valueOf(amend_count));
				if(AmendSchedule!=null && AmendSchedule.size() > 0)
				{
				%>
					<a class='gridLink' href=javascript:AmendDisplaySchedule("AmendSchedule<%=amendRecords[2]%>","<%=amend_count%>","<%=bean.getLoginFacilityId()%>")  title='Schedule Frequency'><font size='1'><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></font></a>
				<%
				}
				%>
				</label>
				</td>
				<td class="<%=classValue%>" align="left" colspan='2' nowrap><font size="1">
				<%		
//if( (order_category.equals("LB") && lb_instal_yn.equals("Y")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC")) )	changed on 7/9/2007 for lb_instal_yn by uma 
						if((order_category.equals("LB")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC") || (order_category.equals("OT")) )) { %><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></b><!-- IN31901 -->
						<% 
							if(login_facility_id.equalsIgnoreCase(amendRecords[27]))
								facility_name =PerformingFacilityName;
							else
								facility_name =bean.getPerformingFacilityName(amendRecords[27]);
						%>
						<%=facility_name%> </font>/ <select name="amend_perform_loc_code<%=amend_count%>" id="amend_perform_loc_code<%=amend_count%>" <%= order_category.equals("RD")?"disabled":"" %> onchange='setPerforming("amend_perform_loc_code<%=amendRecords[2]%>",this)'>
						<option value=""  <%=bean.getTempvalue("amend_perform_loc_code"+amendRecords[2])==null?"":bean.getTempvalue("amend_perform_loc_code"+amendRecords[2]).equals("")?"selected":""%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						//DeptLocationCode = bean.getPerformingDeptLocation(amendRecords[27], amendRecords[30],order_category,lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma
						DeptLocationCode = bean.getPerformingDeptLocation(amendRecords[27], amendRecords[2],order_category,amendRecords[3],rd_instal_yn);
						if(bean.getTempvalue("amend_perform_loc_code"+amendRecords[2])==null)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if(amendRecords[31].equalsIgnoreCase(deptLocation[0]) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) )
								if(amendRecords[31].equalsIgnoreCase(deptLocation[0])) //IN047739
								{
									out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
								}
							}
						}
						else
						{	
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								if( (order_category.equals("RD") && rd_instal_yn.equals("Y"))  || bean.getTempvalue("amend_perform_loc_code"+amendRecords[2]).equals(deptLocation[0]))
								{
									out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
								}
							}
						}
			%> </select>
		<% } %>
						<!-- IN069674 start -->
					 <%
					//for RADIOLOGY
					if(("RD".equals(order_category)) && ("Y".equals(rd_instal_yn))){ 
						if("Y".equals(perfLocnMandFlag)){%>	
							<img src="../../eCommon/images/mandatory.gif">
							<%}
					}
					//EXCEPT RADIOLOGY
					if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && !(amendRecords[3]).equals(bt_order_type_code)){%>
							<img src="../../eCommon/images/mandatory.gif">
					<%}
					%><!-- IN069674 end -->
					<input type="hidden" name="amend_performing_dept_loc_code<%=amend_count%>" id="amend_performing_dept_loc_code<%=amend_count%>" value="<%=amendRecords[31]%>">
					<input type="hidden" name="amend_performing_facility_id<%=amend_count%>" id="amend_performing_facility_id<%=amend_count%>" value="<%=amendRecords[27]%>">
					<!--<input type="hidden" name="amend_line_comments<%=amend_count%>" id="amend_line_comments<%=amend_count%>" value="<%=amendRecords[16]%>">--> <!--IN64543-->
					<input type="hidden" name="amend_rep_group_ref<%=amend_count%>" id="amend_rep_group_ref<%=amend_count%>" value="<%=amendRecords[76]%>">
					<input type="hidden" name="amend_trn_group_ref<%=amend_count%>" id="amend_trn_group_ref<%=amend_count%>" value="<%=amendRecords[77]%>">
				</td>
				<td colspan="4" class="<%=classValue%>" align="left" style="border-right-width:0"><font size="1">
<%				
				//IN065324, starts
				boolean show_bill_dtls = false;

				if("Y".equals(amendRecords[33].trim()))
				{
					if(is_bt_view_bill_dtls && "BT".equals(amendRecords[59].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(amendRecords[59].trim()))
					{
						show_bill_dtls = true;
					}
					else
					{
						show_bill_dtls = false;
					}
				}
				//IN065324, ends
				String category_fpp_amend =  bean.getTempvalue("fpp_category"+amendRecords[2])==null?amendRecords[81]:bean.getTempvalue("fpp_category"+amendRecords[2]);//IN068314
				//if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && 					!amendRecords[59].equals("BT"))// && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")) )//IN065324
				if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && show_bill_dtls)// && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")) )//IN065324
				{
					amend_billing_call_yn		= "Y";
					//IN068314 Starts
					//BillChargeInfo		= bean_qryobj.getBillChargeDetails(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					if("Y".equals(amendRecords[80])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),amendRecords[80],category_fpp_amend) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN068314 Ends
					
					if(BillChargeInfo!=null)
					{						
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
						{
							billing_details 	= (String[])BillChargeInfo.get(k);
							setBills_dtls		= new HashMap();
		
							setBills_dtls.put("charged_yn"       , billing_details[1]);
							setBills_dtls.put("total_payable"    , billing_details[2]);
							setBills_dtls.put("patient_payable"  , billing_details[3]);
							setBills_dtls.put("quantity"         , qty_value);
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("incl_excl_action" , billing_details[4]);
							setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , amendRecords[80]);
							setBills_dtls.put("fpp_category"		 , amendRecords[81]);
							orderEntryBillBean.setOrderBillDtls(amendRecords[0]+amendRecords[1], setBills_dtls); 
							 if(!billing_details[9].equals(""))
							{%>
								 <script>
									alert("<%=billing_details[9]%>");
								 </script>
							<% 
						  	} 
							if(billing_details[10].equals("")&&billing_details[11].equals(""))
							{%>

								 <script> 
									 var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
									msg=msg.replace('{1}',"<%=records[0]%>");
									alert(msg);
								</script>
							<% 
							} 
						}
					}
			
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(amendRecords[0]+amendRecords[1]);
				%>
					<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%>>
					<!--	<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' style='border-width:0;display:inline'> -->
						<tr >	
							<!--IN068314 Starts-->
							<%
							if("Y".equals(amendRecords[80]))
							{	
								%>
							<input type="hidden" name="fpp_yn<%=amend_count%>" id="fpp_yn<%=amend_count%>"  value="<%=amendRecords[80]%>" >
							<td rowspan="2" colspan="" width='50%' class="<%=classValue%>" style='border-width:0;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${or_labels}"/>:</B></font>
						
								<select name="fpp_category<%=amend_count%>" id="fpp_category<%=amend_count%>"  onchange="reviseBillingchrgs('<%=amend_count%>','AMEND_ORDER')" ><!-- 10503 -->
									<option value="S" <%="S".equals(category_fpp_amend)?"selected":""%>><fmt:message key="eOR.Simple.label" bundle="${or_labels}"/></option><!--IN068314-->
									<option value="M" <%="M".equals(category_fpp_amend)?"selected":""%>><fmt:message key="eOR.Medium.label" bundle="${or_labels}"/></option><!--IN068314-->
									<option value="C" <%="C".equals(category_fpp_amend)?"selected":""%>><fmt:message key="eOR.Complex.label" bundle="${or_labels}"/></option><!--IN068314-->
								</select>
							
							</td>
							<%}else{ %>
							<td width='50%' rowspan="2" class="<%=classValue%>" style='border-width:0;'>&nbsp;</td>
							<%} %>
							<!--IN068314 Ends-->
							<td colspan="" width='30%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
							<td colspan="" width='15%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='15%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
								<td colspan="" width='20%' class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='fields' size="1"><span id='amend_bill_now_<%=amend_count%>'style='visibility:<%=bean.getTempvalue("amend_bill_now_"+amendRecords[2])==null?"hidden":bean.getTempvalue("amend_bill_now_"+amendRecords[2]).equals("visible")?"visible":"hidden"%>'><fmt:message key="eOR.BillLater.label" bundle="${or_labels}"/><input type="checkbox" name='amend_bill_now_check<%=amend_count%>' id='amend_bill_now_check<%=amend_count%>' value="<%=bean.getTempvalue("amend_bill_now_check"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("amend_bill_now_check"+amendRecords[2])%>"  onclick="amendChangeBillNow(this,'<%=amend_count%>','<%=amendRecords[2]%>')"
							<%//out.println("519"+bean.getTempvalue("bill_now_check"+amendRecords[2]+"chk"));%>
							<%=bean.getTempvalue("amend_bill_now_check"+amendRecords[2]+"chk")==null?"":bean.getTempvalue("amend_bill_now_check"+amendRecords[2]+"chk").equals("Checked")?"checked":""%>></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='amend_actual_<%=amend_count%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='amend_payable_<%=amend_count%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='amend_included_<%=amend_count%>'><%=bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")%></span></font></td>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='amend_approved_<%=amend_count%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font></td>
							<%
							}
							%>
						</tr>
							<input type="hidden" name="amend_bill_now<%=amend_count%>" id="amend_bill_now<%=amend_count%>" value="<%=bean.getTempvalue("amend_bill_now"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""): bean.getTempvalue("amend_bill_now"+amendRecords[2])%>">
							 <input type="hidden" name="amend_bill_now_check_Df<%=amend_count%>" id="amend_bill_now_check_Df<%=amend_count%>" value="<%=bean.getTempvalue("amend_bill_now_check_Df"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("amend_bill_now_check_Df"+amendRecords[2])%>">
								<input type="hidden" name="amend_future_date<%=amend_count%>" id="amend_future_date<%=amend_count%>"  value="<%=billing_details[18]%>" >
								<input type="hidden" name="amend_actual_value<%=amend_count%>" id="amend_actual_value<%=amend_count%>"  value="<%=billing_details[2]%>" >
								<input type="hidden" name="amend_actual_old_value<%=amend_count%>" id="amend_actual_old_value<%=amend_count%>"  value="<%=billing_details[2]%>" >
								<input type="hidden" name="amend_round_off_start_time<%=amend_count%>" id="amend_round_off_start_time<%=amend_count%>"  value="<%=billing_details[19]%>" >
					</table>
<%				}else{
					amend_billing_call_yn		= "N";
					out.println("&nbsp;");
				}
			
			
				//IN072654 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
					    boolean amendOverremarks = bean.chkDrugInteractionForLBAmend(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1]);
					    if(!amendOverremarks)
						bean.chkDrugInteractionForLB(amendRecords[2],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
					
						interactionYN=bean.getDruginteractionYN();
						interdrugDtls = bean.getDruginteractionDtl(); 
						if(null!=interdrugDtls)
							drugintercnt =	interdrugDtls.size();
						
						checkUncheck =	interactionYN.get(amendRecords[2]);
				
					if("R".equals(checkUncheck)){
					%>
					 <script>
							labdruginterchk("<%=records[0]%>");			
					 </script>
					
					<%}
				}//IN072654 Ends%>
			</td>
				<td class="<%=classValue%>" id="order<%=amend_count%>" <%if(show_bill_info_yn.equals("Y")) {%> style="border-left-width:0;text-align:center;display:inline" <%}else{%>style='border-width:0;display:none' <%}%> ><font size="1"> <!--  modified for IN039607 -->
				
<%  	           
			//if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && !amendRecords[59].equals("BT") && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )//IN065324
			if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && show_bill_dtls && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )//IN065324
		//	if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && !amendRecords[59].equals("BT") && (amendRecords[19].equals("DO") && show_bill_info_yn.equals("Y") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )// condition added for IN035929  - commented for IN039607
			{ 
					amend_billing_call_yn		= "Y";
%>
					<a class="gridLink" href="javascript:callReviseBilling('<%=i%>','AMEND_ORDER','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','<%=amendRecords[0]%>','<%=amendRecords[1]%>')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> <!--View / Edit--></a>
		
<%				}else{
				//10503 Starts	%>
					<tr>
					<td colspan="9" id="order<%=amend_count%>"  class="OR_QRYEVENBORDER">&nbsp;</td><!--IN068314-->
					</tr>
					<%//10503 Ends
					amend_billing_call_yn		= "N";}
				
%>				</font></td>
			</tr>
		<!--	<tr>
				<td colspan="9" id="order<%=amend_count%>"  class="OR_QRYEVENBORDER">&nbsp;</td> 
			</tr>--> <!--IN068314--> <!--Commented for 10503--><!-- 15910 Regression-OR-Amend Order-->
<%
			comments			= bean.getAmendComments(amendRecords[0],amendRecords[1]);//IN68475
			preps_instrn			= bean.getAmendPreps(amendRecords[0],amendRecords[1]);
			preps_dept_instrn		= bean.getAmendDepts(amendRecords[0],amendRecords[1]); // amend_Order_id & amend_order_line_num 
			pat_preps_instrn 		= bean.checkForNull(bean.getAmendPatientInstrn(amendRecords[0],amendRecords[1]),"");  // For Patient Preps. Insructions
			//IN68475 starts		
			ArrayList arrSeqNo2		= new ArrayList();
			arrSeqNo2.add(0, comments);	//Comments
			arrSeqNo2.add(1, preps_instrn);	//Preps
			arrSeqNo2.add(2, preps_dept_instrn);	//Dept
			arrSeqNo2.add(3, pat_preps_instrn); //Patient
			orderEntryRecordBean.setOrderFormats("Comments"+amendRecords[2], amendRecords[2], arrSeqNo2);
			//IN68475 ends
%>
			  <!--<input type="hidden" name="amend_line_preps<%=amend_count%>" id="amend_line_preps<%=amend_count%>" value="<%=preps_instrn%>">
			  <input type="hidden" name='amend_line_pat_instrn<%=amend_count%>' id='amend_line_pat_instrn<%=amend_count%>' value="<%=pat_preps_instrn%>">--><!--IN64543--%>
<%			 
                if(bean.checkForNull(amendRecords[4],"").equalsIgnoreCase("LB")) // If it is an Lab then only
                {
                	AmendSpecimenNurse = bean.getSpecimenNurseValue(amendRecords[0]);
					for(int j=0; j<AmendSpecimenNurse.size(); j++)
					{
						String[] record 		= (String[])AmendSpecimenNurse.get(j);
					    amend_specimen_type		= record[0];
                	    amend_nurse_collect_yn  = record[1];
					}
					AmendSpecimenNurse			 = null;
                }
                else
                {	amend_specimen_type 		= "";
                	amend_nurse_collect_yn		= "N";
                }

				//Added by Uma on 5/3/2011 
				order_types_comb	= "'"+bean.checkForNull(bean.getAmendOrderType(),"")+"'";
				OrderFormatTypes		= bean.getOrderTypeFormatID(order_category,order_types_comb);

  				if(OrderFormatTypes!=null && OrderFormatTypes.size() != 0 )
				{
					orderEntryRecordBean.setOrderFormats("ORDER_TYPE"+order_category, "0",OrderFormatTypes);
				}

				String header_format_id	= "";//IN066436
				for(count=0;count<OrderFormatTypes.size();count++)
				{
					header_format_id = "";//IN066436
					ind_catalog_code			= "";					
					order_type_records		= (String[])OrderFormatTypes.get(count);
					//format_id				= order_type_records[0];//commented for IN066436
					header_format_id				= order_type_records[0];//Added for IN066436
					order_type_code			= order_type_records[1];
					
					if(order_type_code!=null && order_type_code.equals("ALL"))
						order_type_code		= "";
						//order_type_short_desc	= order_type_records[2];
					
					ind_catalog_code	= order_type_code+amendRecords[59]; // For other Header Orders
					ind_row_value				= (ind_catalog_code+"_"+row_value);
				
					arrSeqNo1					= (ArrayList)	orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);	

					ArrayList OrderFormat=new ArrayList();	

					if(arrSeqNo1==null || arrSeqNo1.size()==0) // If it is already there in the bean
					{

						arrSeqNo1			=	new ArrayList();
						//OrderFormat 	= bean.getOrderFormat(format_id,order_category,bean.checkForNull(bean.getOrderId(),""),"HEADER",bean.checkForNull(amendRecords[1],""),bean.checkForNull(amendRecords[6],""),bean.checkForNull(bean.getSex(),""),bean.checkForNull(bean.getDob(),""),login_facility_id,bean.checkForNull(amendRecords[2],""),order_type_code,bean.checkForNull(bean.getPatientId(),""));//Commented for IN066436
						OrderFormat 	= bean.getOrderFormat(header_format_id,order_category,bean.checkForNull(bean.getOrderId(),""),"HEADER",bean.checkForNull(amendRecords[1],""),bean.checkForNull(amendRecords[6],""),bean.checkForNull(bean.getSex(),""),bean.checkForNull(bean.getDob(),""),login_facility_id,bean.checkForNull(amendRecords[2],""),order_type_code,bean.checkForNull(bean.getPatientId(),""));//Modified for IN066436
					

						for(int k=0; k<OrderFormat.size(); k++)
						{
							records			= (String[])OrderFormat.get(k);
							seq_num 		= (Integer.parseInt(bean.checkForNull(records[1],"0"))); // seq_num will start with 0

							if(old_seq_num!=0 && seq_num==old_seq_num ) 
							{	//used for Amend Orders
								new_seq_num--;		// reduce the new_seq_num
								arrSeqNo1.remove( String.valueOf(new_seq_num));		//remove the arraylist
								field_mnemonic	 = old_field_mnemonic;
							}
							else 
								field_mnemonic	 = bean.checkForNull(records[0],"0");

							//template		= beanQueryObj.buildHashTable(properties, new_seq_num, bean.getPatientId(), bean.checkForNull(bean.getOrderId(),""), format_id, order_type_code, "" , field_mnemonic,  records);//commented for IN066436
							template		= beanQueryObj.buildHashTable(properties, new_seq_num, bean.getPatientId(), bean.checkForNull(bean.getOrderId(),""), header_format_id, order_type_code, "" , field_mnemonic,  records);//Modified for IN066436
							//amend_order_id will be the order_id and order_type_short_desc will be null
							field_type	= (String) template.get("field_type");
							field_values	= (String) template.get("field_values");
							dflt_value	= (String) template.get("dflt_value");
							
							if(field_type.equalsIgnoreCase("D"))
							{
								if(field_values!=null)
								{
									if(!(field_values.equals("")))
									{
										field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMY","en",localeName);	
									}
								}
								if(!(dflt_value.equals("")))
								{
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMY","en",localeName);	
								}
								
							}
							if(field_type.equalsIgnoreCase("E"))
							{
								if(field_values!=null)
								{
									if(!(field_values.equals("")))
									{
										field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMYHM","en",localeName);	
									}
								}
								if(!(dflt_value.equals("")))
								{
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMYHM","en",localeName);	
								}
								
							}
							template.put("field_values"	,field_values);
							template.put("dflt_value"	,dflt_value);
							orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
							arrSeqNo1.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
							new_seq_num++;
							exists = true;
						}
						OrderFormat = null; // nullifying the object after use			
					}
				}
			
				if(exists)
		    	{				    		
					//orderEntryRecordBean.setOrderFormats(ind_catalog_code,ind_row_value,arrSeqNo1);//Commented for IN043099
				}
				ind_catalog_code			= "";
				//Added by Uma on 5/3/2011 			
				
%>
				<!--<input type="hidden" name="amend_line_dept_instrn<%=amend_count%>" id="amend_line_dept_instrn<%=amend_count%>" value="<%=preps_dept_instrn%>">--><!--IN64543-->
				<input type="hidden" name="amend_order_id<%=amend_count%>" id="amend_order_id<%=amend_count%>" value="<%=bean.checkForNull(bean.getOrderId(),"")%>">
				<input type="hidden" name="amend_order_line_num<%=amend_count%>" id="amend_order_line_num<%=amend_count%>" value="<%=amendRecords[1]%>">
				<input type="hidden" name="amend_order_category<%=amend_count%>" id="amend_order_category<%=amend_count%>" value="<%=amendRecords[4]%>">
				<input type="hidden" name="ord_appr_reqd_yn<%=amend_count%>" id="ord_appr_reqd_yn<%=amend_count%>" value="<%=amendRecords[8]%>">
				<input type="hidden" name="amend_ord_auth_reqd_yn<%=amend_count%>" id="amend_ord_auth_reqd_yn<%=amend_count%>" value="<%=amendRecords[7]%>">
				<input type="hidden" name="amend_ord_cosign_reqd_yn<%=amend_count%>" id="amend_ord_cosign_reqd_yn<%=amend_count%>" value="<%=amendRecords[9]%>">
				<input type="hidden" name="amend_old_quantity<%=amend_count%>" id="amend_old_quantity<%=amend_count%>" value="<%=amendRecords[18]%>">
				<input type="hidden" name="amend_ord_consent_reqd_yn<%=amend_count%>" id="amend_ord_consent_reqd_yn<%=amend_count%>" value="<%=amendRecords[22]%>">
				<input type="hidden" name="amend_specimen_type<%=amend_count%>" id="amend_specimen_type<%=amend_count%>" value="<%=amend_specimen_type%>">
				<input type="hidden" name="amend_nurse_collect<%=amend_count%>" id="amend_nurse_collect<%=amend_count%>" value="<%=amend_nurse_collect_yn%>">
				<input type="hidden" name="amend_pat_instrn_age_sex_yn<%=amend_count%>" id="amend_pat_instrn_age_sex_yn<%=amend_count%>" value="<%=amendRecords[28]%>">
				<input type="hidden" name="amend_contr_msr_mod_id<%=amend_count%>" id="amend_contr_msr_mod_id<%=amend_count%>" value="<%=amendRecords[59]%>">
				<input type="hidden" name="amend_contr_msr_panel_id<%=amend_count%>" id="amend_contr_msr_panel_id<%=amend_count%>" value="<%=amendRecords[30]%>">
				<input type="hidden" name="amend_order_catalog_nature<%=amend_count%>" id="amend_order_catalog_nature<%=amend_count%>" value="<%=amendRecords[32]%>">
				<input type="hidden" name="amend_billing_call_yn<%=amend_count%>" id="amend_billing_call_yn<%=amend_count%>" value="<%=amend_billing_call_yn%>">
				<input type="hidden" name="amend_quantity_uom<%=amend_count%>" id="amend_quantity_uom<%=amend_count%>" value="<%=amendRecords[35]%>">
				<input type="hidden" name="amend_chk_for_dupl_yn<%=amend_count%>" id="amend_chk_for_dupl_yn<%=amend_count%>" value="<%=amendRecords[36]%>">
				<input type="hidden" name="amend_chk_for_dupl_status<%=amend_count%>" id="amend_chk_for_dupl_status<%=amend_count%>" value="<%=amendRecords[37]%>">
				<input type="hidden" name="amend_activity_type<%=amend_count%>" id="amend_activity_type<%=amend_count%>" value="<%=amendRecords[38]%>">
				<input type="hidden" name="amend_check_for_dupl_level<%=amend_count%>" id="amend_check_for_dupl_level<%=amend_count%>" value="<%=amendRecords[39]%>">
				<input type="hidden" name="amend_chk_for_dupl_ahead_action<%=amend_count%>" id="amend_chk_for_dupl_ahead_action<%=amend_count%>" value="<%=amendRecords[40]%>">
				<input type="hidden" name="amend_chk_for_dupl_ahead_period<%=amend_count%>" id="amend_chk_for_dupl_ahead_period<%=amend_count%>" value="<%=amendRecords[41]%>">
				<input type="hidden" name="amend_chk_for_dupl_ahead_unit<%=amend_count%>" id="amend_chk_for_dupl_ahead_unit<%=amend_count%>" value="<%=amendRecords[42]%>">
				<input type="hidden" name="amend_chk_for_dupl_behind_action<%=amend_count%>" id="amend_chk_for_dupl_behind_action<%=amend_count%>" value="<%=amendRecords[43]%>">
				<input type="hidden" name="amend_chk_for_dupl_behind_period<%=amend_count%>" id="amend_chk_for_dupl_behind_period<%=amend_count%>" value="<%=amendRecords[44]%>">
				<input type="hidden" name="amend_chk_for_dupl_behind_unit<%=amend_count%>" id="amend_chk_for_dupl_behind_unit<%=amend_count%>" value="<%=amendRecords[45]%>">
				<input type="hidden" name="amend_result_applicable_yn<%=amend_count%>" id="amend_result_applicable_yn<%=amend_count%>" value="<%=amendRecords[46]%>">
				<input type="hidden" name="amend_bill_yn<%=amend_count%>" id="amend_bill_yn<%=amend_count%>" value="<%=amendRecords[47]%>">
				<input type="hidden" name="amend_appt_reqd_yn<%=amend_count%>" id="amend_appt_reqd_yn<%=amend_count%>" value="<%=amend_appt_reqd_yn%>">			
				<input type="hidden" name="amend_routine_appt_reqd_yn<%=amend_count%>" id="amend_routine_appt_reqd_yn<%=amend_count%>" value="<%=amend_routine_appt_reqd_yn%>">
				<input type="hidden" name="amend_stat_appt_reqd_yn<%=amend_count%>" id="amend_stat_appt_reqd_yn<%=amend_count%>" value="<%=amend_stat_appt_reqd_yn%>">
				<input type="hidden" name="amend_urgent_appt_reqd_yn<%=amend_count%>" id="amend_urgent_appt_reqd_yn<%=amend_count%>" value="<%=amend_urgent_appt_reqd_yn%>">
				<input type="hidden" name="amend_result_auth_reqd_yn<%=amend_count%>" id="amend_result_auth_reqd_yn<%=amend_count%>" value="<%=amendRecords[49]%>">
				<input type="hidden" name="amend_cont_order_yn<%=amend_count%>" id="amend_cont_order_yn<%=amend_count%>" value="<%=amendRecords[50]%>">
				<input type="hidden" name="amend_complete_on_order_yn<%=amend_count%>" id="amend_complete_on_order_yn<%=amend_count%>" value="<%=amendRecords[51]%>">
				<input type="hidden" name="amend_ord_spl_appr_reqd_yn<%=amend_count%>" id="amend_ord_spl_appr_reqd_yn<%=amend_count%>" value="<%=amendRecords[52]%>">
				<input type="hidden" name="amend_chart_result_type<%=amend_count%>" id="amend_chart_result_type<%=amend_count%>" value="<%=amendRecords[53]%>">
				<input type="hidden" name="amend_routine_chk_for_dupl_yn<%=amend_count%>" id="amend_routine_chk_for_dupl_yn<%=amend_count%>" value="<%=amendRecords[60]%>">
				<input type="hidden" name="amend_urgent_chk_for_dupl_yn<%=amend_count%>" id="amend_urgent_chk_for_dupl_yn<%=amend_count%>" value="<%=amendRecords[61]%>">
				<input type="hidden" name="amend_stat_chk_for_dupl_yn<%=amend_count%>" id="amend_stat_chk_for_dupl_yn<%=amend_count%>" value="<%=amendRecords[62]%>">
				<input type="hidden" name="amend_consent_stage<%=amend_count%>" id="amend_consent_stage<%=amend_count%>" value="<%=amendRecords[63]%>">
				<!--added on 08/05/07-->
			    <input type="hidden" name="amend_num_of_consent_req_bo<%=amend_count%>" id="amend_num_of_consent_req_bo<%=amend_count%>" value="<%=amendRecords[66]%>">
				<input type="hidden" name="amend_num_of_consent_req_br<%=amend_count%>" id="amend_num_of_consent_req_br<%=amend_count%>" value="<%=amendRecords[67]%>">
				<input type="hidden" name="amend_order_set_id<%=amend_count%>" id="amend_order_set_id<%=amend_count%>" value="<%=amendRecords[68]%>">
				<input type="hidden" name="amend_future_order_YN<%=amend_count%>" id="amend_future_order_YN<%=amend_count%>" value="<%=amendRecords[71]%>">
				<input type="hidden" name="amend_order_set_line_num<%=amend_count%>" id="amend_order_set_line_num<%=amend_count%>" value="<%=amendRecords[69]%>">
				<input type="hidden" name="amend_clin_cmts_reqd_yn<%=amend_count%>" id="amend_clin_cmts_reqd_yn<%=amend_count%>" value="<%=bean.checkForNull(amendRecords[70],"N")%>">
                 <!--added on 08/05/07 ends here-->					
				<input type="hidden" name="amend_freq_nature<%=amend_count%>" id="amend_freq_nature<%=amend_count%>" value="F" >
				<input type="hidden" name="amend_authorised_yn<%=amend_count%>" id="amend_authorised_yn<%=amend_count%>" value="N" >
				<input type="hidden" name="amend_freq_applicable_yn<%=amend_count%>" id="amend_freq_applicable_yn<%=amend_count%>" value="<%=amendRecords[75]%>">
				<input type="hidden" name="amend_barcode_reqd_yn<%=amend_count%>" id="amend_barcode_reqd_yn<%=amend_count%>" value="<%=amendRecords[78]%>"><!--IN063816 - GHL-CRF-0445.1 -->
				<%
				if(amend_speciality_code[0].equalsIgnoreCase("Y"))
				{
				
				%>
					<input type="hidden" name="amend_splty_code<%=amend_count%>" id="amend_splty_code<%=amend_count%>" value="<%=amend_speciality_code[1]%>" >
					<input type="hidden" name="amend_auth_yn<%=amend_count%>" id="amend_auth_yn<%=amend_count%>" value="<%=amend_speciality_code[2]%>" >
				<%
				}
				else
				{
				%>
					<input type="hidden" name="amend_splty_code<%=amend_count%>" id="amend_splty_code<%=amend_count%>" value="" >
					<input type="hidden" name="amend_auth_yn<%=amend_count%>" id="amend_auth_yn<%=amend_count%>" value="<%=bean.checkForNull(amendRecords[72],"N")%>" >
			   <%
				}	
			   %>
				<input type="hidden" name="amend_explanatory_text<%=amendRecords[2]%>" id="amend_explanatory_text<%=amendRecords[2]%>" value="<%=bean.checkForNull(amendRecords[64],"")%>"> <%-- explanatory_text--%>
				<input type="hidden" name="amend_auto_report_yn<%=amend_count%>" id="amend_auto_report_yn<%=amend_count%>" value="<%=bean.checkForNull(amendRecords[65],"")%>"> <%-- auto_report_yn--%>
				<input type="hidden" name="amend_instrn_content_type<%=amend_count%>" id="amend_instrn_content_type<%=amend_count%>" value='<%=bean.checkForNull(amendRecords[79],"T")%>'><!--IN64543-->
				<script>amenddate(<%=amend_count%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>','amend_start_date_time<%=amendRecords[2]%>','<%=amendRecords[2]%>','onLoad','<%=bean.getLoginFacilityId()%>');</script>
				<script>
					if((document.getElementById("amend_frequency_code<%=amend_count%>").value)!='')
					{
						setAmendFrequency(document.getElementById("amend_frequency_code<%=amend_count%>"),<%=amend_count%>,'<%=amendRecords[2]%>','<%=bean.getLoginFacilityId()%>','onload');
					}
				</script>
				<%
				String EnableEmail="N";
				
				/*arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+amendRecords[2],amendRecords[2]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); //preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
			  			pat_preps_instrns     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
				 }*/
				if(bean.checkForNull(amendRecords[16],"").equals("")&&preps_instrn.equals("")&&pat_preps_instrn.equals("")&&preps_dept_instrn.equals(""))
				{
					String sex_yn="";
					int age_in_days=0;
					String pat_pat_preps_instrns="";
					
					if(bean.checkForNull(amendRecords[28],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						if(null!=records && null!=records[0])//IN040531
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(amendRecords[2],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(amendRecords[2]);  // For Patient Preps. Insructions.				
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(prepins),"");  // For Patient Preps. Insructions.
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
					<input type="hidden" name="amend_enable_email<%=amend_count%>" id="amend_enable_email<%=amend_count%>" value="<%=EnableEmail%>">
					<%
											
			}  // End for Amend

			dateString=	ammend_start_date_time;
			%>
			<input type="hidden" name="amend_order_set_bill_yn" id="amend_order_set_bill_yn" value="<%=order_set_bill_yn%>">
			<input type="hidden" name="amend_order_charge_yn" id="amend_order_charge_yn" value="<%=charge_yn%>">
	<%} // End of if amend
	// New Orders, Painting
	String discharge_date_time = bean.getDischargeDateTime(bean.getPatientId(),bean.getEncounterId() );//IN050607
	bean.setDischargeDate(discharge_date_time);//IN050607
	String ordering_rule_yn = bean.getOrderingRuleYn(order_category);//IN050607

	if(PlaceOrderItems!=null)
	{
		for(i=0; i<PlaceOrderItems.size(); i++)
		{
			billinginterface="";
			String servicepanel="";
			String servicepanelcode="";
			String finbill="";
			displaytooltip="";
			String locn_appt_reqd_yn="";
			String speciality_code[]=new String[3];
			ArrayList speciality=new ArrayList();
			String comment 			  = "";
			String pat_preps_instrns ="";
			String pat_preps_pat_instrns="";
			String pat_preps_dep_instrns="";

			numbering=0;
			records =(String[])PlaceOrderItems.get(i); // String array
			comments = ""; pat_preps_instrn	=""; preps_instrn = "";  preps_dept_instrn = "";

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
			if(records[51].equalsIgnoreCase("Y"))
				chk_class_value = "eORConsent" ;
			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			if(function_from.equals("COPY_ORDER"))
			{
				copyOrderDetails	 = bean.getCopyOrderIDDetails(); // Get the Order Id and order_line
				if(copyOrderDetails!=null){
					order_id		 = bean.checkForNull((String)copyOrderDetails.get("order_id"+records[0]),""); // Get the order_id from the HashMap passing the catalog_code
					order_line_no	 = bean.checkForNull((String)copyOrderDetails.get("order_line_no"+records[0]),""); // Get the order_line_no from the HashMap passing the catalog_code
				}
				// Get the Default values
				/*Added by Uma on 4/1/2010 for IN020457*/
				if((order_id.equals("")&&order_line_no.equals("")))
				{
					Default = bean.getPlaceOrderDefault(records[0]);
				}
				else
				{
					Default	= bean.getCopyPlaceOrderDefault(order_id, order_line_no);
				}
				/*Ends Here by Uma on 4/1/2010 for IN020457*/
				// Get the Preps, Patient Instruction and Dept Instruction
				if(!(order_id.equals("") && order_line_no.equals("")))
				{
					pat_preps_instrn 		= bean.checkForNull(bean.getAmendPatientInstrn(order_id,order_line_no),"");  // For Patient Preps. Insructions
					preps_instrn			= bean.checkForNull(bean.getAmendPreps(order_id,order_line_no),"");
					preps_dept_instrn		= bean.checkForNull(bean.getAmendDepts(order_id,order_line_no),"");
				}
			}
			else // For other Orders
			{
				Default = bean.getPlaceOrderDefault(records[0]);
			}
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
 				if(recordDefault!=null){
					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
					if(qty_value.equals("0")) qty_value = "1";
						qty_uom			 =  bean.checkForNull(recordDefault[9],"");
						qty_uom_shortdesc=  bean.checkForNull(recordDefault[10],"");
				}else{
					qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
				}
			}
			// Till Here
			String temp_Start_Date = (bean.getTempvalue("start_date_time"+records[0]))==null?"":(bean.getTempvalue("start_date_time"+records[0]));   //Added for IN029076
%>
			<tr>
				<td width="2%"  id="billing<%=i%>" class="<%=chk_class_value%>" align="center"><input type="checkbox" name="ck<%=records[0]%>" id="ck<%=records[0]%>" value="Y" checked onClick="setCheckValue(this,'<%=records[0]%>','<%=i%>')">
				</td>
				<input type="hidden" name="h1<%=records[0]%>" id="h1<%=records[0]%>" value="<%=records[3]%>"><input type="hidden" name="h2<%=records[0]%>" id="h2<%=records[0]%>" value="<%=records[4]%>">
				<td width="12%" id="billing1<%=i%>" class="<%=classValue%>"><input type="text" id ="start_date_time<%=i%>"  name="start_date_time<%=i%>" onkeydown='chkBackSpace();' value='<%=temp_Start_Date==""?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName):temp_Start_Date%>' size="12" maxLength="16" 			OnBlur="checkStartDateTim(this,<%=i%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>','start_date_time<%=records[0]%>','<%=records[0]%>');" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('start_date_time<%=i%>',null,'hh:mm','start_date_time','<%=records[0]%>');" style='cursor:pointer'></td> <!-- Added for IN029076 -->
				<!--<td width="12%" id="billing1<%=i%>" class="<%=classValue%>"><input type="text" id ="start_date_time_id<%=i%>"  name="start_date_time<%=i%>" onkeydown='chkBackSpace();' value='<%=(bean.getTempvalue("start_date_time"+records[0]))==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName):bean.getTempvalue("start_date_time"+records[0])%>' size="14" maxLength="16" 			OnBlur="checkStartDateTim(this,<%=i%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>','start_date_time<%=records[0]%>','<%=records[0]%>');" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('start_date_time_id<%=i%>',null,'hh:mm','start_date_time','<%=records[0]%>');" style='cursor:pointer'></td> -->     <!--Commented for  IN029076 --> 
				<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=records[0]%>">
				<td  width="29%" id="billing2<%=i%>" algin="center" class="<%=classValue%>" onMouseOver='showToolTip("<%=records[0]%>","placeOrderForm")' onMouseOut="hideToolTip()"><font size="1">
				<input type="hidden" name="auth_reqd<%=i%>" id="auth_reqd<%=i%>" value="">
				<%=records[1]%> &nbsp;  
 <%
				if(!bean.checkForNull(records[62],"").equals("")) 
				{
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		
			
			   speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
			  
				if(speciality.size()>0)
				{
					for(int sc=0;sc<speciality.size();sc++)
					{
							speciality_code=(String[])speciality.get(sc);
					}
				}
				if(speciality_code[0].equalsIgnoreCase("Y"))
				{
				
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						
	%>		<img id='authorization<%=i%>' src="../../eOR/images/Authorization.gif" align="center"></img>
	<%			   }        
				}
				else
				{
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y"))
					{
						display_auth_count++;
						records[48]="Y";
	%>				<img id='authorization<%=i%>' src="../../eOR/images/Authorization.gif" align="center"></img>
	<%		
					}
				}
				
				if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y")) // For Cosign Required
				{
						display_cosign_count++;
						records[49]="Y";
	%>					<img id='cosign"+i+"' src="../../eOR/images/Cosign_click.gif" align="center"></img>
	<%			}
				if(records[50].equalsIgnoreCase("Y")) // For Special Approval
				{
				    display_special_count++;
%>					<img id='special_approval"+i+"' src="../../eOR/images/SpecialApproval.gif" align="center"></img>
<%				} %>

				</font><input type="hidden" name="cat_desc<%=i%>" id="cat_desc<%=i%>" value="<%=records[1]%>"><input type="hidden" name="type_desc<%=i%>" id="type_desc<%=i%>" value=""></td>
				<td width="14%" id="billing3<%=i%>" class="<%=classValue%>" align="center">
					<select name="order_type_code<%=i%>" id="order_type_code<%=i%>" DISABLED>
<%/*					out.println( bean.getPlaceOrderType(records[0], ((String)previousValues.get("h2"+records[0])) ) );*/
%>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>-->
<%					PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(((String)previousValues.get("h2"+records[0])).equals(orderTypeRecords[0]))
							out.println("<option value=\""+orderTypeRecords[0]+"\" selected> "+orderTypeRecords[1]+" </option>");
						else
							out.println("<option value=\""+orderTypeRecords[0]+"\"> "+orderTypeRecords[1]+" </option>");
						 temptype=orderTypeRecords[0];
						orderTypeRecords = null;
					}
					PlaceOrderType = null; // Nullifying the Objects	
%>
					</select>
					<input type="hidden" name="order_type<%=i%>" id="order_type<%=i%>" value="">
				</td>
 				<td width="4%" id="billing4<%=i%>" class="<%=classValue%>">
					<select name="priority<%=i%>" id="priority<%=i%>" onChange="setOrderPriority('priority','<%=records[0]%>',<%=i%>)" <%if(records[3].equals("OT")) out.println("DISABLED");%> ><!--IN048467-->
					<%if ( !((records[52]).equals("3"))) {%>
					      <option value=R <%=bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("R")?"selected":""%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					<% }
					  if (((records[52]).equals("")) || ((records[52]).equals("2"))) {%>
					   <option value=U <%=bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("U")?"selected":""%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					<%}
					if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					%>
					   <option value=S <%=bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("S")?"selected":""%>><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
					<%}%>
	   		 		</select>
				</td>
					
				<td width="5%" id="billing5<%=i%>" class="<%=classValue%>"><input type="text" style="text-align:'right'" name="quantity<%=i%>" id="quantity<%=i%>" value='<%=bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0])%>' size="2" maxLength="6" onKeyPress="return(ChkNumberInput(this,event,'2'))" onBlur="checkValidNumber('quantity<%=records[0]%>',this);reviseBillingchrgs('<%=i%>','NEW_ORDER')" <% if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); %>>&nbsp;
				<%
					if (qty_uom.equals("")) 
					{	
					//out.println(records[11]);modified by Ambiga.M on 1/19/2010 for 18146
						out.println(records[68]);
					}					
				    else
					{
						//out.println(qty_uom);
				        	out.println(qty_uom_shortdesc);
					}
					//IN046975 - Added to set the quantity value to the tempvalue for the correct charge calculation while navigating between place order n additional search tab
					if(!qty_value.equals(bean.getTempvalue("quantity"+records[0])) && bean.getTempvalue("quantity"+records[0]) != null)
						qty_value = bean.getTempvalue("quantity"+records[0]);
					//IN046975		
				%></td>
				<td width="17%" id="billing6<%=i%>" class="<%=classValue%>">
				<%
				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				%>
					<select name="frequency_code<%=i%>" id="frequency_code<%=i%>" onChange="setFrequency(this,<%=i%>,'<%=records[0]%>','<%=bean.getLoginFacilityId()%>','onChange'); setFrequencyCode('frequency_code<%=records[0]%>',this);" >
						<option value="" <%=bean.getTempvalue("frequency_code"+records[0])==null?"":bean.getTempvalue("frequency_code"+records[0]).equals("")?"selected":""%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
							PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","",""); // Pass the order_category and catalog_code
							if(bean.getTempvalue("frequency_code"+records[0])!=null)
							for(int j=0; j<PlaceOrderFrequency.size(); j++)
							{
								frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
								
 								if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0])))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
								}
							}
							else
							for(int j=0; j<PlaceOrderFrequency.size(); j++)
							{
								frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
 								if(recordDefault!=null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2]))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
								}
							}
						%>
					</select>
					<%				
					if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
					}
					else
					{
					%>
						<select name="frequency_code<%=i%>" id="frequency_code<%=i%>" disabled>
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select>
					<%
					}
					%>
					<input type="hidden" name="frequency_val<%=i%>" id="frequency_val<%=i%>" value="<%=frequency_val%>">
					<input type="hidden" name="schedule_yn<%=i%>" id="schedule_yn<%=i%>" value="N" >
					<input type="hidden" name="schedule_mandatorily_yn<%=i%>" id="schedule_mandatorily_yn<%=i%>" value="N" >
					<input type="hidden" name="freq_nature<%=i%>" id="freq_nature<%=i%>" value="F" >
					<input type="hidden" name="repeat_value<%=i%>" id="repeat_value<%=i%>" value="" >
				</td>
				<td width="4%" id="billing7<%=i%>" class="<%=classValue%>">
<% 					if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
					if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
					if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
					if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
%>
					<input type="text"  class="NUMBER" name="duration_value<%=i%>" id="duration_value<%=i%>" value="<%=bean.getTempvalue("duration_value"+records[0])==null?duration_value:bean.getTempvalue("duration_value"+records[0])%>" size="2" maxLength="3" onKeyPress="return(ChkNumberInput(this,event,'0'))" onBlur='checkMaxValue(this,"<%=max_durn_value%>","<%=chk_for_max_durn_action%>",escape("<%=prompt_msg%>"),"<%=records[19]%>","<%=i%>","<%=records[0]%>");setcheckMaxValue("duration_value<%=records[0]%>",this);'  <%if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");%>>
					<input type="hidden" class="NUMBER" name="duration_def_value<%=i%>" id="duration_def_value<%=i%>" value="<%=duration_value%>">
				</td>
				<td width="11%" id="billing9<%=i%>" class="<%=classValue%>">
					<select name="duration_code<%=i%>" id="duration_code<%=i%>" DISABLED>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select>
						<input type="hidden" name="duration<%=i%>" id="duration<%=i%>" value="">
				</td>
			</tr>
<%
							
		format_id = bean.checkForNull(records[47],"");
		if(!records[47].trim().equals(""))
		{
     		stFormatID 	= new StringTokenizer(records[47],"~");
     		while(stFormatID.hasMoreTokens())
     		{
     			format_id_mandatory_yn  = stFormatID.nextToken();
     			format_id 				= stFormatID.nextToken();
     		}
			stFormatID = null;// Nullifying the objects
 		}
%>			<TR>
				<input type="hidden" name="format_id_val<%=i%>" id="format_id_val<%=i%>" value="<%=format_id%>">
				<input type="hidden" name="format_id<%=i%>" id="format_id<%=i%>" value="<%=format_id%>"><!--Added for IN066436-->
				<input type="hidden" name="format_id_yn<%=i%>" id="format_id_yn<%=i%>" value="Y">
				<input type="hidden" name="format_id_mandatory_yn<%=i%>" id="format_id_mandatory_yn<%=i%>" value="<%=format_id_mandatory_yn%>" >
				<td class="<%=classValue%>" id="orderformat<%=i%>" ><font size="1"> &nbsp;<!--IN068314-->

          <%
		  
		  if(records[51].equalsIgnoreCase("Y"))
		 {
		 %>
				 <input class="button" type="button" name="consent_id_lookup<%=i%>" id="consent_id_lookup<%=i%>" title='Consent Required' value="C" onClick="callMultipleConsent('<%=records[0]%>','<%=URLEncoder.encode(records[1],"UTF-8")%>','','','<%=order_category%>','<%=i%>')">  <!-- IN041421 --> 
				<!--<IMG id='consent_id_lookup<%=i%>' style='cursor:pointer' SRC="../images/consentJ.JPG" WIDTH="25" HEIGHT="16" BORDER=0 ALT="Consent Required" onClick="callMultipleConsent('<%=records[0]%>','<%=records[1]%>','','','<%=order_category%>','<%=i%>')">-->
		 <%	
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
			 	ArrayList multiConsentList = new ArrayList();
				String[] multiConsentValues = null;
				String[] multiConsentDtls = null;
				boolean consentflag=false;
				multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
				multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
				if(multiConsentList==null || multiConsentList.size()==0)
				{
					multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
				}
				int total_recs = 0;				
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
									<input type='hidden' value="Y" name="consent_chk<%=i%><%=total_recs%>" id="consent_chk<%=i%><%=total_recs%>">
									<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id<%=i%><%=total_recs%>">
									<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_stages<%=i%><%=total_recs%>">
								<%
										total_recs++;
										consentflag = false;
								}
							}
						}						
					%>
					<Input type='hidden' name="consent_form_list<%=i%>" id="consent_form_list<%=i%>" value="<%=multiConsentDtls[0]%>">
					<Input type='hidden' name="total_recs<%=i%>" id="total_recs<%=i%>" value="<%=total_recs%>">						
				<%
				}
				else
				{
					if(multiConsentDtls[0].equals("F"))
					{	
						if(!(bean.checkForNull(multiConsentDtls[3])).equals(""))
						{
							total_recs = total_recs++;
						}
					%>							
						<input type="hidden" value='<%=multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")%>' name="consent_stages<%=i%>0">		
						<input type="hidden" value="Y" name="consent_chk<%=i%>0" id="consent_chk<%=i%>0">
						<!--<input type='hidden' value="<//%=multiConsentDtls[3]%>" name="consent_form_id<//%=i%>0">-->
						<input type='hidden' value="<%=multiConsentDtls[3]%>" name="consent_form_id<%=i%>"><!--IN030298-->							
					<%
					}
					%>
					<Input type='hidden' name="consent_form_list<%=i%>" id="consent_form_list<%=i%>" value="<%=multiConsentDtls[0]%>">
					<Input type='hidden' name="total_recs<%=i%>" id="total_recs<%=i%>" value="<%=total_recs%>">
					<%
				}
				%>
				<Input type='hidden' name="multiConsentList<%=i%>" id="multiConsentList<%=i%>" value="<%=total_recs%>">
			<%
			}
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
		 }
	
			secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class
			// secondayOrders will have to 2 values , count and the sec_order_catalog_type
			if (bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
				  sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""); //pass the catalog_code, prioriy as R, and the patient_class
               sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);


%>              <Script> 
					if(document.getElementById('start_date_time')<%=i%>)
						document.getElementById('start_date_time')<%=i%>.value = '<%=sec_start_date_time%>';
                //alert(''+document.getElementById('start_date_time')<%=i%>.value);
                </Script>
				<a class="gridLink" href="javascript:viewSecondaryOrders('<%=i%>','<%=bean.getPatientClass()%>')"> <img src='../../eOR/images/SecondaryOrder.gif' border='0'  title='Secondary Orders Exists'></img>&nbsp;</a>
				<%}%>
<%
				if(!format_id.equals(""))  // check for the Format
				{
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean
  						format_mandatory_count++;
					}
					else
					{
%>			 
<%		   			format_count++;
		 	   		} // else of format_id_mandatory_yn
		 	   	}
%>
				<input type="hidden" name="sec_tasks_type<%=i%>" id="sec_tasks_type<%=i%>" value="<%=secondaryOrders[1]%>"> <!--Keep the Seconday order catalog_type -->
				</td>
				<td class="<%=classValue%>" id="billing10<%=i%>" nowrap ><font size="1"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></font><input type="text" name="end_date_time<%=i%>" id="end_date_time<%=i%>" size="8" maxLength="16" value="" readOnly></td>
				<td class="<%=classValue%>" id="billing11<%=i%>" colspan='2' nowrap><label class="<%=classValue%>" id="schedule<%=i%>" Title="Schedule">&nbsp;</label>&nbsp;<!-- </td>
				<td class="<%=classValue%>" >&nbsp; -->
<%				
	//if((order_category.equals("LB") && lb_instal_yn.equals("Y")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC")) ) { changed on 7/9/2007 for lb_instal_yn by uma 
	if((order_category.equals("LB") )|| (order_category.equals("RD")) || (order_category.equals("RX"))||(order_category.equals("TR")) ) 
	{ 
		
		%>
		<font size="1"><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/>&nbsp;:</b>
		<select name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" onchange='clearDepLocn("<%=i%>","<%=records[0]%>","<%=order_category%>","<%=temptype%>","<%=rd_instal_yn%>",this);setPerformingFacility("performing_facility_id<%=records[0]%>",this);'>
			<%					
				performingLocationCode = bean.getPerformingLocation(order_category,((String)previousValues.get("h2"+records[0])),records[0]);	
				if(bean.getTempvalue("performing_facility_id"+records[0])==null)
				{
					for(int j=0; j<performingLocationCode.size(); j++)
					{
						performingLocation	= (String[]) performingLocationCode.get(j);
						//if condition added to handle 1 facility which is not login facility //IN047469		
						if(j==0)
							fac_selected = performingLocation[0];
						/* IN035095 starts */
						//if(performingLocation[0].equals(records[5])) //let the last one be selected
						if(performingLocation[0].equals(login_facility_id))
						/* IN035095 ends */
						{
							out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
							fac_selected = performingLocation[0]; //IN044014 to get the selected fac
						}
						else
						{
							out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
						}
					}
				}
				else
				{
					for(int j=0; j<performingLocationCode.size(); j++)
					{
						performingLocation	= (String[]) performingLocationCode.get(j);	
						//if condition added to handle 1 facility which is not login facility //IN047469		
						if(j==0)
							fac_selected = performingLocation[0];	
						/* IN035095 starts */
						//if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
						if(performingLocation[0].equals(login_facility_id))
						/* IN035095 ends */
						{
							out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
							fac_selected = performingLocation[0]; //IN044014 to get the selected fac
						}
						else
						{
							out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
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
					<font size="1"><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/>&nbsp;:</b>
					<%		
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
						fac_selected = 	records[5];//IN049984
					%>
 					<%=facility_name%></font>/
					<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=records[5]%>">
				<%
				}
				if((order_category.equals("LB") )|| (order_category.equals("RD")) || (order_category.equals("RX"))||(order_category.equals("TR")) ||(order_category.equals("MI"))||(order_category.equals("PC")) || (order_category.equals("OT")))//IN31901 
				{ 		
				%>
					<select name="performing_dept_loc_code<%=i%>" id="performing_dept_loc_code<%=i%>" onchange='getApptReqdYN("<%=records[0]%>",this,"<%=i%>");setPerforming("performing_dept_loc_code<%=records[0]%>",this)'>
						<option value="" <%=bean.getTempvalue("performing_dept_loc_code"+records[0])==null?"":bean.getTempvalue("performing_dept_loc_code"+records[0]).equals("")?"selected":""%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%					
						//DeptLocationCode = bean.getPerformingDeptLocation(records[5],records[0],order_category,lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma 
						//DeptLocationCode = bean.getPerformingDeptLocation(records[5],records[0],order_category,temptype,rd_instal_yn);		
						DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],order_category,temptype,rd_instal_yn); //IN044014 pass the selected facility as location	
						if(bean.getTempvalue("performing_dept_loc_code"+records[0])==null)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if((order_category.equals("RD") && rd_instal_yn.equals("Y") && 
								
								if(deptLocation[2]!=null && deptLocation[2].equals("Y")) //let the last one be selected
								{
									out.println("<option value=\""+deptLocation[0]+"\" selected> "+deptLocation[1]+" </option>");
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\" > "+deptLocation[1]+" </option>");
								}
							}
						}
						else
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if((order_category.equals("RD") && rd_instal_yn.equals("Y") && 
								if(deptLocation[2]!=null  && bean.getTempvalue("performing_dept_loc_code"+records[0]).equals(deptLocation[0])) //let the last one be selected
								{
									out.println("<option value=\""+deptLocation[0]+"\" selected> "+deptLocation[1]+" </option>");
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								
								}
								else 
								{
									out.println("<option value=\""+deptLocation[0]+"\" > "+deptLocation[1]+" </option>");
								}
							}
						}
					%>
					</select>
					<%			
					}
					else 
					{ 
					%>
						<input type="hidden" name="performing_dept_loc_code<%=i%>" id="performing_dept_loc_code<%=i%>" value="">
					<%
					}
					%>	
					<!-- IN066377 start -->
					 <%
					//for RADIOLOGY
					if(("RD".equals(order_category)) && ("Y".equals(rd_instal_yn))){ 
						if("Y".equals(perfLocnMandFlag)){%>	
							<img src="../../eCommon/images/mandatory.gif">
							<%}
					}
					//EXCEPT RADIOLOGY
					String cat_type_code = records[4];	
					if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag))  && !(cat_type_code.equals(bt_order_type_code))){%>
							<img src="../../eCommon/images/mandatory.gif">
					<%}	%>
					<!-- IN066377 end -->
				</td>
				<td colspan="4" id="billing12<%=i%>" class="<%=classValue%>" align="left" style="border-right-width:0">
				<%
				//IN065324, starts
				boolean show_bill_dtls = false;
				
				if("Y".equals(records[38].trim()))
				{
					if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(records[43].trim()))
					{
						show_bill_dtls = true;
					}
				}
				//IN065324, ends					
			String category =  bean.getTempvalue("fpp_category"+records[0])==null?records[75]:bean.getTempvalue("fpp_category"+records[0]);//IN068314
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN068314 Starts
					if("Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],category) ; //IN068314
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN068314 Ends
					if(BillChargeInfo!=null)
					{
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
						{
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
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("rate"		 ,"");
							setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);
							setBills_dtls.put("fpp_category"		 , records[75]);
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");

							orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							if(!billing_details[9].equals(""))
							{
								numbering=1;finbill="Billing";
								%>

								 <script>
									 alert("<%=billing_details[9]%>");billchecking("<%=records[0]%>");
									 displaycolor("<%=i%>");</script>

							<% displaytooltip=billing_details[9];
							} 
							if(billing_details[10].equals("")&&billing_details[11].equals(""))
							{
								numbering=1;							
							%>
								 <script>
									 var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
									msg=msg.replace('{1}',"<%=records[0]%>");
									alert(msg);
									billchecking("<%=records[0]%>");displaycolor("<%=i%>");
								</script>
								<% 		
								displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							}
							//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						}
					}
					/*if(numbering==1)
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
					}*/
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
					//if(show_bill_info_yn.equals("Y")) {	// commented for IN039607
			%>
					<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%> style='border-width:0;display:inline' <%}else{%>style='border-width:0;display:none' <%}%>> <!--  modified for IN039607 -->
							
							<tr  >	
							<!--IN068314 Starts-->
							<%
							
							if("Y".equals(records[74]))
							{	
								%>
							<input type="hidden" name="fpp_yn<%=i%>" id="fpp_yn<%=i%>"  value="<%=records[74]%>" >
							<td rowspan="2" colspan="" width='50%' class="<%=classValue%>" style='border-width:0;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${or_labels}"/>:</B></font>
						
								<select name="fpp_category<%=i%>" id="fpp_category<%=i%>"  onchange="reviseBillingchrgs('<%=i%>','NEW_ORDER')" >
									<option value="S" <%="S".equals(category)?"selected":""%>><fmt:message key="eOR.Simple.label" bundle="${or_labels}"/></option><!--IN068314 -->
									<option value="M" <%="M".equals(category)?"selected":""%>><fmt:message key="eOR.Medium.label" bundle="${or_labels}"/></option><!--IN068314 -->
									<option value="C" <%="C".equals(category)?"selected":""%>><fmt:message key="eOR.Complex.label" bundle="${or_labels}"/></option><!--IN068314 -->
								</select>
							
							</td>
							<%}else{ %>
							<td width='50%' rowspan="2" class="<%=classValue%>" style='border-width:0;'>&nbsp;</td>
							<%} %>
							<!--IN068314 Ends-->
							<td colspan="" width='10%'  class="<%=classValue%>" style='border-width: 0;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
							<td colspan="" width='20%'  class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
							<td colspan=""  width='20%' class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" width='25%'  class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
								<td colspan="" width='25%'  class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
							<%
							}
							%>
						</tr>
							<tr>
							<td colspan="" class="<%=classValue%>"  style='border-width: 0;text-align: right;'  nowrap><font class='fields' size="1"><span id='bill_now_<%=i%>' style='visibility:<%=bean.getTempvalue("bill_now_"+records[0])==null?(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden"):bean.getTempvalue("bill_now_"+records[0]).equals("visible")?"visible":(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden")%>'><fmt:message key="eOR.BillLater.label" bundle="${or_labels}"/><input type="checkbox" name='bill_now_check<%=i%>' id='bill_now_check<%=i%>' value="<%=bean.getTempvalue("bill_now_check"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check"+records[0])%>" onclick="changeBillNow(this,'<%=i%>','<%=records[0]%>')" <%=bean.getTempvalue("bill_now_check"+records[0]+"chk")==null?(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":""):bean.getTempvalue("bill_now_check"+records[0]+"chk").equals("Checked")?"checked":(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")%>></span></font><%if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){%>(<fmt:message key="eOR.ApptRequired.label" bundle="${or_labels}"/>)<%}%></td>
							<td colspan=""  class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
							<td colspan=""  class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")%></span></font></td>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font></td> 
								<%
								}
								%>
						</tr>
							 <input type="hidden" name="bill_now<%=i%>" id="bill_now<%=i%>" value="<%=bean.getTempvalue("bill_now"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""): bean.getTempvalue("bill_now"+records[0])%>">
							 <input type="hidden" name="bill_now_check_Df<%=i%>" id="bill_now_check_Df<%=i%>" value="<%=bean.getTempvalue("bill_now_check_Df"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check_Df"+records[0])%>">
							<input type="hidden" name="future_date<%=i%>" id="future_date<%=i%>"  value="<%=billing_details[18]%>" >
							<input type="hidden" name="round_off_start_time<%=i%>" id="round_off_start_time<%=i%>"  value="<%=billing_details[19]%>" >
						</table>
<%				
					}
				//} 	// commented for IN039607
					else
					{ 
								//hashEntry.put(entryValue,"Y");								
						billing_call_yn = "N";
						out.println("&nbsp;");
					}				
				//IN071260 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				ArrayList<OrderDrugInteractionVO> drugs  = null;//IN072683
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
						bean.chkDrugInteractionForLB(records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
					
						interactionYN=bean.getDruginteractionYN();
						interdrugDtls = bean.getDruginteractionDtl();
						if(null!=interdrugDtls){
							drugs = interdrugDtls.get(records[0]);//IN072683
							if(null!=drugs && drugs.size() > 0 )//IN072683
								drugintercnt =	drugs.size();
						}
						
						checkUncheck =	interactionYN.get(records[0]);
				
					if("R".equals(checkUncheck)){
					%>
					 <script>
							labdruginterchk("<%=records[0]%>");			
					 </script>
					
					<%}
				}
				//IN071260 ENDS
				//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
%>				
				</td>
				<%
				if(numbering==0)
				{
				%>
					<td class="<%=classValue%>" id="order<%=i%>" <%if(show_bill_info_yn.equals("Y")) {%> style="border-left-width:0;text-align: center;display:inline" <%}else{%>style='border-width:0;display:none' <%}%>><font size="1"> <!--  added for IN039607 -->
				<%
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
			//	if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && show_bill_info_yn.equals("Y")) // condition added for IN035929 // commented for IN039607
			//if(billing_interface_yn.equals("Y") && records[38].equals("Y"))//IN065324
			if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{	
						billing_call_yn		= "Y";
					//if(!billing_details[10].equals("")&&!billing_details[11].equals(""))
					//{
						//if(numbering==0)
					//{
%>
						<a class="gridLink"  href="javascript:callReviseBilling('<%=i%>','NEW_ORDER','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','','')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></font></td> <!--View / Edit Added for IN068314	 -->
					<!--	 <a href="javascript:callBilling('<%=i%>','NEW_ORDER')" title='Charge Details'>  --> <!-- <fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>  View / Edit --></a>
<%				} else billing_call_yn = "N"; %>

				<%}else{%><td class="<%=classValue%>" style="border-left-width:0;text-align: center;display:inline" id="order<%=i%>" style="background:#FF7DD0">&nbsp;</td><%}%>
				<%
				String EnableEmail="N";
				
				arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+records[0],records[0]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); //preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
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
						if(null!=records && null!=records[0])//IN040531
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(records[0],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(records[0]);  // For Patient Preps. Insructions.
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(prepins),"");  // For Patient Preps. Insructions.
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
							displaycolor("<%=i%>");
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
					billinginterface = "operational_interface";
					non_billing_numbering=1;//IN068314
					%>
					 <script>
						 var msg=getMessage("CATALOG_OPERATIONAL_MODULE","OR");
						msg=msg.replace('{1}',"<%=records[0]%>");
						alert(msg);
						billchecking("<%=records[0]%>");
						displaycolor("<%=i%>");
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
					//IN050607 Starts
				  	if ("N".equals(ordering_rule_yn)) {
						numbering = 1;
						billinginterface="or_ordering_rule_chk";
						non_billing_numbering=1;//IN068314
						%>
						<script>
							var msg=getMessage("OR_ORDERING_RULE_CHK","OR");
							msg=msg.replace('{1}',"<%=records[0]%>");
							alert(msg);
							billchecking("<%=records[0]%>");
							displaycolor("<%=i%>");
						</script>
						<%
						displaytooltip = bean.getMessage(localeName,
											"OR_ORDERING_RULE_CHK", "OR");
						displaytooltip = displaytooltip.replace("{1}",
											records[0]);
					}
					if (numbering == 1) {
						Set setValues = null;
						Iterator iterator = null;
						if (previousValues != null) // Get the Previous Values from the Bean
						{
							setValues = previousValues.keySet();
							iterator = setValues.iterator();
							String chk_value = "";
							String order_type = "";
							for (int z = 0; z < previousValues.size(); z++) {
								entryValue = ((String) iterator.next());
								chk_value = (String) previousValues
										.get(entryValue);
								keyItems = orderEntryRecordBean
										.getKey(entryValue); // Method Called from Bean to split the chk/h1 and get the value
							

								if (keyItems[0].equals("ck")) // If it is a check Box, then put the entry into a hashmap with the value as "Y"
								{
									if (!chk_value.equals("N")) {
										check = records[0];
										if ((entryValue.substring(2))
												.equals(check)) {
											hashEntry.put(entryValue, "N");
										} else {
											hashEntry.put(entryValue, "Y");
										}
									}
								} else // If it is hidden Field
								{
									if (keyItems[0].equals("h1")) // If it is a hidden (h1--denotes order_category)
									{
										order_category = (String) previousValues
												.get("h1" + keyItems[1]);
										hashEntry.put("h1" + keyItems[1],
												order_category);
									} else if (keyItems[0].equals("h2")) // If it is a hidden (h2--denotes order_type_code)
									{
										order_type = (String) previousValues
												.get("h2" + keyItems[1]);
										hashEntry.put("h2" + keyItems[1],
												order_type);
									}
								}
							}
						}
						orderEntryRecordBean.setCheckedEntries(key,
								hashEntry);
						previousValues = (HashMap) orderEntryRecordBean
								.getCheckedEntries(key);
					}
					//IN050607 Ends
					//}
					/*Ends Here*/
					%>
					<input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=records[0]%>"><!-- IN041644 -->
					<input type="hidden" name="enable_email<%=i%>" id="enable_email<%=i%>" value="<%=EnableEmail%>">
					<input type="hidden" name="order_catalog_nature<%=i%>" id="order_catalog_nature<%=i%>" value="<%=records[2]%>">
					<input type="hidden" name="quantity_uom<%=i%>" id="quantity_uom<%=i%>" value="<%=records[11]%>">
					<input type="hidden" name="freq_applicable_yn<%=i%>" id="freq_applicable_yn<%=i%>" value="<%=records[14]%>">
					<input type="hidden" name="soft_stop_yn<%=i%>" id="soft_stop_yn<%=i%>" value="<%=records[19]%>">
					<input type="hidden" name="cont_order_yn<%=i%>" id="cont_order_yn<%=i%>" value="<%=records[20]%>">
					<input type="hidden" name="chk_for_dupl_yn<%=i%>" id="chk_for_dupl_yn<%=i%>" value="<%=records[22]%>">
					<input type="hidden" name="chk_for_dupl_status<%=i%>" id="chk_for_dupl_status<%=i%>" value="<%=records[23]%>">
				
					<input type="hidden" name="chk_for_dupl_ahead_action<%=i%>" id="chk_for_dupl_ahead_action<%=i%>" value="<%=records[24]%>">
					<input type="hidden" name="chk_for_dupl_ahead_period<%=i%>" id="chk_for_dupl_ahead_period<%=i%>" value="<%=records[25]%>">
					<input type="hidden" name="chk_for_dupl_ahead_unit<%=i%>" id="chk_for_dupl_ahead_unit<%=i%>" value="<%=records[26]%>">
					<input type="hidden" name="chk_for_dupl_behind_action<%=i%>" id="chk_for_dupl_behind_action<%=i%>" value="<%=records[27]%>">
					<input type="hidden" name="chk_for_dupl_behind_period<%=i%>" id="chk_for_dupl_behind_period<%=i%>" value="<%=records[28]%>">
					<input type="hidden" name="chk_for_dupl_behind_unit<%=i%>" id="chk_for_dupl_behind_unit<%=i%>" value="<%=records[29]%>">

					<input type="hidden" name="appt_reqd_yn<%=i%>" id="appt_reqd_yn<%=i%>" value="<%=records[33]%>">
					<input type="hidden" name="locn_appt_reqd_yn<%=i%>" id="locn_appt_reqd_yn<%=i%>" value="<%=locn_appt_reqd_yn%>">
					<input type="hidden" name="appt_time<%=i%>" id="appt_time<%=i%>" value="<%=records[34]%>">
					<input type="hidden" name="pat_instrn_age_sex_yn<%=i%>" id="pat_instrn_age_sex_yn<%=i%>" value="<%=records[35]%>">
					<input type="hidden" name="complete_on_order_yn<%=i%>" id="complete_on_order_yn<%=i%>" value="<%=records[37]%>">
					<input type="hidden" name="bill_yn<%=i%>" id="bill_yn<%=i%>" value="<%=records[38]%>">
					<input type="hidden" name="result_applicable_yn<%=i%>" id="result_applicable_yn<%=i%>" value="<%=records[39]%>">
					<input type="hidden" name="result_auth_reqd_yn<%=i%>" id="result_auth_reqd_yn<%=i%>" value="<%=records[40]%>">
					<input type="hidden" name="chart_result_type<%=i%>" id="chart_result_type<%=i%>" value="<%=records[41]%>">
					<input type="hidden" name="contr_msr_mod_id<%=i%>" id="contr_msr_mod_id<%=i%>" value="<%=records[43]%>">
					<input type="hidden" name="contr_msr_panel_id<%=i%>" id="contr_msr_panel_id<%=i%>" value="<%=records[44]%>">

					<input type="hidden" name="ord_auth_reqd_yn<%=i%>" id="ord_auth_reqd_yn<%=i%>" value="<%=records[48]%>">
					<input type="hidden" name="ord_cosign_reqd_yn<%=i%>" id="ord_cosign_reqd_yn<%=i%>" value="<%=records[49]%>">
					<input type="hidden" name="ord_spl_appr_reqd_yn<%=i%>" id="ord_spl_appr_reqd_yn<%=i%>" value="<%=records[50]%>">
					<input type="hidden" name="ord_consent_reqd_yn<%=i%>" id="ord_consent_reqd_yn<%=i%>" value="<%=records[51]%>">
					<input type="hidden" name="activity_type<%=i%>" id="activity_type<%=i%>" value="<%=records[53]%>">
					<input type="hidden" name="check_for_dupl_level<%=i%>" id="check_for_dupl_level<%=i%>" value="<%=records[54]%>">
					
					<input type="hidden" name="group_order_category<%=i%>" id="group_order_category<%=i%>" value="<%=order_category%>">
					<input type="hidden" name="billing_call_yn<%=i%>" id="billing_call_yn<%=i%>" value="<%=billing_call_yn%>">
					<input type="hidden" name="specimen_type<%=i%>" id="specimen_type<%=i%>" value="">
					<input type="hidden" name="nurse_collect<%=i%>" id="nurse_collect<%=i%>" value="N">
					<input type="hidden" name="start_time<%=i%>" id="start_time<%=i%>" value=""> <!-- For Care Sets -->
					<input type="hidden" name="care_set_order_category<%=i%>" id="care_set_order_category<%=i%>" value=""><!--For Care Sets-->
					<input type="hidden" name="care_set_authorized<%=i%>" id="care_set_authorized<%=i%>" value="false"> <!--For Care Sets-->
					<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=order_id%>"> <!-- For Copy Order -->
					<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_no%>"> <!-- For Copy Order -->
					<!--<input type="hidden" name="line_preps<%=i%>" id="line_preps<%=i%>" value="<%=preps_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_pat_instrn<%=i%>" id="line_pat_instrn<%=i%>" value="<%=pat_preps_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_dept_instrn<%=i%>" id="line_dept_instrn<%=i%>" value="<%=preps_dept_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_comments<%=i%>" id="line_comments<%=i%>" value="<%=comments%>"><%--IN64543--%>
					<input type="hidden" name="routine_appt_reqd_yn<%=i%>" id="routine_appt_reqd_yn<%=i%>" value="<%=records[55]%>">
					<input type="hidden" name="stat_appt_reqd_yn<%=i%>" id="stat_appt_reqd_yn<%=i%>" value="<%=records[56]%>">
					<input type="hidden" name="urgent_appt_reqd_yn<%=i%>" id="urgent_appt_reqd_yn<%=i%>" value="<%=records[57]%>">

					<input type="hidden" name="routine_chk_for_dupl_yn<%=i%>" id="routine_chk_for_dupl_yn<%=i%>" value="<%=records[58]%>">
					<input type="hidden" name="urgent_chk_for_dupl_yn<%=i%>" id="urgent_chk_for_dupl_yn<%=i%>" value="<%=records[59]%>">
					<input type="hidden" name="stat_chk_for_dupl_yn<%=i%>" id="stat_chk_for_dupl_yn<%=i%>" value="<%=records[60]%>">
					<input type="hidden" name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=records[61]%>">
					<!-- added on 08/05/07 -->
					<input type="hidden" name="num_of_consent_req_bo<%=i%>" id="num_of_consent_req_bo<%=i%>" value="<%=records[64]%>">
					<input type="hidden" name="num_of_consent_req_br<%=i%>" id="num_of_consent_req_br<%=i%>" value="<%=records[65]%>">
					<input type="hidden" name="billing_interface<%=i%>" id="billing_interface<%=i%>" value="<%=billinginterface%>">
					<input type="hidden" name="service_panel<%=i%>" id="service_panel<%=i%>" value="<%=servicepanel%>">
					<input type="hidden" name="service_panel_code<%=i%>" id="service_panel_code<%=i%>" value="<%=servicepanelcode%>">
					<input type="hidden" name="numbering<%=i%>" id="numbering<%=i%>" value="<%=numbering%>">
					<input type="hidden" name="FinBill<%=i%>" id="FinBill<%=i%>" value="<%=finbill%>">
					<input type="hidden" name="clin_cmts_reqd_yn<%=i%>" id="clin_cmts_reqd_yn<%=i%>" value="<%=bean.checkForNull(records[66],"N")%>">
				<!-- 	<input type="hidden" name="can_authorise_yn<%=i%>" id="can_authorise_yn<%=i%>" value="<%=bean.checkForNull(records[67],"N")%>"> -->
					<input type="hidden" name="authorised_yn<%=i%>" id="authorised_yn<%=i%>" value="N">
					<input type="hidden" name="skip_auth<%=i%>" id="skip_auth<%=i%>" value="<%=records[70]%>"><!--IN048467 - HSA-CRF-0150-->
					<input type="hidden" name="barcode_reqd_yn<%=i%>" id="barcode_reqd_yn<%=i%>" value="<%=records[71]%>"><!--IN063816 - GHL-CRF-0445.1 -->
					<input type="hidden" name="prn_regd_ord<%=i%>" id="prn_regd_ord<%=i%>" value="<%=records[72]%>"><!--IN065942-->
					<input type="hidden" name="instrn_content_type<%=i%>" id="instrn_content_type<%=i%>" value='<%=bean.checkForNull(records[73],"T")%>'><!--IN065942--><!--IN64543-->
					<input type="hidden" name="non_billing_numbering<%=i%>" id="non_billing_numbering<%=i%>"  id ="non_billing_numbering<%=i%>" value="<%=non_billing_numbering %>" /><!--IN068314 -->
				<%							
					if(speciality_code[0].equalsIgnoreCase("Y"))
					{
					%>
						<Input type='hidden' name="splty_code<%=i%>" id="splty_code<%=i%>" value="<%=speciality_code[1]%>">
						<Input type='hidden' name="auth_yn<%=i%>" id="auth_yn<%=i%>" value="<%=speciality_code[2]%>">
					<%
					}
					else
				   {
					%>
						<Input type='hidden' name="splty_code<%=i%>" id="splty_code<%=i%>" value="">
						<Input type='hidden' name="auth_yn<%=i%>" id="auth_yn<%=i%>" value="<%=bean.checkForNull(records[67],"N")%>">
					<%
					}
					%>
					<!-- ends here-->
					<%if(numbering==1){%>
					<input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=displaytooltip%>"> 
					<%}else{%><input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=bean.checkForNull(records[62],"")%>"> 
					<%}%>
					<%-- explanatory_text--%>
					<input type="hidden" name="auto_report_yn<%=i%>" id="auto_report_yn<%=i%>" value="<%=bean.checkForNull(records[63],"")%>"> <%-- auto_report_yn--%> 				
					<%		
						out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+i+","+i+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
					%>
				</tr>
				<tr>
					<td colspan="9" class="OR_QRYEVENBORDER">&nbsp;</td>
				</tr>
				<%	
				}
			} 
		%>
	</table>
		<input type="hidden" name="patient_email_id" id="patient_email_id" value="<%=bean.checkForNull(patient_email_id,"")%>">
		<input type="hidden" name="care_set_count" id="care_set_count" value="0"><!-- Used for Care Sets-->
		<input type="hidden" name="mode" id="mode" value="1">
		<input type="hidden" name="sys_date" id="sys_date" value='<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>'>
		<input type="hidden" name="total_rows" id="total_rows" value="<%=i%>">
		<input type="hidden" name="amend_total_rows" id="amend_total_rows" value="<%=amend_count%>">
		<input type="hidden" name="check_box_val" id="check_box_val" value="">
		<input type="hidden" name="authorized" id="authorized" value="">
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="location_type" id="location_type" value="">
		<input type="hidden" name="location_code" id="location_code" value="">
		<input type="hidden" name="priority_hdr" id="priority_hdr" value="">
		<input type="hidden" name="order_date_time" id="order_date_time" value="">
		<input type="hidden" name="header_comments" id="header_comments" value="">
		<input type="hidden" name="order_category" id="order_category" value="">
		<input type="hidden" name="consented" id="consented" value="">
		<input type="hidden" name="cosigned" id="cosigned" value="">
		<input type="hidden" name="special_approved" id="special_approved" value="">
		<input type="hidden" name="lb_instal_yn" id="lb_instal_yn" value="<%=lb_instal_yn%>">
		<input type="hidden" name="rd_install_yn" id="rd_install_yn" value="">
		<input type="hidden" name="ot_install_yn" id="ot_install_yn" value="">
		<input type="hidden" name="session_id" id="session_id" value="<%=session_id%>">
		<input type="hidden" name="sex" id="sex" value="<%=bean.getSex()%>">
		<input type="hidden" name="dob" id="dob" value="<%=bean.getDob()%>">
		<input type="hidden" name="display_auth_count" id="display_auth_count" value="<%=display_auth_count%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="ordering_practitioner" id="ordering_practitioner" value="<%=bean.getPractitionerId()%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
		<!-- IN030279 Start -->
		<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
		<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
		<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
		<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
		<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
		<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
		<!-- IN030279 End. -->
		<input type="hidden" name="p_task_code" id="p_task_code" value="<%=p_task_code%>">
		<input type="hidden" name="p_task_srl_no" id="p_task_srl_no" value="<%=p_task_srl_no%>">
		<input type="hidden" name="ref_facility_id" id="ref_facility_id" value="<%=ref_facility_id%>"><!--External Orders-->
		<input type="hidden" name="ref_date_time" id="ref_date_time" value="<%=ref_date_time%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_pract_id" id="ref_sent_pract_id" value="<%=ref_sent_pract_id%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_remarks" id="ref_sent_remarks" value="<%=ref_sent_remarks%>"><!--External Orders-->
		<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>"><!--Query String-->
		<input type="hidden" name="perfLocnMandFlag" id="perfLocnMandFlag" value="<%=perfLocnMandFlag%>"><!--IN066377-->
		<input type="hidden" name="bt_order_type_code" id="bt_order_type_code" value="<%=bt_order_type_code%>">
		<input type="hidden" name="call_function" id="call_function" value="ORCAT"><!--IN066377-->
		<%
		if(order_set_bill_yn.equals("Y"))
		{
		%>
			<input type="hidden" name="care_set_catalog_code" id="care_set_catalog_code" value="<%=bill_order_catalog_code%>"><!-- Used for Care Sets-->
			<input type="hidden" name="care_set_catalog_desc" id="care_set_catalog_desc" value="<%=bill_order_set_desc%>"><!-- Used for Care Sets-->
		<%
		}
		else
		{
		%>
			<input type="hidden" name="care_set_catalog_code" id="care_set_catalog_code" value=""><!-- Used for Care Sets-->
			<input type="hidden" name="care_set_catalog_desc" id="care_set_catalog_desc" value=""><!-- Used for Care Sets-->
		<%
		}
		%>
		<input type="hidden" name="function_name" id="function_name" value="NEW_ORDER"> <!-- For Order Format Line Level -->
    	<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
			 <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->
		<input type="hidden" name="cosign_reqd_yn" id="cosign_reqd_yn" value=""> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn='Y' when nurse is logging in -->
		<input type="hidden" name="primary_order_type" id="primary_order_type" value=""> <!-- Used for Primary Order Type OT Ordercategory -->
		<input type="hidden" name="validated_status" id="validated_status" value="validation_reqd">
		<input type="hidden" name="new_order_reqd" id="new_order_reqd" value=""> 
		<input type="hidden" name="email_yn" id="email_yn" value="N"> <!-- For Email -->
		<input type="hidden" name="appl_user_name" id="appl_user_name" value="<%=appl_user_name%>"> 
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="order_set_bill_yn" id="order_set_bill_yn" value="<%=order_set_bill_yn%>">
		<input type="hidden" name="checkCount" id="checkCount" value="">
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
		<input type="hidden" name="twicedupchkflg" id="twicedupchkflg" value="<%=dupchk_siteSpecFlag%>"> <!-- IN062607 -->
		<input type="hidden" name="show_bill_info_yn" id="show_bill_info_yn" value="<%=show_bill_info_yn%>"> <!-- added for IN039607 -->

		<input type="hidden" name="pract_type" id="pract_type" value="<%=practitioner_type%>"><!--IN065942-->
		<input type="hidden" name="interactionDrugsCnt" id="interactionDrugsCnt"  id ="interactionDrugsCnt" value="<%=drugintercnt %>" />	<!-- IN071260 -->

		<!-- For Amend Order , To generate a New Order-->
<%
		//Nullifying the objects
		PlaceOrderItems				= null;  		//Nullifying the objects
		AmendPlaceOrderItems		= null;		AmendSchedule				= null;
		AmendPlaceOrderFrequency	= null;		
		//AmendPlaceOrderDuration		= null;
		previousValues				= null;		Default						= null;
		DeptLocationCode 			= null;		performingLocationCode		= null;
		PlaceOrderType				= null;		PlaceOrderFrequency			= null;
		stFormatID					= null;
		copyOrderDetails			= null;		secondaryOrders				= null;
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
	
	loadDetails("<%=display_auth_count%>","<%=format_mandatory_count%>","<%=format_count%>","<%=display_cosign_count%>","<%=display_special_count%>","<%=function_from%>","<%=i%>","<%=p_start_date_time%>","<%=drugintercnt%>")
	skipAuthIndicator();//IN048467
	</script>
	 
	<script>
		if(parent.legendsFrame.document.getElementById('titleTab')!=null) {
			alignWidth('<%=order_set_bill_yn%>');
		}
		 <!-- added for IN039607 -->
		var show_bill_info_yn = document.placeOrderForm.show_bill_info_yn.value;
		if(show_bill_info_yn=='Y') {
			showBillingTable();
		}	
		<!-- added for IN039607 -->
	</script>
	<script>
		chkCount();
	</script>
	</html>
<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
	/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
	putObjectInBean(bean_id1,bean1,request);
	/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
//	if(function_from.equals("EXTERNAL_ORDER")) {
//		putObjectInBean(existing_bean_id,external_bean_obj,request);
 //	}
}catch(Exception e){
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
%>

