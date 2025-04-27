<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String code	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String setComponents	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SetComponents.Label","ot_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(code);     // label
firstItem.add("instr_code");   //name of field
firstItem.add("25"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(description);    // label
secondItem.add("description");  //name of field
secondItem.add("65");   // SIZE
secondItem.add("50");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = code;
	orderByCols[1] = description;
	

	orderByColVals[0] = "instr_code";
	orderByColVals[1] = "long_desc";
	

strbuff = qrypg.getQueryPage( con,finAr,setComponents,"../../eOT/jsp/SetComponentsQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

