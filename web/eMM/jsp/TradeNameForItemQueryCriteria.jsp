<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*"     contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

		 request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 
<%

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff = new StringBuffer();
String function_id = request.getParameter( "function_id" );

try
{
	ArrayList components = new ArrayList();
	ArrayList firstItem = new ArrayList();
	String Item_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
	firstItem.add("Text");
	firstItem.add(Item_Code);
	firstItem.add("item_code");
	firstItem.add("20");
	firstItem.add("20");
	components.add(firstItem);

	ArrayList secondItem=new ArrayList();
	String Item_Description = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
	secondItem.add("Text");
	secondItem.add(Item_Description);
	secondItem.add("long_desc");
	secondItem.add("60");
	secondItem.add("60");
	components.add(secondItem);

	ArrayList thirdItem = new ArrayList();
	String TradeID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeID.label","common_labels");
	thirdItem.add("Text");
	thirdItem.add(TradeID);
	thirdItem.add("trade_id");
	thirdItem.add("20");
	thirdItem.add("20");
	components.add(thirdItem);

	ArrayList fourthItem=new ArrayList();
	String TradeName = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels");
	fourthItem.add("Text");
	fourthItem.add(TradeName);
	fourthItem.add("long_name");
	fourthItem.add("40");
	fourthItem.add("40");
	components.add(fourthItem);

	ArrayList fivethItem=new ArrayList();
	fivethItem.add("Hidden");	// label
	fivethItem.add("function_id");   //name of field
	fivethItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

	components.add(fivethItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = Item_Code;
	orderByCols[1] = Item_Description;
	orderByCols[2] = TradeID;
	orderByCols[3] = TradeName;
	
	orderByColVals[0] = "item_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "trade_id";
	orderByColVals[3] = "long_name";
	
	String TradeNameforItem = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.TradeNameforItem.label","mm_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

	strbuff = qrypg.getQueryPage(null,components,TradeNameforItem, "TradeNameForItemQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
}
catch (java.lang.Exception e)
{
		// out.println(exception.toString());
		e.printStackTrace(); // COMMON-ICN-0184
}
%>
