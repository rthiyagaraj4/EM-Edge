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
<HEAD>


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
firstItem.add("Section");     // label
firstItem.add("sectionCode");  //name of field
firstItem.add("10");   // SIZE
firstItem.add("10");   //LENGTH
finAr.add(firstItem);    //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");          //Type of item
secondItem.add("Study Location");    // label
secondItem.add("studyLocation");  //name of field
secondItem.add("50");   // SIZE
secondItem.add("50");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");          //Type of item
thirdItem.add("Facility");    // label
thirdItem.add("facilityID");  //name of field
thirdItem.add("50");   // SIZE
thirdItem.add("50");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("Text");          //Type of item
fourthItem.add("Service");    // label
fourthItem.add("serviceNo");  //name of field
fourthItem.add("50");   // SIZE
fourthItem.add("50");   //LENGTH
finAr.add(fourthItem);    //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("Text");          //Type of item
fifthItem.add("Counter Name");    // label
fifthItem.add("counterName");  //name of field
fifthItem.add("50");   // SIZE
fifthItem.add("50");   //LENGTH
finAr.add(fifthItem);    //add to ArrayList obj finAr

String[] orderByCols = null;
String[] orderByColVals = null;

orderByCols = new String[2];
orderByColVals = new String[2];

orderByCols[0] = "Section";
orderByCols[1] = "Study Location";

orderByColVals[0] = "1";
orderByColVals[1] = "2";

strbuff = qrypg.getQueryPage(con, finAr, "NotificationRecipient", 
	"../../servlet/eXH.QMSRDCounterSetupServlet?requestType=QUERY",
	"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels") + "",
	"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels") + "",
	"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels") + "",
	"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels") + "",
	orderByCols, 
	orderByColVals,
	"" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels") + "");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();

finAr.clear();
} catch (Exception e) {}

finally
{
   if(con != null) ConnectionManager.returnConnection(con, request);
}
%>
</HTML>
