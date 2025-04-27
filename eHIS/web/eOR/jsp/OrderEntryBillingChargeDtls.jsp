<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
14/09/2012    IN034785      Chowminya G     Incident No: IN034785 <In the multi-facility scenario -  Charge details display> 
19/10/2017	IN065324		Dinesh T		To display the price in OR screen and the billing status in Manage Specimen screen
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
--------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<title><fmt:message key="eOR.BillingChargesDetails.label" bundle="${or_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderBillingChargeDtls.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- for Tool Tip-->
	
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="billing_details" id="billing_details">

<%
	

	String temp_order_id="";
	String bean_id			 = "Or_billingQueryBean" ;
	String bean_name		 = "eOR.OrderEntryBillingQueryBean";
	
	String orderId			 = request.getParameter("orderId");
	String order_line_num	 = request.getParameter("lineId");
	String patient_id		 = request.getParameter("patient_id");
	String encounter_id		 = request.getParameter("encounter_id");
	String patient_class	 = request.getParameter("patient_class");
	String called_from=request.getParameter("called_from");
	
	called_from = (called_from == null) ? "" : called_from;

	orderId					= (orderId == null) ? "" : orderId;
    order_line_num			 = (order_line_num == null) ? "" : order_line_num;  
    patient_id				 = (patient_id == null) ? "" : patient_id;
    encounter_id			 = (encounter_id == null) ? "" : encounter_id;
    patient_class			 = (patient_class == null) ? "" : patient_class;
   
	String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
	String facility_id		 = (String)session.getValue("facility_id");
	
	if(practitioner_id == null)practitioner_id = "";
	if(facility_id == null)facility_id = "";
	
	ArrayList allValues		 = new ArrayList();
	
	OrderEntryBillingQueryBean bean = (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	
	//bean.clearBean() ;
	String order_set_id=bean.checkForNull(request.getParameter("order_set_id"),"");
	if(order_set_id == null || order_set_id.equals("null"))order_set_id="";

	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String order_set_bill_yn="N";
	String ord_fac_id = "";//--[IN034785]
	
	

	HashMap  setBills_dtls	 = new HashMap();
	HashMap  bill_dtls		 = new HashMap();
	ArrayList BillChargeInfo = null;
	ArrayList OrderCatalogsInfo=new ArrayList();
	String[] catalog_details = null;
	catalog_details = new String[6];
	if(!order_set_id.equals(""))
	{
		String[] OrderSetDetails=bean.getOrderSetDetails(order_set_id);
		if(OrderSetDetails[5].equalsIgnoreCase("Y"))
			orderId=order_set_id;
		OrderCatalogsInfo=bean.getOrderSetSearchDetails(orderId);
		order_set_bill_yn=OrderSetDetails[5];
		
	}
	if(!called_from.equals("register_visit"))
	{		
		allValues					= bean.viewBillCatalogDetails(orderId);
	}
	else
	{
		allValues				=bean.viewBillMultiCatalogDetails(patient_id,encounter_id,patient_class,facility_id);
	}


	String slClassValue 	= "";
	String[] record			= null;
	String[] billing_details= null;
	String billing_call_yn	= "N";
	String order_category="";
	int total_count			= 0;
	int total_records=0;
	String billing_serv_ind = "";

	boolean show_bill_dtls = false;//IN065324
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
%>
<table cellpadding=3 cellspacing=0 border=1 width='100%' id='detailTab' align='center' class="grid">

<%
if(allValues != null && allValues.size() > 0){
	
	total_count = allValues.size();
	for(int i=0; i<allValues.size(); i++){
	
		record = (String [])allValues.get(i);
		
		slClassValue="gridData";
		if(called_from.equalsIgnoreCase("register_visit"))
		{
			orderId=record[19];
			order_category=record[20];
		}
		else
		{
			order_category=record[18];
		}
	
		//IN065324, starts
		if(is_bt_view_bill_dtls && "BT".equals(order_category.trim()) && ("OP".equals(patient_class) || "EM".equals(patient_class)) || !"BT".equals(order_category.trim()))
		{
			show_bill_dtls = true;
		}
		//IN065324, ends
		
		//if ( billing_interface_yn.equals("Y") && record[4].equals("Y") && !order_category.equals("BT") )//IN065324
		if ( billing_interface_yn.equals("Y") && record[4].equals("Y") && show_bill_dtls)//IN065324
		{
			total_records++;
			billing_call_yn		= "Y";
			//[IN034785] - Start
			ord_fac_id		= bean.getOrderFacility(orderId, record[0]);
			//[IN034785] - End
			//IN068314 Starts
			//BillChargeInfo		= bean.getBillChargeDetails(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id) ;
			if("Y".equals(record[19]))
			{
				BillChargeInfo		= bean.getBillChargeDetailsfpp(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id,record[19],record[20]) ;
			}
			else{
				BillChargeInfo		= bean.getBillChargeDetails(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id) ;
			}
			//IN068314 Ends
				if(BillChargeInfo!=null)
				{
					for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
						billing_details 	= (String[])BillChargeInfo.get(k);
						setBills_dtls		= new HashMap();
						setBills_dtls.put("charged_yn"       , billing_details[1]);
						setBills_dtls.put("total_payable"    , billing_details[2]);
						setBills_dtls.put("patient_payable"  , billing_details[3]);
						setBills_dtls.put("quantity"         , record[9]);
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
						setBills_dtls.put("rate"		 , "");
						setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
						setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
						setBills_dtls.put("fpp_yn"		 , record[19]);//IN068314
						setBills_dtls.put("fpp_category"		 , record[20]);//IN068314
					
						bean.setOrderBillDtls(orderId+record[0], setBills_dtls); 
					

				}

				bill_dtls = (HashMap)bean.getOrderBillDtls(orderId+record[0]);
		%>
		<tr>
		<%
		if(called_from.equalsIgnoreCase("register_visit"))
		{
			if(!temp_order_id.equals(orderId))
			{
	%>
			<td class='<%=slClassValue%>' width='16%'><%=orderId%> </td>
		<%
				temp_order_id=orderId;
			}
			else
			{
				%>
					<td class='<%=slClassValue%>' width='16%'></td>
				<%
			}
		}
	%>
 			<td class='<%=slClassValue%>' width='15%'><%=record[8]%> </td>
			<td class='<%=slClassValue%>' width='16%' style='text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
			<td class='<%=slClassValue%>' width='15%' style='text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
			<td class='<%=slClassValue%>' width='15%' style='text-align: right;'><font class='label' size="1"><span id='paid_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("patient_paid_amt"),"0.0")%></span></font></td>
			<%
			if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
			{
			%>
				<td class='<%=slClassValue%>'  width='15%' style='text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"&nbsp;")%></span></font></td>
			
				<td class='<%=slClassValue%>'  width='15%' style='text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"&nbsp;")%></span></font></td>
			<%
			} 
			%>
			<td class='<%=slClassValue%>' width='16%' style='text-align: center;' nowrap><FONT SIZE="1" ><a class="gridLink"  href="javascript:callReviseBilling('<%=i%>','EXIST_ORDER','<%=patient_id%>','<%=encounter_id%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','<%=orderId%>','<%=record[0]%>','<%=ord_fac_id%>')" title='Charge Details'><%
				if(!billing_details[7].equalsIgnoreCase("Y")){%><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/><%}else{%><fmt:message key="Common.view.label" bundle="${common_labels}"/><%}%></a></FONT></td> <!--Added ord_fac_id for [IN034785] -->
			<%
			billing_serv_ind = bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
			%>
			
					
			<input type=hidden name='ord_auth_reqd_yn<%=i%>' id='ord_auth_reqd_yn<%=i%>' value='<%=record[11]%>'>
			<input type=hidden name='ord_auth_by_pract_id<%=i%>' id='ord_auth_by_pract_id<%=i%>' value='<%=record[12]%>'>
			<input type=hidden name='ord_spl_appr_reqd_yn<%=i%>' id='ord_spl_appr_reqd_yn<%=i%>' value='<%=record[13]%>'>
			<input type=hidden name='ord_appr_by_user_id<%=i%>' id='ord_appr_by_user_id<%=i%>' value='<%=record[14]%>'>
			<input type=hidden name='ord_consent_reqd_yn<%=i%>' id='ord_consent_reqd_yn<%=i%>' value='<%=record[15]%>'>
			<input type=hidden name='ord_consent_by_id<%=i%>' id='ord_consent_by_id<%=i%>' value='<%=record[16]%>'>
			<input type=hidden name='order_line_num<%=i%>' id='order_line_num<%=i%>' value='<%=record[0]%>'>
			<input type=hidden name='order_id<%=i%>' id='order_id<%=i%>' value='<%=orderId%>'>
			<input type=hidden name='order_catalog_code<%=i%>' id='order_catalog_code<%=i%>' value='<%=record[7]%>'>
			<input type=hidden name='order_catalog_desc<%=i%>' id='order_catalog_desc<%=i%>' value='<%=record[8]%>'>
			<input type=hidden name='order_qty<%=i%>' id='order_qty<%=i%>' value='<%=record[9]%>'>
			<input type=hidden name='start_date_time<%=i%>' id='start_date_time<%=i%>' value='<%=record[10]%>'>
			<input type=hidden name='order_set_bill_yn<%=i%>' id='order_set_bill_yn<%=i%>' value='<%=order_set_bill_yn%>'>
			<input type=hidden name='billing_call_yn<%=i%>' id='billing_call_yn<%=i%>' value='<%=billing_call_yn%>'>
			
				
		</tr>
<%
		}
	  }
	  else
			billing_call_yn = "N";
	}
}
		if(OrderCatalogsInfo.size()>0)
			{
				%>
				<tr>
						<td class='<%=slClassValue%>' width='' nowrap >&nbsp;</td>
						<td colspan="7">
						 <table class="grid" width="100%" cellpadding=3 cellspacing=0>
							<tr>
						
								 <td class='columnheader' width='' nowrap ><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
								<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
								<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
								<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
								<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
								<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						</tr>
				<%
				for(int z=0; z<OrderCatalogsInfo.size(); z++)
				{
					   catalog_details = (String[])OrderCatalogsInfo.get(z);
					   if(catalog_details[0] == null) catalog_details[0] = "";
					   if(catalog_details[1] == null) catalog_details[1] = "";
					   if(catalog_details[2] == null) catalog_details[2] = "";
					   if(catalog_details[3] == null) catalog_details[3] = "";
					   if(catalog_details[4] == null) catalog_details[4] = "";
					   if(catalog_details[5] == null) catalog_details[5] = "";
					   String  priority_desc=catalog_details[0];
					   if(priority_desc.equalsIgnoreCase("R"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
						}
						else if(priority_desc.equalsIgnoreCase("U"))
						{				
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");		
						}
						else if(priority_desc.equalsIgnoreCase("S"))
						{		
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
					   }	
					   String  order_date_time=catalog_details[1];
					   String  order_catalog_detail=catalog_details[2];
					   String  order_type_short_desc=catalog_details[3];
					   String ordering_pract_name=catalog_details[4];
					   String order_status_short_desc=catalog_details[5];

				 %>
					  <tr>
						 <td class='<%=slClassValue%>'><%=order_date_time%></td>
						 <td class='<%=slClassValue%>'><%=priority_desc%></td>
						 <td class='<%=slClassValue%>'><%=order_type_short_desc%></td>
						 <td class='<%=slClassValue%>'><%=order_catalog_detail%></td>
						 <td class='<%=slClassValue%>'><%=ordering_pract_name%></td>
						 <td class='<%=slClassValue%>'><%=order_status_short_desc%></td>
					</tr>
				
				<%
				}
				%>
				</table>
				</td>
				</tr>
				<%
			}
		//}
	
		if(total_records==0)
		{
			%>	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));window.close();</script> 
			<%
		}

%>		
<%
	//}
//}

%>

</table>

<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name='localeName' id='localeName' value='<%=localeName%>'>

<input type=hidden name='total_rows' id='total_rows' value='<%=total_count%>'>
<input type="hidden" name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type="hidden" name='ordering_practitioner' id='ordering_practitioner' value='<%=practitioner_id%>'>
<input type="hidden" name='billing_interface_yn' id='billing_interface_yn' value='<%=billing_interface_yn%>'>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name='orderId' id='orderId' value='<%=orderId%>'>
<input type="hidden" name='called_from' id='called_from' value='<%=called_from%>'>

<SCRIPT>

setTimeout('showBillingTable();',2000);
if("<%=billing_serv_ind%>"=="S")
{
	if(parent.OrderBillChargeHeader.document.getElementById("ApprovalReqd"))
	{
		parent.OrderBillChargeHeader.document.getElementById("ApprovalReqd").style.display = "";
	}
	if(parent.OrderBillChargeHeader.document.getElementById("Included"))
	{
		parent.OrderBillChargeHeader.document.getElementById("Included").style.display = "";
	}
}
else
{
	if(parent.OrderBillChargeHeader.document.getElementById("ApprovalReqd"))
	{
		parent.OrderBillChargeHeader.document.getElementById("ApprovalReqd").style.display = "none";
	}
	if(parent.OrderBillChargeHeader.document.getElementById("Included"))
	{
		parent.OrderBillChargeHeader.document.getElementById("Included").style.display = "none";
	}
}

</SCRIPT>
</body>
</form>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

