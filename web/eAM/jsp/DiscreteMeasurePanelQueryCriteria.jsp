<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCA
*	Purpose 		:	Responsible for generating the query page for search functionality
*	Created By		:	Dheeraj Kumar M
*	Created On		:	23 July 2002
*	Modified On		:	22 Feb 2005
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%!	
	ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	ArrayList fourthItem;
%>

<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request);

	 finAr = new ArrayList();

	 firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PanelID.label","common_labels"));	  // label
		firstItem.add("DISCR_MSR_BATTERY_ID");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

	secondItem=new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PanelDescription.label","common_labels"));	  // label
		secondItem.add("DISCR_MSR_BATTERY_DESC");	//name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

	 thirdItem=new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Discrete.label","am_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MeasureID.label","am_labels"));	  // label
		thirdItem.add("DISCR_MSR_ID");	//name of field
		thirdItem.add("10");	// SIZE
		thirdItem.add("10");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

	fourthItem=new ArrayList();
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasureDescription.label","common_labels"));	  // label
		fourthItem.add("DISCR_MSR_DESC");	//name of field
		fourthItem.add("15");	// SIZE
		fourthItem.add("15");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr


String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PanelID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PanelDescription.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SerialNo.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Discrete.label","am_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MeasureID.label","am_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasureDescription.label","common_labels");

orderByColVals[0] = "DISCR_MSR_BATTERY_ID";
orderByColVals[1] = "DISCR_MSR_BATTERY_DESC";
orderByColVals[2] = "ORDER_SRL_NO";
orderByColVals[3] = "DISCR_MSR_ID";
orderByColVals[4] = "DISCR_MSR_DESC";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation", "../jsp/DiscreteMeasurePanelQueryCriteriaResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();

	ConnectionManager.returnConnection(con,request);
}
%>

