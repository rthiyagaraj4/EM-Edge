<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	: 07/06/07
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
String composition_class_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.CompositionClass.Label","oh_labels");
String composition_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String composition_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.CompositionCode.Label","oh_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String anaesthesia=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthesia.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
String sql = "SELECT DISTINCT COMPOSITION_CLASS_CODE, COMPOSITION_CLASS_DESC FROM OH_COMPOSITION_CLASS_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(composition_code);     // label
	firstItem.add("composition_code");   //name of field
	firstItem.add("6"); // SIZE
	firstItem.add("6"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(composition_desc);    // label
	secondItem.add("composition_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");          //Type of item
	thirdItem.add(composition_class_code);    // label
	thirdItem.add("composition_class_code");  //name of field
    thirdItem.add(sql);
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(nature);  // label
	fourthItem.add("eff_status");//name
	fourthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);;//static values that need to be displayed as 
	finAr.add(fourthItem);

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(anaesthesia);  // label
	fifthItem.add("anesthesia_yn");//name
	fifthItem.add("B,"+all+",Y,"+yes+",N,"+no);;//static values that need to be displayed as 
	finAr.add(fifthItem);


	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = composition_code;
	orderByCols[1] = composition_desc;
	orderByCols[2] = composition_class_code;

	orderByColVals[0] = "composition_code";
	orderByColVals[1] = "composition_desc";
	orderByColVals[2] = "composition_class_code";

	strbuff = qrypg.getQueryPage( con,finAr,"Procedure Composition" ,"../../eOH/jsp/MProcCompositionQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

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

