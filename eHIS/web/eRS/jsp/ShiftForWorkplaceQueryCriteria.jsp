<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
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

try {
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
	secondItem.add("20"); //size
	secondItem.add("30");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	String ShiftCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftCode.label","rs_labels");
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(ShiftCode);  // label
	thirdItem.add("shift_code");//name
	thirdItem.add("5");
	thirdItem.add("4");
	finAr.add(thirdItem); //add to ArrayList obj finAr

String ShiftDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftDescription.label","rs_labels");
	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(ShiftDescription);  // label
	fourthItem.add("shift_desc");//name
	fourthItem.add("20"); //size
	fourthItem.add("30");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Hidden");  //Type of item
	fifthItem.add("function_id");  // name of field
	fifthItem.add(function_id);   //value of field
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = WorkplaceCode;
	orderByCols[1] = WorkplaceDescription;
	orderByCols[2] = ShiftCode;
	orderByCols[3] = ShiftDescription;

	orderByColVals[0] = "workplace_code";
	orderByColVals[1] = "workplace_desc";
	orderByColVals[2] = "shift_code";
	orderByColVals[3] = "shift_desc";





	String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String FindSkillForPosition=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindSkillForPosition.label","rs_labels");

	strbuff = qrypg.getQueryPage(con,finAr,FindSkillForPosition,"../jsp/ShiftForWorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
} catch (Exception e) {
	out.println(e.toString());
}
finally{
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
