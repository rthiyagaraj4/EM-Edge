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
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, oracle.jdbc.driver.*" %>

<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try {
con = ConnectionManager.getConnection(request);





ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("List");  		//Type of item
firstItem.add("Dependency");	// label
firstItem.add("dependency_code");	//name of field
firstItem.add("Select dependency_code,long_desc from cp_dependency where eff_status='E' order by long_desc");	
finAr.add(firstItem);			//add to ArrayList obj finAr
//out.println(finAr);
ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add("Workplace Code");	 // label
secondItem.add("workplace_code");	 //name of field
secondItem.add("10");			 // SIZE
secondItem.add("10");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add("Workplace Description");        // label
thirdItem.add("workplace_desc");   	 	 //name
thirdItem.add("30");			 // SIZE
thirdItem.add("30");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("List");  		//Type of item
fourthItem.add("Shift");	// label
fourthItem.add("shift_code");	//name of field
fourthItem.add("select  shift_code,long_desc from am_shift");
finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   		 //Type of item
fifthItem.add("Position Code");        // label
fifthItem.add("position_code");   	 	 //name
fifthItem.add("10");			 // SIZE
fifthItem.add("10");			 //LENGTH
finAr.add(fifthItem); 			 //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   		 //Type of item
sixthItem.add("Position Description");        // label
sixthItem.add("position_desc");   	 	 //name
sixthItem.add("30");			 // SIZE
sixthItem.add("30");			 //LENGTH
finAr.add(sixthItem); 			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = "Dependency";
orderByCols[1] = "Workplace Code";
orderByCols[2] = "Workplace description";
orderByCols[3] = "Shift";
orderByCols[4] = "Position Code";
orderByCols[5] = "Position Description";

orderByColVals[0] = "dependency_code";
orderByColVals[1] = "workplace_code";
orderByColVals[2] = "worplplace_desc";
orderByColVals[3] = "shift_code";
orderByColVals[4] = "position_code";
orderByColVals[5] = "position_desc";



strbuff = qrypg.getQueryPage(con,finAr,"FindStaffRequirement","../jsp/StaffRequirementQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(con!=null)
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
