<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
 <jsp:useBean id="beanObj" scope="page" class="eOR.ExistingOrder"/>
 <jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
    	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName=request.getParameter("localeName");
	//System.out.println("==localeName==="+localeName+"==========");    
		beanObj.setLanguageId(localeName);


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	Properties properties	= (Properties) session.getValue( "jdbc" );
 	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	/*if ( validate.equals( "ord_cat" ) ) {
		String order_category = (String)hash.get("order_category") ;
		out.println( "clearList('document') ; " ) ;
		
		ArrayList OrderTypeData = beanObj.getOrderTypeData(properties, order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

		out.println( "clearActivityList('document') ; " ) ;

		ArrayList ActivityTypeData = beanObj.getActivityType(properties, order_category, "") ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) {
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}

	}   else*/ if (validate.equals("viewBill")) {
		String parent_order_id 			= request.getParameter("parent_order_id");
		String parent_order_line_num 	= request.getParameter("parent_order_line_num");
		String ordering_facility_id 	= request.getParameter("ordering_facility_id");
		//String function_from 			= request.getParameter("function_from");
		String catalog_code				= request.getParameter("catalog_code");
		String catalog_desc				= request.getParameter("catalog_desc");

		ArrayList BillChargeInfo		= beanObj.getBillChargeDetails(properties, parent_order_id,parent_order_line_num,ordering_facility_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		//out.println("load"+BillChargeInfo.size());
		if (BillChargeInfo != null && BillChargeInfo.size() > 0) {
			String[] record				= (String[])BillChargeInfo.get(0);
			if (record[21] != null && (!record[21].equals(""))) {
				out.println("alert('"+record[21]+"')");
			} else {
				String day_type_code 			= "", day_type_desc 		= "";
				String time_type_code 			= "", time_type_desc 		= "";
				String base_qty 	  			= "", base_rate 			= "";
				String addl_factor 	  			= "", base_charge_amt 		= "";
				String gross_charge_amt 		= "", disc_amt 				= "";
				String net_charge_amt 			= "", disc_perc 			= "";
				String pat_gross_charge_amt		= "", pat_disc_amt 			= "";
				String pat_net_charge_amt		= "", cust_gross_charge_amt	= "";
				String cust_disc_amt			= "", cust_net_charge_amt	= "";
				String split_ind				= "", curr_availed			= "";
				String credit_auth_ref			= "", error_text			= "";
				String serv_panel_ind       	= "", serv_panel_code       = "";
		 	 	String service_panel_name   	= "";

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
				net_charge_amt  		= beanObj.checkForNull(record[10],"");
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
				//out.println("alert('parent_order_id="+parent_order_id+",parent_order_line_num="+parent_order_line_num+",ordering_facility_id="+ordering_facility_id+",loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; ')");
				out.println( "loadBillingDetails(\""+day_type_code+"\",\"" +day_type_desc+"\" ,\""+time_type_code+"\",\""+time_type_desc+"\",\""+base_qty+"\",\"" +base_rate+"\" ,\""+addl_factor+"\",\""+base_charge_amt+"\",\"" +gross_charge_amt+"\" ,\""+disc_amt+"\",\""+net_charge_amt+"\",\""+disc_perc+"\",\""+pat_gross_charge_amt+"\",\""+pat_disc_amt+"\",\""+pat_net_charge_amt+"\",\""+cust_gross_charge_amt+"\",\""+cust_disc_amt+"\",\""+cust_net_charge_amt+"\" ,\""+split_ind+"\",\""+curr_availed+"\" ,\"" +credit_auth_ref+"\" ,\""+catalog_code+"\" ,\""+catalog_desc+"\" ,\""+serv_panel_ind+"\" ,\""+serv_panel_code+"\" ,\""+service_panel_name+"\" ,\""+error_text+"\") ; " ) ;
			}
		}
	}
%>
