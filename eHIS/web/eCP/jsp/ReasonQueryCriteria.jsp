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
*	Created By		:	nikhil
*	Created On		:	27 jan 05
-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
	String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>

<%

	ecis.utils.CommonQueryPage qrypg		=		new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con							=		null;
	PreparedStatement ps					=		null;
	ResultSet rs							=		null;

try{
	
	ArrayList final_arr						=		new ArrayList();
//	conn									=		(Connection) session.getValue( "connection" );

	ArrayList firstItem						=		new ArrayList();
	String Reason_Code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
	firstItem.add("Text");//Type of item	
	firstItem.add(Reason_Code);// label
	firstItem.add("reason_code");//name of field
	firstItem.add("4");//size
	firstItem.add("4");//maxlength
	final_arr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	String Reason_Description				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonDescription.label","common_labels");
	secondItem.add("Text");//Type of item
	secondItem.add(Reason_Description);//label
	secondItem.add("reason_desc");//name
	secondItem.add("30");//size
	secondItem.add("30");//maxlength
	final_arr.add(secondItem);//add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();
	String Applicable_To					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels");
	thirdItem.add("List");//Type of item
	thirdItem.add(Applicable_To);//label
	thirdItem.add("activity_type_code");//name

	con										=		ConnectionManager.getConnection(request);
	//ps									=		con.prepareStatement("select activity_type_code, activity_type_desc from cp_activity_type order by activity_type_desc");
	ps = con.prepareStatement("SELECT ACTIVITY_TYPE_CODE, ACTIVITY_TYPE_DESC FROM CP_ACTIVITY_TYPE_LANG_VW WHERE language_id='"+locale+"'"+ "ORDER BY ACTIVITY_TYPE_DESC");
	rs										=		ps.executeQuery();
	String list_of_value					=		"%"+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");;
	while(rs != null && rs.next())
	{
		list_of_value						=		list_of_value+","+rs.getString(1)+","+rs.getString(2);
	}
	
	thirdItem.add(list_of_value);//Database values that need to be displayed as option.
	final_arr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem					=		new ArrayList();
	String Nature							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	 String Nature_List						=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;

	fourthItem.add("List");//Type of item
	fourthItem.add(Nature);//label
	fourthItem.add("eff_status");//name
	fourthItem.add(Nature_List);//static values that need to be displayed as option.
	final_arr.add(fourthItem);//add to ArrayList obj finAr
	

	String Sort_order						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	String orderByCols[]					=		new String[2];
	String orderByColVals[]					=		new String[2];

	orderByCols[0]							=		Reason_Code;
	orderByCols[1]							=		Reason_Description;

	orderByColVals[0]						=		"reason_code";
	orderByColVals[1]						=		"reason_desc";

	strbuff									=		qrypg.getQueryPage(con,final_arr,"Find Reason","../jsp/ReasonQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());

	}
	catch (Exception e) 
	{
		//out.println(e.toString());//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
	}	finally{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		 ConnectionManager.returnConnection(con,request);
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

