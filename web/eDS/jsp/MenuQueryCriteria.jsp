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
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String menu =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Menu.Label","ot_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels");
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String dietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietType.Label","ot_labels") ;
String mealType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealType.Label","ot_labels");
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
/*Added Against Start ML-MOH-CRF-1006-US5*/
String patientClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String emergency =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
String inpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
String Outpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
String Staff =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Staff.label","common_labels");
/*Added Against End ML-MOH-CRF-1006-US5*/
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");
	firstItem.add(menu);
	firstItem.add("menu");
	firstItem.add("5");
	firstItem.add("5");
	finAr.add(firstItem);

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");
	secondItem.add(longDesc);
	secondItem.add("long_Desc");
	secondItem.add("30");
	secondItem.add("30");
	finAr.add(secondItem);

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");
	thirdItem.add(shortDesc);
	thirdItem.add("short_Desc");
	thirdItem.add("15");
	thirdItem.add("15");
	finAr.add(thirdItem);

	/* Added Against Start ML-MOH-CRF-1006-US5 */
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");
	fourthItem.add(patientClass);
	fourthItem.add("patient_class");
	fourthItem.add("All,"+all+",EM,"+emergency+",IP,"+inpatient+",OP,"+Outpatient+",ST,"+Staff);
	finAr.add(fourthItem);
	/* Added Against End ML-MOH-CRF-1006-US5 */

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");
	fifthItem.add(dietType);
	fifthItem.add("diet_Type");
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
	fifthItem.add(str2);
	finAr.add(fifthItem);
	strBuff.setLength(0);


	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");
	sixthItem.add(mealClass);
	sixthItem.add("meal_Class");
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
	sixthItem.add(str3);//static values that need to be displayed as
	finAr.add(sixthItem);
	strBuff.setLength(0);
	
	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");
	seventhItem.add(mealType);
	seventhItem.add("meal_Type");
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
	seventhItem.add(str4);//static values that need to be displayed as
	finAr.add(seventhItem);
	strBuff.setLength(0);
	ArrayList eighthItem = new ArrayList();

	eighthItem.add("List");   //Type of item
	eighthItem.add(nature);  // label
	eighthItem.add("enable");//name
	eighthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(eighthItem);


	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[8];
	orderByColVals = new String[8];

	orderByCols[0] = menu;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
	orderByCols[3] = patientClass;
	orderByCols[4] = dietType;
	orderByCols[5] = mealClass;
	orderByCols[6] = mealType;
	orderByCols[7] = nature;



	orderByColVals[0] = "menu_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "patient_class";
	orderByColVals[4] = "diet_type";
	orderByColVals[5] = "meal_type";
	orderByColVals[6] = "meal_class";
	orderByColVals[7] = "eff_status";


	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/MenuQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
}catch(Exception e){
	System.err.println("Exception in MenuQueryCriteria.jsp ->"+e);
	e.printStackTrace();
}finally{ 
   if(rst !=null) rst.close();
   if(pstmt !=null) pstmt.close();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

