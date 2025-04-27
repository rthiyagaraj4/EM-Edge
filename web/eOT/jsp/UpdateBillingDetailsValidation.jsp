<!DOCTYPE html>
<%@page  contentType=" text/html;charset=UTF-8"%>
<%@page  import ="eOR.OrderEntryBillingQueryBean,java.util.HashMap,eOT.OTBillingBean"  %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%  
	String trace="0";
	String panel_str = "";
	HashMap bill_info		= new HashMap();
	HashMap orig_bill_info		= new HashMap();
	StringBuilder bl_bfr	= new StringBuilder();
	HashMap hash = new HashMap();
try{
	// This page is being called only from Implants and Consumables pages.
	//bean_id name shouldn't be changed.
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 					= "OTBillingBean";
	String bean_name 				= "eOT.OTBillingBean";
	OTBillingBean billing_bean		= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String order_id			= "";//checkForNull(request.getParameter("order_id"));
	String order_line_num	= checkForNull(request.getParameter("order_line_num"));
	String key				= checkForNull(request.getParameter("key"));
	String key_line			= checkForNull(request.getParameter("key_line"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String encounter_id		= checkForNull(request.getParameter("encounter_id"));
	String patient_class	= checkForNull(request.getParameter("patient_class"));
	String surgeon_code		= checkForNull(request.getParameter("surgeon_code"));
	String catalog_code		= checkForNull(request.getParameter("catalog_code"));
	String booking_date		= checkForNull(request.getParameter("booking_date"));
	String locale			= checkForNull(request.getParameter("locale"));
	String p_qty			= checkForNull(request.getParameter("p_qty"));
	String oper_num			= checkForNull(request.getParameter("oper_num"));
	String oper_code			= checkForNull(request.getParameter("oper_code"));
	String acc_code			= checkForNull(request.getParameter("acc_code"));
	String acc_type			= checkForNull(request.getParameter("acc_type"));
	
	hash = billing_bean.getORBillingParams(oper_num);
	trace="1";
	catalog_code	= acc_type+"#"+acc_code;
	booking_date	= (String) hash.get("service_date");
	patient_id	    = (String)hash.get("patient_id");
	encounter_id	= (String)hash.get("encounter_id");
	surgeon_code	= (String)hash.get("pract_staff_id");
	patient_class   = (String)hash.get("patient_class");
	trace="1.5";
	ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
	trace="2";
	orig_bill_info		= or_bean.getOrderBillDtls(key+key_line);
//.err.println("54:UpdateBillingDetailsValidation: before......getOrderBillDtls==="+orig_bill_info);
	bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
	panel_str = (String) bill_info.get("bl_panel_str");
	trace="3";
	orig_bill_info.put("quantity",p_qty);
	orig_bill_info.put("key",key);
	orig_bill_info.put("bl_panel_str",panel_str);
	//bill_info.putAll(hash);
	//set billing details from OTBillingBean........	
	or_bean.setOrderBillDtls(key,orig_bill_info);
	putObjectInBean(or_bean_id,or_bean,request);
	String overridden_action_reason_code=null;
	String overridden_incl_excl_ind=null;
	bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
	bl_bfr.append(overridden_incl_excl_ind).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
	bl_bfr.append(overridden_action_reason_code).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"")).append("::");
	String bill_str = bl_bfr.toString();
	out.println(bill_str+"OTMS_SEP"+panel_str);
}catch(Exception e){
	bl_bfr.setLength(0);
	e.printStackTrace();
}
%>

	
