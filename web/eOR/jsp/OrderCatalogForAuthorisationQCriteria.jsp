<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
14/03/2014     IN041644			Nijitha S		Prescription Authorization of Drugs Based on Rules. 
18/03/2014	   IN047879			Nijitha S		Query Sort Order Order By Duration Type Execute Screen displayed as empty	
---------------------------------------------------------------------------------------------------------------

*/ %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="beanObj" scope="page" class="eOR.OrderEntryBean"/>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%-- Mandatory declarations end --%>


<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_OrderCatalogForAuthorisationBean" ;
	String bean_name = "eOR.OrderCatalogForAuthorisationBean";
	
	OrderCatalogForAuthorisationBean bean = (OrderCatalogForAuthorisationBean)getBeanObject( bean_id,  bean_name, 	request ) ;  

	bean.setLanguageId(localeName);
	beanObj.setLanguageId(localeName);
	StringBuffer strbuff = new StringBuffer();


	try 
	{	

		ArrayList l_final_Array = new ArrayList();

		ArrayList l_control_1 = new ArrayList();
	
		String comboString = bean.getOrderCategoryValues();
		
		ArrayList durationType = beanObj.getPlaceOrderDuration();
		System.out.println("size"+durationType.size());
		String[] durationType_details=null;
		String dur_type_amend="";
		for(int i=0; i<durationType.size(); i++)
		{
			durationType_details = (String[])durationType.get(i);
			dur_type_amend = dur_type_amend+","+durationType_details[0]+","+durationType_details[1];	 
		}
		System.out.println("dur_type_amend-->"+dur_type_amend);
		l_control_1.add("List");  		 //Type of item
		l_control_1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		l_control_1.add("order_category");	//name of field
		l_control_1.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString);	// SIZE
		l_control_1.add("6");	//LENGTH
		l_final_Array.add(l_control_1);//add to ArrayList obj finAr

		ArrayList l_control_2=new ArrayList();
		l_control_2.add("Text");  //Type of item
		l_control_2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
		l_control_2.add("order_type_code");   //name of field
		l_control_2.add("4");
		l_control_2.add("4");	//LENGTH
		l_final_Array.add(l_control_2); //add to ArrayList obj finAr
			
		ArrayList l_control_3=new ArrayList();
		l_control_3.add("Text");  //Type of item
		l_control_3.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		l_control_3.add("order_type_desc");   //name of field
		l_control_3.add("15");
		l_control_3.add("15");	//LENGTH
		l_final_Array.add(l_control_3); //add to ArrayList obj finAr
		
		ArrayList l_control_4=new ArrayList();
		l_control_4.add("Text");  //Type of item
		l_control_4.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		l_control_4.add("order_catalog_code");   //name of field
		l_control_4.add("4");
		l_control_4.add("4");	//LENGTH
		l_final_Array.add(l_control_4); //add to ArrayList obj finAr
		
		ArrayList l_control_5=new ArrayList();
		l_control_5.add("Text");  //Type of item
		l_control_5.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","or_labels"));  // label
		l_control_5.add("order_catalog_desc");   //name of field
		l_control_5.add("15");
		l_control_5.add("15");	//LENGTH
		l_final_Array.add(l_control_5); //add to ArrayList obj finAr
		
		ArrayList l_control_6=new ArrayList();
		l_control_6.add("List");  		 //Type of item
		l_control_6.add("Duration Type");	  // label
		//l_control_6.add("duration_type");	//name of field//IN047879
		l_control_6.add("auth_durn_type");	//name of field//IN047879
		l_control_6.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---,"+dur_type_amend);	// SIZE
		l_control_6.add("4");	//LENGTH
		l_final_Array.add(l_control_6);//add to ArrayList obj finAr

		function_id = request.getParameter( "function_id" );
		ArrayList l_control_7= new ArrayList();
		l_control_7.add("Hidden");  //Type of item
		l_control_7.add("function_id");  // name of field
		l_control_7.add(function_id);   //value of field
		l_final_Array.add(l_control_7); //add to ArrayList obj finAr	

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[3] = "Duration Type";
	
		orderByColVals[0] = "order_category";
		orderByColVals[1] = "order_type_code";
		orderByColVals[2] = "order_catalog_code";
		//orderByColVals[3] = "duration_type";//IN047879
		orderByColVals[3] = "auth_durn_type";//IN047879

		strbuff = qrypg.getQueryPage(null, l_final_Array, "Find Occupation", "../../eOR/jsp/OrderCatalogForAuthorisationQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		
		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
%>


