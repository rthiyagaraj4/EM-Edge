<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String sortorder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels") ;
String status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels") ;
String function_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FunctionID.Label","ot_labels") ;
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels") ;
Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(status);     // label
firstItem.add("status_code");   //name of field

//firstItem.add("SELECT STATUS_CODE ,STATUS_DESC FROM OT_STATUS ORDER BY status_desc"); // SIZE

firstItem.add("SELECT STATUS_CODE ,STATUS_DESC FROM OT_STATUS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY status_desc"); // SIZE


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

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = status;
	orderByCols[1] = function_id;
	orderByCols[2] = description;
   // orderByCols[3] = "Select";
    
	orderByColVals[0] = "status_code";
	orderByColVals[1] = "function_id";
	orderByColVals[2] = "function_desc_user";
	//orderByColVals[3] = "sel";
    
	
	

strbuff = qrypg.getQueryPage( con,finAr,"Functions ","../../eOT/jsp/FunctionsForStatusQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executeQuery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

