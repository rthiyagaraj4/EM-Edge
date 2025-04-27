<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>
<%

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

/* Mandatory checks start */	
	String function_id	= request.getParameter("function_id") ;
	String bean_id		= "Or_order_status_code" ;
	String bean_name	= "eOR.OrderStatusCode";
/* Mandatory checks end */	

	/* Initialize Function specific start */
	OrderStatusCode bean = (OrderStatusCode)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	/* Initialize Function specific end */
try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusCode.label","or_labels"));  // label
firstItem.add("order_status_code");//name
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusDesc.label","or_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  	 //Type of item
String orderStatus = bean.getOrderStatusValues();
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusType.label","or_labels"));	  // label
thirdItem.add("order_status_type");	//name of field
thirdItem.add(" ,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+","+orderStatus);	// Include the values and description
thirdItem.add("30");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();
fourthItem.add("Hidden");  //Type of item
fourthItem.add("function_id");  // name of field
fourthItem.add(function_id);   //value of field
finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[]	= new String[3];
String orderByColVals[] = new String[3];

orderByCols[0]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusCode.label","or_labels");
orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusDesc.label","or_labels");
orderByCols[2]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderStatusType.label","or_labels");

orderByColVals[0] = "order_status_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "order_status_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/OrderStatusCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
putObjectInBean(bean_id,bean,request);
} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

