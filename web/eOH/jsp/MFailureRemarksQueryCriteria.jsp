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
String reason_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ReasonCode.Label","oh_labels");
//String trmt_category_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentCategoryType.Label","oh_labels");
String reason_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ReasonDescription.Label","oh_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
//String sql = "SELECT DISTINCT TRMT_CATEGORY_TYPE, TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
			
	firstItem.add("Text");           //Type of item
	firstItem.add(reason_code);     // label
	firstItem.add("reason_code");   //name of field
	firstItem.add("5"); // SIZE
	firstItem.add("5"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	/*secondItem.add("List");          //Type of item
	secondItem.add(trmt_category_type);    // label
	secondItem.add("trmt_category_type");  //name of field
    secondItem.add(sql);
	finAr.add(secondItem);    //add to ArrayList obj finAr
	*/

	secondItem.add("Text");           //Type of item
	secondItem.add(reason_desc);     // label
	secondItem.add("reason_desc");   //name of field
	secondItem.add("20"); // SIZE
	secondItem.add("200"); //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = reason_code;
	orderByCols[1] = reason_desc;

	orderByColVals[0] = "A.REASON_CODE";
	orderByColVals[1] = "A.REASON_DESC";

	strbuff = qrypg.getQueryPage( con,finAr,"reason" ,"../../eOH/jsp/MFailureRemarksQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
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

