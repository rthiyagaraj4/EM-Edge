<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<head>
<!--<title><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></title>-->
<title>Child Orders</title>
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

 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
</head>
<body>
<form name="view_order" id="view_order">
<%
String bean_id1 = "Or_ViewOrder" ;
String bean_name1 = "eOR.ViewOrder";
String bean_id = "Or_ExistingOrder" ;
String bean_name = "eOR.ExistingOrder";
ArrayList childValues = new ArrayList();
String p_orderId = request.getParameter("orderId");
String orderId="";
//String mode	   = "1";//request.getParameter( "mode" ) ;
//String function_id = request.getParameter( "function_id" ) ;
String patient_id = request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id");
//out.println("<script>alert('"+request.getQueryString()+"');</script>");
String patient_class = request.getParameter("patient_class");
//String sex = request.getParameter( "sex" ) ;
String image_ref = request.getParameter( "image_ref" );
String ord_facility_id = request.getParameter("ord_facility_id");
ord_facility_id = (ord_facility_id == null) ? "":ord_facility_id;
String iv_prep_yn = request.getParameter("iv_prep_yn");
iv_prep_yn = (iv_prep_yn == null) ? "":iv_prep_yn;
String ord_cat_code = request.getParameter("ord_cat_code");
ord_cat_code = (ord_cat_code == null) ? "" : ord_cat_code;
String ord_cat = request.getParameter("ord_cat");
ord_cat = (ord_cat == null) ? "" : ord_cat;
ArrayList allValues = new ArrayList();
if( image_ref==null || image_ref==" " || image_ref.equals("null"))
	image_ref = "";
String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
					
ArrayList BillChargeInfo = null;
String[] billing_details= null;
String bill_call_yn = "N";
double toatal_amt = 0.0;
double toatal_pat_payable = 0.0;
double toatal_pat_paid = 0.0;
ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
bean1.setLanguageId(localeName);
childValues=bean1.getChildOrders(p_orderId);
ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(localeName);
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
bean.setLanguageId(localeName);
bean.clear() ;
String facility_id		= (String)session.getValue("facility_id");
String rd_install		=  bean.getRadiology(facility_id);
String ot_install		=  bean.getOTModule(facility_id);
	
if(rd_install==null) rd_install="N";
if(ot_install==null) ot_install="N";
String slClassValue 		= "gridData";
//String prepsdata 			= "";
String rowColor 			= "";
String ordering_facility_id = "";
String order_category 		= "";
String bill_yn		  		= "";
String billed_yn	  		= "";
String bill_legend	  		= "";
String bill_for_facility 	= "";
String dosage_unit			= "";
String billing_serv_ind = "";
String practitioner_type  	= (String) session.getValue("practitioner_type");//Added by Uma on 5/12/2010 for IN021330

boolean showBill = true;
%>
<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center' class="grid">
<tr >	
	<th width='5%' class='columnheader'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
	<th width='5%' class='columnheader'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></th>
	<th width='18%' class='columnheader' ><fmt:message key="Common.total.label" bundle="${common_labels}"/></th>
	<th width='18%' class='columnheader' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></th>
	<th width='20%' class='columnheader' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></th>
	<th width='18%' class='columnheader' style="display:none" id="Included"><fmt:message key="Common.Included.label" bundle="${common_labels}"/></th>
	<th width='17%' class='columnheader' style="display:none" id="Approved"><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></th>
</tr>
<%
for(int j=0; j<childValues.size(); j++)
{
	String[] c_orderid = (String [])childValues.get(j);
	if(c_orderid[0] == null) c_orderid[0] = "";
	orderId=c_orderid[0];
	allValues					= bean.viewOtherDetails(orderId,practitioner_type);
	
	for(int i=0; i<allValues.size(); i++)
	{
		String[] record = (String [])allValues.get(i);
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
		
		image_ref				= 	record[34];

		String appt_reqd_yn 			= record[20];
		String appt_date_time 			= record[21];
		String appt_ref_num 			= record[22];
		String cont_order_ind			= record[23];
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
		if(record[16].trim().equals("RED") || record[8].trim().equals("RD") || record[8].trim().equals("RJ")) rowColor = "orcancel"; else rowColor = slClassValue;

		//out.println(">>>>>>>"+orderId);
		//out.println(">>>>>>>"+record[9]);
		order_category = record[14];

	/*if(!(record[8].trim().equals("CN") || record[8].trim().equals("DC") || record[8].trim().equals("RD") || record[8].trim().equals("RJ") || record[8].trim().equals("OS"))){*/
		if(bill_for_facility.equals("Y")) 
		{
			if(bill_yn.equals("Y"))	
			{
				showBill = true;
				if(billed_yn.equals("Y"))
					bill_legend	= "Billed";
				else
					bill_legend  = "Not Billed";
			}else
				showBill = false;
		}
					//}

					if(showBill)
					{

					if(bill_call_yn.equals("N"))
						bill_call_yn = "Y";
					OrderEntryBillingQueryBean billingbean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
					//IN068314 Starts
					//BillChargeInfo		= billingbean.getBillChargeDetails(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,encounter_id,patient_class,practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					if("Y".equals(record[48])){
						BillChargeInfo		= billingbean.getBillChargeDetailsfpp(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,encounter_id,patient_class,practitioner_id,record[48],record[49]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations 
					}
					else{
					BillChargeInfo		= billingbean.getBillChargeDetails(record[36],record[13],record[2], localeName, orderId, record[9],patient_id,encounter_id,patient_class,practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
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
						}
					}
						
%>
					<tr>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='order_<%=i%>'><%=orderId%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0'></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull(billing_details[2],"0.0")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull(billing_details[3],"0.0")%></font></td>
							<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='pat_payable<%=i%>'><%=bean.checkForNull(billing_details[6],"0.0")%></font></td>
							<%
							if(bean.checkForNull(billing_details[10],"").equalsIgnoreCase("S"))
							{
							%>
								<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=(bean.checkForNull(billing_details[4],"").equals("E"))?"No":(bean.checkForNull(billing_details[4],"").equals("I")?"Yes":"")%></font></td>
								<td colspan="" class='<%=rowColor%>' style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=(bean.checkForNull(billing_details[5],"").equals("Y"))?"Yes":(bean.checkForNull(billing_details[5],"").equals("N")?"No":"")%></font></td>
							<%
							}
							%>
						</tr>
						
				
<%				billing_serv_ind = bean.checkForNull(billing_details[10],"");		
		}
	}
}
%>
	
	</table>
	<Input type='hidden'name='toatal_amt' id='toatal_amt' value='<%=toatal_amt%>'>
	<Input type='hidden'name='toatal_pat_payable' id='toatal_pat_payable' value='<%=toatal_pat_payable%>'>
	<Input type='hidden' name='toatal_pat_paid' id='toatal_pat_paid' value='<%=toatal_pat_paid%>'>
	
	<script>
	var qrystring 	=  "&toatal_amt="+document.getElementById("toatal_amt").value+"&toatal_pat_payable="+document.getElementById("toatal_pat_payable").value;
	qrystring		+= "&toatal_pat_paid="+document.getElementById("toatal_pat_paid").value;
	//alert(document.getElementById("order_category").value);
	//alert('<%=request.getQueryString()%>'+qrystring);
	parent.ChildOrderBtn.location.href="ChildOrderBtn.jsp?<%=request.getQueryString()%>"+qrystring;
	if("<%=billing_serv_ind%>"=="S")
	{
		if(document.getElementById("Approved"))
		{
			document.getElementById("Approved").style.display = "inline";
		}
		if(document.getElementById("Included"))
		{
			document.getElementById("Included").style.display = "inline";
		}
	}
	else
	{
		if(document.getElementById("Approved"))
		{
			document.getElementById("Approved").style.display = "none";
		}
		if(document.getElementById("Included"))
		{
			document.getElementById("Included").style.display = "none";
		}
	}
	</script>
	</form>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);

%>

