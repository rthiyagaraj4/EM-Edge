<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %> 
<%@ page contentType="text/html;charset=UTF-8" %>
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
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String packs_code =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PackageCode.label","common_labels") ; 
String long_desc =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels") ;
String short_desc =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels") ;
String enabled =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels") ;
String both =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels") ;
String disable =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(packs_code);     // label
firstItem.add("package_code");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(long_desc);    // label
secondItem.add("long_description");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("40");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(short_desc);    // label
thirdItem.add("short_description");  //name of field
thirdItem.add("15");   // SIZE
thirdItem.add("15");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthtem = new ArrayList();

fourthtem.add("List");          //Type of item
fourthtem.add(enabled);    // label
fourthtem.add("enabled");  //name of field
fourthtem.add("B,"+both+",E,"+enabled+",D,"+disable);   // SIZE

finAr.add(fourthtem);    //add to ArrayList obj finAr



String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = packs_code;
	orderByCols[1] = long_desc;
	orderByCols[2] = short_desc;

	orderByColVals[0] = "package_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	

strbuff = qrypg.getQueryPage( con,finAr,"Swab And Instruments Template ","../../eOT/jsp/ConsumablePackQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
