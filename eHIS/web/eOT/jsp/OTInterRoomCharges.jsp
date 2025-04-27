<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean,eST.OTTransactionBean,eST.*" contentType=" text/html;charset=UTF-8"  %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
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
	String surgeon_code = request.getParameter("surgeon_code")== null?"":request.getParameter("surgeon_code");
	String bill_str="";
	String panel_str="";

	try{
		if(called_from.equals("PassBillDetails")){
			bill_info = or_bean.getOrderBillDtls(key+key_line);
	//		if(bill_info==null){
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
				bill_info.put("module_id","OT");
				bill_info.put("service_code",service_code);
				bill_info.put("quantity",charge_units);
				bill_info.put("mod_physician_id",surgeon_code);
				bill_info.put("pract_staff_id",surgeon_code);
				bill_info = billing_bean.getBillingParams(bill_info,"HB");//C-> for Surgical Accessories Billing
				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
	//		}
			panel_str = (String) bill_info.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			bill_str = bl_bfr.toString();

	 }
	}catch(Exception e)
	{
		System.out.println("Exception in main room working="+e);
		e.printStackTrace();
	}
	finally{
	}

%>
