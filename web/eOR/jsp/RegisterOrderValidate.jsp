<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<% /*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
15/12/2017	IN065942		Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the 																				barcode functionality at the time of 																							Registration of order,required patient 																							Id,patient name,age,sex,register date and name 																					of study.
23/04/2020	  IN071618	   Nijitha S	 					PMG2019-MMS-CRF-0004
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
try
{
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag		= request.getParameter("flag");
	String login_value		= request.getParameter("login_value");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String value="";

	String practitioner_id	 =(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	
	String resp_id 			=(String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	RegisterOrder beanObj = (RegisterOrder)getBeanObject( bean_id, "eOR.RegisterOrder" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	OnLinePrinting online_print = new OnLinePrinting();//IN065942
    if (flag == null || flag.equals("")) {
		if ( validate.equals( "location" ) ) {
			String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;

			ArrayList OrderTypeData = beanObj.getLocation(locn_type) ;
			
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}
	} else if (flag.equalsIgnoreCase("true")) {
		if ( validate.equals( "ord_cat" ) ) {
			
			out.println( "clearCategoryList('document') ; " ) ;
            ArrayList OrderTypeData = new ArrayList();
			if (practitioner_id != null && !practitioner_id.equals("")){
				
				OrderTypeData = beanObj.getOrderCategoryByPract(practitioner_id);
				value="pract";
				}
			if ((OrderTypeData.size() == 0) && ((resp_id != null) && (!resp_id.equals(""))) ) {
				OrderTypeData = beanObj.getOrderCategoryByResp(resp_id);
				value="resp";
				
			}

			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				
				if (OrderTypeData.size() == 1 && i == 0) {
					
					selected = "true";
				}
				out.println( "addCategoryList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				out.println( "setvalue(\"" + value+ "\") ; " ) ;

				if (OrderTypeData.size() == 1) {
					out.println("populateLocnOrdType('ord_type');");
				} else {
					out.println("formObj.ord_cat.value='';");
				}
			}
		
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("ord_cat") ;
			String isRDInstalled_yn="";
			String isOTInstalled_yn="";

			out.println( "clearTypeList('document') ; " ) ;
			
			if(orderCategory!="")
				{
					if(orderCategory.equalsIgnoreCase("RD"))
					{
						isRDInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"RD");
						out.println( "setRDvalue(\"" + isRDInstalled_yn+ "\") ; " ) ;
						if(isRDInstalled_yn.equalsIgnoreCase("Y"))
						{
							orderCategory="";
						}
					}
					
					/* else if(orderCategory.equalsIgnoreCase("OT"))
					{
						isOTInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"OT");
						out.println( "setOTvalue(\"" + isOTInstalled_yn+ "\") ; " ) ;
						if(isOTInstalled_yn.equalsIgnoreCase("Y"))
						{
							orderCategory="";
						}
					} */
				}
				if(orderCategory!="")
				{
					ArrayList OrderTypeData = new ArrayList();
					if(login_value.equalsIgnoreCase("pract"))
					{
						if (practitioner_id != null && !practitioner_id.equals(""))
						{	
							OrderTypeData = beanObj.getOrderTypeByPract(orderCategory, practitioner_id);
						}
					}
					else if(login_value.equalsIgnoreCase("resp"))
					{
						if ((OrderTypeData.size() == 0) && ((resp_id != null) && (!resp_id.equals(""))) ) {
							OrderTypeData = beanObj.getOrderTypeByResp(orderCategory,resp_id);
					}
				}

				for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
					String[] record = (String[])OrderTypeData.get(i);
					out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
				//String order_type = "" ;
				
            		//out.println( "clearPerformingLocnList('document') ; " ) ;
					//ArrayList PerformingLocn = new ArrayList();
					
	            	//PerformingLocn = beanObj.getPerformingLocn(orderCategory);
				

					//for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
						//String[] record = (String[])PerformingLocn.get(i);
						//out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
					//}
							
		}
		} else if ( validate.equals( "PERFORM_LOCN_INT_OR_EXT" ) ) {
		 
		} else if ( validate.equals( "CHANGE_PERFORM_LOCN" ) ) {
		     
		      String performing_facility = (String)hash.get("performing_facility") ;
		      String order_category = (String)hash.get("order_category") ;
		      String order_catalog_code = (String)hash.get("order_catalog_code") ;
		      out.println( "clearChangePerformLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				PerformingLocn = beanObj.getPerformingLocationDetails(performing_facility,order_category,order_catalog_code);

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					out.println( "addChangePerformLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
		} else if ( validate.equals( "CHECK_INT_OR_EXT" ) ) {
		    String int_or_ext = "";
		    String order_id = (String)hash.get("order_id") ;
			
			int_or_ext = beanObj.getIntOrExt(order_id);
			out.println( "formObj.int_or_ext.value='" + int_or_ext + "';" ) ;
		}else if ( validate.equals( "SET_REF_CONTENT" ) ) {
		    String ref_form_text = "";
		    String ref_form_id = (String)hash.get("ref_form_id") ;
			ref_form_text = (String ) beanObj.getRefFormContent(ref_form_id);
			beanObj.setRefFormContent(ref_form_text);
			
		}else if ( validate.equals( "activity_type" ) ) {
			//String order_category = request.getParameter("order_category");
			//String order_type = request.getParameter("order_type") ;
	
            	//out.println( "clearPerformingLocnList('document') ; " ) ;
	            //ArrayList PerformingLocn = new ArrayList();
           		//PerformingLocn = beanObj.getPerformingLocn(order_category);
			
				//for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					//String[] record = (String[])PerformingLocn.get(i);
					//out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				//}
						
		}
		else if ( validate.equals( "PRINT_REG_ORDER_LABEL" ) ) //IN065942, starts
		{
			Hashtable print_reg_order_lbls = beanObj.getPrintLabelValues();
			
			if(print_reg_order_lbls.size()>0)
			{
				online_print.printRegOrdLabel(print_reg_order_lbls, request, response);
				beanObj.clearPrintLabelValues();
			}
		}//IN065942, ends
		else if(validate.equals("CHECK_BILLSETTLEMENT"))//IN071618 Starts
		{
			String order_id = (String)hash.get("order_id");
			String ordering_facility = (String)hash.get("ordering_facility");
			String patient_class = (String)hash.get("patient_class");
			String patient_id = (String)hash.get("patient_id");
			String encounter_id = (String)hash.get("encounter_id");
			String rec_num = (String)hash.get("rec_num");
			
			
				ArrayList BillDetails = beanObj.getBillSettlementYN(ordering_facility, order_id);
				String message = "";	
				String details = "";
				if (BillDetails.size() > 0) 
				{
					for( int i=0 ; i< BillDetails.size() ; i++ ) 
					{	
						String[] record = (String[])BillDetails.get(i);	
						message = record[0];
						details = record[1];
					}
					out.println("settlementPendingMsg(\""+message+ "\",\""+details+"\",\""+patient_id+"\",\""+encounter_id+"\",\""+ordering_facility+"\",\""+rec_num+"\");");
				}
			
		}//IN071618 Ends
	}

	putObjectInBean(bean_id,beanObj,request);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
