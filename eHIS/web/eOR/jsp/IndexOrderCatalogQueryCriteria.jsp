<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	/* Mandatory checks start */
	String bean_id = "indexordercatalogbean" ;
	String bean_name = "eOR.IndexOrderCatalogBean";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCatalogBean bean = (IndexOrderCatalogBean)getBeanObject( bean_id,bean_name, request ) ;  
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));			// label
	firstItem.add("service_code");			//name of field
	firstItem.add("4");						// SIZE
	firstItem.add("4");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels"));		// label
	secondItem.add("service_desc");			//name of field
	secondItem.add("15");					// SIZE
	secondItem.add("15");					//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));	// label
	thirdItem.add("order_catalog_code");	//name of field
	thirdItem.add("15");					//LENGTH
	thirdItem.add("15");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("Text");					// Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));	// label
	forthItem.add("catalog_desc");			// name of field
	forthItem.add("20");					// size
	forthItem.add("40");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================
	ArrayList fifthItem=new ArrayList();
	fifthItem.add("Hidden");					// Type of item
	fifthItem.add("function_id");	// label
	fifthItem.add(function_id);			// name of field
	finAr.add(fifthItem);					//add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
	orderByCols[2]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDescription.label","common_labels");

	orderByColVals[0]	= "service_code";    
	orderByColVals[1]	= "service_desc";  
	orderByColVals[2]	= "order_catalog_code";   
	orderByColVals[3]	= "catalog_desc";      
		
	strbuff =qrypg.getQueryPage(null, finAr, "indexordercatalogbean", "../../eOR/jsp/IndexOrderCatalogQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);

	putObjectInBean(bean_id,bean,request);
 

%>

