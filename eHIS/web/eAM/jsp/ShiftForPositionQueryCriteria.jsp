<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<% String sStyle =
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
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("List");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels"));	 // label
	firstItem.add("position_desc");	//name of field
	firstItem.add("Select position_code, position_desc from am_position where EFF_STATUS='E' order by position_desc");

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SHIFT.label","common_labels"));	  // label
	secondItem.add("shift_desc");	//name of field
	secondItem.add("Select shift_code, short_desc shift_desc from am_shift where eff_status = 'E' order by shift_desc");//

	finAr.add(secondItem);//add to ArrayList obj finAr

	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SHIFT.label","common_labels");
	

	orderByColVals[0] = "a.position_code";
	orderByColVals[1] = "b.short_desc";
	

	strbuff = qrypg.getQueryPage(con,finAr,"Shift For Position  ","../../eAM/jsp/ShiftForPositionQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	} 
	catch (Exception e) {
	e.printStackTrace();
	}
	finally   {
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
