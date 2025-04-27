<!DOCTYPE html>
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
String splty_module_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SpecialityModuleId.Label","oh_labels");
String trmt_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentProcedure.Label","oh_labels");
String trmt_category_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentCategoryCode.Label","oh_labels");
String order_catalog_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.OrderCatalogue.Label","oh_labels");
//String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
//String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
//String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
//String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("List");          //Type of item
	firstItem.add(splty_module_id);    // label
	firstItem.add("splty_module_id");  //name of field
	firstItem.add("SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE_LANG_VW WHERE MODULE_GROUP_ID = 'SS' AND LANGUAGE_ID = '"+ locale +"' AND NVL(INSTALL_YN,'N')='Y' ORDER BY 2");
	finAr.add(firstItem);    //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");          //Type of item
	secondItem.add(trmt_code);    // label
	secondItem.add("trmt_code");  //name of field
	secondItem.add("SELECT DISCR_MSR_ID, SHORT_DESC FROM AM_DISCR_MSR_LANG_VW WHERE LANGUAGE_ID = '"+ locale +"' AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 2");
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");          //Type of item
	thirdItem.add(trmt_category_code);    // label
	thirdItem.add("trmt_category_code");  //name of field
    thirdItem.add("SELECT DISTINCT TRMT_CATEGORY_CODE, SHORT_DESC FROM OH_TREATMENT_CATEGORY ORDER BY 2");
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");          //Type of item
	fourthItem.add(order_catalog_code);    // label
	fourthItem.add("order_catalog_code");  //name of field
	fourthItem.add("SELECT ORDER_CATALOG_CODE, SHORT_DESC FROM OR_ORDER_CATALOG_LANG_VW WHERE ORDER_CATEGORY = 'MI' AND LANGUAGE_ID = '"+ locale +"' AND NVL(EFF_STATUS,'E') = 'E'");
	finAr.add(fourthItem);    //add to ArrayList obj finAr

//	ArrayList sixth = new ArrayList();
//
//	sixth.add("List");   //Type of item
//	sixth.add(nature);  // label
//	sixth.add("eff_status");//name
//	sixth.add("B,"+both+",E,"+enabled+",D,"+disabled);;//static values that need to be displayed as 
//	finAr.add(sixth);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = trmt_code;
	orderByCols[1] = order_catalog_code;
	orderByCols[2] = trmt_category_code;

	orderByColVals[0] = "trmt_code";
	orderByColVals[1] = "order_catalog_code";
	orderByColVals[2] = "trmt_category_code";

	strbuff = qrypg.getQueryPage( con,finAr,"Speciality Treatments / Procedures" ,"../../eOH/jsp/MSpltyTreatmentProcQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
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

