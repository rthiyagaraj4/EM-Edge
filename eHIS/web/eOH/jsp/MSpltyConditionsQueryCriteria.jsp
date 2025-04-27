<!DOCTYPE html>
<!--  
	Developer		: Sridevi Joshi
	Completed On	: 02/05/07
	Modified On		: 07/06/07 
 -->

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList,java.sql.PreparedStatement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

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
String condition_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ConditionCode.Label","oh_labels");
String condition_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String splty_module_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SpecialityModuleId.Label","oh_labels");
String condition_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ConditionType.Label","oh_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
String sql = "SELECT DISTINCT CONDITION_TYPE,CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("List");          //Type of item
	firstItem.add(splty_module_id);    // label
	firstItem.add("splty_module_id");  //name of field
	firstItem.add("SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE WHERE MODULE_GROUP_ID = 'SS' AND NVL(INSTALL_YN,'Y')='Y'");
	finAr.add(firstItem);    //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();		
	secondItem.add("Text");           //Type of item
	secondItem.add(condition_code);     // label
	secondItem.add("condition_code");   //name of field
	secondItem.add("20"); // SIZE
	secondItem.add("20"); //LENGTH
	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(condition_desc);    // label
	thirdItem.add("condition_desc");  //name of field
	thirdItem.add("30");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");          //Type of item
	fourthItem.add(condition_type);    // label
	fourthItem.add("condition_type");  //name of field
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

	orderByCols[0] = condition_code;
	orderByCols[1] = condition_desc;
	orderByCols[2] = condition_type;

	orderByColVals[0] = "condition_code";
	orderByColVals[1] = "condition_desc";
	orderByColVals[2] = "condition_type";

	strbuff = qrypg.getQueryPage( con,finAr,"Speciality Conditions" ,"../../eOH/jsp/MSpltyConditionsQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());
} 
catch (Exception e) {}
finally{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</html>

