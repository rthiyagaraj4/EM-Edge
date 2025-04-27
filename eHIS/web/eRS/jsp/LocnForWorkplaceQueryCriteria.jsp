<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	10 Jan 2005

--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	Connection con=null ;
    try
	{
	con = ConnectionManager.getConnection(request);


	String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(WorkplaceCode);	  // label
	firstItem.add("workplace_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr

	String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(WorkplaceDescription); //label
	secondItem.add("workplace_desc");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
	String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
	

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");  //Type of item
	thirdItem.add(locationtype);  // name of field
	thirdItem.add("location_type");   //value of field
	thirdItem.add("select  locn_type,long_desc from am_care_locn_type");
	finAr.add(thirdItem); //add to ArrayList obj finAr
	
	String locationcode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	
	
	
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   //Type of item
	fourthItem.add(locationcode); //label
	fourthItem.add("location_code");//name
	fourthItem.add("10"); //size
	fourthItem.add("10");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr


	String LocationDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");   //Type of item
	fifthItem.add(LocationDescription); //label
	fifthItem.add("location_desc");//name
	fifthItem.add("30"); //size
	fifthItem.add("30");  //maxlength
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] 	= new String[5];
	String orderByColVals[] = new String[5];

	orderByCols[0] = WorkplaceCode;
	orderByCols[1] = WorkplaceDescription;
	orderByCols[2] = locationtype;
	orderByCols[3] = locationcode;
	orderByCols[4] = LocationDescription;

	orderByColVals[0] = "a.workplace_code";
	orderByColVals[1] = "b.workplace_desc";
	orderByColVals[2] = "a.locn_type";
	orderByColVals[3] = "a.locn_code";
	orderByColVals[4] = "c.long_desc";



	String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	strbuff = qrypg.getQueryPage(con,finAr,"FindLocationWorkplace","../jsp/LocnForWorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
finally
{
	try
	{
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
}
%>
<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
