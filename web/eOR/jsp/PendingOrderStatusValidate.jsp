<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
/*
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	 Rev.By 	Description
--------------------------------------------------------------------------------------------------------------------------------
25/09/2018	  IN068719		sivabagyam	 25/09/2018	Ramesh G   GHL-CRF-0517.1
--------------------------------------------------------------------------------------------------------------------------------
*/
--%>
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%--New File Added For  ML-BRU-SCF-0184  --%>
<%
/*
	PendingOrderStatusForAmend structure
	0 - DrugTYpeCode
	1 - Prepere Order Status
	2 - prepere Discharge Advice
	3 - 
	4 - 
*/
    Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
	String bean_id   =  "@PendingOrderStatusBean";
	String bean_name =  "eOR.PendingOrderStatusBean";
	//String order_category = request.getParameter("order_category")==null?"":(String)request.getParameter("order_category");//commented for checkstyle IN068719
    PendingOrderStatusBean bean			= (PendingOrderStatusBean)getBeanObject( bean_id, bean_name, request);
	ArrayList Pending_Order_Status = new ArrayList(bean.getOrderSatList());
	
	
	String order_type_code= (String)request.getParameter("order_status_code")==null?"":(String)request.getParameter("order_status_code");
//	String selected_yn =   (String)hash.get("selected")==null?"":(String)hash.get("selected");
	String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
	String form_mode =   (String)request.getParameter("form_mode")==null?"":(String)request.getParameter("form_mode");
	//String temp_order_type_code="";//commented for checkstyle IN068719
	//int count=0;//commented for checkstyle IN068719
	//int index=0;
	//if(!form_mode.equals("chk2"))//IN068719
	if(form_mode.equals("chk1")){//IN068719
	if(!order_type_code.equals("")){
	  for(int i=0; i<Pending_Order_Status.size(); i++){
	    // String record = "";//commented for checkstyle IN068719
		 if(((String)Pending_Order_Status.get(i)).trim().equals(order_type_code.trim())){
		  System.out.println("Setting the values");
		  Pending_Order_Status.set(i+2,selected_yn);
		  break;
		}
    	}
	}
	}
	//else//IN068719
	else if(form_mode.equals("chk2")) {//IN068719
	if(!order_type_code.equals("")){
	  for(int i=0; i<Pending_Order_Status.size(); i++){
	    // String record = "";//commented for checkstyle IN068719
		 if(order_type_code.equals((String)Pending_Order_Status.get(i))){
		 Pending_Order_Status.set(i+3,selected_yn);
		 break;
		}
	}
	}
	}
	//IN068719 starts
		else
		{
			if(!order_type_code.equals("")){
				  for(int i=0; i<Pending_Order_Status.size(); i++){
				    // String record = "";//commented for checkstyle IN068719
					 if(order_type_code.equals((String)Pending_Order_Status.get(i))){
					 Pending_Order_Status.set(i+4,selected_yn);
					 break;
					}
				}
				}
		}
		//IN068719 ends
	bean.setOrderSatList(Pending_Order_Status);
%>
