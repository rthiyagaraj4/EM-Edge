<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	PrivilegeGroupBean beanObj = (PrivilegeGroupBean)getBeanObject( bean_id , bean_name, request) ;
	beanObj.clear();
	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	String queryMode = (String) hash.get("QUERYMODE");
	String mode = (String) hash.get("mode");
	//System.out.println("=queryMode=="+queryMode);
	if(null!=queryMode && queryMode.equalsIgnoreCase("savecategory"))
		{
			String tabvalue = (String)hash.get("tabvalue") ;
			String type = (String)hash.get("type") ;
			String obj = (String)hash.get("obj") ;
			String categorykey=tabvalue+"!!"+type;
			//System.out.println("==="+mode+obj+categorykey);
			if(obj.equals("defaultSelect") && mode.equals("1"))
			beanObj.removeCategoryValues(categorykey);
			else
			beanObj.setCategoryValues(categorykey,obj);
		}
	else if(null!=queryMode && queryMode.equalsIgnoreCase("saveordertype"))
	{
			String tabvalue = (String)hash.get("tabvalue") ;
			String type = (String)hash.get("type") ;
			String obj = (String)hash.get("obj") ;
			String order_category = (String)hash.get("order_category") ;
			String typekey=tabvalue+"!!"+order_category+"!!"+type;
			if(obj.equals("defaultSelect") && mode.equals("1"))
			beanObj.removeTypeValues(typekey);
			else
			beanObj.setTypeValues(typekey,obj);
	}
	else if(null!=queryMode && queryMode.equalsIgnoreCase("savecatalog"))
	{
			String tabvalue = (String)hash.get("tabvalue") ;
			String type = (String)hash.get("type") ;
			String obj = (String)hash.get("obj") ;
			String order_category = (String)hash.get("order_category") ;
			String order_type = (String)hash.get("order_type") ;
			String catalogkey=tabvalue+"!!"+order_category+"!!"+order_type+"!!"+type;
			if(obj.equals("defaultSelect") && mode.equals("1"))
			beanObj.removeCatalogValues(catalogkey);
			else
			beanObj.setCatalogValues(catalogkey,obj);
	}
	else if(null!=queryMode && queryMode.equalsIgnoreCase("copy"))
	{
			String tabvalue = (String)hash.get("tabvalue") ;
			String obj = (String)hash.get("obj") ;
			String obj_desc=beanObj.get_order_tab(obj);
			obj_desc=" "+obj_desc;
			boolean test=beanObj.copyValues(tabvalue,obj);
			if(!test)
				out.println("alert(getMessage(\"OR_PRIVILEGE_GROUP_COPY_FROM\",\"OR\") +'"+obj_desc+"')");
	}
	else if(null!=queryMode && queryMode.equalsIgnoreCase("undo"))
	{
			String tabvalue = (String)hash.get("tabvalue") ;
			String typecode = (String)hash.get("typecode") ;
			String type = (String)hash.get("type") ;
			boolean report=beanObj.undoChanges(tabvalue,typecode,type);
			if(!report)
				out.println("alert(getMessage(\"OR_PRIVILEGE_GROUP_UNDO\",\"OR\"))");
				
	}
	%>
