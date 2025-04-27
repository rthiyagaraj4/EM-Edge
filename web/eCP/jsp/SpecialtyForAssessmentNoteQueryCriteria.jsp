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
*	Created By		:	Sreelatha
*	Created On		:	10 Jan 2005

--%>
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
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
String spl_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels");
String spl_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyDescription.label","common_labels");
String find_splty_for_ass_note=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindSpecialtyForAssessmentNote.label","cp_labels");
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

firstItem.add("Text");  		//Type of item
firstItem.add(ass_note_id);	// label
firstItem.add("assess_note_id");	//name of field
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(ass_note_desc);	 // label
secondItem.add("assess_note_desc");	 //name of field
secondItem.add("60");			 // SIZE
secondItem.add("60");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(spl_code);        // label
thirdItem.add("specialty_code");   	 	 //name
thirdItem.add("2");			 // SIZE
thirdItem.add("2");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(spl_desc);  	 //label
fourthItem.add("specialty_desc");  	 //name
fourthItem.add("30");		         //SIZE 
fourthItem.add("30");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = ass_note_id;
orderByCols[1] = ass_note_desc;
orderByCols[2] = spl_code;
orderByCols[3] = spl_desc;

orderByColVals[0] = "assess_note_id";
orderByColVals[1] = "assess_note_desc";
orderByColVals[2] = "specialty_code";
orderByColVals[3] = "specialty_desc";



strbuff = qrypg.getQueryPage(con,finAr,find_splty_for_ass_note,"../jsp/SpecialtyForAssessmentNoteQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

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
