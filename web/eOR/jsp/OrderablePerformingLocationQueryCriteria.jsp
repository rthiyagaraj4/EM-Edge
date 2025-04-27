<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//

	//String readOnly = "" ;

	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter("function_id") ;
	String bean_id = "orderablePerformingLocation";
	String bean_name = "eOR.OrderablePerformingLocationBean";
	//String disabled = "" ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	OrderablePerformingLocationBean bean = (OrderablePerformingLocationBean)getBeanObject(bean_id,bean_name,request);
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {

		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
//out.println("<script>alert('-L-"+bean.getLbInstall("RL")+"-R--"+bean.getLbInstall("RD")+"');<script>");            
		//String comboString = "";//bean.getComboString();
		StringBuffer comboString=new StringBuffer();

		//comboString += "I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",";
			comboString.append("I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",");

		//if (!(bean.getLbInstall("RL")).equalsIgnoreCase("Y")) {changed on 7/19/2007 for labinstall check by uma 
		//if (!(bean.getLbInstall("RL")).equalsIgnoreCase("Y")) {
			//comboString += "L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",";
          comboString.append("L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",");


		//} 		
		//comboString += "M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",";
       comboString.append("M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",");

		//comboString += "P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PatientCare.label","or_labels")+",";

      comboString.append("P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",");


		if (!(bean.getLbInstall("RD")).equalsIgnoreCase("Y")) {
			//comboString += "R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",";
			comboString.append("R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",");
		}
		//comboString += "T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"";
       comboString.append("T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+",");//IN31901
       comboString.append("O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NonOTRooms.label","or_labels")+"");//IN31901

		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));	  // label
		firstItem.add("location_type");	//name of field
		firstItem.add("%,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString.toString());	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));  // label
		secondItem.add("location_code");   //name of field
		secondItem.add("6");	// SIZE
		secondItem.add("6");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels"));  // label
		thirdItem.add("location_desc");   //name of field
		thirdItem.add("30");	// SIZE
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels"));  // label
		fourthItem.add("order_type");   //name of field
		fourthItem.add("4");
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		fifthItem.add("order_type_desc");   //name of field
		fifthItem.add("15");
		fifthItem.add("15");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		sixthItem.add("order_catalog_code");   //name of field
		sixthItem.add("10");
		sixthItem.add("10");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr

		//==================== populating the 7th item in the firstitem object

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("Text");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
		seventhItem.add("order_catalog_desc");   //name of field
		seventhItem.add("40");	//LENGTH
		seventhItem.add("40");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr

		ArrayList eightItem = new ArrayList();
		eightItem.add("Hidden");  //Type of item
		eightItem.add("performing_facility_id");  // name of field
		eightItem.add(bean.getLoginFacilityId());   //value of field
		finAr.add(eightItem); //add to ArrayList obj finAr

		//==================== populating the 9th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList ninthItem = new ArrayList();
		ninthItem.add("Hidden");  //Type of item
		ninthItem.add("function_id");  // name of field
		ninthItem.add(function_id);   //value of field
		finAr.add(ninthItem); //add to ArrayList obj finAr


		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");

		orderByColVals[0] = "location_code";
		orderByColVals[1] = "location_desc";
		orderByColVals[2] = "location_type";
		orderByColVals[3] = "order_type";
		orderByColVals[4] = "order_type_desc";
		orderByColVals[5] = "order_catalog_code";
		orderByColVals[6] = "order_catalog_desc";


		//===============yet to explore================================//

		//strbuff = qrypg.getQueryPage(con, finAr, "EORCatalogBySection", "../../eOR/jsp/OrderablePerformingLocationQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");
		strbuff = qrypg.getQueryPage(null, finAr, "EOROrderablePerformingLocation","../../eOR/jsp/OrderablePerformingLocationQueryResult.jsp",
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),						com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),
		orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		strbuff.setLength(0);
		
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		System.out.println("main"+e);
	}/*finally{
		try
		 {
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){

		 }
	}*/
%>

