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
*	Created On		:	31 Dec 2004

--%>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " %>
  <script language="javascript" src="../js/CpMessages.js"></script>  

  <% 
  //This file is saved on 18/10/2005.
  String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
  %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;


try {
	con = ServiceLocator.getInstance().getConnection(request);
 
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add("Level of Care Code");	  // label
	firstItem.add("level_of_care_code");	//name of field
	firstItem.add("10");
	firstItem.add("10"); //size
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add("Level of Care Description"); //label
	secondItem.add("level_of_care_desc");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add("Dependency Code");  // label
	thirdItem.add("dependency_code");//name
	thirdItem.add("4"); //size
	thirdItem.add("4");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add("Dependency Description");  // label
	fourthItem.add("long_desc");//name
	fourthItem.add("30"); //size
	fourthItem.add("30");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = "Level of Care Code";
	orderByCols[1] = "Level of Care Description";
	orderByCols[2] = "Dependency Code";
	orderByCols[3] = "Dependency Description";

	orderByColVals[0] = "level_of_care_code";
	orderByColVals[1] = "level_of_care_desc";
	orderByColVals[2] = "dependency_code";
	orderByColVals[3] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Level of Care For Dependency", "../jsp/LevelOfCareForDependencyQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally 
	{
		if(con != null)
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

