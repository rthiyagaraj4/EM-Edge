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
*	Purpose 		:	to get the query criteria
*	Created By		:	
*	Created On		:	18 July 2005
-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->

<% 
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
//ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

try{
	
	ArrayList final_arr = new ArrayList();
//	conn = (Connection) session.getValue( "connection" );
	
	ArrayList firstItem = new ArrayList();
	String var_cause_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.VarianceCauseCode.label","cp_labels");
	String var_cause_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.VarianceCauseDescription.label","cp_labels");
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String find_reason=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindReason.label","cp_labels");
	firstItem.add("Text");//Type of item
	firstItem.add(var_cause_code);// label
	firstItem.add("VAR_CAUSE_CODE");//name of field
	firstItem.add("4");//size
	firstItem.add("4");//maxlength
	final_arr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");//Type of item
	secondItem.add(var_cause_desc);//label
	secondItem.add("VAR_CAUSE_DESC");//name
	secondItem.add("30");//size
	secondItem.add("30");//maxlength
	final_arr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");//Type of item
	thirdItem.add(Nature);//label
	thirdItem.add("eff_status");//name
	thirdItem.add(Nature_List);//static values that need to be displayed as option.
	final_arr.add(thirdItem);//add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = var_cause_code;
	orderByCols[1] = var_cause_desc;

	orderByColVals[0] = "VAR_CAUSE_CODE";
	orderByColVals[1] = "VAR_CAUSE_DESC";

	strbuff = qrypg.getQueryPage(null,final_arr,find_reason,"../jsp/VarianceCauseQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());

	}
	catch (Exception e) 
	{
		out.println(e.toString());
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
