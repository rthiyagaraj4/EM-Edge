<!DOCTYPE html>
<%@page  contentType=" text/html;charset=UTF-8"%>
<%@page  import ="eOR.OrderEntryBillingQueryBean,java.util.HashMap"  %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%  
	String trace="0";
try{
	//bean_id name shouldn't be changed.
	String bean_id 							= "Or_billingQueryBean";
	String bean_name 						= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean bean			= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request );
	//if it is comming from instrument/equipments/implants/consumables key --> orderid = bill sub_regn_key & order_line_num = bill sub_regn_line_key
	String order_id			= checkForNull(request.getParameter("order_id"));
	String order_line_no	= checkForNull(request.getParameter("order_line_num"));
	String oper_code		= checkForNull(request.getParameter("oper_code"));
	String key		= checkForNull(request.getParameter("key"));
	String key_line		= checkForNull(request.getParameter("key_line"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String called_from		= checkForNull(request.getParameter("called_from"));
	HashMap bill_info		= new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
if(called_from.equals("SURG_ACC_EDIT")){
	bill_info = bean.getOrderBillDtls(key+key_line);	
}else{
	if(!"".equals(order_line_no)){
		bill_info = bean.getOrderBillDtls(order_id+order_line_no);
	}else{
		//if called from SURG_ACC calling surgical accessories
		bill_info = ("SURG_ACC".equals(called_from))?bean.getOrderBillDtls(order_id):bean.getOrderBillDtls(patient_id+oper_code); 
	}
}
trace="6";
		bl_bfr.append(bill_info.get("key")).append("::");
trace="6.1";
		bl_bfr.append(bill_info.get("key_line_no")).append("::");
trace="6.2";
		bl_bfr.append(bill_info.get("oper_code")).append("::");
trace="6.3";
		bl_bfr.append(bill_info.get("patient_id")).append("::");
trace="6.4";
		bl_bfr.append(bill_info.get("episode_type")).append("::");
trace="6.5";
		bl_bfr.append(bill_info.get("episode_id")).append("::");
trace="6.6";
		bl_bfr.append(bill_info.get("visit_id")).append("::");
trace="6.7";
		bl_bfr.append(bill_info.get("encounter_id")).append("::");
trace="6.8";
		bl_bfr.append(bill_info.get("service_date")).append("::");
trace="6.9";
		bl_bfr.append("P").append("::");
trace="6.10";
		bl_bfr.append(bill_info.get("pract_staff_id")).append("::");
trace="6.11";
		bl_bfr.append(bill_info.get("serv_panel_ind")).append("::");
trace="6.12";
		bl_bfr.append(bill_info.get("serv_panel_code")).append("::");
trace="6.13";
		bl_bfr.append(bill_info.get("bl_panel_str")).append("::");
trace="6.14";
		bl_bfr.append(bill_info.get("total_payable")).append("::");
trace="6.15";
		bl_bfr.append(bill_info.get("patient_payable")).append("::");
trace="6.16";
		bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
trace="6.17";
		bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
trace="6.18";
		bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
trace="6.19";
		bl_bfr.append(bill_info.get("quantity")).append("::");//050795
trace="6.20";
		bl_bfr.append(bill_info.get("order_line_no"));//050795
trace="7";
		out.println(bl_bfr.toString());
trace="8";
		bl_bfr.setLength(0);
trace="9";
}catch(Exception e){
	System.err.println("Exception in GetBillDetailsFromPersistence:::trace=="+trace);
	System.err.println("Exception in GetBillDetailsFromPersistence:::"+e);
	e.printStackTrace();
}
%>
