<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*,java.math.BigDecimal, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanObj" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
String cont_order_ind			= request.getParameter("cont_order_ind");
String parent_order_id			= request.getParameter("parent_order_id");
String parent_order_line_num	= request.getParameter("parent_order_line_num");
String bean_id					= request.getParameter("bean_id");
String bean_name				= request.getParameter("bean_name");
String function_from			= request.getParameter("function_from");
String ordering_facility_id 	= request.getParameter("ordering_facility_id");
String slClassValue				= "";

if(cont_order_ind == null || cont_order_ind.equals("null"))	cont_order_ind = "";
if(parent_order_id == null || parent_order_id.equals("null"))	parent_order_id = "";
if(parent_order_line_num == null || parent_order_line_num.equals("null"))	parent_order_line_num = "";
if(bean_id == null || bean_id.equals("null"))	bean_id = "";
if(bean_name == null || bean_name.equals("null"))	bean_name = "";
if(function_from == null || function_from.equals("null"))	function_from = "";
//double tempDouble				= 1.111,
double totalAmt				= 0.0;
BigDecimal TotAmt = new BigDecimal(0.000);
TotAmt = TotAmt.setScale(3,6);

java.util.ArrayList	BillDetails = new java.util.ArrayList();
Properties properties	= (Properties) session.getValue( "jdbc" );

//if (appt_ref_num.equals("") && (!(function_from.equalsIgnoreCase("DO") || function_from.equalsIgnoreCase("CO")))) {
//	if (!(cont_order_ind.equalsIgnoreCase("DO") || cont_order_ind.equalsIgnoreCase("CO"))) {
//		if (function_from.equalsIgnoreCase("View") || function_from.equalsIgnoreCase("Cancel")) {
			//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
			//ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	beanObj.setLanguageId(localeName);

			BillDetails = (java.util.ArrayList)beanObj.getBLDetails(properties, parent_order_id,parent_order_line_num);
//		} else if (function_from.equalsIgnoreCase("ReviewStatus")) {
//			ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);
//		} else if (function_from.equalsIgnoreCase("Complete")) {
//			CompleteOrderBean bean = (CompleteOrderBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);
//		}
//	}
//} else if (!appt_ref_num.equals("")){
//	String [] record 	= new String[2];
//	record[0]			= appt_ref_num;
//	record[1]			= appt_date;
//	AppointmentDetails.add(record);
//}
%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="Common.BillDetails.label" bundle="${common_labels}"/> </title>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">
<table class="grid" cellpadding=3 cellspacing=0 border=1>
<tr><td class='columnheader' width=''><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td><td class='columnheader' width=''><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td><td class='columnheader' width=''></td><td class='columnheader' width=''><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td></tr>
<%--<Script>alert('<%=BillDetails.size()%>,<%=parent_order_id%>,<%=parent_order_line_num%>')</Script>--%>
<%for(int i=0;i < BillDetails.size();i++) {
	String[] records = (String [])BillDetails.get(i);
	String order_id 			= beanObj.checkForNull(records[0],"");
	String order_line_num		= beanObj.checkForNull(records[1],"");
	String start_date_time		= beanObj.checkForNull(records[2],"");
	String billed_yn			= beanObj.checkForNull(records[3],"");
	String bill_yn				= beanObj.checkForNull(records[4],"");
	String catalog_code			= beanObj.checkForNull(records[5],"");
	String catalog_desc			= beanObj.checkForNull(records[6],"");
	String order_line_status	= beanObj.checkForNull(records[7],"");
	if(!(order_line_status.trim().equals("CN") || order_line_status.trim().equals("DC") || order_line_status.trim().equals("RD") || order_line_status.trim().equals("RJ"))) {
	ArrayList BillChargeInfo	= beanObj.getBillChargeDetails(properties, order_id,order_line_num,ordering_facility_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations

    String day_type_code 			= "", day_type_desc 		= "";
    String time_type_code 			= "", time_type_desc 		= "";
    String base_qty 	  			= "", base_rate 			= "";
    String addl_factor 	  			= "", base_charge_amt 		= "";
    String gross_charge_amt 		= "", disc_amt 				= "";
    double net_charge_amt 			= 0.0;
    String pat_gross_charge_amt		= "", pat_disc_amt 			= "";
    String pat_net_charge_amt		= "", cust_gross_charge_amt	= "";
    String cust_disc_amt			= "", cust_net_charge_amt	= "";
    String split_ind				= "", curr_availed			= "";
    String credit_auth_ref			= "", error_text			= "";
    String serv_panel_ind       	= "", serv_panel_code       = "";
    String service_panel_name   	= "", disc_perc 			= "";


	if (BillChargeInfo != null && BillChargeInfo.size() > 0) {
			String[] record				= (String[])BillChargeInfo.get(0);
//			if (record[21] != null && (!record[21].equals(""))) {
//				out.println("alert('"+record[21]+"')");
//			} else {
				day_type_code   		= beanObj.checkForNull(record[0],"");
				day_type_desc   		= beanObj.checkForNull(record[1],"");
				time_type_code  		= beanObj.checkForNull(record[2],"");
				time_type_desc  		= beanObj.checkForNull(record[3],"");
				base_qty   				= beanObj.checkForNull(record[4],"");
				base_rate   			= beanObj.checkForNull(record[5],"");
				addl_factor   			= beanObj.checkForNull(record[6],"");
				base_charge_amt 		= beanObj.checkForNull(record[7],"");
				gross_charge_amt		= beanObj.checkForNull(record[8],"");
				disc_amt  	 			= beanObj.checkForNull(record[9],"");
				//net_charge_amt  		= beanObj.checkForNull(record[10],"");
				net_charge_amt			= (record[10] == null || record[10].equals("")) ? 0.0:Double.parseDouble(record[10]);

				disc_perc	    		= beanObj.checkForNull(record[11],"");
				pat_gross_charge_amt	= beanObj.checkForNull(record[12],"");
				pat_disc_amt 			= beanObj.checkForNull(record[13],"");
				pat_net_charge_amt 		= beanObj.checkForNull(record[14],"");
				cust_gross_charge_amt	= beanObj.checkForNull(record[15],"");
				cust_disc_amt			= beanObj.checkForNull(record[16],"");
				cust_net_charge_amt		= beanObj.checkForNull(record[17],"");
				split_ind				= beanObj.checkForNull(record[18],"");
				curr_availed			= beanObj.checkForNull(record[19],"");
				credit_auth_ref			= beanObj.checkForNull(record[20],"");
				error_text				= beanObj.checkForNull(record[21],"");
				serv_panel_ind			= beanObj.checkForNull(record[22],"");
				serv_panel_code			= beanObj.checkForNull(record[23],"");
				service_panel_name		= beanObj.checkForNull(record[24],"");

				//out.println( "loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; " ) ;
			//}
		}
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
%>
<tr><td class='<%=slClassValue%>' ><B><%=order_id%></B></td><td class='<%=slClassValue%>' align='left'><B><%=start_date_time%></B></td>
<%if(bill_yn.equals("Y"))	{
//out.println("<script>alert('order_id=" +order_id+",order_line_num="+order_line_num+",ordering_facility_id="+ordering_facility_id+",loadBillingDetails(\"day_type_code="+day_type_code+"\",\"day_type_desc=" +day_type_desc+"\" ,\"time_type_code="+time_type_code+"\",\"time_type_desc="+time_type_desc+"\",\"base_qty="+base_qty+"\",\"base_rate=" +base_rate+"\" ,\"addl_factor="+addl_factor+"\",\"base_charge_amt="+base_charge_amt+"\",\"gross_charge_amt=" +gross_charge_amt+"\" ,\"disc_amt="+disc_amt+"\",\"net_charge_amt="+net_charge_amt+"\",\"disc_perc="+disc_perc+"\",\"pat_gross_charge_amt="+pat_gross_charge_amt+"\",\"pat_disc_amt="+pat_disc_amt+"\",\"pat_net_charge_amt="+pat_net_charge_amt+"\",\"cust_gross_charge_amt="+cust_gross_charge_amt+"\",\"cust_disc_amt="+cust_disc_amt+"\",\"cust_net_charge_amt="+cust_net_charge_amt+"\" ,\"split_ind="+split_ind+"\",\"curr_availed="+curr_availed+"\" ,\"credit_auth_ref=" +credit_auth_ref+"\" ,\"catalog_code="+catalog_code+"\" ,\"catalog_desc="+catalog_desc+"\" ,\"serv_panel_ind="+serv_panel_ind+"\" ,\"serv_panel_code="+serv_panel_code+"\" ,\"service_panel_name="+service_panel_name+"\" ,\"error_text="+error_text+"\") ; ')</script>");
%>
<td class='<%=slClassValue%>' ><B><a class="gridLink"  href="javascript:loadBillingDetails('<%=day_type_code%>','<%=day_type_desc%>','<%=time_type_code%>','<%=time_type_desc%>','<%=base_qty%>','<%=base_rate%>','<%=addl_factor%>','<%=base_charge_amt%>','<%=gross_charge_amt%>','<%=disc_amt%>','<%=net_charge_amt%>','<%=disc_perc%>','<%=pat_gross_charge_amt%>','<%=pat_disc_amt%>','<%=pat_net_charge_amt%>','<%=cust_gross_charge_amt%>','<%=cust_disc_amt%>','<%=cust_net_charge_amt%>','<%=split_ind%>','<%=curr_availed%>','<%=credit_auth_ref%>','<%=catalog_code%>','<%=catalog_desc%>','<%=serv_panel_ind%>','<%=serv_panel_code%>','<%=service_panel_name%>','<%=error_text%>') ;"><%=(billed_yn.equals("Y"))?"Billed":"Not Billed"%></B></td>
<%--<Script>alert('ordering_facility_id=<%=ordering_facility_id%>&parent_order_id=<%=order_id%>&parent_order_line_num=<%=order_line_num%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&function_from=<%=function_from%>&validate=viewBill&cont_order_ind=<%=cont_order_ind%>')</Script>--%>
<%--<td class='label' ><B><a href="javascript:billDetails('ordering_facility_id=<%=ordering_facility_id%>&parent_order_id=<%=order_id%>&parent_order_line_num=<%=order_line_num%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&function_from=<%=function_from%>&validate=viewBill&cont_order_ind=<%=cont_order_ind%>');"><%=(billed_yn.equals("Y"))?"Billed":"Bill Dtls."%></B>&nbsp;&nbsp;</td>--%>
<%}%>
<%//net_charge_amt=net_charge_amt+tempDouble;
BigDecimal net_charge = new BigDecimal(net_charge_amt);
net_charge = net_charge.setScale(3,6);
TotAmt = TotAmt.add(net_charge);
totalAmt				= totalAmt + net_charge_amt;
//tempDouble += 1;%>
<td class='<%=slClassValue%>' ><B><%=net_charge%></B></td>

</tr>
<%}
}
//slClassValue = (slClassValue.equals("QRYEVEN"))?"QRYODD":"QRYEVEN";
slClassValue="gridData";
%>
<tr><td colspan='3' class='<%=slClassValue%>' ><B><fmt:message key="eOR.TotalAmount.label" bundle="${or_labels}"/></B></td>
<td class='<%=slClassValue%>' ><B><%=TotAmt%></B></td></tr>
</table>
</FORM>

</BODY>
</HTML>

<%
	//putObjectInBean(bean_id,beanObj,request);	
%>

