<!DOCTYPE html>
<!-- 
	Developer   : Sridevi Joshi
	Created On  : 04/06/07
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
String composition_class_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.CompositionClassCode.Label","oh_labels");
String composition_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String trmt_category_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentCategoryType.Label","oh_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
String sql = "SELECT DISTINCT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
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

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");          //Type of item
	thirdItem.add(trmt_category_type);    // label
	thirdItem.add("trmt_category_type");  //name of field
    thirdItem.add(sql);
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = composition_class_code;
	orderByCols[1] = composition_class_desc;
	orderByCols[2] = trmt_category_type;

	orderByColVals[0] = "A.COMPOSITION_CLASS_CODE";
	orderByColVals[1] = "B.COMPOSITION_CLASS_DESC";
	orderByColVals[2] = "A.TRMT_CATEGORY_TYPE";

	strbuff = qrypg.getQueryPage( con,finAr,"composition" ,"../../eOH/jsp/MTrmtCatTypeForCompositionClassQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
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

