<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
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
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
String priority =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels");

//String priority_code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(code);     // label
firstItem.add("priority_code");   //name of field
firstItem.add("2"); // SIZE
firstItem.add("2"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(description);    // label
secondItem.add("priority_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(nature);  // label
thirdItem.add("status");//name
thirdItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(thirdItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = priority+" "+code;
	orderByCols[1] = priority+" "+description;
	

	orderByColVals[0] = "priority_code";
	orderByColVals[1] = "priority_desc";
	

strbuff = qrypg.getQueryPage( con,finAr,"BookingPriority ","../../eOT/jsp/BookingPriorityQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

