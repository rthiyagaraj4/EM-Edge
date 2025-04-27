
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request); 

ArrayList finAr = new ArrayList();



ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
firstItem.add("order_category");//name
String temp=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1_ANOTHER");
temp=temp.replace("?","'"+localeName+"'");
firstItem.add(temp);
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
secondItem.add("order_type_code");//name
secondItem.add("15");
secondItem.add("15");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
thirdItem.add("order_type_desc");//name
thirdItem.add("15");
thirdItem.add("15");
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Format.label","common_labels"));  // label
fourthItem.add("format");//name
fourthItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---,YY,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByYear.label","or_labels")+",YJ,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByYearandJulianDate.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.prefix.label","mp_labels"));  // label
sixthItem.add("prefix");//name
sixthItem.add("15");
sixthItem.add("15");
finAr.add(sixthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.prefix.label","mp_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Format.label","common_labels");


orderByColVals[0] = "a.order_category";
orderByColVals[1] = "a.order_type_code";
orderByColVals[2] = "b.short_desc";
orderByColVals[3] = "a.access_num_prefix";
orderByColVals[4] = "a.access_num_format";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/AccessionNumberRulesQueryResults.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
// finAr.clear();
// firstItem.clear();
// secondItem.clear();
// thirdItem.clear();
// fourthItem.clear();
// sixthItem
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
	 e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

