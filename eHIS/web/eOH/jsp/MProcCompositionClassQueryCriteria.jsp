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
String composition_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(composition_class_code);     // label
	firstItem.add("composition_class_code");   //name of field
	firstItem.add("6"); // SIZE
	firstItem.add("6"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(composition_class_desc);    // label
	secondItem.add("composition_class_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(nature);  // label
	fourthItem.add("eff_status");//name
	fourthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);;//static values that need to be displayed as 
	finAr.add(fourthItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = composition_class_code;
	orderByCols[1] = composition_class_desc;

	orderByColVals[0] = "composition_class_code";
	orderByColVals[1] = "composition_class_desc";

	strbuff = qrypg.getQueryPage( con,finAr,"Procedure Composition Class" ,"../../eOH/jsp/MProcCompositionClassQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
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

