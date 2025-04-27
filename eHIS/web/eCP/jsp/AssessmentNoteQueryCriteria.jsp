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
		String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
		String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
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
		String assessmentnote=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNote.label","cp_labels");
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(ass_note_id);	 // Label
	firstItem.add("assess_note_id");	//Name of field
	firstItem.add("4");			// SIZE
	firstItem.add("4");
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(ass_note_desc);	  // Label
	secondItem.add("assess_note_desc");	//Name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");   //Type of item
	thirdItem.add(Nature);  // Label
	thirdItem.add("eff_status");//Name
	thirdItem.add(Nature_List);
	
	finAr.add(thirdItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = ass_note_id;
	orderByCols[1] = ass_note_desc;
		
	orderByColVals[0] = "assess_note_id";
	orderByColVals[1] = "assess_note_desc";
	
strbuff = qrypg.getQueryPage(con,finAr,assessmentnote,"../../eCP/jsp/AssessmentNoteQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	}
catch (Exception e) 
	{
		//out.println(e.toString());//COMMON-ICN-0181
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
