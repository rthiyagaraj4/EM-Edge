<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReplaceableOrderableQueryCriteria.jsp -->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,java.sql.*,eOR.*,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>


<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//


	/* Mandatory checks start */
	String bean_id = "Or_Replaceable_Orderable" ;
	String bean_name = "eOR.ReplaceableOrderableBean";
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ReplaceableOrderableBean bean = (ReplaceableOrderableBean)getBeanObject( bean_id,  bean_name , request) ;  
	bean.clear() ;
	StringBuffer strbuff =	new StringBuffer();
	//Connection con		 =	null ;
	/* Initialize Function specific end */


	try {
	
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");  //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		firstItem.add("order_catalog_code");   //name of field
		firstItem.add("20");
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr
		

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
		secondItem.add("catalog_desc");   //name of field
		secondItem.add("40");
		secondItem.add("40");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr
				

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReplaceableOrderCatalogCode.label","or_labels"));  // label
		thirdItem.add("order_catalog_code_repl");   //name of field
		thirdItem.add("20");	//LENGTH
		thirdItem.add("20");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

								
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReplaceableOrderCatalogDescription.label","or_labels"));  // label
		fourthItem.add("order_catalog_code_repl_desc");   //name of field
		fourthItem.add("40");	//LENGTH
		fourthItem.add("40");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr


		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Hidden");  //Type of item
		fifthItem.add("function_id");  // name of field
		fifthItem.add("function_id");   //value of field
		finAr.add(fifthItem); //add to ArrayList obj finAr
		

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

	
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReplaceableOrderCatalogCode.label","or_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReplaceableOrderCatalogDescription.label","or_labels");
			
		
		orderByColVals[0] = "order_catalog_code";
		orderByColVals[1] = "catalog_desc";
		orderByColVals[2] = "order_catalog_code_repl";
		orderByColVals[3] = "order_catalog_code_repl_desc";


		strbuff =qrypg.getQueryPage(null, finAr, "Or_Replaceable_Orderable", "../../eOR/jsp/ReplaceableOrderableQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);

	finAr.clear();		
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
		
	}/*finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){
			 e.printStackTrace(System.out);
		 
		 }
	}*/
%>


