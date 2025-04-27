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
String dietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietType.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String dayNo =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DayNo.Label","common_labels");
String menuSchdCycle =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Menu.Label","common_labels");
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

	firstItem.add("List");
	firstItem.add(dietType);
	firstItem.add("diet_Type");
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("diet_type")+","+rst.getString("short_desc"));
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
	secondItem.add(mealClass);
	secondItem.add("meal_Class");
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_class")+","+rst.getString("short_desc"));
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

	thirdItem.add("Text");
	thirdItem.add(dayNo);
	thirdItem.add("day_No");
	thirdItem.add("5");
	thirdItem.add("5");
	finAr.add(thirdItem);

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");
	fourthItem.add(menuSchdCycle);
	fourthItem.add("menu_Schd_Cycle");
	fourthItem.add("5");
	fourthItem.add("5");
	finAr.add(fourthItem);

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(nature);  // label
	fifthItem.add("enable");//name
	fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(fifthItem);
	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] = dietType;
	orderByCols[1] = mealClass;
	orderByCols[2] = dayNo;
    orderByCols[3] = menuSchdCycle;
    orderByCols[4] = nature;


	orderByColVals[0] = "diet_type";
	orderByColVals[1] = "meal_class";
	orderByColVals[2] = "meal_plan_ref_day_no";
	orderByColVals[3] = "menu_sched_cycle_days";
	orderByColVals[4] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/MenuCycleQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
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

