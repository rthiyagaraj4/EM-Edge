<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	to get the query criteria
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	18 jan 05
-->
<!-- <%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %> -->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
 request.setCharacterEncoding("UTF-8");
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");%>
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

con = ConnectionManager.getConnection(request);	
try
{

	String ReasonCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(ReasonCode);	 // label
firstItem.add("reason_code");	//name of field
firstItem.add("4");				//Size
firstItem.add("4");				//Length	
finAr.add(firstItem);			//add to ArrayList obj finAr


String Reason= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels");
ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(Reason);  // label
secondItem.add("reason_desc");//name
secondItem.add("20");//size
secondItem.add("30");//length
finAr.add(secondItem); //add to ArrayList obj finAr

String ApplicableTo= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels");
ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(ApplicableTo);  // label
thirdItem.add("activity_type_code");//name
thirdItem.add("select activity_type_code,activity_type_desc from rs_activity_type order by activity_type_desc");
finAr.add(thirdItem); //add to ArrayList obj finAr


String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");


String list_values="%,"+Both_legend+",E,"+Enable_legend+",D,"+Disable_legend;

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(Nature);  // label
fourthItem.add("eff_status");//name
fourthItem.add(list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

String[] orderByCols = new String[2];
String[] orderByColVals = new String[2];

orderByCols[0] = ReasonCode;
orderByCols[1] = Reason;

orderByColVals[0] = "a.reason_code";
orderByColVals[1] = "a.reason_desc";

String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");



strbuff = qrypg.getQueryPage(con,finAr,Reason,"../jsp/ReasonQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy ,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());
	} 
	catch (Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
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
