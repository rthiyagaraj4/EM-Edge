<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	24 Dec 2004

--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*" contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
 request.setCharacterEncoding("UTF-8");
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
	 //This file is saved on 18/10/2005.
	Connection con=null ;
	con = (Connection) session.getValue( "connection" );

	try
	{
	ArrayList finAr = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String ass_cat_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryCode.label","cp_labels");
	String ass_cat_disc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryDescription.label","cp_labels");
	String find_ass_cate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindAssessmentCategory.label","cp_labels");
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
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(ass_cat_code);	  // label
	firstItem.add("assess_catg_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(ass_cat_disc); //label
	secondItem.add("short_desc");//name
	secondItem.add("15"); //size
	secondItem.add("15");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
	

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(Nature);// label
	thirdItem.add("eff_status");//name
	thirdItem.add(Nature_List);//static values that need to be displayed as option.
	finAr.add(thirdItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = ass_cat_code;
	orderByCols[1] = ass_cat_disc;
	orderByColVals[0] = "assess_catg_code";
	orderByColVals[1] = "short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,find_ass_cate,"../jsp/AssessmentCategoryQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());

	}
	catch (Exception e) 
	{
	//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
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
