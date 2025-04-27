<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */
	
	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("List");  				// Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExceptionType.label","or_labels"));		// label
	firstItem.add("exception_type");		// name of field
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;&nbsp;,OC,Order Category,OT,Order Type,OR,Orderable");  // SIZE

	firstItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",OC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels")+",OT,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+",OR,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orderable.label","common_labels")+"");
	finAr.add(firstItem);					// add to ArrayList obj finAr
	
	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");					// Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupID.label","or_labels"));			    // label
	secondItem.add("grp_exception_id");		// name of field
	secondItem.add("10");					// SIZE
	secondItem.add("10");					// LENGTH
	finAr.add(secondItem);					// add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					// Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupName.label","common_labels"));	        // label
	thirdItem.add("grp_exception_name");	// name of field
	thirdItem.add("15");					// LENGTH
	thirdItem.add("30");					// LENGTH
	finAr.add(thirdItem);					// add to ArrayList obj finAr

	//================
	ArrayList fourthItem=new ArrayList();
	fourthItem.add("Hidden");				// Type of item
	fourthItem.add("function_id");	        // label
	fourthItem.add(function_id);			// name of field
	finAr.add(fourthItem);					// add to ArrayList obj finAr


	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupID.label","or_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExceptionType.label","or_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupName.label","common_labels");
	
	
	orderByColVals[0]	= "grp_exception_id";    
	orderByColVals[1]	= "exception_type";  
	orderByColVals[2]	= "grp_exception_name";   
			
	strbuff =qrypg.getQueryPage(null, finAr, "privilegeexceptiongrpbean", "../../eOR/jsp/PrivilegeExceptionGrpQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);

%>

