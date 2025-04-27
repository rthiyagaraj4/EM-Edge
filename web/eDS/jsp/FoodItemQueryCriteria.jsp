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
String foodItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FoodItemCode.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String itemType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemType.Label","ot_labels");
String servingUom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ServingUOM.Label","ot_labels");
String preparationFactor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationFactor.Label","ot_labels");
String calorieContent =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CalorieContentUOM.Label","ot_labels");
String preparationUom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationUOM.Label","ot_labels");
String baseQty =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationBaseQty.Label","ot_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(foodItem);     // label
	firstItem.add("food_Item");   //name of field
	firstItem.add("20"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("long_Desc");  //name of field
	secondItem.add("60");   // SIZE
	secondItem.add("60");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("short_Desc");  //name of field
	thirdItem.add("30");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(itemType);  // label
	fourthItem.add("item_Type");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_ITEM_TYPE);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("item_type")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str1);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(servingUom);  // label
	fifthItem.add("serving_Uom");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	fifthItem.add(str2);//static values that need to be displayed as
	finAr.add(fifthItem);
	strBuff.setLength(0);
	
	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(preparationUom);  // label
	sixthItem.add("preparation_Uom");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	sixthItem.add(str3);//static values that need to be displayed as
	finAr.add(sixthItem);
	strBuff.setLength(0);
	ArrayList seventhItem = new ArrayList();

	seventhItem.add("Text");          //Type of item
	seventhItem.add(preparationFactor);    // label
	seventhItem.add("preparation_Factor");  //name of field
	seventhItem.add("10");   // SIZE
	seventhItem.add("10");   //LENGTH
	finAr.add(seventhItem);    //add to ArrayList obj finAr

	ArrayList eightItem = new ArrayList();

	eightItem.add("Text");          //Type of item
	eightItem.add(baseQty);    // label
	eightItem.add("base_Qty");  //name of field
	eightItem.add("10");   // SIZE
	eightItem.add("10");   //LENGTH
	finAr.add(eightItem);    //add to ArrayList obj finAr


	ArrayList ninthItem = new ArrayList();

	ninthItem.add("Text");          //Type of item
	ninthItem.add(calorieContent);    // label
	ninthItem.add("calorie_Content");  //name of field
	ninthItem.add("10");   // SIZE
	ninthItem.add("10");   //LENGTH
	finAr.add(ninthItem);    //add to ArrayList obj finAr


	ArrayList tenththItem = new ArrayList();

	tenththItem.add("List");   //Type of item
	tenththItem.add(nature);  // label
	tenththItem.add("enable");//name
	tenththItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(tenththItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[10];
	orderByColVals = new String[10];

	orderByCols[1] = calorieContent;
	orderByCols[2] = nature;
	orderByCols[3] = itemType;
    orderByCols[4] = longDesc;
    orderByCols[5] = baseQty;
    orderByCols[6] = preparationFactor;
    orderByCols[7] = preparationUom;
    orderByCols[8] = servingUom;
    orderByCols[9] = shortDesc;
    orderByCols[0] = foodItem;

	orderByColVals[0] = "food_item_code";
	orderByColVals[1] = "calorific_cont_per_uom";
	orderByColVals[2] = "eff_status";
	orderByColVals[3] = "item_type";
	orderByColVals[4] = "long_desc";
	orderByColVals[5] = "prep_base_qty";
	orderByColVals[6] = "prep_factor";
	orderByColVals[7] = "prep_uom";
	orderByColVals[8] = "serving_uom_code";
	orderByColVals[9] = "short_desc";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/FoodItemQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{    //Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

