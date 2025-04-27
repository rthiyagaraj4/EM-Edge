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
*	Created By		:	Sandhya.S
*	Created On		:	24 jan 2005

--%>
<%@ page import ="java.util.*" contentType="text/html; charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>
<BODY style="overflow-y:hidden">

<%
	 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();

	try {
		ArrayList finAr = new ArrayList();
		String lib_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryID.label","cp_labels");
		String lib_des=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryDescription.label","cp_labels");
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");							//	Type of item
		firstItem.add(lib_id);				//	Label
		firstItem.add("LIBRARY_ID");				//	Name of field
		firstItem.add("20");								//	SIZE
		firstItem.add("20");								//	LENGTH
		finAr.add(firstItem);							//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");									//	Type of item
		secondItem.add(lib_des);					    //	Label
		secondItem.add("SHORT_DESC");					    //	Name of field
		secondItem.add("60");									    //	.SIZE
		secondItem.add("60");									    //   Length
		finAr.add(secondItem);									    //	Add to ArrayList obj finAr

		
	
        //=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = lib_id;
		orderByCols[1] = lib_des;
		
		orderByColVals[0] = "LIBRARY_ID";
		orderByColVals[1] = "SHORT_DESC";
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String lib=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Library.label","cp_labels");
		strbuff = qrypg.getQueryPage(null, finAr, lib , "BuildLibraryQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		//out.println( "main " + e );//COMMON-ICN-0181
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
