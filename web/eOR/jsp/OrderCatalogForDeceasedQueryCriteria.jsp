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
07/11/2012		IN036060		Karthi L		Sort order and Search criteria in Order Type Desc and Order Catalog Desc are not working
18/12/2013		IN045197		Ramesh G		Bru-HIMS-CRF-348.2 - Embalm request
18/12/2013		IN045770		Ramesh G		Bru-HIMS-CRF-348.2- 45197/03
---------------------------------------------------------------------------------------------------------------

*/ %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	String bean_id = "Or_OrderCatalogForDeceasedBean" ;
	String bean_name = "eOR.OrderCatalogForDeceasedBean";
	
	OrderCatalogForDeceasedBean bean = (OrderCatalogForDeceasedBean)getBeanObject( bean_id,  bean_name, 	request ) ;  

	//bean.clearALL();
	bean.setLanguageId(localeName);

	StringBuffer strbuff = new StringBuffer();

	//Connection con=null ;

	try 
	{	
		//con = ConnectionManager.getConnection(request);
		ArrayList l_final_Array = new ArrayList();

		ArrayList l_control_1 = new ArrayList();

		String comboString = bean.getOrderCategoryValues();

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
		l_control_6.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PostMortemAppl.label","or_labels"));	  // label
		l_control_6.add("post_applicability");	//name of field
		//IN045197 Start
		//l_control_6.add("B,Both,R,Post Mortem Request,Q,Post Mortem Record");	// SIZE
		l_control_6.add("B,All,R,Post Mortem Request,Q,Post Mortem Record,E,Embalm Registration");	// SIZE
		//IN045197 End.
		l_control_6.add("4");	//LENGTH
		l_final_Array.add(l_control_6);//add to ArrayList obj finAr

		ArrayList l_control_7=new ArrayList();
		l_control_7.add("List");  		 //Type of item
		l_control_7.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PostMortemType.label","or_labels"));	  // label
		l_control_7.add("post_type");	//name of field
		//IN045770 Start
		//l_control_7.add("B,Both,C,Clinical Post Mortem,M,Medico Legal Post Mortem");	// SIZE
		l_control_7.add("B,Both,C,Clinical Post Mortem,M,Medico Legal Post Mortem,E,Not Applicable");
		//IN045770 End.
		l_control_7.add("4");	//LENGTH
		l_final_Array.add(l_control_7);//add to ArrayList obj finAr

		function_id = request.getParameter( "function_id" );
		ArrayList l_control_8= new ArrayList();
		l_control_8.add("Hidden");  //Type of item
		l_control_8.add("function_id");  // name of field
		l_control_8.add(function_id);   //value of field
		l_final_Array.add(l_control_8); //add to ArrayList obj finAr	

		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PostMortemAppl.label","or_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PostMortemType.label","or_labels");
	
		orderByColVals[0] = "order_category";
		orderByColVals[1] = "order_type_code"; // IN036060
		orderByColVals[2] = "order_type_desc";
		orderByColVals[3] = "order_catalog_code"; //IN036060
		orderByColVals[4] = "order_catalog_desc";
		orderByColVals[5] = "POSTMORTEM_APPLICABILITY";
		orderByColVals[6] = "POSTMORTEM_TYPE";

		strbuff = qrypg.getQueryPage(null, l_final_Array, "Find Occupation", "../../eOR/jsp/OrderCatalogForDeceasedQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		
		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
%>


