<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*
----------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           										created
26/06/2012    IN033488      Chowminya G      									Incident No: IN033488 -  Error Marking - Result completed indicator> 
24/07/2012    IN033493      Chowminya G      									Incident No: IN033493 -  Order Tracking>hyperlink-appointment details with text 
12/12/2012    IN035317      Chowminya G      									Incident No: IN035317 -  System should also display the external prescription record at CA - Order Tracking 
20/12/2012    IN035618	    Vijayakumar K	    								No Hyper Link For Partial Resulted
09/04/2013    IN039195      Chowminya G        									Not able To View Results For Resulted Modified In Order Tracking
05/06/2013    IN029948		Nijitha  S     							 			Bru-HIMS-CRF-082
06/06/2013    IN040198.1    Chowminya G       									Reopen - Status of the Order Catalog is displayed wrongly
04/09/2013	  IN042630		Karthi L											The color displayed wrongly at Medication Administration details in Order tracking.	
05/02/2014 	  IN047918		NijithaS											KDAH-CRF-0284
08/05/2014	  IN048935		Nijitha S											ML-BRU-SCF-1318	- In the existing order tab, once a drug has been discontinued, the order status changes to Discontinued However the MAR status in the existing order still remains as In Progress
04/05/2014	  IN049050		Nijitha S											KDAH-CRF-0284/01 - Discharged Patient displayed in Order Tracking Function
04/03/2014	  IN053433		Nijitha S											ML-BRU-SCF-1545
17/03/2015	  IN054500		Vijayakumar K										Specimen result report is not printing 
03/06/2015	  IN054720		Vijayakumar K	03/06/2015							ML-BRU-SCF-1580 [IN:054720]																				
09/10/2015	  IN055910		Karthi L	    									From Clinician Access, modified result shall be identified by include "!" in Blue color																				
21/10/2015	  IN058125		Karthi L											Modified icon is showing for Registration Status.								
08/03/2016		IN059490		Karthi L										After placing orders, in Existing order â?? keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]							
15/08/2016		IN059315		Raja S										When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
12/05/2017	IN063781		Krishna Gowtham J	12/05/2017		Ramesh G		ML-MMOH-CRF-0804	
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
24/04/2018  	IN067360		Sharanraj			24/04/2018		Ramesh G	 OR-ML-MMOH-CRF-1071/01-Order Tracking
17/04/2018        IN066414		Sharanraj	  17/04/2018		Ramesh G		ML-MMOH-CRF-1071
11/06/2018        IN067921              Sharanraj         11/06/2018            Ramesh G                OR-Common-Order Tracking
06/06/2018    	  IN08078		Sharanraj	  12/06/2018		Ramesh G		ML-MMOH-SCF-1011
07/09/2018   	  IN068616		sivabagyam M      18/07/2018		Ramesh G		GHL-CRF-0433
17/09/2018		IN068663		Dinesh T			17/09/2018		Ramesh G	MMS-QF-SCF-0589	
05/11/2018		IN068986		Ramya Maddena		05/11/2018		Ramesh G	MO-CRF-20137.1
28/09/2020		ord_track		Nijitha S			28/09/2020		Nijitha S	Interaction Dtls not working in order tracking			
16/08/2021		19112			Ramesh												NMC-JD-CRF-0106
24/02/2022	 	25671			Ramesh G									NMC-JD-CRF-0091.2
03/07/2022		29803			Ramesh G									ML-BRU-CRF-0635
----------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%--<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> --%>
<jsp:useBean id="bean" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>
<%-- Mandatory declarations end --%> 
<html>
<head>
<%  
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--IN029948 Starts-->
	<script>
	async function showDetailsPH(patient_id,orderid,order_line_no,line_status_text)
	{
	var dialogHeight= "15" ;
	var dialogWidth	= "50" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id="+patient_id+"&order_id="+orderid+"&order_line_no="+order_line_no+"&line_status_text="+line_status_text,arguments,features);
	}
	</script>
	<!--IN029948 ENDS-->
	<Style>     </Style>
	<!--IN065091 start-->
	<style>
	TD.QRY11 
	{
		BACKGROUND-COLOR: #05bbea;
		FONT-SIZE: 9PT ;
		BORDER-COLOR:	BLACK;
		BORDER-LEFT-COLOR: #D5E2E5;
		BORDER-RIGHT-COLOR: #D5E2E5;
		BORDER-TOP-COLOR: #D5E2E5;
		BORDER-BOTTOM-COLOR: #D5E2E5;
	}
	</style>
	<!--IN065091 Ends-->
</head>
<body  onscroll='processScroll()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
			String bean_id = "Or_PatOrderByPrivRelnBean" ;
			String bean_name = "eOR.PatOrderByPrivRelnBean";
		bean.setLanguageId(localeName);

	/* Mandatory checks end */

//		PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
  		String mode	   = "1";//request.getParameter( "mode" ) ;
		//beanObj.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		//beanObj.setMode( mode ) ;

		String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
		String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
		String TrackingDate="";
		String TrackingEndDate="";
 		int start	 = Integer.parseInt(from);
		int end		 = Integer.parseInt(to);
		String total_query_records = "0";
		String practitioner_type = (String) session.getValue("practitioner_type");
		if(practitioner_type== null) practitioner_type = "";
/* 		if(from!=null && from.equals("1")) {
 			beanObj.clear() ;
		}
*/
		//String session_id= bean.getSessionId();
		//String tmpstr =new String();
		String slClassValue = "";
		int check_count = 0;

		//ArrayList searchData=new ArrayList();
		//19112 Start.
		Connection connection =  null;	
		boolean isSiteSpecificBillStatus = false; 
		boolean isSiteSpecificESignature = false;  //25671
		try{
			connection = ConnectionManager.getConnection(request); 	
			isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");
			isSiteSpecificESignature = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","ESIGNATURE_REQUIRED");   //25671
		}catch(Exception e){
			out.println("Exception@1: "+e);
		}finally{
			if(connection!=null)	ConnectionManager.returnConnection(connection,request);
		}
		//19112 End.
		//25671 Start.
		String eSignatureYN ="N";
		if(isSiteSpecificESignature)
			eSignatureYN ="Y";
		//25671 End.
Properties properties		= (Properties) session.getValue( "jdbc" );  

String order_status = request.getParameter( "order_status" ) ;
if(order_status == null || order_status.equals("null")) order_status =""; else order_status = order_status.trim();

String patientId = request.getParameter( "pat_id1");
if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();

String encounterId = request.getParameter( "encounterId");
if(encounterId == null || encounterId.equals("null")) encounterId =""; else
	encounterId = encounterId.trim();

String period_from = request.getParameter( "period_from" ) ;
if(period_from == null || period_from.equals("null")) period_from =""; else
	period_from = period_from.trim();

String period_to = request.getParameter( "period_to" ) ;
if(period_to == null || period_to.equals("null")) period_to =""; else
		period_to = period_to.trim();

String location_type = request.getParameter( "location_type");
if(location_type == null || location_type.equals("null")) location_type =""; else location_type = location_type.trim();

String locn = request.getParameter( "locn");
if(locn == null || locn.equals("null")) locn =""; else locn = locn.trim();

String ord_category = request.getParameter( "order_cat");
if(ord_category == null || ord_category.equals("null")) ord_category =""; else ord_category = ord_category.trim();

String order_type = request.getParameter( "order_type");
if(order_type == null || order_type.equals("null")) order_type =""; else order_type = order_type.trim();

String order_by = request.getParameter( "order_by");
if(order_by == null || order_by.equals("null")) order_by =""; else order_by = order_by.trim();

String view_by = request.getParameter("view_by");
if(view_by == null || view_by.equals("null")) view_by = ""; else view_by = view_by.trim();

String curr_sys_date = 	 request.getParameter( "curr_sys_date");
if(curr_sys_date == null || curr_sys_date.equals("null")) curr_sys_date =""; else curr_sys_date = curr_sys_date.trim();

String order_catelog= request.getParameter( "order_catelog");
if(order_catelog == null || order_catelog.equals("null")) order_catelog =""; else order_catelog = order_catelog.trim();

String ordering_pract= request.getParameter( "ordering_pract");
if(ordering_pract == null || ordering_pract.equals("null")) ordering_pract =""; else ordering_pract = ordering_pract.trim();

String priority= request.getParameter( "priority");
if(priority == null || priority.equals("null")) priority =""; else priority = priority.trim();

String search_crt=request.getParameter("search_crt");

if(search_crt == null || search_crt.equals("null")) search_crt =""; else search_crt = search_crt.trim();

//IN065091 start
String BTColorYN = request.getParameter("BTColorYN");
if(BTColorYN == null || BTColorYN.equals("null")) BTColorYN = ""; else BTColorYN = BTColorYN.trim();
//IN065091 ends
String practitioner_id=request.getParameter("practitioner_id");
if(practitioner_id == null || practitioner_id.equals("null")) practitioner_id =""; else practitioner_id = practitioner_id.trim();
String elapsed_orders=request.getParameter("elapsed_orders");
if(elapsed_orders == null || elapsed_orders.equals("null")) elapsed_orders =""; else elapsed_orders = elapsed_orders.trim();
String sys_cancelled_orders=request.getParameter("sys_cancelled_orders");
if(sys_cancelled_orders == null || sys_cancelled_orders.equals("null")) sys_cancelled_orders =""; else sys_cancelled_orders = sys_cancelled_orders.trim();

String activity_type = request.getParameter("activity_type")==null?"":request.getParameter("activity_type");
//String practitioner_type = (String)session.getValue("practitioner_type");
String facility_id = (String)session.getValue("facility_id");
bean.setLoginFacilityId(facility_id);//IN053433
//String resp_id = (String)session.getValue("responsibility_id");
String rd_install = "N";
String ot_install = "N";
//rd_install = bean.getRadiology(facility_id);
//included condition for --[IN033493]
if(ord_category.equals("RD") || ord_category.equals("OT") || ord_category.equals(""))
{
	rd_install = bean.getFacilityModuleInstallYn("RD", facility_id, properties);
	ot_install = bean.getFacilityModuleInstallYn("OT", facility_id, properties);
}

//ot_install = bean.getOTModule(facility_id);
String current_ip_list_check = request.getParameter("current_ip_list_check")==null?"N":request.getParameter("current_ip_list_check");//IN047918

String appt_ref_num ="";
String appt_date    = "";
String appt_locn	 ="";
String appt_resched_yn    = "N";
String appt_resched_reason ="";
String no_of_reschedules     = "";
String item_narration= ""; //IN059315
String ph_colors	= "";
int i= 0;

String last_action_type		= "";
String accession_num 		= "";
String ext_appl_accession_num 		= "";
String accession_num_tooltip 		= "";
String action_type    = "";//--[IN033488]
String action_date_time    = "";
String action_by_id    = "";
ArrayList ErrStatusChk		= null;
String bt_ack_YN = "";//IN065091
ArrayList resultData=new ArrayList();
//ArrayList AppointmentDetails  = null;

try
{
    if (location_type.equals("W")) location_type = "N";
//	if(from!=null && from.equals("1")) {
  		//resultData=(ArrayList)bean.getSearchResultDetails(properties, order_status,patientId,encounterId,period_from,period_to,location_type,locn,ord_category,order_type,order_catelog, priority,search_crt,order_by,practitioner_id,ordering_pract,activity_type,view_by,practitioner_type,elapsed_orders,sys_cancelled_orders,start,end);//IN047918		
  		resultData=(ArrayList)bean.getSearchResultDetails(properties, order_status,patientId,encounterId,period_from,period_to,location_type,locn,ord_category,order_type,order_catelog, priority,search_crt,order_by,practitioner_id,ordering_pract,activity_type,view_by,practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,current_ip_list_check);//IN047918
		// Setting as a persistence bean
//		beanObj.setDetails(resultData);
		// Persist it
//		putObjectInBean(bean_id,beanObj,request);
 //	} else {
//		resultData=beanObj.getDetails();
 // 	}
 
}catch(Exception e){
	e.printStackTrace();
}

if(resultData!=null && resultData.size() == 0)
{
		{%><script>
		parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.search.disabled= false;
		if(parent.framePatOrderByPrHeaderDtl)
		{
			parent.framePatOrderByPrHeaderDtl.document.location.href="../../eCommon/html/blank.html"
		}
		parent.framePatOrderByPrColor.document.location.href="../../eCommon/html/blank.html"
		</script><%}					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html' </script>");
}

/* Initialize Function specific end */
%>
<form name='formPatOrderByPRSearchResult' id='formPatOrderByPRSearchResult' action="../../eOR/jsp/PatOrderByPRSearchResult.jsp"  method="post" >
<div id="divHeadSep" ">
	<table name='' id='' border='1' cellspacing='0' cellpadding = '3' width='100%' id="tableresult" class="grid">
		<tr id="heading">
			<%
			if(order_by.equals("P"))
			{
		%>
				<td class='columnheader' width='' nowrap></td>
				<td class='columnheader' width='' nowrap></td>
				<!--IN065091 Start-->
				<% if("L".equals(view_by)&&"Y".equals(BTColorYN)){%>
					<td class='columnheader' width='' nowrap></td>
			<%
				}//IN065091 ends
				if(view_by.equals("H"))
				{
			%>
					<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
			<%
				}
				else
				{
			%>
					<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			<%
				}
			%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>

			<!---Arvind-->
			<% if((ord_category.equals("PH")||ord_category.equals(""))&&view_by.equals("L")){%>
				<td class='columnheader'><fmt:message key="eCA.MedAdmindetails.label" bundle="${ca_labels}"/></td>
			<%}%>
			<!---end-->
			<!---19112 Start.-->
			<% if(isSiteSpecificBillStatus && view_by.equals("L")){%>
				<td class='columnheader'><fmt:message key="eOR.BillingStatus.label" bundle="${or_labels}"/></td>
			<%}%>
			<!---19112 End.-->
			<td class='columnheader' width='' nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/><br><Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' ></td>
   
		<%
		}
		else if(order_by.equals("T"))
		{
		%>
			<td class='columnheader' width='' nowrap></td>
			<td class='columnheader' width='' nowrap></td>
			<!--IN065091 Start-->
				<% if("L".equals(view_by)&&"Y".equals(BTColorYN)){%>
					<td class='columnheader' width='' nowrap></td>
			<%
				}//IN065091 ends
			%>
			<td class='columnheader' width='' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<%
			if(view_by.equals("H"))
			{
			%>
				<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<%
			}
			else
			{
		%>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		<%
			}
		%>
			<td class='columnheader' width='' nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<!---19112 Start.-->
			<% if(isSiteSpecificBillStatus && view_by.equals("L")){%>
				<td class='columnheader'><fmt:message key="eOR.BillingStatus.label" bundle="${or_labels}"/></td>
			<%}%>
			<!---19112 End.-->
			<td class='columnheader' width='' nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/>
			<Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' ></td>
		<%
		}
		else
		{
		%>
			<td  class='columnheader' width='' nowrap></td>
			<td  class='columnheader' width='' nowrap></td>
			<!--IN065091 Start-->
				<% if("L".equals(view_by)&&"Y".equals(BTColorYN)){%>
					<td class='columnheader' width='' nowrap></td>
			<%
				}//IN065091 ends
			%>
			<td class='columnheader' width='' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<%
				if(view_by.equals("H"))
				{
			%>
					<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
				<%
					}
					else
					{
				%>
						<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
						<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
				<%
					}
				%>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<!---19112 Start.-->
				<% if(isSiteSpecificBillStatus && view_by.equals("L")){%>
					<td class='columnheader'  width='' nowrap><fmt:message key="eOR.BillingStatus.label" bundle="${or_labels}"/></td>
				<%}%>
				<!---19112 End.-->
				<td class='columnheader' width='' nowrap> <fmt:message key="Common.print.label" bundle="${common_labels}"/>
				<Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' ></td>	
<%}%>
</tr>	

<%
try
{

	String Pat_details		= "";
	String Order_cat		= "";
	String Order_type		= "";
	String Loc_details		= "";
	String Loc_detail		= "";
	String location			= "";
	String Date_details		= "";
	String temp_grpby		= "";
	String sex				= "";
	String Pat_Id			= "";
	String Order_Id			= "";
	String result_link		= "";
	String cont_order_ind	= "";
	String Order_cat_code	= "";
	String age				= "";
	String Priority_desc	= "";
	String source_type		= "";
	String Pat_name			= "";
	String sex1				= "";
	String descpriority		= "";
	String check_enable		= "";
	String displayChk		= "";
	String orderStatus		= "";
	ArrayList GroupBy		= null;
	String [] colorString	= {"X","X","X","X"};
	StringTokenizer colorTokenizer = null;
	String performing_facility_id = facility_id;

	//String color_string  = "";
	//String Ord_status="";
	String Order_line_num="";
	StringTokenizer menu_options = null;
	String Replaced_Order = "";
	String Original_Order = "";
	StringBuffer strOrderCtl = new StringBuffer();	
	String tepm_order_id="";
	String alternate="";//IN029948
	String lb_rslt_mod_status = ""; //HSA-CRF-0257.1 - IN055910
	String isResultModified = ""; //HSA-CRF-0257.1-02 IN058125	
	String ord_catalog_code = ""; //HSA-CRF-0257.1-02 IN058125
	ArrayList specList = null; //HSA-CRF-0257.1-02 IN058125	
	String pat_encounter_id = "";//ord_track
	String billingStatus="";//19112
	//String Order_catalog="";
	//if(resultData.size() < 7 || end > resultData.size()) {
	//			end = resultData.size();
	// }	
	//for(int i=0;i<resultData.size();i++){		
	for(int k=0;k<resultData.size();k++)
	{
	//	for(int k=(start-1);k<end;k++){
 		GroupBy	=(ArrayList)resultData.get(k);

		if(k==0)
		{ 
			if(view_by.equals("L"))
			{				
				//IN068986 Start.
				/*if(GroupBy.size()>=46) //Modified for IN059315
					total_query_records = bean.checkForNull((String)GroupBy.get(45),"0"); //Added for IN065091
				*/
				/* if(GroupBy.size()>=47) //Modified for IN059315
					total_query_records = bean.checkForNull((String)GroupBy.get(46),"0"); */
				//IN068986 End.
				//19112 Start.
				//if(GroupBy.size()>=48) //Modified for IN059315//ord_track
				//	total_query_records = bean.checkForNull((String)GroupBy.get(47),"0");//ord_track
				if(GroupBy.size()>=49) //Modified for IN059315//Ramesh
					total_query_records = bean.checkForNull((String)GroupBy.get(48),"0");//Ramesh	
				//19112 End.
			}
			else
			{
				//IN054720 starts
				/*if(GroupBy.size()>=29)
					total_query_records = bean.checkForNull((String)GroupBy.get(28),"0");*/
			/*	if(GroupBy.size()>=30)
					total_query_records = bean.checkForNull((String)GroupBy.get(29),"0"); */
				//IN054720 ends - commented for HSA-CRF-0257.1 - IN055910 
				/*IN067921 starts*/
				//if(GroupBy.size()>=31)
				//if(GroupBy.size()>=34)//IN68663
					//total_query_records = bean.checkForNull((String)GroupBy.get(30),"0");
					//total_query_records = bean.checkForNull((String)GroupBy.get(33),"0");
					//total_query_records = bean.checkForNull((String)GroupBy.get(33),"0");//IN68663
				/*IN067921 Ends*/		
				//HSA-CRF-0257.1 - IN055910 - End		
				//IN68663, starts
			/* 	if(GroupBy.size()>=34)
					total_query_records = bean.checkForNull((String)GroupBy.get(33),"0"); */
				//IN68663, ends
				if(GroupBy.size()>=35)//ord_track
					total_query_records = bean.checkForNull((String)GroupBy.get(34),"0");//ord_track
			}
			if((Integer.parseInt(total_query_records)>0) || (start>1))
			{
%>			<tr align="right">
					<!--IN065091 Start-->
					<!--<td colspan="11">-->
				<% if("L".equals(view_by)&&"Y".equals(BTColorYN) && isSiteSpecificBillStatus){%>
					<td colspan="13">
				<%
				}else if("L".equals(view_by)&& ("Y".equals(BTColorYN) ||isSiteSpecificBillStatus)){%>
					<td colspan="12">
				<%
				}else{
				%>
					<td colspan="11">
				<%
					}
				%>
					<!--IN065091 Start-->
						<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name ="from" value= "<%=start%>" /> 
						<jsp:param name ="to" value= "<%=end%>" />	
						<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
						<jsp:param name ="check_box_name" value= "chk" />					 
						<jsp:param name ="form_name" value= "formPatOrderByPRSearchResult" />  
						</jsp:include>
					</td>
				</tr>
<%
			}
		}  
		Pat_details			= bean.checkForNull((String)GroupBy.get(17),"");
		Pat_name			= bean.checkForNull((String)GroupBy.get(17),"");		
		Order_cat			= bean.checkForNull((String)GroupBy.get(1),"");			
		Order_cat_code	= bean.checkForNull((String)GroupBy.get(0),""); 
		Order_type			= bean.checkForNull((String)GroupBy.get(3),"");		
		Loc_details			= bean.checkForNull((String)GroupBy.get(10),"");		
		Date_details		= bean.checkForNull((String)GroupBy.get(14),"");		
		orderStatus		= bean.checkForNull((String)GroupBy.get(9),"");		
		if(!localeName.equals("en"))
		{ 
			Date_details=com.ehis.util.DateUtils.convertDate(Date_details,"DMY","en",localeName);
		}
		
		Pat_Id					= bean.checkForNull((String)GroupBy.get(11),"");
		Order_Id				= bean.checkForNull((String)GroupBy.get(13),"");
		if(view_by.equals("L"))
		{
			if(!tepm_order_id.equals(Order_Id))
			{
				check_enable  = "";
				tepm_order_id = Order_Id; 
				
			}
			else
			{
				check_enable = "style='display:none'";
				//displayChk="style='display:none'";
				check_count++;
			}
		}
		else
		{
			check_enable = "";
		}
		Priority_desc		= bean.checkForNull((String)GroupBy.get(4),"");
		source_type		= bean.checkForNull((String)GroupBy.get(5),"");
		descpriority			= bean.checkForNull((String)GroupBy.get(4),"");
		if(view_by.equals("L"))
		{
			sex								= bean.checkForNull((String)GroupBy.get(20),"");
			age								= bean.checkForNull((String)GroupBy.get(35),"");
			result_link						= bean.checkForNull((String)GroupBy.get(21),"");
			cont_order_ind					= bean.checkForNull((String)GroupBy.get(22),"");
			performing_facility_id			= bean.checkForNull((String)GroupBy.get(36),"");
			Order_line_num					= bean.checkForNull((String)GroupBy.get(23),"");
			menu_options					= new StringTokenizer((String)GroupBy.get(38),"|");
			alternate						= bean.checkForNull((String)GroupBy.get(41),"");//IN029948
			ord_catalog_code				= bean.checkForNull((String)GroupBy.get(42),"");//HSA-CRF-0257.1-02 IN058125
			pat_encounter_id 				= bean.checkForNull((String)GroupBy.get(46),"");//ord_track
			//19112 Start.
			billingStatus					= bean.checkForNull((String)GroupBy.get(47),"");//19112
			if("B".equals(billingStatus))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(billingStatus))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			
			if("DC".equals(orderStatus)||"CN".equals(orderStatus))
				billingStatus = "";
			//19112 End.			
		}
		else
		{
			sex								= bean.checkForNull((String)GroupBy.get(18),"");
			age								= bean.checkForNull((String)GroupBy.get(24),"");
			result_link						= bean.checkForNull((String)GroupBy.get(19),"");
			cont_order_ind	 				= bean.checkForNull((String)GroupBy.get(20),"");
			Order_line_num					= "";
			menu_options					= new StringTokenizer((String)GroupBy.get(25),"|");
			performing_facility_id			= bean.checkForNull((String)GroupBy.get(28),"");//IN054720
			pat_encounter_id 				= bean.checkForNull((String)GroupBy.get(33),"");//ord_track
		}
		
		if(menu_options.hasMoreTokens())
		{
			Replaced_Order					= menu_options.nextToken();  //VIEW_REPLACED_ORDER
			if(menu_options.hasMoreTokens())//IN067360
			Original_Order					= menu_options.nextToken();  //VIEW_ORIGINAL_ORDER			
		}
		if(view_by.equals("L"))
		{
			GroupBy.set(39,Replaced_Order);//VIEW_REPLACED_ORDER
			GroupBy.set(40,Original_Order);//VIEW_ORIGINAL_ORDER	
		}
		else
		{
			/*IN067360 starts*/
			//GroupBy.set(26,Replaced_Order);//VIEW_REPLACED_ORDER
			if(!appt_ref_num.equals(""))
			{
				GroupBy.set(26,Replaced_Order);//VIEW_REPLACED_ORDER	
			}
			/*IN067360 ends*/
			GroupBy.set(27,Original_Order);//VIEW_ORIGINAL_ORDER
		}
		//Ord_status	= (String)GroupBy.get(16);
		//Order_line_num= (String)GroupBy.get(23);
		//Order_catalog = (String)GroupBy.get(15);
		String order_details = (String)GroupBy.get(15);
		if(order_details.indexOf("$$RD##")!=-1)
		{
			String[] str = (String[])order_details.split("!~!");
			String order_detail ="";
			String[] strtitle = null;
			for(int s=0;s<str.length;s++)
			{
				if(str[s].indexOf("$$RD##")!=-1)
				{
					String line_order = (String)str[s];
					strtitle  =line_order.split("::");
					String titleText = "";
					if(strtitle[1].length()>0)
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
					}
					else
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
					}
					strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
					order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
				}
				else
				{
					order_detail = order_detail+str[s]+", ";
				}
			}
			order_details = order_detail;
			if(order_details.lastIndexOf(",") ==((order_details.length())-2))
			{
				order_details = order_details .substring(0,((order_details.length())-2));
			}
		}
		if(order_details.indexOf("!~!")!=-1)
		{
			order_details = order_details.replace("!~!",",");
		}
			
		if(descpriority.equals("R"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(descpriority.equals("U"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(descpriority.equals("S"))
		{
			descpriority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
		
		if (sex.equalsIgnoreCase("M"))
			 sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(sex.equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

		if(source_type.equalsIgnoreCase("C"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}
		else if(source_type.equalsIgnoreCase("N"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		else if(source_type.equalsIgnoreCase("R"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
		}
		else //--[IN035317]
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
		}
		Loc_detail=source_type+"/"+Loc_details;
		Pat_details=Pat_name+","+sex1+"/"+age+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+Pat_Id;
	
		if(view_by.equals("L"))
		{
			ph_colors									= bean.checkForNull((String)GroupBy.get(26),"");
			appt_date									= bean.checkForNull((String)GroupBy.get(27),"");
			appt_ref_num							= bean.checkForNull((String)GroupBy.get(28),"");
			appt_locn									= bean.checkForNull((String)GroupBy.get(29),"");
			appt_resched_yn						= bean.checkForNull((String)GroupBy.get(30),"");
			appt_resched_reason				= bean.checkForNull((String)GroupBy.get(31),"");
			no_of_reschedules					= bean.checkForNull((String)GroupBy.get(32),"");
			last_action_type						= bean.checkForNull((String)GroupBy.get(33),"");
			accession_num							= bean.checkForNull((String)GroupBy.get(34),"");
			ext_appl_accession_num			= bean.checkForNull((String)GroupBy.get(37),"");
			item_narration		= bean.checkForNull((String)GroupBy.get(43),""); //IN059315
			bt_ack_YN			= bean.checkForNull((String)GroupBy.get(44),""); //IN065091
		}
		else
		{
			ph_colors									= bean.checkForNull((String)GroupBy.get(23),"");
			/*IN067360 Starts*/
			//appt_date									= "";
			//appt_date      = bean.checkForNull((String)GroupBy.get(24),"");
			//appt_ref_num							= "";
			//appt_ref_num	= bean.checkForNull((String)GroupBy.get(25),"");
			//appt_locn									= "";
			//appt_locn  = bean.checkForNull((String)GroupBy.get(26),"");
			/*IN067360 ends*/
			//required?, starts
			appt_resched_yn						= "";
			appt_resched_reason				= "";
			no_of_reschedules					= "";
			//required?, ends
			last_action_type						= "";
			//accession_num							= ""; // commented for HSA-CRF-0257.1 - IN055910
			ext_appl_accession_num			= "";
			accession_num			= bean.checkForNull((String)GroupBy.get(29),""); // modified for HSA-CRF-0257.1 - IN055910 
			item_narration			=	""; //IN059315
			bt_ack_YN				=	"";//IN065091
			/*IN067360 Starts*/
			//appt_date									= "";
			appt_date      = bean.checkForNull((String)GroupBy.get(30),"");
			//appt_ref_num							= "";
			appt_ref_num	= bean.checkForNull((String)GroupBy.get(31),"");
			//appt_locn									= "";
			appt_locn  = bean.checkForNull((String)GroupBy.get(32),"");
			/*IN067360 ends*/
		}

		if(ph_colors==null || ph_colors.equals("")) ph_colors = "X,X,X";
		if(appt_ref_num==null) appt_ref_num= "";
		if(appt_date==null) appt_date= "";
		if(appt_locn==null) appt_locn= "";
		if(appt_resched_yn==null) appt_resched_yn= "";
		if(appt_resched_reason==null) appt_resched_reason= "";
		if(no_of_reschedules==null) no_of_reschedules= "";
		if(last_action_type==null) last_action_type= "";
		if(accession_num==null) accession_num= "";
	 
		if(result_link == null || result_link.equals("null")) 
			result_link =""; 
		else 
			result_link = result_link.trim();
		
		//IN063781 starts
		if("PF".equals(orderStatus) && !("RD".equals(Order_cat_code) && "Y".equals(result_link)))
		{
			result_link = "N";
		}
		//IN063781 Ends

		slClassValue="gridData";
        
//        if (Order_cat_code.equals("PH"))
		{
            // color_string = bean.getColors(facility_id,Order_Id,Order_catalog,Order_line_num);
             colorTokenizer = new StringTokenizer(ph_colors,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                if (tempToken.equals("#7FFF00"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008000"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#0000CD"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#808000"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
				else if (tempToken.equals("#D8BFD8"))
                    colorString[index] = "QRY8";
				else if (tempToken.equals("#DDA0DD"))  
                    colorString[index] = "QRY9";
				else if (tempToken.equals("#F4A460"))
                    colorString[index] = "QRY10";
				else if (tempToken.equals("LIGHTYELLOW"))
                    colorString[index] = "LIGHTYELLOW";
				else if (tempToken.equals("BROWN"))
                    colorString[index] = "BROWN";
                else if (tempToken.equals("X"))
                    colorString[index] = slClassValue;
                index++;
            }
        }
	//HSA-CRF-0257.1 - IN055910 - Start
	
	if(Order_cat_code.equals("LB")) { 
		//isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num); // AAKH-SCF-0252  // commented for PERF issue - Karthi
		isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num, patientId); // modified for PERF issue - Karthi
		if(isResultModified == null) isResultModified = ""; // AAKH-SCF-0252
		if("Y".equals(isResultModified)) { //AAKH-SCF-0252
			//specList = bean.getIntervalTestSpecNos(Order_Id); // commented for PERF issue - Karthi
			specList = bean.getIntervalTestSpecNos(Order_Id, patientId); // modified for PERF issue - Karthi
			if(specList != null && specList.size()>1){
				//lb_rslt_mod_status = bean.getLBModStatForIntTest(specList); // commented for PERF issue- Karthi
				lb_rslt_mod_status = bean.getLBModStatForIntTest(specList, patientId);// modified for PERF issue - Karthi
			}
			else {
				//lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, ord_catalog_code); // commented for PERF issue - Karthi
				lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, ord_catalog_code, patientId); // modified for PERF issue - Karthi
			}
			if(lb_rslt_mod_status == null) lb_rslt_mod_status ="";
		}	
		//isResultModified = bean.getResultStatFromStatusAppl(view_by, Order_Id, Order_line_num); //HSA-CRF-0257.1-02 [IN058125]
		//if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125]
	}
	//HSA-CRF-0257.1 - IN055910 - End
 	if(order_by.equals("P"))
	{
        if (!temp_grpby.equals(Pat_details))
		{
			temp_grpby = Pat_details;
%>
		<tr>
			<td colspan='100%'  class ='CAGROUPHEADING' style="border-top: 0.2em solid #a59d9d;border-bottom: 1px solid lightgray;"><%=temp_grpby%></td>
		</tr>
<%
		}
%>
	<tr>

	<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
	<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
	<% 
	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
		{
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		}
		else
		{
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
	}
	else
	{
		if(view_by.equals("L"))
		{
			TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
		}
		else
		{
			TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}
	%>
	<td width='' nowrap class='<%=slClassValue%>'>
		<font size=1><%=TrackingDate%></font>
	</td>
<%
	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{
%>
			<td width='' nowrap class='<%=slClassValue%>'>
				<font size=1><%=TrackingEndDate%></font>
			</td>
<%
		}
		else
		{
%>
			<td width='' nowrap class='<%=slClassValue%>'><font size=1>&nbsp;</font></td>
<%
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=descpriority==null?"&nbsp;":descpriority%></font>
	</td>

	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(3)%></font>
	</td>
	<%
	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
		
	}
	else
	{
	%>
		<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>'>
		<!-- 	<font size=1><a class='gridLink' href='#'  onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"><%=order_details%></font>  -->
			<font size=1><a class='gridLink' href='#'  onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>','<%=pat_encounter_id%>')"><%=order_details%></font><!-- //ord_track -->
		<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			System.out.println("PatOrderByPRSearchResult.jsp:Line:738");
		
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		<!--IN029948 Ends-->
		</td>
	<%
	}
	%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(7)%></font>
	</td>

	<td width='' nowrap style='height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;' class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >			<font size=1>
<%
	//HSA-CRF-0257.1 - IN055910 - Start
	if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
	%>
		<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
					
	<% //HSA-CRF-0257.1 - IN055910  - End
	if(result_link.equals("Y"))
	{
	//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
		
		if(last_action_type!=null && last_action_type.equals("NT"))
		{
%> <!--call Notes view  -->
	<!-- <a href="javascript:showNotes('<%=accession_num%>')"><%=(String)GroupBy.get(16)%></a> -->
			<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
				
<% 
		}
		else
		{
%> <!-- Result View --> 
			<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<% 
		}
		}
		else {
		out.println((String)GroupBy.get(16));}
		//IN035618 ends
	}
	else
	{
		/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
		for(int k=0;k<AppointmentDetails.size();k++) {
			String[] record = (String [])AppointmentDetails.get(k);
			appt_ref_num 	= record[0];
			appt_date		= record[1];
			if(appt_ref_num==null) appt_ref_num= "";
			if(appt_date==null) appt_date= "";
		}*/
 %>
		<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
		<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
		<!--<input type="hidden" name="performing_facility_id<% //=i%>" id="performing_facility_id<% //=i%>" value="<% //=performing_facility_id%>">--> <!-- IN054720 -->
		<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
		<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
		<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
		<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
		<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
		<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
		<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
 <%	
		if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
		{
			/*commented and added for IN08078 starts*/
			//if( ((((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
			if( ((((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )	
			/*commented and added for IN08078 ends*/
			{ 
%>
				<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%		
			}
			else
			{ 
%>
				<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%		
			}
			out.println((String)GroupBy.get(16));
			out.println("</a>");
		}
		else {
			//IN068986 Start.
			if(view_by.equals("L"))
			{
				if("LB".equals(Order_cat_code) && "RG".equals(orderStatus) && "Y".equals((String)GroupBy.get(45))){
				%>
				<a class='gridLink' href='#' onClick="resultViewForRegisteredOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>','<%=orderStatus%>')"><%=(String)GroupBy.get(16)%></a>
				<%
				}else{
					out.println((String)GroupBy.get(16));
				}
			}else{
			//IN068986 End.
				out.println((String)GroupBy.get(16));
			} //IN068986
		}
	}
	//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
		</font>
		</td>
		<!---Arvind-->
		<% 
		if((ord_category.equals("PH")||ord_category.equals(""))&&view_by.equals("L"))
		{
			String med_admin_status_imd="";
			String med_admin_status_title="";			
			String med_admin_status=bean.getMedAdminStatus(patientId,encounterId,facility_id,Order_Id,Order_line_num);			
			if(med_admin_status.equals("P") && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus))//IN048935
			{ 
				//med_admin_status_imd="green"; // commented for IN042630
				med_admin_status_imd="yellow"; //  modified for IN042630
				med_admin_status_title="Progress";
			}
			else if(med_admin_status.equals("C") && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus))//IN048935
			{
				//med_admin_status_imd="yellow"; // commented for IN042630
				med_admin_status_imd="green"; //  modified for IN042630
				med_admin_status_title="Completed";
			}
			else
			{
				med_admin_status_imd="";
				med_admin_status_title="";
			}
		%>
			<td class='<%=slClassValue%>'>
			 <%if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(orderStatus) && !"CN".equals(orderStatus) && !"FC".equals(orderStatus) ) //IN048935
		    { 
		    %>
				<table><tr><a href='javascript:viewMedication("<%=GroupBy.get(11)%>","<%=GroupBy.get(6)%>","<%=GroupBy.get(14)%>","<%=GroupBy.get(24)%>")'><td 
				style='BACKGROUND-COLOR:<%=med_admin_status_imd%>;
					width:20px;
					height:20px;' title=<%=med_admin_status_title%>></td></a></tr></table>
			<% 
			} 
			%>
			</td> 
		<% } %>
		<!--ens-->			
		<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;<%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		%>
		<!-- 19112 End.-->				
		<!-- added by Arvind -->
		<td  width='' nowrap  class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)'  
			<%=check_enable%> <%=displayChk%>>
		
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<!--<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>" >--><!--IN68663-->
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(6)%>" ><!--IN68663-->
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500-->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
		</td>
		
	</tr>
<%
	}

	if(order_by.equals("C"))
	{
        if(!temp_grpby.equals(Order_cat))
		{
			temp_grpby = Order_cat;
%>
		<tr>
			<td colspan='100%'  class ='CAGROUPHEADING'><%=temp_grpby%></td>
		</tr>

<%
		}
%>

<tr>

	<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
	<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
	<%
	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=Pat_details%></font>
	</td>
<%
	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate = bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate = bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=TrackingDate%></font>
	</td>

<%
	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";

		if(!TrackingEndDate.equals(""))
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >
				<font size=1><%= TrackingEndDate %></font>
			</td>
<%
		}
		else
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >	<font size=1>&nbsp;</font></td>
<%
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=descpriority%></font>
	</td>

	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(3)%></font>
	</td>
	<%
	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
	}
	else
	{
	%>

		<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>'>
			<font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"><%=order_details%></font>
<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		
<!--IN029948 Ends-->
		</td>
	<%
	}
	%>

	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(7)%></font>
	</td>

	<td width='' nowrap class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >									<font size=1>
<%
		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		%>
			<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
						
		<% //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{
%> <!--call Notes view  -->
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			else
			{
%> <!-- Result View --> 
 				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
				/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
	 			for(int k=0;k<AppointmentDetails.size();k++) {
					String[] record = (String [])AppointmentDetails.get(k);
					appt_ref_num 	= record[0];
					appt_date		= record[1];
					if(appt_ref_num==null) appt_ref_num= "";
					if(appt_date==null) appt_date= "";
				}*/
%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
			<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
			<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
<%
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*commentted and added for IN08078 Starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y"))  || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")))  || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*commentted and added for IN08078 Ends*/	
				{ 
%>
					<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%
				}
				else
				{
%>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%
				}
				out.println((String)GroupBy.get(16));
				out.println("</a>");
			}
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
	</font>
	</td>
	<!-- 19112 Start.-->
	<%
	if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
	{
	%>		
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;<%=billingStatus%></td>
	<%
	}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
	{
	%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
	<%
	}
	%>
	<!-- 19112 End.-->	
	<td  width='' nowrap class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)' <%=check_enable%><%=displayChk%>>
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>">
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500-->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
	</td>

</tr>
<%
	}

	if(order_by.equals("T"))
	{
        if(!temp_grpby.equals(Order_type))
		{
			temp_grpby = Order_type;
%>
		<tr>
			<td colspan='100%' class ='CAGROUPHEADING'><%=temp_grpby%></td>
		</tr>
<%
		}
%>
<tr>

	<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
	<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
	<%
	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=Pat_details%></font>
	</td>
<%
	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
		if(!localeName.equals("en"))
		{ 
			TrackingEndDate 	=com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=TrackingDate%></font>
	</td>

<%
	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >
				<font size=1><%= TrackingEndDate %></font>
			</td>
<%
		}
		else
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >
				<font size=1>&nbsp;</font>
			</td>
<%
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=descpriority%></font>
	</td>
	<%
	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
	}
	else
	{
	%>

		<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>'>
			<!-- <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"> <%=order_details%></font> -->
			<font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>','<%=pat_encounter_id%>')"> <%=order_details%></font><!-- //ord_track -->
			<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		
<!--IN029948 Ends-->
		</td>
	<%
	}
	%>

	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(7)%></font>
	</td>

	<td width='' nowrap class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >									<font size=1>
<%
		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		%>
			<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
						
		<% //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{
%> <!--call Notes view  -->
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			else
			{
%> <!-- Result View --> 
 				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/
%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
			<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
			<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
<%	
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*commentted and added for IN08078 Starts*/			
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*commentted and added for IN08078 Ends*/	
				{ 
%>
					<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%		
				}
				else
				{
%>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
			}
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
	</font>
	</td>
	<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;<%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		%>
	<!-- 19112 End.-->	
	<td width='' nowrap class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)' <%=check_enable%><%=displayChk%>>
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>" >
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500-->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
	</td>
</tr>
<%
	}

	if(order_by.equals("L"))
	{
        if(!temp_grpby.equals(Loc_detail))
		{
			temp_grpby = Loc_detail;
			//Modified the check to display external PH orders without empty location data - IN035317 - Start
			if(!("/").equals(temp_grpby))
			{
%>
				<tr>
					<td colspan='100%'  class ='CAGROUPHEADING'><%=location%>/<%=Loc_details%></td>
				</tr>
<%
			}
			else
			{
%>
				<tr>
					<td colspan='100%'  class ='CAGROUPHEADING'><%=location%></td>
				</tr>
<%
			}
			//IN035317 - End
		}
%>
<tr>
	<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
	<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
	<%
	//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	%>
	<td width='' nowrap class='<%=slClassValue%>' >	
		<font size=1><%=Pat_details%></font>
	</td>
<%
	if(!localeName.equals("en"))
	{ 
		if(view_by.equals("L"))
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
		else
			TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
	}
	else
	{
		if(view_by.equals("L"))
			TrackingDate = bean.checkForNull((String)GroupBy.get(18),"");
		else
			TrackingDate = bean.checkForNull((String)GroupBy.get(14),"");
	}
	if(view_by.equals("L"))
	{
		TrackingEndDate = bean.checkForNull((String)GroupBy.get(19),"");
		if ( !localeName.equals("en") )
		{ 
			TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
			if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
		}
		if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
		{
			TrackingEndDate = "";
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=TrackingDate%></font>
	</td>

<%
	if(view_by.equals("L"))
	{
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip= "";
		if(!TrackingEndDate.equals(""))
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >	
				<font size=1><%= TrackingEndDate %></font>
			</td>
<%
		}
		else
		{
%>
			<td width='' nowrap class='<%=slClassValue%>' >
				<font size=1>&nbsp;</font>
			</td>
<%
		}
	}
%>
	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=descpriority%></font>
	</td>

	<td width='' nowrap class='<%=slClassValue%>' >	
		<font size=1><%=(String)GroupBy.get(3)%></font>
	</td>
	<%
	if(view_by.equals("L"))
	{
		Replaced_Order = (String)GroupBy.get(39);
		Original_Order = (String)GroupBy.get(40);
	}
	else
	{
		Replaced_Order = (String)GroupBy.get(26);
		Original_Order = (String)GroupBy.get(27);
	}
	if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
	{
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
		strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
		strOrderCtl.append(order_details);
		//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
		out.println(strOrderCtl.toString());
		strOrderCtl.setLength(0);
		
	}
	else
	{
	%>
		<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>' >
			<!-- <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"><%=order_details%></font> -->
			 <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>','<%=pat_encounter_id%>')"><%=order_details%></font><!-- //ord_track --> 
			
<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		
<!--IN029948 Ends-->
		</td>
	<%
	}
	%>

	<td width='' nowrap class='<%=slClassValue%>' >
		<font size=1><%=(String)GroupBy.get(7)%></font>
	</td>

	<td width='' nowrap class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >									<font size=1>
<%
		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		%>
			<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
						
		<% //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{ 
%> <!--call Notes view  -->
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<% 
			}
			else
			{ 
%> <!-- Result View --> 
 				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<% 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/
%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
			<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
			<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
<%		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*Commented and added for IN08078 Ends*/
				{ 
%>
					<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%
				}
				else
				{
%>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
	</font>
	</td>
	<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'><%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		%>
	<!-- 19112 End.-->	
	<td  width='' nowrap  class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)' <%=check_enable%><%=displayChk%>>
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>" >
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500-->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
	</td>
</tr>
<%
	}

	if(order_by.equals("D"))
	{
        if(!temp_grpby.equals(Date_details))
		{
			temp_grpby = Date_details;
%>
		<tr>
			<td colspan='100%'  class ='CAGROUPHEADING'><%=temp_grpby%></td>
		</tr>

<%
		}
%>
<tr>

		<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
		<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
		<%
		//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	%>
		<td width='' nowrap class='<%=slClassValue%>' >	
			<font size=1><%=Pat_details%></font>
		</td>
<%
		if ( !localeName.equals("en") )
		{ 
			 if(view_by.equals("L"))
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
			 else
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
		else
		{
			if(view_by.equals("L"))
				TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
			else
				TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
		if(view_by.equals("L"))
		{
			TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
			if(!localeName.equals("en"))
			{ 
				TrackingEndDate = com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
				if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate = "";
			}
			if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
			{
				TrackingEndDate = "";
			}
		}
%>
		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=TrackingDate%></font>
		</td>
<%
		if(view_by.equals("L"))
		{
			if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
				accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
			else
				accession_num_tooltip= "";
			if(!TrackingEndDate.equals(""))
			{
%>
				<td width='' nowrap class='<%=slClassValue%>' >	
					<font size=1><%= TrackingEndDate %></font>
				</td>
<%
			}
			else
			{
%>
				<td width='' nowrap class='<%=slClassValue%>' >	<font size=1>&nbsp;</font></td>
<%
			}
		}
%>
		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=descpriority%></font>
		</td>

		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=(String)GroupBy.get(3)%></font>
		</td>
		<%
		if(view_by.equals("L"))
		{
			Replaced_Order = (String)GroupBy.get(39);
			Original_Order = (String)GroupBy.get(40);
		}
		else
		{
			Replaced_Order = (String)GroupBy.get(26);
			Original_Order = (String)GroupBy.get(27);
		}
		if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
		{
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			strOrderCtl.append(order_details);
			//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
			out.println(strOrderCtl.toString());
			strOrderCtl.setLength(0);
		}
		else
		{
		%>
			<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>'>
				<!-- <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"><%=order_details%></font> -->
				<font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>','<%=pat_encounter_id%>')"><%=order_details%></font><!-- //ord_track -->
				
<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		
<!--IN029948 Ends-->
			</td>
		<%
		}
		%>

		<td width='' nowrap class='<%=slClassValue%>' >	
			<font size=1><%=(String)GroupBy.get(7)%></font>
		</td>

		<td width='' nowrap class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >									<font size=1>
<%
		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		%>
			<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
						
		<% //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{ 
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{
%> <!--call Notes view  -->
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			else
			{ 
%> <!-- Result View --> 
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<% 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends			
		}
		else
		{

			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/
%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
			<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
			<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
<%		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )	
				/*Commented and added for IN08078 Ends*/	
				{ 
%>
					<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%		
				}
				else
				{
%>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
	</font>
	</td>
	<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'><%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		%>
	<!-- 19112 End.-->	
	<td  width='' nowrap  class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)' <%=check_enable%><%=displayChk%>>
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>" >
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500-->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
	</td>
</tr>
<%
	}
	else if(order_by.equals("U"))
	{
        if(!temp_grpby.equals(descpriority))
		{
			temp_grpby = descpriority;
%>
		<tr>
			<td colspan='100%'  class ='CAGROUPHEADING'><%=temp_grpby%></td>
		</tr>

<%
		}
%>
<tr>

		<td width='' nowrap class='<%=((colorString[0].equals("X"))?slClassValue:colorString[0])%>' ></td>
		<td width='' nowrap class='<%=((colorString[2].equals("X"))?slClassValue:colorString[2])%>' ></td>
		<%
		//IN065091 start
	if("L".equals(view_by)&&"Y".equals(BTColorYN)){
		if("Y".equals(bt_ack_YN))
		{
	%>
			<td width='' nowrap class='QRY11'></td>
	<%
		}
		else
		{
	%>
			<td width='' nowrap class='<%=slClassValue%>'></td>
	<%
		}
	}
		//IN065091 ends
	%>
		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=Pat_details%></font>
		</td>
<%	
		if ( !localeName.equals("en") )
		{ 
			if(view_by.equals("L"))
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(18),"DMYHM","en",localeName);
			else
				TrackingDate = com.ehis.util.DateUtils.convertDate((String)GroupBy.get(14),"DMYHM","en",localeName);
		}
		else
		{
			if(view_by.equals("L"))
				TrackingDate=bean.checkForNull((String)GroupBy.get(18),"");
			else
				TrackingDate=bean.checkForNull((String)GroupBy.get(14),"");
		}
		if(view_by.equals("L"))
		{
			TrackingEndDate=bean.checkForNull((String)GroupBy.get(19),"");
			if ( !localeName.equals("en") )
			{ 
				TrackingEndDate 	=com.ehis.util.DateUtils.convertDate(TrackingEndDate,"DMYHM","en",localeName);
				if(TrackingEndDate.equals("null") || (TrackingEndDate.equals(" "))) TrackingEndDate="";
			}
			if(bean.checkForNull((String)GroupBy.get(0),"").equalsIgnoreCase("PH")&&bean.checkForNull((String)GroupBy.get(2),"").equalsIgnoreCase("MS"))
			{
				TrackingEndDate = "";
			}
		}
%>
		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=TrackingDate%></font>
		</td>

<%
		if(view_by.equals("L"))
		{
			if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
				accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
			else
				accession_num_tooltip= "";
			if(!TrackingEndDate.equals(""))
			{
%>
				<td width='' nowrap class='<%=slClassValue%>' >	
					<font size=1><%= TrackingEndDate %></font>
				</td>
<%
			}
			else
			{
%>
				<td width='' nowrap class='<%=slClassValue%>' >	<font size=1>&nbsp;</font></td>
<%
			}
		}
%>
		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=descpriority%></font>
		</td>

		<td width='' nowrap  class='<%=slClassValue%>' >
			<font size=1><%=(String)GroupBy.get(3)%></font>
		</td>
		<%
		if(view_by.equals("L"))
		{
			Replaced_Order = (String)GroupBy.get(39);
			Original_Order = (String)GroupBy.get(40);
		}
		else
		{
			Replaced_Order = (String)GroupBy.get(26);
			Original_Order = (String)GroupBy.get(27);
		}
		if((Replaced_Order.equalsIgnoreCase("Y"))||((Original_Order.equalsIgnoreCase("Y"))))
		{
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((Replaced_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((Original_Order.trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+"','"+Order_cat+"','"+Order_Id+"','"+sex+"','"+Pat_Id+"','"+Order_line_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			strOrderCtl.append(order_details);
			//IN029948 Start
		
if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patientId+"','"+Order_Id+"','"+Order_line_num+"','"+orderStatus+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		}
		
//IN029948 End
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");
			out.println(strOrderCtl.toString());
			strOrderCtl.setLength(0);
		
		}
		else
		{
		%>
			<td width='' nowrap class='<%=slClassValue%>' title='<%=accession_num_tooltip%>'>
		<!-- 		<font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>')"><%=order_details%></font> -->
		<font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=Order_cat%>','<%=Order_Id%>','<%=sex%>','<%=Pat_Id%>','<%=Order_line_num%>','<%=pat_encounter_id%>')"><%=order_details%></font><!-- //ord_track --> 

<!--IN029948 Start-->	
		<%
		if( view_by.equals("L") && Order_cat_code.equalsIgnoreCase("PH") && "Y".equals(alternate))
		{
		%>
		<a href='javascript: dummy()' onClick="showDetailsPH('<%=patientId%>','<%=Order_Id%>','<%=Order_line_num%>','<%=orderStatus%>')">
		<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>
		</a>
		<%
		}
	    %>
		
		
<!--IN029948 Ends-->
			</td>
		<%
		}
		%>

		<td width='' nowrap class='<%=slClassValue%>' >
			<font size=1><%=(String)GroupBy.get(7)%></font>
		</td>

		<td width='' nowrap class='<%=((colorString[3].equals("X"))?slClassValue:colorString[3])%>' >									<font size=1>
<%
		//HSA-CRF-0257.1 - IN055910 - Start
		if(Order_cat_code.equals("LB") && lb_rslt_mod_status.equals("C") && isResultModified.equals("Y")) 
		%>
			<img width='20' height='20' src='../../eCA/images/modifiedresult.png' alt='Result Modified'/>
						
		<% //HSA-CRF-0257.1 - IN055910  - End
		if(result_link.equals("Y"))
		{
		//IN035618 starts
		if(!Order_cat_code.equals("RX") || (Order_cat_code.equals("RX") && (orderStatus.equals("RS")||orderStatus.equals("RM")||orderStatus.equals("RA")||orderStatus.equals("MA")||orderStatus.equals("MP"))) ) //IN039195 //newly added orderStatus.equals("MP") for 29803
		{
			if(last_action_type!=null && last_action_type.equals("NT"))
			{ 
%> <!--call Notes view  -->
				<!-- <a href="javascript:showNotes('<%=accession_num%>')"><%=(String)GroupBy.get(16)%></a> -->
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<%
			}
			else
			{
%> <!-- Result View --> 
				<a class='gridLink' href='#' onClick="resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>
<% 
			}
			}else {
			out.println((String)GroupBy.get(16));}
		//IN035618 ends
		}
		else
		{
			/*AppointmentDetails = bean.getOrderApptDetails((String)GroupBy.get(13));
			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/
%>
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=appt_locn%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=appt_resched_yn%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=appt_resched_reason%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=no_of_reschedules%>">
			<input type="hidden" name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=item_narration%>"> <!--IN059315-->
			<input type="hidden" name="Order_Id<%=i%>" id="Order_Id<%=i%>" value="<%=Order_Id%>"><!--IN64543-->
			<input type="hidden" name="Order_line_num<%=i%>" id="Order_line_num<%=i%>" value="<%=Order_line_num%>"><!--IN64543-->
<%		 
			if((!appt_ref_num.equals("")) && (!appt_date.equals(""))&&(orderStatus.equals("AB")))
			{
				/*Commented and added for IN08078 starts*/			
				//if( ( (((String)GroupBy.get(0)).equals("RD")) && rd_install.equals("Y")) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				if( ( (((String)GroupBy.get(0)).equals("RD")) ) || ((((String)GroupBy.get(0)).equals("OT")) && ot_install.equals("Y")) )
				/*Commented and added for IN08078 Ends*/	
				{ 
%>
					<a class="gridLink" href="javascript:viewApptData(escape('<%=i%>'))"> 
<%	
				}
				else
				{
%>
					<a class="gridLink" href="javascript:viewOAApptData(escape('<%=i%>'))"> 			
<%	
				} 
				out.println((String)GroupBy.get(16));
				out.println("</a>");
		    }
			else 
				out.println((String)GroupBy.get(16));
		}
		//--[IN033488]
	StringBuffer error_desc=new StringBuffer();	
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
	error_desc.append(" ");
	error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
	error_desc.append(" ");
	if(orderStatus.equals("RS") ||orderStatus.equals("RM"))
	{
		ErrStatusChk  = bean.getRltNoteSts(Order_Id,localeName); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";// IN040198.1
		}
	}
		
	//--[IN033488]
%>
	</font>
	</td>
	<!-- 19112 Start.-->
		<%
		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		%>		
		<td width='' nowrap class='<%=slClassValue%>'><%=billingStatus%></td>
		<%
		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		%>
		<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
		<%
		}
		%>
	<!-- 19112 End.-->	
	<td  width='' nowrap Align='left' class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="N" onClick='clickLine(this)' <%=check_enable%><%=displayChk%>>
		<input type="hidden" name="order_category<%=i%>" id="order_category<%=i%>" value="<%=(String)GroupBy.get(0)%>">
		<input type="hidden" name="order_status_<%=i%>" id="order_status_<%=i%>" value="<%=(String)GroupBy.get(9)%>">
		<input type="hidden" name="ord_typ_code<%=i%>" id="ord_typ_code<%=i%>" value="<%=(String)GroupBy.get(2)%>" >
		<input type="hidden" name="ord_typ_desc<%=i%>" id="ord_typ_desc<%=i%>" value="<%=(String)GroupBy.get(3)%>" >
		<input type="hidden" name="ord_id<%=i%>" id="ord_id<%=i%>" value="<%=(String)GroupBy.get(13)%>" >
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=(String)GroupBy.get(5)%>" >
		<input type="hidden" name="location_code<%=i%>" id="location_code<%=i%>" value="<%=(String)GroupBy.get(10)%>" >
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>" ><!--IN054500 -->
		<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=performing_facility_id%>" ><!-- IN054720 -->
<%
		if(view_by.equals("L"))
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(24)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(25)%>" >
<%
		}
		else
		{
%>
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=(String)GroupBy.get(21)%>" >
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=(String)GroupBy.get(22)%>" >
<%
		}
%>
	</td>
</tr>
<%
	}
 	i++; 
	}
%>

<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="order_entry" id="order_entry" value="ExistingOrder">
	<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">

<%--<input type="hidden" name="total_recs" id="total_recs" value="<%\\=resultData.size()%>" >--%>
	<input type="hidden" name="total_recs" id="total_recs" value="<%=i%>" >
	<input type="hidden" name="hidden_cunt" id="hidden_cunt" value="<%=check_count%>" >
 <!-- Parameters from the search screen --> 

	<input type="hidden" name="order_status" id="order_status" value="<%=order_status%>" >
	<input type="hidden" name="pat_id1" id="pat_id1" value="<%=patientId%>" >
	<input type="hidden" name="encounterId" id="encounterId" value="<%=encounterId%>" >
	<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>" >
	<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>" >
	<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>" >
	<input type="hidden" name="locn" id="locn" value="<%=locn%>" >
	<input type="hidden" name="order_cat" id="order_cat" value="<%=ord_category%>" >
	<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>" >
	<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>" >
	<input type="hidden" name="view_by" id="view_by" value="<%=view_by%>" >
	<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>" >
	<input type="hidden" name="order_catelog" id="order_catelog" value="<%=order_catelog%>" >
	<input type="hidden" name="ordering_pract" id="ordering_pract" value="<%=ordering_pract%>" >
	<input type="hidden" name="priority" id="priority" value="<%=priority%>" >
	<input type="hidden" name="search_crt" id="search_crt" value="<%=search_crt%>" >
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>" >
	<input type="hidden" name="activity_type" id="activity_type" value="<%=activity_type%>" >
	<input type="hidden" name="elapsed_orders" id="elapsed_orders" value="<%=elapsed_orders%>" >
	<input type="hidden" name="sys_cancelled_orders" id="sys_cancelled_orders" value="<%=sys_cancelled_orders%>" >
	<input type="hidden" name="current_ip_list_check" id="current_ip_list_check" value="<%=current_ip_list_check%>" ><!--IN049050-->
	<!-- Till here --> 
	<!-- Next, Prev --> 
	<input type="hidden" name="from" id="from" value="<%=from%>" >
	<input type="hidden" name="to" id="to" value="<%=to%>" >
	<input type="hidden" name="BTColorYN" id="BTColorYN" value="<%=BTColorYN%>" ><!--IN065091-->
	<input type="hidden" name="eSignatureYN" id="eSignatureYN" value="<%=eSignatureYN%>" > <!-- 25671  -->
	<input type="hidden" name="includeESignature" id="includeESignature" value="" > <!-- 25671  -->
	<!-- Next, Prev Till here--> 
	<script>
		//if(parent.framePatOrderByPrHeaderDtl.document.getElementById("tableheader")==null)
		//{
			//setTimeout("alignHeading();",300);
		//}
		//else 
			//alignHeading();
	</script>
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' id='t'></td>
		</tr>
	</table>
</div>
</body>
<script>parent.framePatOrderByPrivRelnSearch.document.PatOrderByPrivReln_search.search.disabled= false;</script>
<script>
	if('<%=view_by%>' == 'H')
		ondetail();
</script>
</html>

 

