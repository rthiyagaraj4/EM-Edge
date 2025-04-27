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
String facility_id  = (String) session.getValue("facility_id");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String dietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietType.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String kitchenCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.KitchenCode.Label","ot_labels") ;
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String mealType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealType.Label","common_labels");
String dayNo =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DayNo.Label","common_labels");
String menu =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Menu.Label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
/*Added Against Start ML-MOH-CRF-1006-US6*/
String patientClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String emergency =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
String inpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
String Outpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
String Staff =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Staff.label","common_labels");
/*Added Against End ML-MOH-CRF-1006-US6*/
StringBuffer strbuff;
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;
StringBuffer strBuff = new StringBuffer();
try{
   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();	
	/* Added Against Start ML-MOH-CRF-1006-US6 */
	ArrayList PatClassItem = new ArrayList();
	PatClassItem.add("List");
	PatClassItem.add(patientClass);
	PatClassItem.add("patient_class");
	PatClassItem.add("All,"+all+",EM,"+emergency+",IP,"+inpatient+",OP,"+Outpatient+",ST,"+Staff);
	finAr.add(PatClassItem);
	/* Added Against End ML-MOH-CRF-1006-US6 */
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");
	firstItem.add(kitchenCode);
	firstItem.add("kitchen_Code");
	pstmt = con.prepareStatement(DlQuery.DL_GET_KITCHEN_CODE);
	pstmt.setString(1, locale);
	pstmt.setString(2, facility_id);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("kitchen_code")+","+rst.getString("long_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);
	finAr.add(firstItem);
	strBuff.setLength(0);
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("List");
	secondItem.add(dietType);
	secondItem.add("diet_Type");
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("diet_type")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str2);
	finAr.add(secondItem);
	strBuff.setLength(0);

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");
	thirdItem.add(mealClass);
	thirdItem.add("meal_Class");
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_class")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str3);//static values that need to be displayed as
	finAr.add(thirdItem);
	strBuff.setLength(0);
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(mealType);  // label
	fourthItem.add("meal_Type");//name
	
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_TYPE);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_type")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str4 = "";
	str4 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str4);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");
	fifthItem.add(dayNo);
	fifthItem.add("day_No");
	fifthItem.add("5");
	fifthItem.add("5");
	finAr.add(fifthItem);

	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");
	sixthItem.add(menu);
	sixthItem.add("menu_code");
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_MENU_FOR_QUERY_CRITERIA);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		// Fix for IN034544
		strBuff.append(","+rst.getString("menu_code")+","+(rst.getString("short_desc").replace(',', ' ')));
		// IN034544 Fix ends
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str5 = "";
	str5 =  strBuff.substring(1, strBuff.length());
	sixthItem.add(str5);
	finAr.add(sixthItem);
	strBuff.setLength(0);

	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");   //Type of item
	seventhItem.add(nature);  // label
	seventhItem.add("enable");//name
	seventhItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(seventhItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[8];
	orderByColVals = new String[8];

	orderByCols[0] = patientClass;
	orderByCols[1] = kitchenCode;
	orderByCols[2] = dietType;
	orderByCols[3] = mealClass;
    orderByCols[4] = mealType;
    orderByCols[5] = dayNo;
    orderByCols[6] = menu;
    orderByCols[7] = nature;

	orderByColVals[0] = "patient_class";
	orderByColVals[1] = "kitchen_code";
	orderByColVals[2] = "diet_type";
	orderByColVals[3] = "meal_class";
	orderByColVals[4] = "meal_type";
	orderByColVals[5] = "day_no";
	orderByColVals[6] = "menu_code";
	orderByColVals[7] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/MenuTimeTableQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
}catch(Exception e){
	System.err.println("Exception in MenuTimeTableQueryCriteria.jsp--->"+e);
	e.printStackTrace();
}finally{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

