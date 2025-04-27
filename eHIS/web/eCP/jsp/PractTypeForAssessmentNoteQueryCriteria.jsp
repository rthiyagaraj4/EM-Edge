<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*   File Name		:	PractTypeForAssessmentNoteQueryCriteria.jsp
*	Purpose 			:	to get the criteria for the Query
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;

try {
	con = ServiceLocator.getInstance().getConnection(request);
	String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
	String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
	String prac_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	String prac_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PractitionerTypeDescription.label","common_labels");
	String find_pract_type_for_ass=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FindPractitionerTypeForAssessmentNote.label","common_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	
	firstItem.add("Text");  		 //Type of item
	firstItem.add(ass_note_id);	  // label
	firstItem.add("assess_note_id");	//name of field
	firstItem.add("3");
	firstItem.add("4"); //size
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(ass_note_desc); //label
	secondItem.add("assess_note_desc");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(prac_type);  // label
	thirdItem.add("pract_type");//name
	thirdItem.add("2"); //size
	thirdItem.add("2");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(prac_type_desc);  // label
	fourthItem.add("pract_type_desc");//name
	fourthItem.add("30"); //size
	fourthItem.add("30");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = ass_note_id;
	orderByCols[1] = ass_note_desc;
	orderByCols[2] = prac_type;
	orderByCols[3] = prac_type_desc;

	orderByColVals[0] = "a.assess_note_id";
	orderByColVals[1] = "b.assess_note_desc";
	orderByColVals[2] = "a.pract_type";
	orderByColVals[3] = "c.desc_userdef";

	strbuff = qrypg.getQueryPage(con,finAr,find_pract_type_for_ass, "../jsp/PractTypeForAssessmentNoteQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		ServiceLocator.getInstance().returnConnection(con,request);
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
