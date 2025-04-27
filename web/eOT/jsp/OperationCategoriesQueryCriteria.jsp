<!DOCTYPE html>
 <%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection,java.util.ArrayList, webbeans.eCommon.ConnectionManager" %>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
//String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
//String orderType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")	;
//String specialityCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels");
//String category =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels");
String category1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels");

//String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
//String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
//String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
//String specialityDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");
//String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LongDesc.label","or_labels");
//String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("List");           //Type of item
firstItem.add(speciality);     // label
firstItem.add("oper_group_code"); 
firstItem.add("SELECT A.SPECIALITY_CODE OPER_GROUP_CODE,B.SHORT_DESC SPECIALITY_DESC  FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE ORDER BY 2"); 
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(category1);    // label
secondItem.add("oper_cat_code");  //name of field
secondItem.add("4");   // SIZE
secondItem.add("4");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("long_desc");  //name of field
thirdItem.add("30");   // SIZE
thirdItem.add("30");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("List");   //Type of item
fourthItem.add(nature);  // label
fourthItem.add("status");//name
fourthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(fourthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = speciality;
	orderByCols[1] = category1;
	orderByCols[2] = description;

	orderByColVals[0] = "oper_group_code";
	orderByColVals[1] = "oper_cat_code";
	orderByColVals[2] = "long_desc";


strbuff = qrypg.getQueryPage( con,finAr,speciality ,"../../eOT/jsp/OperationCategoriesQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

