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
String foodItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FoodItem.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String ingredients =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Ingredients.Label","ot_labels") ;
String uom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Uom.Label","ot_labels");
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("List");
	firstItem.add(foodItem);
	firstItem.add("food_Item");
	pstmt = con.prepareStatement(DlQuery.DL_DS_FOOD_ITEM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("food_item_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str2);
	finAr.add(firstItem);
	strBuff.setLength(0);
	ArrayList secondItem = new ArrayList();

	secondItem.add("List");
	secondItem.add(ingredients);
	secondItem.add("ingredient_Code");
	pstmt = con.prepareStatement(DlQuery.DL_DS_INGREDIENT);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("ingredient_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str3);//static values that need to be displayed as
	finAr.add(secondItem);
	strBuff.setLength(0);
	
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");
	thirdItem.add(uom);
	thirdItem.add("uom_Code");
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str4 = "";
	str4 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str4);//static values that need to be displayed as
	finAr.add(thirdItem);
	strBuff.setLength(0);
	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = foodItem;
	orderByCols[1] = ingredients;
	orderByCols[2] = uom;


	orderByColVals[0] = "food_item_code";
	orderByColVals[1] = "ingredient_code";
	orderByColVals[2] = "ingredient_uom";


	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/RecipeQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{   
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

