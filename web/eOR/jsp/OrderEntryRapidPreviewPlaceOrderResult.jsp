<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

11/08/2011	  IN00747		 Chowminya											Incident No: IN00747 - <Clinical comments mandatory check in Preview  screen>
08/11/2011	  IN28273		 Dinesh T	 										Added the change event to that control
17/12/2012	  IN036383		Ramesh G											The  Order released from Preview Screen is not getting placed.
13/08/2013	  IN042045		Chowminya G	    									System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
15/10/2013	  IN041155		Karthi L											Preview screen opens and Billing details are displayed
06/05/2014    IN048942		Chowminya      										Performing Location and wing code defaulting issue	
02/07/2014	  IN048467 		Nijitha S											HSA-CRF-0150
26/08/2014    IN050607		Nijitha S											KDAH-SCF-0255	
24/9/2014	  IN051367		Nijitha S											Regression-OP-Transaction â?? Register Visit	
04/12/2014	  IN052765		Vijayakumar K		04/12/2014		Chowminya	ML-BRU-SCF-1489 [IN:052765]From CA, 
29/04/2015	  IN055190		Vijayakumar K	29/04/2015		Dinesh T			KDAH-SCF-0296 [IN:055190] - Wrong order
09/06/2017	  IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]	
03/07/2017	  IN062607		Raja S			03/07/2017		Ramesh G			ML-MMOH-CRF-0727
19/10/2017	IN065324		Dinesh T		19/10/2017		Ramesh G			To display the price in OR screen and the 																					billing status in Manage Specimen screen
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
08/02/2018	IN066436		Raja S				08/02/2018	Ramesh G			SS-SCF-0777
06/07/2018	IN067246		Raja S				06/07/2018	Ramesh G			GHL-CRF-0516
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
09/01/2019  IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
25/06/2020	IN073309	Nijitha S     		25/06/2020		Ramesh G		ML-MMOH-CRF-1229.2/02
07/06/2020  IN072654	Nijitha S     		07/06/2020		Ramesh G		MMS-KH-CRF-0029.4
-------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.*,webbeans.eCommon.*"%><!--IN062607-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<!--IN055190 starts -->
<%! 
	public String getArrayToString(List<String> categorylist)
	{
		StringBuilder sbcategory = new StringBuilder();
		int category_count = 0;
		
		for(String categry:categorylist)
		{
			sbcategory.append("'"+categry+"'");
			if(category_count != categorylist.size() - 1)
			{
				sbcategory.append(",");
			}
			category_count++;
		}
		
		return sbcategory.toString();
	}
%>
<!--IN055190 ends -->
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>	
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- for Tool Tip-->
	<title><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></title>
<style>
TD.PATQRED1 
{
	BACKGROUND-COLOR: #FA8072 ;
	FONT-SIZE: 9pt ;
	/*border-style: dashed;*/
	border-right-width: 0
	border-left-width: 0
	border-right-width: 0
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0 
}
</style>
</head>
<style TYPE="text/css"></style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="ClinicalComment();">
<form name="placeOrderForm" id="placeOrderForm" >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String patient_email_id="";	
	String check="";
	Object patpreps = "IS";
	String patientDischargedYn      = "N";
	boolean is_bt_view_bill_dtls = false;//IN065324
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";
	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	 bean1.setLanguageId(localeName);
	 String practitioner_id = (String)session.getValue("ca_practitioner_id");
	 /*Added by Uma on 9/29/2009 for PMG-CRF-641*/
	 String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	 String PrivilegeApplicabilityAuthYN = "";
	 /* Ends Here*/
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
   	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	//IN055190  starts
	String order_category_list = "";
	HashMap order_categoryvalues = bean.getOrderCategories(previousValues);
	List<String> or_catrgorylist = new ArrayList<String>(order_categoryvalues.values());
   	
	order_category_list = getArrayToString(or_catrgorylist);
	//IN055190 ends
   	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
	if(order_category.equalsIgnoreCase("PH") || order_category.equalsIgnoreCase("CS"))
		order_catalog_code="'"+order_catalog_code+"'";
	String lb_instal_yn				= "N"; 
 	String rd_instal_yn				= "N"; 
  	lb_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N"); // check whether the lb_module is installed or not, used in EJB
	rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	String session_id				= bean.checkForNull(bean.getSessionId(),""); //  used in EJB
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN036383 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN036383 End.
	String p_start_date_time		= bean.checkForNull(request.getParameter("p_start_date_time"),"");
  	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String forceStatus=bean.getForceStatus(practitioner_type,order_category);
	String fStatus[]=forceStatus.split(":");
 	String classValue				= "", chk_class_value = "";
	String existing_bean_id			= "", existing_bean_name="";
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String auth_reqd				= "";
	String cosign_reqd				= "";
   	String special_approval_reqd	= "";
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER

	String l_patient_class = bean.getPatientClass();//IN065324

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
		// Get the External Order Reference Values, to be inserted into the or_order table
	} // End of function-from
	String specialty_code			= "";
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	String dateString				= bean.getSysDate();
	//IN055190 starts
	//ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),"PREVIEW");
	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category_list,""),bean.checkForNull(order_catalog_code,"''"),"PREVIEW");
	//IN055190 ends
	int i							= 0, display_special_count   = 0, hide_count			   = 0;
	int display_auth_count			= 0, format_mandatory_count = 0;
	int format_count 			= 0,	display_cosign_count   = 0;//age_in_days					= 0,"''" 
	int order_cat_count				= 0;
	String preps_instrn 			= "", frequency_val			= "",	qty_value			   = "";
	String preps_dept_instrn		= "", duration_value		= "",   qty_uom				   = "",qty_uom_shortdesc				   = "";
	String pat_preps_instrn			= "", max_durn_value		= "";
	String chk_for_max_durn_action = "";//sex_yn					= "", 
	String format_id				= "", prompt_msg			= "";
	String format_id_mandatory_yn	= "", comments				= "";
	String order_id					= "", order_line_no			= "";
	String entered_yn				= "N", old_order_category   = "" ,order_category_desc = "",clin_category_comments_reqd_yn="",display_style="";
	String order_type_code			= "", order_types_comb		= "", frequency			  = "";
	String sec_start_date_time		= "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;
//	String[] peformingFacility		= null;
//	String[] deptLocation			= null;
	String[] format					= null;
	String[] records				= null; String[] orderTypeRecords =	null;	
	String[] frequencyRecords		= null;	String[] durationRecords = null;	
	String[] secondaryOrders		= new String[2];String[] deptLocation = null;String depLocation_code="";
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N", facility_name	= "";
	String priority_value			= "N";
	ArrayList PlaceOrderType		= null;
	ArrayList PlaceOrderFrequency	= null;
	ArrayList PlaceOrderDuration	= null;
	ArrayList FormatHdr				= null;
	//ArrayList DeptLocationCode		= null; 
	StringTokenizer stFormatID		= null;
	HashMap copyOrderDetails		= null;
	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	ArrayList performingLocationCode = new ArrayList();
	String [] performingLocation = null;
	HashMap instructionsMap = new HashMap();
	patientDischargedYn = (String)bean.getPatientDischarged();
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); //IN041155
	String fac_selected		= "";// IN048942
	//IN062607 Starts
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	String perfLocnMandFlag = "N";//IN066377
	String bt_order_type_code = "";//IN066377
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	String fpp_patient_yn = "";//IN072524
	int drugintercnt = 0;//IN072654
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
	//IN062607 Ends
	
%>
<table width="100%" border="1" cellspacing="0" cellpadding="3" id="detailTab" class="grid">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<%
//function_from = "REPLACE_ADD";
//order_id = "TRIP00000001075";
	if(function_from.equals("REPLACE_ADD") && !order_id.equals("")) 
	{ // If called from 	REPLACE_ADD Orders and order_id is passed, display the old datas
			//AmendPlaceOrderItems		= bean.getAmendPlaceOrdersResult(bean.checkForNull(bean.getOrderId(),""));
%>	<!-- To display the old orderables -->
<%		
	} // End of old orderables
	// New Orders, Painting
	//IN051367 Starts
	String discharge_date_time = "";
	discharge_date_time = bean.getDischargeDateTime(bean.getPatientId(),bean.getEncounterId() );//IN050607
	String ordering_rule_yn = "";
	
	if(!"".equals(discharge_date_time))
	{
		bean.setDischargeDate(discharge_date_time);//IN050607
		ordering_rule_yn = bean.getOrderingRuleYn(order_category);//IN050607
	}
	//IN051367 Ends
	if(PlaceOrderItems!=null)
	{
		for(i=0; i<PlaceOrderItems.size(); i++)
		{
			String billinginterface="";
			String servicepanel="";
			String servicepanelcode="";
			String finbill="";
			String displaytooltip="";
			String locn_appt_reqd_yn="";
			String displays_style1="visibility:hidden";
			String displays_style2="visibility:hidden";
			String speciality_code[]=new String[3];
			ArrayList speciality=new ArrayList();
			int numbering=0;
			int non_billing_numbering=0;//IN072524
			String comment 			  = "";
			String pat_preps_instrns ="";
			String pat_preps_pat_instrns="";
			String pat_preps_dep_instrns="";			
			records =(String[])PlaceOrderItems.get(i); // String array
			comments = ""; pat_preps_instrn	=""; preps_instrn = "";  preps_dept_instrn = "";
			order_type_code = "";format_id_mandatory_yn = "N";	priority_value= "";frequency ="";
			if ( i% 2 == 0 )
			{
				classValue 			= "BODYCOLORFILLED" ;
				chk_class_value		= "BODYCOLORFILLED" ;
			}
			else
			{
				classValue		 	= "BODYCOLORFILLED" ;
				chk_class_value		= "BODYCOLORFILLED" ;
			}
			if(records[51].equalsIgnoreCase("Y"))
				chk_class_value		= "eORConsent" ;
			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			if(function_from.equals("COPY_ORDER"))
			{
				copyOrderDetails	 = bean.getCopyOrderIDDetails(); // Get the Order Id and order_line
				if(copyOrderDetails!=null)
				{
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
				Default = bean.getPlaceOrderDefault(records[0]);
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
				if(recordDefault!=null)
				{
					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
					if(qty_value.equals("0")) qty_value = "1";
					qty_uom			 =  bean.checkForNull(recordDefault[9],"");
					qty_uom_shortdesc			 =  bean.checkForNull(recordDefault[10],"");
				}
				else
				{
					qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
				}
			}
			// Till Here
			if(!records[3].equals("") && !old_order_category.equals(records[3]))
			{
				display_auth_count  = 0; display_cosign_count = 0; display_special_count=0;
				order_category_desc = bean.checkForNull((String)beanQueryObj.getOrderCategoryDesc(properties, records[3]),""); // Pass the Order Category
				clin_category_comments_reqd_yn = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, records[3]),"N"); // Pass the Order Category
				// Get the Format Id Logic
				order_types_comb		=
					bean.checkForNull(bean.getOrderTypes(previousValues),"");  
				//auth_reqd				= bean.getAccessReqd(records[3],"auth_yn");	// (order_category & auth_yn) Column Name. auth_yn is passed
 				cosign_reqd				= bean.getAccessReqd(records[3],"cosign_yn");	// (order_category & auth_yn) Column Name. auth_yn is passed
				/*if(fStatus[0].equals("Y"))
				auth_reqd="X";
				if(fStatus[1].equals("Y"))
				cosign_reqd="X";*/
				special_approval_reqd	= bean.getAccessReqd(records[3],"ord_spl_appr_reqd_yn");	// Column Name. auth_yn is passed
				// Get the Format Id for the Header
				format_id				= bean.checkForNull(bean.getFormatIdHdr(records[3], order_types_comb,bean.getSex(), bean.getDob()),""); //order_category
				FormatHdr				= beanQueryObj.getFormatID_YN(format_id);
				for(int j=0; j<FormatHdr.size(); j++)
				{
					format				   = (String[]) FormatHdr.get(j);
					format_id_mandatory_yn = bean.checkForNull(format[0], "");		
					format_id			   = bean.checkForNull(format[1], "");
				} 
				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
				{
					out.println("<input type='hidden' name='format_id_yn"+order_cat_count+"' id='format_id_yn"+order_cat_count+"' value='N'>");
				}
				else
				{
					out.println("<input type='hidden' name='format_id_yn"+order_cat_count+"' id='format_id_yn"+order_cat_count+"' value='Y'>");
				}
				%>
				<input type="hidden" name="hdr_format_id_mandatory_yn<%=order_cat_count%>" id="hdr_format_id_mandatory_yn<%=order_cat_count%>" value="<%=format_id_mandatory_yn%>" >
				<input type="hidden" name="hdr_care_set_order_category<%=order_cat_count%>" id="hdr_care_set_order_category<%=order_cat_count%>" value="<%=records[3]%>" >
				<input type="hidden" name="hdr_order_catalog_code<%=order_cat_count%>" id="hdr_order_catalog_code<%=order_cat_count%>" value="<%=records[0]%>" >
				<input type="hidden" name="hdr_format_id<%=order_cat_count%>" id="hdr_format_id<%=order_cat_count%>" value="<%=format_id%>" >
				<input type="hidden" name="care_set_order_category<%=order_cat_count%>" id="care_set_order_category<%=order_cat_count%>" value="<%=records[3]%>"><!--For Care Sets & PREVIEW-->
				<!--<input type="hidden" name="clin_category_comments_reqd_yn" id="clin_category_comments_reqd_yn" value="<%=clin_category_comments_reqd_yn%>"> --> <!-- IN00747 -->
				<!--<input type="hidden" name="clin_cmts_reqd_yn" id="clin_cmts_reqd_yn" value="N"> <!-- IN00747 -->
				<input type="hidden" name="clin_category_comments_reqd_yn<%=records[3]%>" id="clin_category_comments_reqd_yn<%=records[3]%>" value="<%=clin_category_comments_reqd_yn%>"><!--For Category Level Clinical Comments-->
				<tr id="<%=records[3]%>">
					<td align="" colspan="3" class="PATQRED1" style="border-width:0"><div align='left'>
					<%				
					if(!format_id.equals("")) 
					{
					%>
						<a class='gridLink'  href='javascript:orderFormatForPreviewHeader("<%=format_id%>","<%=records[3]%>","<%=records[0]%>",<%=order_cat_count%>,"")' title='Order Format'>
						<%
							if(format_id_mandatory_yn.equals("Y"))
								out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
							else
								out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
					} // End of if !format_id	
					%>
					<b><font size="2"><%=order_category_desc%></font></b></div></td>
					<td align="right"  colspan="2" class="PATQRED1" style="border-width:0" nowrap>
						<font size="1">
							<input type="hidden" name="clinical_comments<%=records[3]%>" id="clinical_comments<%=records[3]%>" value="">
								<a class='gridLink' href='javascript:DisplayClinicalComments("clinical_comments<%=records[3]%>","CLINICAL","<%=records[3]%>","N")' title='Clinical Comments' nowrap><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a> <!-- Modified [IN0747] -->
						</font>
						<%
						if(clin_category_comments_reqd_yn.equalsIgnoreCase("Y"))
						{
							display_style="visibility:visible";
						}
						else
						{
							display_style="visibility:hidden";
						}
						%>
						<label  id="cl_cmt_mand<%=records[3]%>" Title="Clinical Comment"  style="<%=display_style%>"><img src="../../eCommon/images/mandatory.gif"></img></label> 
					</td>
					<td align="left"   colspan="3" class="PATQRED1" style="border-width:0"><font size="1"><!-- Header Format Items -->&nbsp;
					</font>
					</td>					
				<%		

						if(records[48].equalsIgnoreCase("Y"))
						{
							PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth); 
							
					
							if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
							{
								displays_style1="display:inline";
								displays_style2="display:none";
							}else{
								displays_style1="display:none";
								displays_style2="display:inline";
							}
						}

					/*	if(!auth_reqd.equalsIgnoreCase("X")) 
						{ 
							displays_style1="visibility:visible";
							displays_style2="visibility:hidden";
						} 
						else 
						{
							displays_style1="visibility:hidden";
							displays_style2="visibility:visible";
						}	 */
				%>

					<td id="hdg<%=records[3]%><%=order_cat_count%>"  align="left" class="PATQRED1" style="border-width:0" nowrap>
<%				if(!PrivilegeApplicabilityAuthYN.equalsIgnoreCase("Y") || !cosign_reqd.equalsIgnoreCase("X")||			!special_approval_reqd.equalsIgnoreCase("X")) 
					{
						out.println("&nbsp;"); 
					}
					else
					{ 						out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PressLinkto.label","or_labels")+"</b>"); 
					}
					%>
				</td>

					<td id="imageId<%=records[3]%><%=order_cat_count%>"  align="left" class="PATQRED1" style="border-width:0;"><%out.println("<img id=\"textimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/Authorization.gif\" align=\"right\" style=\""+displays_style2+"\"> ");%></td>
  					<td id="authorizedId<%=records[3]%><%=order_cat_count%>" align="left" class="PATQRED1" style="border-width:0">
					
				<label  id="auths"  style="<%=displays_style2%>">
					<a class='gridLink' href='javascript:CheckMultipleAuth("<%=records[3]%>","X")' title='Authorize'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></a></label><label  id="auth"  style="display:none">
					<%							out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");
					%>
				</label>
					<input type="hidden" name="auth_reqd<%=records[3]%><%=order_cat_count%>" id="auth_reqd<%=records[3]%><%=order_cat_count%>" value="X">
				</td>
				  <td id="imageCosignId<%=records[3]%><%=order_cat_count%>" class="PATQRED1" style="border-width:0" align="left"><%out.println("<img id=\"textcosignimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/Cosign_click.gif\" align=\"right\"> ");%></td>
		 		  <td id="cosignId<%=records[3]%><%=order_cat_count%>" class="PATQRED1" style="border-width:0" align="left">
					<%
					 if(!cosign_reqd.equalsIgnoreCase("X")) 
					 {
						out.println("&nbsp;Cosign Reqd");
					} 
					else 
					{
					%>	
					<a class='gridLink' href='javascript:CheckMultipleCosign("<%=records[3]%>","<%=cosign_reqd%>")' title='Cosign'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></a>
				<% 
				} 
				%>
 				<input type="hidden" name="cosign_reqd<%=records[3]%><%=order_cat_count%>" id="cosign_reqd<%=records[3]%><%=order_cat_count%>" value="<%=cosign_reqd%>">
				</td>
 				<td id="imageSpecialId<%=records[3]%><%=order_cat_count%>" class="PATQRED1" style="border-width:0" align="left"><%out.println("<img id=\"textspecialimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"right\"> ");%></td>
  				<td  colspan="3"      id="specialId<%=records[3]%><%=order_cat_count%>" class="PATQRED1" style="border-width:0" align="left" nowrap>&nbsp;
					<%
					if(!special_approval_reqd.equalsIgnoreCase("X")) 
					{
						out.println("&nbsp;Special Approval Reqd");
					} 
					else 
					{
					%>					
						<a class='gridLink'  href='javascript:CheckMultipleSpecialApproval("<%=records[3]%>","<%=special_approval_reqd%>")' title='Special Approval'><fmt:message key="Common.SpecialApproval.label" bundle="${common_labels}"/></a>
					<% 			
					}	
					%>
					<input type="hidden" name="special_approval_reqd<%=records[3]%><%=order_cat_count%>" id="special_approval_reqd<%=records[3]%><%=order_cat_count%>" value="<%=special_approval_reqd%>">
					<input type="hidden" name="care_set_authorized<%=records[3]%><%=order_cat_count%>" id="care_set_authorized<%=records[3]%><%=order_cat_count%>" value="false">  
					<input type="hidden" name="multiple_cosigned<%=records[3]%><%=order_cat_count%>" id="multiple_cosigned<%=records[3]%><%=order_cat_count%>" value="false">  
					<input type="hidden" name="multiple_special_approved<%=records[3]%><%=order_cat_count%>" id="multiple_special_approved<%=records[3]%><%=order_cat_count%>" value="false"> 
				</td>
				</tr>
				<tr id="head<%=records[3]%>">
					<th nowrap>&nbsp;</th>
					<th nowrap><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
					<th colspan="2" nowrap><fmt:message key="Common.duration.label" bundle="${common_labels}"/></th>
					<th nowrap>&nbsp;</th>
					<th nowrap ><a class="gridLink" href="#" onClick="changeAllStartDateTime()" title="Do u want to change all the Start Date Time, Click here"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></a></th>
					<th nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
					<th colspan="3" nowrap><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></th><!-- IN066377 -->
					<th colspan="4" nowrap>&nbsp;</th>					
				</tr>
<%			
			hide_count = order_cat_count; //use to hide the gifs authorize,cosign
			order_cat_count++; // Increment the order_category count 
		} // End of old_order_category
%>
			<tr id="row<%=records[0]%>" >
				<td id="billing<%=i%>" class="<%=chk_class_value%>" align="center" nowrap><font size="1"><input type="checkbox" name="ck<%=records[0]%>" id="ck<%=records[0]%>" value="Y" checked onClick="setCheckValue(this,'<%=records[0]%>','<%=i%>')"></font>
		      <%  //added on 08/05/07		  
				if(records[51].equalsIgnoreCase("Y"))
				{
				%>
					<input class="button" type="button" name="consent_id_lookup<%=i%>" id="consent_id_lookup<%=i%>" title='Consent Required' value="C" onClick="callMultipleConsent('<%=records[0]%>','<%=records[1]%>','','','<%=order_category%>','<%=i%>')">
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
									total_recs = total_recs ++;
								}
								%>							
								<input type="hidden" value='<%=multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")%>' name="consent_stages<%=i%>0">	
								<input type="hidden" value="Y" name="consent_chk<%=i%>0" id="consent_chk<%=i%>0">
								<input type='hidden' value="<%=multiConsentDtls[3]%>" name="consent_form_id<%=i%>0">							
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
				}//ends here
				%>
				<input type="hidden" name="h1<%=records[0]%>" id="h1<%=records[0]%>" value="<%=records[3]%>"><input type="hidden" name="h2<%=records[0]%>" id="h2<%=records[0]%>" value="<%=records[4]%>">
				<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=records[0]%>">
		<!--<input type="hidden" id ="start_date_time_id<%=i%>"  name="start_date_time<%=i%>" value="<%=dateString%>">-->
				</td>
				<td id="billing1<%=i%>" class="<%=classValue%>"  align="right" nowrap onMouseOver='showToolTip("<%=records[0]%>","placeOrderForm")' onMouseOut="hideToolTip()"><font size="1">
				<%=records[1]%>
				 <%
				  if(!bean.checkForNull(records[62],"").equals("")) 
				{
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}							speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);	
				if(speciality.size()>0)
				{
					for(int sc=0;sc<speciality.size();sc++)
					{
							speciality_code=(String[])speciality.get(sc);
					}
				}
				if(speciality_code[0].equalsIgnoreCase("Y"))
				{
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y"))// For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						%>	
					&nbsp;<img id='authorization<%=records[3]%><%=i%>' src="../../eOR/images/Authorization.gif" align="center"></img>
				<%
					}
				}
				else
			   {
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y"))// For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						%>	
						&nbsp;<img id='authorization<%=i%>' src="../../eOR/images/Authorization.gif" align="center"></img>
						<%
					}
			   }				
				if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y")) // For Cosign Required
				{
				    display_cosign_count++; 
					records[49]="Y";
					//id='cosign"+i+"' 
				%>
				&nbsp;
					<img id="cosign<%=records[3]%><%=i%>" src="../../eOR/images/Cosign_click.gif" align="center"></img>
				<%
				}
				if(records[50].equalsIgnoreCase("Y")) // For Special Approval
				{
				    display_special_count++;
					%>
					&nbsp;<img id="special_approval<%=records[3]%><%=i%>" src="../../eOR/images/SpecialApproval.gif" align="center"></img>
				<%
				}
				%>
				</font><input type="hidden" name="cat_desc<%=i%>" id="cat_desc<%=i%>" value="<%=records[1]%>"><input type="hidden" name="type_desc<%=i%>" id="type_desc<%=i%>" value=""></td>
				<td id="billing2<%=i%>" class="<%=classValue%>" align="right" nowrap><font size="1">
				<%
					PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(((String)previousValues.get("h2"+records[0])).equals(orderTypeRecords[0]))
						{
							order_type_code = orderTypeRecords[0];
							out.println(orderTypeRecords[1]);
							break; //come out of the loop;
						}
						else
						{
							order_type_code = orderTypeRecords[0];
							out.println(orderTypeRecords[1]); // otherwise last one
						}
					}
					%>
					</font>
				<input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value= "<%=order_type_code%>">
				<input type="hidden" name="order_type<%=i%>" id="order_type<%=i%>" value= "<%=order_type_code%>">
				<%
				if ( !((records[52]).equals("3")) && priority_value.equals("")) 
				{ 
					priority_value = "R";
				} 
				else if (priority_value.equals("") && ( ((records[52]).equals("")) || ((records[52]).equals("2"))) )
				{  
					priority_value = "U";
				} 
				else if(priority_value.equals("") && (((records[52]).equals("")) || ((records[52]).equals("3"))) ) 
				{
					priority_value = "S";
				} 
				else priority_value  = "R";
				// If it is called from MO module then it will be of Urgent priority
				if(function_from.equals("MO")) 
				{ 
					priority_value  = "U";
				}
				%>
				</td>
					<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=priority_value%>">
					<input type="hidden" name="priority_appl<%=i%>" id="priority_appl<%=i%>" value="<%=records[52]%>">
				<td  class="<%=classValue%>" align="right" nowrap id="priority_id<%=i%>"><font size="1">
					<%
					if ( priority_value.equalsIgnoreCase("R")) 
					{ 
					%>
						<a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>','<%=records[0]%>')" <%} %> title="Routine"><b><fmt:message key="Common.routine.label" bundle="${common_labels}"/></b>
					<%
					} 
					else if(priority_value.equalsIgnoreCase("U")) 
					{ 
					%>
						<a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>')" <%} %>  title="Urgent"><b><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></b>
					<%
					} 
					else if(priority_value.equalsIgnoreCase("S")) 
					{ 
					%>
						 <a class="gridLink" href="#" <% if(!records[3].equals("OT")){ %> onClick="javascript:return changePriorityLineLevel('<%=i%>')" <%} %>  title="Stat"><b><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></b>
					<%
					}   
					%>
				</td>
				<td id="billing4<%=i%>" class="<%=classValue%>" nowrap><font size="1">
					<%
					if(!records[10].equalsIgnoreCase("N")) 
					{	
					%>
						<a class="gridLink" href="#" onClick="javascript:changeValue('P','quantity<%=i%>',<%=i%>)" title="Quantity"><b><</b></a>
					<%
					}
					%>	
					<input type="text" style="text-align:'right'" name="quantity<%=i%>" id="quantity<%=i%>" value="<%=qty_value%>" size="2" maxLength="6" onKeyPress="return(ChkNumberInput(this,event,'2'))" onBlur="checkValidNumber('',this)" onchange="reviseBillingchrgs('<%=i%>','OP_NEW_ORDER')" <% if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); %>>&nbsp;<!--IN28273-->
				<% if (qty_uom.equals("")) 
						{
							out.println(records[68]);
						}
						else
						{			
							out.println(qty_uom_shortdesc);
						}
				%>
				<%
					if(!records[10].equalsIgnoreCase("N")) 
					{  
					%>
						<a class="gridLink" href="#" onClick="javascript:changeValue('N','quantity<%=i%>',<%=i%>)" title="Quantity"><b>></b></a>
					<%
					} 
					%></font>
				</td>
				<td class="<%=classValue%>" align="right" id="frequency_id<%=i%>" nowrap><font size="1">
					
					<%
					if(patientDischargedYn.equalsIgnoreCase("N"))
					{
					%>
						<font size="1">
						<a class="gridLink" href="#" onClick="javascript:changeRapidFrequency('<%=i%>','<%=records[0]%>','<%=records[3]%>','<%=bean.getLoginFacilityId()%>')" title="Frequency"> 
						<%		
						PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","",""); // Pass the Order_category and catalog_code
						entered_yn			= "N";
						for(int j=0; j<PlaceOrderFrequency.size(); j++)
						{
							frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
							if(recordDefault!=null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2])) 
							{
								out.println(frequencyRecords[1]);
								entered_yn = "Y";
								frequency = bean.checkForNull(frequencyRecords[0]);
								break; // come out of the loop
							} // End of If
						} // End of For
						if(PlaceOrderFrequency.size()<=0 || entered_yn.equals("N") )						out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
						%>
						</a></font>
					<%
					}
					%>
				</td>
				<td id="billing6<%=i%>" class="<%=classValue%>" nowrap>
					<%
					if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
					if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
					if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
					if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
					if(recordDefault!=null && !recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("N")) 
					{ 
					%>
						<a class="gridLink" href="#" onClick="javascript:changeValue('P','duration_value<%=i%>',<%=i%>)" title="Duration"><b><</b></a>
					<%
					} 
					if(patientDischargedYn.equalsIgnoreCase("N"))
					{
					%>
					<input type="text" class="NUMBER" name="duration_value<%=i%>" id="duration_value<%=i%>" value="<%=duration_value%>" size="2" maxLength="3" onKeyPress="return(ChkNumberInput(this,event,'0'))" onBlur='checkMaxValue(this,"<%=max_durn_value%>","<%=chk_for_max_durn_action%>",escape("<%=prompt_msg%>"),"<%=records[19]%>","<%=i%>")'  <%if(recordDefault!=null && recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("Y")) out.println("readOnly");%>>
					<%
					}
					else
					{
					%>
						<input type="text" class="NUMBER" name="duration_value<%=i%>" id="duration_value<%=i%>" value="<%=duration_value%>" size="2" maxLength="3" disabled>
					<%
					}
					if(recordDefault!=null && !recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("N")) 
					{ 
					%>
						<a class="gridLink" href="#" onClick="javascript:changeValue('N','duration_value<%=i%>',<%=i%>)" title="Duration"> 
						<b> > </b></a>
					<%
					} 
					%>
					<input type="hidden" class="NUMBER" name="duration_def_value<%=i%>" id="duration_def_value<%=i%>" value="<%=duration_value%>">
				</td>
				<td class="<%=classValue%>"  align="right" id="duration_code_id<%=i%>" nowrap><font size="1">
				<%
					PlaceOrderDuration = bean.getPlaceOrderDuration();					
					for(int j=0; j<PlaceOrderDuration.size(); j++)
					{
						durationRecords = (String[]) PlaceOrderDuration.get(j);
						if(recordDefault!=null && recordDefault[4].equalsIgnoreCase(durationRecords[0])) {
							out.println(durationRecords[1]);
							break; // come out of the loop
						}
					} // End of for
					%>
					</font>
				</td>
					<input type="hidden" name="duration_code<%=i%>" id="duration_code<%=i%>" <%if(PlaceOrderDuration.size()>0) { %> value="<%=durationRecords[0]%>" <%} else { %> value="" <% } %> > 
					<input type="hidden" name="duration<%=i%>" id="duration<%=i%>" value="">
				<td class="<%=classValue%>" align="right" id="schedule<%=i%>" nowrap>&nbsp;</font></td>
					<td id="billing12<%=i%>" class="<%=classValue%>" align="right" nowrap> <input type="text" id ="start_date_time_id<%=i%>"  name="start_date_time<%=i%>" onkeyDown='chkBackSpace();'  value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>" size="14" maxLength="16" onBlur="checkStartDateTim(this,<%=i%>,'<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)%>','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('start_date_time_id<%=i%>',null,'hh:mm','','');" style='cursor:pointer'> 					 
				<!--<td class="<%=classValue%>" align="right" id="start_date_time_href_id<%=i%>" nowrap>&nbsp;<font size="1"><a href="#" onClick="javascript:return changeLineLevelDateTime('start_date_time_id<%=i%>','<%=i%>')" title="StartDateTime"><%=dateString%></a></font>-->
				</td>
				<td id="billing9<%=i%>" class="<%=classValue%>" align="left" nowrap><input type="text" name="end_date_time<%=i%>" id="end_date_time<%=i%>" size="14" maxLength="16" value="" readOnly></td>
				<td id="billing10<%=i%>" class="<%=classValue%>" align="right" nowrap>&nbsp;<font size="1">
				&nbsp;
				<%//if(records[3]!=null && ((records[3].equals("LB") && lb_instal_yn.equals("Y")) || (records[3].equals("RD") && rd_instal_yn.equals("Y")) || (!records[3].equals("NC")) ) ) {	changed on 7/9/2007 for lb_instal_yn by uma 			
				if((records[3].equals("LB") )|| (records[3].equals("RD")) || (records[3].equals("RX"))||(records[3].equals("TR")) ) 
				{ 
				%>
					<!--<select name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" onchange='clearDepLocn("<%=i%>","<%=records[0]%>","<%=order_category%>","<%=orderTypeRecords[0]%>","<%=rd_instal_yn%>",this);setPerformingFacility("performing_facility_id<%=records[0]%>",this);'>-->
					<select name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" onchange='clearDepLocn("<%=i%>","<%=records[0]%>","<%=records[3]%>","<%=orderTypeRecords[0]%>","<%=rd_instal_yn%>",this);setPerformingFacility("performing_facility_id<%=records[0]%>",this);'><!-- IN048942 -->
					<%					
					performingLocationCode = bean.getPerformingLocation(records[3],((String)previousValues.get("h2"+records[0])),records[0]);	
					if(bean.getTempvalue("performing_facility_id"+records[0])==null)
					{
						for(int j=0; j<performingLocationCode.size(); j++)
						{
							performingLocation	= (String[]) performingLocationCode.get(j);
							//IN048942 - for preview screen performing location issue - Start		
							if(j==0)
								fac_selected = performingLocation[0];
							//if(performingLocation[0].equals(records[5])) //let the last one be selected
							if(performingLocation[0].equals(login_facility_id))//IN048942 - for preview screen performing location issue -End
							{
								out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
								fac_selected = performingLocation[0]; //IN048942 - for preview screen performing location issue
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
							//IN048942 - for preview screen performing location issue - Start	
							if(j==0)
								fac_selected = performingLocation[0];	
							//if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
							if(performingLocation[0].equals(login_facility_id))//IN048942 - for preview screen performing location issue - End
							{
								out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
								fac_selected = performingLocation[0]; //IN048942 - for preview screen performing location issue
							}
							else
							{
								out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
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
					<font size="1"><b><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/>&nbsp;:</b>
					<%				
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
					%>
 					<%=facility_name%></font>/
					<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=records[5]%>">
				<%
				}
				%>
				</td>
				<%
				if((records[3].equals("LB") )|| (records[3].equals("RD")) || (records[3].equals("RX"))||(records[3].equals("TR")) ||(records[3].equals("MI"))||(records[3].equals("PC"))) 
				{ 		
				%>
				<td class="<%=classValue%>" align="right" id="performing_dept_loc_code_id<%=i%>" nowrap><font size="1">
				<!-- <a href="#" onClick="javascript:changePerformingDeptLoc('<%=i%>','<%=records[5]%>','<%=records[0]%>','<%=records[3]%>','<%=lb_instal_yn%>','<%=rd_instal_yn%>')">changed on 7/9/2007 for lb_instal_yn by uma   -->
					<a class="gridLink" href="#" onClick="javascript:changePerformingDeptLoc('<%=i%>','<%=fac_selected%>','<%=records[0]%>','<%=records[3]%>','<%=orderTypeRecords[0]%>','<%=rd_instal_yn%>')"> 
<%					//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], 					records[0],records[3],lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma
					//IN048942 - Modified Start
					//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], 					records[0],records[3],orderTypeRecords[0],rd_instal_yn);
					ArrayList DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],records[3],orderTypeRecords[0],rd_instal_yn);
					String def_yn = "N"; 
					//IN048942 - Modified End
						if(DeptLocationCode.size()>0)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								if(deptLocation[2] != null && deptLocation[2].equals("Y"))
								{  
									out.println(""+deptLocation[1]+"");
									depLocation_code = deptLocation[0];									
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],depLocation_code);
									def_yn = "Y"; //IN048942
									break;
								}
								//Commentted IN048942
								/*else
								{
									out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
									depLocation_code = "";
									break;
								}*/
							}
							//IN048942 - Added Start
							if("N".equals(def_yn)) 
							{		out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
								depLocation_code = "";
							}
							//IN048942 Added End
						}
						else
						{	out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						//IN052765 starts
							if(!depLocation_code.equals(""))
								depLocation_code = "";		
						//IN052765 ends
						}
				}   // End of records[3] (order_category) and lb_install
				else
				{
					%>
					</td>
					<td class="<%=classValue%>" align="right" id="performing_dept_loc_code_id<%=i%>" nowrap><font size="1">
				<%
				}
				%>
					</a></font>
				</td>
				<%
				try
	{
		con				=	ConnectionManager.getConnection(request);
	//IN066377 start
		String sql = "select * from OR_ORDER_PERF_LOCN_MAND where order_category=?";
		pstmt = con.prepareStatement(sql);
		//pstmt.setString(1,order_category);
		pstmt.setString(1,records[3]);
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

	}%>
				
				<!-- IN066377 start -->
				<%if(("RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && "Y".equals(rd_instal_yn)){%>
				<td style="border: none;">
						<img src="../../eCommon/images/mandatory.gif">
				</td>
				<%}%>
				<%if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && !(records[4]).equals(bt_order_type_code)){%>
				<td style="border: none;">
						<img src="../../eCommon/images/mandatory.gif">
				</td>
				<%}%>
				<!-- IN066377 end -->
					<input type="hidden" name="performing_dept_loc_code<%=i%>" id="performing_dept_loc_code<%=i%>" value="<%=depLocation_code%>"> 
					<%
					// Line Level check			
					format_id = bean.checkForNull(records[47],"");
					if(!records[47].trim().equals(""))
					{
						stFormatID 	= new StringTokenizer(records[47],"~");
						while(stFormatID.hasMoreTokens())
						{
							format_id_mandatory_yn  = stFormatID.nextToken();
							format_id 				= stFormatID.nextToken();
						}
						stFormatID	= null;
					}
					%>		
				<input type="hidden" name="format_id<%=i%>" id="format_id<%=i%>" value="<%=format_id%>"><!--Added for IN066436-->
				<input type="hidden" name="format_id_val<%=i%>" id="format_id_val<%=i%>" value="<%=format_id%>">
				<td class="<%=classValue%>" align="right" id="order<%=i%>" nowrap><font size="1"> &nbsp;
				<%
				secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class			
				if (bean.checkForNull((String)secondaryOrders[0]).equals("Y"))
				{     
					 sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""); // Pass the catalog_code, prioriy (default as "R") and patient_class
					 sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);
					%>
					<Script>
						document.getElementById('start_date_time')<%=i%>.value = '<%=sec_start_date_time%>';
					</Script>
				<a class="gridLink" href="javascript:viewSecondaryOrders('<%=i%>','<%=bean.getPatientClass()%>')"> <img src="../../eOR/images/SecondaryOrder.gif" border="0"  title="Secondary Orders Exists"></img>&nbsp;</a>
<%				} %>
<%
				if(!format_id.equals(""))  // check for the Format
				{
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean
						format_mandatory_count++;
					}
					else
					{
						//out.println("<script>setOrderFormatLine('"+i+"','Y')</script>");
	 	    			format_count++;
		 	   		} // else of format_id_mandatory_yn
		 	   	}
%>
				<input type="hidden" name="sec_tasks_type<%=i%>" id="sec_tasks_type<%=i%>" value="<%=secondaryOrders[1]%>"> <!--Keep the Seconday order catalog_type -->
				<input type="hidden" name="format_id_mandatory_yn<%=i%>" id="format_id_mandatory_yn<%=i%>" value="<%=format_id_mandatory_yn%>"> <!--IN069657-->
				</td>
				<td class="<%=classValue%>"    align="right" id="order1<%=i%>" >
<%
				boolean show_bill_dtls = false;//IN065324

				//IN065324, starts
				if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && "OP".equals(l_patient_class) || "EM".equals(l_patient_class) || !"BT".equals(records[43].trim()))
				{
					show_bill_dtls = true;
				}
				//IN065324, ends

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN072524 Starts
					fpp_patient_yn = bean.getFpp_patient_yn();
					if("Y".equals(fpp_patient_yn) && "Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],records[75]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN072524 Ends
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
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);//IN073309
							setBills_dtls.put("fpp_category"		 , records[75]);//IN073309
							 //out.println(billing_details[9]);
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");
							orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							if(!billing_details[9].equals(""))
							{numbering=1;finbill="Billing";%>

								 <script>alert("<%=billing_details[9]%>;");billchecking("<%=records[0]%>");displaycolor("<%=i%>");</script>

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
						billchecking("<%=records[0]%>");displaycolor("<%=i%>");</script>
							<% displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
							displaytooltip=displaytooltip.replace("{1}",records[0]);
							}}
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
											}//else
											//{
												//	hashEntry.remove(entryValue);
											//}
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

						//}
					//}
				
				
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
				
			
%>
					<!--  <table cellpadding=3 cellspacing=0 border=0 width='100%' align='center' style='border-width:0'> --> <!--  commented for IN041155 -->
					<table cellpadding=3 cellspacing=0 border=0 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%>><!--  modified for IN041155 -->
						<!--IN072524 Starts-->
						<%if("Y".equals(fpp_patient_yn)){//IN073309 %>
						<tr>
						<input type="hidden" name="fpp_yn<%=i%>" id="fpp_yn<%=i%>"  value="<%=records[74]%>" >
						<td rowspan="2" colspan="" width='50%' class="<%=classValue%>" style='border-width:1;' nowrap ><font size="1" class='label'>&nbsp;<B><fmt:message key="eOR.FPPCATEGORY.label" bundle="${common_labels}"/>:</B></font>
						
								<select name="fpp_category<%=i%>" id="fpp_category<%=i%>"  onchange="reviseBillingchrgs('<%=i%>','NEW_ORDER')" >
									<option value="S" <%="S".equals(records[75])?"selected":""%>><fmt:message key="eOR.Simple.label" bundle="${common_labels}"/></option><!--IN068314 -->
									<option value="M" <%="M".equals(records[75])?"selected":""%>><fmt:message key="eOR.Medium.label" bundle="${common_labels}"/></option><!--IN068314 -->
									<option value="C" <%="C".equals(records[75])?"selected":""%>><fmt:message key="eOR.Complex.label" bundle="${common_labels}"/></option><!--IN068314 -->
								</select>
							
						</td>
						</tr>
						<%}//IN073309 %>
						<!--IN072524 Ends-->
						<tr >	
							<td  colspan="" width='30%' class="<%=classValue%>" style='border-width: 1;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>: </B></font></td>
							<td colspan="" width='30%' class="<%=classValue%>" style='border-width: 1;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/> </B></font></td>
							<td colspan="" width='30%' class="<%=classValue%>" style='border-width: 1;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/> </B></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" width='35%' class="<%=classValue%>" style='border-width: 1;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/> </B></font></td>
								<td colspan="" width='35%' class="<%=classValue%>" style='border-width: 1;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/> </B></font></td>
							<%
							}
							%>
						</tr>
							<tr>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'  nowrap><font class='fields' size="1"><span id='bill_now_<%=i%>' style='visibility:<%=(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden")%>'><fmt:message key="eOR.BillLater.label" bundle="${or_labels}"/><input type="checkbox" name='bill_now_check<%=i%>' id='bill_now_check<%=i%>' value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>" <%=(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")%> onclick="changeBillNow(this,'<%=i%>')" ></span></font><%if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){%>(<fmt:message key="eOR.ApptRequired.label" bundle="${or_labels}"/>)<%}%></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
							<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
							<%
							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")%></span></font></td>
								<td colspan="" class="<%=classValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font></td> 
							<%
							}
							%>
						</tr>
								<input type="hidden" name="bill_now<%=i%>" id="bill_now<%=i%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
							   <input type="hidden" name="bill_now_check_Df<%=i%>" id="bill_now_check_Df<%=i%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
								<input type="hidden" name="future_date<%=i%>" id="future_date<%=i%>"  value="<%=billing_details[18]%>" >
								<input type="hidden" name="round_off_start_time<%=i%>" id="round_off_start_time<%=i%>"  value="<%=billing_details[19]%>" >
					</table>
				<!--
                 	<a href="javascript:callBilling('<%=i%>','NEW_ORDER')" title='Charge Details'><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></a>	  -->
<%				} else {billing_call_yn = "N"; 
					       out.println("&nbsp;");}

				//IN072654 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
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
				}
				//IN072654 ENDS
					%>
						</td><%if(numbering==0)
					{%>
					<td class="<%=classValue%>" id="order2<%=i%>" style="border-left-width:0;text-align: center;" nowrap><font size="1">
<%
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billing_call_yn		= "Y";
					//if(numbering==0)
					//{
%>
					<a class="gridLink"  href="javascript:callReviseBilling('<%=i%>','NEW_ORDER','<%=bean.getPatientId()%>','<%=bean.getEncounterId()%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','','')" title='Charge Details'><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> 
				<!--	 <a href="javascript:callBilling('<%=i%>','NEW_ORDER')" title='Charge Details'>  --> <!-- <fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>  View / Edit --></a>

<%				} else billing_call_yn = "N"; %>
</td><%}else{%><td style="background=#FF7DD0;"></td><%}%>
				</font>				
				<%
				/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
				if(records[48].equalsIgnoreCase("Y"))
				{
					PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth); 
					
			
					if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
					{
						numbering=1;		
						non_billing_numbering=1;//IN072524
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
					non_billing_numbering=1;//IN072524
					billinginterface = "operational_interface";
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
						non_billing_numbering=1;//IN072524
						billinginterface="or_ordering_rule_chk";
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
					/*Ends Here*/
				%>
					<input type="hidden" name="temp_frequency_code<%=i%>" id="temp_frequency_code<%=i%>" value="<%=frequency%>"><!-- on Load -->
					<input type="hidden" name="frequency_code<%=i%>" id="frequency_code<%=i%>" value="">
					<input type="hidden" name="frequency_val<%=i%>" id="frequency_val<%=i%>" value="<%=frequency_val%>">
					<input type="hidden" name="schedule_yn<%=i%>" id="schedule_yn<%=i%>" value="N" >
					<input type="hidden" name="schedule_mandatorily_yn<%=i%>" id="schedule_mandatorily_yn<%=i%>" value="N" >
					<input type="hidden" name="freq_nature<%=i%>" id="freq_nature<%=i%>" value="F" >
					<input type="hidden" name="repeat_value<%=i%>" id="repeat_value<%=i%>" value="" >
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
					<input type="hidden" name="routine_appt_reqd_yn<%=i%>" id="routine_appt_reqd_yn<%=i%>" value="<%=records[55]%>">
					<input type="hidden" name="stat_appt_reqd_yn<%=i%>" id="stat_appt_reqd_yn<%=i%>" value="<%=records[56]%>">
					<input type="hidden" name="urgent_appt_reqd_yn<%=i%>" id="urgent_appt_reqd_yn<%=i%>" value="<%=records[57]%>">
					<input type="hidden" name="routine_chk_for_dupl_yn<%=i%>" id="routine_chk_for_dupl_yn<%=i%>" value="<%=records[58]%>">
					<input type="hidden" name="urgent_chk_for_dupl_yn<%=i%>" id="urgent_chk_for_dupl_yn<%=i%>" value="<%=records[59]%>">
					<input type="hidden" name="stat_chk_for_dupl_yn<%=i%>" id="stat_chk_for_dupl_yn<%=i%>" value="<%=records[60]%>">
					<input type="hidden" name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=records[61]%>">
					<!--added on 08/05/07-->
					
					<input type="hidden" name="num_of_consent_req_bo<%=i%>" id="num_of_consent_req_bo<%=i%>" value="<%=records[64]%>">
					<input type="hidden" name="num_of_consent_req_br<%=i%>" id="num_of_consent_req_br<%=i%>" value="<%=records[65]%>">
					<input type="hidden" name="billing_interface<%=i%>" id="billing_interface<%=i%>" value="<%=billinginterface%>">
					<input type="hidden" name="service_panel<%=i%>" id="service_panel<%=i%>" value="<%=servicepanel%>">
					<input type="hidden" name="service_panel_code<%=i%>" id="service_panel_code<%=i%>" value="<%=servicepanelcode%>">
					<input type="hidden" name="numbering<%=i%>" id="numbering<%=i%>" value="<%=numbering%>">
					<input type="hidden" name="FinBill<%=i%>" id="FinBill<%=i%>" value="<%=finbill%>">
					<input type="hidden" name="clin_cmts_reqd_yn<%=i%>" id="clin_cmts_reqd_yn<%=i%>" value="<%=bean.checkForNull(records[66],"N")%>">
					<input type="hidden" name="authorised_yn<%=i%>" id="authorised_yn<%=i%>" value="N">
				<%if(speciality_code[0].equalsIgnoreCase("Y"))
				{
				%>
					<input type="hidden" name="splty_code<%=i%>" id="splty_code<%=i%>" value="<%=speciality_code[1]%>">
					<input type="hidden" name="auth_yn<%=i%>" id="auth_yn<%=i%>" value="<%=speciality_code[2]%>">
				<%
				}
				else
			   {
				%>
					<input type="hidden" name="splty_code<%=i%>" id="splty_code<%=i%>" value="">
					<input type="hidden" name="auth_yn<%=i%>" id="auth_yn<%=i%>" value="<%=bean.checkForNull(records[67],"N")%>">
				<%
				}
				%>



					<!--Ends here 08/05/07-->
					<input type="hidden" name="perfLocnMandFlag<%=i%>" id="perfLocnMandFlag<%=i%>" value="<%=perfLocnMandFlag%>"><!--IN066377-->
					<input type="hidden" name="group_order_category<%=i%>" id="group_order_category<%=i%>" value="<%=records[3]%>"> <!-- order_category -->
					<input type="hidden" name="billing_call_yn<%=i%>" id="billing_call_yn<%=i%>" value="<%=billing_call_yn%>">
					<input type="hidden" name="specimen_type<%=i%>" id="specimen_type<%=i%>" value="">
					<input type="hidden" name="nurse_collect<%=i%>" id="nurse_collect<%=i%>" value="">
					<input type="hidden" name="start_time<%=i%>" id="start_time<%=i%>" value=""> <!-- For Care Sets -->
					
					<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=order_id%>"> <!-- For Copy Order -->
					<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_no%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_preps<%=i%>" id="line_preps<%=i%>" value="<%=preps_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_pat_instrn<%=i%>" id="line_pat_instrn<%=i%>" value="<%=pat_preps_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_dept_instrn<%=i%>" id="line_dept_instrn<%=i%>" value="<%=preps_dept_instrn%>"> <!-- For Copy Order -->
					<input type="hidden" name="line_comments<%=i%>" id="line_comments<%=i%>" value="<%=comments%>">
					<%if(numbering==1){%><input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=displaytooltip%>"> 
					<%}else{%>
					<input type="hidden" name="explanatory_text<%=records[0]%>" id="explanatory_text<%=records[0]%>" value="<%=bean.checkForNull(records[62],"")%>"><%}%> <%-- explanatory_text--%>
					<input type="hidden" name="auto_report_yn<%=i%>" id="auto_report_yn<%=i%>" value="<%=bean.checkForNull(records[63],"")%>"> <%-- auto_report_yn--%>
					<input type="hidden" name="skip_auth<%=i%>" id="skip_auth<%=i%>" value="<%=records[70]%>"><!--IN048467 - HSA-CRF-0150-->
					<input type="hidden" name="barcode_reqd_yn<%=i%>" id="barcode_reqd_yn<%=i%>" value="<%=records[71]%>"><!--IN063816 - GHL-CRF-0445.1 -->
					<input type="hidden" name="prn_regd_ord<%=i%>" id="prn_regd_ord<%=i%>" value="<%=records[72]%>"><!--IN065942-->
					<input type="hidden" name="instrn_content_type<%=i%>" id="instrn_content_type<%=i%>" value="<%=records[73]%>"><!--IN64543-->
					<input type="hidden" name="non_billing_numbering<%=i%>" id="non_billing_numbering<%=i%>"  id ="non_billing_numbering<%=i%>" value="<%=non_billing_numbering %>" /><!--IN068314 -->
  				</td>
			</tr>

<%	
			if(!records[3].equals("") && !old_order_category.equals(records[3]))

				out.println("<script>setTimeout('hideGifs("+hide_count+",\""+records[3]+"\","+display_auth_count+","+display_cosign_count+","+display_special_count+")',100);</script>"); // hide the gifs 
				
				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
					out.println("<script>setFrequency(document.placeOrderForm.temp_frequency_code"+i+","+i+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
				}
%>
<%		
			old_order_category = records[3]; // Assign the order_category

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
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); // dep instrns
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
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(patpreps),"");  // For Patient Preps. Insructions.
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
					<input type="hidden" name="enable_email<%=i%>" id="enable_email<%=i%>" value="<%=EnableEmail%>">
<%
		}
	} 	
	if(PlaceOrderItems==null || PlaceOrderItems.size()==0){
%>
	<Script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
		window.close();
	</script>
<%	}
%>
</table>
		<input type="hidden" name="patient_email_id" id="patient_email_id" value="<%=patient_email_id%>">
		<input type="hidden" name="care_set_count" id="care_set_count" value="0"><!-- Used for Care Sets-->
		<input type="hidden" name="total_order_cat_count" id="total_order_cat_count" value="<%=order_cat_count%>"><!-- Used for Rapid Preview(to store the category count)-->
				<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

		<input type="hidden" name="mode" id="mode" value="1">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>">
		<input type="hidden" name="total_rows" id="total_rows" value="<%=i%>">
		
		<input type="hidden" name="amend_total_rows" id="amend_total_rows" value="0">
		<input type="hidden" name="check_box_val" id="check_box_val" value="">

		<input type="hidden" name="authorized" id="authorized" value="">
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="location_type" id="location_type" value="">
		<input type="hidden" name="location_code" id="location_code" value="">
		<input type="hidden" name="priority_hdr" id="priority_hdr" value="">
		<input type="hidden" name="order_date_time" id="order_date_time" value="">
		<input type="hidden" name="header_comments" id="header_comments" value="">
		<input type="hidden" name="order_category" id="order_category" value="<%=old_order_category%>">
		<input type="hidden" name="consented" id="consented" value="">
		<input type="hidden" name="cosigned" id="cosigned" value="">
		<input type="hidden" name="special_approved" id="special_approved" value="">
		<input type="hidden" name="lb_instal_yn" id="lb_instal_yn" value="<%=lb_instal_yn%>">
		<input type="hidden" name="rd_install_yn" id="rd_install_yn" value="">
		<input type="hidden" name="ot_install_yn" id="ot_install_yn" value="">
		<input type="hidden" name="session_id" id="session_id" value="<%=session_id%>">
		<input type="hidden" name="display_auth_count" id="display_auth_count" value="<%=display_auth_count%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="ordering_practitioner" id="ordering_practitioner" value="<%=bean.getPractitionerId()%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
		<!-- IN036383 Start -->
		<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>">
		<input type="hidden" name="medico_legal_yn" id="medico_legal_yn" value="<%=medico_legal_yn%>">
		<input type="hidden" name="postmortem_status" id="postmortem_status" value="<%=postmortem_status%>">
		<input type="hidden" name="body_part_yn" id="body_part_yn" value="<%=body_part_yn%>">
		<input type="hidden" name="registration_no" id="registration_no" value="<%=registration_no%>">
		<input type="hidden" name="callingFrom" id="callingFrom" value="<%=callingFrom%>">
		<!-- IN036383 End. -->
		<input type="hidden" name="task_code" id="task_code" value="<%=p_task_code%>">
		<input type="hidden" name="task_srl_no" id="task_srl_no" value="<%=p_task_srl_no%>">
 		<input type="hidden" name="sex" id="sex" value="<%=bean.getSex()%>">
		<input type="hidden" name="dob" id="dob" value="<%=bean.getDob()%>">
		<input type="hidden" name="primary_order_type" id="primary_order_type" value=""> <!-- Used for Primary Order Type OT Ordercategory -->

		<input type="hidden" name="ref_facility_id" id="ref_facility_id" value="<%=ref_facility_id%>"><!--External Orders-->
		<input type="hidden" name="ref_date_time" id="ref_date_time" value="<%=ref_date_time%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_pract_id" id="ref_sent_pract_id" value="<%=ref_sent_pract_id%>"><!--External Orders-->
		<input type="hidden" name="ref_sent_remarks" id="ref_sent_remarks" value="<%=ref_sent_remarks%>"><!--External Orders-->
		<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
		 <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->
		<input type="hidden" name="cosign_reqd_yn" id="cosign_reqd_yn" value=""> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn='Y' when nurse is logging in -->
		<input type="hidden" name="care_set_catalog_code" id="care_set_catalog_code" value=""><!-- Used for Care Sets-->
		<input type="hidden" name="function_name" id="function_name" value="PREVIEW"> <!-- For Order Format Line Level -->
		<input type="hidden" name="validated_status" id="validated_status" value="validation_reqd">
		<input type="hidden" name="new_order_reqd" id="new_order_reqd" value=""> <!-- For Amend Order , To generate a New Order-->
		<input type="hidden" name="record_from" id="record_from" value="PREVIEW"> <!-- For Preview Order , To check header mandatory -->
		<input type="hidden" name="email_yn" id="email_yn" value="N"> <!-- For Email -->
		<input type="hidden" name="appl_user_name" id="appl_user_name" value="<%=appl_user_name%>"> 
		<input type="hidden" name="checkCount" id="checkCount" value="">
		<input type="hidden" name="called_from" id="called_from" value="">
		<input type="hidden" name="twicedupchkflg" id="twicedupchkflg" value="<%=dupchk_siteSpecFlag%>"> <!-- IN062607 -->
		<input type="hidden" name="pract_type" id="pract_type" value="<%=practitioner_type%>"> <!--IN065942-->
		<input type="hidden" name="orset_ind_flag" id="orset_ind_flag" value="<%=orset_ind_flag%>"><!--IN067246-->
		<input type="hidden" name="format_mandatory_count" id="format_mandatory_count" value="<%=format_mandatory_count%>"> <!--IN069657-->
		<input type="hidden" name="call_function" id="call_function" value="ORSET"><!--IN066377-->
		<input type="hidden" name="bt_order_type_code" id="bt_order_type_code" value="<%=bt_order_type_code%>">
		<input type="hidden" name="interactionDrugsCnt" id="interactionDrugsCnt"  id ="interactionDrugsCnt" value="<%=drugintercnt %>" />	<!-- IN072654 -->
		
<%	
		// Nullifying the Objects
		previousValues			= null;				// Nullifying the Objects
		PlaceOrderItems			= null;		Default				= null;
		PlaceOrderType			= null;		PlaceOrderFrequency	= null;
		PlaceOrderDuration		= null;		FormatHdr			= null;
		stFormatID				= null;		copyOrderDetails	= null;
		secondaryOrders			= null;
%>
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
 		<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
 		   	<tr>
 		 		<td width='100%' id='t'></td>
 			</tr>
 		</table>
	</div>

	</form>
	</body>
	<script>
	
	loadDetails("<%=display_auth_count%>","<%=format_mandatory_count%>","<%=format_count%>","<%=display_cosign_count%>","<%=display_special_count%>","<%=function_from%>","<%=i%>","<%=p_start_date_time%>","<%=drugintercnt%>")//IN072654
	
	setTimeout('showBillingTable();',2000);
	skipAuthIndicator();//IN048467
	</script>
	<script>
		chkCount();
	</script>
</html>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
	//if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
	//  putObjectInBean(existing_bean_id,external_bean_obj,request);
	//} // End of function-from

%>

