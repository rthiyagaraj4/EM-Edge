<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;

		String l_bean_id		= (String)hash.get("bean_id");
		String l_bean_name	= (String)hash.get("bean_name");
		String update_value	="";
		String l_action = (String)hash.get("p_action");
		String l_order_category = (String)hash.get("p_order_category");
		String l_language_id = (String)hash.get("p_language_id");
		String l_field_index = (String)hash.get("p_index");
		int l_index = Integer.parseInt(l_field_index);
		ArrayList l_order_types = null;
		System.out.println(" L _INDEX " + l_index);
		System.out.println("OrderCatalogForDeceasedValidate.jsp,request=>"+request.getQueryString());
		System.out.println("OrderCatalogForDeceasedValidate.jsp,20,l_action=>"+l_action);
		OrderCatalogForDeceasedBean beanObj = (OrderCatalogForDeceasedBean)getBeanObject(l_bean_id,l_bean_name, request) ;
		System.out.println("OrderCatalogForDeceasedValidate.jsp,l_action=>"+l_action+",l_order_category=>"+l_order_category);

		if(l_action.equals("LOAD_ORDER_TYPES"))
		{
			beanObj.setLanguageId(l_language_id);
			l_order_types = beanObj.getOrderTypes(l_order_category);
			System.out.println("OrderCatalogForDeceasedValidate.jsp,l_order_types=>"+l_order_types);
			
			out.println( "clearOrderTypeList('document', \""+l_index+"\" ) ; " ) ;

			for( int i=0 ; i< l_order_types.size() ; i++ ) 
			{
				String[] l_record_details = (String[])l_order_types.get(i);
				out.println( "addOrderTypeList(\"" + l_record_details[0] + "\",\"" + l_record_details[1] + "\" ,\"" + l_index + "\"	) ; " ) ;
			}
		}
		else if(l_action.equals("DELETE_RECORDS"))
		{
			String l_delete_records = (String)hash.get("p_delete_records");		
			String l_task = (String)hash.get("p_task");	
			
			if(l_task.equals("ADD"))
				beanObj.addDeleteRecords(l_delete_records);
			else if(l_task.equals("REMOVE"))
				beanObj.removeDeleteRecords(l_delete_records);
		}

		putObjectInBean("orderCatalogForDeceasedBean","OrderCatalogForDeceasedBean",request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>
