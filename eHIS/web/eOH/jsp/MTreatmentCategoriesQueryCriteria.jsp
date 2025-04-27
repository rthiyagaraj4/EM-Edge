<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	: 10/05/07
	Modified On		: 07/06/07 
-->

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList,java.sql.PreparedStatement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String)session.getAttribute("LOCALE"); 

	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%
String sortOrder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"); 
String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DefaultSelect.Label","oh_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String trmt_category_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentCategoryCode.Label","oh_labels");
String trmt_category_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String splty_module_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SpecialityModuleId.Label","oh_labels");
String trmt_category_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentCategoryType.Label","oh_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
String sql = "SELECT DISTINCT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(trmt_category_code);     // label
	firstItem.add("trmt_category_code");   //name of field
	firstItem.add("20"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(trmt_category_desc);    // label
	secondItem.add("trmt_category_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");          //Type of item
	thirdItem.add(splty_module_id);    // label
	thirdItem.add("splty_module_id");  //name of field
	thirdItem.add("SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = 'SS' AND LANGUAGE_ID = '"+ locale +"' AND NVL(INSTALL_YN,'N')='Y'");
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");          //Type of item
	fourthItem.add(trmt_category_type);    // label
	fourthItem.add("trmt_category_type");  //name of field
    fourthItem.add(sql);
	finAr.add(fourthItem);    //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(nature);  // label
	fifthItem.add("eff_status");//name
	fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);;//static values that need to be displayed as 
	finAr.add(fifthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = trmt_category_code;
	orderByCols[1] = trmt_category_desc;
	orderByCols[2] = trmt_category_type;

	orderByColVals[0] = "trmt_category_code";
	orderByColVals[1] = "trmt_category_desc";
	orderByColVals[2] = "trmt_category_type";

	strbuff = qrypg.getQueryPage( con,finAr,"Treatment Categories" ,"../../eOH/jsp/MTreatmentCategoriesQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
} 
catch (Exception e) {}
finally{
	try{
		 ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>

