<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	29 Oct 04
-->

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

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
	//String sql_locn="select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	try {

		con = ConnectionManager.getConnection(request);




		ArrayList finAr = new ArrayList();

		pstmt = con.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
	
String ShiftPatternID= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftPatternID.label","rs_labels");

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(ShiftPatternID);	  // label
	firstItem.add("shift_pattern_id");	//name of field
	firstItem.add("15"); //size
	firstItem.add("10"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr
	

String shortdescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");


	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(shortdescription); //label
	secondItem.add("short_desc");//name
	secondItem.add("20"); //size
	secondItem.add("15");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
String all= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(locationtype);  // label
	thirdItem.add("locn_type");//name
	//String strList = " "+","+"----All----"+",";
	String strList = " "+","+all+",";
	for(int k=0;k<Locn_Data.size();k++)	{
		record=(String[])Locn_Data.get(k);
		strList = strList + (String)record[0] + ","+(String)record[1]+",";
	}
	thirdItem.add(strList);

	thirdItem.add("5"); //size
	finAr.add(thirdItem); //add to ArrayList obj finAr

		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(Nature);// label
	fourthItem.add("eff_status");//name
	fourthItem.add(list_values);//static values that need to be displayed as option.
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Hidden");  //Type of item
	fifthItem.add("function_id");  // name of field
	fifthItem.add(function_id);   //value of field
	finAr.add(fifthItem); //add to ArrayList obj finAr


String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String FindShiftPattern=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindShiftPattern.label","RS_labels");





	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];
	orderByCols[0] = ShiftPatternID;
	//orderByCols[1] = "Shift Pattern Description";
	orderByCols[1] = shortdescription;
	orderByCols[2] = locationtype;
	orderByColVals[0] = "shift_pattern_id";
	orderByColVals[1] = "short_desc";
	orderByColVals[2] = "a.locn_type";

	strbuff = qrypg.getQueryPage(con,finAr,FindShiftPattern,"../jsp/ShiftPatternQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());

	} catch (Exception e) {
		out.println(e.toString());
	}	finally{
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
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
