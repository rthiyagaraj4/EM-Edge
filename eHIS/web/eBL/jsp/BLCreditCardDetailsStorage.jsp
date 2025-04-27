<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
1-Dec-2014     100           	Karthikeyan.K       GHL-CRF-0366.1 Karthik Created this File code for Credit Card Integration   
---------------------------------------------------------------------------------------------------------------
-->

<%@page  import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<HTML>


<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String cardOperation=request.getParameter("cardOperation");
	
	if(cardOperation.equals("storedata")){
	
 	String P_patient_id=request.getParameter("P_patient_id");
	String P_episode_ID=request.getParameter("P_episode_ID");
	String P_settlement_type=request.getParameter("P_settlement_type");
	String P_trn_type=request.getParameter("P_trn_type");
	String p_doc_date=request.getParameter("p_doc_date");
	String P_Bill_Doc_Type=request.getParameter("P_Bill_Doc_Type");
	String P_Bill_Doc_Num =request.getParameter("P_Bill_Doc_Num");
	String P_Total_Bill_Amount=request.getParameter("P_Total_Bill_Amount");
	String P_doc_amt=request.getParameter("P_doc_amt");
	String P_Preapaid_Card_Number=request.getParameter("P_Preapaid_Card_Number");
	String P_Reciept_Date=request.getParameter("P_Reciept_Date");
	String P_USER_ID=request.getParameter("P_USER_ID");
	String P_RESP_ID=request.getParameter("P_RESP_ID");
	String P_FACILITY_ID=request.getParameter("P_FACILITY_ID");
	String P_MODULE_ID=request.getParameter("P_MODULE_ID");
	String P_FUNCTION_ID=request.getParameter("P_FUNCTION_ID");
	String P_LANGUAGE_ID=request.getParameter("P_LANGUAGE_ID");
	String P_WS_NO=request.getParameter("P_WS_NO");
	String P_Trx_No=request.getParameter("P_Trx_No");
	String P_Ext_Input_Key=request.getParameter("P_Ext_Input_Key");
	String P_Ext_Application_ID=request.getParameter("P_Ext_Application_ID");
	String P_Ext_Function=request.getParameter("P_Ext_Function");
	String P_PATIENT_NAME=request.getParameter("P_PATIENT_NAME");
	
	Map<String,String> paramMap=new HashMap<String,String>();
	paramMap.put("P_patient_id",P_patient_id);
	paramMap.put("P_episode_ID",P_episode_ID);
	paramMap.put("P_settlement_type",P_settlement_type);
	paramMap.put("P_trn_type",P_trn_type);
	paramMap.put("p_doc_date",p_doc_date);
	paramMap.put("P_Bill_Doc_Type",P_Bill_Doc_Type);
	paramMap.put("P_Bill_Doc_Num",P_Bill_Doc_Num);
	paramMap.put("P_Total_Bill_Amount",P_Total_Bill_Amount);
	paramMap.put("P_doc_amt",P_doc_amt);
	paramMap.put("P_Preapaid_Card_Number",P_Preapaid_Card_Number);
	paramMap.put("P_Reciept_Date",P_Reciept_Date);
	paramMap.put("P_USER_ID",P_USER_ID);
	paramMap.put("P_RESP_ID",P_RESP_ID);
	paramMap.put("P_FACILITY_ID",P_FACILITY_ID);
	paramMap.put("P_MODULE_ID",P_MODULE_ID);
	paramMap.put("P_FUNCTION_ID",P_FUNCTION_ID);
	paramMap.put("P_LANGUAGE_ID",P_LANGUAGE_ID);
	paramMap.put("P_WS_NO",P_WS_NO);
	paramMap.put("P_Trx_No",P_Trx_No);
	paramMap.put("P_Ext_Input_Key",P_Ext_Input_Key);
	paramMap.put("P_Ext_Application_ID",P_Ext_Application_ID);
	paramMap.put("P_Ext_Function",P_Ext_Function);
	paramMap.put("P_PATIENT_NAME",P_PATIENT_NAME);	
	session.setAttribute("BL_CREDIT_CARD_PARAM_MAP", paramMap);
	
	String cardData= request.getParameter("cardData");	
	session.setAttribute("BL_CREDIT_CARD_DETAILS", cardData);
	//System.out.println(cardData);
	}else{
	session.removeAttribute("BL_CREDIT_CARD_DETAILS");
	//System.out.println("session BL_CREDIT_CARD_DETAILS cleared");
	}
	
	

	

%>

</HTML>
