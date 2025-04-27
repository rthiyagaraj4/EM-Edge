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
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
13/09/2013    IN030284.1 	Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)	
---------------------------------------------------------------------------------------------------------------
*/
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean";
	String validate = request.getParameter( "validate" ) ;
    String localeName=(String)session.getAttribute("LOCALE");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean",request) ;
	beanObj.setLanguageId(localeName);
	try
	{
	if ( validate.equals( "ref_ord" ) ) 
	{
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
	} else if ( validate.equals( "ref_order_type" ) ) 
	{
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
	}//end of else loop
	else if(validate.equals("Remove_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String from = beanObj.checkForNull(request.getParameter("from")) ;
		String to = beanObj.checkForNull(request.getParameter("to")) ;
		String flag = "box_unchecked";
		beanObj.setfrom(from);
		beanObj.setto(to);
		beanObj.setflag(flag);
		beanObj.removeTempOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
	}
	else if(validate.equals("Add_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String nature = beanObj.getCatalogNature(key);
		int orderSetCount = beanObj.getorderSetCount();
		
		if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no))
		{
			if(nature.equals("S"))
			{
				if(orderSetCount>=1)
				{
					out.println("addCatalog(\"ORDER_SET_SELECTED\");");
				}
				else
				{
					beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
					out.println("addCatalog(\"SAVE\");");
				}
			}
			else
			{
				beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
				out.println("addCatalog(\"SAVE\");");
			}
		}
	}
	else if(validate.equals("Remove_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String from = beanObj.checkForNull(request.getParameter("from")) ;
		String to = beanObj.checkForNull(request.getParameter("to")) ;
		String flag = "box_unchecked";
		beanObj.setfrom(from);
		beanObj.setto(to);
		beanObj.setflag(flag);
		beanObj.removeOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
	}
	else if(validate.equals("Add_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no))
		{
			beanObj.putObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
		}
	}
	else if(validate.equals("Reset_Order_Catalog"))
	{
		beanObj.clearObject();
	}
	else if(validate.equals("Submit_Order_Catalog"))
	{
		beanObj.finalOrderable();
	}
	else if(validate.equals("Clear_Order_Catalogs"))
	{
		beanObj.clearObject(); 
		beanObj.clearTempObject();
	}	
	else if(validate.equals("Record_order_catalog"))
	{
		
	}
	}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	putObjectInBean(bean_id,beanObj,session);	
%>
