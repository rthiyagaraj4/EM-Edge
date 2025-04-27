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
*	Created By		:	Vinay
*	Created On		:	10 Feb 05
-->
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
	con = ConnectionManager.getConnection(request);	
	String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
	String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
	String ass_cate_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryCode.label","cp_labels");
	String ass_cate_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryDescription.label","cp_labels");
	String AssessmentCriteriaScoresQueryResult=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCriteriaScoresQueryResult.label","cp_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	ArrayList StageValues = new ArrayList();
	ArrayList firstItem = new ArrayList();
	
	firstItem.add("Text");  		//Type of item
	firstItem.add(ass_note_id);	// label
	firstItem.add("assess_note");	//name of field
	firstItem.add("4");			// SIZE
	firstItem.add("4");			//LENGTH
	StageValues.add(firstItem);			//add to ArrayList obj finAr
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  		 //Type of item
	secondItem.add(ass_note_desc);	 // label
	secondItem.add("assess_desc");	 //name of field
	secondItem.add("30");			 // SIZE
	secondItem.add("30");			 //LENGTH
	StageValues.add(secondItem);			 //add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   		 //Type of item
	thirdItem.add(ass_cate_code);        // label
	thirdItem.add("catg_code");   	 	 //name
	thirdItem.add("10");			 // SIZE
	thirdItem.add("10");			 //LENGTH
	StageValues.add(thirdItem); 			 //add to ArrayList obj finAr
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(ass_cate_desc);  	 //label
	fourthItem.add("catg_desc");  	 //name
	fourthItem.add("30");		         //SIZE 
	fourthItem.add("30");  			 //LENGTH
	StageValues.add(fourthItem);			 //add to ArrayList obj finAr
	String orderByCols[] 	= new String[4];
	String orderByColVals[] = new String[4];
	orderByCols[0] = ass_note_id;
	orderByCols[1] = ass_note_desc;
	orderByCols[2] = ass_cate_code;
	orderByCols[3] = ass_cate_desc;
	orderByColVals[0] = "assess_note";
	orderByColVals[1] = "assess_desc";
	orderByColVals[2] = "catg_code";
	orderByColVals[3] = "catg_desc";
	strbuff = qrypg.getQueryPage(con,StageValues,AssessmentCriteriaScoresQueryResult,"../jsp/AssessmentCriteriaScoresQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
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
