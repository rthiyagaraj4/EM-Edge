<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String sortOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")	;
//String specialityDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");
//String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");	
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label" ,"common_labels");	
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label" ,"common_labels");
String both=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String subcategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SubCategory.Label","ot_labels");
String category =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels");
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
//String locationType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
//String noteType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");

Connection   con  =  ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("List");           //Type of item
firstItem.add(speciality);     // label
firstItem.add("oper_group_code"); 
firstItem.add("SELECT A.SPECIALITY_CODE OPER_GROUP_CODE,B.SHORT_DESC SPECIALITY_DESC  FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE ORDER BY 2"); 
finAr.add(firstItem);//add to ArrayList obj finAr
ArrayList secondItem = new ArrayList();
secondItem.add("List");          //Type of item
secondItem.add(category);    // label
secondItem.add("oper_cat_code");  //name of field
//secondItem.add("SELECT OPER_CAT_CODE OPER_CAT_CODE,LONG_DESC OPER_CAT_DESC  FROM OT_OPER_CATEGORY ");  
secondItem.add("SELECT OPER_CAT_CODE OPER_CAT_CODE,LONG_DESC OPER_CAT_DESC  FROM OT_OPER_CATEGORY_LANG_VW where LANGUAGE_ID = '"+locale+"'");   // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr
ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(subcategory);    // label
thirdItem.add("oper_sub_cat_code");  //name of field
thirdItem.add("4");   // SIZE
thirdItem.add("4");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("Text");
fourthItem.add(description);
fourthItem.add("long_desc");
fourthItem.add("30");
fourthItem.add("30");
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();
fifthItem.add("List");   //Type of item
fifthItem.add(nature);  // label
fifthItem.add("status");//name
fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled+"");//static values that need to be displayed as 
finAr.add(fifthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = speciality ;
	orderByCols[1] = category;
	orderByCols[2] = subcategory;
    orderByCols[3] = description;

	orderByColVals[0] = "short_desc";
	orderByColVals[1] = "a.long_desc";
	orderByColVals[2] = "oper_sub_cat_code";
	orderByColVals[3] = "long_desc";
String params=request.getQueryString();
try {
strbuff = qrypg.getQueryPage( con,finAr,speciality,"../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?"+params,sortOrder,QueryCriteria,select ,orderby,orderByCols, orderByColVals,executequery	);

strbuff = qrypg.getQueryPage( con,finAr,"OperationSubCategories" ,"../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?"+params,sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);
out.println(strbuff.toString());

} catch (Exception e){
	e.printStackTrace();
}

finally
{
	finAr.clear();firstItem.clear();	secondItem.clear();
	thirdItem.clear();	fourthItem.clear();fifthItem.clear();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

