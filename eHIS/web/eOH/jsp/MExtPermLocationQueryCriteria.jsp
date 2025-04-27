<!DOCTYPE html>
<!-- 
	Developer   : Muraleedhar
	Created On  : 01/10/21009
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
String extPermLoc_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ExternalPerformingLocationCode.Label","oh_labels");
String extPermLoc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ExternalPerformingLocationDesc.Label","oh_labels");

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
	firstItem.add(extPermLoc_code);     // label
	firstItem.add("ext_Loc_code");   //name of field
	firstItem.add("6"); // SIZE
	firstItem.add("6"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(extPermLoc_desc);    // label
	secondItem.add("ext_Loc_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");   //Type of item
	thirdItem.add(nature);  // label
	thirdItem.add("eff_status");//name
	thirdItem.add("B,"+both+",E,"+enabled+",D,"+disabled);;//static values that need to be displayed as 
	finAr.add(thirdItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = extPermLoc_code;
	orderByCols[1] = extPermLoc_desc;

	orderByColVals[0] = "ext_Loc_code";
	orderByColVals[1] = "ext_Loc_desc";

	strbuff = qrypg.getQueryPage( con,finAr,"MExtPermLocation" ,"../../eOH/jsp/MExtPermLocationQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
} 
catch (Exception e) {
}
finally{
	try{
		 ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>

