<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
23/12/2011    IN029318      Chowminya G     Incident No: IN029318 - "Order Tracking-- system is show wrong ?order charge detail" 
03/04/2013    IN035929 		Karthi L		When user Place in OR/CA, user should not see Service charges. 	
07/05/2013    IN0EMG        Chowminya G     Exeception handling - unclosed connection	
24/05/2013    IN040092		Karthi L      When we Place "Order Set" Billing details are displayed.
18/02/2014 	  IN047068		Nijitha S		Trade Name Showing Twice
23/05/2019	IN068778		Selvin M		23/05/2019		Ramesh G		TBMC-CRF-0011
-------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
01/08/2014	  IN049419		Karthi L										An Audit Trail for Additional Information Amendment of Order
07/11/2014    IN052330		Chowminya						Total Charges not gets rounded off						
15/08/2016    IN059315		Raja S											When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
19/10/2017	IN065324		Dinesh T		To display the price in OR screen and the billing status in Manage Specimen screen
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
18/07/2018   IN068789		prakash C   	18/07/2018		Ramesh G		MMS-DM-CRF-0115.4
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
06/07/2020	  IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
24/09/2020	IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
21/10/2021	25188			Prabha			22/10/2021		Ramesh G	Common-ICN-0069
-------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,eOR.*,java.sql.*,webbeans.eCommon.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,ePH.* " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

 	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script> <!-- for Tool Tip-->
 	<%--<script language="JavaScript" src="../js/OrderEntrySearch.js"></script>--%>
	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- For reload --> 
	<script>
		function alignWidth() {

				 //alert(document.getElementById('detailTab').rows(last).cells.length);
			var last=eval(document.getElementById('detailTab').rows.length)-1;
			if(document.getElementById('detailTab')!=null) {
					for(i=0;i <document.getElementById('detailTab').rows[last].cells.length;i++) {
						var wid=document.getElementById('detailTab').rows[last].cells[i].offsetWidth;
						var wid1= parent.ViewOrderHeader.document.getElementById("titleTab").rows[0].cells[i].offsetWidth;
						if(eval(wid1) <eval(wid)){
							parent.ViewOrderHeader.document.getElementById('titleTab').rows[0].cells[i].width=wid;
						} else {
							document.getElementById('detailTab').rows[last].cells[i].width = wid1;
						}
					}
				}
			}
		async function showSlidingDetails(order_id, order_line_num, sliding_scale_yn){
		var slidingYesNo = document.getElementById('slidingYesNo'+order_line_num);
		//alert(slidingYesNo.value);
		if(slidingYesNo.value=="Y")
		{
		var dialogHeight= "13vh" ;
		var dialogWidth = "35vw" ;
		var dialogTop = "400" ;
		var center = "1" ;
		var status="no";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +             dialogTop;
		var arguments = "" ;
		var retVal =       await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&sliding_scale_yn="+slidingYesNo.value+"&called_frm=SlidingScale",arguments,features);
		}
		}

		function hideToolTipExisting(obj)	
		{	//alert();
			if(eval("document.getElementById('PHtooltiplayer')"+obj) )
			var tooltipvalue = eval("document.getElementById('PHtooltiplayer')"+obj);	
			//document.getElementById('tooltiplayer').style.visibility = 'hidden'
			//document.getElementById('tooltiplayer').style.visibility = 'hidden'
			//alert("visible=>"+tooltipvalue.style.visibility);
			tooltipvalue.style.visibility = 'hidden';
		}

// In Order Entry Module all the places, this method is called to display the tool tip
	function showToolTipExisting(obj) {
		resizeWindowExisting(obj);
		
	}
 
function resizeWindowExisting(obj){
		 bodwidth	= document.body.offsetWidth
		 bodheight	= document.body.offsetHeight
   		 var x		= event.x
		 var y		= event.y;
			x		= x + eval("document.getElementById('PHtooltiplayer')"+obj+".offsetWidth");
			y		= y + eval("document.getElementById('PHtooltiplayer')"+obj+".offsetHeight")
		
		 if(x<bodwidth)
			x		= event.x
		 else
			x		= x - eval("document.getElementById('PHtooltiplayer')"+obj+".offsetWidth"*2)

		 if(y<bodheight)
		 {
			 y		= event.y
		 }
		 else {
			y		= y - eval("document.getElementById('PHtooltiplayer')"+obj+".offsetHeight"*2)
		 }

		y	+=document.body.scrollTop
		x	+=document.body.scrollLeft

		var left = eval("document.getElementById('PHtooltiplayer')"+obj);
		var right = eval("document.getElementById('PHtooltiplayer')"+obj);
		
		left.style.posLeft=x;
		right.style.posTop=y;
		var toolvisibile = eval("document.getElementById('PHtooltiplayer')"+obj); 
		toolvisibile.style.visibility='visible'		 
	}
 	
	function tooltip_findPosX(obj) 
	{
		var curleft = 0;
		if (obj.offsetParent) 
		{
			while (obj.offsetParent) 
			{
				curleft += obj.offsetLeft
				obj = obj.offsetParent;
			}
		}
		else if (obj.x)
		curleft += obj.x;
		return curleft;
	}
	function tooltip_findPosY(obj) 
	{
		var curtop = 0;
		if (obj.offsetParent) 
		{
			while (obj.offsetParent) 
			{
				curtop += obj.offsetTop
				obj = obj.offsetParent;
			}
		}
		else if (obj.y)
		curtop += obj.y;
		return curtop;
	}
	function tooltip_show(tooltipId, parentId, posX, posY)
	{
		it = document.getElementById(tooltipId);
		img = document.getElementById(parentId); 
		if (posX + it.offsetWidth > img.offsetWidth) 
		posX = img.offsetWidth - it.offsetWidth;
		if (posX < 0) 
		posX = 0; 
		x = tooltip_findPosX(img) + posX;
		y = tooltip_findPosY(img) + posY;
		it.style.top = y + 'px';
		it.style.left = x + 'px';
		it.style.visibility = 'visible'; 
	}
	function tooltip_hide(id)
	{
		it = document.getElementById(id); 
		it.style.visibility = 'hidden'; 
	}
</script>
<style>
	.xstooltip 
	{
		visibility: hidden; 
		position: absolute; 
		top: 0;  
		left: 0; 
		z-index: 2; 
		font: normal 8pt sans-serif; 
		padding: 3px; 
		border: solid 1px;
	}
	tr
	{
		cursor:pointer;
	}
	.phDiv
	{
	   position:absolute; 
	   width:75%;
	   visibility:hidden;
	   float:left;
	   font-size:13; 
	   border:1px solid black
	}
	
</style>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="view_order" id="view_order">

<%
	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String bean_id1 = "Or_ViewOrder" ;
	String bean_name1 = "eOR.ViewOrder";
	boolean is_bt_view_bill_dtls = false;//IN065324

	String orderId = (request.getParameter("orderId")==null||request.getParameter("orderId").equals("null"))?"":request.getParameter("orderId");
	String order_catalog_code = (request.getParameter("order_catalog_code")==null||request.getParameter("order_catalog_code").equals("null"))?"":request.getParameter("order_catalog_code");//IN061961
	String view_by = (request.getParameter("view_by")==null||request.getParameter("view_by").equals("null"))?"":request.getParameter("view_by");//IN061961
	String order_line_num = (request.getParameter("order_line_num")==null||request.getParameter("order_line_num").equals("null"))?"":request.getParameter("order_line_num");//IN061961
	String patient_id = request.getParameter("patient_id")==null||request.getParameter("patient_id").equals("null")?"":request.getParameter("patient_id");
	String encounter_id = (request.getParameter("encounter_id")==null|| request.getParameter("encounter_id").equals("null"))?"":request.getParameter("encounter_id");
	String existing_order_called_from_new = ((String)request.getParameter("existing_order_called_from_new"))==null ? "" : (String)request.getParameter("existing_order_called_from_new");//IN074110
	//String patient_class = (request.getParameter("patient_class")==null||request.getParameter("patient_class").equals("null"))?"":request.getParameter("patient_class");
	//IN072654 Starts
	String bean_id2 		= "@existingorderbean"+patient_id+encounter_id;

	String bean_name2 = "eOR.ExistingOrder";
	ExistingOrder bean2 = (ExistingOrder)getBeanObject( bean_id2, bean_name2, request ) ;
	bean2.setLanguageId(localeName);
	//IN072654 Ends
	//if(patient_class.equals(""))patient_class="XT";
	String sex = (request.getParameter( "sex")==null||request.getParameter( "sex").equals("null"))?"":request.getParameter( "sex" ) ;
	String image_ref = (request.getParameter( "image_ref")==null||request.getParameter( "image_ref").equals("null"))?"":request.getParameter( "image_ref");
 	String ord_facility_id = request.getParameter("ord_facility_id");
    ord_facility_id = (ord_facility_id == null||ord_facility_id.equals("null")) ? "":ord_facility_id;
    String iv_prep_yn = request.getParameter("iv_prep_yn");
    iv_prep_yn = (iv_prep_yn == null||iv_prep_yn.equals("null")) ? "":iv_prep_yn;
    String ord_cat_code = request.getParameter("ord_cat_code");
	ord_cat_code = (ord_cat_code == null||ord_cat_code.equals("null")) ? "" : ord_cat_code;
	String ord_cat = request.getParameter("ord_cat");
    ord_cat = (ord_cat == null||ord_cat.equals("null")) ? "" : ord_cat;
	ArrayList allValues = new ArrayList();
	String patient_class = (request.getParameter("patient_class")==null||request.getParameter("patient_class").equals("null"))?"":request.getParameter("patient_class");//IN065324, moved the line from top to here
	//IN061961Starts
	if(ord_cat_code.equals(""))
		ord_cat_code=ord_cat;
	//IN061961Ends
	//IN065324, starts
	if(!"PH".equals(ord_cat))
		patient_class = orderId.substring(2,4);
	//IN065324, ends

	if(patient_class.equals(""))patient_class="XT";//IN065324, moved the line from top to here
	String[] order_set_record =null;
	String practitioner_type  	= (String) session.getValue("practitioner_type");//Added by Uma on 5/12/2010 for IN021330
/* Mandatory checks end */
	if( image_ref==null || image_ref==" " || image_ref.equals("null"))
		image_ref = "";
	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//ViewOrder bean1 = (ViewOrder)mh.getBeanObject( bean_id1, request,  bean_name1 ) ;
	
	String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
					
	ArrayList BillChargeInfo = null;
	String[] billing_details= null;
	String bill_call_yn = "N";
	double toatal_amt = 0.0;
	double toatal_pat_payable = 0.0;
	double toatal_pat_paid = 0.0;
	
	String amt = ""; //IN052330
	String pat_payable = ""; //IN052330
	String pat_paid = ""; //IN052330
	String cont_order_ind = "";
	
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setMode( mode ) ;

	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	
	String facility_id		= (String)session.getValue("facility_id");
	String rd_install		=  bean.getRadiology(facility_id);
	String ot_install		=  bean.getOTModule(facility_id);

	if(rd_install==null) rd_install="N";
	if(ot_install==null) ot_install="N";

	//allValues					= bean.viewOtherDetails(orderId,practitioner_type);
	allValues					= bean.viewOtherDetails(orderId,practitioner_type,order_line_num,view_by,ord_cat_code);//IN061961
	String slClassValue 		= "";
	String prepsdata 			= "";
	String rowColor 			= "";
	String ordering_facility_id = "";
	String order_category 		= "";
	String bill_yn		  		= "";
	String billed_yn	  		= "";
	String bill_legend	  		= "";
	String bill_for_facility 	= "";
	String dosage_unit			= "";
	String start_time_day_param = "";
	String pr_duration = "";
	String pr_duration_type = "";
	String appl_sliding_scale_yn = "";
	String quantity = "";
	String audit_reqd_yn = bean.getOrderFormatAuditTrailYN();//IN049419
	ArrayList order_set_allValues		 = new ArrayList();
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(facility_id); // added for IN035929
	DecimalFormat df = new DecimalFormat("0.0");//IN052330
	//Added for IN059315 starts
	Boolean custSpecificFlg=true;
	Connection con = null;
	try
	{
		con 	= ConnectionManager.getConnection(request);
		custSpecificFlg = CommonBean.isSiteSpecific(con, "CA","APPSCHEDULE_RD_RISPACS");
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally
	{
		if(con != null) ConnectionManager.returnConnection(con, request);
	}
	//Added for IN059315 Ends
		//IN072654 Starts
		HashMap<String,String> tempMap = new HashMap<String,String>();
		HashMap<String, ArrayList<OrderDrugInteractionVO>> dtlsTemp = new HashMap<String, ArrayList<OrderDrugInteractionVO>>();
		bean2.setDruginteractionYN(tempMap);
		bean2.setDruginteractionDtl(dtlsTemp);
		//IN072654 Ends
%>

<table cellpadding=3 cellspacing=0 border=1 width='100%' id='detailTab' align='center' class="grid">
<%	//System.out.println("ord_cat_code=>"+ord_cat_code);
//System.out.println("order_cat_code=>"+order_cat_code);
if (ord_cat_code.equals("PH")) {	%>
		<th align='left' class='columnheader' width='7%'><fmt:message key="Common.Form.label" bundle="${common_labels}"/></th>
		<th align='left' class='columnheader' width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<th align='left' class='columnheader' width='15%'><fmt:message key="eOR.DosageUnit.label" bundle="${or_labels}"/></th>		
	<%} else {%>
		<th align='left' class='columnheader' width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<th align='left' class='columnheader' width='7%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
	<%}%>
	
		<th align='left'  class='columnheader' width='15%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
	<th align='left' class='columnheader' width='15%' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
	<th align='left' class='columnheader' width='15%' nowrap><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
	<th align='left' class='columnheader' width='3%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
	<th align='left' class='columnheader' width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	<th align='left' class='columnheader' width='10%'><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></th>
	<th align='left' class='columnheader' width='10%'></th>
	<th align='left' class='columnheader' width='10%'></th> <!--IN068778-->

	<%
	String order_set_id			=(((String)bean.getOrderSetId(orderId)==null)?"":(String)bean.getOrderSetId(orderId));
	//String order_set_bill_yn    =(((String)bean.getOrderSetDetails(order_set_id)==null)?"N":(String)bean.getOrderSetDetails(order_set_id));
	String order_set_bill_yn[] =(String[])bean.getOrderSetViewDetails(order_set_id);   
	
	order_set_bill_yn[0]=((order_set_bill_yn[0]==null)?"N":order_set_bill_yn[0]);
	order_set_bill_yn[1]=((order_set_bill_yn[1]==null)?"":order_set_bill_yn[1]);

	//if((!(order_set_id.equals("")))&&(order_set_bill_yn.equalsIgnoreCase("Y")))
	if((!(order_set_id.equals("")))&&(order_set_bill_yn[0].equalsIgnoreCase("Y")))
	{
		if(!(order_set_bill_yn[1].equals("BT")))
			{
				bill_call_yn = "Y";
				OrderEntryBillingQueryBean billingbean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;

				order_set_allValues=billingbean.viewBillCatalogDetails(order_set_id);
				if(order_set_allValues != null && order_set_allValues.size() > 0)
				{
					for(int s=0; s<order_set_allValues.size(); s++)
					{
							order_set_record = (String [])order_set_allValues.get(s);
					}
				}
				//IN068314 Starts
				//BillChargeInfo		= billingbean.getBillChargeDetails(order_set_record[9],order_set_record[7],order_set_record[10], localeName, order_set_id,order_set_record[0],order_set_record[1],order_set_record[3],order_set_record[2],practitioner_id) ;
				if("Y".equals(order_set_record[19]))
				{
					BillChargeInfo		= billingbean.getBillChargeDetailsfpp(order_set_record[9],order_set_record[7],order_set_record[10], localeName, order_set_id,order_set_record[0],order_set_record[1],order_set_record[3],order_set_record[2],practitioner_id,order_set_record[19],order_set_record[20]) ;
				}
				else{
					BillChargeInfo		= billingbean.getBillChargeDetails(order_set_record[9],order_set_record[7],order_set_record[10], localeName, order_set_id,order_set_record[0],order_set_record[1],order_set_record[3],order_set_record[2],practitioner_id) ;
				}
				//IN068314 Ends
				if(BillChargeInfo!=null)
				{
					for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
					{
						billing_details 	= (String[])BillChargeInfo.get(k);				
						toatal_amt =toatal_amt+ Double.parseDouble(bean.checkForNull(billing_details[2],"0.0"));
						//toatal_amt += Double.parseDouble(bean.checkForNull(billing_details[2],"0.0"));
						toatal_pat_payable =toatal_pat_payable+ Double.parseDouble(bean.checkForNull(billing_details[3],"0.0"));
					//toatal_pat_payable += Double.parseDouble(bean.checkForNull(billing_details[3],"0.0"));
						toatal_pat_paid =toatal_pat_paid+ Double.parseDouble(bean.checkForNull(billing_details[6],"0.0"));
						//toatal_pat_paid += Double.parseDouble(bean.checkForNull(billing_details[6],"0.0"));
						//IN052330 - Start
						amt = df.format(toatal_amt);
						pat_payable = df.format(toatal_pat_payable);
						pat_paid = df.format(toatal_pat_paid);
						//IN052330 - End
					}
				}
						
		%>
				<tr style='border-width:0'><td colspan="3" class='<%=rowColor%>' style='border-width:0'><B><fmt:message key="eOR.OrderSetBillingDetails.label" bundle="${or_labels}"/>:</B></td><td colspan="6" style='border-width:0'><!-- <table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' style='border-width:0'> --><!--  commented for IN040092[IN035929] --> 
				<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;<%}else{%>style='border-width:0;display:none' <%}%>>  <!--  modified  for IN040092[IN035929] --> 
					<tr >
							<td colspan="" width='5%' class='<%=rowColor%>' style='border-width: 0;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
							<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='20%' class='<%=rowColor%>' style='border-width: 0;text-align: right;' nowrap><font class='label' size="1"><B><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='17%' class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></B></font></td>
						</tr>
						<tr>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0'></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=order_set_id%>'><%=bean.checkForNull(billing_details[2],"0.0")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=order_set_id%>'><%=bean.checkForNull(billing_details[3],"0.0")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='pat_payable<%=order_set_id%>'><%=bean.checkForNull(billing_details[6],"0.0")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=order_set_id%>'><%=(bean.checkForNull(billing_details[4],"").equals("E"))?"No":(bean.checkForNull(billing_details[4],"").equals("I")?"Yes":"")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=order_set_id%>'><%=(bean.checkForNull(billing_details[5],"").equals("Y"))?"Yes":(bean.checkForNull(billing_details[5],"").equals("N")?"No":"")%></font></td>
						</tr>
					</table></td></tr>
<%				}} else{ 
						out.println("");
				}
				for(int i=0; i<allValues.size(); i++){

				String[] record = (String [])allValues.get(i);
				slClassValue="gridData";
				if(record[0] == null) record[0] = "";
				if(record[1] == null) record[1] = "";
				if(record[2] == null) record[2] = "";
				if(record[3] == null) record[3] = "";
				if(record[4] == null) record[4] = "";
				if(record[5] == null) record[5] = "";
				if(record[7] == null) record[7] = "";
				if(record[8] == null) record[8] = "";
				if(record[10] == null) record[10] = "";
				if(record[11] == null) record[11] = "";
				ordering_facility_id  = record[19] ; //this is added_by_id  of the table
				if(record[34] == null) record[34] = "N";
				if(record[35] == null) record[35] = "";
				if(record[37] == null) record[37] = "";
				if(record[38] == null) record[38] = "";
				if(record[39] == null) record[39] = "";
				if(record[41] == null) record[41] = "";
				if(record[42] == null) record[42] = "";
				if(record[43] == null) record[43] = "";
				if(record[44] == null) record[44] = "";
				if(record[45] == null) record[45] = "";
				if(record[46] == null) record[46] = "";
				if(record[47] == null) record[47] = "T";
				if(record[51] == null) record[51] = "";//added for skr-scf-1723

				// Added By Sridhar Reddy 060909 SRR20056-CRF-0274
				start_time_day_param = record[2] ;
				if(!localeName.equals("en"))
				{
					start_time_day_param = com.ehis.util.DateUtils.convertDate(start_time_day_param,"DMYHM","en",localeName);
				}
				pr_duration = record[40] ;
				pr_duration_type = record[7] ;				
				quantity =  record[36] ;		
				appl_sliding_scale_yn =  record[46] ;		
				// End SRR20056-CRF-0274
				
				image_ref				= 	record[34];
				
				String appt_reqd_yn 			= record[20];
				String appt_date_time 			= record[21];
				String appt_ref_num 			= record[22];
				cont_order_ind			= record[23];
				String parent_order_id			= orderId;
				String parent_order_line_num	= record[9] ;
				bill_yn							= record[26];
				billed_yn						= record[27];
				dosage_unit						= record[28];
				

				if (appt_reqd_yn == null) appt_reqd_yn = "";
				if (appt_date_time == null) appt_date_time = "";
				if (appt_ref_num == null) appt_ref_num = "";
				if (cont_order_ind == null) cont_order_ind = "";
				if (parent_order_id == null) parent_order_id = "";
				if (parent_order_line_num == null) parent_order_line_num = "";
				if (bill_yn==null) bill_yn = "";
				if (billed_yn==null) billed_yn = "";
				if (dosage_unit == null) dosage_unit = "";

				
				order_category = record[14];
				//prepsdata = bean.getPrepsdata(orderId,record[9]);//IN64543
				prepsdata = CommonBean.checkForNull(bean.getPrepsdata(orderId,record[9]),"");//IN64543
				bean1.setPrepsData(prepsdata,i);
				bill_for_facility = bean.getBillForFacility(ord_facility_id);
				bill_for_facility = (bill_for_facility == null) ? "N" : bill_for_facility;
				if(record[16].trim().equals("RED") || record[8].trim().equals("RD") || record[8].trim().equals("RJ")) rowColor = "orcancel"; else rowColor = slClassValue;

				String deptData  = "";
				//deptData = bean.getDeptdata(orderId,record[9]);//IN64543
				deptData = CommonBean.checkForNull(bean.getDeptdata(orderId,record[9]),"");//IN64543
				bean1.setDeptData(deptData,i);

		String instruction = "";
		//String no_of_days = (String)bean.getPatientNoOfDays( patient_id, orderId) ;
		//if(no_of_days == null) no_of_days = ""; else	no_of_days = no_of_days.trim();
		//instruction = bean.getPatientInstruction(record[18],no_of_days,sex) ;
		//instruction = bean.getPatientInstruction(orderId,record[9]);//IN64543
		instruction = CommonBean.checkForNull(bean.getPatientInstruction(orderId,record[9]),"");//IN64543
		//if(instruction == null)	instruction = "";//IN64543
		String schd_yn = "";
		String interval_type = "";
		String freq_code = record[6];
		if(freq_code == null)	freq_code = "";
		if(!freq_code.equals(""))
		{
			String schedule[]  =  (String[])bean.getScheduleYN(freq_code) ;
			schd_yn = schedule[0];
			interval_type = schedule[1];
		}
		bean1.setIntervalType(interval_type);
		//schd_yn  = "Y";
		boolean showBill = false;
		if(interval_type == null)	interval_type = "";
		if(schd_yn == null)			schd_yn = "";
	
			if(!(record[8].trim().equals("CN") || record[8].trim().equals("DC") || record[8].trim().equals("RD") || record[8].trim().equals("RJ"))){
				if(bill_for_facility.equals("Y")) {
					if(bill_yn.equals("Y"))	{
						showBill = true;
						if(billed_yn.equals("Y"))
							bill_legend	= "Billed";
						else
							bill_legend  = "Not Billed";
					}else
						showBill = false;
				}
			}	
			
			//IN065324, starts
			
			/*
			if(record[41].trim().equals("BT"))
			{
				showBill = false;
			}*/			
			
			if("Y".equals(bill_yn) && showBill)
			{
				if(is_bt_view_bill_dtls && "BT".equals(record[41].trim()) && ("OP".equals(patient_class) || "EM".equals(patient_class)))
				{
					showBill = true;
				}
				else if("BT".equals(record[41].trim()))
				{
					showBill = false;
				}
			}
			//IN065324, ends
			%>
			<%--<Script>alert('appt_reqd_yn=<%=appt_reqd_yn%>,appt_ref_num=<%=appt_ref_num%>,appt_date_time=<%=appt_date_time%>,cont_order_ind=<%=cont_order_ind%>')</Script>--%>

		<tr>
				<%
			/*Commented for incident IN047068*/	
			/*if(ord_cat_code.equalsIgnoreCase("PH")||ord_cat_code.equalsIgnoreCase("PH"))
			{
				String tradename=bean.getTradeName(orderId,record[9]);
				if (tradename == null) tradename = "";
				if(!tradename.equals("**"))
				record[0]=record[0]+"["+tradename+"]";					
			}*/
			
			if(ord_cat_code.equalsIgnoreCase("RD")||ord_cat_code.equalsIgnoreCase("RD"))
			{
				if(record[0].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])record[0].split("!~!");
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
							order_detail = order_detail+strtitle[0]+strtitle[2];
						}
						else
						{
							order_detail = order_detail+str[s];
						}
					}
					record[0] = order_detail;
				}
			}
			if(record[10].indexOf("!~!")!=-1)
			{
				record[10]=record[10].replace("!~!",",");
			}
			if (ord_cat_code.equals("PH")) 
			{	
				String	probean_id			=	"QueryPatientDrugProfileBean" ;
				String	probean_name		=	"ePH.QueryPatientDrugProfileBean";
				QueryPatientDrugProfileBean probean = (QueryPatientDrugProfileBean)getBeanObject( probean_id,probean_name, request) ;
	
				//ArrayList sliding_scale_details =   probean.getSlidingScaleTemplateDetails(orderId,parent_order_line_num);// IN068789
				ArrayList sliding_scale_details =   probean.getSlidingScaleTemplateDetails(orderId,parent_order_line_num,"","");// IN068789
				String sRemarks="&nbsp;";
				boolean blTempFound = false;
				
				
				String slidingYN =bean.getSlidingYN(orderId,parent_order_line_num); //modified for Common-ICN-0069
				
			/*	//Connection connection			= null; //commented for Common-ICN-0069
				PreparedStatement pstmt			= null;      		
				ResultSet resultSet				= null;
				String slidingYN	= "";	
				//Included to handle exception - Start IN0EMG
				try 
				{				
				//connection	= ConnectionManager.getConnection();
		 		//pstmt		= connection.prepareStatement("SELECT SLIDING_SCALE_YN FROM OR_ORDER_LINE_PH where ORDER_ID = ? AND ORDER_LINE_NUM= ?");
				pstmt		= con.prepareStatement("SELECT SLIDING_SCALE_YN FROM OR_ORDER_LINE_PH where ORDER_ID = ? AND ORDER_LINE_NUM= ?");
				pstmt.setString(1,orderId);			
				pstmt.setString(2,parent_order_line_num);			
				resultSet	= pstmt.executeQuery() ;
				if (resultSet !=null && resultSet.next())
				{
					slidingYN = resultSet.getString("SLIDING_SCALE_YN");
				}
				}catch(Exception e){
				e.printStackTrace();
				}finally
				{
					//if(connection!=null) 
						//ConnectionManager.returnConnection(connection,request);
				}//Included to handle exception - end IN0EMG */   //commented for Common-ICN-0069
			%>
			<td width='7%' class='<%=rowColor%>'><font size=1><%=bean.getFormDesc(record[29])%></td>
			<td width='15%' class='<%=rowColor%>' id='showToolTipTD<%=parent_order_line_num%>' onclick="showSlidingDetails('<%=orderId%>','<%=record[9]%>','<%=slidingYN%>')" onMouseOver='tooltip_show("PHtooltiplayer<%=parent_order_line_num%>","showToolTipTD<%=parent_order_line_num%>",300,30)' onMouseOut="tooltip_hide('PHtooltiplayer<%=parent_order_line_num%>')"><font size=1><%=record[0]%>
			<div name="PHtooltiplayer<%=parent_order_line_num%>" id="PHtooltiplayer<%=parent_order_line_num%>" style="position:absolute; width:75%;visibility:hidden;float:left;font-size:13; ">
			<input type='hidden' name='slidingYesNo<%=parent_order_line_num%>' id='slidingYesNo<%=parent_order_line_num%>' value='<%=slidingYN%>'/>
			<table id="tblSlidingdetail" width="100%" height="100%" align="center" cellpadding="1" cellspacing="0" border="1">
			<%
				if(slidingYN.equalsIgnoreCase("Y"))
				{
					if(sliding_scale_details.size()>1)
					{
					blTempFound = true;
			%>			
			<tr>
				<th style="font-size:13; border-bottom:1px solid white;" colspan=6 > <%=(String)sliding_scale_details.get(9)%></th>		
			</tr>
			<tr>
				<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.FROMRANGE.label" bundle="${ph_labels}"/></th>
				<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.TORANGE.label" bundle="${ph_labels}"/></th>
				<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></th>
				<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/></th>
				<th align="left" style="font-size:9" nowrap><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/></th>
				<th align="left" style="font-size:9" nowrap width='150px'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			</tr>
<%
			String toRan="";
			String admUnit="";
			for(int sl=1;sl<sliding_scale_details.size();sl+=9){
				toRan=((String)sliding_scale_details.get(sl+3)).equals("0")?(">"+(String)sliding_scale_details.get(sl+2)):(String)sliding_scale_details.get(sl+3);
				admUnit=(String)sliding_scale_details.get(sl+4);
				if(admUnit!=null && !admUnit.equals("")){
					float admUnitValue=Float.parseFloat(admUnit);
					if(admUnitValue>0.0 && admUnitValue<1.0)
						admUnit=Float.parseFloat(admUnit)+"";
				}
				
				if(((String)sliding_scale_details.get(sl+7)).equalsIgnoreCase("null") || ((String)sliding_scale_details.get(sl+7)).equals(" ") || sliding_scale_details.get(sl+7) ==null)
					sRemarks = "&nbsp;";
				else
					//sRemarks = (String)sliding_scale_details.get(sl+7);
					sRemarks = java.net.URLDecoder.decode((String)sliding_scale_details.get(sl+7),"UTF-8");

%>
				<tr>
					<td nowrap><%=(String)sliding_scale_details.get(sl+2)%></td>
					<td nowrap><%=toRan%></td>	
					<td nowrap><%=(String)sliding_scale_details.get(sl+5)%></td>	
					<td nowrap><%=admUnit%></td>	
					<td nowrap><%=(String)sliding_scale_details.get(sl+6)%></td>
					<td width='20%'><%=sRemarks%></td>	
				</tr>
<%
			}
		}
		else{
%>
			<tr>
				<th style="font-size:13; border-bottom:1px solid white;" colspan=6 >No Templates Found</th>	
			</tr>
<%
		}
		%>
		<script>
			document.getElementById("PHtooltiplayer<%=parent_order_line_num%>").className = 'phDiv';
			//document.getElementById("PHtooltiplayer<%=parent_order_line_num%>").style 'border:1px solid black';
		</script>
		<%
	}
%>
			</table>
			</div>
 <%
				if(!bean.checkForNull(record[35],"").equals("")) {
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		
%>
			</td>
			<td width='15%' class='<%=rowColor%>'><font size=1><%=dosage_unit%></Font>
			<%if ((bean.getSplitDosageYN(parent_order_id,parent_order_line_num)).equalsIgnoreCase("Y")) {%>
			<BR><Font size='1' color='red'>(<fmt:message key="eOR.SplitDosage.label" bundle="${or_labels}"/>)</Font>
			<%}%>
			</td>
			<%
			
			} 
			else 
			{
			%>
 				<td width='15%' class='<%=rowColor%>' onMouseOver='showToolTip("<%=record[13]%>","view_order")' onMouseOut="hideToolTip()" rowspan="<%=showBill?"2":"0"%>"><font size=1>
			<%if(image_ref.equals("Y")){
			%>
				<a class='gridLink' href='#' onClick="viewImageDetails(escape('<%=orderId%>'))"><%=record[0]%></a>
			<%}else{%>
				<%=record[0]%>
			<%}%>
 <%
				if(!bean.checkForNull(record[35],"").equals("")) {
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		
%>
			</td>
	<% if(record[1].equalsIgnoreCase("routine"))
			{
				record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
			else if(record[1].equalsIgnoreCase("urgent"))
			{
				record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
			}
			else
			{
				record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}
	%>

			<td width='7%' class='<%=rowColor%>' rowspan='<%=showBill?"2":"0"%>'><font size=1><%=record[1]%></td>
			<%}%>
			<td width='15%' class='<%=rowColor%>' rowspan=''><font size=1><% if(!(record[38].equalsIgnoreCase("MS") && record[14].equals("PH"))) out.println(record[10]);%></td>
			<td width='15%' class='<%=rowColor%>' rowspan=''><font size=1><%=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName)%></td>
			<td width='15%' class='<%=rowColor%>'><font size=1><%if(!(record[38].equalsIgnoreCase("MS") && record[14].equals("PH"))){out.println(com.ehis.util.DateUtils.convertDate(record[3],"DMYHM","en",localeName));}%></td>
			<td width='3%' class='<%=rowColor%>'><font size=1><%=record[4]%> </td>
			<td width='10%' class='<%=rowColor%>'><font size=1>
			<%String can_reason = "";
				if(record[17]!=null && !record[17].equals("")) {%>
					<%can_reason = record[17].replace('\"','\n');
					}
			%>
			<input type="hidden" name="Cancel<%=i%>" id="Cancel<%=i%>" value="<%=can_reason%>">
				<%if(record[16].trim().equals("RED") || record[8].trim().equals("DC") || record[8].trim().equals("RD") || record[8].trim().equals("RJ") || (!can_reason.equals(""))){
				
				String str_value;

					if(record[8].trim().equals("HC"))
						str_value = "Hold";
					
					else if(record[8].trim().equals("DC"))
						str_value = "Discontinue";

					else if(record[8].trim().equals("RD") )
						str_value = "Replaced";
                    else if(record[8].trim().equals("RG") )
						str_value = "Registered";
	 				else if(record[8].trim().equals("CN") )
						str_value = "Cancel Reason";
					else
						str_value = record[5];
				
				%><a class="gridLink"  href="javascript:viewOrderFormatLineCmts('','<%=i%>','<%=record[9]%>','<%=orderId%>')"><%}%>
				<%=record[5]%>
				<input type="hidden" name="Can_Reason<%=i%>" id="Can_Reason<%=i%>" value="<%=record[5]%>">
			</td>
			<%//added for skr-scf-1723
			System.out.println("record[51]"+record[51]);
			if(!record[51].equals("5")){ %><td width='10%' class='<%=rowColor%>'><font size=1><a class="gridLink"  href="javascript:viewOrderFormatLineDtl('<%=orderId%>','<%=record[9]%>')"><%=record[11]%></a></td>
			<%}else{
			%>
			<td width='10%' class='<%=rowColor%>'><font size=1><a class="gridLink"  ><%=record[11]%></a></td>
				
		<%	}%>
			
			<td width='10%' class='<%=rowColor%>' rowspan='<%=showBill?"2":""%>'><font size=1>
			<%--<input type="hidden" name="Cmts<%=i%>" id="Cmts<%=i%>" value="<%=record[12]%>">--%>
	<!--Added for IN059315 starts -->
			    <%
				//if(record[12]!=null && !record[12].equals("") && custSpecificFlg)//IN059315, modified by Dinesh T on 21/09/2017
				if(record[12]!=null && !record[12].equals("") && order_category.equals("RD") && custSpecificFlg)//IN059315, modified by Dinesh T on 21/09/2017
				{ 
					%> 
				 <fmt:message key="Common.Comments.label" bundle="${common_labels}"/> 
	<!--Added for IN059315 Ends -->
				<%}else 
			      if(record[12]!=null && !record[12].equals("")) {
			    	if(audit_reqd_yn.equalsIgnoreCase("N")){ // IN049419  
				%>
						<a class="gridLink"  href="javascript:viewOrderFormatLineCmts('Comments','<%=i%>','<%=record[9]%>','<%=orderId%>')"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a>
				<%	
					// IN049419 - Start
			    	} else {
				%>
						<a  class="gridLink" href="javascript:viewOrderLineAuditData('<%=orderId%>','<%=record[9]%>','Comments','<%=i%>')"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a>	
				<%  } // IN049419 - End 
			    	} else { %>
				    <fmt:message key="Common.Comments.label" bundle="${common_labels}"/>
				<% } %>
				<% if(!"EXTERNAL_ORDER".equals(existing_order_called_from_new)  && order_category.equals("LB") && null!=record[50] && Integer.valueOf(record[50])>0 ){//IN072654 Starts
					//IN072654 Starts
					HashMap<String, String> interactionYN = null;
					String checkUncheck =null;
					
					HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
					bean2.setPatientId(patient_id);//IN072654
					bean2.setEncntrId(encounter_id);//IN072654
					bean2.getDrugInteractionDtls(record[13],orderId,"",record[9]);
					
					//IN072654 Ends
					
					%>
			<a  class="gridLink" href="javascript:viewInteractionDtls('<%=record[13] %>','<%=patient_id%>','<%=encounter_id%>')"><fmt:message key="eOR.InteractionDtls.label" bundle="${or_labels}"/></a>
			<%}//IN072654 ends %>
			<!--<input type="hidden" name="Preps<%=i%>" id="Preps<%=i%>" value="<%=prepsdata%>">
			<input type="hidden" name="Depts<%=i%>" id="Depts<%=i%>" value="<%=deptData%>">
			<input type="hidden" name="Instruction<%=i%>" id="Instruction<%=i%>" value="<%=instruction%>">-->
			<input type="hidden" name="Appt<%=i%>" id="Appt<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="Appt_date<%=i%>" id="Appt_date<%=i%>" value="<%=appt_date_time%>">
			<input type="hidden" name="appt_locn<%=i%>" id="appt_locn<%=i%>" value="<%=record[30]%>">
			<input type="hidden" name="appt_resched_yn<%=i%>" id="appt_resched_yn<%=i%>" value="<%=record[31]%>">
			<input type="hidden" name="appt_resched_reason<%=i%>" id="appt_resched_reason<%=i%>" value="<%=record[32]%>">
			<input type="hidden" name="no_of_reschedules<%=i%>" id="no_of_reschedules<%=i%>" value="<%=record[33]%>">
			<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>">
			<input type="hidden" name="parent_order_id<%=i%>" id="parent_order_id<%=i%>" value="<%=parent_order_id%>">
			<input type="hidden" name="performing_facility_id<%=i%>" id="performing_facility_id<%=i%>" value="<%=record[39]%>">
			<input type="hidden" name="parent_order_line_num<%=i%>" id="parent_order_line_num<%=i%>" value="<%=parent_order_line_num%>">
            <input type=hidden name='catalog_code<%=i%>' id='catalog_code<%=i%>' value='<%=record[13]%>'>
            <input type=hidden name="catalog_desc<%=i%>" id="catalog_desc<%=i%>" value="<%=record[0]%>">
            <input type=hidden name="order_category<%=i%>" id="order_category<%=i%>" value="<%=order_category%>">
            <%-- <input type=hidden name="item_narration<%=i%>" id="item_narration<%=i%>" value="<%=record[12]%>"> --%> <!-- Added for IN059315--><!-- commented for IN64543-->
            <INPUT TYPE="hidden" name="instrn_type<%=i%>" id="instrn_type<%=i%>" value="<%=record[47]%>">
			<% if(!(prepsdata.equals(""))){ if(audit_reqd_yn.equalsIgnoreCase("N")){    %><br> <a class="gridLink" href="javascript:viewPrepsData(escape('<%=i%>'))"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a> <%} else {%><br><a  class="gridLink" href="javascript:viewOrderLineAuditData(escape('<%=orderId%>'),'<%=record[9]%>','PAT_PREPS_TEXT','<%=i%>')"><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></a><%} }else { %><br><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/>  <%}%> <!--  IN049419 -->
				<% if(!(deptData.equals(""))){if(audit_reqd_yn.equalsIgnoreCase("N")){  %><br> <a class="gridLink"  href="javascript:viewDeptData(escape('<%=i%>'))"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a> <%} else {%><br><a  class="gridLink" href="javascript:viewOrderLineAuditData(escape('<%=orderId%>'),'<%=record[9]%>','DEPT_INSTRNS','<%=i%>')"><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></a><%}}else {%><br><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/>  <%}%> <!--  IN049419 -->
				<% if(!(instruction.equals(""))){ if(audit_reqd_yn.equalsIgnoreCase("N")){ %>
					<a class="gridLink"  href="javascript:viewPatientData('<%=orderId%>','<%=record[9]%>','<%=i%>')"><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></a> <%} else {%><br><a  class="gridLink" href="javascript:viewOrderLineAuditData(escape('<%=orderId%>'),'<%=record[9]%>','PATIENT_INSTRNS','<%=i%>')"><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></a><%}}else{%><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/> <% }%>  <!--  IN049419 -->
				<!--<a href="javascript:viewPatientData('<%=record[18]%>','<%=orderId%>','<%=patient_id%>','<%=sex%>')"><br>Pat.Instrn</a>-->
				<%--<Script>alert('order_category=<%=order_category%>,iv_prep_yn=<%=iv_prep_yn%>,parent_order_line_num=<%=parent_order_line_num%>,schd_yn=<%=schd_yn%>')</Script>--%>
				<% if((schd_yn.equals("Y"))){
					if(!order_category.equalsIgnoreCase("PH")) {
				%><br><a class="gridLink"   href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ordering_facility_id%>','<%=freq_code%>','<%=order_category%>','view_order','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%} else if (order_category.equalsIgnoreCase("PH") && (!iv_prep_yn.equals("")) && parent_order_line_num.equalsIgnoreCase("1")) {%>
				<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ordering_facility_id%>','<%=freq_code%>','<%=order_category%>','view_order','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%} else if (order_category.equalsIgnoreCase("PH") && (iv_prep_yn.equals(""))) {%>
				<br><a class="gridLink"  href="javascript:viewScheduleData('<%=orderId%>','<%=record[9]%>','<%=interval_type%>','<%=ordering_facility_id%>','<%=freq_code%>','<%=order_category%>','view_order','<%=pr_duration%>','<%=pr_duration_type%>','<%=quantity%>','<%=appl_sliding_scale_yn%>','<%=start_time_day_param%>')"><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/></a>
				<%}
				}%>
				<%--<%else {%>
				<br><fmt:message key="eOR.Schd.label" bundle="${or_labels}"/><% } %>--%>
				<% if((!appt_ref_num.equals("")) && (!appt_date_time.equals(""))){//(appt_reqd_yn.equals("Y")) && 
			
					
				%>	<br>
					<%  if( (record[14].equals("RD") && rd_install.equals("Y")) || (record[14].equals("OT") && ot_install.equals("Y")) )  { %>
						<a class="gridLink"  href="javascript:viewApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
					<% } else { %> 
						<a class="gridLink"  href="javascript:viewOAApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>				
					<% } %>		
				<%} else if (!(cont_order_ind.equalsIgnoreCase("DO") || cont_order_ind.equalsIgnoreCase("CO"))){
					String apptYN = bean.getAppointmentYN(parent_order_id,parent_order_line_num);%>
					<%--<Script>alert('apptYN=<%=apptYN%>,parent_order_id=<%=parent_order_id%>,parent_order_line_num=<%=parent_order_line_num%>')</Script>--%>
					<%if (apptYN != null && apptYN.equalsIgnoreCase("Y")) {%>
					<br>
					<%  if( (record[14].equals("RD") && rd_install.equals("Y")) || (record[14].equals("OT") && ot_install.equals("Y")) )  { %>
						<a class="gridLink"  href="javascript:viewApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>
					<% } else { %> 
						<a class="gridLink"  href="javascript:viewOAApptData(escape('<%=i%>'))"><fmt:message key="eOR.ApptDetails.label" bundle="${or_labels}"/></a>				
					<% } %>		
  					<%}
				}%>
				<%					
					if(!(record[8].trim().equals("CN") || record[8].trim().equals("DC") || record[8].trim().equals("RD") || record[8].trim().equals("RJ"))){
						if(bill_for_facility.equals("Y")) {
							if(bill_yn.equals("Y"))	{
								if(billed_yn.equals("Y"))
									bill_legend	= "Billed";
								else
								    bill_legend  = "Not Billed";
						%>
								<!-- <br><a href="javascript:viewBillingDetails(escape('<%=i%>'))"><%=bill_legend%></a> -->
						<%	}
						}

					}	%>
			</td>							
		</tr>
		<input type=hidden name='catalog_code' id='catalog_code' value='<%=record[13]%>'>
		<input type="hidden" name="explanatory_text<%=record[13]%>" id="explanatory_text<%=record[13]%>" value="<%=record[35]%>"> <%-- explanatory_text--%>
		<tr style="display:<%=showBill?"inline":"none"%>">
<%			if(!showBill){%>
			<td class='<%=rowColor%>'></td>
			<td class='<%=rowColor%>'></td>
		<!--	<td class="<%=rowColor%>"></td>
			 <td class="<%=rowColor%>"></td> -->
			<%}%>
				<td class='<%=rowColor%>' colspan='<%=showBill?"6":"0"%>'>
					<%		
				if(showBill) 
				{
					if(bill_call_yn.equals("N"))
						bill_call_yn = "Y";
					OrderEntryBillingQueryBean billingbean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
					//IN068314 Starts
					//BillChargeInfo		= billingbean.getBillChargeDetails(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,record[43],record[44],practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations // --[IN029318] - Modified ent_id n pat_cls
					if("Y".equals(record[48])){
						BillChargeInfo		= billingbean.getBillChargeDetailsfpp(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,record[43],record[44],practitioner_id,record[48],record[49]) ; 
					}
					else{
						BillChargeInfo		= billingbean.getBillChargeDetails(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,record[43],record[44],practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations // --[IN029318] - Modified ent_id n pat_cls
					}
					//IN068314 Ends
					
					if(BillChargeInfo!=null)
					{
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
							billing_details 	= (String[])BillChargeInfo.get(k);
							toatal_amt =toatal_amt+ Double.parseDouble(bean.checkForNull(billing_details[2],"0.0"));
							toatal_pat_payable =toatal_pat_payable+ Double.parseDouble(bean.checkForNull(billing_details[3],"0.0"));
							toatal_pat_paid =toatal_pat_paid+ Double.parseDouble(bean.checkForNull(billing_details[6],"0.0"));
							//IN052330 - Start
							amt = df.format(toatal_amt);
							pat_payable = df.format(toatal_pat_payable);
							pat_paid = df.format(toatal_pat_paid);
							//IN052330 - End
						}
					}
					if(show_bill_info_yn.equalsIgnoreCase("Y")) {
						
%>
						<!--<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' style='border-width:0'>  --><!--  commented for IN040092[IN035929] --> 
						<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%>>  <!--  modified  for IN040092[IN035929] --> 
							<tr >
								<td colspan="" width='5%' class='<%=rowColor%>' style='border-width: 0;'><font class='label' size="1"><B><%if(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("DR")||(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("CR")))
								{%><fmt:message key="Common.Unit.label" bundle="${common_labels}"/><%}%>&nbsp;<fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
								<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
								<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></B></font></td>
								<%							if(!(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("DR")||(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("CR"))))
								{
								%>
									<td colspan="" width='20%' class='<%=rowColor%>' style='border-width: 0;text-align: right;' nowrap><font class='label' size="1"><B><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></B></font></td>
								<%
								}
								if(bean.checkForNull(billing_details[10],"").equalsIgnoreCase("S"))
								{
								%>
									<td colspan="" width='18%' class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
									<td colspan="" width='17%' class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></B></font></td>
								<%
								}
								StringBuffer menu_text1 = new StringBuffer();
								menu_text1.append( "'+getLabel('Common.view.label','Common')+'");
								if(!ord_cat.equalsIgnoreCase("PH")&&bill_yn.equalsIgnoreCase("Y") && show_bill_info_yn.equalsIgnoreCase("Y"))// condition added for IN035929
								{
								%>
									<td class='<%=rowColor%>' width='' nowrap><a class="gridLink" href="javascript:callBilling('<%=i%>','<%=orderId%>','<%=record[42]%>','<%=record[39]%>','<%=record[43]%>','<%=record[44]%>','<%=ord_cat%>','<%=record[45]%>','<%=menu_text1%>','<%=orderId%>','<%=bean.checkForNull(record[37],"")%>')" title='Charge Details'> <!--<fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>--><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></a></td> 
								<%
								}
								%>
							</tr>
							<tr>
								<td colspan="" class='<%=rowColor%>' style='border-width: 0'><a class='gridLink'  href='#' onClick="showChildOrders(escape('<%=orderId%>'),escape('<%=patient_id%>'),escape('<%=encounter_id%>'),escape('<%=patient_class%>'),escape('<%=sex%>'),escape('<%=image_ref%>'),escape('<%=ord_facility_id%>'),escape('<%=iv_prep_yn%>'),escape('<%=ord_cat%>'),escape('<%=bean.checkForNull(request.getParameter("function_id"))%>'))" nowrap><%=(cont_order_ind.equals("CR") || cont_order_ind.equals("DR"))? "Child Orders" : "" %></a> </td>
								<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull(billing_details[2],"0.0")%></font></td>
								<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull(billing_details[3],"0.0")%></font></td>
								<%							if(!(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("DR")||(bean.checkForNull(cont_order_ind,"").equalsIgnoreCase("CR"))))
								{
								%>
									<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='pat_payable<%=i%>'><%=bean.checkForNull(billing_details[6],"0.0")%></font></td>
								<%
								}
								if(bean.checkForNull(billing_details[10],"").equalsIgnoreCase("S"))
								{
								%>
									<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=(bean.checkForNull(billing_details[4],"").equals("E"))?"No":(bean.checkForNull(billing_details[4],"").equals("I")?"Yes":"")%></font></td>
									<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=(bean.checkForNull(billing_details[5],"").equals("Y"))?"Yes":(bean.checkForNull(billing_details[5],"").equals("N")?"No":"")%></font></td>
								<%
								}
								%>
							</tr>
						</table>
						
<%					}
				} else{ 
						out.println("");
				}
%>
					
				</td>
			<!-- <td class="<%=rowColor%>"></td>
			<td class="<%=rowColor%>"></td>
			<td class="<%=rowColor%>"></td> -->
<%			if(!showBill)%>
			<td class="QRYEVEN"></td>
			
		</tr>
<%	
}
%>
<tr style='visibility:hidden; display:none'>
		<td class='columnheader' width=''><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width=''></td>

</tr>
</table>
<input type='hidden' name='ordering_facility_id' id='ordering_facility_id' value='<%=ord_facility_id%>'>
<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type=hidden name='view_bean_id' id='view_bean_id' value='<%=bean_id1%>'>
<input type=hidden name='view_bean_name' id='view_bean_name' value='<%=bean_name1%>'>
<input type=hidden name='orderId' id='orderId' value='<%=orderId%>'>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type=hidden name='function_from' id='function_from' value='View'>
<input type="hidden" name="pr_duration" id="pr_duration" value="<%=pr_duration%>">
<input type="hidden" name="pr_duration_type" id="pr_duration_type" value="<%=pr_duration_type%>">
<INPUT TYPE="hidden" name="start_time_day_param" id="start_time_day_param" value="<%=start_time_day_param%>">
<INPUT TYPE="hidden" name="quantity" id="quantity" value="<%=quantity%>">
<INPUT TYPE="hidden" id=order_catalog_code name=order_catalog_code value="<%=order_catalog_code%>"><!--IN061961 -->
<INPUT TYPE="hidden" id="view_by" value="<%=view_by%>"><!--IN061961 -->
<INPUT TYPE="hidden" id="order_line_num" value="<%=order_line_num%>"><!--IN061961 -->
<INPUT TYPE="hidden" id="ord_cat" value="<%=ord_cat%>"><!--IN061961 -->

<%--<script>
			if(parent.ViewOrderHeader.document.getElementById('titleTab')!=null) {
				alignWidth();
			}
</script>--%>
<%	
if(bill_call_yn.equals("Y") && show_bill_info_yn.equals("Y")){
%>
 <script>showTotalBilling('<%=amt%>','<%=pat_payable%>','<%=pat_paid%>','<%=cont_order_ind%>')</script>  <!-- IN052330 changed param toatal_amt, toatal_pat_payable, toatal_pat_paid -->
<%}

%>
<script>
	enableAuditTrail();
</script>
</body>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden;' bgcolor='blue'>
 		<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' align='center'>
 		   	<tr>
 		 		<td width='100%' id='t'></td>
 			</tr>
 		</table>
	</div>

</form>
</html>

<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
}
catch(Exception e)
{e.printStackTrace();}
%>

