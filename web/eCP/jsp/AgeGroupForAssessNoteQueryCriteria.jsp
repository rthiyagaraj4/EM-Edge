<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
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

Connection con=null ;
StringBuffer strbuff;


try {
	con = ServiceLocator.getInstance().getConnection(request);

	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
	String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
	String age_group_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroupcode.label","common_labels");
	String age_group_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroupdesc.label","common_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String find_age_group_for_ass_note=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindAgeGroupForAssessNote.label","cp_labels");
	firstItem.add("Text");  		 //Type of item
	firstItem.add(ass_note_id);	  // label
	firstItem.add("assess_note_id");	//name of field
	firstItem.add("4");
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
	thirdItem.add(age_group_code);  // label
	thirdItem.add("age_group_code");//name
	thirdItem.add("2"); //size
	thirdItem.add("2");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(age_group_desc);  // label
	fourthItem.add("long_desc");//name
	fourthItem.add("30"); //size
	fourthItem.add("30");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];
	
	orderByCols[0] = ass_note_id;
	orderByCols[1] = ass_note_desc;
	orderByCols[2] = age_group_code;
	orderByCols[3] = age_group_desc;

	orderByColVals[0] = "assess_note_id";
	orderByColVals[1] = "assess_note_desc";
	orderByColVals[2] = "age_group_code";
	orderByColVals[3] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,find_age_group_for_ass_note, "../jsp/AgeGroupForAssessNoteQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

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
