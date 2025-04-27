<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eOT/js/OrderTypesForSpeciality.js'></script>
<%@ page import ="java.util.ArrayList,webbeans.eCommon.ConnectionManager,java.sql.Connection"%>
<%
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
//Modified by rajesh on 27/12 as instructed by vishwa 
//Removed description text box and make role type by list item.
//String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")	;
String orderType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")	;


ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {
con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("List");//Type of item
firstItem.add(speciality);// label
firstItem.add("speciality_code");//name of field
firstItem.add("SELECT A.SPECIALITY_CODE, A.LONG_DESC FROM AM_SPECIALITY A, OT_SPECIALITIES B WHERE NVL(A.EFF_STATUS,'E') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2");// SIZE
finAr.add(firstItem);//add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();
secondItem.add("List");          //Type of item
secondItem.add(orderType);    // label
secondItem.add("order_type_code");  //name of field
secondItem.add("SELECT A.ORDER_TYPE_CODE, B.SHORT_DESC FROM OT_SPECIALITY_ORDER_TYPES A, OR_ORDER_TYPE_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.ORDER_TYPE_CODE=B.ORDER_TYPE_CODE  ");   // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr

/*
ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("order_type_desc");  //name of field
thirdItem.add("30");   // SIZE
thirdItem.add("30");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

*/
String[] orderByCols=null;
String[] orderByColVals=null;
orderByCols = new String[2];
orderByColVals = new String[3];
orderByCols[0] = speciality;
orderByCols[1] = orderType;
//orderByCols[2] = description;
//orderByCols[3] = "Select";
    
orderByColVals[0] = "speciality_code";
orderByColVals[1] = "order_type_code";
orderByColVals[2] = "c.short_desc";
//orderByColVals[3] = "sel";
    
	
	

strbuff = qrypg.getQueryPage( con,finAr,"OrderTypesForSpeciality ","../../eOT/jsp/OrderTypesForSpecialityQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

