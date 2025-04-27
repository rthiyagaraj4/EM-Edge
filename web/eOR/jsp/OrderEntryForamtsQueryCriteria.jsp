
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String orderCatValues = "";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String function_id = request.getParameter("function_id");
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

  HttpSession ss = request.getSession(false);
	eOR.OrderEntryFormatItem beanObjs = new eOR.OrderEntryFormatItem(); 
	beanObjs.setLanguageId(localeName);
	beanObjs.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
	try{
		orderCatValues = (String)beanObjs.listOrderCategory ();
	}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
//orderCatValues = " ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,*A,Non Specific," + orderCatValues;
orderCatValues = " ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + orderCatValues;


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
/*
firstItem.add("Text");   //Type of item
firstItem.add("Level");  // label
firstItem.add("level");//name
firstItem.add("10");
firstItem.add("20");
*/
firstItem.add("List");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Level.label","common_labels"));	  // label
firstItem.add("level");	//name of field
firstItem.add("%,  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"   ,H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Line.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("List");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
secondItem.add("order_category");//name
secondItem.add(orderCatValues);
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
thirdItem.add("order_type");//name
thirdItem.add("10");
thirdItem.add("20");
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
fourthItem.add("order_type_desc");//name
fourthItem.add("10");
fourthItem.add("20");
finAr.add(fourthItem); //add to ArrayList obj finAr



ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
fifthItem.add("order_catalog");//name
fifthItem.add("10");
fifthItem.add("20");
finAr.add(fifthItem); //add to ArrayList obj finAr



ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
sixthItem.add("order_catalog_desc");//name
sixthItem.add("10");
sixthItem.add("20");
finAr.add(sixthItem); //add to ArrayList obj finAr


ArrayList seventhItem = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels"));  // label
seventhItem.add("meaning");//name
seventhItem.add("%, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+" ,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(seventhItem); //add to ArrayList obj finAr



ArrayList ninethItem = new ArrayList();
ninethItem.add("Hidden");  //Type of item
ninethItem.add("function_id");  // name of field
ninethItem.add(function_id);   //value of field
finAr.add(ninethItem); //add to ArrayList obj finAr


String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");

orderByColVals[0] = "order_category";
orderByColVals[1] = "order_type";
orderByColVals[2] = "order_type_desc";
orderByColVals[3] = "order_catalog";
orderByColVals[4] = "order_catalog_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/OrderEntryFormatsQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	
}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

