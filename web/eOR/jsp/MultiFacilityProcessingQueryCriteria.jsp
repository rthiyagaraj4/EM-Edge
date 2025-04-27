<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%-- Mandatory declarations end --%>

<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
	/* Mandatory checks start */
	
	String bean_id = "multifacilityprocessingbean" ;
	String bean_name = "eOR.MultiFacilityProcessingBean";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)getBeanObject( bean_id,bean_name, request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String comboBox = bean.getOrCatString();
	//out.println("comboBox :"+comboBox);

	ArrayList firstItem=new ArrayList();
	firstItem.add("Text");					// Type of item
	//firstItem.add(" Ordering Facility Id");
	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityID.label","common_labels"));	// label
	
	firstItem.add("ordering_facility_id");	// name of field
	firstItem.add("2");						// SIZE
	firstItem.add("2");						// LENGTH
	finAr.add(firstItem);					// add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityName.label","common_labels"));	// label
	secondItem.add("order_facility_name");	    //name of field
	secondItem.add("25");						// SIZE
	secondItem.add("60");						//LENGTH
	finAr.add(secondItem);						//add to ArrayList obj finAr

	//======================

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("List");						//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));			// label
	thirdItem.add("order_category");			//name of field
	thirdItem.add(" ,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+comboBox);		//LENGTH
	thirdItem.add("30");						//LENGTH
	finAr.add(thirdItem);						//add to ArrayList obj finAr


	ArrayList forthItem=new ArrayList();
	forthItem.add("Hidden");						// Type of item
	forthItem.add("function_id");					// label
	forthItem.add(function_id);						// name of field
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object
	//================= populating the 3rd item in the firstitem object
	//================= populating the 4th item in the firstitem object
	//================= populating the 5th item in the firstitem object
	
	ArrayList fivethItem=new ArrayList();
	fivethItem.add("Text");					// Type of item
	fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));		// label
	fivethItem.add("order_type_code");		// name of field
	fivethItem.add("4");					// LENGTH
	fivethItem.add("4");					//LENGTH
	finAr.add(fivethItem);					//add to ArrayList obj finAr

	//================= populating the 6th item in the firstitem object
	
	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");						// Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));			// label
	sixthItem.add("order_type_desc");			// name of field
	sixthItem.add("15");						// size
	sixthItem.add("15");						//LENGTH
	finAr.add(sixthItem);						//add to ArrayList obj finAr

	//================= populating the 7th item in the firstitem object

	ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");					// Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityID.label","common_labels"));	// label
	seventhItem.add("performing_facility_id");	// name of field
	seventhItem.add("2");						// size
	seventhItem.add("2");						//LENGTH
	finAr.add(seventhItem);						//add to ArrayList obj finAr

	//================= populating the 8th item in the firstitem object

	ArrayList eightItem=new ArrayList();
	eightItem.add("Text");						// Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityName.label","common_labels"));  // label
	eightItem.add("performing_facility_name");  // name of field
	eightItem.add("25");						// size
	eightItem.add("60");						//LENGTH
	finAr.add(eightItem);						//add to ArrayList obj finAr

	//================= populating the 9th item in the firstitem object
	
	ArrayList ninthItem=new ArrayList();
	ninthItem.add("Text");						// Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));		// label
	ninthItem.add("order_catalog_code");		// name of field
	ninthItem.add("10");						// size
	ninthItem.add("10");						//LENGTH
	finAr.add(ninthItem);						//add to ArrayList obj finAr

	//================= populating the 10th item in the firstitem object
	
	ArrayList tenthItem=new ArrayList();
	tenthItem.add("Text");						// Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));		// label
	tenthItem.add("order_catalog_desc");		// name of field
	tenthItem.add("15");						// size
	tenthItem.add("40");						//LENGTH
	finAr.add(tenthItem);						//add to ArrayList obj finAr

	//================= populating the 11th item in the firstitem object
	
	String orderByCols[] = new String[9];
	String orderByColVals[] = new String[9];

	orderByCols[0]		= //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderingFacilityId.label","or_labels");
	orderByCols[0]		= "Ordering Facility ID";
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityName.label","common_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
	orderByCols[5]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityID.label","common_labels");
	orderByCols[6]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityName.label","common_labels");
	orderByCols[7]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
	orderByCols[8]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
	

	orderByColVals[0]	= "ordering_facility_id";    
	orderByColVals[1]	= "order_facility_name";  
	orderByColVals[2]	= "order_category";   
	orderByColVals[3]	= "order_type_code";      
	orderByColVals[4]	= "order_type_desc";       
	orderByColVals[5]	= "performing_facility_id";  
	orderByColVals[6]	= "performing_facility_name";
	orderByColVals[7]	= "order_catalog_code";     
	orderByColVals[8]	= "order_catalog_desc";     
	
	
	strbuff =qrypg.getMultiColumnQueryPage(null, finAr, "multifacilityprocessingbean", "../../eOR/jsp/MultiFacilityProcessingQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	//strbuff =qrypg.getQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString().replace("nowrap",""));
	strbuff.setLength(0);

	putObjectInBean(bean_id,bean,request);


%>

