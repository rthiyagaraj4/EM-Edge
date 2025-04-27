<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*  File Name		:	ShiftPatternForWorkplaceQueryCriteria.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	20-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
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
	String function_id = request.getParameter("function_id");
	Connection con=null ;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Locn_Data		= new ArrayList() ;

	String[] record				= null;
	//String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="Select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	try {
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
	 String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
	 String defaultSelect= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("List");  		 //Type of item
		firstItem.add(locationtype);	  // label
		firstItem.add("locn_type");	//name of field
		String strList = " "+","+defaultSelect+",";
		for(int k=0;k<Locn_Data.size();k++)	{
			record=(String[])Locn_Data.get(k);
			strList = strList + (String)record[0] + ","+(String)record[1]+",";
		}
		firstItem.add(strList);
		firstItem.add("10"); //size
		finAr.add(firstItem); //add to ArrayList obj finAr

String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");   //Type of item
		secondItem.add(WorkplaceCode); //label
		secondItem.add("workplace_code");//name
		secondItem.add("15"); //size
		secondItem.add("10");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");
	
		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");   //Type of item
		thirdItem.add(WorkplaceDescription);  // label
		thirdItem.add("workplace_desc");//name
		thirdItem.add("25"); //size
		thirdItem.add("30");  //maxlength
		finAr.add(thirdItem); //add to ArrayList obj finAr

String ShiftPatternID= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftPatternID.label","rs_labels");
		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");   //Type of item
		fourthItem.add(ShiftPatternID);  // label
		fourthItem.add("shift_pattern_id");//name
		fourthItem.add("15"); //size
		fourthItem.add("10");  //maxlength
		finAr.add(fourthItem); //add to ArrayList obj finAr

	String ShiftPatternDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftPatternDescription.label","rs_labels");
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");   //Type of item
		fifthItem.add(ShiftPatternDescription);  // label
		fifthItem.add("short_desc");//name
		fifthItem.add("20"); //size
		fifthItem.add("15");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = locationtype;
		orderByCols[1] = WorkplaceCode;
		orderByCols[2] = WorkplaceDescription;
		orderByCols[3] = ShiftPatternID;
		orderByCols[4] = ShiftPatternDescription;

		orderByColVals[0] = "b.locn_type";
		orderByColVals[1] = "a.workplace_code";
		orderByColVals[2] = "c.workplace_desc";
		orderByColVals[3] = "a.shift_pattern_id";
		orderByColVals[4] = "d.short_desc";



		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

//		defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String FindShiftPatternForWorkplace=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindShiftPatternForWorkplace.label","rs_labels");




		strbuff = qrypg.getQueryPage(con,finAr,FindShiftPatternForWorkplace, "../jsp/ShiftPatternForWorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	} 
	catch ( Exception e ){
		e.printStackTrace() ;
		throw e;
	} finally {
		resultSet.close() ;
		pstmt.close() ;
		ConnectionManager.returnConnection(con,request);
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
