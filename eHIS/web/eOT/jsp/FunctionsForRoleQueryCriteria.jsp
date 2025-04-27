<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>


<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;

String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;

String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String role_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RoleID.Label","ot_labels") ;

String function_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FunctionID.Label","ot_labels") ;

String sequence_no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SequenceNo.label","common_labels") ;

String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

String functionsForRole =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FunctionsForRole.Label","ot_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(role_id);     // label
firstItem.add("role_id");   //name of field
firstItem.add("SELECT ROLE_ID, ROLE_DESC FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND NVL(APPL_TO_OT_SLATE,'N') = 'Y' ORDER BY 1"); // SIZE

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(function_id);    // label
secondItem.add("function_id");  //name of field
secondItem.add("2");   // SIZE
secondItem.add("2");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("function_desc_user");  //name of field
thirdItem.add("40");   // SIZE
thirdItem.add("40");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(sequence_no);    // label
fourthItem.add("srl_no");  //name of field
fourthItem.add("2");   // SIZE
fourthItem.add("2");   //LENGTH
finAr.add(fourthItem);    //add to ArrayList obj finAr


/*ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add("Select");  // label
fifthItem.add("sel");//name
fifthItem.add("B,Both,Y,Yes,N,No");

finAr.add(fifthItem);*/

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = role_id;
	orderByCols[1] = function_id;
	orderByCols[2] = description;
    orderByCols[3] = sequence_no;
    
	orderByColVals[0] = "role_id";
	orderByColVals[1] = "function_id";
	orderByColVals[2] = "function_desc_user";
	orderByColVals[3] = "srl_no";

strbuff = qrypg.getQueryPage( con,finAr,functionsForRole,"../../eOT/jsp/FunctionsForRoleQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
