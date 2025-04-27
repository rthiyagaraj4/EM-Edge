<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Sreelatha
*	Created On		:	27 Dec 2004
-->

<!-- OutcomeQueryCriteria.jsp-->
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;
	try 
	{
		con = (Connection) session.getValue( "connection" );
		String case_type_nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseTypeNature.label","cp_labels");
		String case_type_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseTypeCode.label","cp_labels");
		String case_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseTypeDescription.label","cp_labels");
		String case_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.CaseType.label","cp_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String ill_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.lllness.label","cp_labels");
		String well_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","commmon_labels");
		String Case_list="%,"+Both_legend+",I,"+ill_legend+",W,"+well_legend;
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
		
	firstItem.add("List");  		 // Type of item
	firstItem.add(case_type_nature);	 // Label
	firstItem.add("case_type_nature");	//Name of field
	firstItem.add(Case_list);
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(case_type_code);	  // Label
	secondItem.add("case_type_code");	//Name of field
	secondItem.add("12");	// SIZE
	secondItem.add("10");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(case_type_desc);	  // Label
	thirdItem.add("short_desc");	//Name of field
	thirdItem.add("50");	// SIZE
	thirdItem.add("60");	//Length

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	forthItem.add("List");   //Type of item
	forthItem.add(Nature);  // Label
	forthItem.add("eff_status");//Name
	forthItem.add(Nature_List);
	
	finAr.add(forthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = case_type;
	orderByCols[1] = case_type_desc;
		
	orderByColVals[0] = "case_type_code";
	orderByColVals[1] = "short_desc";
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
strbuff = qrypg.getQueryPage(con,finAr,case_type,"../../eCP/jsp/CaseTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	}
	catch (Exception e) 
	{
		out.println(e.toString());
	}
	finally
	{
		try
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);					
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
	}

%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
