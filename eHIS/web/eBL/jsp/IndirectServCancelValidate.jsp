<!DOCTYPE html>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*,eBL.* , eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*
	IndirectServCancel page structure
	0 - Order Code
	1 - Order Status
	2 - RestrctOPserv
	3 - RestrctIPserv
	
*/
    Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
	String bean_id   = "@IndirectServBean" ;
	String bean_name = "eBL.IndirectServBean";
	 IndirectServBean bean			= (IndirectServBean)getBeanObject( bean_id, bean_name, request);
	ArrayList indir_order_status = new ArrayList(bean.getOrderSatList());
	
	
	String order_type_code= (String)request.getParameter("order_status_code")==null?"":(String)request.getParameter("order_status_code");
	String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
	String form_mode =   (String)request.getParameter("form_mode")==null?"":(String)request.getParameter("form_mode");
	if(form_mode.equals("chk1")){
	if(!order_type_code.equals("")){
	  for(int i=0; i<indir_order_status.size(); i++){
	   if(((String)indir_order_status.get(i)).trim().equals(order_type_code.trim())){
		 indir_order_status.set(i+2,selected_yn);
		  break;
		}
    	}
	}
	}
	else if(form_mode.equals("chk2")) {
	if(!order_type_code.equals("")){
	  for(int i=0; i<indir_order_status.size(); i++){
	    if(order_type_code.equals((String)indir_order_status.get(i))){
			indir_order_status.set(i+3,selected_yn);
		    break;
		}
	}
	}
	}

	bean.setOrderSatList(indir_order_status);
%>
