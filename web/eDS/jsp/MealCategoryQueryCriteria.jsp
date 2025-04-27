<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
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
String mealCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealCategory.Label","ot_labels") ;
//ML-MMOH-CRF-0406
String Attendent_Label_Name="";
String facility_id	= (String)session.getAttribute("facility_id");
//String DS_Param_Sql="select Attendent_Label_Name from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
//ML-MMOH-CRF-0406
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;//,pstmt1=null;//ML-MMOH-CRF-406
ResultSet rst = null;//,rs1=null;//ML-MMOH-CRF-406
StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("List");   //Type of item
	firstItem.add(mealCategory);  // label
	firstItem.add("meal_Category");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CATEGORY);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_category_code")+","+rst.getString("description"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);//static values that need to be displayed as
	finAr.add(firstItem);
	strBuff.setLength(0);
	

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");   //Type of item
	secondItem.add(dietType);  // label
	secondItem.add("diet_Type");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("diet_type")+","+rst.getString("short_desc"));
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
	//Checkstyle Violation commented by Munisekhar
	//String strChk = "";
	thirdItem.add("List");   //Type of item
	thirdItem.add(mealClass);  // label
	thirdItem.add("meal_Class");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_class")+","+rst.getString("short_desc"));
	}
   //Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str2);//static values that need to be displayed as
	//seventhItem.add("B,"+both+",E,"+"Yes"+",D,"+"No");
	finAr.add(thirdItem);
	strBuff.setLength(0);
	

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = mealCategory;
	orderByCols[1] = dietType;
	orderByCols[2] = mealClass;

	orderByColVals[0] = "meal_category_code";
	orderByColVals[1] = "default_diet_type";
	orderByColVals[2] = "default_meal_class";
	//ML-ML-MMOH-CRF-0406 STARTS
	//pstmt1 = con.prepareStatement(DS_Param_Sql);	
	/*rs1=pstmt1.executeQuery();
	if(rs1.next()){
		//Attendent_Label_Name=rs1.getString("Attendent_Label_Name");
		System.err.println("INSIDE Attendent_Label_Name:"+Attendent_Label_Name);
	}*/
	Attendent_Label_Name=DSCommonBeanObj.getAttendantLabel();
	//ML-MMOH-CRF-0406 ENDS
	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/MealCategoryQueryResult.jsp?ph_module_yn="+ph_module_yn+"&Attendent_Label_Name="+Attendent_Label_Name,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");//ML-MMOH-CRF-0406
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

