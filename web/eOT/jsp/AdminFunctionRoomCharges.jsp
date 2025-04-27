<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean,eST.OTTransactionBean,eST.*" contentType=" text/html;charset=UTF-8"  %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String called_from = request.getParameter("key")== null?"":request.getParameter("called_from");
	String room_id = request.getParameter("room_id")== null?"":request.getParameter("room_id");
	String key = request.getParameter("key")== null?"":request.getParameter("key");
	String oper_num = request.getParameter("oper_num")== null?"":request.getParameter("oper_num");
	String key_line = request.getParameter("key_line")== null?"":request.getParameter("key_line");
	String room_code = request.getParameter("bay_code")== null?"":request.getParameter("bay_code");
	String service_code = request.getParameter("service_code")== null?"":request.getParameter("service_code");
	String charge_units = request.getParameter("charge_units")== null?"":request.getParameter("charge_units");
	String flag = request.getParameter("charge_units")== null?"":request.getParameter("flag");

	
	String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String episode_id = request.getParameter("episode_id")== null?"":request.getParameter("episode_id");
	String visit_id = request.getParameter("visit_id")== null?"":request.getParameter("visit_id");
	String serv_date = request.getParameter("serv_date")== null?"":request.getParameter("serv_date");
	String pract_staff_id = request.getParameter("pract_staff_id")== null?"":request.getParameter("pract_staff_id");
	String patient_class = request.getParameter("patient_class")== null?"":request.getParameter("patient_class");
	String bl_episode_type = request.getParameter("bl_episode_type")== null?"":request.getParameter("bl_episode_type");
	String order_id1 = request.getParameter("order_id1")== null?"":request.getParameter("order_id1");

	HashMap bill_info_reqd_dtls =new HashMap();
	

	bill_info_reqd_dtls.put("patient_id",patient_id);
	bill_info_reqd_dtls.put("encounter_id",encounter_id);
	bill_info_reqd_dtls.put("episode_id",episode_id);
	bill_info_reqd_dtls.put("visit_id",visit_id);
	bill_info_reqd_dtls.put("serv_date",serv_date);
	bill_info_reqd_dtls.put("pract_staff_id",pract_staff_id);
	bill_info_reqd_dtls.put("patient_class",patient_class);
	bill_info_reqd_dtls.put("bl_episode_type",bl_episode_type);
	bill_info_reqd_dtls.put("order_id",order_id1);
	String bill_str="";
	String panel_str="";
	try{
		if(called_from.equals("PassBillDetails")){
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			//if(bill_info==null && ("onblur").equals(flag)){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				bill_info.put("oper_code",room_code);			//pass room  in oper_code
				if(room_id.equals("HB")){
					bill_info.put("acc_type","HB");
				}else if(room_id.equals("OR")){
					bill_info.put("acc_type","OR");
				}else if(room_id.equals("RR")){
					bill_info.put("acc_type","RR");
				}
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("oper_num",oper_num);
				bill_info.put("module_id","OT");
				bill_info.put("service_code",service_code);
				bill_info.put("quantity",charge_units);
				bill_info = billing_bean.getBillingParamsForAdmin(bill_info,room_id,bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
			//}
			panel_str = (String) bill_info.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"null")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"null")).append("::");
			
			bill_str = bl_bfr.toString();

	 }
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
	}

%>
