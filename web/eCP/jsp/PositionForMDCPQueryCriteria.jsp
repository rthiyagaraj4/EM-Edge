<!DOCTYPE html>
<!-- Outcome.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	
*	Created On		:	27 Dec 2004

--%>
<html>
<head>
<script language="JavaScript" src="../../eCP/js/common.js"></script>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, oracle.jdbc.driver.*" %>

<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try{
con = ConnectionManager.getConnection(request);	


ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add("Facility Id");	// label
firstItem.add("facility_id");	//name of field
firstItem.add("4");			// SIZE
firstItem.add("2");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add("Facility Name");	 // label
secondItem.add("facility_name");	 //name of field
secondItem.add("25");			 // SIZE
secondItem.add("30");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");				//Type of item
thirdItem.add("Practitioner Type");	 // label
thirdItem.add("pract_type");	 //name of field
thirdItem.add("Select pract_type, desc_userdef pract_type_desc from am_pract_type where eff_status = 'E' order by pract_type_desc");			 // SIZE

finAr.add(thirdItem);			 //add to ArrayList obj finAr


ArrayList forthItem = new ArrayList();

forthItem.add("Text");   		 //Type of item
forthItem.add("Position Code");        // label
forthItem.add("position_code");   	 	 //name
forthItem.add("12");			 // SIZE
forthItem.add("10");			 //LENGTH
finAr.add(forthItem); 			 //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");  		 //Type of item
fifthItem.add("Position Description");  	 //label
fifthItem.add("position_desc");  	 //name
fifthItem.add("25");		         //SIZE 
fifthItem.add("30");  			 //LENGTH
finAr.add(fifthItem);			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = "Position Code";
orderByCols[1] = "Position Description";
orderByCols[2] = "Facility Id";
orderByCols[3] = "Facility Name";

orderByColVals[0] = "a.position_code";
orderByColVals[1] = "c.position_desc";
orderByColVals[2] = "a.facility_id";
orderByColVals[3] = "b.facility_name";



strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/PositionForMDCPQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
}catch(Exception e){
	//out.print(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
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

