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
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	27 Dec 2004
-->

<!-- OutcomeQueryCriteria.jsp-->
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*"contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
//This file is saved on 18/10/2005.
	String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	try 
	{
	
	ArrayList finAr						=		new ArrayList();
	ArrayList firstItem					=		new ArrayList();

	
	String Outcome_Indicator			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.OutcomeIndicator.label","cp_labels");
	
	String Both_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Goal							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Goal.label","cp_labels");
	String Expected_Outcome				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.ExpectedOutcome.label","cp_labels");
	String outcome_type_List						=		"%,"+Both_legend+",G,"+Goal+",O,"+Expected_Outcome;
	firstItem.add("List");  		 // Type of item
	firstItem.add(Outcome_Indicator);	 // Label
	firstItem.add("outcome_type");	//Name of field
	firstItem.add(outcome_type_List);
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	String Outcome_Code			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.OutcomeCode.label","cp_labels");
	secondItem.add("Text");  		 //Type of item
	secondItem.add(Outcome_Code);	  // Label
	secondItem.add("outcome_code");	//Name of field
	secondItem.add("12");	// SIZE
	secondItem.add("10");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	String Outcome_Description			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.OutcomeDescription.label","cp_labels");
	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(Outcome_Description);	  // Label
	thirdItem.add("short_desc");	//Name of field
	thirdItem.add("68");	// SIZE
	thirdItem.add("60");	//Length

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();
	String Nature							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	
	String Enabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List						=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	forthItem.add("List");   //Type of item
	forthItem.add(Nature);  // Label
	forthItem.add("eff_status");//Name
	forthItem.add(Nature_List);
	
	finAr.add(forthItem); //add to ArrayList obj finAr

	String orderByCols[]					=		new String[2];
	String orderByColVals[]					=		new String[2];

	orderByCols[0]							=		Outcome_Code;
	orderByCols[1]							=		Outcome_Description;
		
	orderByColVals[0]						=		"outcome_code";
	orderByColVals[1]						=		"short_desc";
	

	
	String Sort_order						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


	strbuff = qrypg.getQueryPage(null,finAr,"Outcome","../../eCP/jsp/OutcomeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	}
	catch (Exception e) 
	{
		//out.println(e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
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
