<!DOCTYPE html>
<HTML>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {

con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");          //Type of item
firstItem.add("Interface Domain");    // label
firstItem.add("module_id");  //name of field
firstItem.add("10");   // SIZE
firstItem.add("10");   //LENGTH
finAr.add(firstItem);    //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add("Description");    // label
secondItem.add("module_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add("Sub Domain");    // label
thirdItem.add("sub_module_id");  //name of field
thirdItem.add("10");   // SIZE
thirdItem.add("10");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Hidden");   //Type of item
fourthItem.add("locale");  // label
fourthItem.add(locale);//name
fourthItem.add(locale);//static values that need to be displayed as 
finAr.add(fourthItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = "Interface Domain";
	orderByCols[1] = "Description";
	orderByCols[2] = "Sub Domain";
		
	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	
strbuff = qrypg.getQueryPage( con,finAr,"InterfaceModule","../../eXH/jsp/InterfaceModuleQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();
} catch (Exception e) {}

finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
