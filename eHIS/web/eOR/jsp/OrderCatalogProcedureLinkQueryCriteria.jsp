<!DOCTYPE html>
<%-----JSP page specific attributes start ---%>
<%@page import="java.util.*,java.sql.*,eOR.*,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-----JSP page specific attributes end ---%>

<%---Mandatory declarations start---%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle=((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%---Mandatory declarations end---%>

<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//

	
	/* Mandatory checks start */
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_Order_Catalog_Procedure_Link" ;
	String bean_name = "eOR.OrderCatalogProcedureLink";

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderCatalogProcedureLink bean = (OrderCatalogProcedureLink)getBeanObject( bean_id,  bean_name , request) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	/* Initialize Function specific end */

	String comboString = bean.getComboString();
	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {
		
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		firstItem.add("order_catalog_code");   //name of field
		firstItem.add("20");
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr
		

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
		secondItem.add("order_catalog");   //name of field
		secondItem.add("40");
		secondItem.add("40");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetID.label","common_labels"));	  // label
		thirdItem.add("term_set");	//name of field
		thirdItem.add("'',--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString);	// SIZE
		thirdItem.add("6");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TermSetCode.label","or_labels"));  // label
		fourthItem.add("term_set_code");   //name of field
		fourthItem.add("30");	//LENGTH
		fourthItem.add("30");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetDescription.label","common_labels"));  // label
		fifthItem.add("term_set_desc");   //name of field
		fifthItem.add("60");	//LENGTH
		fifthItem.add("60");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		function_id = request.getParameter( "function_id" );
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

	
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetID.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TermSetCode.label","or_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetDescription.label","common_labels");

		orderByColVals[0] = "order_catalog_code";
		orderByColVals[1] = "order_catalog";
		orderByColVals[2] = "term_set";
		orderByColVals[3] = "term_set_code";
		orderByColVals[4] = "term_set_desc";

		strbuff =qrypg.getQueryPage(null, finAr, "Or_Order_Catalog_Procedure_Link", "../../eOR/jsp/OrderCatalogProcedureLinkQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);
		
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


