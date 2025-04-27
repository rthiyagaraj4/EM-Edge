<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@  page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%
String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String dietCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietCategoryCode.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Description.Label","ot_labels") ;
String orderType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OrderType.Label","ot_labels") ;

StringBuffer strbuff;
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");
	firstItem.add(dietCategory);
	firstItem.add("diet_Category");
	firstItem.add("4");
	firstItem.add("4");
	finAr.add(firstItem);

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("long_Desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(orderType);    // label
	thirdItem.add("order_Type");  //name of field
	thirdItem.add("4");   // SIZE
	thirdItem.add("4");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr


	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = dietCategory;
	orderByCols[1] = longDesc;
	orderByCols[2] = orderType;

	orderByColVals[0] = "diet_category_code";
	orderByColVals[1] = "description";
	orderByColVals[2] = "order_type_code";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/DietCategoryQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
  //Checkstyle Correction added by Munisekhar
   if(rst !=null) rst.close();
   if(pstmt !=null) pstmt.close();
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

