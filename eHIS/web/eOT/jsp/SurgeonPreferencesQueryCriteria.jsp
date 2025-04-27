<!DOCTYPE html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

                   

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null ;
	String facility_id =(String) session.getAttribute("facility_id"); 
try {
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String function_id = request.getParameter("function_id") ;
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String surgeon =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String applicability	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicability.label","common_labels");
String categoryCode	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CategoryCode.label","common_labels");
String subCategoryCode	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SubCategory.Label","ot_labels");
subCategoryCode =subCategoryCode +" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String subCategorydesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SubCategory.Label","ot_labels");
subCategorydesc =subCategorydesc +" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String categoryDescription	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CategoryDescription.label","common_labels");
String code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String operationCode	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationCode.Label","ot_labels");
String operationDescription	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDescription.Label","ot_labels");
String surgeonpreferences	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeonPreferences.Label","ot_labels");
String all	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String allOperations	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllOperations.label","common_labels");
String specificSpeciality	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecificSpecialty.label","common_labels");
String specificOperation	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecificOperation.label","common_labels");
String specificoperationcategorywithinspeciality	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificOperationCategoryWithinSpeciality.Label","ot_labels");
String specificoperationsubcategorywithinspeciality	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificOperationSubCategoryWithinSpeciality.Label","ot_labels");

StringBuffer strbuff;

con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

firstItem.add("List");           //Type of item
firstItem.add(applicability);     // label
firstItem.add("applicability");   //name of field
//firstItem.add("ALL,"+all+",AOPR,"+allOperations+",SSPL,"+specificSpeciality+",SCAT,"+specificOperationCategoryWithinSpeciality+","+specificOperationSubCategoryWithinSpeciality+",SOPR,"+specificOperation); // SIZE

firstItem.add("ALL,"+all+",AOPR,"+allOperations+",SSPL,"+specificSpeciality+",SCAT,"+specificoperationcategorywithinspeciality+",SSUB,"+specificoperationsubcategorywithinspeciality+",SOPR,"+specificOperation); // SIZE
finAr.add(firstItem);   //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");           //Type of item
secondItem.add(surgeon);     // label
secondItem.add("surgeon_code");   //name of field
secondItem.add("SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE  WHERE ROLE_TYPE ='OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER('%') AND UPPER(PRACTITIONER_ID) LIKE UPPER('%') ORDER BY 1"); // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("List");           //Type of item
thirdItem.add(speciality);     // label
thirdItem.add("speciality_code");   //name of field
thirdItem.add("SELECT B.SPECIALITY_CODE CODE, A.LONG_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE NVL(EFF_STATUS,'X') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE"); // SIZE
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList  fourthItem= new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(categoryCode);    // label
fourthItem.add("oper_cat_code");  //name of field
fourthItem.add("4");   // SIZE
fourthItem.add("4");   //LENGTH
finAr.add(fourthItem);    //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");          //Type of item
fifthItem.add(categoryDescription);    // label
fifthItem.add("oper_cat_desc");  //name of field
fifthItem.add("30");   // SIZE
fifthItem.add("30");   //LENGTH
finAr.add(fifthItem);    //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");          //Type of item
//sixthItem.add(code);    // label
sixthItem.add(subCategoryCode);    // label
sixthItem.add("oper_sub_cat_code");  //name of field
sixthItem.add("4");   // SIZE
sixthItem.add("4");   //LENGTH
finAr.add(sixthItem);    //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();

seventhItem.add("Text");          //Type of item
//seventhItem.add(operationCode);    // label
seventhItem.add(subCategorydesc);    // label
seventhItem.add("oper_sub_cat_desc");  //name of field
seventhItem.add("30");   // SIZE
seventhItem.add("30");   //LENGTH
finAr.add(seventhItem);    //add to ArrayList obj finAr

ArrayList eightItem = new ArrayList();

eightItem.add("Text");          //Type of item
eightItem.add(operationCode);    // label
eightItem.add("oper_code");  //name of field
eightItem.add("10");   // SIZE
eightItem.add("10");   //LENGTH
finAr.add(eightItem);    //add to ArrayList obj finAr

ArrayList ninethItem = new ArrayList();

ninethItem.add("Text");          //Type of item
ninethItem.add(operationDescription);    // label
ninethItem.add("oper_desc");  //name of field
//ninethItem.add("30");   // SIZE Commented  against MMS-QH-CRF-0199 UserStory 4
//ninethItem.add("30");   //LENGTH Commented against MMS-QH-CRF-0199 UserStory 4
ninethItem.add("60");   // SIZE Added  against MMS-QH-CRF-0199 UserStory 4
ninethItem.add("60");   //LENGTH Added against MMS-QH-CRF-0199 UserStory 4
finAr.add(ninethItem);    //add to ArrayList obj finAr
String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[9];
	orderByColVals = new String[9];



	orderByCols[0] = applicability;
	orderByCols[1] = surgeon;
	orderByCols[2] = speciality;
	orderByCols[3] = categoryCode;
	orderByCols[4] = categoryDescription;
	orderByCols[5] = subCategoryCode;
	orderByCols[6] = description;
	orderByCols[7] = operationCode;
	orderByCols[8] = operationDescription;

	orderByColVals[0] = "applicability";
	orderByColVals[1] = "team_doctor_code";
	orderByColVals[2] = "speciality_desc";
	orderByColVals[3] = "oper_cat_code";
	orderByColVals[4] = "oper_cat_desc";
	orderByColVals[5] = "oper_sub_cat_code";
	orderByColVals[6] = "oper_sub_cat_desc";
	orderByColVals[7] = "oper_code";
	orderByColVals[8] = "oper_desc";

/*	orderByColVals[0] = "A.APPLICABILITY";
	orderByColVals[1] = "B.SHORT_DESC";
	orderByColVals[2] = "A.OPER_CAT_CODE";
	orderByColVals[3] = "C.LONG_DESC";
	orderByColVals[4] = "A.OPER_SUB_CAT_CODE";
	orderByColVals[5] = "D.LONG_DESC";
	orderByColVals[6] = "A.OPER_CODE";
	orderByColVals[7] = "E.SHORT_DESC";*/

	strbuff = qrypg.getQueryPage( con,finAr,surgeonpreferences,"../../eOT/jsp/SurgeonPreferencesQueryResult.jsp?function_id="+function_id,sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
	out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>	
</body>

