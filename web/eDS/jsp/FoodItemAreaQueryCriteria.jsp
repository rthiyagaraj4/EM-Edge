<!DOCTYPE html>
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
String facilityId=(String)session.getAttribute("facility_id");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String queryCriteria = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String kitchen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Kitchen.Label","ot_labels");
String kitchenArea =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.KitchenArea.Label","ot_labels");
String foodItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FoodItem.Label","ot_labels");
// Checkstyle Violation commented by Munisekhar
//String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
//String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

String sql_kitchen = "select kitchen.kitchen_Code code,kitchen.short_Desc sdesc from Ds_Kitchens_Lang_Vw kitchen where kitchen.operating_Facility_Id like '"+facilityId+"'and   kitchen.language_Id = '"+locale+"'and   kitchen.eff_Status ='E'";
String sql_kitchenArea = "select area.kitchen_Area_Code code,area.short_Desc sdesc from Ds_Kitchen_Area area where area.operating_Facility_Id like '"+facilityId+"'	and area.eff_Status ='E'";
String sql_foodItem = "select foodItem.food_Item_Code code,	foodItem.short_Desc sdesc from Ds_Food_Item_Lang_Vw foodItem where foodItem.language_Id like '"+locale+"'	and foodItem.eff_Status ='E'";
StringBuffer strBuff = new StringBuffer();

try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	
	firstItem.add("List");   //Type of item
	firstItem.add(kitchen);  // label
	firstItem.add("kitchen");//name
	
	pstmt = con.prepareStatement(sql_kitchen);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);//static values that need to be displayed as
	finAr.add(firstItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();

	ArrayList secondItem = new ArrayList();
	
	secondItem.add("List");   //Type of item
	secondItem.add(kitchenArea);  // label
	secondItem.add("kitchenArea");//name
	
	pstmt = con.prepareStatement(sql_kitchenArea);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str2);//static values that need to be displayed as
	finAr.add(secondItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
    if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
	ArrayList thirdItem = new ArrayList();
	
	thirdItem.add("List");   //Type of item
	thirdItem.add(foodItem);  // label
	thirdItem.add("foodItem");//name
	
	pstmt = con.prepareStatement(sql_foodItem);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str3);//static values that need to be displayed as
	finAr.add(thirdItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];
	
	orderByCols[0] = kitchen;
	orderByCols[1] = kitchenArea;
	orderByCols[2] = foodItem;
	
	orderByColVals[0] = "kitchen";
	orderByColVals[1] = "kitchen_Area";
	orderByColVals[2] = "food_Item";
	
	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/FoodItemForKitchenAreaQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	
}
catch (Exception e) {
	System.err.println("Exception is ->"+e);
}
finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

