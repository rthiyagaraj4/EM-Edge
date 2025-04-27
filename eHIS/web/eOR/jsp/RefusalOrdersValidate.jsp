<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean"; //request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
    String localeName=(String)session.getAttribute("LOCALE");
//System.out.println("checking"+localeName);
//System.out.println("in refusal validate"+request.getQueryString());
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;
	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean",request) ;
	beanObj.setLanguageId(localeName);
	if ( validate.equals( "ref_ord" ) ) 
	{
		//RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean",request) ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;	
		out.println( "clearList(\"document\") ; " ) ;
		ArrayList OrderTypeData = beanObj.getLocation(ordercat) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
		{
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
	} 
	else if ( validate.equals( "ref_order_type" ) ) 
	{
		//RefusalOrdersBean beanObj = (RefusalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.RefusalOrdersBean") ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
	    String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;
	
 		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
	}	else if(validate.equals("pat_det"))
	{
		//RefusalOrdersBean beanObj = (RefusalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.RefusalOrdersBean") ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String patientId = (String)hash.get("patientId") ;
		ArrayList OrderTypeData = beanObj.getLocation1(patientId) ;
		if(OrderTypeData.size()==0)
		out.println("callClear();");
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
		{
			String[] record = (String[])OrderTypeData.get(i);
			record[0]=record[0].replace(',', '.');
			out.println("addPatientList(\""+record[0]+"\",\"" + record[1] + "\") ; " ) ;
		}				
			beanObj.clearBean();
	}
	else if(validate.equals("pat_details"))
	{
		//RefusalOrdersBean beanObj = (RefusalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.RefusalOrdersBean") ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String patientId = (String)hash.get("patientId") ;
		ArrayList OrderTypeData = beanObj.getLocation1(patientId) ;
	
		if(OrderTypeData.size()==0)
		out.println("callClear1();");
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
		{
			String[] record = (String[])OrderTypeData.get(i);
			record[0]=record[0].replace(',', '.');
			out.println("addPatientList1(\""+record[0]+"\",\"" + record[1] + "\",\"" + localeName + "\") ; " ) ;
		}				
			beanObj.clearBean();
	}//end of else loop
	else if(validate.equals("ord_cat_code"))
	{			
		String orderId            = beanObj.checkForNull(request.getParameter( "ord_id" ),"");
		String ord_line_num =  beanObj.checkForNull(request.getParameter( "order_line_num" ),"");
		String[] ordText         = beanObj.getOrderCatalog(orderId, ord_line_num);
		String order_catalog_code         = "";
		order_catalog_code = ordText[1];
		out.println("addcatalogcode(\""+order_catalog_code+ "\") ; " ) ;
	}//end of else loop
	else if(validate.equals("Remove_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		beanObj.removeOrderCatalogs(key+"$$"+value);
	}
	else if(validate.equals("refusal_Content"))
	{
		String consent_content=(String)beanObj.getConsentContent();
		String win_status = beanObj.getWindowStatus();	
		if(consent_content==null)consent_content="";
		String exists="";
		if(consent_content.length()>0 && win_status.equals("false"))
		{
			exists="true";
		}
		else
		{
			exists="false";				
		}
		out.println("consent_content(\""+exists+ "\") ; " ) ;
	}else if(validate.equals("WIN_STATUS"))
	{
		String win_status = request.getParameter( "win_status" )==null?"false":request.getParameter( "win_status" ) ;
		
		if(win_status.equals("onload"))
		{			
			beanObj.setWindowStatus("true");
		}else if(win_status.equals("onunload"))
		{			
			beanObj.setWindowStatus("false");
		}
	}
	else if(validate.equals("pat_details_tasklist"))
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String patientId = (String)hash.get("patientId") ;
		ArrayList OrderTypeData = beanObj.getLocation1(patientId) ;
		if(OrderTypeData.size()==0)
		out.println("callClear1();");
		beanObj.clearBean();
	}
	putObjectInBean(bean_id,beanObj,request);	
%>
