<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes end --%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
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
	//String bean_id = "Or_OrdersTab";
	//String bean_name = "eOR.OrdersTabBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//OrdersTabBean  bean = (OrdersTabBean)mh.getBeanObject( bean_id, request,bean_name );  
	

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	//String  comboString = "";
	Connection con=null ;

	try {
		con = ConnectionManager.getConnection(request);
	

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));	  // label
		firstItem.add("patient_class");	//name of field
		firstItem.add("15");	// SIZE
		firstItem.add("15");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList firstItem1 = new ArrayList();
		firstItem1.add("Text");  		 //Type of item
		firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassDescription.label","common_labels"));	  // label
		firstItem1.add("patient_class_desc");	//name of field
		firstItem1.add("15");	// SIZE
		firstItem1.add("15");	//LENGTH
		finAr.add(firstItem1);//add to ArrayList obj finAr

		///////////////////////
		
		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));	  // label
		thirdItem.add("practitioner_id");	//name of field
		thirdItem.add("15");	// SIZE
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

		///////////////////////

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));	  // label
		fourthItem.add("practitioner_name");	//name of field
		fourthItem.add("15");	// SIZE
		fourthItem.add("15");	//LENGTH
		finAr.add(fourthItem);//add to ArrayList obj finAr

		///////////////////////

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");

		
		orderByColVals[0] = "patient_class";
		orderByColVals[1] = "practitioner_id";
		
		
		strbuff =qrypg.getQueryPage(con, finAr, "Or_OrdersTab", "../../eOR/jsp/OrdersTabQueryResult.jsp?function_id="+function_id, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());
	strbuff.setLength(0);
	} catch (Exception e) {
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

